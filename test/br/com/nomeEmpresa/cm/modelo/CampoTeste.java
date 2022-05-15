package br.com.nomeEmpresa.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.nomeEmpresa.cm.excecao.ExplosaoException;
import br.com.nomeEmpresa.cm.modelo.Campo;

public class CampoTeste {

	private Campo campo;

	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testVizinhoRealDistanciaEsquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}

	@Test
	void testVizinhoDistanciaDireita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}

	@Test
	void testVizinhoDistanciaEmCima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}

	@Test
	void testVizinhoDistanciaEmBaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}

	@Test
	void testVizinhoRealDistanciaDiagonal() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}

	@Test
	void testNaoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);

	}

	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacaoDuassChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());

	}

	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();

		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();

		});
	}

	@Test
	void testeAbrirComVizinhos() {

		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 1);
		campo12.minar();

		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);

		campo.adicionarVizinho(campo22);
		campo.abrir();

		assertTrue(campo22.isAberto() && campo11.isFechado());

	}

	@Test
	void testeLinhaEColuna() {
		Campo campo66 = new Campo(6, 6);
		campo66.getLinha();
		campo66.getColuna();

	}

	@Test
	void testeObjetivoAlcancado1() {
		Campo c1 = new Campo(3, 3);
		c1.abrir();
		c1.isAberto();
		assertTrue(c1.objetivoAlcancado());
	}

	@Test
	void testeObjeticoAlvancado2() {
		Campo c2 = new Campo(3, 3);
		c2.minar();
		c2.alternarMarcacao();

		assertTrue(c2.objetivoAlcancado());

	}

	@Test
	void minasNaVizinhanca() {
		Campo campo13 = new Campo(1, 1);
		Campo campo14 = new Campo(1, 1);
		campo13.minar();

		Campo campo24 = new Campo(2, 2);
		campo24.adicionarVizinho(campo13);
		campo24.adicionarVizinho(campo14);

		campo.adicionarVizinho(campo24);
		campo.abrir();
		campo.minasNaVizinhanca();

		assertTrue(campo24.isAberto());
	}

	@Test
	void reiniciar() {
		Campo campo25 = new Campo(2, 2);
		campo25.abrir();
		campo25.minar();
		campo25.alternarMarcacao();
		campo25.reiniciar();

		assertFalse(campo25.isAberto());
	}

}

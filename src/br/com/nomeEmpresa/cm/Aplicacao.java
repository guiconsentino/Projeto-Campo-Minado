package br.com.nomeEmpresa.cm;

import br.com.nomeEmpresa.cm.modelo.Tabuleiro;
import br.com.nomeEmpresa.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		new TabuleiroConsole(tabuleiro);
		
	}
}

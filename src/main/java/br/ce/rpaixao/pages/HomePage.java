package br.ce.rpaixao.pages;

import br.ce.rpaixao.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
		
	}

}

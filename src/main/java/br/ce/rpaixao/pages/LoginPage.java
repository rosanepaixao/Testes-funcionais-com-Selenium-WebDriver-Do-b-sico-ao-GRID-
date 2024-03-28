package br.ce.rpaixao.pages;

import br.ce.rpaixao.core.BasePage;
import br.ce.rpaixao.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
		
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}
	
	public void resetar() {
		clicarLink("reset");
	}


}

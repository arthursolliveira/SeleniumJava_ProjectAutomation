package br.so.soliveira.pages;

import Package.core.DriverFactory;
import br.so.soliveira.core.BasePage;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
	DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/");
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
}

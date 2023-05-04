package br.so.soliveira.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.so.soliveira.core.DriverFactory;
import br.so.soliveira.pages.LoginPage;
import br.so.soliveira.tests.ContaTest;
import br.so.soliveira.tests.MovimentacaoTest;
import br.so.soliveira.tests.RemoverMovimentacaoContaTest;
import br.so.soliveira.tests.ResumoTest;
import br.so.soliveira.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("qateste01@teste.com");
		page.setSenha("Teste123");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}

package br.so.soliveira.tests;

import org.junit.Assert;
import org.junit.Test;

import br.so.soliveira.core.BaseTest;
import br.so.soliveira.core.Propriedades;
import br.so.soliveira.pages.ContasPage;
import br.so.soliveira.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	 
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelalistarConta();
		
		contasPage.cliarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemContaExistente());

	}
}

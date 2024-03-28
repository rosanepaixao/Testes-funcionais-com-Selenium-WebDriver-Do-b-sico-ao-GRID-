package br.ce.rpaixao.tests;

import org.junit.Test;
import org.junit.Assert;
import br.ce.rpaixao.core.BaseTest;
import br.ce.rpaixao.pages.ContasPage;
import br.ce.rpaixao.pages.MenuPage;


public class ContaTest extends BaseTest {
	 
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test 
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta para alterar");
		
		contasPage.setNome("Conta alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void testInserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
		
	}
}

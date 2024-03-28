package br.ce.rpaixao.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.ce.rpaixao.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import br.ce.rpaixao.core.BaseTest;
import br.ce.rpaixao.core.DriverFactory;
import br.ce.rpaixao.pages.MenuPage;
import br.ce.rpaixao.pages.ResumoPage;


public class ResumoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1ExcluirMovimentacao(){
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!",
				resumoPage.obterMensagemSucesso());
	}
	//@Test(expected=NoSuchElementException.class)
	
	@Test
	public void testResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		//DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
	//	try {
		//DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		//Assert.fail();
		
	//	}catch (NoSuchElementException e) {
		
		//}
		
		resumoPage.selecionarAno("2016");
		resumoPage.buscar();
		
		List<WebElement> elementosEncontrados = 
				DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
		
	}
	}



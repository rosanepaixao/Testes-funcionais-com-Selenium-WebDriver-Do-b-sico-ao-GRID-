package br.ce.rpaixao.core;

import static br.ce.rpaixao.core.DriverFactory.getDriver;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.rpaixao.pages.LoginPage;

public class BaseTest {
	
	
	@Rule
	public TestName testName = new TestName();
	
    private LoginPage page = new LoginPage();
	
	@Before
	public void inicializa() {
		
		page.acessarTelaInicial();
	
		page.setEmail("wagner@costa");
		page.setSenha("123456");
		page.entrar();
	}
	
	@After
	public void finaliza() throws Exception{
		TakesScreenshot ss = (TakesScreenshot)getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target"+File.separator +"screenshort/"+
			File.separator + testName.getMethodName()+".jpg"));
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
	
   }
	}
}


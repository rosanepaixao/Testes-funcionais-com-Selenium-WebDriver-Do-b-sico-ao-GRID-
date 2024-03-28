package br.ce.rpaixao.core;


//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URL;

//import org.junit.runner.Describable;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;

//import br.ce.rpaixao.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	//private static WebDriver driver;
	private static ThreadLocal<WebDriver>threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized  WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory(){}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
		
	}
	
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
			switch (Propriedades.browsers) {
		    case FIREFOX:driver = new FirefoxDriver();break;
			case CHROME: driver = new ChromeDriver(); break;
		}
			driver.manage().window().setSize(new Dimension(1200,765));
		return driver;
		}
	
	
	
	// Refatorando o Testes para usar o Selenium GRID
//	public static WebDriver initDriver() {
//		WebDriver driver = null;
//		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
//			switch (Propriedades.BROWER) {
//		    case FIREFOX:driver = new FirefoxDriver();break;
//			case CHROME: driver = new ChromeDriver(); break;
//		}
		
//			}
//		if(Propriedades.TIPO_EXECUCAO== TipoExecucao.GRID) {
//			DesiredCapabilities cap = null;
			
//			switch (Propriedades.BROWER) {
//			case FIREFOX: cap = DesiredCapabilities.firefox();break;
//			case CHROME:cap = DesiredCapabilities.chrome();break;
//			}
//			try {
//			driver = new RemoteWebDriver( new URL("http://192.168.15.20:4444/wd/hub"), cap);
//		}catch (MalformedURLException e) {
//			System.err.println("Falha na conexão com o GRID");
//		e.printStackTrace();
//		}
//		}
//			driver.manage().window().setSize(new Dimension(1200,765));
//		return driver;
//	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
		    driver = null;
	}
	if(threadDriver != null) {
		threadDriver.remove();
	}
		
	}
}


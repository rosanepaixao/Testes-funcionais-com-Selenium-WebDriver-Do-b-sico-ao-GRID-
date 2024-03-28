package br.ce.rpaixao.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.rpaixao.core.DriverFactory;
import br.ce.rpaixao.pages.LoginPage;
import br.ce.rpaixao.tests.ContaTest;
import br.ce.rpaixao.tests.MovimentacaoTest;
import br.ce.rpaixao.tests.RemoverMovimentacaoContaTest;
import br.ce.rpaixao.tests.ResumoTest;
import br.ce.rpaixao.tests.SaldoTest;

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
	public static void reset() {
		page.acessarTelaInicial();
		
		page.setEmail("wagner@costa");
		page.setSenha("123456");
		page.entrar();
		
	   page.resetar();
	   
	   DriverFactory.killDriver();
	}
}

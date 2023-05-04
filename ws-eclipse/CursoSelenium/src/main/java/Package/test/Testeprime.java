package Package.test;
import static Package.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Package.core.DSL;
import Package.core.DriverFactory;

public class Testeprime {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=1efa5");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt344:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt344:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt344:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=f6cc5");
		dsl.selecionarComboPrime("j_idt343:console", "Option3");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt343:console_label"));
	}
}

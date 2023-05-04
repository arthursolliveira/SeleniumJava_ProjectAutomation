package Package.test;
import static Package.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Package.core.DSL;
import Package.core.DriverFactory;


public class TesteAlert {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void deveInteragirComAlertSimples(){
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Alert Simples", texto);
		
		dsl.escrever("elementosForm:nome", texto);
	}
	
	//@Test
	//public void deveInteragirComConfirm(){
		//dsl.clicarBotao("confirm");
		//Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		//Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());

		//dsl.clicarBotao("confirm");
		//Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		//Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
	//}
	
	@Test
	public void deveInteragirComPrompt(){
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
	}
	
}

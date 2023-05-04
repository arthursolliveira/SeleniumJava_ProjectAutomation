package Package.test;
import static Package.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Package.core.BaseTest;
import Package.core.DSL;
import Package.core.DriverFactory;

public class TesteRegraDeNegocio extends BaseTest {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@Test
	public void campoNomeObrigatorio(){
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void campoSobreNomeObrigatorio() {
		dsl.escrever("elementosForm:nome", "Arthur");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void campoGeneroObrigatorio(){
		dsl.escrever("elementosForm:nome", "Arthur");
		dsl.escrever("elementosForm:sobrenome", "Silva");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void alertComidaFavorita(){
		dsl.escrever("elementosForm:nome", "Arthur");
		dsl.escrever("elementosForm:sobrenome", "Silva");
		dsl.clicarRadio("elementosForm:sexo:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void alertEsportSelecionados(){
		dsl.escrever("elementosForm:nome", "Arthur");
		dsl.escrever("elementosForm:sobrenome", "Silva");
		dsl.clicarRadio("elementosForm:sexo:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
}


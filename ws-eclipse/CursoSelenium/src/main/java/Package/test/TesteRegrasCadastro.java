package Package.test;
import static Package.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import Package.core.BaseTest;
import Package.core.DSL;


@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest {
	
	private DSL dsl;
	 
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@Parameters 
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Arthur", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Arthur", "Silva", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Arthur", "Silva", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Arthur", "Silva", "Masculino", Arrays.asList("Carne"), new String[]{"Natacao", "O que eh esporte?"}, "Voce faz esporte ou nao?"},

		});
	}
	
	@Test
	public void deveValidarRegras(){
		dsl.escrever("elementosForm:nome", nome);
		dsl.escrever("elementosForm:sobrenome", sobrenome);
		if(sexo.equals("Masculino")) {
			dsl.clicarRadio("elementosForm:sexo:0");
		} 
		if(sexo.equals("Feminino")) {
			dsl.clicarRadio("elementosForm:sexo:1");
		}
		if(comidas.contains("Carne")) dsl.clicarRadio("elementosForm:comidaFavorita:0");
		if(comidas.contains("Pizza")) dsl.clicarRadio("elementosForm:comidaFavorita:2");
		if(comidas.contains("vegetariano")) dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.selecionarCombo("elementosForm:esportes", "valor");		
		dsl.clicarBotao("elementosForm:cadastrar");
		
		System.out.println(msg);
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}
}


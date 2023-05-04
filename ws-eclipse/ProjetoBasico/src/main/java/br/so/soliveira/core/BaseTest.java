package br.so.soliveira.core;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

import Package.core.DriverFactory;

public class BaseTest {
		
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza(){
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
	}

}

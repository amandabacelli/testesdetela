package com.br.inmetrics.tests.php;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.santander.frm.base.TestBase;
import br.com.santander.frm.controllers.WebController;
import br.com.santander.frm.testng.DataTableConfig;
import br.com.santander.frm.testng.TestConfig;


import static br.com.santander.frm.bdd.Gherkin.executeScenario_;
import static br.com.santander.frm.helpers.PropertyHelper.setProperty;

//o @ é uma notação do Java, tipo uma otimização de código, eu peço oque quero e 
//ele configura tudo sozinho dentro doque pedi, sem precisar escrever tudo
@TestConfig(controllerType      = WebController.class,  //configurar o controller
			dtFilePropertyAlias ="env.dt.filename.testePHP") //configurar a fonte de dados que será utilizada

public class TestCadastro extends TestBase {
	
	@DataTableConfig(ct = 2)
	@Test(groups = {"grupos" }, priority = 1, testName = "CT1 - ") //"grupos" eh nome da tag do teste
	public void CT1_CadastroPHPTravel() {
		
		try { //blloco try, chamar vários métodos e pode gerar excessões 
			executeScenario_("Cadastro novo usuario", "Novo usuario");//(Feature, nome do Scenario)
		} catch (Exception e) { //vai tratar a excessão criada e caso de erro vai mostrar o erro
			Assert.fail("Test Error", e);
		}
		
	}
	@BeforeMethod(alwaysRun = true)
	public void setup(final Method method, final ITestContext context) {
		
		super.setup(method, context);
	}
	@AfterMethod(alwaysRun = true)
	public void teardown(final Method method, final ITestContext context, ITestResult testResult){
		super.teardown(method, context, testResult);
	}
	}

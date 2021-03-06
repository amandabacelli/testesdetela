package com.br.inmetrics.phpSuppliers.Testes;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import br.com.santander.frm.base.TestBase;
import br.com.santander.frm.controllers.WebController;
import br.com.santander.frm.testng.DataTableConfig;
import br.com.santander.frm.testng.TestConfig;
import java.lang.reflect.Method;

import static br.com.santander.frm.bdd.Gherkin.executeScenario_;

@Test
@TestConfig(controllerType = WebController.class, dtFilePropertyAlias = "env.dt.filename.phpSuppliers")

public class LoginTest extends TestBase {

	@DataTableConfig(ct = 2)
	@Test(groups = { "Login" }, priority = 1, testName = "CT2 -Login admin ")

	public void login_admin() {
		try {
			executeScenario_("Login", "Login_admin");

		}

		catch (Exception e) {
			Assert.fail("Deu Ruim", e);
		}

	}

	
	@BeforeMethod(alwaysRun = true)
	public void setup(final Method method, final ITestContext context) {
		super.setup(method, context);
	}

	@AfterMethod(alwaysRun = true)
	public void teardown(final Method method, final ITestContext context, ITestResult testResult) {
		super.teardown(method, context, testResult);
	}
}

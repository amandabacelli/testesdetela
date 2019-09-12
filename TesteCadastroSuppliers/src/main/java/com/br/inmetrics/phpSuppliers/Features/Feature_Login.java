package com.br.inmetrics.phpSuppliers.Features;

import static br.com.santander.frm.bdd.Gherkin.given_;
import java.util.concurrent.ExecutionException;
import br.com.santander.frm.bdd.Scenario;
import cucumber.api.java.BeforeStep;
import br.com.santander.frm.bdd.Feature;

@SuppressWarnings("static-access")
@Feature("Login")

public class Feature_Login {

	@Scenario("Login_admin")
	public void loginAdmin() throws ExecutionException {
		given_("Estiver na pagina de login")
		.when_("inserir os dados de login")
		.then_("entao estarei logado")
		.execute_();
	}

}

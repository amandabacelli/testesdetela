package com.br.inmetrics.phpSuppliers.Features;

import static br.com.santander.frm.bdd.Gherkin.given_;
import java.util.concurrent.ExecutionException;
import br.com.santander.frm.bdd.Scenario;
import cucumber.api.java.BeforeStep;
import br.com.santander.frm.bdd.Feature;

@SuppressWarnings("static-access")
@Feature("Cadastro Suppliers")

public class Feature_phpSuppliers_Cadastro {


	@Scenario("Cadastro_supplier")
	public void novaSupplier() throws ExecutionException {
		given_("Estiver na pagina de login")
		.when_("inserir os dados de login")
		.and_("Inserir os dados de uma nova Supplier")
//		given_("Estando logado como ADMIN")
		.then_("entao terei uma supplier cadastrada")
		.execute_();
	}

	@Scenario("Deletar Suppliers")
	public void deletarSuplliers() throws ExecutionException {
		given_("Dado que a supplier esteja criada").when_("Selecionar a supplier desejada")
				.then_("A supllier sera excluida").execute_();
	}
	


}

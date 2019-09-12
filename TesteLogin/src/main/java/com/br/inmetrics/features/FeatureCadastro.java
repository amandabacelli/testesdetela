package com.br.inmetrics.features;
//importar as bibliotecas que vou utilizar nos testes
import static br.com.santander.frm.bdd.Gherkin.given_;
import java.util.concurrent.ExecutionException;

import br.com.santander.frm.bdd.Feature;
import br.com.santander.frm.bdd.Scenario;
import br.com.santander.frm.bdd.Tags;

//descrever a feature
@Feature("Cadastro novo usuario") //descrição da feature
//o public class tem que ter o mesmo nome do arquivo java da feature
public class FeatureCadastro {
	
	@SuppressWarnings("static-access")
	@Tags ({"Cadastro"}) //atribuo uma tag para quando solicitar para rodar os testes eu chamo uma tag e todo cenário constante naquela tag será testado
	@Scenario("Novo usuario")
	public void novo_usuario () throws ExecutionException { //criar uma função sem retorno
		given_("Estando na página de Sing Up")
		.when_("Inserir os dados 'First_Name', 'Last_Name', 'Mobile_Number', 'Email', 'Password' e 'Confirm_Password'")
		.then_("O usuário será criado")
		.execute_();
	}
 	
}

	
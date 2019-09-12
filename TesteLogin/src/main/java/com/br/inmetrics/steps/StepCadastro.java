package com.br.inmetrics.steps; //tem que ser um package 

import br.com.santander.frm.bdd.DesignSteps;
import br.com.santander.frm.bdd.Step;
import com.br.inmetrics.pages.PageCadastro;//importar os dados da pageobjects
import static br.com.santander.frm.base.DefaultBaseController.getPage_;//comando para instanciar a page
import static br.com.santander.frm.helpers.DataTableHelper.getDt_; //nescessário para puxar os dados da massa (tabela excel)

import org.apache.http.util.Args;

import br.com.santander.frm.helpers.LoggerHelper; //necessário para tirar print

@DesignSteps
public class StepCadastro {
	//classe STEP vai inserir os os locais exatos de onde os valores de execução dos métodos que foram definidos na Page, serão retirados
	
PageCadastro  pageCadastro =getPage_(PageCadastro.class); //instanciei o objeto pageCadastro dentro da classe PageCadastro pegando os dados da Page
LoggerHelper  logger = new LoggerHelper(PageCadastro.class);//instanciei o objeto logger dentro da classe LoggerHelper para tirar SS
//aqui nao uso o getPage pq nao eh uma pagina o LoggerHelper, mas um comando do framework  que vai utilizar as informações da classe PageCadastro

		
	//----------------------------------given
	@Step("Estando na página de Sing Up")
	public void Estando_na_página_de_Sing_Up () throws Exception{
		pageCadastro.abrir_sitecadastro(); //pagecadastro é o objeto o ponto significa que quero algo que está neste objeto; depois do ponto é o método que eu quero
		pageCadastro.validar_pagina();
		logger.info("Tela Cadastro", true);//tirar print da tela de cadastro
		
	}
		
		//----------------------------------when
	@Step("Inserir os dados 'First_Name', 'Last_Name', 'Mobile_Number', 'Email', 'Password' e 'Confirm_Password'")
	public void Inserir_dados () throws Exception {
		pageCadastro.sendKeysfirstname(getDt_().getStringOf("FirstName"));//comando getDT é do framework para pegar o dado da tabela determinada
																		  //determinada do project.properties
																		  //getStringOf é para pegar o dado da coluna "FirstName" na tabela 
																		  //determinada do project.properties
		pageCadastro.sendKeyslastname(getDt_().getStringOf("LastName"));
		pageCadastro.sendKeysmobilenumber(getDt_().getStringOf("MobileNumber"));
		pageCadastro.sendKeysEmail(getDt_().getStringOf("Email"));
		pageCadastro.sendKeysPassword(getDt_().getStringOf("Password"));
		pageCadastro.sendKeysConfirmPassword(getDt_().getStringOf("ConfirmPasword"));
		pageCadastro.clicar_singup();
		logger.info("Dados Preenchidos", true); //tirar ss dos dados preenchidos
		
		// reoorganizacao do codigo
		/*pageCadastro.preencher_cadastro(getDt_().getStringOf("FirstName"),
										getDt_().getStringOf("LastName"),
										getDt_().getStringOf("MobileNumber"),
										getDt_().getStringOf("Email"),
										getDt_().getStringOf("Password"),
										getDt_().getStringOf("Password"),
										getDt_().getStringOf("ConfirmPasword"));*/
	}
	//----------------------------------then
	@Step("O usuário será criado")
	public void O_usuario_sera_criado() throws Exception{
		pageCadastro.validar_cadastro ();
				
		
	}
	
}
package com.br.inmetrics.phpSuppliers.Steps;

import static br.com.santander.frm.base.DefaultBaseController.getPage_;
import static br.com.santander.frm.helpers.DataTableHelper.getDt_;
import com.br.inmetrics.phpSuppliers.Pages.Page_phpSuppliers_Cadastro;
import br.com.santander.frm.bdd.DesignSteps;
import br.com.santander.frm.bdd.Step;
import br.com.santander.frm.helpers.LoggerHelper;

@DesignSteps
public class Step_phpSuppliers_Cadastro {

Page_phpSuppliers_Cadastro pageCadastro = getPage_(Page_phpSuppliers_Cadastro.class);
LoggerHelper loggerHelper = new LoggerHelper(Page_phpSuppliers_Cadastro.class);

public String email = "admin@phptravels.com";
public String password = "demoadmin";

//------------------------------------GIVEN---------------------------------------------
	@Step("Estiver na pagina de login")
	public void estar_pglogin () throws Exception {
		pageCadastro.acessar_pagina();
		pageCadastro.validar_pagina();
	}
		
	
//--------------------------------WHEN---------------------------------------
	@Step("inserir os dados de login")
	public void inserir_dadoslogin () throws Exception{
		pageCadastro.inserir_email(email);
		pageCadastro.inserir_password(password);
		pageCadastro.logar_admin();
		pageCadastro.validar_login();
	}
//--------------------------cadastro nova supplier-------------------------------
	@Step("criar nova supplier")
	public void acessar_form () throws Exception {
		pageCadastro.nova_suppliers();
	}
	public void cadastro_supplier () throws Exception {
		pageCadastro.preencher_dados(getDt_().getStringOf("FirstName"),
								  getDt_().getStringOf("LastName"),
								  getDt_().getStringOf("Email"),
								  getDt_().getStringOf("Password"),
								  getDt_().getStringOf("MobileNumber"),
								  getDt_().getStringOf("Country"),
								  getDt_().getStringOf("Address1"),
								  getDt_().getStringOf("Address2"),
								  getDt_().getStringOf("Name"));
		}	
//===================================================================================================================
	//-------------------------------THEN----------------------------------------
	@Step("entao estarei logado")
	public void validarlogin () throws Exception {
	pageCadastro.validar_login();
	}
	//------------------------------cadastro nova supplier------------------------
	@Step("entao terei uma supplier cadastrada")
	public void criar () throws Exception {
		pageCadastro.submit();
	}
	
	
}

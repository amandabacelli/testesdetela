package com.br.inmetrics.phpSuppliers.Pages;

import br.com.santander.frm.helpers.LoggerHelper;
import br.com.santander.frm.helpers.PropertyHelper;
import static br.com.santander.frm.helpers.QueryHelper.*;

import br.com.santander.frm.base.PageBase;
import br.com.santander.frm.base.VirtualElement;
import br.com.santander.frm.exceptions.ElementFindException;
import br.com.santander.frm.exceptions.GenericException;

public class Page_phpSuppliers_Cadastro extends PageBase {
	@SuppressWarnings("rawtypes")
// -------------------------------------------------LOGIN----------------------------------------------------------------------
	public VirtualElement 
			insertEmail				= getElementByXPath("//input[@placeholder='Email']"),
			insertPassword			= getElementByXPath("//input[@placeholder='Password']"),
			buttonLogin 			= getElementByXPath("//button[@class='btn btn-primary btn-block ladda-button fadeIn animated']"),
			validapag 				= getElementByXPath("//strong[contains(.,'Login Panel')]"),
			validLogin 				= getElementByXPath("//strong[contains(.,'Logout')]"),
// ---------------------------------------------CADASTRO-----------------------------------------------------------------------
			clickAccount			= getElementByXPath("//ul[@class='collapse wow fadeIn animated list-unstyled']"),
			clickSpuppliers 		= getElementByXPath("(//a[@href='https://www.phptravels.net/admin/accounts/suppliers/'])[1]"),
			clickADD 				= getElementByXPath("//button[@type='submit']"),
			validADD 				= getElementByXPath("(//div[@class='panel-heading'])[1]"),
			firstName 				= getElementByXPath("//input[@placeholder='First name']"),
			lastName 				= getElementByXPath("//input[@placeholder='Last name']"),
			emailAdress 			= getElementByXPath("//input[@placeholder='Email address']"),
			password 				= getElementByXPath("//input[@placeholder='Password']"),
			mobileNumber 			= getElementByXPath("//input[@placeholder='Mobile Number']"),
			selectCountry 			= getElementByXPath("//span[@class='select2-chosen']"),
			adress1 				= getElementByXPath("(//input[@placeholder='Full address'])[1]"),
			adress2 				= getElementByXPath("(//input[@placeholder='Full address'])[2]"),
			name 					= getElementByXPath("//input[@placeholder='Name']"),
			buttonSubmit 			= getElementByXPath("//button[@class='btn btn-primary']");

	// ------------------------------------------------DELETE----------------------------------------------------------------------

	LoggerHelper loggerHelper = new LoggerHelper(Page_phpSuppliers_Cadastro.class);

	public int delay = 10;

//=====================================================================================================
//---------------------------------------GIVEN---------------------
	public void acessar_pagina() throws GenericException {
		getController().getDriver().get(PropertyHelper.getProperty("env.web.phptravel.url"));
	}

	public void validar_pagina() throws ElementFindException {
		waitUntilElementExists(validapag, delay);
	}

	public void inserir_email(String email) throws ElementFindException {
		waitUntilElementExists(insertEmail, delay);
		insertEmail.sendKeys(email);
	}

	public void inserir_password(String password) throws ElementFindException {
		waitUntilElementExists(insertPassword, delay);
		insertPassword.sendKeys(password);
	}

	public void logar_admin() throws ElementFindException {
		waitUntilElementExists(buttonLogin, delay);
		buttonLogin.click();
	}

//---------------------------------------WHEN - CADASTRO-----------------------
	public void nova_suppliers() throws ElementFindException {
		waitUntilElementExists(clickAccount, delay);
		waitUntilElementExists(clickSpuppliers, delay);
		waitUntilElementExists(clickADD, delay);
		waitUntilElementExists(validADD, delay);
	}

	public void preencher_dados(String FirstName, String LastName, String Email, String Password, String MobileNumber,
			String Country, String Address1, String Address2, String Name) throws ElementFindException {
		waitUntilElementExists(firstName, delay);
		firstName.sendKeys(FirstName);
		waitUntilElementExists(lastName, delay);
		lastName.sendKeys(LastName);
		waitUntilElementExists(emailAdress, delay);
		emailAdress.sendKeys(Email);
		waitUntilElementExists(password, delay);
		password.sendKeys(Password);
		waitUntilElementExists(mobileNumber, delay);
		mobileNumber.sendKeys(MobileNumber);
		waitUntilElementExists(selectCountry, delay);
		selectCountry.sendKeysKeyboard(Country); // verificar comando de click depois
		waitUntilElementExists(adress1, delay);
		adress1.sendKeys(Address1);
		waitUntilElementExists(adress2, delay);
		adress2.sendKeys(Address2);
		waitUntilElementExists(name, delay);
		name.sendKeys(Name);
	}

//=====================================================================================================
//---------------------------------------THEN-LOGIN---------------------
	public void validar_login() {
		waitUntilElementExists(validLogin, delay);
	}

//---------------------------------------THEN-CADASTRO---------------------	
	public void submit() throws ElementFindException {
		waitUntilElementExists(buttonSubmit, delay);
		buttonSubmit.click();
	}

}

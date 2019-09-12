package com.br.inmetrics.pages;

import static br.com.santander.frm.helpers.QueryHelper.getElementBys;
import static br.com.santander.frm.helpers.QueryHelper.*;

import org.apache.tools.ant.taskdefs.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.support.ui.Wait;
//import static br.com.santander.frm.helpers.QueryHelper.
import org.testng.Assert;
import br.com.santander.frm.base.PageBase;
import br.com.santander.frm.base.VirtualElement;
import br.com.santander.frm.exceptions.ElementFindException;
import br.com.santander.frm.exceptions.GenericException;
import br.com.santander.frm.helpers.LoggerHelper;
import br.com.santander.frm.helpers.PropertyHelper;

public class PageCadastro extends PageBase{
	
	//PAGE = é a classe que determino os metodos que serao utilizados, sem determinação de valores. Os valores são colocados na classe Step
	
	@SuppressWarnings("rawtypes")
	public VirtualElement //identificação dos campos de interação com o teste
				Firstname				= getElementByXPath("//input[@placeholder='First Name']"),
				Lastname				= getElementByXPath("//input[@placeholder='Last Name']"),
				MobileNumber			= getElementByXPath("//input[@placeholder='Mobile Number']"),
				Email					= getElementByXPath("//input[@placeholder='Email']"),
				Password 				= getElementByXPath("//input[@placeholder='Password']"),
				ConfirmPassord			= getElementByXPath("//input[@placeholder='Confirm Password']"),
				ConfirmSite				= getElementByXPath ("//div[@class='go-text-right panel-heading']"),
				ConfirmSingUP			= getElementByXPath("//h3[@style='margin-left: 17px']"),
				ButtonSignUp			= getElementByXPath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");
						
						
	LoggerHelper loggerHelper = new LoggerHelper(PageCadastro.class); //tirar print das telas

	
	private final int delay = 5; //delay de execução do metodo
	
	//toda função que eu chamar, preciso importar elas antes. EX: Generic Exception. Verificar os comandos na lista de comandos
	//ao lado dos comandos na lista de comandos tem a função que ele pertence. EX comando getcontroller - PageBase
	
	public void abrir_sitecadastro () throws GenericException {
		getController().getDriver().get(PropertyHelper.getProperty("env.web.phptravel.url")); //getcontroller é o controlador que vai abrir o site
		//get driver eh o driver que vamos usar no controller (chromedriver).get estou pegando uma propriedade da project.properties
		//propertyHelper.getProperty são comandos da framework para puxar o dado do project.properties
	}

	//VALIDAR---------------------------------------------------
	public void validar_pagina () throws ElementFindException {
		waitUntilElementExists(ConfirmSite, delay);//validar se está na pagina de cadastro
	}
	public void validarinfosexistentes (String dadosexcel) throws ElementFindException {
		waitUntilElementExists(ConfirmSingUP, delay);//validar se cadastrou o usuário
		Assert.assertEquals(ConfirmSingUP.getText(), Firstname);
	}
	public void validar_cadastro () throws ElementFindException {
		waitUntilElementVisible(ConfirmSingUP);
	}
	//colocar varias ações em um metodo.
	/*public void preencher_cadastro(String ... Args )  throws ElementFindException {		
			waitUntilElementExists(Firstname, delay);
			Firstname.sendKeys(Args[0]);
			waitUntilElementExists(Lastname, delay);
			Lastname.sendKeys(Args[1]);
			waitUntilElementExists(MobileNumber, delay);
			MobileNumber.sendKeys(Args[2]);
			waitUntilElementExists(Email, delay);
			Email.sendKeys(Args[3]);
			waitUntilElementExists(Password, delay);
			Password.sendKeys(Args[4]);
			waitUntilElementExists(ConfirmPassord, delay);
			ConfirmPassord.sendKeys(Args[5]);*/
	

	//CLICK-----------------------------------------------------------------------
	/*public void clicarFirstName () throws ElementFindException {
		waitUntilElementExists(Firstname, delay);
		Firstname.click();
	}
	public void clicarlastName () throws ElementFindException {
		waitUntilElementExists(Lastname, delay);
		Lastname.click();
	}
	public void clicarmobilenumber () throws ElementFindException {
		waitUntilElementExists(MobileNumber, delay);
		MobileNumber.click();
	}
	public void clicarEmail () throws ElementFindException {
		waitUntilElementExists(Email, delay);
		Email.click();
	}
	public void clicarPassword() throws ElementFindException {
		waitUntilElementExists(Password, delay);
		Password.click();
	}
	public void clicarConfirmPassword() throws ElementFindException {
		waitUntilElementExists(ConfirmPassord, delay);
		ConfirmPassord.click();//clicar no campo
	}*/
	public void clicar_singup () throws ElementFindException, GenericException {
		scrollToElement(ButtonSignUp);//rolar a pagina ate o botao para ficar visivel
		waitUntilElementExists(ButtonSignUp, delay);
		ButtonSignUp.click();		
	}
		
	//SENDKEYS---------------------------------------------------------------------
	public void sendKeysfirstname (String dadosexcel) throws ElementFindException {
		waitUntilElementExists(Firstname, delay);
		Firstname.sendKeys(dadosexcel);
	}
	public void sendKeyslastname (String dadosexcel) throws ElementFindException {
		waitUntilElementExists(Lastname, delay);
		Lastname.sendKeys(dadosexcel);
	}
	public void sendKeysmobilenumber(String dadosexcel) throws ElementFindException {
		waitUntilElementExists(MobileNumber, delay);
		MobileNumber.sendKeys(dadosexcel);
	}
	public void sendKeysEmail(String dadosexcel) throws ElementFindException {
		waitUntilElementExists(Email, delay);
		Email.sendKeys(dadosexcel);
	}
	public void sendKeysPassword(String dadosexcel) throws ElementFindException {
		waitUntilElementExists(Password, delay);
		Password.sendKeys(dadosexcel);
	}
	public void sendKeysConfirmPassword(String dadosexcel) throws ElementFindException {
		waitUntilElementExists(ConfirmPassord, delay);
		ConfirmPassord.sendKeys(dadosexcel);
	}
		
	
}


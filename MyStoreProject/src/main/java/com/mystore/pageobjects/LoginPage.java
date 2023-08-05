package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="pass")
	WebElement passWord;
	
	@FindBy(id="send2")
	WebElement submit;
	
	@FindBy(id="login-email")
	WebElement LoginEmail;
	
	@FindBy(id="login-password")
	WebElement LoginPassword;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement SubmitSign;
	
	@FindBy(xpath="//a[@class='action create primary']")
	WebElement createaccount;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage Login(String uname,String pwd)
	{
		ActionClass.type(userName, uname);
		ActionClass.type(passWord, pwd);
		ActionClass.click(driver, submit);
		return new HomePage();
	}
	
	public AddressPage Login1(String uname1,String pwd1)
	{
		ActionClass.type(LoginEmail, uname1);
		ActionClass.type(LoginPassword, pwd1);
		ActionClass.JSClick(driver, SubmitSign);
		//ActionClass.click(driver, SubmitSign);
		return new AddressPage();
	}
	
	public AccountCreationPage CreateAccount()
	{
		ActionClass.click(driver,createaccount);
		return new AccountCreationPage();
	}

}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	@FindBy(xpath="//div[@id='block-collapsible-nav']//a[text()='My Account']")
	WebElement formTitle;
	
	public AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	 public boolean ValidateAccountCreatePage()
	 {
		 ActionClass.explicitWait(driver, formTitle,5000);
		 return ActionClass.isDisplayed(driver, formTitle);
	 }
}

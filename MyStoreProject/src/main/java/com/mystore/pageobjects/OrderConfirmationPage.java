package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//span[text()='Thank you for your purchase!']")
	WebElement ConfirmationMessage;
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(driver, this);
	}
    
	public boolean VerifyConfirmation()
	{
		return ActionClass.isDisplayed(driver, ConfirmationMessage);
	}
}

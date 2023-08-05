package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div")
	WebElement PlaceOrder;
	
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage ClickOnPlaceOrder() throws InterruptedException
	{
		Thread.sleep(5000);
		PlaceOrder.click();
		return new OrderConfirmationPage();
	}

}

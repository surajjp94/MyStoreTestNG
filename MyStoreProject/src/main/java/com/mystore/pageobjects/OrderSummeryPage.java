package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class OrderSummeryPage extends BaseClass {
	WebDriverWait wait;
	
	@FindBy (xpath="//div[@class='title']")
	WebElement OrderTitle;
	
	@FindBy(xpath="//span[@class='cart-price']")
	WebElement CartPrice;
	
	@FindBy(xpath="//button[@type='button']//span[text()='Sign In']")
	WebElement SignInBtn;

	@FindBy(id="login-email")
	WebElement LoginEmail;
	
	@FindBy(id="login-password")
	WebElement LoginPassword;
	
	@FindBy(xpath="//*[@id='modal-content-6']//span[text()='Sign In']")
	WebElement SubmitSign;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']/div")
	WebElement next;
	
	public OrderSummeryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnOrderTitle()
	{
		
		ActionClass.JSClick(driver, OrderTitle);
		//ActionClass.click(driver, OrderTitle);
	}
	
	public String ValidatePrice()
	{
		ActionClass.explicitWait(driver, CartPrice, 50);
		return CartPrice.getText();
	}
	
	public LoginPage ClickOnSignIn()
	{
		ActionClass.explicitWait(driver, SignInBtn, 30);
		ActionClass.JSClick(driver, SignInBtn);
		return new LoginPage();
	}
	
	public PaymentPage ClickOnNext() throws InterruptedException
	{
		//ActionClass.explicitWait(driver, next, 30);
		ActionClass.scrollByVisibilityOfElement(driver, next);
		Thread.sleep(5000);
		ActionClass.click(driver, next);
		return new PaymentPage();
	}
	

}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	@FindBy(id="qty")
	WebElement quantity;
	
	@FindBy(id="option-label-size-143-item-169")
	WebElement sizeList;
	
	@FindBy(id="option-label-color-93-item-58")
	WebElement Addcolor;
	
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	WebElement AddToCartBtn;
	
	@FindBy(xpath="//*[@id=\"maincontent\"]//div[@class='messages']")
	WebElement AddToCartMessage;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement ShowCart;
	
	@FindBy(id="top-cart-btn-checkout")
	WebElement ProceedToCheckout;
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectQty(String qty)
	{
		ActionClass.type(quantity, qty);
	}
	
	public void selectSize()
	{
		ActionClass.click(driver, sizeList);
	}
	
	public void selectColor()
	{
		ActionClass.click(driver, Addcolor);
	}
	public void ClickOnAddToCart()
	{
		ActionClass.click(driver, AddToCartBtn);
	}
	
	public boolean CartMessage()
	{
		return ActionClass.isDisplayed(driver, AddToCartMessage);
	}
	
	public OrderSummeryPage CheckoutPage()
	{
		
		ActionClass.click(driver, ShowCart);
		ActionClass.explicitWait(driver, ProceedToCheckout, 30);
		ActionClass.click(driver, ProceedToCheckout);
		return new OrderSummeryPage();
	}
	
	
}

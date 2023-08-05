package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="(//span[@class='customer-name'])[1]")
	WebElement pathToHomePage;

	@FindBy(xpath="//span[text()='My Wish List']")
	WebElement wishlist;
	
	@FindBy(xpath="//a[text()='My Orders']")
	WebElement myorders;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean MyWishList()
	{
		ActionClass.explicitWait(driver, wishlist, 5000);
		return ActionClass.isDisplayed(driver, wishlist);
	}
	
	public boolean MyOrders()
	{
		return ActionClass.isDisplayed(driver, myorders);
	}
	
	public String getCurrURL()
	{
		String homepageURL=driver.getCurrentUrl();
		return homepageURL;
	}
	
	public void ClickonAfterSignIn()
	{
		ActionClass.click(driver, pathToHomePage);
		ActionClass.click(driver, driver.findElement(By.xpath("(//li[@class='link wishlist'])[1]")));
	}
}

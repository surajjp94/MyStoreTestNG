package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{

	
	@FindBy(xpath="//*[@id='maincontent']//img[@alt='Chloe Compete Tank']")
	WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailabel()
	{
		return ActionClass.isDisplayed(driver, productResult);
		
	}
	
	public AddToCartPage clickOnProduct()
	{
		ActionClass.click(driver, productResult);
		return new AddToCartPage();
	}
}

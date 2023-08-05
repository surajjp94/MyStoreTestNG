package com.mystore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	
	
	@FindBy(xpath="//a[contains(text(),\"Sign In\")][1]")
	WebElement sigInBtn;
	
	@FindBy(xpath="//a[@class='logo']/img")
	WebElement logo;
	
	@FindBy(id="search")
	WebElement SearchBox;
	
	@FindBy(xpath="//input[@id='search']//following::button[@type='submit'][1]")
	WebElement SubmitSearch;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage ClickOnSignIn() {
		ActionClass.click(driver,sigInBtn );
		return new LoginPage();
	}
	
	public boolean ValidateLogo()
	{
		return ActionClass.isDisplayed(driver, logo);
	}
	
	public String getTitle()
	{
		return ActionClass.getTitle(driver);
	}
	public SearchResultPage SearchProduct(String ProductName)
	{
		ActionClass.type(SearchBox, ProductName);
		SearchBox.sendKeys(Keys.ENTER);
		return new SearchResultPage();
	}
	
}

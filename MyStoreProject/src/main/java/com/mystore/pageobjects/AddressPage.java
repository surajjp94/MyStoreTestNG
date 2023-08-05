package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='QF4U32L']")
	WebElement StreetAddress;
	
	@FindBy(xpath="//input[@id='RF0KONJ']")
	WebElement city;
	
	@FindBy(xpath="//*[@id='DOTNFYU']")
	WebElement State;
	
	@FindBy(xpath="//*[@id='JQ8R9I9']")
	WebElement ZipCode;
	
	@FindBy(xpath="//*[@id='NT79E4O']")
	WebElement country;
	
	@FindBy(xpath="//*[@id='DAB10KC']")
	WebElement Phone;
	
	@FindBy(xpath="//input[@value='tablerate_bestway']")
	WebElement faltrateradio;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement clicknext;
	
	public AddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void AddStreet(String Street)
	{
		ActionClass.type(StreetAddress, Street);
	}
	
	public void AddCity(String City)
	{
		ActionClass.selectByValue(city, City);
	}
	
	public void AddState(String state)
	{
		ActionClass.type(State, state);
	}
	
	public void AddZipCode(String Zip)
	{
		ActionClass.type(ZipCode, Zip);
	}
	
	public void AddCountry(String countri)
	{
		ActionClass.selectByValue(country, countri);
	}
	
	public void AddPhone(String Mobile)
	{
		ActionClass.type(Phone, Mobile);
	}
	
	public void SelectShipping()
	{
		ActionClass.click(driver, faltrateradio);
	}
	
	public PaymentPage clickOnNext()
	{
		ActionClass.click(driver, clicknext);
		return new PaymentPage();
	}

}

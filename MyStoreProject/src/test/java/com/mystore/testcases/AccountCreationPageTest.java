package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	AccountCreationPage ap=new AccountCreationPage();
	@BeforeTest
	public void setup()
	{
		launchApp();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void VerifyAccount()
	{
		indexpage=new IndexPage();
		loginpage=indexpage.ClickOnSignIn();
		homepage=loginpage.Login(ip.getProperty("username"), ip.getProperty("password"));
		homepage.ClickonAfterSignIn();
		ap=new AccountCreationPage();
		boolean result=ap.ValidateAccountCreatePage();
		Assert.assertTrue(result);
	}
}

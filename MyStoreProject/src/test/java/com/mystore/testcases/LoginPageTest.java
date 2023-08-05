package com.mystore.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mystore.actiondriver.ActionClass;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;



public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homepage;
	@BeforeTest
	public void Setup()
	{
		launchApp();
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	@Test(dataProvider = "credentials",dataProviderClass = DataProviders.class,groups= {"smoke","sanity"})
	public void loginTest(String user,String pwd)
	{
		Log.startTestCase("LoginPageTest");
		indexPage=new IndexPage();
		Log.info("User is going to click on signIn");
		loginPage=indexPage.ClickOnSignIn();
		Log.info("User enters username and password");
		//homepage=loginPage.Login(ip.getProperty("username"), ip.getProperty("password"));
		homepage=loginPage.Login(user,pwd);
		String actualURL=homepage.getCurrURL();
		Log.info("Verify user is able to login");
		Assert.assertEquals(actualURL, "https://magento.softwaretestingboard.com/");
		Log.info("login is success");
		
	}
	
	
}



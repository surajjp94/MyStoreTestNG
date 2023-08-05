package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;



public class HomePageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
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
	
//	@Test(priority=2)
//	public void VerifyWishList()
//	{
//		indexpage=new IndexPage();
//		loginpage=indexpage.ClickOnSignIn();
//		homepage=loginpage.Login(ip.getProperty("username"), ip.getProperty("password"));
//		homepage.ClickonAfterSignIn();
//		boolean result=homepage.MyWishList();
//		Assert.assertTrue(result);
//	}
	
	@Test(priority=1)
	public void VerifyMyorders()
	{
		
			indexpage=new IndexPage();
			loginpage=indexpage.ClickOnSignIn();
			homepage=loginpage.Login(ip.getProperty("username"), ip.getProperty("password"));
			homepage.ClickonAfterSignIn();
			boolean result=homepage.MyOrders();
			Assert.assertTrue(result);
		
	}

}


package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;



public class IndexPageTest extends BaseClass  {
	IndexPage pg;
	@BeforeTest(groups= {"smoke","sanity"})
	public void Setup()
	{
		launchApp();
	}
	@AfterTest(groups= {"smoke","sanity"})
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(groups="smoke")
	public void VerifyLogo()
	{
		pg=new IndexPage();
		boolean result=pg.ValidateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups="smoke")
	public void VerifyTitle()
	{
		String actulatitle=pg.getTitle();
		Assert.assertEquals(actulatitle, "Home Page");
	}

}

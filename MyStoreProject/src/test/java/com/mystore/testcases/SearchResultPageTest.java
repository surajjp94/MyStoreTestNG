package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;



public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchpage;
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
	
	@Test
	public void VerifyProduct()
	{
		indexpage=new IndexPage();
		searchpage = indexpage.SearchProduct("tshirts for women");
		boolean result=searchpage.isProductAvailabel();
		Assert.assertTrue(result);
	}

}

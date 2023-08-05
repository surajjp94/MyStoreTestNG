package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;



public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResultPage searchpage;
	AddToCartPage Addtocart;
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
	public void VerifyAddToCart()
	{
		indexpage=new IndexPage();
		searchpage = indexpage.SearchProduct("tshirts for women");
		boolean result=searchpage.isProductAvailabel();
		Assert.assertTrue(result);
		Addtocart=searchpage.clickOnProduct();
		Addtocart.selectQty("2");
		Addtocart.selectSize();
		Addtocart.selectColor();
		Addtocart.ClickOnAddToCart();
		boolean reslut=Addtocart.CartMessage();
		Assert.assertTrue(reslut);
		
	}

}

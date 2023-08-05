package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderSummeryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;


public class PaymentPageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchpage;
	AddToCartPage Addtocart;
	OrderSummeryPage ordersummery;
	LoginPage login;
	AddressPage add;
	PaymentPage paymentpage;
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
	public void VerifyAddToCart() throws InterruptedException
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
		ordersummery=Addtocart.CheckoutPage();
		login=ordersummery.ClickOnSignIn();
		add=login.Login1(ip.getProperty("username"), ip.getProperty("password"));
		Thread.sleep(5000);
		paymentpage=ordersummery.ClickOnNext();
		paymentpage.ClickOnPlaceOrder();

		
		
		
		
	}
}

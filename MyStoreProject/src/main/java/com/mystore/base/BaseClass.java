package com.mystore.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.w3c.dom.DOMConfiguration;

import com.mystore.actiondriver.ActionClass;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties ip;
	public static WebDriver driver;
	
	@BeforeSuite(groups= {"smoke","sanity"})
	public void loadConfig() throws Exception
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		ip=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\configuration\\Config.properties");
		ip.load(fis);
	}
	
	
	
	
	public static void launchApp()
	{
		WebDriverManager.chromedriver().setup();
		String browserName=ip.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browserName.contains("Edge")) {
			driver=new EdgeDriver();
		}
		ActionClass.implicitWait(driver, 10);
		ActionClass.pageLoadTimeOut(driver, 30);
		
		driver.get(ip.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
	}

}

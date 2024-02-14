package com.waitlist.genericutility;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	public static  WebDriver driver;
	public WebDriverUtility webDriverUtils = new WebDriverUtility();
	public FileUtility fileUtils = new FileUtility();
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeClass
	public void executeBeforeTest() throws Throwable
	{
		
		String browser = fileUtils.readFromPropertyFile("browser");
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		webDriverUtils.implicitWait(driver);
		driver.get(fileUtils.readFromPropertyFile("url"));
	}
	
		
	@AfterClass
	public void executeAfterTest()
	{
				
		driver.manage().window().minimize();
		driver.quit();
	}
	
	
	
	

}

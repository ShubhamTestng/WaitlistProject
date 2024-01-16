package com.waitlist.genericutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	public static  WebDriver driver;
	public WebDriverUtility webDriverUtils = new WebDriverUtility();
	public FileUtility fileUtils = new FileUtility();
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeMethod	
	public void executeBeforeClass() throws Throwable
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
	
	@AfterMethod
	public void executeAfterClass()
	{
		driver.manage().window().minimize();
		driver.quit();
	}
}

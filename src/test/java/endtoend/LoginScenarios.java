package endtoend;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;

import com.waitlist.genericutility.BaseClass;
import com.waitlist.genericutility.ExcelUtility;
import com.waitlist.genericutility.FileUtility;
import com.waitlist.pomrepo.AddParty;
import com.waitlist.pomrepo.LandingPage;
import com.waitlist.pomrepo.LoginPage;
import com.waitlist.pomrepo.WaitList;
import com.waitlist.pomrepo.WelcomePage;

import net.bytebuddy.utility.RandomString;

public class LoginScenarios extends BaseClass {
	
	public FileUtility fileUtils = new FileUtility();
	public ExcelUtility excelUtil = new ExcelUtility();
	public Logger log = LogManager.getLogger(LoginScenarios.class);
	
	@Test(priority=1)
	public void validCredentials() throws Throwable
	{
	
	LandingPage land = new LandingPage(driver);	
	land.getLoginButton().click();	
	log.info("Clicked login button"); 
	
	LoginPage login = new LoginPage(driver);
	log.info("Login page opened");
	
	login.getEmailTetField().sendKeys(fileUtils.readFromPropertyFile("email"));
	log.info("Email Entered");
	
	login.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
	log.info("Password Entered");
	
	login.getLoginButton().click();
	log.info("Clicked login button");
	
	Assert.assertTrue(driver.getCurrentUrl().equals("https://fourtopstaging.appspot.com/welcome")); 
	
	}
	
	@Test(priority=2)
	public void invalidPassword() throws Throwable {
		
		LandingPage land = new LandingPage(driver);	
		land.getLoginButton().click();	
		log.info("Clicked login button");
		
		LoginPage login = new LoginPage(driver);
		log.info("Login page opened");
		
		login.getEmailTetField().sendKeys(fileUtils.readFromPropertyFile("email"));
		log.info("Email Entered");
		
		login.getPasswordTextField().sendKeys("654321");
		log.info("Password Entered");
		
		login.getLoginButton().click();
		log.info("Clicked login button");	
		
		Assert.assertFalse(driver.getCurrentUrl().equals("https://fourtopstaging.appspot.com/welcome"));
		
	}
//	
//	@Test(priority=3)
//	public void invalidEmail() throws Throwable {
//				
//		LandingPage land = new LandingPage(driver);	
//		land.getLoginButton().click();	
//		log.info("Clicked login button");
//		
//		LoginPage login = new LoginPage(driver);
//		log.info("Login page opened");
//		
//		login.getEmailTetField().sendKeys("abc@yopmail.com");
//		log.info("Email Entered");
//		
//		login.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
//		log.info("Password Entered");
//		
//		login.getLoginButton().click();
//		log.info("Clicked login button");
//	
//		Assert.assertFalse(driver.getCurrentUrl().equals("https://fourtopstaging.appspot.com/welcome"));	
//	}
	
}

package endtoend;


import java.time.Duration;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.waitlist.genericutility.BaseClass;
import com.waitlist.genericutility.ExcelUtility;
import com.waitlist.genericutility.FileUtility;
import com.waitlist.genericutility.JavaScriptUtility;
import com.waitlist.pomrepo.AddParty;
import com.waitlist.pomrepo.LandingPage;
import com.waitlist.pomrepo.LoginPage;
import com.waitlist.pomrepo.WaitList;
import com.waitlist.pomrepo.WelcomePage;

import net.bytebuddy.utility.RandomString;


public class CreateWaitList extends BaseClass {
	
	public FileUtility fileUtils = new FileUtility();
	public ExcelUtility excelUtil = new ExcelUtility();
	public Logger log = LogManager.getLogger(CreateWaitList.class);
	JavaScriptUtility jse = new JavaScriptUtility();
		
	@Test(priority=1, dataProvider = "testDataProvider")
	public void createWaitList(String name,String randomPhone, String randomEmail ) throws Throwable
	{
	
		
	log.info("landing page opened");
	
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
	
	WelcomePage welcome = new WelcomePage(driver);
	log.info("Welcome page opened");
	
	welcome.getWaitlistLink().click();
	log.info("Clicked Waitlist link");
	
	WaitList waitlist = new WaitList(driver);
	waitlist.getAddPartyButton().click();
	
	AddParty addParty = new AddParty(driver);
	addParty.getNameTextField().sendKeys(name);
	
	addParty.getPhoneTextField().sendKeys(randomPhone);
	addParty.getEmailTextField().sendKeys(randomEmail);
	addParty.getMemberSize().click();
	addParty.getAdultButton().click();
	
	for(int i=1;i<=2;i++) {
	addParty.getKidsButton().click();
	}
	for(int i=1;i<=3;i++) {
	addParty.getAgedButton().click();
	}
	addParty.getStatusButton().click();
	addParty.getNotesTextBox().sendKeys(RandomString.make(200));
	log.info("Party Added");	
	addParty.getNextButton().click();
	
	WebElement dropdown = driver.findElement(By.name("waitTime"));
	
	Select drop = new Select(dropdown);
	drop.selectByVisibleText("45 Minutes");
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='next']"))));
	nextBtn.click();
	
	driver.findElement(By.xpath("//tr[@id='assign_7']")).click();
//	nextBtn.click();
//	
//	WebElement checkmark = driver.findElement(By.xpath("//span[text()='"+randomPhone+"']/../../td[9]/div[@id='request_2_undefined']"));
//	checkmark.click();
	}	
	
	
	
	// DataProvider for above test
	@DataProvider(name = "testDataProvider")
    public Object[][] testData() {
        // Define your test data as a 2D array
        return new Object[][]{
        {"Sumit"+RandomString.make(3), ""+new Random().nextLong(1000000000l, 9999999999l), RandomString.make(5)+"@yopmail.com" }
                
        };
    }
	
	
		
	
}

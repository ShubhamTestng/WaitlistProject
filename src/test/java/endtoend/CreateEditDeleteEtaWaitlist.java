package endtoend;

import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.waitlist.genericutility.BaseClass;
import com.waitlist.genericutility.DropdownUtility;
import com.waitlist.genericutility.ExcelUtility;
import com.waitlist.genericutility.FileUtility;
import com.waitlist.genericutility.JavaScriptUtility;
import com.waitlist.pomrepo.AddParty;
import com.waitlist.pomrepo.EditParty;
import com.waitlist.pomrepo.HistoryPage;
import com.waitlist.pomrepo.LandingPage;
import com.waitlist.pomrepo.LoginPage;
import com.waitlist.pomrepo.WaitList;
import com.waitlist.pomrepo.WelcomePage;

import net.bytebuddy.utility.RandomString;


public class CreateEditDeleteEtaWaitlist extends BaseClass {

	public FileUtility fileUtils = new FileUtility();
	public DropdownUtility dropdown = new DropdownUtility();
	public ExcelUtility excelUtil = new ExcelUtility();
	public Logger log = LogManager.getLogger(Create_Edit_delete_waitlist.class);
	JavaScriptUtility jse = new JavaScriptUtility();
	public Scanner s = new Scanner(System.in);
		
	@Test(priority=1, dataProvider = "testDataProvider")
	public void createWaitList(String name,String Phone, String Email ) throws Throwable
	{
		WelcomePage welcome = new WelcomePage(driver);
		LandingPage land = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		AddParty addParty = new AddParty(driver);		
		WaitList waitList = new WaitList(driver);
		
	land.getLoginButton().click();	
	log.info("Clicked login button");
	Assert.assertEquals(driver.getCurrentUrl().equals("https://fourtopstaging.appspot.com/login"), true);
	Assert.assertEquals(driver.getTitle().contains("Login | Waitlist Me"), true);
	
	login.getEmailTetField().sendKeys(fileUtils.readFromPropertyFile("email"));
	log.info("Entered email");
	
	login.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
	log.info("Entered password");
	
	login.getLoginButton().click();
	log.info("Clicked login button");
	Assert.assertEquals(driver.getCurrentUrl().equals("https://fourtopstaging.appspot.com/welcome"), true);
	Assert.assertEquals(driver.getTitle().contains("Welcome to Waitlist Me"), true);
	
	welcome.getWaitlistLink().click();
	log.info("Clicked waitlist link");
	
//	waitList.getAddPartyButton().click();
//	
//	addParty.getNameTextField().sendKeys(name);
//	addParty.getPhoneTextField().sendKeys(Phone);
//	addParty.getEmailTextField().sendKeys(Email);
//	addParty.getMemberSize().click();
//	addParty.getAdultButton().click();
//	
//	for(int i=1;i<=2;i++) {
//	addParty.getKidsButton().click();
//	}
//	
//	for(int i=1;i<=3;i++) {
//	addParty.getAgedButton().click();
//	}
//	
//	addParty.getStatusButton().click();
//	addParty.getNotesTextBox().sendKeys(RandomString.make(200));
//	addParty.getNextButton().click();
//	
//	addParty.getETAOption().click();
//	addParty.getETADate().sendKeys("03/01/2024");
//	addParty.getETATime().clear();
//	driver.findElement(By.xpath("//li[text()='8:30 PM']")).click();
//	Thread.sleep(2000);
//	dropdown.dropdown(addParty.getETADuration(), "2 Hour 30 Minutes");
//	Thread.sleep(2000);	
//	addParty.getETAnext().click();
//	addParty.getETAassignment().click();
//	addParty.getETAnext().click();
		
	}	
		
	@Test(priority=2)
	public void deleteParty () throws Throwable  {
		
		WaitList waitList = new WaitList(driver);
		EditParty editParty = new EditParty(driver);
		
		waitList.getWaitListparty().click();
		log.info("Clicked waitlistparty link");
		
		editParty.getDeleteButton().click();
		log.info("Clicked delete button");
				
		editParty.getYesAction().click();
		log.info("Clicked yes button");
		
		}
		
	@Test(priority=3)
	public void checkHistory() throws Throwable {
		HistoryPage historyPage = new HistoryPage(driver);
		AddParty addParty = new AddParty(driver);		
		WaitList waitList = new WaitList(driver);
				
		//Check History After Deleting
		waitList.getShowHistoryButton().click();
		log.info("Clicked show history button");
		
		//restoring the party
		historyPage.getWaitlistpartyHistory2().click();
		log.info("Clicked waitlist party in history tab");
		
		addParty.getETAReturntoWaitlist().click();
		log.info("Clicked return to waitlist button");
	}
	
	@Test(priority=4)
	public void restoreParty() throws Throwable {
		HistoryPage historypage = new HistoryPage(driver);
		
		//Check party is restored
		historypage.getWaitlistLinkHistoryPage().click();
		log.info("Clicked waitlist link");
		 
	}
	
	
	@Test(priority=5)
	public void editParty() throws Throwable{
		
		HistoryPage historyPage= new HistoryPage(driver);
		EditParty editParty = new EditParty(driver);
		
		historyPage.getWaitlistpartyHistory3().click();
		log.info("Clicked edit waitlist party button");
			
		editParty.getNameTextField().clear();
		log.info("Cleared name text field");
		
		editParty.getNameTextField().sendKeys("Smith");
		log.info("Entered Name");
		
		editParty.getPhoneTextField().clear();
		log.info("Cleared phone text field");
		
		editParty.getPhoneTextField().sendKeys("789456123");
		log.info("Entered Phone number");
		
		editParty.getEmailTextField().clear();
		log.info("Cleared email text field");
		
		editParty.getEmailTextField().sendKeys("Smith@yopmail.com");
		log.info("Entered Email");
		
		editParty.getNotesTextField().clear();
		log.info("Cleared notes text field");
		
		editParty.getNotesTextField().sendKeys("def");
		log.info("Entered notes in notes text field");
		
		editParty.getUpdateLink().click();
		log.info("Clicked update link");
		
		editParty.getAssignment().click();
		log.info("Clicked  assignment link");
		
		editParty.getDoneButton().click();
		log.info("Clicked done button");
		
		editParty.getSize().clear();
		log.info("Cleared member size");
		
		editParty.getSize().sendKeys("8");
		log.info("Entered member size");
		
		editParty.getColorCode().click();
		log.info("Clicked color code for status");
				
		editParty.getSaveButton().click();
	}
	
	
	@Test(priority=6)
	public void restoreEditParty() throws Throwable{
		WaitList waitlist = new WaitList(driver);
		EditParty editParty = new EditParty(driver);
		
		waitlist.getWaitlistpartyHistory4().click();
		log.info("Clicked edit waitlist party button");
			
		editParty.getNameTextField().clear();
		log.info("Cleared name text field");
		
		editParty.getNameTextField().sendKeys("Richard");
		log.info("Entered Name");
		
		editParty.getPhoneTextField().clear();
		log.info("Cleared phone text field");
		
		editParty.getPhoneTextField().sendKeys("123456");
		log.info("Entered Phone number");
		
		editParty.getEmailTextField().clear();
		log.info("Cleared email text field");
		
		editParty.getEmailTextField().sendKeys("Richard@yopmail.com");
		log.info("Entered Email");
		
		editParty.getNotesTextField().clear();
		log.info("Cleared notes text field");
		
		editParty.getNotesTextField().sendKeys("abc");
		log.info("Entered notes in notes text field");
		
		editParty.getUpdateLink().click();
		log.info("Clicked update link");
		
		editParty.getAssignment().click();
		log.info("Clicked  assignment link");
		
		editParty.getDoneButton().click();
		log.info("Clicked done button");
		
		editParty.getSize().clear();
		log.info("Cleared member size");
		
		editParty.getSize().sendKeys("8");
		log.info("Entered member size");
		
		editParty.getColorCode().click();
		log.info("Clicked color code for status");
			
		editParty.getSaveButton().click();
	}
	
	@Test(priority=7)
	public void logout() throws Throwable{
		WaitList waitlist = new WaitList(driver);
		waitlist.getAccountButton().click();
		log.info("Clicked account button");
		waitlist.getLogoutButton().click();
		log.info("Clicked logout button");
		Assert.assertEquals(false, true);
	}
	
	
	
	// DataProvider for above test
	@DataProvider(name = "testDataProvider")
    public Object[][] testData() {
		
        return new Object[][]{
        {"Richard", "654879879","Richard@yopmail.com" }
                
        };
    }
}

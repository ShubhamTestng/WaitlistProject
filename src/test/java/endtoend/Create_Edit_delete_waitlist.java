package endtoend;


import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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


public class Create_Edit_delete_waitlist extends BaseClass {
	
	public FileUtility fileUtils = new FileUtility();
	public DropdownUtility dropdown = new DropdownUtility();
	public ExcelUtility excelUtil = new ExcelUtility();
	public Logger log = LogManager.getLogger(Create_Edit_delete_waitlist.class);
	JavaScriptUtility jse = new JavaScriptUtility();
	
	
	
	@Test(priority=1, dataProvider = "testDataProvider")
	public void createWaitList(String name,String Phone, String Email ) throws Throwable
	{
		WaitList waitList = new WaitList(driver);
		WelcomePage welcome = new WelcomePage(driver);
		LandingPage land = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		AddParty addParty = new AddParty(driver);
		
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
//		Assert.assertEquals(driver.getCurrentUrl().equals("https://fourtopstaging.appspot.com/v2/waitlist/?place_id=8197710014"), true);
			
//	waitList.getAddPartyButton().click();
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
//	dropdown.dropdown(addParty.getTimeDropdown(),"45 Minutes");
//	Thread.sleep(2000);
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//	WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='next']"))));
//	nextBtn.click();
	
//	driver.findElement(By.xpath("//tr[@id='assign_7']")).click();
//	nextBtn.click();
//	addParty.getClosebuttonatAssignment().click();
		
	}	
	
	
	@Test(priority=2, dataProvider = "testDataProvider")
	public void deleteParty (String name,String Phone, String Email) {
		
		
		EditParty editParty = new EditParty(driver);
		
		editParty.getEditWaitlistPartylink().click();
		log.info("Clicked waitlistparty link");
		
		
		//Delete Party
		editParty.getDeleteButton().click();
		log.info("Clicked delete button");
						
		editParty.getYesAction().click();
		log.info("Clicked yes button");
		
	}		
	
	
	@Test(priority=3, dataProvider = "testDataProvider")
	public void checkHistory(String name,String Phone, String Email) {
		
		HistoryPage historyPage = new HistoryPage(driver);		
		WaitList waitList = new WaitList(driver);
		
		//Check History After Deleting
		waitList.getShowHistoryButton().click();
		log.info("Clicked show history button");
		
		historyPage.getWaitlistpartyHistory().click();
		log.info("Clicked waitlist party in history tab");
		
	}
	
	@Test(priority=4, dataProvider = "testDataProvider")
	public void restoreParty(String name,String Phone, String Email) throws Throwable {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		EditParty editParty = new EditParty(driver);
		//Check party is restored
		
		welcomePage.getWaitlistLink2().click();
		log.info("Clicked waitlist link");
	}
	
	
	@Test(priority=5, dataProvider = "testDataProvider")
	public void editParty(String name,String Phone, String Email) {
				
		EditParty editParty = new EditParty(driver);
		
		editParty.getEditWaitlistPartylink().click();	
		log.info("Clicked edit waitlist party button");
		
		editParty.getNameTextField().clear();
		log.info("Cleared name text field");
		
		editParty.getNameTextField().sendKeys("Sumit");
		log.info("Entered Name");
		
		editParty.getPhoneTextField().clear();
		log.info("Cleared phone text field");
		
		editParty.getPhoneTextField().sendKeys("123456");
		log.info("Entered Phone number");
		
		editParty.getEmailTextField().clear();
		log.info("Cleared email text field");
		
		editParty.getEmailTextField().sendKeys("Sumit@yopmail.com");
		log.info("Entered Email");
		
		editParty.getNotesTextField().clear();
		log.info("Cleared notes text field");
		
		editParty.getNotesTextField().sendKeys("Edited text");
		log.info("Entered notes in notes text field");
		
		DropdownUtility dropdown = new DropdownUtility();
		dropdown.dropdown(editParty.getQuotedDropdown(),"3 Hour 15 Minutes");
		log.info("Entered time in quoted duration");
		
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
	public void restoreEditParty() {
		
		EditParty editParty = new EditParty(driver);
		
		editParty.getEditWaitlistPartylink2().click();	
		log.info("Clicked edit waitlist party button");
		
		editParty.getNameTextField().clear();
		log.info("Cleared name text field");
		
		editParty.getNameTextField().sendKeys("Robert");
		log.info("Entered Name");
		
		editParty.getPhoneTextField().clear();
		log.info("Cleared phone text field");
		
		editParty.getEmailTextField().clear();
		log.info("Cleared email text field");
		
		editParty.getEmailTextField().sendKeys("Robert@yopmail.com");
		log.info("Entered Email");
		
		editParty.getNotesTextField().clear();
		log.info("Cleared notes text field");
		
		editParty.getNotesTextField().sendKeys("Original text");
		log.info("Entered notes in notes text field");
		
		DropdownUtility dropdown = new DropdownUtility();
		dropdown.dropdown(editParty.getQuotedDropdown(),"3 Hour 15 Minutes");
		log.info("Entered time in quoted duration");
		
		editParty.getUpdateLink().click();
		log.info("Clicked update link");
		
		editParty.getAssignment().click();
		log.info("Clicked  assignment link");
		
		editParty.getDoneButton().click();
		log.info("Clicked done button");
		
		editParty.getSize().clear();
		log.info("Cleared member size");
		
		editParty.getSize().sendKeys("7");
		log.info("Entered member size");
		
		editParty.getColorCode().click();
		log.info("Clicked color code for status");
		
		
		editParty.getSaveButton().click();
		
	}
	
	@Test(priority=7)
	public void logout() throws Throwable{
		WaitList waitlist = new WaitList(driver);
		waitlist.getAccountButton().click();
		waitlist.getLogoutButton().click();
	}
	
	
	
	
	// DataProvider for above test
	@DataProvider(name = "testDataProvider")
    public Object[][] testData() {
       
        return new Object[][]{
        {"Robert", "564582549","Robert@yopmail.com" }
                
        };
    }
	
	
		
	
}

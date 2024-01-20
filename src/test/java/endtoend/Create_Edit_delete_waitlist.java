package endtoend;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
		login.getEmailTetField().sendKeys(fileUtils.readFromPropertyFile("email"));
		login.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
		login.getLoginButton().click();
		welcome.getWaitlistLink().click();
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
//	dropdown.dropdown(addParty.getTimeDropdown(),"45 Minutes");
//	Thread.sleep(2000);
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//	WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='next']"))));
//	nextBtn.click();
//	
//	driver.findElement(By.xpath("//tr[@id='assign_7']")).click();
//	nextBtn.click();
//	addParty.getClosebuttonatAssignment().click();
		
	}	
	
	
	@Test(priority=2, dataProvider = "testDataProvider")
	public void deleteParty (String name,String Phone, String Email) {
		
		
		EditParty editParty = new EditParty(driver);
		editParty.getEditWaitlistPartylink().click();
		
		//Delete Party
		editParty.getDeleteButton().click();
		editParty.getNoAction().click();
		editParty.getDeleteButton().click();
		editParty.getYesAction().click();
	}
	
	
	@Test(priority=3, dataProvider = "testDataProvider")
	public void checkHistory(String name,String Phone, String Email) {
		
		HistoryPage historyPage = new HistoryPage(driver);		
		WaitList waitList = new WaitList(driver);
		//Check History After Deleting
		waitList.getShowHistoryButton().click(); 
		historyPage.getWaitlistpartyHistory().click();
		
	}
	
	@Test(priority=4, dataProvider = "testDataProvider")
	public void restoreParty(String name,String Phone, String Email) throws Throwable {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		EditParty editParty = new EditParty(driver);
		//Check party is restored
		welcomePage.getWaitlistLink2().click();
		
	}
	
	
	@Test(priority=5, dataProvider = "testDataProvider")
	public void editParty(String name,String Phone, String Email) {
				
		EditParty editParty = new EditParty(driver);
		editParty.getEditWaitlistPartylink().click();	
		editParty.getNameTextField().clear();
		editParty.getNameTextField().sendKeys("Sumit");
		editParty.getPhoneTextField().clear();
		editParty.getPhoneTextField().sendKeys("123456");
		editParty.getEmailTextField().clear();
		editParty.getEmailTextField().sendKeys("Robert@yopmail.com");
		editParty.getNotesTextField().clear();
		editParty.getNotesTextField().sendKeys("abc");
		DropdownUtility dropdown = new DropdownUtility();
		dropdown.dropdown(editParty.getQuotedDropdown(),"3 Hour 15 Minutes");
		editParty.getUpdateLink().click();
		editParty.getAssignment().click();
		editParty.getDoneButton().click();
		editParty.getSize().clear();
		editParty.getSize().sendKeys("8");
		editParty.getColorCode().click();
		
		//closing without saving
		editParty.getCloseButton().click();
	}
	
	
	
	
	
	// DataProvider for above test
	@DataProvider(name = "testDataProvider")
    public Object[][] testData() {
       
        return new Object[][]{
        {"Smith", "564582549","Smith@yopmail.com" }
                
        };
    }
	
	
		
	
}

package endtoend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.waitlist.genericutility.BaseClass;
import com.waitlist.genericutility.DropdownUtility;
import com.waitlist.genericutility.ExcelUtility;
import com.waitlist.genericutility.FileUtility;
import com.waitlist.pomrepo.EditParty;
import com.waitlist.pomrepo.LandingPage;
import com.waitlist.pomrepo.LoginPage;
import com.waitlist.pomrepo.WaitList;
import com.waitlist.pomrepo.WelcomePage;

public class LoginScenarios extends BaseClass {
	
	public FileUtility fileUtils = new FileUtility();
	public ExcelUtility excelUtil = new ExcelUtility();
	public Logger log = LogManager.getLogger(LoginScenarios.class);
	
	
	
	@Test(priority=1)
	public void validCredentials() throws Throwable
	{
	WaitList waitList = new WaitList(driver);
	WelcomePage welcome = new WelcomePage(driver);
	EditParty editParty = new EditParty(driver);
	
	LandingPage land = new LandingPage(driver);	
	land.getLoginButton().click();	
	LoginPage login = new LoginPage(driver);
	login.getEmailTetField().sendKeys(fileUtils.readFromPropertyFile("email"));
	login.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
	login.getLoginButton().click();
	Assert.assertTrue(driver.getCurrentUrl().equals("https://fourtopstaging.appspot.com/welcome")); 
	
	
	welcome.getWaitlistLink().click();
	driver.findElement(By.xpath("//td[text()='Robert']/span[text()='4568972842']")).click();
	
	//Delete Party
	editParty.getDeleteButton().click();
	editParty.getNoAction().click();
	editParty.getDeleteButton().click();
	editParty.getYesAction().click();
	
	//Check History After Deleting
	waitList.getShowHistoryButton().click();
	if(driver.findElement(By.xpath("//span[text()='Robert']")).isDisplayed()) {
		System.out.println("Present");
		//restoring the party
		driver.findElement(By.xpath("//span[text()='Robert']/../../td[7]/div[@class='visual-custom-class style__VisualButtons-ov6qif-1 izPKcx']")).click();
	}
	
	
	//Check party is restored
	driver.findElement(By.xpath("//a[text()='Waitlist']")).click();
	if(driver.findElement(By.xpath("//td[text()='Robert']/span[text()='4568972842']")).isDisplayed()) {
	System.out.println("Present");
	driver.findElement(By.xpath("//td[text()='Robert']/span[text()='4568972842']")).click();
	}
	
	
	//Edit Party
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
	
		
}

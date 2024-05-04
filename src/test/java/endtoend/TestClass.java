package endtoend;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.waitlist.genericutility.BaseClass;
import com.waitlist.genericutility.FileUtility;
import com.waitlist.pomrepo.LandingPage;
import com.waitlist.pomrepo.LoginPage;
import com.waitlist.pomrepo.WaitList;

public class TestClass extends BaseClass {
	public FileUtility fileUtils = new FileUtility();
	public Logger log = LogManager.getLogger(Create_Edit_delete_waitlist.class);
	
	@Test
	public void loginWithValidCredentials() throws IOException {
		
		LandingPage landingPage = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		landingPage.getLoginButton().click();
		log.info("Clicked login button");
		login.getEmailTetField().sendKeys(fileUtils.readFromPropertyFile("email"));
		log.info("Entered email into email text field");
		login.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
		log.info("Entered password into password text field");
		login.getLoginButton().click();
		log.info("Clicked login button");
		WaitList waitlist = new WaitList(driver);
		String userName = waitlist.getAccountButton0().getText();
		Assert.assertEquals(userName, "Hello, Stage Namrata","UserName doesnot match with expected user ");
		waitlist.getAccountButton0().click();
		log.info("Clicked account button");
		waitlist.getLogoutButton().click();
		log.info("Clicked logout button");
	}
}

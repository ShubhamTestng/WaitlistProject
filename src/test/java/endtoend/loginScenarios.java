package endtoend;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.waitlist.genericutility.BaseClass;
import com.waitlist.genericutility.FileUtility;
import com.waitlist.pomrepo.LandingPage;
import com.waitlist.pomrepo.LoginPage;

public class loginScenarios extends BaseClass {
	public FileUtility fileUtils = new FileUtility();
		
	@Test
	public void loginWithValidCredentials() throws IOException {
		
		LandingPage landingPage = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		landingPage.getLoginButton().click();
		login.getEmailTetField().sendKeys(fileUtils.readFromPropertyFile("email"));
		login.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("password"));
		login.getLoginButton().click();
	}
}

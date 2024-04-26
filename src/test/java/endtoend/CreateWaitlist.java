package endtoend;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.waitlist.genericutility.BaseClass;
import com.waitlist.genericutility.DropdownUtility;
import com.waitlist.genericutility.FileUtility;
import com.waitlist.genericutility.JavaScriptUtility;
import com.waitlist.pomrepo.AddParty;
import com.waitlist.pomrepo.LandingPage;
import com.waitlist.pomrepo.LoginPage;
import com.waitlist.pomrepo.WaitList;
import com.waitlist.pomrepo.WelcomePage;

public class CreateWaitlist extends BaseClass {
	

	
	
	public static void main(String [] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		FileUtility fileUtils = new FileUtility();
		DropdownUtility dropdown = new DropdownUtility();
		JavaScriptUtility jse = new JavaScriptUtility();
		WelcomePage welcome = new WelcomePage(driver);
		LandingPage land = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(fileUtils.readFromPropertyFile("produrl"));
		land.getLoginButton().click();
		login.getEmailTetField().sendKeys(fileUtils.readFromPropertyFile("prodemail"));
		login.getPasswordTextField().sendKeys(fileUtils.readFromPropertyFile("prodpass"));
		login.getLoginButton().click();
		welcome.getWaitlistLink().click();
		
		for(int i=161;i<=186;i++) {
		
		WaitList waitList = new WaitList(driver);
		AddParty addParty = new AddParty(driver);
		waitList.getAddPartyButton().click();
		addParty.getNameTextField().sendKeys("ETAParty"+" "+i);
//		addParty.getMemberSize().click();
//		Thread.sleep(1000);
		addParty.getStatusButton().click();
		Thread.sleep(1000);
		addParty.getNotesTextBox().sendKeys("Testing note "+ i);
		Thread.sleep(1000);
		addParty.getNextButton().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tr[@id='assign_"+(i-160)+"']")).click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(1000);
		WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='next']"))));
		Thread.sleep(1000);
		nextBtn.click();
		Thread.sleep(1000);
		WebElement ETAbutton = driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
		ETAbutton.click();
		WebElement time = driver.findElement(By.xpath("//input[@classvalue='stepTime']"));
		Actions action = new Actions(driver);
		action.click(time);
		Thread.sleep(1000);
		action.keyDown(Keys.SHIFT)
	       .keyDown(Keys.HOME)
	       .keyUp(Keys.HOME).keyUp(Keys.SHIFT)
	       .perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.BACK_SPACE)
	       .perform();
		
		
		
		time.sendKeys("10:"+(i-160)+" PM");
		
		
//		String time = String.valueOf((i-150)*5);
//		dropdown.dropdown(addParty.getTimeDropdown(),time);
		Thread.sleep(1000);
		nextBtn.click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		}
		
	}	
	
	    
}


	
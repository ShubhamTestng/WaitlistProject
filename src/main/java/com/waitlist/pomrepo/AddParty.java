package com.waitlist.pomrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddParty {

	WebDriver driver;	
	
	public AddParty(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void synchronised(By locator, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	
	@FindBy(xpath="/html/body/div[4]/div/div[1]/div/div/div[1]/button")
	WebElement closeButton;
		
	@FindBy(xpath="/html/body/div[4]/div/div[1]/div/div/div[1]/h5/span")
	WebElement addPartyLabel;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement nameTextField;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phoneTextField;
	
	@FindBy(xpath="//input[@placeholder='email']")
	WebElement emailTextField;
	
	@FindBy(xpath="//input[@value='6']")
	WebElement	memberSize;
	
	@FindBy(xpath="(//img[contains(@src,\"data:image/png;base64,iVBOR\")])[1]")
	WebElement adultButton;
	
	@FindBy(xpath="(//img[contains(@src,\"data:image/png;base64,iVBOR\")])[2]")
	WebElement kidsButton;
	
	@FindBy(xpath="(//img[contains(@src,\"data:image/png;base64,iVBOR\")])[3]")
	WebElement agedButton;
	
	@FindBy(xpath="(//button[contains(@class,'style__ColoredCircleBtn')])[4]")
	WebElement statusButton;
	
	@FindBy(xpath="//textarea[@name='notes']")
	WebElement notesTextBox;
	
	@FindBy(xpath="//button[text()='next']")
	WebElement nextButton;
	
	
	@FindBy(xpath="//span[text()='ETA']")
	WebElement ETAOption ;
	
	
	public WebElement getETAOption() {
		synchronised(By.xpath("//span[text()='ETA']"),ETAOption);
		return ETAOption;
	}

	public WebElement getETADate() {
		synchronised(By.xpath("//input[@placeholder='Date Calender']"),ETADate);
		return ETADate;
	}

	public WebElement getETATime() {
		synchronised(By.xpath("//input[@classvalue='stepTime']"),ETATime);
		return ETATime;
	}

	public WebElement getETADuration() {
		synchronised(By.name("estimatedDuration"),ETADuration);
		return ETADuration;
	}

	public WebElement getETAnext() {
		synchronised(By.xpath("//button[text()='next']"),ETAnext);
		return ETAnext;
	}

	public WebElement getETAclose() {
		synchronised(By.xpath("//span[text()='Choose Time']/../..//button[@class='close']"),ETAclose);
		return ETAclose;
	}

	@FindBy(xpath="//input[@placeholder='Date Calender']")
	WebElement ETADate;
	
	@FindBy(xpath="//input[@classvalue='stepTime']")
	WebElement ETATime;  
	
	@FindBy(name = "estimatedDuration")
	WebElement ETADuration;
	
	@FindBy(xpath="//button[text()='next']")
	WebElement ETAnext;
	
	@FindBy(xpath="//span[text()='Choose Time']/../..//button[@class='close']")
	WebElement ETAclose;
	
	@FindBy(xpath="//td[text()='8']")
	WebElement ETAassignment;
	
	@FindBy(xpath="(//div[@class='input-group'])[2]")
	WebElement ETAeditTime;
	
	public WebElement getETAeditTime() {
		synchronised(By.xpath("(//div[@class='input-group'])[2]"),ETAeditTime);
		return ETAeditTime;
	}

	public WebElement getETAeditDuration() {
		synchronised(By.xpath("//div[@class='dropdown']/button[@type='button']"),ETAeditDuration);
		return ETAeditDuration;
	}

	public WebElement getETAReturntoWaitlist() {
		synchronised(By.xpath("//button[text()='Return to Waitlist']"),ETAReturntoWaitlist);
		return ETAReturntoWaitlist;

	}

	@FindBy(xpath="//div[@class='dropdown']/button[@type='button']")
	WebElement ETAeditDuration;
	
	@FindBy(xpath="//button[text()='Return to Waitlist']")
	WebElement ETAReturntoWaitlist;
	
	public WebElement getETAassignment() {
		synchronised(By.xpath("//td[text()='8']"),ETAassignment);
		return ETAassignment;
	}

	public WebElement getClosebuttonatTime() {
		synchronised(By.xpath("//span[text()='Choose Time']/../..//button[@class='close']"),closebuttonatTime);
		return closebuttonatTime;
	}

	public WebElement getTimeDropdown() {
		synchronised(By.name("waitTime"),timeDropdown);
		return timeDropdown;
	}

	@FindBy(xpath="//span[text()='Choose Time']/../..//button[@class='close']")
	WebElement closebuttonatTime;
	
	@FindBy(name="waitTime")
	WebElement timeDropdown;
	
	
	@FindBy(xpath="//h5[text()='Assignments']/../..//button[@class='close']")
	WebElement closebuttonatAssignment;
	
	public WebElement getClosebuttonatAssignment() {
		synchronised(By.xpath("//h5[text()='Assignments']/../..//button[@class='close']"),closebuttonatAssignment);
		return closebuttonatAssignment;
		}

	public WebElement getCloseButton() {
		synchronised(By.xpath("/html/body/div[4]/div/div[1]/div/div/div[1]/button"),closeButton);
		return closeButton;
	}

	public WebElement getAddPartyLabel() {
		synchronised(By.xpath("/html/body/div[4]/div/div[1]/div/div/div[1]/h5/span"),addPartyLabel);
		return addPartyLabel;
	}

	public WebElement getNameTextField() {
		synchronised(By.xpath("//input[@name='name']"),nameTextField);
		return nameTextField;
	}

	public WebElement getPhoneTextField() {
		synchronised(By.xpath("//input[@name='phone']"),phoneTextField);
		return phoneTextField;
	}

	public WebElement getEmailTextField() {
		synchronised(By.xpath("//input[@placeholder='email']"),emailTextField);
		return emailTextField;
	}

	public WebElement getMemberSize() {
		synchronised(By.xpath("//input[@value='6']"),memberSize);
		return memberSize;
	}

	public WebElement getAdultButton() {
		synchronised(By.xpath("(//img[contains(@src,\\\"data:image/png;base64,iVBOR\\\")])[1]"),adultButton);
		return adultButton;
	}

	public WebElement getKidsButton() {
		synchronised(By.xpath("(//img[contains(@src,\\\"data:image/png;base64,iVBOR\\\")])[2]"),kidsButton);
		return kidsButton;
	}

	public WebElement getAgedButton() {
		synchronised(By.xpath("(//img[contains(@src,\\\"data:image/png;base64,iVBOR\\\")])[3]"),agedButton);
		return agedButton;
	}

	public WebElement getStatusButton() {
		synchronised(By.xpath("(//button[contains(@class,'style__ColoredCircleBtn')])[4]"),statusButton);
		return statusButton;
	}

	public WebElement getNotesTextBox() {
		synchronised(By.xpath("//textarea[@name='notes']"),notesTextBox);
		return notesTextBox;
	}

	public WebElement getNextButton() {
		synchronised(By.xpath("//button[text()='next']"),nextButton);
		return nextButton;
	}
}

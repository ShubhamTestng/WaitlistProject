package com.waitlist.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddParty {

	WebDriver driver;	
	public AddParty(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	
	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getAddPartyLabel() {
		return addPartyLabel;
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getMemberSize() {
		return memberSize;
	}

	public WebElement getAdultButton() {
		return adultButton;
	}

	public WebElement getKidsButton() {
		return kidsButton;
	}

	public WebElement getAgedButton() {
		return agedButton;
	}

	public WebElement getStatusButton() {
		return statusButton;
	}

	public WebElement getNotesTextBox() {
		return notesTextBox;
	}

	public WebElement getNextButton() {
		return nextButton;
	}
}

package com.waitlist.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.waitlist.genericutility.DropdownUtility;

public class EditParty {

	WebDriver driver;	
	public EditParty(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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

	public WebElement getNotesTextField() {
		return notesTextField;
	}

	public WebElement getQuotedDropdown() {
		return quotedDropdown;
	}

	public WebElement getUpdateLink() {
		return updateLink;
	}

	public WebElement getAssignment() {
		return assignment;
	}

	public WebElement getDoneButton() {
		return doneButton;
	}

	public WebElement getColorCode() {
		return colorCode;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	@FindBy(name="name")
	private WebElement nameTextField;
	
	@FindBy(name="phone")
	private WebElement phoneTextField;
	
	@FindBy(xpath="//label[text()='Email']/..//input[@name='email']")
	private WebElement emailTextField;
	
	@FindBy(name="notes")
	private WebElement notesTextField;
		
	@FindBy(xpath = "//select[@name='quoted']")
	private WebElement quotedDropdown;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateLink;
	
	@FindBy(xpath="//tr[@id='assign_9']")
	private WebElement assignment;
	
	@FindBy(xpath="//button[text()='Done']")
	private WebElement doneButton;
	
	@FindBy(xpath="//button[contains(@class,'hPSPjo btn btn-outline-#f42e00')]")
	private WebElement colorCode;
	
	@FindBy(xpath="//button[@data-tip='Save Info']")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[@data-tip='Delete Customer']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//button[@data-tip='Close']")
	private WebElement closeButton;
	
	@FindBy(xpath="//input[@name='customSize']")
	private WebElement size;
	
	@FindBy(xpath="//button[text()='No']")
	private WebElement noAction;
	
	public WebElement getNoAction() {
		return noAction;
	}

	public WebElement getYesAction() {
		return yesAction;
	}

	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesAction;
	
	public WebElement getSize() {
		return size;
	}
}

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

import com.waitlist.genericutility.DropdownUtility;

public class EditParty {

	WebDriver driver;	
	public EditParty(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void synchronised(By locator, WebElement element)  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		try {
		Thread.sleep(1000); }
		catch (InterruptedException e) {
		e.printStackTrace();	
		}
		}
	
	
	
	public WebElement getNameTextField() {
		synchronised(By.name("name"),nameTextField);
		return nameTextField;
	}

	public WebElement getPhoneTextField() {
		synchronised(By.name("phone"),phoneTextField);
		return phoneTextField;
	}

	public WebElement getEmailTextField() {
		synchronised(By.xpath("//label[text()='Email']/..//input[@name='email']"),emailTextField);
		return emailTextField;
	}

	public WebElement getNotesTextField() {
		synchronised(By.name("notes"),notesTextField);
		return notesTextField;
	}

	public WebElement getQuotedDropdown() {
		synchronised(By.xpath("//select[@name='quoted']"),quotedDropdown);
		return quotedDropdown;
	}

	public WebElement getUpdateLink() {
		synchronised(By.xpath("//button[text()='Update']"),updateLink);
		return updateLink;
	}

	public WebElement getAssignment() {
		synchronised(By.xpath("//tr[@id='assign_9']"),assignment);
		return assignment;
	}

	public WebElement getDoneButton() {
		synchronised(By.xpath("//button[text()='Done']"),doneButton);
		return doneButton;
	}

	public WebElement getColorCode() {
		synchronised(By.xpath("//button[contains(@class,'hPSPjo btn btn-outline-#f42e00')]"),colorCode);
		return colorCode;
	}

	public WebElement getSaveButton() {
		synchronised(By.xpath("//button[@data-tip='Save Info']"),saveButton);
		return saveButton;
	}

	public WebElement getDeleteButton() {
		synchronised(By.xpath("//button[@data-tip='Delete Customer']"),deleteButton);
		return deleteButton;
	}

	public WebElement getCloseButton() {
		synchronised(By.xpath("//button[@data-tip='Close']"),closeButton);
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
		synchronised(By.xpath("//button[text()='No']"),noAction);
		return noAction;
	}

	public WebElement getYesAction() {
		synchronised(By.xpath("//button[text()='Yes']"),yesAction);
		return yesAction;
	}

	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesAction;
	
	public WebElement getSize() {
		synchronised(By.xpath("//input[@name='customSize']"),size);
		return size;
	}

	@FindBy(xpath="//td[text()='Robert']")
	WebElement editWaitlistPartylink;
	
	public WebElement getEditWaitlistPartylink() {
		synchronised(By.xpath("//td[text()='Robert']"),editWaitlistPartylink);
		return editWaitlistPartylink;
	}
	
	@FindBy(xpath="//td[text()='Robert']")
	WebElement editWaitlistPartylink2;
	
	public WebElement getEditWaitlistPartylink2() {
		synchronised(By.xpath("//td[text()='Sumit']"),editWaitlistPartylink2);
		return editWaitlistPartylink2;
	}
	
	


}

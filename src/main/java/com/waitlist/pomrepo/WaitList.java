package com.waitlist.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WaitList {
	
	WebDriver driver;
	public WaitList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//button[@data-tip='Settings']")
	WebElement settingsButton;

	@FindBy(xpath="//button[@data-tip='Show History']")
	WebElement showHistoryButton;
	
	@FindBy(xpath="//button[@data-tip='Add Party']")
	WebElement addPartyButton;
	
	
	public WebElement getAddPartyButton() {
		return addPartyButton;
	}

	public WebElement getSettingsButton() {
		return settingsButton;
	}

	public WebElement getShowHistoryButton() {
		return showHistoryButton;
	}
	
	
}

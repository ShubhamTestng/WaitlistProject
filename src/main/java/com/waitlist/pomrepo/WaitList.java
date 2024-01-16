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
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/div[3]/button[1]/i")
	WebElement settingsButton;

	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/div[3]/button[2]/i")
	WebElement showHistoryButton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/div[3]/button[3]/i")
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

package com.waitlist.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	WebDriver driver;	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//a[text()='Waitlist']")
	WebElement waitlistLink;
	
	@FindBy(xpath="/html/body/div/header/div[2]/div[1]/div[1]/div[2]/div/nav/div[2]/ul/li[2]/a")
	WebElement analyticsLink;
	
	@FindBy(xpath="//*[@id=\"navigationarea\"]/div[2]/ul/li[3]/a")
	WebElement accountLink;
	
	@FindBy(xpath="//*[@id=\"navigationarea\"]/div[2]/ul/li[4]/a")
	WebElement helpLink;
	
	@FindBy(xpath="//*[@id=\"greeting\"]")
	WebElement greetingLink;
	
	@FindBy(xpath="/html/body/div/header/div[2]/div[1]/div[2]/div/div[2]/a")
	WebElement myPlacesLink;
	
	@FindBy(xpath="/html/body/div/header/div[2]/div[1]/div[1]/div[1]/div/a/img")
	WebElement waitListLogo;
	
	public WebElement getWaitlistLink() {
		return waitlistLink;
	}

	public WebElement getAnalyticsLink() {
		return analyticsLink;
	}

	public WebElement getAccountLink() {
		return accountLink;
	}

	public WebElement getHelpLink() {
		return helpLink;
	}

	public WebElement getGreetingLink() {
		return greetingLink;
	}

	public WebElement getMyPlacesLink() {
		return myPlacesLink;
	}

	public WebElement getWaitListLogo() {
		return waitListLogo;
	}
	
	
	
}

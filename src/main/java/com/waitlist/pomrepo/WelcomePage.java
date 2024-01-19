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

public class WelcomePage {

	WebDriver driver;	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void synchronised(By locator, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
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
	
	
	@FindBy(xpath="//a[text()='Waitlist']")
	WebElement waitlistLink2;
	
	
	public WebElement getWaitlistLink2() {
		synchronised(By.xpath("//a[text()='Waitlist']"),waitlistLink2);
		return waitlistLink2;
	}

	public WebElement getWaitlistLink() {
		synchronised(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Waitlist']"),waitlistLink);
		return waitlistLink;
	}

	public WebElement getAnalyticsLink() {
		synchronised(By.xpath("/html/body/div/header/div[2]/div[1]/div[1]/div[2]/div/nav/div[2]/ul/li[2]/a"),analyticsLink);
		return analyticsLink;
	}

	public WebElement getAccountLink() {
		synchronised(By.xpath("//*[@id=\"navigationarea\"]/div[2]/ul/li[3]/a"),accountLink);
		return accountLink;
	}

	public WebElement getHelpLink() {
		synchronised(By.xpath("//*[@id=\"navigationarea\"]/div[2]/ul/li[4]/a"),helpLink);
		return helpLink;
	}

	public WebElement getGreetingLink() {
		synchronised(By.xpath("//*[@id=\"greeting\"]"),greetingLink);
		return greetingLink;
	}

	public WebElement getMyPlacesLink() {
		synchronised(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/div/div[2]/a"),myPlacesLink);
		return myPlacesLink;
	}

	public WebElement getWaitListLogo() {
		synchronised(By.xpath("/html/body/div/header/div[2]/div[1]/div[1]/div[1]/div/a/img"),waitListLogo);
		return waitListLogo;
	}
	
	
	
}

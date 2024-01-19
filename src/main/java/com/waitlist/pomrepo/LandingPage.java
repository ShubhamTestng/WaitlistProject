package com.waitlist.pomrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	WebDriver driver;	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
		
	public void synchronised(By locator, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
		
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginButton;
	
	public WebElement getLoginButton() {
		
		synchronised(By.xpath("//a[text()='Login']"),loginButton);
		return loginButton;
	}
	
			
	
}

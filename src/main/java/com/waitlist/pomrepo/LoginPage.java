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

public class LoginPage {

	private WebDriver driver;	
		
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void synchronised(By locator, WebElement element)  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		try {
		Thread.sleep(1500); }
		catch (InterruptedException e) {
		e.printStackTrace();	
		}
		}
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(name="Submit")
	private WebElement loginButton;
	
	public WebElement getEmailTetField() {
		synchronised(By.id("email"),emailTextField);
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		synchronised(By.id("password"),passwordTextField);
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		synchronised(By.name("Submit"),loginButton);
		return loginButton;
	}
	}

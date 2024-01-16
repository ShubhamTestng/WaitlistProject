package com.waitlist.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(id="email")
	WebElement emailTetField;
	
	@FindBy(id="password")
	WebElement passwordTextField;
	
	@FindBy(name="Submit")
	WebElement loginButton;
	
	public WebElement getEmailTetField() {
		return emailTetField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	}

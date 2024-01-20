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

public class HistoryPage {

	
	WebDriver driver;	
	public HistoryPage(WebDriver driver) {
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
		
	
	@FindBy(xpath="//a[text()='Waitlist']")
	WebElement waitlistLinkHistoryPage;
	
	public WebElement getWaitlistLinkHistoryPage() {
		synchronised(By.xpath("//a[text()='Waitlist']"),waitlistLinkHistoryPage);
		return waitlistLinkHistoryPage;
	}
	
	@FindBy(xpath="//span[text()='Robert']/../../td[7]/div[@class='visual-custom-class style__VisualButtons-ov6qif-1 izPKcx']")
	WebElement waitlistpartyHistory;
	
	public WebElement getWaitlistpartyHistory() {
		synchronised(By.xpath("//span[text()='Robert']/../../td[7]/div[@class='visual-custom-class style__VisualButtons-ov6qif-1 izPKcx']"),waitlistpartyHistory);
		return waitlistpartyHistory;
	}
	
	
	@FindBy(xpath="//span[text()='Richard']/../../td[7]/div[@class='visual-custom-class style__VisualButtons-ov6qif-1 izPKcx']")
	WebElement waitlistpartyHistory2;
	
	public WebElement getWaitlistpartyHistory2() {
		synchronised(By.xpath("//span[text()='Richard']/../../td[7]/div[@class='visual-custom-class style__VisualButtons-ov6qif-1 izPKcx']"),waitlistpartyHistory2);
		return waitlistpartyHistory2;
	}
	
	
	@FindBy(xpath="//td[text()='Richard']")
	WebElement waitlistpartyHistory3;

	public WebElement getWaitlistpartyHistory3() {
		synchronised(By.xpath("//td[text()='Richard']"),waitlistpartyHistory3);
		return waitlistpartyHistory3;
	}
	
	
	
}

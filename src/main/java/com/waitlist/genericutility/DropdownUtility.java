package com.waitlist.genericutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {
	public void dropdown(WebElement locator,String text) {
		Select dropSelect = new Select(locator);
		dropSelect.selectByVisibleText(text);
	}
}

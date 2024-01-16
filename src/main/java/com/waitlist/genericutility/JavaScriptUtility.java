package com.waitlist.genericutility;

import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptUtility extends BaseClass {

	public void execute(String jseScript) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(jseScript);
	}
}

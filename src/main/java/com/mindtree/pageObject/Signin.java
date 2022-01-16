package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.UIsignIn;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class Signin extends UIsignIn{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public Signin(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}

	public void Button(String uid, String pw) throws ReusableComponentException, Exception {
		try {
			WebDriverSupport.click(driver, button, "button","button", log, test);
			WebDriverSupport.click(driver, id, "id","name", log, test);
			WebDriverSupport.sendKeys(driver, id, "id", "name", log, test, uid);
			WebDriverSupport.click(driver, pwd, "pwd","pass", log, test);
			WebDriverSupport.sendKeys(driver, pwd, "pwd", "pass", log, test, pw);
			WebDriverSupport.click(driver, login, "login","click", log, test);
			if (driver.findElement(name).isDisplayed()) {
				ExtentLogUtilities.pass(driver, test, "Successfully logged in", log);
				
			} else {
				ExtentLogUtilities.fail(driver, test, "logged in failed", log);
				throw new PageObjectException("Logged in failed");
			}
		} catch (Exception e) {
			throw new PageObjectException(e.getMessage());
		}
	}

}

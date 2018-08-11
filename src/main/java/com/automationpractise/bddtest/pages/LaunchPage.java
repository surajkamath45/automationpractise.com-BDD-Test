package com.automationpractise.bddtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class of the Launch page before signing in
 *
 */
public class LaunchPage {

	private WebDriver driver;

	@FindBy(className = "login")
	private WebElement signin;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public LaunchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/**
	 * Method to launch the application
	 * 
	 * @param launchURL
	 *            String representation of the Launch page URL
	 */
	public void navToLaunch(String launchURL) {
		this.driver.get(launchURL);
		signin.click();

	}
}

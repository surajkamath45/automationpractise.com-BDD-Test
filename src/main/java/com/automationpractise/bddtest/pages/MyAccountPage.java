package com.automationpractise.bddtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class of MyAccount Page
 *
 */
public class MyAccountPage {

	private WebDriver driver;

	@FindBy(css = "a[title= 'Information']")
	private WebElement personInfoBtn;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/**
	 * Method to navigate to Personal Information Page
	 */
	public void navToPersonalInfo() {
		personInfoBtn.click();
	}

}

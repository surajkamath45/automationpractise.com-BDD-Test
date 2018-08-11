package com.automationpractise.bddtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class of the Home page
 *
 */
public class HomePage {

	private WebDriver driver;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement teeLink;

	@FindBy(className = "account")
	private WebElement userAccount;

	@FindBy(className = "logout")
	private WebElement signOut;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	/**
	 * Method to navigate to T-Shirts page
	 */
	public void navToTee() {
		teeLink.click();
	}

	/**
	 * Method to navigate to the MyAccount page
	 */
	public void navToAccount() {
		userAccount.click();
	}

	/**
	 * Method to logout from the application
	 */
	public void logout() {
		signOut.click();
	}

}

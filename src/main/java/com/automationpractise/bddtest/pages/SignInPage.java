package com.automationpractise.bddtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class of the Sign In page
 *
 */
public class SignInPage {

	private WebDriver driver;
	private static String pswd;
	private JavascriptExecutor jse;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement submit;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		jse = (JavascriptExecutor) driver;
	}

	/**
	 * Method to Sign in to the application
	 * 
	 * @param userName
	 *            Username of the customer trying to login
	 * @param pwd
	 *            Password of the customer trying to login
	 */
	public void signIn(String userName, String pwd) {

		pswd = pwd;

		jse.executeScript("arguments[0].scrollIntoView();", email);
		email.sendKeys(userName);
		password.sendKeys(pwd);
		submit.click();
	}

	/**
	 * Getter method to get the password. This method id useful when updating
	 * the personal information where entering the password is mandatory.
	 * 
	 * @return Password
	 */
	public String getPassword() {
		return pswd;
	}

}

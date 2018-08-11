package com.automationpractise.bddtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Page class of the Personal Information page
 *
 */
public class PersonalInfoPage {

	private WebDriver driver;
	private JavascriptExecutor jse;
	private WebDriverWait wait;

	@FindBy(css = "input#firstname")
	private WebElement firstName;

	@FindBy(css = "input#old_passwd")
	private WebElement oldPassword;

	@FindBy(css = "button[name= 'submitIdentity']")
	private WebElement saveBtn;

	@FindBy(css = "p[class= 'alert alert-success']")
	private WebElement updateCnfmMsg;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		jse = (JavascriptExecutor) driver;
		wait= new WebDriverWait(this.driver, 30);

	}

	/**
	 * Method to update the first name in personal information page
	 */
	public void updateFirstName() {
		firstName.clear();
		firstName.sendKeys("TestHarry");
		jse.executeScript("arguments[0].scrollIntoView();", oldPassword);
		String password = new SignInPage(driver).getPassword();
		oldPassword.sendKeys(password);
		saveBtn.click();

	}

	/**
	 * Method to check whether thee first name has been successfully updated
	 */
	public void checkUpdateSuccessful() {
		wait.until(ExpectedConditions.visibilityOf(updateCnfmMsg));
		String actualMessage= updateCnfmMsg.getText();
		Assert.assertEquals(actualMessage, "Your personal information has been successfully updated.");
	}

}

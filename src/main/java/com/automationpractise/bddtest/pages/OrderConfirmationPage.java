package com.automationpractise.bddtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Page class of the order confirmation page
 *
 */
public class OrderConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindAll({ @FindBy(xpath = "//p[@class= 'cheque-indent']//strong"),
			@FindBy(xpath = "//p[@class= 'alert alert-success']") })
	private WebElement cnfmMsg;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 30);
	}

	/**
	 * Method to check whether the order has been placed successfully
	 */
	public void checkOrderConfirmation() {

		wait.until(ExpectedConditions.visibilityOf(cnfmMsg));
		String actualMessage = cnfmMsg.getText();
		Assert.assertEquals(actualMessage, "Your order on My Store is complete.");
	}

}

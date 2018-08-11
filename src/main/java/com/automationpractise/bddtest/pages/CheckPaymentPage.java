package com.automationpractise.bddtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class of the Payment by Check page
 *
 */
public class CheckPaymentPage {

	private WebDriver driver;
	JavascriptExecutor jse;

	@FindBy(css = "button[class='button btn btn-default button-medium']")
	private WebElement confirmOrder;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public CheckPaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		jse = (JavascriptExecutor) driver;

	}

	/**
	 * Method to confirm the order that is being placed
	 */
	public void confirmOrder() {
		jse.executeScript("arguments[0].scrollIntoView();", confirmOrder);
		confirmOrder.click();
	}

}

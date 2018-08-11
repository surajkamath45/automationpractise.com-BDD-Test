package com.automationpractise.bddtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class of the Order Address page
 *
 */
public class OrderAddressPage {

	private WebDriver driver;
	JavascriptExecutor jse;

	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
	private WebElement proceedToCheckout;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public OrderAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		jse = (JavascriptExecutor) driver;

	}

	/**
	 * Method to proceed to checkout
	 */
	public void proceedToCheckOut() {
		jse.executeScript("arguments[0].scrollIntoView();", proceedToCheckout);
		proceedToCheckout.click();

	}

}

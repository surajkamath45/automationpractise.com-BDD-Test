package com.automationpractise.bddtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class of the Order Shipping Page
 *
 */
public class OrderShipppingPage {

	private WebDriver driver;
	JavascriptExecutor jse;

	@FindBy(css = "input[type='checkbox'][name='cgv']")
	private WebElement agreeToTerms;

	@FindBy(css = "button[type='submit'][name= 'processCarrier']")
	private WebElement proceedToCheckout;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public OrderShipppingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		jse = (JavascriptExecutor) driver;

	}

	/**
	 * Method to accept the terms and conditions of the application and proceed
	 * to checkout
	 */
	public void acceptAndProceed() {
		jse.executeScript("arguments[0].scrollIntoView();", agreeToTerms);
		agreeToTerms.click();
		proceedToCheckout.click();
	}

}

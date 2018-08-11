package com.automationpractise.bddtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class of the Payment Method selection page
 *
 */
public class PaymentMethodPage {

	private WebDriver driver;
	JavascriptExecutor jse;

	@FindBy(css = "a.bankwire")
	private WebElement bankWire;

	@FindBy(css = "a.cheque")
	private WebElement cheque;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public PaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		jse = (JavascriptExecutor) driver;

	}

	/**
	 * Method to select the mode of payment. The method randomly selects either
	 * Wire mode or Check Mode.
	 */
	public void selectPaymentMethod() {
		int x = (int) Math.ceil(Math.random() * 2);
		if (x == 1) {
			jse.executeScript("arguments[0].scrollIntoView();", bankWire);
			bankWire.click();
			new BankWirePaymentPage(this.driver).confirmOrder();
		} else {
			jse.executeScript("arguments[0].scrollIntoView();", cheque);
			cheque.click();
			new CheckPaymentPage(this.driver).confirmOrder();
		}
	}

}

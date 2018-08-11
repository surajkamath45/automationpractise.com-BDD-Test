package com.automationpractise.bddtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page class of the TShirt selection page
 *
 */
public class TShirtsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "img[src*= 'loader']")
	private WebElement loader;

	@FindBy(css = "span.available-now")
	private WebElement inStockBtn;

	@FindBy(xpath = "//span[text()= 'Add to cart']")
	private WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	private WebElement proceedToCheckout;

	/**
	 * Constructor used to initialize the page elements in the page class
	 * 
	 * @param driver
	 *            WebDriver instance passed from the caller test class
	 */

	public TShirtsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 30);
	}

	/**
	 * Method to select the size of the T-Shirt. The selection of the T-Shirt size has been randomized.
	 */
	public void selectSize() {

		String cssExp_size = "input[type= 'checkbox'][name*= 'layered_id_attribute_group_"
				+ ((int) Math.ceil(Math.random() * 3)) + "']";
		driver.findElement(By.cssSelector(cssExp_size)).click();
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}

	/**
	 * Method to select a T-Shirt, add it to the card and proceed with the checkout
	 */
	public void addItemToCart() {

		Actions acts = new Actions(this.driver);
		acts.moveToElement(inStockBtn).build().perform();
		addToCart.click();

		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		acts.moveToElement(proceedToCheckout);
		proceedToCheckout.click();

	}

}

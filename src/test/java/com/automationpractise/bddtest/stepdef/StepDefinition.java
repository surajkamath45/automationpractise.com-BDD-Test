package com.automationpractise.bddtest.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automationpractise.bddtest.pages.BankWirePaymentPage;
import com.automationpractise.bddtest.pages.CheckPaymentPage;
import com.automationpractise.bddtest.pages.HomePage;
import com.automationpractise.bddtest.pages.LaunchPage;
import com.automationpractise.bddtest.pages.MyAccountPage;
import com.automationpractise.bddtest.pages.OrderAddressPage;
import com.automationpractise.bddtest.pages.OrderConfirmationPage;
import com.automationpractise.bddtest.pages.OrderShipppingPage;
import com.automationpractise.bddtest.pages.PaymentMethodPage;
import com.automationpractise.bddtest.pages.PersonalInfoPage;
import com.automationpractise.bddtest.pages.ShoppingCartSummaryPage;
import com.automationpractise.bddtest.pages.SignInPage;
import com.automationpractise.bddtest.pages.TShirtsPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Step Definition class which defines each step given in the feature files 
 *
 */
public class StepDefinition {

	public static WebDriver driver;

	BankWirePaymentPage payByWirePage = new BankWirePaymentPage(driver);
	SignInPage signinPage = new SignInPage(driver);
	CheckPaymentPage payByCheckPage = new CheckPaymentPage(driver);
	HomePage homePage = new HomePage(driver);
	MyAccountPage accountPage = new MyAccountPage(driver);
	OrderAddressPage orderAddressPage = new OrderAddressPage(driver);
	OrderConfirmationPage orderCnfmPage = new OrderConfirmationPage(driver);
	OrderShipppingPage orderShipPage = new OrderShipppingPage(driver);
	PaymentMethodPage paymentPage = new PaymentMethodPage(driver);
	PersonalInfoPage personalInfoPage = new PersonalInfoPage(driver);
	ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
	TShirtsPage tShirtsPage = new TShirtsPage(driver);
	LaunchPage launchPage = new LaunchPage(driver);

	static {
		if (driver==null) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			String currWin = driver.getWindowHandle();

			for (String winHndl : driver.getWindowHandles())
				if (!winHndl.equals(currWin))
					driver.switchTo().window(winHndl).close();
			driver.switchTo().window(currWin);
		}
	}

	@Given("^the customer launches the website \"([^\"]*)\"$")
	public void the_customer_launches_the_website(String launchURL) throws Throwable {
		launchPage.navToLaunch(launchURL);
	}

	@Given("^the customer enters the username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void the_customer_enters_the_username_and_password(String userName, String pwd) throws Throwable {
		signinPage.signIn(userName, pwd);
	}

	@When("^The customer navigates to Tee shirt page$")
	public void the_customer_navigates_to_Tee_shirt_page() throws Throwable {
		homePage.navToTee();
	}

	@When("^the customer adds a tshirt to his cart$")
	public void the_customer_adds_a_tshirt_to_his_cart() throws Throwable {
		tShirtsPage.selectSize();
		tShirtsPage.addItemToCart();
	}

	@When("^The customer places an order$")
	public void the_customer_places_an_order() throws Throwable {
		shoppingCartSummaryPage.proceedToCheckOut();
		orderAddressPage.proceedToCheckOut();
		orderShipPage.acceptAndProceed();
		paymentPage.selectPaymentMethod();
	}

	@Then("^The order should be successfully placed$")
	public void the_order_should_be_successfully_placed() throws Throwable {
		orderCnfmPage.checkOrderConfirmation();
	}

	@When("^The customer navigates to the personal information page$")
	public void the_customer_navigates_to_the_personal_information_page() throws Throwable {
		homePage.navToAccount();
	}

	@When("^the customer updates the first name$")
	public void the_customer_updates_the_first_name() throws Throwable {
		accountPage.navToPersonalInfo();
		personalInfoPage.updateFirstName();
	}

	@Then("^the information should be successfully updated$")
	public void the_information_should_be_successfully_updated() throws Throwable {
		personalInfoPage.checkUpdateSuccessful();
	}

	
	@After
	public void afterHook(){
		homePage.logout();
	}
}

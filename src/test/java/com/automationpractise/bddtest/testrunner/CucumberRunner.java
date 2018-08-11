package com.automationpractise.bddtest.testrunner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractise.bddtest.stepdef.StepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * 
 * @author Suraj Rajendra Kamath 
 */

/**
 * 
 * The Cucumber Test Runner class which is implemented using
 * TestNGCucumberRunner. This is where the execution starts. This class reads
 * each scenario that is available in each of the feature file in our features
 * package and "glues" it with the StepDefinition class.
 */

@CucumberOptions(features = "src//main//resources//features", glue = "com.automationpractise.bddtest.stepdef", plugin = {
		"pretty", "html:target/Destination" }, monochrome = true, strict = true)
public class CucumberRunner {

	TestNGCucumberRunner cukeRunner;

	/**
	 * Method to setup the Cucumber test
	 */
	@BeforeTest
	public void setupTest() {
		cukeRunner = new TestNGCucumberRunner(this.getClass());
	}

	/**
	 * The data provider method that supplies the Cucumber features to the test
	 * method
	 * 
	 * @return The cucumber features as CucumberFeatureWrapper after reading
	 *         each of them from the feature files
	 */
	@DataProvider
	public Object[][] provider() {
		return cukeRunner.provideFeatures();
	}

	/**
	 * The test method that executes the cucumber features.
	 * 
	 * @param cukeFeatWrapper
	 *            The Cucumber Features supplied through the data provider
	 */
	@Test(dataProvider = "provider")
	public void runCuke(CucumberFeatureWrapper cukeFeatWrapper) {
		cukeRunner.runCucumber(cukeFeatWrapper.getCucumberFeature());
	}

	/**
	 * Method to tear down the test
	 */
	@AfterTest
	public void teardownTest() {
		cukeRunner.finish();
		StepDefinition.driver.quit();

	}

}

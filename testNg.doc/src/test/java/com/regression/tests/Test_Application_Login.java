package com.regression.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pages.objects.LoginPage;
import com.reusable.helpers.CaptureScreenshot;
import com.reusable.helpers.InitializeDriver;
import com.reusable.helpers.ReadPropertiesFile;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;

public class Test_Application_Login {

	WebDriver driver;
	int waitUntilSleep;
	WebDriverWait wait;
	Actions actions;
	String releaseNo;

	private static Logger logger = LogManager.getLogger(Test_Application_Login.class);

	static {
		System.setProperty("logFileName", "Test_Application_Login");
	}

	@BeforeTest
	public void setUp() {

		logger.info("Setup Step");
		// Read Sleep time from properties file
		waitUntilSleep = Integer
				.parseInt(new ReadPropertiesFile().readPropertiesFile("executionConf", "waitUntilSleep"));
		releaseNo = new ReadPropertiesFile().readPropertiesFile("executionConf", "releaseNo");
		// Call InitializeDriver class
		InitializeDriver driverObj = new InitializeDriver();

		// Driver is initialized
		logger.info("Initilizing Chrome WebDriver");
		driver = driverObj.InitializeChromeDriver();
		logger.info("Sleep Time " + waitUntilSleep);
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitUntilSleep));
		logger.info("Initilizing Actions Class");
		actions = new Actions(driver);
	}

	@Test(priority = 1, description = "Login", enabled = true)
	public void Step_1() throws InterruptedException {

		ReadPropertiesFile readProperties = new ReadPropertiesFile();
		String url = readProperties.readPropertiesFile("testUrls", "testUrl1");

		logger.info("Launching URL - " + url);
		driver.get(url);

		ReadPropertiesFile readTestData = new ReadPropertiesFile();
		String userNameVal = readTestData.readTestDataPropertiesFile("RegressionTest1", "userName");
		String passWordVal = readTestData.readTestDataPropertiesFile("RegressionTest1", "passWord");

		// Login to Application
		logger.info("Login to Application ");
		logger.info("UserName " + userNameVal);
		logger.info("Password " + passWordVal);
		LoginPage loginpageObj = new LoginPage();
		loginpageObj.enterUserName(userNameVal, driver, wait);
		loginpageObj.enterPassword(passWordVal, driver, wait);
		loginpageObj.clickOnLoginBtn(driver, wait);

		Thread.sleep(5000);

	}

	@AfterTest
	public void tearDown() {
		logger.info("Quit Execution");
		driver.quit();
	}

	@AfterMethod
	public void captureScreen(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.SUCCESS) {

			CaptureScreenshot.takeScreenshot(driver, testResult.getName(), releaseNo, this.getClass().getName());

		}

		if (testResult.getStatus() == ITestResult.FAILURE) {

			CaptureScreenshot.takeScreenshot(driver, "Step_1_Failed", "R_1", "Regression_Test_1");

		}
	}

}

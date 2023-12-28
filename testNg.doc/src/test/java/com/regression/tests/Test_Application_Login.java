package com.regression.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reusable.helpers.ReadPropertiesFile;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

public class Test_Application_Login {

	private static Logger logger = LogManager.getLogger(Test_Application_Login.class);

	WebDriver driver;
	int waitUntilSleep;
	WebDriverWait wait;
	Actions actions;

	static {
		System.setProperty("logPath", "C:/Temp/logs/");
		System.setProperty("logFileName", "Test_Application_Login");
	}

	@BeforeTest
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.setBinary(getChromeLocation());

		options.addArguments("--start-maximized");

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/driver/path");

		options.setExperimentalOption("prefs", prefs);
		// driver = new ChromeDriver();
		driver = new ChromeDriver(options);

		wait = new WebDriverWait(driver, Duration.ofSeconds(waitUntilSleep));
		actions = new Actions(driver);
	}

	private File getChromeLocation() {
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("stable");
		SeleniumManagerOutput.Result output = DriverFinder.getPath(ChromeDriverService.createDefaultService(), options);
		return new File(output.getBrowserPath());
	}

	@Test(priority = 1, description = "Login", enabled = true)
	public void Step_1() {

		ReadPropertiesFile readProperties = new ReadPropertiesFile();
		String url = readProperties.readPropertiesFile("testUrls", "testUrl1");

		logger.info("Launching URL");

		driver.get(url);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod
	public void captureScreen(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.SUCCESS) {

		}

		if (testResult.getStatus() == ITestResult.FAILURE) {

		}
	}

}

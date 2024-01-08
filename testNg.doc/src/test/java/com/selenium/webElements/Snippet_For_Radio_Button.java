package com.selenium.webElements;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reusable.helpers.ReadPropertiesFile;

public class Snippet_For_Radio_Button {
	
	WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger(Snippet_For_Radio_Button.class);

	String url = "https://ultimateqa.com/simple-html-elements-for-automation/";

	@BeforeTest
	public void setup() {

		ChromeOptions options = new ChromeOptions();

		options.setBinary(getChromeLocation());

		options.addArguments("--start-maximized");

		ReadPropertiesFile readProperties = new ReadPropertiesFile();
		String chromeDownloadPath = readProperties.readPropertiesFile("executionConf", "chromeDownloadPath");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", chromeDownloadPath);
		prefs.put("profile.default_content_settings.popups", 0);

		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@Test(priority = 1, description = "Snippet For Radio Button", enabled = true)
	public void test() throws InterruptedException {

		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='radio' and @value='male']")).click();
		Thread.sleep(8000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	private File getChromeLocation() {

		SeleniumManagerOutput.Result output = null;
		try {
			// Setting Chrome Driver Binary
			logger.info("Setting Chrome Driver Binary");
			ChromeOptions options = new ChromeOptions();
			options.setBrowserVersion("stable");
			output = DriverFinder.getPath(ChromeDriverService.createDefaultService(), options);
			logger.info("Binary Path - " + output.getBrowserPath());
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
		}

		return new File(output.getBrowserPath());
	}

}

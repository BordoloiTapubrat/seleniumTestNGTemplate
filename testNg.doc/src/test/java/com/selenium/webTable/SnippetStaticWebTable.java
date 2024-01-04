package com.selenium.webTable;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

public class SnippetStaticWebTable {

	/*
	 * Open URL - https://www.techlistic.com/p/demo-selenium-practice.html Read the
	 * demo table 1's data row by row. And print the values of each cell of the
	 * table.
	 * 
	 */

	WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger(SnippetStaticWebTable.class);

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

	@Test
	public void test() throws InterruptedException {

		/*
		 * Open URL - https://www.techlistic.com/p/demo-selenium-practice.html Read the
		 * demo table 1's data row by row. And print the values of each cell of the
		 * table.
		 * 
		 */
		String url = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
		driver.get(url);

		WebElement table = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='customers']")));

		// Get total rows
		int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();

		// Get total cols
		int cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th")).size();

		System.out.println("Total Rows " + rows);
		System.out.println("Total Columns " + cols);

		System.out.println();

		System.out.println("Printing Table Data");

		//
		System.out.println();
		for (int i = 2; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {

				System.out.print(
						driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]"))
								.getText() + "\t");
			}
			System.out.println();

		}

		Thread.sleep(5000);
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

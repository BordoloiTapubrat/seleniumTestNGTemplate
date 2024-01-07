package com.selenium.webTable;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
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

import com.reusable.helpers.InitializeDriver;
import com.reusable.helpers.ReadPropertiesFile;

public class SnippetDynamicWebTable {

	WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger(SnippetDynamicWebTable.class);

	String url = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";

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

	@Test(priority = 1, description = "dynamic web table 1", enabled = true)
	public void test() throws InterruptedException {
		/*
		 * Open URL - https://www.techlistic.com/p/demo-selenium-practice.html Read the
		 * 'Structure' column and find out the total number of structures present. Read
		 * the value of the 'Total' column and match it with the previous step.
		 */

		driver.get(url);

		WebElement table = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='tsc_table_s13']")));

		// Get columnNo for column Name "Structure"
		int noOfHeadings = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th")).size();
		int structureColIndex = 0;
		for (int i = 1; i <= noOfHeadings; i++) {
			if (driver.findElement(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th")).getText()
					.contentEquals("Structure")) {
				structureColIndex = i;
				break;
			}
		}
		// Get total rows

		int rows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr")).size();

		System.out.println("Total Rows " + rows);

		System.out.println();
		int totalNumberOfStructures = 0;
		System.out.println("Printing all Structures");
		System.out.println();
		for (int i = 1; i <= rows; i++) {
			if (!driver
					.findElement(By
							.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + i + "]/th[" + structureColIndex + "]"))
					.getText().isEmpty()) {
				totalNumberOfStructures++;
			}
			System.out.println(driver
					.findElement(By
							.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + i + "]/th[" + structureColIndex + "]"))
					.getText());

		}

		System.out.println("Total Number Of Structures " + totalNumberOfStructures);

		Thread.sleep(5000);
	}

	@Test(priority = 2, description = "dynamic webtable 2", enabled = true)
	public void test2() {
		/*
		 * Verify that there are only 4 structure values present in the table with
		 * Selenium Verify that the 6th row of the table (Last Row) has only two columns
		 * with Selenium Find the tallest structure in the table with Selenium
		 */

		// Verify that there are only 4 structure values present in the table with
		// Selenium
		driver.get(url);

		WebElement table = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='tsc_table_s13']")));
		System.out.println();
		// Assert 4 Structures
		// Count the no of rows in thead
		int rows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr")).size();
		System.out.println("Rows in thead " + rows);

		// Get the column of for column name structure
		int colNoForStructure = 0;
		for (int i = 1; i <= rows; i++) {
			int cols = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr[" + i + "]/th")).size();
			// System.out.println("Total Columns in row " + i + " -- " + cols);
			for (int j = 1; j <= cols; j++) {
				if (driver.findElement(By.xpath("//table[@class='tsc_table_s13']/thead/tr[" + i + "]/th[" + j + "]"))
						.getText().equalsIgnoreCase("Structure"))
					;
				colNoForStructure = j;
				break;
			}
		}
		System.out.println();
		System.out.println("Column No for Structure Column " + colNoForStructure);

		// Count the no of rows in the table
		int rowsTbody = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr")).size();
		// System.out.println("Rows in tbody " + rowsTbody);
		System.out.println();
		int structuresCount = 0;
		System.out.println("Values in Structure Column " + colNoForStructure);
		System.out.println();
		for (int i = 1; i <= rowsTbody; i++) {
			if (!driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + i + "]/th")).getText()
					.isEmpty()) {
				System.out.println(driver
						.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + i + "]/th")).getText());
				structuresCount++;
			}

		}
		System.out.println();
		System.out.println("Total Structures Count " + structuresCount);

		assert structuresCount == 4;

		System.out.println();
	}

	@Test(priority = 3, description = "dynamic webtable 3", enabled = true)
	public void test3() {

		/*
		 * Selenium Verify that the 6th row of the table (Last Row) has only two columns
		 */

		driver.get(url);

		// Verify that the 6th row of the table (Last Row) has only two columns with

		WebElement table = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='tsc_table_s13' and @summary='Sample Table']")));

		System.out.println("Find the last row in the table - Method 1");
		System.out.println();
		// Find the last row in the table
		List<WebElement> kw = table.findElements(By.xpath("//tfoot//tr[last()]"));
		int total = 0;
		int columns_th = 0;
		int columns_td = 0;
		for (WebElement r : kw) {
			System.out.println("Last Row Values -- " + r.getText());
			// Find all columns in the last row
			columns_th = r.findElements(By.tagName("th")).size();
			columns_td = r.findElements(By.tagName("td")).size();

			total = columns_th + columns_td;
			System.out.println("Total " + total + " Columns in Last Row ");
		}

		assert total == 2;
		System.out.println();
		System.out.println("Find the last row in the table - Method 2");
		System.out.println();
		List<WebElement> rw = table.findElements(By.tagName("tr"));
		int th;
		int td;
		int i = 1;
		total = 0;
		for (WebElement r : rw) {

			if (r.getText().contains("Total")) {
				th = r.findElements(By.tagName("th")).size();
				td = r.findElements(By.tagName("td")).size();
				System.out.println("Last Row Values -- " + r.getText());
				total = th + td;
				System.out.println("Total " + total + " Columns in Row " + i);
				break;
			}
			i++;
			th = 0;
			td = 0;
			total = 0;
		}

		assert total == 2;

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

package com.reusable.helpers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;

public class InitializeDriver {

	WebDriver driver;
	private static Logger logger = LogManager.getLogger(InitializeDriver.class);

	public WebDriver InitializeChromeDriver() {

		ChromeOptions options = new ChromeOptions();

		options.setBinary(getChromeLocation());

		logger.info("Setting Chrome Options --start-maximized");
		options.addArguments("--start-maximized");

		ReadPropertiesFile readProperties = new ReadPropertiesFile();
		String chromeDownloadPath = readProperties.readPropertiesFile("executionConf", "chromeDownloadPath");

		logger.info("Setting ChromeDriver Preferences");
		Map<String, Object> prefs = new HashMap<String, Object>();
		logger.info("Setting default download directory");
		prefs.put("download.default_directory", chromeDownloadPath);
		logger.info("Setting popups to 0");
		prefs.put("profile.default_content_settings.popups", 0);

		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);

		return driver;

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

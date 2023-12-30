/**
 * 
 */
package com.reusable.helpers;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

/**
 * @author tapubrat
 *
 */
public class CaptureScreenshot {

	private static Logger logger = LogManager.getLogger(CaptureScreenshot.class);

	public static void takeScreenshot(WebDriver driver, String stepNo, String releaseNo, String testName) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			File directory = new File("evidences\\" + releaseNo);
			if (!directory.exists()) {
				logger.info("Creating Directory " + "evidences\\" + releaseNo);
				directory.mkdir();
			}

			FileUtils.copyFile(source, new File(directory + "\\" + testName + "\\" + stepNo + ".png"));
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
		}
	}

}

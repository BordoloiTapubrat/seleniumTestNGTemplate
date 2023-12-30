package com.reusable.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadPropertiesFile {

	private static Logger logger = LogManager.getLogger(ReadPropertiesFile.class);
	
	public String readPropertiesFile(String fileName, String key) {
		Properties prop = new Properties();

		try {
			File src = new File("./configuration/" + fileName + ".properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
		}

		return prop.getProperty(key);

	}

	public String readTestDataPropertiesFile(String fileName, String key) {
		Properties prop = new Properties();

		try {
			File src = new File("./release_data/" + fileName + ".properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
		}

		return prop.getProperty(key);

	}

}

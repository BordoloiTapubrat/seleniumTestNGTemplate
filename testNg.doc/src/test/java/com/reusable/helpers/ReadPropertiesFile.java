package com.reusable.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {
	
	public String readPropertiesFile(String fileName, String key)
	{
		Properties prop = new Properties();
		
		try
		{
			File src = new File("./configuration/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		}
		catch(Exception ex)
		{
		 ex.printStackTrace();
		}
		
		return prop.getProperty(key);
		
	}

}

/**
 * 
 */
package com.pages.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.reusable.helpers.ReadPropertiesFile;

/**
 * @author tapubrat
 *
 */
public class LoginPage {

	private static Logger logger = (Logger) LogManager.getLogger(LoginPage.class);

	WebDriver driver;
	WebDriverWait wait;

	ReadPropertiesFile readProperties = new ReadPropertiesFile();

	String userNameLoc = readProperties.readPropertiesFile("loginPageSelectors", "userName");
	String passWordLoc = readProperties.readPropertiesFile("loginPageSelectors", "passWord");
	String loginBtnLoc = readProperties.readPropertiesFile("loginPageSelectors", "loginBtn");

	public void enterUserName(String userName, WebDriver driver, WebDriverWait wait) {

		logger.info("Type UserName");
		WebElement uName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userNameLoc)));
		uName.sendKeys(userName);
	}

	public void enterPassword(String passWord, WebDriver driver, WebDriverWait wait) {

		logger.info("Type Password");
		WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passWordLoc)));
		pwd.sendKeys(passWord);
	}

	public void clickOnLoginBtn(WebDriver driver, WebDriverWait wait) {

		logger.info("Clicking on Login Button");
		WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginBtnLoc)));
		btnLogin.click();
	}

}

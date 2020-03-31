package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

/**
 * This page is designed to logged the user from the account
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class LogoutPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(LogoutPage.class);

	private By logoutTopNav = By.xpath("//*[@id=\"pg-container\"]/nav/div[1]/div[1]/div[2]/div/div[4]/ul/li[5]/a");
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	public void logout() {
		logger.info("Now I am logging out from ariat.com");
		WebDriverUtils.clickOnElementWithWait(driver, logoutTopNav);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_20_SECONDS);
		logger.info("I am succesfully logged out");
	}
}

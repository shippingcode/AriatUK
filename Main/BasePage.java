package com.ariat.Pages.Main;

import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

import org.slf4j.Logger;


/**
 * Base class which contains common properties and methods which can be reused 
 * in all other pages by extending this one
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class BasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
	
	protected WebDriver driver;
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void load(String url) {
		logger.info("Loading page {}", url);
		WebDriverUtils.load(driver, url);
		WebDriverUtils.maximizeWindow(driver);
		logger.info("Page {} loaded", url);
	}
	
	public void quit() {
		if(this != null) {
			WebDriverUtils.quit(driver);
		}
	}
		
		public void close() {
			if(this != null) {
				WebDriverUtils.quit(driver);
			}
	}
}

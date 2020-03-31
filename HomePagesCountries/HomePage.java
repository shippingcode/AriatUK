package com.ariat.Pages.HomePagesCountries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariat.Enums.EUCountries;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contains the Login page with all locators and methods associated and
 * links to SignIn page and Logout page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class HomePage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

	public static final String URL = "https://development.ariat.com";

	private By closeLocationx = By.xpath("//*[@id=\"ext-gen44\"]/body/div[6]/div[1]/a/span");
	private By ariatLogo = By.className("global-nav-logo-svg");
	private By saveAndContinueLocationButton = By.id("btnSaveContext");
	private By chooseLocationArrow = By.xpath("//*[@id=\"chooserTriggerHeader\"]/span/span");
	private By listCountries = By.xpath("//ul[@class='chooserDropdown country']");
	private By countrySelectorWindow = By.xpath("//span[@class='icon icon-full-arrow-down ms_desktop-only']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyLogo() {
		logger.info("Ariat Logo is being displayed");
		WebDriverUtils.getElementText(driver, ariatLogo);
	}

	public HomePage closeLocation() {
		logger.info("Closing the location..");
		WebDriverUtils.clickOnElementWithWait(driver, closeLocationx);
		return new HomePage(driver);
	}

	public HomePageUK chooseEULocation(EUCountries euCountry, String currency) {
		logger.info("Selecting EU  Ariat store country...");

		switch (euCountry.getCountryName()) {
		//Jenkins version
		case "(United Kingdom)":
			logger.info("I choose English United Kingdom as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollLittDown(driver, euCountry.UK.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.UK.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.UK.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
			}
			return new HomePageUK(driver);
						
		default:
			throw new RuntimeException("Country" + euCountry + "not supported");
		}
	}

	public void loadHomePage(String url) {
		load(url);
	}
}

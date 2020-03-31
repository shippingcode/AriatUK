package com.ariat.Tests.HeaderAndFooter.Countries;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;

/**
 * Test Home Page instantiates the browser and access the ariat environment and
 * verifies all elements on Home Page United Kingdom
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class HeaderAndFooterUKTest extends BaseTest {

	private Environments environment;
	private HomePageUK homePageUK;
	private HomePage homePage;
	private EUCountries euCountry;

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test
	public void HeaderUK() {
		logger.info("Starting the check for Header UK elements:");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUK.checkElementsHeader();
		logger.info("Finishing the check for Header UK elements:");
	}

	@AfterTest
	public void ClearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
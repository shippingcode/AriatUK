package com.ariat.Tests.Search.Countries;

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
 * Search product United Kingdom test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class SearchUKTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private EUCountries euCountry;
	private Environments environment;
	private final String OPTION = "boots";
	private final String MESSAGE = "Product results for: ";

	@BeforeTest
	public void SetSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test
	public void SearchProductTestUK() {
		logger.info("Starting search products UK test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUK.search(OPTION);
		homePageUK.assertProductDisplayed(MESSAGE + OPTION);
		homePageUK.seeAllproducts();
		logger.info("Finishing search products UK test");
	}

	@AfterTest
	public void ClearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
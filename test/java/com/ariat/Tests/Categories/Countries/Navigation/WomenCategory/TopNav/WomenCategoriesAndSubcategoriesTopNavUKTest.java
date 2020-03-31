package com.ariat.Tests.Categories.Countries.Navigation.WomenCategory.TopNav;

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
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesBagsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesHeadwearPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesScarfAndPonchosPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesSocksPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingBreechesAndTightsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingOuterwearPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingShowPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingSweatTshirtAndWoodiesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingTopsAndTshirtsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFeatured.WomenFeaturedSubcategories.WomenFeaturedHeritageCollectionPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFeatured.WomenFeaturedSubcategories.WomenFeaturedTriFactorBreechPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFeatured.WomenFeaturedSubcategories.WomenFeaturedWarmWeatherRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCountryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearWesternPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenClothingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFeaturedPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFootwearPage;

/**
 * Test pages redirection from Women Category to all its sub-categories tree
 * United Kingdom test structure
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenCategoriesAndSubcategoriesTopNavUKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePageUK homePageUK;
	private HomePage homePage;
	private WomenCategoryPage womenCategoryPage;

	private WomenFootwearPage womenFootwearPage;
	private WomenFootwearRidingPage womenFootwearRidingPage;
	private WomenFootwearWesternPage womenFootwearWesternPage;
	private WomenFootwearCountryPage womenFootwearCountryPage;
	private WomenFootwearCasualShoesPage womenFootwearCasualShoesPage;

	private WomenClothingPage womenClothingPage;
	private WomenClothingOuterwearPage womenClothingOuterwearPage;
	private WomenClothingBreechesAndTightsPage womenClothingBreechesAndTightsPage;
	private WomenClothingShowPage womenClothingShowPage;
	private WomenClothingSweatTshirtAndWoodiesPage womenClothingSweatTshirtAndWoodiesPage;
	private WomenClothingTopsAndTshirtsPage womenClothingTopsAndTshirtsPage;

	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesBagsPage womenAccessoriesBagsPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private WomenAccessoriesHeadwearPage womenAccessoriesHeadwearPage;
	private WomenAccessoriesScarfAndPonchosPage womenAccessoriesScarfAndPonchosPage;
	private WomenAccessoriesSocksPage womenAccessoriesSocksPage;

	private WomenFeaturedPage womenFeaturedPage;
	private WomenFeaturedHeritageCollectionPage womenFeaturedHeritageCollectionPage;
	private WomenFeaturedWarmWeatherRidingPage womenFeaturedWarmWeatherRidingPage;
	private WomenFeaturedTriFactorBreechPage womenFeaturedTriFactorBreechPage;

	@BeforeTest
	public void SetSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test
	public void NavigateWomenClothingCategoriesTestUK() {
		logger.info("Starting navigate Women Clothing sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingPage = womenCategoryPage.returnWomenClothingCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingOuterwearPage = womenClothingPage.returnWomenClothingOuterwearCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingBreechesAndTightsPage = womenClothingPage.returnWomenClothingBreechesAndTightsCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingShowPage = womenClothingPage.returnWomenClothingShowCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingSweatTshirtAndWoodiesPage = womenClothingPage
				.returnWomenClothingSweatTshirtAndWoodiesCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingTopsAndTshirtsPage = womenClothingPage.returnWomenClothingTopsAndTshirtsCategoryPage();
		logger.info("Finishing navigate Women Clothing sub-categories test.");
	}

	@AfterTest
	public void ClearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		womenCategoryPage.quit();

		womenFootwearRidingPage.quit();
		womenFootwearWesternPage.quit();
		womenFootwearCountryPage.quit();
		womenFootwearCasualShoesPage.quit();

		womenClothingPage.quit();
		womenClothingOuterwearPage.quit();
		womenClothingBreechesAndTightsPage.quit();
		womenClothingShowPage.quit();
		womenClothingSweatTshirtAndWoodiesPage.quit();
		womenClothingTopsAndTshirtsPage.quit();

		womenAccessoriesPage.quit();
		womenAccessoriesBagsPage.quit();
		womenAccessoriesGlovesPage.quit();
		womenAccessoriesHeadwearPage.quit();
		womenAccessoriesScarfAndPonchosPage.quit();
		womenAccessoriesSocksPage.quit();

		womenFeaturedPage.quit();
		womenFeaturedHeritageCollectionPage.quit();
		womenFeaturedWarmWeatherRidingPage.quit();
		womenFeaturedTriFactorBreechPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}

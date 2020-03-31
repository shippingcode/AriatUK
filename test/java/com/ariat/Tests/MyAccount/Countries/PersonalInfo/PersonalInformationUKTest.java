package com.ariat.Tests.MyAccount.Countries.PersonalInfo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PersonalnformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;
import com.ariat.Pages.Header.SignInPage;

/**
 * Personal Information Unite Kingdom test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class PersonalInformationUKTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private Environments environment;
	private EUCountries euCountry;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private PersonalnformationPage personalInformationPage;
	

	@BeforeTest
	public void SetSeleniumUP() {
	SetSelenium setPath = new SetSelenium();
	setPath.setSelenium();
	}
	
	@Test
	public void UpdatePersonalInformationTestUK() {
		logger.info("Starting update personal information test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		personalInformationPage = myAccountPage.returnPersonalInfoPageMiddleNav();
		personalInformationPage.clearEmail();
		personalInformationPage.enterEmail(CredentialsUtils.getProperty("email"));
		personalInformationPage.confirmEmail(CredentialsUtils.getProperty("email"));
		personalInformationPage.enterPassword(CredentialsUtils.getProperty("password"));
		personalInformationPage.confirmPassword(CredentialsUtils.getProperty("password"));
		personalInformationPage.saveEdits();
		logger.info("Update personal information test ended...");
	}
	
	@AfterTest
	public void ClearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		personalInformationPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
    }
}

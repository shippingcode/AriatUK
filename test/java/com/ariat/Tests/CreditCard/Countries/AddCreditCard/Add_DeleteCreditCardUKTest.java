package com.ariat.Tests.CreditCard.Countries.AddCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddACreditCardPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PaymentInformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;
import com.ariat.Pages.Header.SignInPage;


/**
 * Tests for add & deletet credit card United Kingdom
 * @author aila.bogasieru@ariat.com
 *
 */


public class Add_DeleteCreditCardUKTest extends BaseTest{
	
	private HomePage homePage;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddACreditCardPage addACreditCardPage;
	private PaymentInformationPage paymentInfoPage;
	private Environments environment;
	private EUCountries euCountry;
	private ListOfCreditCards typeCard;
	

	private static final String CARD_ID = "MASTER_ID123";
	private static final String CARD_OWNER = "Aila B";
	private static final String YEAR = "2021";
	private static final String MONTH = "December";
	
	@BeforeTest
	public void SetSeleniumUP() {
	SetSelenium setPath = new SetSelenium();
	setPath.setSelenium();
	}
	
	@Test
	public void Add_deleteCreditCardUKTest() {
		String expirationDate = "MONTH/YEAR";
		logger.info("Starting add credit card & delete it Kingdom test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNav();
		addACreditCardPage.setDetailsCreditCard(CARD_ID, CARD_OWNER, typeCard.MASTER_CARD1.getName(), typeCard.MASTER_CARD1.getNumber(),typeCard.MASTER_CARD1.getCvs(), MONTH, YEAR);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.checkCreditCard(CARD_OWNER, typeCard.MASTER_CARD1.getName(), expirationDate);
		paymentInfoPage.deleteCreditCardYes(CARD_OWNER, typeCard.MASTER_CARD1.getName(), expirationDate);
		logger.info("Finishing add credit card & delete it United Kingdom test");
  } 
	
	@AfterTest
	public void ClearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		signInPage.quit();
		addACreditCardPage.quit();
		paymentInfoPage.quit();
		myAccountPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
    }
}
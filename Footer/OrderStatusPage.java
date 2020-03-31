package com.ariat.Pages.Footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Order Status Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class OrderStatusPage extends BasePage{

	public static final Logger logger = LoggerFactory.getLogger(SignInPage.class);

	private By addressEmailTextBoxUS = By.xpath("//input[@placeholder='Email Address']");
	private By addressEmailTextBoxUK = By.xpath("//input[@placeholder='Email address']");
	private By emailAddressTextBoxDE = By.xpath("//input[@placeholder='E-Mail-Adresse (Erforderlich)']");
	private By emailAddressTextBoxFR = By.xpath("//input[@placeholder='Adresse courriel (Requis)']");
	// Search for Products
	private By passwordTextBox = By.id("dwfrm_login_password");
	private By checkRememberMe = By.id("dwfrm_login_rememberme");
	private By loginButton = By.name("dwfrm_login_login");
	private By checkOrderTextBox = By.id("dwfrm_ordertrack_orderNumber");
	private By emailAddressCheckOrderTextBox = By.id("dwfrm_ordertrack_email");
	private By billingCheckOrderTextBoxTextBox = By.id("dwfrm_ordertrack_postalCode");
	private By checkStatusButton = By.name("dwfrm_ordertrack_findorder");
	private By myAccountText = By.xpath("//*[contains(text(), 'My account']");
	private By orderDetailsText = By.xpath("//*[contains[text(),'Order Details']");
	
	public OrderStatusPage(WebDriver driver) {
		super(driver);
	}
	
	public void returningCustomer(String email, String language) {
		switch (language) {
		case "EnglishUK":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, addressEmailTextBoxUK, email);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
			break;
			
		case "EnglishUS":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, addressEmailTextBoxUS, email);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
			break;
		case "Deutsch":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, emailAddressTextBoxDE, email);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
			break;
		case "Francais":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, emailAddressTextBoxFR, email);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
			break;
		default:
			throw new RuntimeException("Language" + language + "not supported");
		}
	}

	public void returningPassword(String password) {
		logger.info("Entering information for an existing customer: password", password);
		WebDriverUtils.enterTextBox(driver, passwordTextBox, password);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
	}

	public void loginClick() {
		logger.info("Logging into your account...");
		WebDriverUtils.clickOnElementWithWait(driver, loginButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
	}

	public void returningCustomerRememberMe() {
		logger.info("Remeber me");
		WebDriverUtils.clickOnElement(driver, checkRememberMe);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
	}

	public void checkOrder(String orderNo, String email, String billing) {
		logger.info("Start entering information to check order", email, billing);
		WebDriverUtils.enterTextBox(driver, checkOrderTextBox, orderNo);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
		WebDriverUtils.enterTextBox(driver, emailAddressCheckOrderTextBox, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
		WebDriverUtils.enterTextBox(driver, billingCheckOrderTextBoxTextBox, billing);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_SECONDS);
	}

	public void checkStatusClick() {
		WebDriverUtils.clickOnElementWithWait(driver, checkStatusButton);
		logger.info("Checking the order status");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public OrderDetailsPage returnOrderDetailsPage() {
		WebDriverUtils.clickOnElementWithWait(driver, checkStatusButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(orderDetailsText));
		return new OrderDetailsPage(driver);
	}

	public MyAccountPage returnMyAccountPage() {
		WebDriverUtils.clickOnElementWithWait(driver, loginButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		return new MyAccountPage(driver);
	}
}

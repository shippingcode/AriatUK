package com.ariat.Pages.Main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariat.Utils.WebDriverUtils;

/**
 * This page contains all the elements on Create Account page and its methods:
 * create account, mark options and links with My Account page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CreateAccountPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(CreateAccountPage.class);

	private By firstNameTextBox = By.id("dwfrm_profile_customer_firstname");
	private By lastNameTextBox = By.id("dwfrm_profile_customer_lastname");
	private By birthMonth = By.id("dwfrm_profile_customer_customProfile_birthdayMonth");
	private By birthDay = By.id("dwfrm_profile_customer_customProfile_birthdayDay");
	private By emailTextBox = By.id("dwfrm_profile_customer_email");
	private By confirmEmailTextBox = By.id("dwfrm_profile_customer_emailconfirm");
	private By passwordTextBox = By.id("dwfrm_profile_login_password");
	private By confirmPasswordTextBox = By.id("dwfrm_profile_login_passwordconfirm");
	private By createAccountButton=By.name("dwfrm_profile_confirm");
	private By myAccountTitle = By.className("/account-overview__title ms-font--proxima_nova_semibold");
	private By emailMsg = By.xpath("//span[contains(text(), 'The email address is invalid.']");
	private By invalidConfirmEmailMessage = By.xpath("//*[@id=\"RegistrationForm\"]/div/div[7]/div/span");
	private By invalidPassMessage = By.xpath("//*[@id=\"RegistrationForm\"]/div/div[8]/div/span");
	private By invalidConfirmMessage = By.xpath("//*[@id=\"RegistrationForm\"]/div/div[9]/div/span");
	private By myAccountText = By.xpath("//*contains[text()='My account']");
	private By myWishlistText = By.xpath("//*contains[text()='Wishlist']");
	private By emailMsgTxt = By.xpath("//span[text()='The email address is invalid.']");
	private By missingMsg =By.xpath("//span[text()='This field is required.']");
	private By emailMsgTxtDE = By.xpath("//span[text()='Die E-Mail-Adresse ist ung�ltig.']");
	private By emailMsgTxtFR = By.xpath("//span[text()='L'adresse courriel n'est pas valide.']");
	

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public void createAccount(String firstName, String lastName, String month, String day, String email, String cnfEmail, String password, String cnfPassword) {
		logger.info("Start collecting information to create a new account: First Name, Last name, Birth month, Birth day, Email, Password");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, firstNameTextBox, firstName);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, lastNameTextBox, lastName);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, birthMonth, month);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, birthDay, day);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, emailTextBox, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.scroll350Down(driver, confirmEmailTextBox);
		WebDriverUtils.enterTextBox(driver, confirmEmailTextBox, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, passwordTextBox, password);	
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, confirmPasswordTextBox, password);
	}
	
	public void asserCreateAccountMissingValues(String missingValue) {
		String missing = WebDriverUtils.getElementText(driver, missingMsg);
		assertEquals(missing, missingValue, "This field is required.");
	}

	public void clearFirstName() {
		logger.info("Clearing text box First Name:");
		WebDriverUtils.clearElement(driver, firstNameTextBox);
		
	}

	public void clearLastName() {
		logger.info("Clearing text box Last Name:");
		WebDriverUtils.clearElement(driver, lastNameTextBox);
	}

	public void clearEmail() {
		logger.info("Clearing text box Email:");
		WebDriverUtils.clearElement(driver, emailTextBox);
	}

	public void assertWrongEmailCreateAccount(String emailMsgExpected) {
		String emailMessage = WebDriverUtils.getElementText(driver, emailMsg);
		assertEquals(emailMessage, emailMsgExpected, "Invalid email message is displayed");
	}
	
	public void assertWrongNameCreateAccount(String emailMsgTxtValue) {
		String nameMessage = WebDriverUtils.getElementText(driver, emailMsgTxt);
		assertEquals(nameMessage, emailMsgTxtValue, "Invalid name message is displayed");
	}
	
	public void assertWrongNameCreateAccountFR(String emailMsgTxtValue) {
		String nameMessage = WebDriverUtils.getElementText(driver, emailMsgTxtFR);
		assertEquals(nameMessage, emailMsgTxtValue, "Invalid name message is displayed");
	}
	
	public void assertWrongNameCreateAccountDE(String emailMsgTxtValue) {
		String nameMessage = WebDriverUtils.getElementText(driver, emailMsgTxtDE);
		assertEquals(nameMessage, emailMsgTxtValue, "Invalid name message is displayed");
	}
	
	public void assertWrongConfirmEmailCreateAccount(String confirmationEmailMsgExpected) {
	String confirmationMessage = WebDriverUtils.getElementText(driver, invalidConfirmEmailMessage);
	assertEquals(confirmationMessage, confirmationEmailMsgExpected, "Message displayed is ok");
	}	
	
	public void assertWrongPassCreateAccount(String passMsgExpected, String confirmationPasslMsgExpected) {
		String passwordMsg = WebDriverUtils.getElementText(driver, invalidPassMessage);
		assertEquals(passwordMsg, passMsgExpected, "(8 - 255 characters) message is displayed");
		
		String confirmPassword = WebDriverUtils.getElementText(driver, invalidConfirmMessage);
		assertEquals(confirmPassword, confirmationPasslMsgExpected, "(8 - 255 characters) message is displayed");
	}

	public void createAccountClick() {
		WebDriverUtils.scroll500Down(driver, createAccountButton);
		WebDriverUtils.clickOnElementWithWait(driver, createAccountButton);
		logger.info("New account was created with success");
	
	}
	
	public void createAccountClickWithoutScroll() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, createAccountButton);
		logger.info("New account was created with success");
	
	}

	public MyAccountPage returnMyAccountPage() {
		WebDriverUtils.scroll500Down(driver, createAccountButton);
		WebDriverUtils.clickOnElementWithWait(driver, createAccountButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountTitle));
		return new MyAccountPage(driver);
	}
	
	public MyAccountWishListPage returnMyAccountWishListPage() {
		WebDriverUtils.clickOnElementWithWait(driver, createAccountButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishlistText));
		return new MyAccountWishListPage(driver);
	  }
  	}


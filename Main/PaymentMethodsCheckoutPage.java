package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

public class PaymentMethodsCheckoutPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(PaymentMethodsCheckoutPage.class);

	private By cardArrow = By.cssSelector(".el-row:nth-child(4) .el-select__caret");
	private By selectCard = By.xpath("//span[text()='(MasterCard) ************4444 1.2033']");
	private By selectTypeCard = By.xpath(
			"//*[@id=\"app\"]/main/div/div[2]/form[2]/div[2]/div/div[2]/form/div[6]/div/div/div/div[1]/div/span/span/i");
	private By optionCardMasterCard = By.xpath("//span[text()='MasterCard']");
	private By optionCardVisa = By.xpath("//span[text()='Visa']");
	private By expirationDateMonth = By.xpath("//span[text()='June']");
	private By expirationDateYear = By.xpath("//span[text()='2024']");
	private By securityCode = By.cssSelector(".checkout__card-cvn .el-input__inner");
	private By pinTxtBox = By.xpath("//input[@placeholder='Pin']");
	private By applyGifCard = By.xpath("//button//span[text()='Apply']");
	private By expandGiftCard = By.xpath("//i[text()='Gift card']");
	private By expandPromoCode = By.xpath("//i[text()='Promo code']");
	private By nameText = By.cssSelector(".checkout__card-name .el-input__inner");
	private By cardNo = By.cssSelector(".checkout__card-number .el-input__inner");
	private By klarnaBtn = By.cssSelector(".payment-method__KLARNA > .el-radio__label");
	private By sofortBtn = By.cssSelector(".payment-method__SOFORT > .el-radio__label");
	private By giropayBtn = By.cssSelector(".payment-method__GIROPAY > .el-radio__label");
	private By payPalBtn = By.xpath("//span[text()='Paypal']");
	private By creditCardBtn = By
			.xpath("//label[@class='el-radio is-checked payment-method-radio payment-method__SA_SILENTPOST']");
	private By reviewOrderBtn = By.id("paymentbtncs");
	private By typeCardLocator = By.id("c-ct");
	private By idealBtn = By.xpath("//span[contains(text(), 'iDeal')]");
	private By arrowExpMonth = By.cssSelector(".el-form-item:nth-child(7) .el-select__caret");
	private By arrowExpYear = By.cssSelector(".el-form-item:nth-child(8) .el-select__caret");
	private By buyNowBtn = By.id("confirmpayment");
	private By typeCardList = By.id("c-ct");
	private By checkoutCompleteText = By.xpath("//*[contains(text(), 'Checkout Complete']");

	protected PaymentMethodsCheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void pressPaymentMethods(String optionMethod) {
		switch (optionMethod) {
		case "Klarna":
			logger.info("Choosing Klarna..");
			WebDriverUtils.scroll500Down(driver, klarnaBtn);
			WebDriverUtils.clickOnElementWithWait(driver, klarnaBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "Sofort":
			logger.info("Choosing Sofort..");
			WebDriverUtils.scroll350Down(driver, sofortBtn);
			WebDriverUtils.clickOnElementWithWait(driver, sofortBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "Giropay":
			logger.info("Choosing Giropay..");
			WebDriverUtils.scroll350Down(driver, giropayBtn);
			WebDriverUtils.clickOnElementWithWait(driver, giropayBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "CreditCard":
			logger.info("Choosing  Credit Card..");
			WebDriverUtils.scroll350Down(driver, creditCardBtn);
			WebDriverUtils.clickOnElementWithWait(driver, creditCardBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "Ideal":
			logger.info("Choosing  Ideal..");
			WebDriverUtils.scroll350Down(driver, idealBtn);
			WebDriverUtils.clickOnElementWithWait(driver, idealBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "PayPal":
			logger.info("Choosing PayPal..");
			WebDriverUtils.scroll350Down(driver, payPalBtn);
			WebDriverUtils.clickOnElementWithWait(driver, payPalBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;
		default:
			throw new RuntimeException("Language" + optionMethod + "not supported");
		}
	}

	public void setPaymentDetailsSecureCheckout(String cardNameValue, String cardNumberValue,
			String securityCardValue) {
		WebDriverUtils.scroll350Down(driver, nameText);
		WebDriverUtils.enterTextBox(driver, nameText, cardNameValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNo, cardNumberValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.scroll350Down(driver, arrowExpMonth);
		WebDriverUtils.clickOnElementWithWait(driver, arrowExpMonth);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, expirationDateMonth);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, arrowExpYear);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, expirationDateYear);
		WebDriverUtils.enterTextBox(driver, securityCode, securityCardValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterCardName(String cardNameValue) {
		logger.info("Entering card name..");
		// WebDriverUtils.enterTextBox(driver, cardName, cardNameValue);
		WebDriverUtils.clickOnElementWithWait(driver, cardArrow);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, selectCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterCardNameNotlogged(String cardNameValue) {
		logger.info("Entering card name..");
		WebDriverUtils.scroll350Down(driver, nameText);
		WebDriverUtils.enterTextBox(driver, nameText, cardNameValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterCardNo(String cardNumberValue) {
		logger.info("Entering card number..");
		WebDriverUtils.scroll350Down(driver, cardNo);
		WebDriverUtils.enterTextBox(driver, cardNo, cardNumberValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void selectTypeCardMasterCard() {
		logger.info("Selecting type of credit card..");
		WebDriverUtils.clickOnElementWithWait(driver, selectTypeCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, optionCardMasterCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void selectTypeCardVisa() {
		logger.info("Selecting type of credit card..");
		WebDriverUtils.clickOnElementWithWait(driver, selectTypeCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, optionCardVisa);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void typeCard(String typeCard) {
		WebDriverUtils.scroll350Down(driver, typeCardList);
		// WebDriverUtils.clickOnElementWithWait(driver, typeCardList);
		WebDriverUtils.selectVisibleText(driver, typeCardList, typeCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void selectTypeCard(String optionTypeCardValue) {
		WebDriverUtils.selectVisibleText(driver, typeCardLocator, optionTypeCardValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void selectExpirationMonth() {
		logger.info("Selecting expiration month credit card..");
		WebDriverUtils.scroll350Down(driver, arrowExpMonth);
		WebDriverUtils.clickOnElementWithWait(driver, arrowExpMonth);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, expirationDateMonth);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void selectExpirationYear() {
		logger.info("Selecting expiration year credit card..");
		WebDriverUtils.clickOnElementWithWait(driver, arrowExpYear);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, expirationDateYear);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterSecurityCode(String securityCardValue) {
		logger.info("Entering security card..");
		WebDriverUtils.enterTextBox(driver, securityCode, securityCardValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void reviewOrder() {
		WebDriverUtils.scroll500Down(driver, reviewOrderBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, reviewOrderBtn);
		try {
			WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
					ExpectedConditions.invisibilityOfElementLocated(checkoutCompleteText));
		} catch (Exception e) {
		}
	}

	public void expandPromoCode() {
		logger.info("Expanding promo code..");
		WebDriverUtils.clickOnElementWithWait(driver, expandPromoCode);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void expandGiftCard() {
		logger.info("Expanding gift card..");
		WebDriverUtils.clickOnElementWithWait(driver, expandGiftCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void apply() {
		logger.info("Apply..");
		WebDriverUtils.clickOnElementWithWait(driver, applyGifCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterPin(String pinValue) {
		logger.info("Entering pin..");
		WebDriverUtils.enterTextBox(driver, pinTxtBox, pinValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void scroll1500DownSecurittCode() {
		WebDriverUtils.scroll1500Down(driver, securityCode);
	}

	public void clickBuyNow() {
		logger.info("Buying now..");
		WebDriverUtils.clickOnElementWithWait(driver, buyNowBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
}

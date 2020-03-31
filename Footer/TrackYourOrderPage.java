package com.ariat.Pages.Footer;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Track Your Order Page
 * @author aila.bogasieru@ariat.com
 *
 */


public class TrackYourOrderPage extends BasePage {

	private By checkOrder = By.xpath("//h2[text()='Check an order / request return']");
	private By orderNoTxtBox = By.id("dwfrm_ordertrack_orderNumber");
	private By emailTxtBox = By.id("dwfrm_ordertrack_email");
	private By postalCodeTxtBox = By.id("dwfrm_ordertrack_postalCode");
	private By checkStatusBtn = By.name("dwfrm_ordertrack_findorder");
	private By orderNoText = By.xpath("//p[text()='You'll receive your order number in an email confirmation "
			+ "within 15 minutes of placing an order. Once your order has shipped, you will also "
			+ "receive an email with the UPS tracking number for your package.']");
	private By contactUsText = By
			.xpath("//p[text()='If you have any questions or need help with your account and/or order, "
					+ "please contact us to assist you. Our representatives are available Monday to Friday 8.30 AM - 5PM GMT "
					+ "at +44 (0)1367 242818 or customer.care@ariat.com']");
	private By MyAccountLink = By.linkText("My Account");
	private By returningCustomerText = By.xpath("//h2[text()='Returning customer']");

	public TrackYourOrderPage(WebDriver driver) {
		super(driver);
	}

	public void enterOrderNo(String orderNo) {
		WebDriverUtils.enterTextBox(driver, orderNoTxtBox, orderNo);
	}

	public void enterEmail(String email) {
		WebDriverUtils.enterTextBox(driver, emailTxtBox, email);
	}

	public void enterPostalCode(String code) {
		WebDriverUtils.enterTextBox(driver, postalCodeTxtBox, code);
	}

	public void checkStatus() {
		WebDriverUtils.clickOnElementWithWait(driver, checkStatusBtn);
	}

	public void assertText2(String expectedText) {
		String text = WebDriverUtils.getElementText(driver, orderNoText);
		assertEquals(text, expectedText, "2nd text is displayed accordingly");
	}

	public void assertText1(String expectedText) {
		WebDriverUtils.scrollLittDown(driver, checkOrder);
		String text = WebDriverUtils.getElementText(driver, checkOrder);
		assertEquals(text, expectedText, "Order number info text is displayed accordingly");
	}

	public void assertText3(String expectedText) {
		WebDriverUtils.scrollMiddlePage(driver, contactUsText);
		String text = WebDriverUtils.getElementText(driver, contactUsText);
		assertEquals(text, expectedText, "Contact Us text is displayed accordingly");
	}

	public MyAccountPage returnMyAccountPage() {
		WebDriverUtils.clickOnElementWithWait(driver, MyAccountLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(returningCustomerText));
		return new MyAccountPage(driver);
	}
}
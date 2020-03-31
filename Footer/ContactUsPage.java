package com.ariat.Pages.Footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Contact Us Page
 * @author aila.bogasieru@ariat.com
 *
 */


public class ContactUsPage extends BasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactUsPage.class);

	private By firstContact = By.id("dwfrm_contactus_firstname");
	private By lastContact = By.id("dwfrm_contactus_lastname");
	private By emailContact = By.id("dwfrm_contactus_email");
	private By phoneContact = By.id("dwfrm_contactus_phone");
	private By orderNoTxtBox = By.id("dwfrm_contactus_ordernumber");
	private By myQuestionSelect = By.id("dwfrm_contactus_myquestion");
	private By commentTxtBox = By.id("dwfrm_contactus_comment");
	private By checkBox = By.xpath("//span[@id='recaptcha-anchor']//div[@class='recaptcha-checkbox-border']//div[@class='recaptcha-checkbox-borderAnimation']");
	private By submitBtn = By.name("dwfrm_contactus_send");

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	public void enterFName(String firstName) {
		logger.info("Entering first name..");
		WebDriverUtils.enterTextBox(driver, firstContact, firstName);
	}

	public void enterLName(String lastName) {
		logger.info("Entering last name..");
		WebDriverUtils.enterTextBox(driver, lastContact, lastName);
	}
	
	public void enterEmail(String email) {
		logger.info("Entering email..");
		WebDriverUtils.enterTextBox(driver, emailContact, email);
	}
	
	public void enterPhone(String phone) {
		logger.info("Entering phone..");
		WebDriverUtils.enterTextBox(driver, phoneContact, phone);
	}
	
	public void enterOrderNo(String orderNo) {
		logger.info("Entering order number..");
		WebDriverUtils.enterTextBox(driver, orderNoTxtBox, orderNo);
	}
	
	public void selectQuestion(String question) {
		logger.info("Selecting a question..");
		WebDriverUtils.selectVisibleText(driver, myQuestionSelect, question);
	}
	
	public void enterComment(String comment) {
		logger.info("Entering order number..");
		WebDriverUtils.enterTextBox(driver, commentTxtBox, comment);
	}
	
	public void checkNotRobot() {
		WebDriverUtils.scrollLittDown(driver, checkBox);
		WebDriverUtils.clickOnElementWithWait(driver, checkBox);
	}
	
	public void submit() {
		logger.info("Saving the contact form..");
		WebDriverUtils.clickOnElementWithWait(driver, submitBtn);
	}
}

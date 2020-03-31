package com.ariat.Pages.Footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Email Sign Up Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class EmailSignUpPage extends BasePage{
	
	private static final Logger logger = LoggerFactory.getLogger(EmailSignUpPage.class);

	
	private By emailSignUpTxtBox = By.id("dwfrm_cmsignup_email");
	private By nameTxtBox = By.id("dwfrm_cmsignup_yourname");
	private By genderSelect = By.id("dwfrm_cmsignup_gender");
	private By ridingStyleSelect = By.id("dwfrm_cmsignup_ridingstyle");
	private By englishCheck = By.xpath("//*[@id=\"EmailSignupExtrasForm\"]/div[7]/div[1]/div[1]/span");
	private By countryCheck = By.xpath("//*[@id=\"EmailSignupExtrasForm\"]/div[7]/div[1]/div[2]/span");
	private By apparelCheck = By.xpath("//*[@id=\"EmailSignupExtrasForm\"]/div[7]/div[1]/div[3]/span");
	private By westernCheck = By.xpath("//*[@id=\"EmailSignupExtrasForm\"]/div[7]/div[2]/div[1]/span");
	private By workCheck = By.xpath("//*[@id=\"EmailSignupExtrasForm\"]/div[7]/div[2]/div[2]/span");
	private By fashionCheck = By.xpath("//*[@id=\"EmailSignupExtrasForm\"]/div[7]/div[2]/div[3]/span");

	protected EmailSignUpPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterEmailSignUp(String emailSignUp) {
		logger.info("Entering sign up email..");
		WebDriverUtils.enterTextBox(driver, emailSignUpTxtBox, emailSignUp);
}
	
	public void enterName(String nameSignUp) {
		logger.info("Entering name for sign up..");
		WebDriverUtils.enterTextBox(driver, nameTxtBox, nameSignUp);
	}	
	
	public void checkGender() {
		WebDriverUtils.clickOnElementWithWait(driver, genderSelect);
	}
	
	public void ridingStyle(String riding) {
		WebDriverUtils.selectVisibleText(driver, ridingStyleSelect, riding);
	}
	
	
	public void checkAriatproduct(String product) {
		switch(product) {
		case "English": 
			WebDriverUtils.clickOnElementWithWait(driver, englishCheck);
		break;
		case "Country":
			WebDriverUtils.clickOnElementWithWait(driver, countryCheck);
		break;
		case "Apparel":
			WebDriverUtils.clickOnElementWithWait(driver, apparelCheck);
		break;
		case "Western":
			WebDriverUtils.clickOnElementWithWait(driver, westernCheck);
		break;
		case "Work":
		WebDriverUtils.clickOnElementWithWait(driver, workCheck);
		break;
		case "Fashion":
			WebDriverUtils.clickOnElementWithWait(driver, fashionCheck);	
		default:
			throw new RuntimeException("Product" + product + "not supported");
	        }
	     }
	}

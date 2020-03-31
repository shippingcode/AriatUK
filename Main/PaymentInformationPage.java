package com.ariat.Pages.Main;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariat.Utils.WebDriverUtils;

/**
 * links with Add a credit card page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class PaymentInformationPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(PaymentInformationPage.class);


	private By addACreditCardButton = By.xpath("//a[contains(text(),'Add a Credit Card')]");
	private By addACreditCardText = By.xpath("//*[contains(text(), 'Add a credit card')]");
	WebElement cardTable = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]"));
	private By deleteCardLink = By.xpath("//a[text()='Delete card']");
	private By makeDefaultCardLink =  By.xpath("//a[text()='Make Default Card']");
	private By deleteButtonDeleteCard = By.xpath("//*[@id=\"ext-gen44\"]/body/div[8]/div[3]/div/button[2]");
	private By cancelButtonDeleteCard = By.xpath("//*[@id=\"ext-gen44\"]/body/div[8]/div[3]/div/button[1]/span");
	private By creditNickname = By.xpath("//div[@id='paymentinfo']/div[2]/div/div/div/div/div/div/h3/span");
	
	
	public PaymentInformationPage(WebDriver driver) {
		super(driver);
	}

	public AddACreditCardPage returnAddACreditCardPage() {
		WebDriverUtils.scroll300(driver, addACreditCardButton);
		WebDriverUtils.clickOnElementWithWait(driver, addACreditCardButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addACreditCardText));
		return new AddACreditCardPage(driver);
	}
	

	public void checkCreditCard(String cardowner, String cardType, String expireDate) {
		ArrayList<WebElement> rows = (ArrayList<WebElement>) cardTable.findElements(By.tagName("div"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.tagName("div"));
			for (WebElement cell : cells) {
				if (cell.getText() == cardowner && cell.getText() == cardType && cell.getText() == expireDate) {
					if (WebDriverUtils.findElement(driver, deleteCardLink) != null
							&& WebDriverUtils.findElement(driver, makeDefaultCardLink) != null) {
						logger.info(
								"Credit card with:{}" + cardowner + cardType + expireDate + "was created with success");
					} else {
						logger.info("Credit card with{}" + cardowner + cardType + expireDate + "was not created");
					}

				} else {
					logger.info("Credit card was not found in the list of cards");
				}
			}
		}
	}
	
	public void deleteCreditCardNo(String cardowner, String cardType, String expireDate) {
		ArrayList<WebElement> rows = (ArrayList<WebElement>) cardTable.findElements(By.tagName("div"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.tagName("div"));
			for (WebElement cell : cells) {
				if (cell.getText() == cardowner && cell.getText() == cardType && cell.getText() == expireDate) {
					if (WebDriverUtils.findElement(driver, deleteCardLink) != null) {
						WebDriverUtils.clickOnElementWithWait(driver, deleteCardLink);
						WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_20_SECONDS);
						WebDriverUtils.clickOnElementWithWait(driver, cancelButtonDeleteCard);
						WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_20_SECONDS);
						logger.info(
								"Credit card with:{}" + cardowner + cardType + expireDate + "was cancelled from deletion");
					} else {
						logger.info("Credit card with{}" + cardowner + cardType + expireDate + "was not cancelled from deletion");
					}

				} else {
					logger.info("Credit card was not found in the list of cards");
				}
			}
		}
	}

	
	public void deleteCreditCardYes(String cardowner, String cardType, String expireDate) {
		ArrayList<WebElement> rows = (ArrayList<WebElement>) cardTable.findElements(By.tagName("div"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.tagName("div"));
			for (WebElement cell : cells) {
				if (cell.getText() == cardowner && cell.getText() == cardType && cell.getText() == expireDate) {
					if (WebDriverUtils.findElement(driver, deleteCardLink) != null) {
						WebDriverUtils.clickOnElementWithWait(driver, deleteCardLink);
						WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_20_SECONDS);
						WebDriverUtils.clickOnElementWithWait(driver, deleteButtonDeleteCard);
						WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_20_SECONDS);
						logger.info(
								"Credit card with:{}" + cardowner + cardType + expireDate + "was deleted with success");
					} else {
						logger.info("Credit card with{}" + cardowner + cardType + expireDate + "was not deleted");
					}

				} else {
					logger.info("Credit card was not found in the list of cards");
				}
			}
		}
	}
	
	public void makeDefaultCreditCard(String cardowner, String cardType, String expireDate) {
		ArrayList<WebElement> rows = (ArrayList<WebElement>) cardTable.findElements(By.tagName("div"));
		for (WebElement row : rows) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.tagName("div"));
			for (WebElement cell : cells) {
				if (cell.getText() == cardowner && cell.getText() == cardType && cell.getText() == expireDate) {
					if (WebDriverUtils.findElement(driver, makeDefaultCardLink) != null) {
						WebDriverUtils.clickOnElementWithWait(driver, makeDefaultCardLink);
						WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_20_SECONDS);
						logger.info(
								"Credit card with:{}" + cardowner + cardType + expireDate + "was made default with success");
					} else {
						logger.info("Credit card with{}" + cardowner + cardType + expireDate + "was not made default");
					}

				} else {
					logger.info("Credit card was not found in the list of cards");
				}
			}
		}
	}

	public void assertMakeDefaultCreditCard(String expectedCreditCard) {
		String creditLabel = WebDriverUtils.getElementText(driver, creditNickname);
		String substring = "DEFAULT | ";
		String makeDefault = substring + creditLabel;
		assertEquals(makeDefault , expectedCreditCard, "Credit card made as default is being displayed");
	}
}

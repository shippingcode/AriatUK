package com.ariat.Pages.Footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Find a Retailer Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class FindARetailerPage extends BasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(FindARetailerPage.class);
	
	private By zipCodeTxt = By.id("dwfrm_storelocator_postalCode");
	private By radiusSelect = By.xpath("dwfrm_storelocator_maxdistance");
	private By searchBtn = By.name("dwfrm_storelocator_findbyzip");
	private By resultAll = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[1]/div[1]/span");
	private By resultWestern = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[1]/div[2]/span");
	private By resultEnglish = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[1]/div[3]/span");
	private By resultFashion = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[2]/div[1]/span");
	private By resultWork = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[2]/div[2]/span");
	private By resultOutdoor = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[2]/div[3]/span");
	private By two24Link = By.id("two24stores");
	private By two24Img = By.xpath("/img[contains(@src, 'two-24-logo.svg')]");

	protected FindARetailerPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterZipCode(String zipCodeValue) {
		logger.info("Entering zip code..");
		WebDriverUtils.enterTextBox(driver, zipCodeTxt, zipCodeValue);
	}
	
	public void selectRadius(String radiusOption) {
		logger.info("Selecting radius..");
		WebDriverUtils.selectVisibleText(driver, radiusSelect, radiusOption);
	}
	
	public void pressSearch() {
		logger.info("Searching for a retailer..");
		WebDriverUtils.clickOnElementWithWait(driver, searchBtn);
	}

	public void findByResults(String result) {
		switch(result) {
		case "All": 
			WebDriverUtils.clickOnElementWithWait(driver, resultAll);
		break;
		case "Western":
			WebDriverUtils.clickOnElementWithWait(driver, resultWestern);
		break;
		case "English":
			WebDriverUtils.clickOnElementWithWait(driver, resultEnglish);
		break;
		case "Fashion":
			WebDriverUtils.clickOnElementWithWait(driver, resultFashion);
		break;
		case "Outdoor":
		WebDriverUtils.clickOnElementWithWait(driver, resultOutdoor);
		break;
		case "Work":
			WebDriverUtils.clickOnElementWithWait(driver, resultWork);	
		default:
			throw new RuntimeException("Result" + result + "not supported");
	}
  }
	
	public Home24TwoPage returnHome24TwoPage() {
		WebDriverUtils.clickOnElementWithWait(driver, two24Link);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(two24Img));
		return new Home24TwoPage(driver);
	}
}


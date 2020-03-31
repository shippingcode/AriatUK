package com.ariat.Pages.Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Find A Retailer Page
 * @author aila.bogasieru@ariat.com
 *
 */


public class FindARetailerPage extends BasePage {

	private By countrySelect = By.id("dwfrm_storelocator_countries_countryCode");
	private By postcodeTxtBox = By.id("dwfrm_storelocator_postalCode");
	private By radiusSelect = By.id("dwfrm_storelocator_maxdistance");
	private By searchBtn = By.name("dwfrm_storelocator_findbyzip");
	private By resultsAll = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[1]/div[1]/span");
	private By westernResults = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[1]/div[2]/span");
	private By englishResults = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[1]/div[3]/span");
	private By fashionResults = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[2]/div[1]/span");
	private By workResults = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[2]/div[2]/span");
	private By outdoor = By.xpath("//*[@id=\"filter-results\"]/div/div/div/div[2]/div[3]/span");

	public FindARetailerPage(WebDriver driver) {
		super(driver);
	}

	public void switchResults(String result) {
		switch (result) {
		case "All":
			WebDriverUtils.clickOnElementWithWait(driver, resultsAll);
			break;
		case "Western":
			WebDriverUtils.clickOnElementWithWait(driver, westernResults);
			break;
		case "English":
			WebDriverUtils.clickOnElementWithWait(driver, englishResults);
			break;
		case "Fashion":
			WebDriverUtils.clickOnElementWithWait(driver, fashionResults);
			break;
		case "Work":
			WebDriverUtils.clickOnElementWithWait(driver, workResults);
			break;
		case "Outdoor":
			WebDriverUtils.clickOnElementWithWait(driver, outdoor);
			break;
		default:
			throw new RuntimeException("Result" + result + "not supported");
		}
	}

	public void selectCountry(String country) {
		WebDriverUtils.selectVisibleText(driver, countrySelect, country);
	}

	public void enterPostCode(String postCode) {
		WebDriverUtils.selectVisibleText(driver, postcodeTxtBox, postCode);
	}

	public void selectRadius(String radius) {
		WebDriverUtils.selectVisibleText(driver, radiusSelect, radius);
	}

	public void search() {
		WebDriverUtils.clickOnElementWithWait(driver, searchBtn);
	}
}

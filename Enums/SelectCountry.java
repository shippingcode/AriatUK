package com.ariat.Enums;

import org.openqa.selenium.By;

/**
 * Shortcuts of countries by country code
 * @author aila.bogasieru@ariat.com
 */

public enum SelectCountry {
	
	AUSTRIA("Austria", By.xpath("//li//span[contains(text(), 'Austria')]")),
	BELGIUM("Belgium", By.xpath("//li//span[contains(text(), 'Belgium')]")),
	DEUTSCHLAND("Deutschland", By.xpath("//li//span[contains(text(), 'Deutschland')]")),
	FRANCE("France", By.xpath("//li//span[contains(text(), 'France')]")),
	UK("United Kingdom", By.xpath("//li//span[contains(text(), 'United Kingdom')]")),
	IRELAND("Ireland", By.xpath("//li//span[contains(text(), 'Ireland')]")),
	SWEDEN("Sweden", By.xpath("//li//span[contains(text(), 'Sweden')]")),
	DENMARK("Sweden", By.xpath("//li//span[contains(text(), 'Denmark')]")),
	FINLAND("Finland", By.xpath("//li//span[contains(text(), 'Finland')]")),
	LUXEMBOURG("Luxembourg", By.xpath("//li//span[contains(text(), 'Luxembourg')]")),
	NETHERLANDS("Netherlands", By.xpath("//li//span[contains(text(), 'Netherlands')]")),
	NORWAY("Norway", By.xpath("//li//span[contains(text(), 'Norway')]"));
		
	private String countryName;
	private By locator;
	
	private SelectCountry(String countryName, By locator) {
		
		this.countryName = countryName;
		this.locator = locator;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public By getLocator() {
		return locator;
	}
}

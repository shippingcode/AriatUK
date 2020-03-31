package com.ariat.Pages.Footer;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Shipping Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class ShippingPage extends BasePage{
	
	private By text1 = By.xpath("//h2[text()='Ariat.com Shipping Guidelines:']");
	private By text2 = By.xpath("//p[text()='All orders ship and deliver during business day M-F (Not Including Holidays)']");
	private By text3 = By.xpath("//h2[text()='Continental U.S.: UPS']");
	
	protected ShippingPage(WebDriver driver) {
		super(driver);
	}

		
	public void assertText1(String expectedText, String expectedText1, String expectedText2) {
		String text = WebDriverUtils.getElementText(driver, text1);
		assertEquals(text, expectedText, "Text on Delivery page is displayed");
		String text1 = WebDriverUtils.getElementText(driver, text2);
		assertEquals(text, expectedText1, "Text on Delivery page is displayed");
		String text2 = WebDriverUtils.getElementText(driver, text3);
		assertEquals(text, expectedText2, "Text on Delivery page is displayed");
	}
}

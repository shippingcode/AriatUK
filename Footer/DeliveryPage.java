package com.ariat.Pages.Footer;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Delivery Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class DeliveryPage extends BasePage{
	
	private By textDelivery = By.xpath("//h2[text()='Delivery Charges']");

	public DeliveryPage(WebDriver driver) {
		super(driver);
	}
	
	public void assertText1(String expectedText) {
		String text = WebDriverUtils.getElementText(driver, textDelivery);
		assertEquals(text, expectedText, "Text on Delivery page is displayed");
	}
}

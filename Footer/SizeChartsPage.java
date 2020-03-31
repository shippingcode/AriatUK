package com.ariat.Pages.Footer;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Size Chart Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class SizeChartsPage extends BasePage{
	
	private By text1 = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[1]/div[1]");
	private By text2 = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[2]/div[1]");
	private By text3 = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[3]/div[1]");
	private By text4 = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[1]");
	private By text5 = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[5]/div[1]");
	private By text6 = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[6]/div[1]");
	private By text7 = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[7]/div[1]");
	
	public SizeChartsPage(WebDriver driver) {
		super(driver);
	}


	public void assertText(String expectedText1, String expectedText2, String expectedText3, String expectedText4,
			String expectedText5, String expectedText6, String expectedText7) {
		String text = WebDriverUtils.getElementText(driver, text1);
		assertEquals(text, expectedText1, "BOOTS text is displayed accordingly");
		String text1 = WebDriverUtils.getElementText(driver, text2);
		assertEquals(text1, expectedText2, "TALL BOOTS text is displayed accordingly");
		String text2 = WebDriverUtils.getElementText(driver, text3);
		assertEquals(text2, expectedText3, "HALF CHAPS text is displayed accordingly");
		String text3 = WebDriverUtils.getElementText(driver, text4);
		assertEquals(text3, expectedText4, "DENIM text is displayed accordingly");
		String text4 = WebDriverUtils.getElementText(driver, text5);
		assertEquals(text4, expectedText5, "WESTERN APPAREL text is displayed accordingly");
		String text5 = WebDriverUtils.getElementText(driver, text6);
		assertEquals(text5, expectedText6, "ENGLISH APPAREL text is displayed accordingly");
		String text6 = WebDriverUtils.getElementText(driver, text7);
		assertEquals(text6, expectedText7, "BELTS text is displayed accordingly");
	}
}

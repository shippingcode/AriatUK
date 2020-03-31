package com.ariat.Pages.Footer;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Faqs Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class FaqsPage extends BasePage {

	private By customerText = By.xpath("//div[text()='Customer Care']");
	private By replacementproductsText = By.xpath("//div[text()='Replacement of Products or Shoe Parts']");
	private By sizingFitText = By.xpath("//div[text()='Sizing & Fit']");
	private By bootCareText = By.xpath("//div[text()='Boot Care']");
	private By retailPartnershipText = By.xpath("//div[text()='Retail Partnership']");
	private By miscellaneousText = By.xpath("//div[text()='Miscellaneous']");

	public FaqsPage(WebDriver driver) {
		super(driver);
	}

	public void assertText(String expectedText1, String expectedText2, String expectedText3, String expectedText4,
			String expectedText5, String expectedText6) {
		String text = WebDriverUtils.getElementText(driver, customerText);
		assertEquals(text, expectedText1, "Customer text is displayed accordingly");
		String text1 = WebDriverUtils.getElementText(driver, replacementproductsText);
		assertEquals(text1, expectedText2, "Replacement Products text is displayed accordingly");
		String text2 = WebDriverUtils.getElementText(driver, sizingFitText);
		assertEquals(text2, expectedText3, "Boot care text is displayed accordingly");
		String text3 = WebDriverUtils.getElementText(driver, bootCareText);
		assertEquals(text3, expectedText4, "Customer text is displayed accordingly");
		String text4 = WebDriverUtils.getElementText(driver, retailPartnershipText);
		assertEquals(text4, expectedText5, "Customer text is displayed accordingly");
		String text5 = WebDriverUtils.getElementText(driver, miscellaneousText);
		assertEquals(text5, expectedText6, "MiscellaneousText text is displayed accordingly");
	}
}

package com.ariat.Pages.Footer;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Carrers Page
 * @author aila.bogasieru@ariat.com
 *
 */


public class CarrersPage extends BasePage{
	
	private By text1 = By.xpath("//p[text()='At Ariat, we measure our success in our people. It's their commitment, talent, work ethic, and endless dedication that helps us reach our goals. We're dedicated to creating a motivated and energetic team, and giving them an environment where they can thrive. "
			+ "We don't just sell a lifestyle, we live it. Striving to ride and live outdoors every day.']");
    private By text2 = By.xpath("h1[text()='Vacancies']");
	
	
	public CarrersPage(WebDriver driver) {
		super(driver);
	}
	
	public void assertText1(String expectedText) {
		String text = WebDriverUtils.getElementText(driver, text1);
		assertEquals(text, expectedText, "1st text is displayed accordingly");
	}
	
	public void assertText2(String expectedText) {
		String text = WebDriverUtils.getElementText(driver, text2);
		assertEquals(text, expectedText, "Vacancies text is displayed accordingly");
	}
}

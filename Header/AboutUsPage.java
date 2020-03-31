package com.ariat.Pages.Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Footer.CarrersPage;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements About Us Page
 * @author aila.bogasieru@ariat.com
 *
 */


public class AboutUsPage extends BasePage{
	
	private By carrersLink = By.linkText("Careers");
	private By carrersText = By.xpath("//*contains[text(), 'CAREERS']");
	

	public AboutUsPage(WebDriver driver) {
		super(driver);
	}
	
	public CarrersPage returnCarrersPage() {
		WebDriverUtils.clickOnElementWithWait(driver, carrersLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(carrersText));
		return new CarrersPage(driver);
	}
}

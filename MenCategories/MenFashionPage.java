package com.ariat.Pages.Categories.MenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contains Men Fashion Page' locators, methods and links with next pages
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenFashionPage extends BasePage{
	
	private By footwearSwitcher = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/a/span[2]");
	private By sneakersCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/ul/li/a");
	private By sneakersCategoryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");

	public MenFashionPage(WebDriver driver) {
		super(driver);
	}
	
	public void footwearSwitcherClick() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearSwitcher);
	}
	
	public MenFashionSneakersPage returnMenWorkPullOnPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, sneakersCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(sneakersCategoryText));
		return new MenFashionSneakersPage(driver);
	}
}

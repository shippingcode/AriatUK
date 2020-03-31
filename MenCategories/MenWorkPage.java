package com.ariat.Pages.Categories.MenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.MenCategories.MenSubcategories.MenFootwearWorkCategories.MenFootwearWorkLaceUpPage;
import com.ariat.Pages.Categories.MenCategories.MenSubcategories.MenFootwearWorkCategories.MenFootwearWorkPullOnPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contains Men Work Page' locators, methods and links with next pages
 * @author aila.bogasieru@ariat.com
 *
 */


public class MenWorkPage extends BasePage{
	
	private By footwearSwitcher = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/a/span[2]");
	private By laceUpLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/ul/li[1]/a");
	private By pullOnLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/ul/li[2]/a");
	private By laceUpCategoryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By pullOnCategoryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	

	public MenWorkPage(WebDriver driver) {
		super(driver);
		}
	
	public void footwearSwitcherClick() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearSwitcher);
	}

	public MenFootwearWorkLaceUpPage returnMenWorkLaceUpPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, laceUpLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(laceUpCategoryText));
		return new MenFootwearWorkLaceUpPage(driver);
	}
	
	public MenFootwearWorkPullOnPage returnMenWorkPullOnPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, pullOnLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(pullOnCategoryText));
		return new MenFootwearWorkPullOnPage(driver);
	}
}

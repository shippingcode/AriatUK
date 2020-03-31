package com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.MenCategories.MenFashionSneakersPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Men Footwear CasualShoes Category Page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenFootwearCasualShoesPage extends BasePage {

	private By sneakersFootwearCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li/a");
	private By sneakersFootwearText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");

	public MenFootwearCasualShoesPage(WebDriver driver) {
		super(driver);

	}

	public MenFashionSneakersPage returnMenFashionSneakersCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, sneakersFootwearCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(sneakersFootwearText));
		return new MenFashionSneakersPage(driver);
	}
}

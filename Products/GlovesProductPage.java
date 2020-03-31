package com.ariat.Pages.Products;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.MyAccountWishListPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.MyWishListPage;
import com.ariat.Utils.WebDriverUtils;



/**
 * Implements Product attributes methods for Gloves Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class GlovesProductPage extends BasePage{
	

	private By wishList = By.xpath("//button[@class='add-to-wishlist in-stock-element wl-action product__button product__button--pdp ']");
	private By myWishListText = By.xpath("//*contains[text(), 'Wish list']");
	private By myAccountText = By.xpath("//*contains[text()='My account']");
	private By myWishlistText = By.xpath("//*contains[text()='Wishlist']");
	private By selectCalf = By.id("va-calf");
	private By selectHeight = By.id("va-height");
	private By increaseQty = By.xpath("//span[text()='+']");
	private By decreaseQty = By.xpath("//span[text()='-']");
	private By writeReview = By.xpath("//*[@id=\"BVRRSummaryContainer\"]/div/div/div/div/div/div/div");
	private By reviewDialog = By.id("bv-mbox-lightbox-list");
	private By starReviewExcellent = By.xpath("//a[@id='bv-radio-rating-5']/span");
	private By starReviewGood = By.xpath("//a[@id='bv-radio-rating-4']/span");
	private By starReviewAverage = By.xpath("//a[@id='bv-radio-rating-3']/span");
	private By starReviewFair = By.xpath("//a[@id='bv-radio-rating-2']/span");
	private By starReviewPoor = By.xpath("//a[@id='bv-radio-rating-1']/span");
	private By titleReview = By.id("bv-text-field-title");
	private By textReview = By.id("bv-textarea-field-reviewtext");
	private By addPhotoReview = By.xpath("//span[text()='Add Photo']");
	private By addVideoReview = By.xpath("//button[text()=' Add Video ']");
	private By addPhotoModal = By.id("bv-mbox-lightbox-list");
	private By choosePhotoReview = By.id("bv-text-field-photourl_1");
	private By videoModalReview = By.id("bv-mbox-lightbox-list");
	private By insertVideoURLReview = By.id("bv-text-field-videourl_1");
	private By addVideoButton = By.xpath("//button[text()='Add Video']");
	private By recommendProductYes = By.id("bv-radio-isrecommended-true-label");
	private By recommendProductNo = By.id("bv-radio-isrecommended-false-label");
	private By nicknameReview = By.id("bv-text-field-usernickname");
	private By userLocation = By.id("bv-text-field-userlocation");
	private By emailReview = By.id("bv-email-field-hostedauthentication_authenticationemail");
	private By postReviewButton = By.xpath("//button[text()='Post Review']");
    private By updateButton = By.xpath("//button[@value='Update']");
	private By lengthLocator = By.id("va-length");

	By selectSize = By.id("va-size");
	By addToBasket = By.cssSelector("#add-to-cart");
	By bonusDialog = By.id("bonus-choose-container product-content");

	public GlovesProductPage(WebDriver driver) {
		super(driver);
	}

	public void selectAttributeSize(String size) {
		WebDriverUtils.selectVisibleText(driver, selectSize, size);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		
	}


	public void selectAttributeCalf(String calf) {
		WebDriverUtils.selectVisibleText(driver, selectCalf, calf);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	
	}

	public void selectAttributeHeight(String height) {
		WebDriverUtils.selectVisibleText(driver, selectHeight, height);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	
	}

	public void setQtyIncrease(int n) {
		for (int i = 0; i <= n; i++) {
			WebDriverUtils.clickOnElementWithWait(driver, increaseQty);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		
		}
	}

	public void setQtyDecrease(int n) {
		for (int i = 0; i <= n; i++) {
			WebDriverUtils.clickOnElementWithWait(driver, decreaseQty);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	
		}
	}

	public void writeReviewClick() {
		WebDriverUtils.clickOnElementWithWait(driver, writeReview);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	
	}

	public void writeReviewStar(String star) {
		if (WebDriverUtils.findElement(driver, reviewDialog) != null) {
			switch (star) {
			case "Excellent":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewExcellent);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
				break;

			case "Good":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewGood);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
				break;

			case "Average":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewAverage);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
				break;

			case "Fair":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewFair);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
				break;

			case "Poor":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewPoor);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
				break;

			default:
				throw new RuntimeException("No star supported");
			}
		}
	}

	public void writeReviewContent(String titleReviewText, String reviewText) {
		WebDriverUtils.enterTextBox(driver, titleReview, titleReviewText);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, textReview, reviewText);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void addPhoto() {
		WebDriverUtils.clickOnElementWithWait(driver, addPhotoReview);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		if (WebDriverUtils.findElement(driver, addPhotoModal) != null) {
			WebDriverUtils.clickOnElementWithWait(driver, choosePhotoReview);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
			// Upload the file
		}
	}

	public void addVideo(String videoURL) {
		WebDriverUtils.clickOnElementWithWait(driver, addVideoReview);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		if (WebDriverUtils.findElement(driver, videoModalReview) != null) {
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
			WebDriverUtils.enterTextBox(driver, insertVideoURLReview, videoURL);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
			WebDriverUtils.clickOnElementWithWait(driver, addVideoButton);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		}
	}

	public void recommendProductYes() {
		WebDriverUtils.clickOnElementWithWait(driver, recommendProductYes);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void recommendProductNo() {
		WebDriverUtils.clickOnElementWithWait(driver, recommendProductNo);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void userInfoReview(String nickname, String userLocationReview, String email) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, nicknameReview, nickname);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, userLocation, userLocationReview);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.enterTextBox(driver, emailReview, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
	}

	public void selectAttributeLength(String lengthSize) {
		WebDriverUtils.enterTextBox(driver, lengthLocator, lengthSize);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void postReview() {
		WebDriverUtils.clickOnElementWithWait(driver, postReviewButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	
	}

	public void addToCart() {
		WebDriverUtils.clickOnElementWithWait(driver, addToBasket);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	
	}

	public void update() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, updateButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);

	}

	public MyBagPage returnMyBagPage() {
		WebDriverUtils.scrollLittDown(driver, addToBasket);
		WebDriverUtils.clickOnElementWithWait(driver, addToBasket);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_6000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(bonusDialog));
		return new MyBagPage(driver);
	}


	public MyAccountWishListPage returnMyAccountWishListPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.scrollLittDown(driver, wishList);
		WebDriverUtils.clickOnElementWithWait(driver, wishList);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_6000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishlistText));
		return new MyAccountWishListPage(driver);
	}

	public MyWishListPage returnMyWishListPage() {
		WebDriverUtils.scrollLittDown(driver, wishList);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, wishList);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_6000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishListText));
		return new MyWishListPage(driver);
	}

}

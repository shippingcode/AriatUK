package com.ariat.Enums;
import org.openqa.selenium.By;

/** Groups all available Core payment methods and their corresponding locators on the checkout page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public enum PaymentMethod {
	
	PAY_PAL("PayPal", By.xpath("//*[@id=\"checkoutItemsSwap2\"]/div/div/div/div[1]/span")),
	CREDIT_CARD("Credit Card", By.xpath("//*[@id=\"checkoutItemsSwap2\"]/div/div/div/div[3]/span")),
	KLARNA("Klarna", By.xpath("//*[@id=\"checkoutItemsSwap2\"]/div/div/div/div[4]/span")),
	PAY_PAL_CHECKOUT("PayPal", By.xpath("//*[@id=\"paypalExpressButtonf5157f5d2f07ab3f037fb79a23\"]/img"));
	
	private String name;
	private By locator;
	
	private PaymentMethod(String name, By locator) {
		this.name = name;
		this.locator = locator;
	}

	public String getName() {
		return name;
	}
	
	public By getLocator() {
		return locator;
	}
}

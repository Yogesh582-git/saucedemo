package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Your Cart']")
	WebElement cartText;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOut;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement conShopping;

	public String cartTextValidation() {
		return cartText.getText();
	}

	public void checkOutClk() {
		checkOut.click();
	}

	public void conShopping() {
		conShopping.click();
	}
}

package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[text()='Swag Labs']")
	WebElement title;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	WebElement sauceBackpacks;

	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
	WebElement sauceBLight;

	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	WebElement sauceBTshirt;

	@FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-backpack']")
	WebElement sauceBackpacksAddtoCart;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cart;

	public void addtoCartSBP() {
		sauceBackpacksAddtoCart.click();
	}

	public void clickCart() {
		cart.click();
	}

	public void sauseBlight() {
		sauceBLight.click();
	}
	public void sauceBshirt() {
		sauceBTshirt.click();
	}
}

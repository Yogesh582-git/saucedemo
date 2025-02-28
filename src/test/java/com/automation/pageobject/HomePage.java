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
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	WebElement sauseLabOnesie;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cart;
	
	@FindBy(xpath = "//button[text()='Open Menu']")
	WebElement menu;
	
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logOutbtn;
	public void clMenu() {
		menu.click();
	}
	public void logoutBtn() {
		logOutbtn.click();
	}

	public void addtoCartSBP() {
		sauceBackpacksAddtoCart.click();
	}
	
	public void addtoCartSLO() {
		sauseLabOnesie.click();
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

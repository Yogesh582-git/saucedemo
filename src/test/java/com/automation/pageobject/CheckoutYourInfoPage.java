package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInfoPage extends BasePage {
	WebDriver driver;

	public CheckoutYourInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	WebElement checkOutTxt;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Zip/Postal Code']")
	WebElement zipCode;

	@FindBy(id = "continue")
	WebElement conti;

	public String checkOutTxt() {
		return checkOutTxt.getText();
	}

	public void firstNam(String str) {
		firstName.sendKeys(str);
	}

	public void lastNam(String str) {
		lastName.sendKeys(str);
	}

	public void zipCode(Double n) {
		zipCode.sendKeys(String.valueOf(n));
	}
	public void contin() {
		conti.click();
	}
}

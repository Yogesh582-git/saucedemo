package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
	WebDriver driver;

	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Checkout: Complete!']")
	WebElement txtCheckOut;

	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	WebElement compTxt;

	@FindBy(xpath = "//button[text()='Back Home']")
	WebElement backBtn;

	public String txtCheckOut() {
		return txtCheckOut.getText();
	}

	public String compTxt() {
		return compTxt.getText();
	}

	public void backBtn() {
		backBtn.click();
	}
}

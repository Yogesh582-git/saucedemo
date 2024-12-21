package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passWord;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginButton;

	public void loginID(String str) {
		userName.sendKeys(str);
	}

	public void password(String str) {
		passWord.sendKeys(str);
	}

	public void loginBtn() {
		loginButton.click();
	}

}

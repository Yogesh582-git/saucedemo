package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutOverview extends BasePage {
	
	WebDriver driver;
	public CheckOutOverview(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	WebElement checkOutTxt;
	
	@FindBy(xpath="//button[text()='Finish']")
	WebElement finishBtn;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelBtn;
	
	public String getTxt() {
		return checkOutTxt.getText();
	}
	
	public void cliFinish() {
		finishBtn.click();
	}
	
	public void canClick() {
		cancelBtn.click();
	}
	

}

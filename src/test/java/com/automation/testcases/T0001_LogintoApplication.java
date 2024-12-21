package com.automation.testcases;

import org.testng.annotations.Test;

import com.automation.pageobject.CheckoutYourInfoPage;
import com.automation.pageobject.HomePage;
import com.automation.pageobject.LoginPage;

public class T0001_LogintoApplication extends BaseClass {
	@Test
	public void loginApp() {
		LoginPage lp= new LoginPage(driver);
		lp.loginID("standard_user");
		lp.password("secret_sauce");
		lp.loginBtn();
		
		HomePage hp= new HomePage(driver);
		hp.addtoCartSBP();
		hp.clickCart();
		
		CheckoutYourInfoPage cyi=new CheckoutYourInfoPage(driver);
		cyi.firstNam("Swamy");
		cyi.lastNam("saranam");
		cyi.zipCode(234567.00);
	}

}

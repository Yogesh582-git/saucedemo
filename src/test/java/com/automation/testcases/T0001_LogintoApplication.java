package com.automation.testcases;

import org.testng.annotations.Test;

import com.automation.pageobject.CartPage;
import com.automation.pageobject.CheckOutOverview;
import com.automation.pageobject.CheckoutYourInfoPage;
import com.automation.pageobject.HomePage;
import com.automation.pageobject.LoginPage;

public class T0001_LogintoApplication extends BaseClass {
	@Test(groups = {"sanity","master"})
	public void loginApp() {
		
		logger.info("============Home Page Launched========== ");
		LoginPage lp= new LoginPage(driver);
		lp.loginID(pr.getProperty("userName"));
		lp.password(pr.getProperty("password"));
//		lp.loginID(pr.getProperty("userName"));
//		lp.password(pr.getProperty("password"));
		lp.loginBtn();
		
		logger.info("============Cart Page Launched========== ");
		HomePage hp= new HomePage(driver);
		hp.addtoCartSBP();
		hp.clickCart();
		
		logger.info("============Login Page Launched========== ");

		CartPage cp = new CartPage(driver);
		cp.checkOutClk();
		
		CheckoutYourInfoPage cyi=new CheckoutYourInfoPage(driver);
		cyi.firstNam("Swamy");
		cyi.lastNam("saranam");
		cyi.zipCode(234567.00);
		cyi.contin();
		
		logger.info("******CO page launch started*******");
		CheckOutOverview co = new CheckOutOverview(driver);
		co.cliFinish();

	}

}

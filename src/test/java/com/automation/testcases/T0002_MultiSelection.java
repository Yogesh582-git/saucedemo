package com.automation.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.automation.pageobject.CartPage;
import com.automation.pageobject.CheckOutOverview;
import com.automation.pageobject.CheckoutCompletePage;
import com.automation.pageobject.CheckoutYourInfoPage;
import com.automation.pageobject.HomePage;
import com.automation.pageobject.LoginPage;

public class T0002_MultiSelection extends BaseClass {
	@Test(groups = {"master"})
	public void loginApp() {
		try {
			logger.info("******lp page launch started*******");
			LoginPage lp = new LoginPage(driver);
			lp.loginID("standard_user");
			lp.password("secret_sauceaaa");
			lp.loginBtn();

			logger.info("******hp page launch started*******");
			HomePage hp = new HomePage(driver);
//			hp.addtoCartSBP();
//			hp.sauceBshirt();
			hp.sauseBlight();
			hp.clickCart();

			logger.info("******cp page launch started*******");
			CartPage cp = new CartPage(driver);
			cp.checkOutClk();

			logger.info("******CYI page launch started*******");
			CheckoutYourInfoPage cyi = new CheckoutYourInfoPage(driver);
			cyi.firstNam("Swamy");
			cyi.lastNam("saranam");
			cyi.zipCode(234567.00);
			cyi.contin();

			logger.info("******CO page launch started*******");
			CheckOutOverview co = new CheckOutOverview(driver);
			co.cliFinish();

			logger.info("******CC page launch started*******");
			CheckoutCompletePage cc = new CheckoutCompletePage(driver);
			String expTxt = cc.compTxt();
			AssertJUnit.assertEquals(expTxt, "Thank you for your order!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("debug logger");
			logger.error("error log");
			AssertJUnit.fail();
		}

	}
}

package com.automation.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.automation.pageobject.CartPage;
import com.automation.pageobject.CheckOutOverview;
import com.automation.pageobject.CheckoutCompletePage;
import com.automation.pageobject.CheckoutYourInfoPage;
import com.automation.pageobject.HomePage;
import com.automation.pageobject.LoginPage;

public class T0003_SelectandDeselectItems extends BaseClass {
	@Test(groups= {"smoke","master"})
	public void deSelect() {

		try {

			logger.info("============Home Page Launched========== ");
			LoginPage lp = new LoginPage(driver);
			lp.loginID("standard_useraaa");
			lp.password("secret_sauce");
			lp.loginBtn();

			logger.info("============HP Page Launched========== ");

			HomePage hp = new HomePage(driver);
			hp.addtoCartSBP();
			hp.addtoCartSLO();
			hp.clickCart();

			logger.info("============CP Page Launched========== ");

			CartPage cp = new CartPage(driver);
			cp.sauceLS();
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

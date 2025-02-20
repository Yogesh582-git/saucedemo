package com.automation.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.automation.pageobject.HomePage;
import com.automation.pageobject.LoginPage;
import com.automation.utilities.DataProviders;

public class T0004_MultiLogin extends BaseClass {

	@Test(dataProvider = "logindata", dataProviderClass = DataProviders.class,groups = {"master"})
	public void multiLogin(String UserName, String Password) {
		logger.info("============Multi Login Launched========== ");
		try {
			LoginPage lp = new LoginPage(driver);
			lp.loginID(UserName);
			lp.password(Password);
			lp.loginBtn();
			
			HomePage hp=new HomePage(driver);
			hp.clMenu();
			hp.logoutBtn();
					

		} catch (Exception e) {
			logger.debug("debug logger");
			logger.error("error log");
			
		}

	}

}

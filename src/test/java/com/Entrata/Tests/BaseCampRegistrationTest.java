package com.Entrata.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Entrata.BasePage.BaseClass;
import com.Entrata.pageObjects.BaseCampPage;
import com.Entrata.pageObjects.LoginPage;
import com.Entrata.utils.Utils;

public class BaseCampRegistrationTest extends BaseClass {

	LoginPage login = new LoginPage(driver);
	BaseCampPage baseCamp = new BaseCampPage(driver);
	Utils ui = new Utils();

	@BeforeMethod
	public void startApplication() {
		System.out.println("................... Start Base Camp Registration Test ...................");

	}

	@AfterMethod
	public void closeApplication() {

		System.out.println("................... Ended Base Camp Registration Test .................");
	}

	@Test
	public void BaseCampRegistration() {

		login.clickOnTheAcceptCookies();
		baseCamp.navigateToBaseCampManu();
		ui.switchToWindow(driver, 1);

		ui.assertTrue(baseCamp.verifyBaseCampNavigated(), "Base Camp Register Now Page Navigated Successfully.",
				"Base Camp Register Now Page Not Navigated Successfully.");

		baseCamp.clickOnTheRegisterNow();
		baseCamp.clickOnTheConfirmRegister();

		ui.assertTrue(baseCamp.verifyBaseCampForm(), "Base Camp Registeration Form Displayed Successfully.",
				"Base Camp Registeration Form Not Displayed Successfully.");

	}

}

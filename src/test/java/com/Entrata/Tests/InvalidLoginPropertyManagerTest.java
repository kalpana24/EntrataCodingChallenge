package com.Entrata.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Entrata.BasePage.BaseClass;
import com.Entrata.pageObjects.LoginPage;
import com.Entrata.utils.Utils;

public class InvalidLoginPropertyManagerTest extends BaseClass {
	LoginPage login = new LoginPage(driver);
	Utils ui = new Utils();

	@BeforeMethod
	public void startApplication() {
		System.out.println("................... Start Login Property Manager Test ...................");

	}

	@AfterMethod
	public void closeApplication() {

		System.out.println("................... Ended Login Property Manager Test .................");
	}

	@Test
	public void InvalidLoginPropertyManager() {

		login.clickOnTheAcceptCookies();
		login.clickOnTheSignInButton();

		login.clickOnThePropertyManagerLoginButton();

		ui.assertTrue(login.verifySignEntrataPage(), "Sign in to Entrata Page Navigated Successfully",
				"Sign in to Entrata Page Not Navigated Successfully");

		login.enterUsername("PropertyManager");
		login.enterPassword("123");
		login.clickOnTheLoginButton();

		ui.assertTrue(login.VerifyLoginError(), "The username and password provided are Not valid.",
				"The username and password provided are valid");

	}

}

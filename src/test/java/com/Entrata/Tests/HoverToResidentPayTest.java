package com.Entrata.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Entrata.BasePage.BaseClass;
import com.Entrata.pageObjects.HoverToResidentPayPage;
import com.Entrata.pageObjects.LoginPage;
import com.Entrata.utils.Utils;

public class HoverToResidentPayTest extends BaseClass {
	LoginPage login = new LoginPage(driver);
	HoverToResidentPayPage hover = new HoverToResidentPayPage(driver);
	Utils ui = new Utils();

	@BeforeMethod
	public void startApplication() {
		System.out.println("................... Start Hover To Resident Pay Test ...................");

	}

	@AfterMethod
	public void closeApplication() {

		System.out.println("................... Ended Hover To Resident Pay Test .................");
	}

	@Test
	public void HoverToResidentPay() {

		login.clickOnTheAcceptCookies();
		hover.hoverToProducts(driver);
		hover.clickOnTheResidentPay();

		ui.assertTrue(hover.verifyScheduleDemoButton(), "hover To Resident Pay Successfully.",
				"hover To Resident Pay Successfully.");

		hover.clickOnTheScheduleDemo();

		ui.assertTrue(hover.verifyScheduleDemoForm(), "Schedule a demo Registeration Form Displayed Successfully.",
				"Schedule a demo Registeration Form Not Displayed Successfully.");

	}

}

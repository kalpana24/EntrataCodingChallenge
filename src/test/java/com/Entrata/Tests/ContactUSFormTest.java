package com.Entrata.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Entrata.BasePage.BaseClass;
import com.Entrata.pageObjects.BaseCampPage;
import com.Entrata.pageObjects.ContactUsPage;
import com.Entrata.pageObjects.LoginPage;
import com.Entrata.utils.Utils;

public class ContactUSFormTest extends BaseClass {
	LoginPage login = new LoginPage(driver);
	BaseCampPage baseCamp = new BaseCampPage(driver);
	Utils ui = new Utils();
	ContactUsPage contact = new ContactUsPage(driver);

	@BeforeTest
	public void startApplication() {
		System.out.println("................... Start Contact US Form Test ...................");

	}

	@AfterTest
	public void closeApplication() {

		System.out.println("................... Ended Contact US Form Test .................");
	}

	@Test
	public void ContactUSForm() {

		login.clickOnTheAcceptCookies();
		login.clickOnTheSignInButton();
		login.navigateToResidentLogin();
		login.clickOnTheViewWebsite();

		ui.assertTrue(contact.verifylinkContactUsPage(), "Welcome to Resident Portal Page Displayed",
				"Welcome to Resident Portal Page Not Displayed");

		contact.navigateToContactUsForm();
		contact.enterFullName("ABC DCF");

		contact.enterEmail("email@gmail.com");
		contact.enterPropertyName("CBD");
		contact.enterPropertyUrl("WWw.CBD.com");
		contact.selectCategory("Payments");
		contact.enterMessage("Text");

		ui.assertTrue(contact.verifySubmitButton(), "Contact Us Form Displayed", "Contact Us Form Not Displayed");

	}

}

package com.Entrata.BasePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void initializeDriver() throws IOException, InterruptedException {

		String userdirpath = System.getProperty("user.dir");
		FileInputStream ip = new FileInputStream(userdirpath + "\\src\\main\\resources\\_config.properties");

		Properties prop = new Properties();
		prop.load(ip);

		String url = (String) prop.get("URL");
		System.out.println("Application URL:- " + url);

		String browserName = prop.getProperty("browser");
		System.out.println("Browser:- " + browserName);

		System.setProperty("webdriver.chrome.driver", userdirpath + "\\driver\\chromedriver.exe");

		driver.get(url);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void terminateDriver() {

		driver.quit();
	}

}

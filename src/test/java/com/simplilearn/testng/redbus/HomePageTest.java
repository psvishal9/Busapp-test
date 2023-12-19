package com.simplilearn.testng.redbus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
	

	// step1: formulate a test domain url & driver path
	String siteUrl = "https://www.redbus.in/";
	String driverPath = "drivers/windows/geckodriver.exe";
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.geckodriver.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new FirefoxDriver();

		// step4: launch browser
		driver.get(siteUrl);
	}

	@AfterMethod
	public void cleanUp() {
		driver.quit();  // the quit() method closes all browser windows and ends the WebDriver session.
		// driver.close(); // the close() closes only the current window on which Selenium is running automated tests.The WebDriver session, however, remains active. 
	}

	@Test(description = "Test RedBus Home Page Title Match")
	public void testRedBusHomePageTitle() {
		String expectedTitle  = "Online Bus Ticket Booking with Best Offers and Lowest Price - redBus";
		String actualTitle  = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(description = "Test RedBus Home Page Source Url")
	public void testRedBusHomePageSourceUrl() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
	
	@Test(description = "Test RedBus Home Page Title Invalid Match")
	public void testRedBusHomePageTitle2() {
		String expectedTitle  = "OOnline BBus Ticket Booking with Best Offers and Lowest Price - redBus";
		String actualTitle  = driver.getTitle();
		assertNotEquals(actualTitle, expectedTitle);
	}
}



package com.simplilearn.testng.redbus;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CSSSelectorTest {
	
	// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.redbus.in/";
		String driverPath = "drivers/windows/geckodriver.exe";
		WebDriver driver;
		WebDriverWait wait;

		@BeforeMethod
		public void setUp() {

			// step2: set system properties for selenium dirver
			System.setProperty("webdriver.geckodriver.driver", driverPath);

			// step3: instantiate selenium webdriver
			driver = new FirefoxDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			// step4: launch browser
			driver.get(siteUrl);
		}

		@AfterMethod
		public void cleanUp() {
			driver.quit(); // the quit() method closes all browser windows and ends the WebDriver session.
			// driver.close(); // the close() closes only the current window on which
			// Selenium is running automated tests.The WebDriver session, however, remains
			// active.
		}

		@Test(description = "Test Bus Tickets Title Match")
		public void tdLinkTest1() {
			WebElement mobileLink = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bus_tickets_vertical > span")));

			System.out.println("Is link loaded :: " + mobileLink.isDisplayed());
			System.out.println("Is link is enabled :: " + mobileLink.isEnabled());

			mobileLink.click();

			String expectedTitle = "Online Bus Ticket Booking with Best Offers and Lowest Price - redBus";
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}

		@Test(description = "Test Bus Tickets Title Match")
		public void tdLinkTest2() {
			WebElement tdLink = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bus_tickets_vertical > span")));

			System.out.println("Is link loaded :: " + tdLink.isDisplayed());
			System.out.println("Is link is enabled :: " + tdLink.isEnabled());

			tdLink.click();

//			String expectedTitle = "Amazon.in - Deals";
//			String actualTitle = driver.getTitle();
//			assertEquals(actualTitle, expectedTitle);
		}

	}



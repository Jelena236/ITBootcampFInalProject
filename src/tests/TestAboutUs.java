package tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.AboutUs;
import objects.Home;
import resources.Constants;

public class TestAboutUs {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testAboutUsLink() {

		driver.navigate().to(Constants.HOME_URL);

		driver.manage().window().maximize();

		Home.closeAnnouncement(driver);

		Home.acceptCookies(driver);

		Home.clickOnAboutUs(driver);

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = Constants.ABOUTUS_URL;

		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Test
	public void testScreenshot() {

		AboutUs.takeScreenshot(driver);

		File copy = new File("C:/Users/PC/Desktop/ITbootcamp/autest.png");

		Assert.assertTrue(copy.canRead());

	}

	@AfterTest
	public void close() {
		driver.close();
	}

}

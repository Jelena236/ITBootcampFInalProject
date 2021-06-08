package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import resources.Constants;
import resources.Data;

public class TestLogin {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testClickLoginLink() {

		driver.navigate().to(Constants.HOME_URL);

		driver.manage().window().maximize();

		Home.closeAnnouncement(driver);

		Home.acceptCookies(driver);

		Home.clickLoginLink(driver);

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = Constants.LOGIN_FORM_URL;

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 2)
	public void testLoginForm() {
		driver.manage().window().maximize();

		Home.login(driver, Data.USERNAME, Data.PASSWORD);

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = Constants.USERSPAGE_URL;

		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@AfterTest
	public void close() {
		driver.close();
	}

}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import objects.Settings;
import resources.Constants;
import resources.Data;

public class TestSettings {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testLanguage() {
		Home.login(driver, Data.USERNAME, Data.PASSWORD);

		driver.navigate().to(Constants.SETTINGS_URL);

		Settings.changeLanguage(driver, Data.LANGUAGE);
		driver.navigate().refresh();

		Assert.assertTrue(driver.getPageSource().contains("Командна табла"));
	}

	@Test(priority = 2)
	public void testEmailNotifications() {

		Settings.disableNotifications(driver, Constants.NOTIF_EMAIL_ID);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Constants.NOTIF_EMAIL_ID)));

		Assert.assertFalse(driver.findElement(By.id(Constants.NOTIF_EMAIL_ID)).isSelected());

	}

	@Test(priority = 3)
	public void testSmsNotifications() {

		Settings.disableNotifications(driver, Constants.NOTIF_SMS_ID);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Constants.NOTIF_SMS_ID)));

		Assert.assertFalse(driver.findElement(By.id(Constants.NOTIF_SMS_ID)).isSelected());
	}

	@Test(priority = 4)
	public void testPushNotifications() {

		Settings.disableNotifications(driver, Constants.NOTIF_PUSH_ID);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Constants.NOTIF_PUSH_ID)));

		Assert.assertFalse(driver.findElement(By.id(Constants.NOTIF_PUSH_ID)).isSelected());
	}

	@AfterClass

	public void StartingSett() {

		driver.navigate().to(Constants.SETTINGS_URL);

		Settings.changeLanguage(driver, Data.ENGLISH);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Constants.NOTIF_EMAIL_ID)));

		driver.findElement(By.id(Constants.NOTIF_EMAIL_ID)).click();
		driver.findElement(By.id(Constants.NOTIF_SMS_ID)).click();
		driver.findElement(By.id(Constants.NOTIF_PUSH_ID)).click();

		driver.findElement(By.id(Constants.SETT_SAVE_ID)).click();

		driver.close();
	}

}

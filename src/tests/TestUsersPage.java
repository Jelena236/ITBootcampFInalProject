package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Home;
import objects.UsersPage;
import resources.Constants;
import resources.Data;

public class TestUsersPage {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testIcons() {

		Home.login(driver, Data.USERNAME, Data.PASSWORD);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		File f = new File("icons.xlsx");
		try {
			InputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);
			SoftAssert sa = new SoftAssert();

			for (int i = 1; i <= 8; i++) {
				Row row = sheet.getRow(i);
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);

				String css = c0.toString();
				String expectedTitle = c1.toString();

				UsersPage.clickIcons(driver, css);

				String actualTitle = driver.getTitle();

				sa.assertEquals(actualTitle, expectedTitle, css);

			}

			sa.assertAll();

			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void testStaffIcon() {
		driver.navigate().to(Constants.USERSPAGE_URL);
		UsersPage.iconShiftPlan(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String actualTitle = driver.getTitle();
		String expectedTitle = Constants.SHIFTPLAN_TITLE;

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 3)
	public void testAvailIcon() {
		driver.navigate().to(Constants.USERSPAGE_URL);
		UsersPage.iconAvailability(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String actualTitle = driver.getTitle();
		String expectedTitle = Constants.AVAIL_TITLE;

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}

}

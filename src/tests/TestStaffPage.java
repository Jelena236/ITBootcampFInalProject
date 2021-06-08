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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Home;
import objects.StaffPage;
import resources.Constants;
import resources.Data;

public class TestStaffPage {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testAddNewMember() {
		// Login
		Home.login(driver, Data.USERNAME, Data.PASSWORD);

		driver.navigate().to(Constants.STAFF_URL);

		// Import Excel
		File f = new File("empl.xlsx");
		try {
			InputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);

			Row row = sheet.getRow(0);
			Cell c0 = row.getCell(0);
			Cell c1 = row.getCell(1);
			Cell c2 = row.getCell(2);

			String firstName = c0.toString();
			String lastName = c1.toString();
			String email = c2.toString();

			StaffPage.addNewMember(driver, firstName, lastName, email);

			wb.close();

			driver.navigate().to(Constants.STAFF_URL);

			Assert.assertTrue(driver.getPageSource().contains(email));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 3)
	public void testChangeName() {
		driver.navigate().to(Constants.STAFF_URL);

		StaffPage.changeStaffName(driver, Data.NEWNAME);

		driver.navigate().to(Constants.STAFF_URL);

		Assert.assertTrue(driver.getPageSource().contains(Data.NEWNAME));

	}

	@Test(priority = 2)
	public void testAddSeveralMember() {

		driver.navigate().to(Constants.STAFF_URL);

		File f = new File("empl.xlsx");
		try {
			InputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);
			SoftAssert sa = new SoftAssert();

			for (int i = 1; i <= 5; i++) {
				Row row = sheet.getRow(i);
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);
				Cell c2 = row.getCell(2);

				String firstName = c0.toString();
				String lastName = c1.toString();
				String email = c2.toString();

				StaffPage.addNewMember(driver, firstName, lastName, email);

				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.elementToBeClickable(By.id(Constants.ADDEMPL_BTN_ID)));

				driver.navigate().to(Constants.STAFF_URL);

				sa.assertTrue(driver.getPageSource().contains(email), email);

			}

			sa.assertAll();

			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void deleteAllStaff() {
		driver.findElement(By.xpath("//*[@id=\"staff-list-container\"]/div[1]/div/div[1]/span/input")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"_topnav\"]/button[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement manage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"manageAccount\"]/label/span")));
		manage.click();
		driver.findElement(By.xpath("//*[@id=\"_cd_staff\"]/div[2]/div[2]/div/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"_cd_staff\"]/div[2]/div[2]/div/div/button")).click();
		driver.switchTo().alert().accept();
		driver.close();
	}

}

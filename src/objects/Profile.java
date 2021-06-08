package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Constants;

public class Profile {

	public static void changeUsername(WebDriver driver, String newUsername) {
		driver.findElement(By.cssSelector(Constants.PROFILE_BAR_CSS)).click();
		driver.findElement(By.xpath(Constants.PROFILE_LINK_XPATH)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.EDITDETAILS_XPATH)));
		driver.findElement(By.xpath(Constants.EDITDETAILS_XPATH)).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Constants.USERNAME_ID)));
		driver.findElement(By.id(Constants.USERNAME_ID)).clear();
		driver.findElement(By.id(Constants.USERNAME_ID)).sendKeys(newUsername);
		driver.findElement(By.cssSelector(Constants.SAVE_BTN_CSS)).click();

		driver.navigate().refresh();
	}

	public static void uploadPhoto(WebDriver driver, String photoPath) {
		driver.findElement(By.cssSelector(Constants.PROFILE_BAR_CSS)).click();
		driver.findElement(By.xpath(Constants.PROFILE_LINK_XPATH)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.EDITDETAILS_XPATH)));
		driver.findElement(By.xpath(Constants.EDITDETAILS_XPATH)).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(Constants.ADDPHOTO_ID)).sendKeys(photoPath);

	}

	public static void changeEmployeeRate(WebDriver driver, String rate) {
		driver.findElement(By.cssSelector(Constants.PROFILE_BAR_CSS)).click();
		driver.findElement(By.xpath(Constants.PROFILE_LINK_XPATH)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.PAYROLL_LINK_XPATh)));
		driver.findElement(By.xpath(Constants.PAYROLL_LINK_XPATh)).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Constants.RATE_FIELD_XPATH)));

		driver.findElement(By.xpath(Constants.RATE_FIELD_XPATH)).clear();
		driver.findElement(By.xpath(Constants.RATE_FIELD_XPATH)).sendKeys(rate);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(Constants.SAVE_RATE_XPATH)).click();

	}

}

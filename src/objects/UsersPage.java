package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.Constants;

public class UsersPage {

	public static void iconShiftPlan(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(Constants.SHIFTPLANICON_XPATH)).click();
	}

	public static void iconAvailability(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(Constants.AVAILICON_XPATH)).click();
	}

	public static void clickIcons(WebDriver driver, String css) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(css)).click();
	}
}

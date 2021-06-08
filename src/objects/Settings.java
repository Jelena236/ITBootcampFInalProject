package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Constants;

public class Settings {

	public static void changeLanguage(WebDriver driver, String language) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.LANGUAGEDRP_XPATH)));
		Select drpLanguage = new Select(driver.findElement(By.xpath(Constants.LANGUAGEDRP_XPATH)));
		drpLanguage.selectByValue(language);
		driver.findElement(By.id(Constants.SETT_SAVE_ID)).click();
		driver.navigate().refresh();

	}

	public static void disableNotifications(WebDriver driver, String id) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));

		if (driver.findElement(By.id(id)).isSelected()) {
			driver.findElement(By.id(id)).click();

			driver.findElement(By.id(Constants.SETT_SAVE_ID)).click();
			driver.navigate().refresh();

		}

	}

}

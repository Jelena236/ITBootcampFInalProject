package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Constants;

public class StaffPage {

	public static void addNewMember(WebDriver driver, String firstName, String lastName, String email) {

		WebDriverWait wait = new WebDriverWait(driver, 7);
		WebElement addEmpBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id(Constants.ADDEMPL_BTN_ID)));
		addEmpBtn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id(Constants.ADDEMP_FN_ID)).sendKeys(firstName);
		driver.findElement(By.id(Constants.ADDEMP_LN_ID)).sendKeys(lastName);
		driver.findElement(By.id(Constants.ADDEMP__EM_ID)).sendKeys(email);
		driver.findElement(By.id(Constants.SAVEEMP_ID)).click();

	}

	public static void changeStaffName(WebDriver driver, String newName) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Constants.EMP1_LINK_XPATH)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.EMPEDIT_LINK_XPATH)));
		edit.click();
		WebElement fName = wait.until(ExpectedConditions.elementToBeClickable(By.id(Constants.EDIT_FN_ID)));
		fName.clear();
		fName.sendKeys(newName);
		driver.findElement(By.name(Constants.SAVECHANGE_NAME)).click();
		driver.navigate().to(Constants.STAFF_URL);
	}

	public static void upoloadPhoto(WebDriver driver, String photoPath) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Constants.EMP1_LINK_XPATH)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.EMPEDIT_LINK_XPATH)));
		edit.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(Constants.EDIT_FN_ID)));
		driver.findElement(By.id(Constants.UPLOADP_BTN_ID)).sendKeys(photoPath);
	}

}

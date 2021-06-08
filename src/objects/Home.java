package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Constants;

public class Home {

	public static void closeAnnouncement(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement announBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.CLOSEBTN_ANNO_CSS)));
		announBtn.click();
	}

	public static void acceptCookies(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement cookies = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.ACC_COOKIESBTN_CSS)));
		cookies.click();
	}

	public static void clickOnAboutUs(WebDriver driver) {
		driver.findElement(By.xpath(Constants.ABOUTUS_HEADER_XPATH)).click();
		driver.findElement(By.xpath(Constants.ABOUTUS_LINK_XPATH)).click();
	}

	public static void clickLoginLink(WebDriver driver) {
		driver.findElement(By.xpath(Constants.LOGIN_LINK_XPATH)).click();
	}

	public static void login(WebDriver driver, String username, String password) {
		driver.navigate().to(Constants.LOGIN_FORM_URL);
		driver.manage().window().maximize();

		driver.findElement(By.id(Constants.USERNAMEFIELD_ID)).sendKeys(username);
		driver.findElement(By.id(Constants.PASSWORDFIELD_ID)).sendKeys(password);
		driver.findElement(By.name(Constants.LOGINBTN_NAME)).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.DASHBOARDICON_XPATH)));

	}

}

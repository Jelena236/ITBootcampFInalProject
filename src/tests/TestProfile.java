package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import objects.Profile;
import resources.Constants;
import resources.Data;

public class TestProfile {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority=1)
	public void testChangeusername() {
		//Login
		Home.login(driver, Data.USERNAME, Data.PASSWORD);
		
		Profile.changeUsername(driver, Data.NEWUSERNAME);
			

}
	@Test(priority=2)
	public void testChangeRate() {
		driver.navigate().to(Constants.USERSPAGE_URL);

		Profile.changeEmployeeRate(driver, Data.RATE);
		
		driver.close();
	}
}
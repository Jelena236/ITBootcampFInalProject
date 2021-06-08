package objects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AboutUs {

	public static void takeScreenshot(WebDriver driver) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:/Users/PC/Desktop/ITbootcamp/autest.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

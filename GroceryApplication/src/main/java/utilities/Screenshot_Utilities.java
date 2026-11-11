package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot_Utilities {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException { //WebDriver driver - pass driver, String failedTestCase -- to fetch failed test case

		TakesScreenshot scrShot = (TakesScreenshot) driver;//TakesScreenshot is a predefined interface to take screenshot. Apply Casting to pass driver
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//to store the captured screenshot. OutputType.FILE -- format is file type. Temporary storing

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//day, month, year, hours, minute, second the screenshot taken is stored in the variable timeStamp

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory. to save the screenshot in folder. to get the local path of project --System.getProperty("user.dir"), OutputScreenShot -- foldername
		if (!f1.exists()) { //stored in f1. f1 not exist f1.mkdirs() is used to repeat the
			//previous line

		f1.mkdirs();
		}
		String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedTestCase + timeStamp//local path, folder, failed testcase -- method name of failed tc, timestamp -- date and time screenshot taken
		+ ".png"; // stored in .png format
		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
		// ".png";

		File finalDestination = new File(destination);// details such as failedtestcase, timestamp, etc..in the destination is given in final destination 
		FileHandler.copy(screenShot, finalDestination);//import selenium.io
		} //copy the captured images that was stored in the file named screenShot.

}

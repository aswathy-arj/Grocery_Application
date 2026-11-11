package main_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.Screenshot_Utilities;

public class GA_Base {
public WebDriver driver;//WebDriver is a predefined interface to launch browser

Properties property;
FileInputStream file;//these are two predefined classes
	
	@BeforeMethod(alwaysRun = true)//automatically run even if grouping is added
	@Parameters("browsers")
	public void intializebrowser(String browsers) throws IOException {
		property=new Properties();
		file=new FileInputStream(Constant.CONFIG_FILE);//object creation can't be done directly --- error in new FileInputStream() -- need to give path  
		property.load(file);//to load the file load() method is used -- load() is under a predefined class called Properties.
		if(browsers.equalsIgnoreCase("chrome")) { //equalsIgnoreCaseis used to avoid case sensitivity
			
		driver = new ChromeDriver(); // to initialize browser
		}
		else if(browsers.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(property.getProperty("url"));// to get the loaded url getProperty() is used
		driver.manage().window().maximize();//to maximize the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicitlyWait() used to apply implicit wait. We can't enter the duration directly.We need to use a predefined class called "Duration"
	}
	@AfterMethod(alwaysRun = true)//automatically run even if grouping is added
	//public void closebrowser() {
	public void closeBrowser(ITestResult itestresult) throws IOException{//ITestResult is an interface used to provide the status of tc. 
		if(itestresult.getStatus()==ITestResult.FAILURE) {//need to take screenshot if tc fails
			Screenshot_Utilities screenshotutility=new Screenshot_Utilities();//create obj
			screenshotutility.getScreenshot(driver, itestresult.getName());//pass driver. getName() to get failed tc 
		}
		 // driver.close();
		//driver.quit();
	}
		//driver.close();//closes current tab only
		//driver.quit();//closes all tabs
	}




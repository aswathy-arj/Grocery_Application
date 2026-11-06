package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import assignment_01.TestNGBase;
import constant.Constant;
import pages.Home_Page;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class Login_Test extends TestNGBase{
	Home_Page home;//to refer 
	@Test(priority=1,description="user is trying to login with valid credentials")
	//To execute the Testcases in order using priority concept.
	//To describe what happens in a testcase description is used
	public void userLoginWithValidCredentials() throws IOException {
		String username = Excel_Utilities.readStringData(0, 0, "LoginData");
		String password = Excel_Utilities.readStringData(0, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password);//code repetition -- chaining of pages is used to reduce this code repetition
		//calling password and username 
		
		home = toAccessLoginPage.clickSignInButton();//
		boolean dashboardValue = toAccessLoginPage.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashboardValue, Constant.VALID_CREDENTIAL_ERROR);//error message is given in constant class
	}
	@Test(priority=2, description="user is trying to login with invalid credentials", groups="smoke", retryAnalyzer= retry.RetryMechanism.class)//retry mechanism should be used in case of flaky testcases
	public void userLoginWithInvalidCredentials() throws IOException {
		String username = Excel_Utilities.readStringData(1, 0, "LoginData");
		String password = Excel_Utilities.readStringData(1, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password).clickSignInButton();
		//connected because as we apply invalid credential stay in login page, so login click also connected.
		
		
		String actualResult = toAccessLoginPage.verifyWhethertext7artsSuperMarketisDisplayed();
		String expectedResult = "7rmart supermarket"; //to check 
		Assert.assertEquals(actualResult, expectedResult, Constant.INVALID_CREDENTIAL_ERROR);
	}
	@Test(priority=3,description="user is trying to login with valid username and invalid password")
	public void userLoginWithValidUsenameInvalidPassword() throws IOException {
		String username = Excel_Utilities.readStringData(2, 0, "LoginData");
		String password = Excel_Utilities.readStringData(2, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password).clickSignInButton();
		
		
		String actualResult = toAccessLoginPage.verifyWhethertext7artsSuperMarketisDisplayed();
		String expectedResult = "7rmart supermarket"; //to check 
		Assert.assertEquals(actualResult, expectedResult, Constant.VALIDUSERNAME_INVALIDPASSWORD);
	}
	@Test(priority=4,description="user is trying to login with invalid username and valid password", groups="smoke", dataProvider="loginData")
	public void userLoginWithInvalidUsernameValidPassword(String username, String password) throws IOException {
		//String username = Excel_Utilities.readStringData(3, 0, "LoginData");
		//String password = Excel_Utilities.readStringData(3, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password).clickSignInButton();
		
		
		String actualResult = toAccessLoginPage.verifyWhethertext7artsSuperMarketisDisplayed();
		String expectedResult = "7rmart supermarket"; //to check 
		Assert.assertEquals(actualResult, expectedResult, Constant.INVALIDUSERNAME_VALIDPASSWORD);
	}
	@DataProvider(name="loginData")
	public Object[][] getDatafromDataProvider(){//Object is the return type to be used here
		return new Object[][] {
			new Object[] {"admin00","admin"}, new Object[] {"admin45","admin"}
					
			};//error happens --- put semicolon
		}
	}



package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import assignment_01.TestNGBase;
import constant.Constant;
import pages.Home_Page;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class Home_Test extends TestNGBase{
	Home_Page toLogout;
	@Test(description="user is trying to logout")
	public void verifyWhetherUserIsAbleToLogout() throws IOException {
		String username = Excel_Utilities.readStringData(0, 0, "LoginData");
		String password = Excel_Utilities.readStringData(0, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password);
		
		toLogout = toAccessLoginPage.clickSignInButton();
		
			toLogout.clickAdmin();
			
			toAccessLoginPage = toLogout.clicklogout();
			
			String actualResult = toAccessLoginPage.verifyWhethertext7artsSuperMarketisDisplayed();
			String expectedResult = "7rmart supermarket"; //to check 
			Assert.assertEquals(actualResult, expectedResult, Constant.LOGOUT);
			
		
	}
	


}

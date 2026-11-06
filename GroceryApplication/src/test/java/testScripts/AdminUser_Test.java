package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import assignment_01.TestNGBase;
import constant.Constant;
import pages.AdminUser_Page;
import pages.Home_Page;
import pages.Login_Page;
import utilities.Excel_Utilities;
import utilities.RandomDataUtility;

public class AdminUser_Test extends TestNGBase{
	Home_Page newHome;
	AdminUser_Page auPage;
	@Test(description="user is trying to add new admin user")
	public void verifyWhetherUserIsAbleToAddNewAdminUsers() throws IOException {
		String username = Excel_Utilities.readStringData(0, 0, "LoginData");
		String password = Excel_Utilities.readStringData(0, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password);
		
		newHome = toAccessLoginPage.clickSignInButton();
		
		//Home_Page toClickMoreInfo = new Home_Page(driver);
		auPage=newHome.clickMoreInfo();
		
		RandomDataUtility random = new RandomDataUtility(); // to use the method from "RandomDataUtility" class create object of class "RandomDataUtility" 
		String newuser = random.generateRandomUsername();
		String newpass = random.generateRandomPassword();
		
		auPage.clickNew().enterUsername(newuser).enterPassword(newpass).usertypeDropdown().clickSaveButton();
		
		//AdminUser_Page toClickNew = new AdminUser_Page(driver);
		
		//String newuser = Excel_Utilities.readStringData(5, 0, "NewUserCreation");
		//String newpass = Excel_Utilities.readStringData(5, 1, "NewUserCreation");
		
		//to generate random data(no need to use excel)
		
		
		//AdminUser_Page enterUserDetails = new AdminUser_Page(driver);
		
		
		boolean alertMessage = auPage.verifyWhetherAlertMessageIsDisplayed();
		Assert.assertTrue(alertMessage, Constant.ADD_NEW_ADMINUSERS);//to call assertion
		
	}
	
	
	@Test(description="user is trying to search an admin user")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedAdminUser() throws IOException {
		
		String username = Excel_Utilities.readStringData(0, 0, "LoginData");
		String password = Excel_Utilities.readStringData(0, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password);
		
		newHome = toAccessLoginPage.clickSignInButton();
		
		//Home_Page toClickMoreInfo = new Home_Page(driver);
		newHome.clickMoreInfo();
		
		String searchuser = Excel_Utilities.readStringData(0, 0, "SearchNewUser");
		//AdminUser_Page searchUser = new AdminUser_Page(driver);
		
		auPage.toClickSearch().searchByUsername(searchuser).usertypeDd().clickSearchButton();
		
		String actualResult = auPage.toViewDataInTable();
		String expectedResult = "demodata"; //to check actual result matches expected result
		Assert.assertEquals(actualResult, expectedResult, Constant.SEARCH_ADMINUSERS);
	}
		
		
}

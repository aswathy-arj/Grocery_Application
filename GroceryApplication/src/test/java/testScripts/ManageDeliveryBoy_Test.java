package testScripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import assignment_01.TestNGBase;
import constant.Constant;
import pages.AdminUser_Page;
import pages.Home_Page;
import pages.Login_Page;
import pages.ManageDeliveryBoy_Page;
import utilities.Excel_Utilities;
import utilities.RandomDataUtility;

public class ManageDeliveryBoy_Test extends TestNGBase{
	ManageDeliveryBoy_Page manage;
	Home_Page hp;
	@Test(description="user is trying to add new delivery boy")
	public void verifywhetherUserIsAbleToAddNewDeliveryBoy() throws IOException {
		String username = Excel_Utilities.readStringData(0, 0, "LoginData");
		String password = Excel_Utilities.readStringData(0, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password);
		
		hp=toAccessLoginPage.clickSignInButton();
		
		//Home_Page toClickMoreInfoOfDeliveryBoy = new Home_Page(driver);
		manage=hp.clickMoreInfoDeliveryBoy();
		
		String name = Excel_Utilities.readStringData(1, 0, "NewDeliveryBoy");
		String email = Excel_Utilities.readStringData(1, 1, "NewDeliveryBoy");
		String phone = Excel_Utilities.readStringData(1, 2, "NewDeliveryBoy");
		String address = Excel_Utilities.readStringData(1, 3, "NewDeliveryBoy");
		String userName = Excel_Utilities.readStringData(1, 4, "NewDeliveryBoy");
		String passWord = Excel_Utilities.readStringData(1, 5, "NewDeliveryBoy");
		
		//ManageDeliveryBoy_Page clickNew = new ManageDeliveryBoy_Page(driver);
		manage.toclickNew().enterName(name).enterEmail(email).enterPhoneNum(phone).enterAddress(address).enterUsername(userName).enterPassword(passWord).clickSaveButton();
		
		
		//RandomDataUtility randomvalue = new RandomDataUtility();
		//String email = randomvalue.generateEmail();
		//String phone = randomvalue.generatePhoneNumber();
		//String userName = randomvalue.generateRandomUsername();
		//String passWord = randomvalue.generateRandomPassword();
		
		//ManageDeliveryBoy_Page enterDeliveryBoyDetails = new ManageDeliveryBoy_Page(driver);
		
		
		boolean alertMessage = manage.verifyWhetherAlertMessageIsDisplayed();
		Assert.assertTrue(alertMessage, Constant.ADD_DELIVERYBOY);
	}
	
	@Test(description="user is trying to search a delivery boy")
	public void verifyWhetherUserisAbleToSearchDeliveryBoy() throws IOException {
		
		String username = Excel_Utilities.readStringData(0, 0, "LoginData");
		String password = Excel_Utilities.readStringData(0, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password);
		
		hp=toAccessLoginPage.clickSignInButton();
		
		manage=hp.clickMoreInfoDeliveryBoy();
		
		//ManageDeliveryBoy_Page DeliveryBoySearch = new ManageDeliveryBoy_Page(driver);
		String n = Excel_Utilities.readStringData(0, 0, "NewDeliveryBoy");
		String e = Excel_Utilities.readStringData(0, 1, "NewDeliveryBoy");
		String ph = Excel_Utilities.readStringData(0, 2, "NewDeliveryBoy");
		
		
		manage.clickSearchButton().enterDeliveryBoyName(n).enterDeliveryBoyEmail(e).enterDeliveryBoyPhone(ph).clickSearchButton1();
		
		
		String actualResult = manage.toViewDataInTable();
		String expectedResult = "Aswin"; //to check actual result matches expected result
		Assert.assertEquals(actualResult, expectedResult, Constant.SEARCH_DELIVERYBOY);
		
	}
	
	

}

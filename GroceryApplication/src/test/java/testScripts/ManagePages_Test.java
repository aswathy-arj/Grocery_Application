package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import assignment_01.TestNGBase;
import constant.Constant;
import pages.AdminUser_Page;
import pages.Home_Page;
import pages.Login_Page;
import pages.ManagePages_Page;
import utilities.Excel_Utilities;

public class ManagePages_Test extends TestNGBase{
	ManagePages_Page mpPage;
	Home_Page hpPage;
	@Test
	public void verifyWhetherUserIsAbleToAddNewPage() throws IOException {
		String username = Excel_Utilities.readStringData(0, 0, "LoginData");
		String password = Excel_Utilities.readStringData(0, 1, "LoginData");
		
		Login_Page toAccessLoginPage = new Login_Page(driver);
		toAccessLoginPage.enterUsername(username).enterPassword(password);
		
		hpPage=toAccessLoginPage.clickSignInButton();
		
		//Home_Page toClickMoreInfo = new Home_Page(driver);
		mpPage = hpPage.clickMoreInfoOfManagePages();
		
		//ManagePages_Page clickNewButton = new ManagePages_Page(driver); 
		
		String title = Excel_Utilities.readStringData(0, 0, "ManagePagesCreation");
		String description = Excel_Utilities.readStringData(0, 1, "ManagePagesCreation");
		String page = Excel_Utilities.readStringData(0, 2, "ManagePagesCreation");
		
		mpPage.clickNewButton().enterTitle(title).enterDescription(description).enterPage(page).clickSaveButton();
		
		//ManagePages_Page toEnterPageDetails = new ManagePages_Page(driver)
		
		boolean alertmessage = mpPage.verifyWhetherAlertMessageIsDisplayed();
		Assert.assertTrue(alertmessage, Constant.MANAGE_PAGES);
	
		}
	
	@Test
	public void verifyWhetherUserIsAbleToSearchPage() throws IOException {
			String username = Excel_Utilities.readStringData(0, 0, "LoginData");
			String password = Excel_Utilities.readStringData(0, 1, "LoginData");
			
			Login_Page toAccessLoginPage = new Login_Page(driver);
			toAccessLoginPage.enterUsername(username).enterPassword(password);
			
			hpPage=toAccessLoginPage.clickSignInButton();
			
			
			mpPage = hpPage.clickMoreInfoOfManagePages();
			
			//ManagePages_Page toSearchPage = new ManagePages_Page(driver);
			String title = Excel_Utilities.readStringData(0, 0, "ManagePagesCreation");
			
			mpPage.toClickSearch().toEnterTitle(title).toClickSearchButton();
			
			//ManagePages_Page toEnterPageDetails = new ManagePages_Page(driver);
			
			
			//ManagePages_Page toConfirmSearch = new ManagePages_Page(driver);
			//toConfirmSearch.toClickSearchButton();
			
			String actualResult = mpPage.assertTableContent();
			String expectedResult = "TestTitle"; //to check actual result matches expected result
			Assert.assertEquals(actualResult, expectedResult, Constant.SEARCH_PAGES);
		}

}

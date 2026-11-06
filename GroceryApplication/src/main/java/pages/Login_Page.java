package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utility;

public class Login_Page {
	
	public WebDriver driver;
	Wait_Utility wait = new Wait_Utility();// object created to Wait_utility class to apply wait for sign in button
	
	public Login_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(name="username")WebElement user;
	public Login_Page enterUsername(String username) {//changed void and gave the landing page(Login_Page)
		user.sendKeys(username);
		return this;//to avoid repetition of Login_Page
	}
	
	@FindBy(name="password")WebElement pass;
	public Login_Page enterPassword(String password) {
		pass.sendKeys(password);
		return this;
	}
	
	@FindBy(xpath = "//button[text()='Sign In']")WebElement button;
	public Home_Page clickSignInButton() {//changed void to Home_Page because on clicking signIn button navigates to new page
	wait.waitUntilElementToBeClickable(driver, button);	
		button.click();
		return new Home_Page(driver);//returns to new page by using new keyword.
	}
	
	@FindBy(linkText ="Dashboard")WebElement dashboard;
	public boolean verifyWhetherDashboardIsDisplayed() { //boolean is the return type, so use boolean instead of void
		return dashboard.isDisplayed();
	}
	
	@FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement text7arts;
	public String verifyWhethertext7artsSuperMarketisDisplayed() {
		return text7arts.getText();
	}

}

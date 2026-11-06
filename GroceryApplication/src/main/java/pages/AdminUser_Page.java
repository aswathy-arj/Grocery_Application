package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Excel_Utilities;
import utilities.Page_Utilities;

public class AdminUser_Page {
	
public WebDriver driver;
Page_Utilities page = new Page_Utilities(); //created object for page utilities to use the methods.
	
	public AdminUser_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(linkText = "New")WebElement newButton;
	public AdminUser_Page clickNew() {
		newButton.click();
		return this;
	}
	
	
	@FindBy(id = "username")WebElement usernameOfNewUser;
	public AdminUser_Page enterUsername(String newuser) {
		usernameOfNewUser.sendKeys(newuser);
		return this;
	}
	
	@FindBy(id = "password")WebElement passwordOfNewUser;
	public AdminUser_Page enterPassword(String newpass) {
		passwordOfNewUser.sendKeys(newpass);
		return this;
	}
	
	@FindBy(id = "user_type")WebElement usertype;
	public AdminUser_Page usertypeDropdown() {
		page.selectDragDropWithValue(usertype, "Admin");//to select dropdown value from page utilities class
		return this;
	//Select dropdown = new Select(usertype);
	//dropdown.selectByValue("admin");
	}
	
	@FindBy(name = "Create")WebElement save;
	public AdminUser_Page clickSaveButton() {
		save.click();
		return this;
	}
	
	@FindBy(xpath ="//h5[text()=' Alert!']")WebElement alertmessage;
	public boolean verifyWhetherAlertMessageIsDisplayed() {//assertion
		return alertmessage.isDisplayed(); // created webelement and perform action to find the element is displayed or not using assertion.
	}
	
	@FindBy(linkText = "Search")WebElement search;
	public AdminUser_Page toClickSearch() {
		search.click();
		return this;
	}
	
	@FindBy(id="un")WebElement searchByUn;
	public AdminUser_Page searchByUsername(String searchuser) {
		searchByUn.sendKeys(searchuser);
		return this;
	}
	
	@FindBy(id="ut")WebElement usertypedropdown;
	public AdminUser_Page usertypeDd() {
		page.selectDragDropWithValue(usertypedropdown, "Admin");
		return this;
		//Select dropdownvalue = new Select(usertypedropdown);
		//dropdownvalue.selectByValue("admin");
	}
	
	@FindBy(xpath="//button[@type='submit' and @name='Search']")WebElement searchButton;
	public AdminUser_Page clickSearchButton() {
		searchButton.click();
		return this;
	}
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody[1]/tr[1]/td[1]")WebElement viewdemoData;
	public String toViewDataInTable() { //assertion
		String data = viewdemoData.getText();
		System.out.println(data);
		return viewdemoData.getText();
	}
}

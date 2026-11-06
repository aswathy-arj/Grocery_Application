package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoy_Page {
	public WebDriver driver;
	
	public ManageDeliveryBoy_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(linkText = "New")WebElement newButton;
	public ManageDeliveryBoy_Page toclickNew() {
		newButton.click();
		return this;
	}
	
	@FindBy(id= "name")WebElement nameOfDeliveryBoy;
	public ManageDeliveryBoy_Page enterName(String name) {
		nameOfDeliveryBoy.sendKeys(name);
		return this;
	}
	
	@FindBy(id = "email")WebElement emailOfDeliveryBoy;
	public ManageDeliveryBoy_Page enterEmail(String email) {
	emailOfDeliveryBoy.sendKeys(email);
	return this;
	}
	
	@FindBy(id = "phone")WebElement phoneNumberOfDeliveryBoy;
	public ManageDeliveryBoy_Page enterPhoneNum(String phone) {
		phoneNumberOfDeliveryBoy.sendKeys(phone);
		return this;
	}
	
	@FindBy(id = "address")WebElement addressOfDeliveryBoy;
	public ManageDeliveryBoy_Page enterAddress(String address) {
		addressOfDeliveryBoy.sendKeys(address);
		return this;

	}
	
	@FindBy(id = "username")WebElement usernameOfDeliveryBoy;
	public ManageDeliveryBoy_Page enterUsername(String userName) {
		usernameOfDeliveryBoy.sendKeys(userName);
		return this;
		
	}
	
	@FindBy(id = "password")WebElement passwordOfDeliveryBoy;
	public ManageDeliveryBoy_Page enterPassword(String passWord) {
		passwordOfDeliveryBoy.sendKeys(passWord);
		return this;
	}
	
	
	
	@FindBy(name = "create")WebElement saveButton;
	public ManageDeliveryBoy_Page clickSaveButton() {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)","");
		
		saveButton.click();
		return this;
	}
	
	@FindBy(xpath ="//h5[text()=' Alert!']")WebElement alertmessage;
	public boolean verifyWhetherAlertMessageIsDisplayed() { // assertion
		return alertmessage.isDisplayed();
	}
	
	@FindBy(linkText = "Search")WebElement searchOption;
	public ManageDeliveryBoy_Page clickSearchButton() {
		searchOption.click();
		return this;
	}
	
	@FindBy(id = "un")WebElement searchByName;
	public ManageDeliveryBoy_Page enterDeliveryBoyName(String n) {
		searchByName.sendKeys(n);
		return this;
	}
	
	@FindBy(id = "ut")WebElement searchByEmail;
	public ManageDeliveryBoy_Page enterDeliveryBoyEmail(String e) {
		searchByEmail.sendKeys(e);
		return this;
	}
	
	@FindBy(id = "ph")WebElement searchByPhone;
	public ManageDeliveryBoy_Page enterDeliveryBoyPhone(String ph) {
		searchByPhone.sendKeys(ph);
		return this;
	}
	
	@FindBy(xpath="//button[@type='submit' and @name='Search']")WebElement searchButton;
	public ManageDeliveryBoy_Page clickSearchButton1() {
		searchButton.click();
		return this;
	}
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody[1]/tr[1]/td[1]")WebElement viewdSearchData;
	public String toViewDataInTable() { // assertion
		String data = viewdSearchData.getText();
		System.out.println(data);
		return viewdSearchData.getText();
	}
}

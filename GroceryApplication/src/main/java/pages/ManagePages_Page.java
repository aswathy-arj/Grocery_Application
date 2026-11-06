package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePages_Page {
	public WebDriver driver;
	
	public ManagePages_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New")WebElement addNewPage;
	public ManagePages_Page clickNewButton() {
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", addNewPage);
		addNewPage.click();
		return this;
	}
	
	@FindBy(id = "title")WebElement titlename;
	public ManagePages_Page enterTitle(String title) {
		titlename.sendKeys(title);
		return this;
	}
	
	@FindBy(xpath = "//div[@class='note-editable card-block']")WebElement descriptionBox;
	public ManagePages_Page enterDescription(String description) {
		descriptionBox.sendKeys(description);
		return this;
	}
		
	@FindBy(id = "page")WebElement pagename;
	public ManagePages_Page enterPage(String page) {
		pagename.sendKeys(page);
		return this;
	}
	
	@FindBy(name = "create")WebElement saveButton;
	public ManagePages_Page clickSaveButton() {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveButton);
		return this;
		//save.click();
	}
	
	@FindBy(xpath = "//h5[text()=' Alert!']")WebElement alertmessage;
	public boolean verifyWhetherAlertMessageIsDisplayed() {
		return alertmessage.isDisplayed();
	}
	
	@FindBy(linkText = "Search")WebElement search;
	public ManagePages_Page toClickSearch() {
		search.click();
		return this;
	}
	
	@FindBy(name = "un")WebElement searchByTitle;
	public ManagePages_Page toEnterTitle(String title) {
		searchByTitle.sendKeys(title);
		return this;
	}
	
	@FindBy(name = "Search")WebElement confirmSearch;
	public ManagePages_Page toClickSearchButton() {
		confirmSearch.click();
		return this;
	}
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody[1]/tr[1]/td[1]")WebElement assertion;
	public String assertTableContent() {
		String data = assertion.getText();
		System.out.println(data);
		return assertion.getText();
	}
	
}

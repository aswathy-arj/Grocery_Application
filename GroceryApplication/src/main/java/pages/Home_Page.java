package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public WebDriver driver;
	public Home_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//div[@class='row']//div[2]/div/a")WebElement moreInfoOfAdminUser;
	public AdminUser_Page clickMoreInfo() {
		moreInfoOfAdminUser.click();
		return new AdminUser_Page(driver);
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")WebElement admin;
	public Home_Page clickAdmin() {
		admin.click();
		return this;
	}
	
	@FindBy(xpath = "//div[@class='row']//div[8]/div/a")WebElement moreInfoOfManageDeliveryBoy;
	public ManageDeliveryBoy_Page clickMoreInfoDeliveryBoy() {
		moreInfoOfManageDeliveryBoy.click();
		return new ManageDeliveryBoy_Page(driver);
	}
	
	@FindBy(linkText = "More info")WebElement moreInfoOfManagePages;
	public ManagePages_Page clickMoreInfoOfManagePages() {
		moreInfoOfManagePages.click();
		return new ManagePages_Page(driver);
	}
	
	@FindBy(linkText = "Logout")WebElement logoutbutton;
	public Login_Page clicklogout() {
		logoutbutton.click();
		return new Login_Page(driver);
	}

}

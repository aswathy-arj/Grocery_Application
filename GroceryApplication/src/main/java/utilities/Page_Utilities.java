package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_Utilities { // page helper class
	
	public void selectDragDropWithValue(WebElement element, String value) {

		Select object=new Select(element);
		object.selectByValue(value);
		}
	
	public void selectDragDropWithIndex(WebElement element, int value) {

		Select object=new Select(element);
		object.selectByIndex(value);
		}
	
	public void selectDragDropWithVisibleText(WebElement element, String value) {

		Select object=new Select(element);
		object.selectByVisibleText(value);
		}
	
	public void javascriptExecutorClick(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		}
	
	public void javascriptExecutorScroll(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)","");
		}
	
	public void mouseActionRightClick(WebDriver driver, WebElement element) {
		
		Actions rightClick = new Actions(driver);
		rightClick.contextClick(element).build().perform();
		}
	
	public void mouseActionMouseHover(WebDriver driver, WebElement element) {
		
		Actions mousehover = new Actions(driver);
		mousehover.moveToElement(element).build().perform();
		}
	
	public void mouseActionDoubleClick(WebDriver driver, WebElement element) {
		
		Actions doubleclick = new Actions(driver);
		doubleclick.doubleClick(element).build().perform();
		}
	
	public void dragDrop(WebDriver driver, WebElement element1, WebElement element2) {
		
		Actions dragdrop = new Actions(driver);
		dragdrop.dragAndDrop(element1, element2).build().perform();
		}
	
	
	
	
	
}

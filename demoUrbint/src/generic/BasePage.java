package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


	public WebDriver driver = null;

	public BasePage(WebDriver driver) {
	this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
	System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	return driver;
	}

	
	/**
	* Method to findElement By locator 
	* @author ariel vc
	*/
	public WebElement findElement(By locator) {

		return driver.findElement(locator);
	}

	/**
	* Method to getText from a webElement
	* @author ariel vc
	*/
	public String getText(WebElement element) {
		return element.getText();
	}

	/**
	* Method to getText from a webElement using the locator to target
	* @author ariel vc
	*/
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	/**
	* Method to type in a input text element
	* @author ariel vc
	*/
	public void type(WebElement element, String inputText) {
		waitUtilElementLoad(element);
		element.sendKeys(inputText);

	}
	
	/**
	* Method to click in a webElement
	* @author ariel vc
	*/
	public void clickElement(WebElement element){
		element.click();
	}
	
	/**
	* Method to click a element using locator 
	* @author ariel vc
	*/
	public void clickElementByLocator(By locator){
		driver.findElement(locator).click();
	}


	/**
	* Method to check if a elememt is present
	* @author ariel vc
	*/
	
	public boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}


	/**
	* Method to check select a option from a dropDown Element 
	* @author ariel vc
	*/
	
	public void selectdropDownValue(WebElement dropdownElement,String optionValue) {
		
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(optionValue);  
	}
	
	
	/**
	* Method to Wait until a element load
	* @author ariel vc
	*/
	public void waitUtilElementLoad(WebElement element) {
		
		WebDriverWait  wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	* Method to check if a especifi element is present
	* @author ariel vc
	*/
	public boolean isAttribtuePresent(WebElement element, String attribute) {
	    Boolean result = false;
	    try {
	        String value = element.getAttribute(attribute);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return result;
	}
	
	/**
	* Method to wait until table result load
	* @author ariel vc
	*/
	public void waitUntilTableLoad( ) {
		try {
			WebElement element = driver.findElement(By.xpath("//div[contains(@class,'MuiCircularProgress-root')]"));
			
			if(element.isDisplayed()) {
			WebDriverWait  wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next Page']")));
			}
		
		}catch(org.openqa.selenium.NoSuchElementException e) {
		
		}
	}
	
	/**
	* Method to check if a specific element is present using the locator to target the element
	* @author ariel vc
	*/
	public boolean isElementPresentXpath(By locator ) {
		try {
			WebElement element = driver.findElement(locator);
			return  element.isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	* Method to open a new url
	* @author ariel vc
	*/
	public void goTo(String url) {
		driver.get(url);
	}
	
	
	
}

	
	
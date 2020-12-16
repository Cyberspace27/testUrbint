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

	public WebElement findElement(By locator) {

	return driver.findElement(locator);
	}

	public String getText(WebElement element) {
	return element.getText();
	}


	public String getText(By locator) {
	return driver.findElement(locator).getText();
	}

	public void type(WebElement element, String inputText) {
	element.sendKeys(inputText);

	}
	public void clickElement(WebElement element){
	element.click();
	}
	public void clickElementByLocator(By locator){
	driver.findElement(locator).click();
	}


	public boolean isElementPresent(WebElement element) {
	try {
	return element.isDisplayed();
	}catch(org.openqa.selenium.NoSuchElementException e) {
	return false;
	}
	}



	public void selectdropDownValue(WebElement dropdownElement,String optionValue) {
	// Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
	Select dropdown = new Select(dropdownElement);
	dropdown.selectByVisibleText(optionValue);  
	}
	
	public void waitUtilElementLoad(WebElement tableElement) {
		
		WebDriverWait  wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(tableElement));
	}
	
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
	
	
	public boolean isElementPresentXpath(By locator ) {
		try {
			WebElement element = driver.findElement(locator);
		return  element.isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
		return false;
		}
		}
	
	public void goTo(String url) {
	driver.get(url);
	}
	
	
	
}

	
	
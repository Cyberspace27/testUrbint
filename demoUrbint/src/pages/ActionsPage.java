package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import generic.BasePage;

public class ActionsPage extends BasePage { 
	
	public ActionsPage(WebDriver driver) {
		super(driver);

	}
	 boolean nextPageExist = false;

public By headerTitle = By.xpath("//h2[@data-testid='default-view-header']");
public WebElement getActionTitle() {
	return driver.findElement(headerTitle);
}

public By btnViewSettings = By.xpath("(//button[@data-testid='urb-btn'])[1]");
public WebElement getViewSettings() {
	return driver.findElement(btnViewSettings);
}




//public By selectTicketType = By.xpath("(//p[@data-testid='filter-selected-summary'])[1]");
//public WebElement getTicketType() {
//	return driver.findElement(selectTicketType);
//}

public By tablePagZise = By.cssSelector(".actions-table > tbody > tr");
public List<WebElement> getTablePagZise() {
	return driver.findElements(tablePagZise);
}

public By btnNextPage = By.xpath("//button[@aria-label='Next Page']");
public WebElement getNextPage(){
	
	return driver.findElement(btnNextPage);
}

public By tableResult = By.cssSelector(".actions-table");
public WebElement getTableResult(){
	
	return driver.findElement(tableResult);
}

public By emptyTable = By.cssSelector(".empty-table");
public WebElement getEmptyTable(){
	
	return driver.findElement(emptyTable);
}



/**
* Method to click on View settings button
*
*
* @author ariel vc
*/
public boolean clickOnViewSettings() {
	boolean elemenFound = false;
	elemenFound = isElementPresent(getViewSettings());
	clickElement(getViewSettings());
	
	return elemenFound;
}

/**
* Method to select any filter under the view settings section
* @param selectFilter :  String variable to enter the filter to search for new results
* @author ariel vc
*/
public void selectFilterName(String selectFilter) {
clickElementByLocator(By.xpath("//div[contains(@class,'MuiAccordionSummary-root') and contains(.,'"+selectFilter+"')]"));

}

/**
* Method to select any filter option under view settings section using the filter name
* @param filterName  :  String variable to enter the filter to search for new results
* @author ariel vc
*/
public void optionFilterByName(String filterName) {
clickElementByLocator(By.xpath("//div[@data-testid='checkbox'  and contains(.,'"+filterName+"')]/label"));

}

/**
* Method to 
* @author ariel vc
*/
public int tablePagSize() {
 int tableCount = 0;
 
 tableCount =	 getTablePagZise().size();
 System.out.println("AAAAAAAAAAA " + tableCount);
	 
 
return tableCount;
}


/**
* Method to go to the next page if the table contains more results 
* @author ariel vc
*/
public int goToNextPage() {
 int tableCount = 0;

 if(nextPageExist) {
 
 waitUntilTableLoad( );
 //isAttribtuePresent(getEmptyTable(), "");
 }
 else if(!isElementPresent( getTableResult()) && !isElementPresentXpath(By.xpath("//div[@class='empty-table']"))  ) {
	 System.out.println("aloharrararararrarar");
	 waitUtilElementLoad(getTableResult());
 }else if(tablePagSize()==1) {
	 waitUntilTableLoad( );
	 
 }
 
 
 if(tablePagSize()==50) {
	 System.out.println("sdsdsdsdsdddddddddd");
	 waitUtilElementLoad(getTableResult());
	 clickElement(getNextPage());	
	 nextPageExist = true;
		 goToNextPage();
	
 }else
	System.out.println("Current Page is the last Page " + tableCount);
return tableCount;
}


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import generic.BasePage;

public class LoginPage extends BasePage {


public By txtUseremail= By.id("email");
public WebElement getUserEmail() {
	return driver.findElement(txtUseremail);
}

public By txtPassword = By.id("password");
public WebElement getPassword() {
	return driver.findElement(txtPassword);
}

public By btnSignIn = By.xpath("//div[@class='MuiGrid-root MuiGrid-item']//button[contains(@class,'MuiButtonBase-root')]");
public WebElement getSignInButton() {
	return driver.findElement(btnSignIn);
}

public By hrfForgotPassword = By.xpath("//p[contains(@class,'MuiTypography-root') and contains(.,'Forgot Password')]");
public WebElement getForgotPassword() {
	return driver.findElement(hrfForgotPassword);
}


public LoginPage(WebDriver driver) {
	super(driver);

}

/**
* Method to types credentials for login
*
* @param user   String variable to enter username
* @param pass   String variable to enter password
*
* @author ariel vc
*/
public void typeUserPassword(String user, String pass) {
	type(getUserEmail(), user);
	type(getPassword(), pass);
}

/**
* Method to performs the login action
*
* @return ActionsPage ;
* @author ariel vc
*/

public ActionsPage login() {
	clickElement(getSignInButton());
	waitUntilTableLoad();
	return new ActionsPage(driver);
}


/**
* Method to check if forgotPassword link is present
*
* @author ariel vc
*/

public boolean forgotPassword() {
	boolean response = false ; 
	response = isElementPresent(getForgotPassword());
	return response;
}

/**
* Method to performs the login action
*
* @return ActionsPage ;
* @author ariel vc
*/

public void clickLoginButton() {
	clickElement(getSignInButton());
}

/**
* Method to performs the login action
*
* @return ActionsPage ;
* @author ariel vc
*/

public void clearLoginElements() {
	
	for (int i = 0 ; i < 25; i++) {
		driver.findElement(By.id("email")).sendKeys(Keys.BACK_SPACE);
	}
	
	for (int i = 0 ; i < 20; i++) {
		driver.findElement(By.id("password")).sendKeys(Keys.BACK_SPACE);
	}
}

}

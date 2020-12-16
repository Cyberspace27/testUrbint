package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.ActionsPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {


	LoginPage loginPage;
	ActionsPage actionsPage;

	@BeforeClass
	public void beforeC() {
	loginPage = new LoginPage(driver);
	}

	@Test(priority=1 ,description = "logIn with invalid data", groups = { "login" })
	public void signInFailed() {
	loginPage.typeUserPassword("admin", "invalid");
	loginPage.login();
	//scrollUp(300);
	//Assert.assertTrue(loginPage.isElementPresent(loginPage.getSingIn()),"The SignIn was not performe as expected");

	}
	
	
	@Test(priority=1 ,description = "logIn with correct data", groups = { "login" })
	public void signInSuccess() {
	
		loginPage.typeUserPassword("qe+candidate@urbint.com", "puy7cind0VOOT_weep");
		waitTime(3000);
		loginPage.login();
		//Assert.assertTrue(loginPage.isElementPresent(loginPage.getLoggedStatus()),"The SignIn was performe as expected");

	}
	
	
}

package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
		actionsPage = new ActionsPage(driver);
	}


	@Test(priority=1 ,description = "logIn with invalid data", groups = { "login" })
	public void signInFailed() {
		loginPage.typeUserPassword("admin", "invalid");
		loginPage.login();
		Assert.assertTrue(loginPage.isElementPresent(loginPage.getUserEmail()),"The SignIn was not performe as expected");
	}
	
	@Test(priority=2 ,description = "logIn with invalid email", groups = { "login" })
	public void invalidEmail() {
		loginPage.clearLoginElements();
		loginPage.typeUserPassword("805409853---&&%%",  "puy7cind0VOOT_weep");
		loginPage.login();
		Assert.assertTrue(loginPage.isElementPresent(loginPage.getUserEmail()),"The SignIn was not performe as expected");
	}
	
	@Test(priority=3 ,description = "logIn with invalid password", groups = { "login" })
	public void invalidUserPassword() {
		loginPage.clearLoginElements();
		loginPage.typeUserPassword("qe+candidate@urbint.com", "$%%805409853---&&%%");
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.isElementPresent(loginPage.getUserEmail()),"The SignIn was not performe as expected");
	}
	
	@Test(priority=4 ,description = "Check forgot password link", groups = { "login" })
	public void checkForgotPasswordLink() {
		Assert.assertTrue(loginPage.forgotPassword(),"Forgot Password is Present");

	}

	@Test(priority=5 ,description = "logIn with correct data", groups = { "login" })
	public void signInSuccess() {
		waitTime(5000);
		loginPage.clearLoginElements();
		waitTime(5000);
		loginPage.typeUserPassword("qe+candidate@urbint.com", "puy7cind0VOOT_weep");
		actionsPage = loginPage.login();
		waitTime(8000);
		Assert.assertTrue(actionsPage.isElementPresent(actionsPage.getActionTitle()),"The SignIn was performe as expected");

	}
	
	
}

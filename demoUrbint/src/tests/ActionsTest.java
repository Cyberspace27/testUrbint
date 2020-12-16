package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.ActionsPage;
import pages.LoginPage;

public class ActionsTest extends BaseTest{
	
	
	LoginPage loginPage;
	ActionsPage actionsPage;
	
	@BeforeClass
	public void beforeC() {
	loginPage = new LoginPage(driver);
	actionsPage = new ActionsPage(driver);
	loginPage.typeUserPassword("qe+candidate@urbint.com", "puy7cind0VOOT_weep");
	waitTime(3000);
	loginPage.login();
	}
	
	@Test(priority=1 ,description = "click on setting view button", groups = { "Actions" })
	
  public void clickOnSettingsOption() {
	  
		waitTime(9000);
		actionsPage.clickOnViewSettings();
		waitTime(8000);
		actionsPage.selectFilterName("Ticket Type");
		waitTime(5000);
		
		actionsPage.optionFilterByName("Standard");
		waitTime(7000);
		actionsPage.goToNextPage();
		System.out.println("RESULTADO");
		
  }
}

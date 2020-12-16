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
	
	@Test(priority=1 ,description = "Validate Action Filter", groups = { "Actions" })
	
  public void clickOnSettingsOption() {
		
		actionsPage.clickOnViewSettings();
		actionsPage.selectFilterName("Ticket Type");
		actionsPage.optionFilterByName("Standard");
		actionsPage.goToNextPage();
		
  }
}

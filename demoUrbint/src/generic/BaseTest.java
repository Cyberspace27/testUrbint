package generic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.LoginPage;

public class BaseTest {
	
	
	public WebDriver driver = null ;
	LoginPage loginPage;
	
	@BeforeClass
	 public void beforeClass() {
	loginPage = new LoginPage(driver);
	driver = loginPage.chromeDriverConnection();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://portal.staging.demo.urbint.com/login");
	//loginPage.goTo("https://waesworks.bitbucket.io");
	 }
	
	
	@AfterClass
	public void afterClass() {
	
	driver.quit();
	}
	
	public void waitTime(int time)  {
	try {
	Thread.sleep(time);
	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	}
	
	public void scrollDown(int pixels) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	// This  will scroll down the page by pixel vertical
	        js.executeScript("window.scrollBy(0,"+pixels+")");
	}
	
	public void scrollUp(int pixels) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,"+(-pixels)+")");
	}

}

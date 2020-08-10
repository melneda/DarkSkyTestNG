package com.qa.darksky.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.darksky.base.BasePage;
import com.qa.darksky.pages.HomePage;
import com.qa.darksky.pages.HomePage2;
import com.qa.darksky.util.ElementUtil;
import com.qa.darksky.util.AppConstants;

public class HomePageTest2 {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage2 homePage2;
	ElementUtil elementutil;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage2 = new HomePage2(driver);
		Thread.sleep(5000);
	}


	@Test(priority = 1)
	public void doclicktoday() {
		homePage2.clicktoday();
	}
	
	@Test(priority=2)
	public void getLowestTempandVerify() {
		homePage2.getLowestTemps();
		
	}
	
	
	@Test(priority=3)
	public void getHighestValueandVerify() {
		homePage2.gethighesttemps();
		
	}

	@AfterTest
	public void quitpage() {
		driver.quit();
	}
}

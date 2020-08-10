package com.qa.darksky.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.darksky.base.BasePage;
import com.qa.darksky.pages.HomePage;
import com.qa.darksky.util.ElementUtil;
import com.qa.darksky.util.AppConstants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	ElementUtil elementutil;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("homepage title is " + title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void doclicktoday() {
		homePage.clicktoday();
	}
	
	@Test(priority=3)
	public void printTempsList() throws InterruptedException {
		homePage. findtemps();
	}
	
	@Test(priority=4)
	public void verifytemps() {
	//	homePage.verify();
	}
	

	@AfterTest
	public void quitpage() {
		driver.quit();
	}
}

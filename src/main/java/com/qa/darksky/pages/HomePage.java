package com.qa.darksky.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.darksky.base.BasePage;
import com.qa.darksky.util.ElementUtil;
public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	int highestTemp=0;
	int lowestTemp=200;

	// locators;

	By today = By.xpath("//span[contains(text(),'Today')]");
	By temps = By.xpath("//div[@id='timeline']//div[@class='temps']//span");
	// By maxTemp= By.xpath("//span[@class='lowTemp swap']");
	 By minTemp=By.xpath("//span[@class='highTemp swip']");

//	By minTemp = By.xpath("//span[@class='temp'][1]");
	By maxTemp = By.xpath("//span[@class='lowTemp swap']//span[1]");	
	
	
	// Constractors
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void clicktoday() {
		elementUtil.doClick(today);

	}

	public String getHomePageTitle() {
		return elementUtil.doGetPageTitle();
	}

	
public void findtemps() {
//	int highestTemp=0;
	//int lowestTemp=200;
     List<WebElement> allTemps = driver.findElements(By.xpath("//div[@id='timeline']//div[@class='temps']//span"));
     for (int i = 0; i < allTemps.size(); i++) {
	   String listTemp = allTemps.get(i).getText();
	   int t= Integer.parseInt(listTemp.substring(0,2));
	   System.out.println( t);
	   if (t > highestTemp){
			 highestTemp  = t;
		    }
		  if (t < lowestTemp ){
			  lowestTemp = t;
		    }}
	System.out.println("Highest Temp:" + Integer.toString(highestTemp));
	System.out.println("Lowest Temp:" + Integer.toString(lowestTemp ));	

	
}		
//	   public void verify() {
//		String maxiTemp = driver.findElement(maxTemp).getText();
//		elementUtil.waitForElementPresent(maxTemp);
//		System.out.println(driver.findElement(maxTemp).getText());
//		elementUtil.waitForElementPresent(minTemp);
//      Assert.assertEquals(driver.findElement(maxTemp).getText(),highestTemp);
//	   Assert.assertEquals(driver.findElement(minTemp).getText(),lowestTemp );
//		
	
	
}

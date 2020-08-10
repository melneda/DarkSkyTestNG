package com.qa.darksky.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.util.ElementUtil;

public class HomePage2 extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	int highestTemp = 0;
	int lowestTemp = 200;

	// locators;

	By today = By.xpath("//span[contains(text(),'Today')]");
	By temps = By.xpath("//div[@id='timeline']//div[@class='temps']//span");
//	 By maxTemp= By.xpath("//span[@class='lowTemp swap']");
	//By minTemp = By.xpath("//span[@class='highTemp swip']");
//	 By minTemp = By.xpath("//span[@class='temp'][1]");
	//By maxTemp = By.xpath("//span[@class='lowTemp swap']//span[1]");
	By minTemp = 	By.className("low-temp-text");					
	//By.xpath("//span[@class='minTemp'][1]");
	By maxTemp= By.className("high-temp-text");
	//By.xpath("//span[@class='maxTemp'][1]");

	// Constractors
	public HomePage2(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void clicktoday() {
		elementUtil.doClick(today);

	}

	public void getLowestTemps() {
		List<WebElement> list = driver.findElements(temps);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			arrayList.add(Integer.parseInt(list.get(i).getText().replaceAll("\\D+", "")));
		}

		Collections.sort(arrayList);
		System.out.println(arrayList);
		System.out.println(arrayList.get(0));

		int expLowestTemp = arrayList.get(0);
		int actualLowestTemp = Integer.parseInt(driver.findElement(minTemp).getText().replaceAll("\\D+", ""));
		Assert.assertEquals(actualLowestTemp, expLowestTemp);
	}

	public void gethighesttemps() {
		
		List<WebElement> list = driver.findElements(temps);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			arrayList.add(Integer.parseInt(list.get(i).getText().replaceAll("\\D+", "")));
		}

		Collections.sort(arrayList);
		System.out.println(arrayList);

		int highindex = arrayList.size()-1;
		System.out.println(highindex);
	int expectedHighestValue=arrayList.get(highindex);
		int actualHighestTemp = Integer.parseInt(driver.findElement(maxTemp).getText().replaceAll("\\D+", ""));
		Assert.assertEquals(actualHighestTemp, expectedHighestValue);
	}
		
}
	
	


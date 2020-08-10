package com.qa.darksky.util;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.darksky.base.BasePage;


public class ElementUtil extends BasePage{
	
	
	
	WebDriver driver;
    WebDriverWait wait;
    Properties prop;
    

	/**
	 * 
	 * @author bobit
	 *
	 */
	    
	    public ElementUtil(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    /**
	     * Get title
	     * @return
	     */
	    public String doGetPageTitle() {
	       
	        try {
	            return driver.getTitle();
	        } catch (Exception e) {
	            System.out.println("some exception got occured while getting the title...");
	        }
	        return null;
	    }
	    
	    /**
	     * This method is used to create the webelement on the basis of by locator
	     * @param locator
	     * @return
	     */
	    public WebElement getElement(By locator) {
	        
	        WebElement element = null;
	        
	        try {
	            element = driver.findElement(locator);
	        } catch (Exception e) {
	            System.out.println("some exception got occured while creating the web element");
	        }
	        return element;
	    }
	    
	    /**
	     * This method is used to click the webelement on the basis of by locator
	     * @param locator
	     */
	    public void doClick(By locator) {
	        
	        try {
	            getElement(locator).click();
	        } catch (Exception e) {
	            System.out.println("some exception got occured while clicking the web element");
	        }
	    }
	    
	    /**
	     * This method is used to send value in a field
	     * @param locator
	     * @param value
	     */
	    public void doSendKeys(By locator, String value) {
	        
	        try {
	            WebElement element = getElement(locator);
	            element.clear();
	            element.sendKeys(value);
	        } catch (Exception e) {
	            System.out.println("some exception got occured while entering values in a field");
	        }
	    }
	    
	    /**
	     * isDisplayed
	     * @param locator
	     * @return
	     */
	    public boolean doIsDisplayed(By locator) {
	        
	        try {
	            return getElement(locator).isDisplayed();
	        } catch (Exception e) {
	            System.out.println("some exception got occured isDisplayed method");
	        }
	        return false;
	    }
	    
	    /**
	     * isEnabled
	     * @param locator
	     * @return
	     */
	    public boolean doIsEnabled(By locator) {
	        
	        try {
	            return getElement(locator).isEnabled();
	        } catch (Exception e) {
	            System.out.println("some exception got occured isEnabled method");
	        }
	        return false;
	    }
	    
	    /**
	     * isSelected
	     * @param locator
	     * @return
	     */
	    public boolean doIsSelected(By locator) {
	        
	        try {
	            return getElement(locator).isSelected();
	        } catch (Exception e) {
	            System.out.println("some exception got occured isSelected method");
	        }
	        return false;
	    }
	    
		  /**
		   * Page title
		   * @param title
		   * @return
		   */
		  public String waitForGetPageTitle(String title){
		      try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.titleContains(title));
			  } catch (Exception e) {
             System.out.println("some exception occurred  while getting title ");			
			}  
          return driver.getTitle();
		  }
	 /**
	  * 
	  * @param driver
	 * @throws InterruptedException 
	  * 
	  *
	  */
		  public void moveToElement(By loc1, By loc2){
			 	WebElement element = driver.findElement(loc1);
				  Actions actions = new Actions(driver);
				  actions.moveToElement(element).build().perform();
				WebElement element2 = driver.findElement(loc2);
				element2.click();
			   
			
			  }
		  
		  
		  /**
		   * 
		   * @param locator
		   */
		  
		  
		  public void waitForElementPresentandclick(By locator){
			  try {
				  WebDriverWait wait = new WebDriverWait(driver, 20);
				    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
				    doClick(locator);
			} catch (Exception e) {
			System.out.println("some exception got occured when wait and click");
			}
			
			  /**
			 * @ param locator
			 */
			    
		  }
		  public void waitForElementPresent(By locator){
			   WebDriverWait wait = new WebDriverWait(driver, 20);
			   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			  }
		  

	/**
	 * 	  
	 * @param locator
	 * waitForElementClicable
	 */
		  
		  
		  
    public void waitForElementClicable(By locator){
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.elementToBeClickable(locator));
	  }

		  
	
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectDropDownByIndex(WebDriver driver, By locator, int index) {
		
		WebElement element = getElement(driver, locator);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectDropdownByVisibleText(WebDriver driver,By locator,String value) {
		
		WebElement element=getElement(driver, locator);
		Select select=new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	
	/**
	 * This method is used to get element
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement getElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		return element;  
		
		
		  
	}  
	
	
	
	
		  
	    /**
	     * GetText()
	     * @param locator
	     * @return
	     */
	    public String doGetText(By locator) {
	        
	        try {
	            return getElement(locator).getText();
	        } catch (Exception e) {
	            System.out.println("some exception got occured while getting text...");
	        }
	        return null;
	        
	   
	        
	    }

	}









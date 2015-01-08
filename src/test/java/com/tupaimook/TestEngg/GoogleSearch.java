/**
 * Class: GoogleSearch
 * Author: Ankan Mookherjee
 * Version: 1.0
 * Date 1/8/2015
 * 
 */

package com.tupaimook.TestEngg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class GoogleSearch {
	
		
	  private WebDriver driver;
	  
	  /**
	   * Sets up class
	   */
	  @BeforeMethod
	  public void setUp() throws Exception {
		  
		  //loading the firefox driver
		  driver = new FirefoxDriver();
		  
		  //set the implicit timeout to find web elements to 15 seconds
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		  //set page load timeout to one minute
		  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		  
		  //maximizing the size of the browser
		  driver.manage().window().maximize();
		  
	  }
	  
	  /**
	   * Tear down class
	   */
	  @AfterMethod
	  public void tearDown() throws Exception {
		  
		  Thread.sleep(10000);
		  //closing the driver
		  driver.quit();
	  }
	  
		public void on_google_search_page(){
		  driver.get("https://www.google.co.uk/");
		}
		
		@When("enter \"([^\"]*)\" into search field")
		public void user_enters_into_field(String text){
			driver.findElement(By.id("gbqfq")).sendKeys(text);
		}
		
		 @And("click on search button")
	      public void user_click_on_search_button() {
	            driver.findElement(By.id("gbqfb")).click();
	      }    
		
		 @Then("verify first link text \"([^\"]*)\"")
	      public void verify_first_link_text(String text)
	     {
	       WebElement message = driver.findElement(By.xpath("//*[@id='rso']/li[1]/div/h3/a"));
	       Assert.assertTrue(message.getText().contains(text));
	      }    

}

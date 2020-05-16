package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.DriverSetup.DriverSetup;
import com.cabBooking.ClickonCab;

public class LogIntoMakemytrip extends DriverSetup{

	
			//Constructor is initialized for the driver 
			public LogIntoMakemytrip(WebDriver driver)
			{
				this.driver=driver;
			} 
			public WebElement mailbox;
			public WebElement mailsubmit;
			public WebElement passbox;
			public WebElement submitbox;
			
			// Function to click on the login button 
			public ClickonCab DoLogin(String username, String password) throws InterruptedException 
			{
				mailbox =driver.findElement(By.id("username"));
				mailbox.sendKeys(username);
				
				mailsubmit= driver.findElement(By.xpath("//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/form/div[2]/button"));
				mailsubmit.click();
				mailsubmit.click();
				passbox =driver.findElement(By.id("password"));
				passbox.sendKeys(password);
				submitbox =driver.findElement(By.cssSelector("button.capText"));
				submitbox.click();
				return PageFactory.initElements(driver, ClickonCab.class);		
			}
			
	
}

package com.cabBooking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.DriverSetup.DriverSetup;

public class ClickonCab extends DriverSetup{

	//Constructor is initialized for the driver 
	public ClickonCab(WebDriver driver)
	{
		this.driver=driver;
	} 
	
	//function to click on cab detail and navigate on search page
	public WebElement cabicon;
	public SearchCabPage CabClick() throws Exception
	{
		Thread.sleep(4000);
		cabicon = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[2]/div[2]/div/div/nav/ul/li[7]"));
		cabicon.click(); 
		return PageFactory.initElements(driver, SearchCabPage.class);
	}
}

package com.cabBooking;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DriverSetup.DriverSetup;

public class SearchCabPage extends DriverSetup{

	//Constructor is initialized for the driver 
	public SearchCabPage(WebDriver driver)
	{
		this.driver=driver;
	} 
	
	// function to search from city cab
	public WebElement tocity;
	public void SearchCabFrom(String fromcity) throws Exception
	{
		
		WebElement city;
		city=driver.findElement(By.xpath("//*[@id=\"fromCity\"]"));
		city.sendKeys(fromcity);	
		Thread.sleep(2000);
        driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		
	}
	//function to search to city cab
	public void SearchCabTo(String tocity) throws InterruptedException
	{
		WebElement city; 
		city=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input"));
		city.sendKeys(tocity);
		Thread.sleep(2000);
        driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		
	
	}
	
	//function for checkin date 
	public void checkInDate(String checkindate)
	{
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]")).click();
		
		List<WebElement> listOfdates=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div//div"));
		
		
		for(WebElement ele:listOfdates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase(checkindate))
			{
				ele.click();
				break;
			}
			
		}
		
		
	}
	
	//function for checkintime
	public void checkInTime(String checkintime) throws Exception
	{
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]"));
			JavascriptExecutor js = (JavascriptExecutor) this.driver;	
		   
		   List<WebElement> listOftime=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/ul//li"));
		   //Thread.sleep(4000);
		   js.executeScript("window.scrollBy(0,100)", "");
		   
		   for(WebElement ele:listOftime)
		{
			
			String time=ele.getText();
			
			if(time.equalsIgnoreCase(checkintime))	
			{
				ele.click();
				break;
			}
			
		}
		
		
	}
	
	// click on search and return on booking page 
	public BookingXuv ClickOnSearch()
	{
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();
		return PageFactory.initElements(driver, BookingXuv.class);
	}
}

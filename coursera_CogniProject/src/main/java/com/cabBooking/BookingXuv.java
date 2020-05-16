package com.cabBooking;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.DriverSetup.DriverSetup;

public class BookingXuv extends DriverSetup{

	//Constructor is initialized for the driver 
	public BookingXuv(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Function to book car as par customer request
	public void xuvBooking(String cartype,String fromcity,String tocity) throws Exception
	{
		int i=3;
		if(cartype.equalsIgnoreCase("sedan"))
		{
			i=1;
		}else if(cartype.equalsIgnoreCase("hatchback"))
		{
			i=2;
		}else if(cartype.equalsIgnoreCase("xuv"))
		{
			i=3;
		}
		else
		{
			Assert.fail("The cartype choosen is invalid ");
		}
		
			
			try {
				List<WebElement> elements=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/ul/li["+i+"]/div[3]//p"));
				WebElement e =elements.get(1);
				String price= e.getText();
				String priceofxuv="";
				priceofxuv = price.replace("₹","Rs");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				System.out.println("The fair from "+fromcity+" to "+tocity+" by "+cartype+" cartype is..... "+priceofxuv);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Assert.fail("The catype is unavailable at this moment on this page  ");
				
			}
		
	}
}

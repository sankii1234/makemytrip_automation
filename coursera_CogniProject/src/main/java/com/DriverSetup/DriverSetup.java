package com.DriverSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Login.*;
import com.Testcases.extentHtmlReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


//The Base class With the reuseable functions
public class DriverSetup {
	
	//Driver and other variables declared globally 
	public static WebDriver driver ;
	public Sheet sheet=null;
	public Workbook wb;
	public ExtentReports report = extentHtmlReport.getReportInstance();
	public ExtentTest logger;
	
	
	//Function to openbrowser
	public void openBrowser(String browser) {

		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				//disable automation info bar
				options.addArguments("disable-infobars");
				 driver = new ChromeDriver(options);
				
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//  Adding waits 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		getPageLoadTimeout();
		// TO maximize the window
		driver.manage().window().maximize();
		
	}
	//Navigating to the url
	public void openWebsite(String url)  
	{
		driver.navigate().to(url);
	}
	// TO set the Pageloadtimeout
	public void getPageLoadTimeout()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	// Function to set an explicit wait
	public void getExplicitWait(String x_path)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x_path)));
	}
	
	//Function to fetch the title
	public String gettitle()
	{
		return driver.getTitle();
	}
	
	// Function to open excel File which return sheet 
	public Sheet fileopen() throws Exception
	{
		File file = new File("/coursera_CogniProject/MMTDetails.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("customervalid");
		return sheet;
	} 
	
	// To get Browser data
	public String getBrowser() throws Exception
	{
		sheet=fileopen();
		String browser = sheet.getRow(0).getCell(1).getStringCellValue();
		return browser;
	}
	// To get Url data 
	public String getUrl() throws Exception
	{
		sheet=fileopen();
		String url = sheet.getRow(1).getCell(1).getStringCellValue();
		return url;
	}
	// To get Username
	public String getUsername() throws Exception
	{
		sheet=fileopen();
		String username = sheet.getRow(2).getCell(1).getStringCellValue();
		return username;
	}
	// To get password from excel
	public String getPassword() throws Exception 
	{
		sheet=fileopen();
		String password = sheet.getRow(3).getCell(1).getStringCellValue();
		return password;
	}
	
	// TO get fromcity data
	public String getFromCity() throws Exception 
	{
		sheet=fileopen();
		String fromcity = sheet.getRow(4).getCell(1).getStringCellValue();
		return fromcity;
	}
	// TO get tocity data
	public String getToCity() throws Exception 
	{
		sheet=fileopen();
		String tocity = sheet.getRow(5).getCell(1).getStringCellValue();
		return tocity;
	}
	// TO get checkindate data
	public String getCheckinDate() throws Exception 
	{
		sheet=fileopen();
		double n=sheet.getRow(6).getCell(1).getNumericCellValue() ;
        String date=Double.toString(n);
        return date;
	}
	// TO get checkintime data
	public String getCheckinTime() throws Exception 
	{
		sheet=fileopen();
		String checkintime = sheet.getRow(7).getCell(1).getStringCellValue();
		return checkintime;
	}
	// TO get cartype data
	public String getCartype() throws Exception 
	{
		sheet=fileopen();
		String cartype = sheet.getRow(8).getCell(1).getStringCellValue();
		return cartype;
	}
	//To close workbook which avoid os clash
	public void closeWorkbook() throws Exception
	{
		sheet=fileopen();
		wb.close();
	}
	
	
	// Function to take screenshot 
	public void takeScreenShoton()
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File destfile = new File("/coursera_CogniProject/"+DateWiseUpdate.getTimeStamp()+".png");
		try {
			FileUtils.copyFile(sourcefile, destfile);
			
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
	
	//closing browser
	public void closeBrowser() {
		driver.close();
		
	}
	
	

	//Quit Browser 
	public void quitBrowser() {
		driver.quit();

	}
	

	public WebElement loginLink;
	
	// The page is navigated to the login page 
	public LogIntoMakemytrip clickLoginLink()
	{
		loginLink = driver.findElement(By.xpath("//*[@id='SW']/div[2]/div[1]/ul/li[6]"));
		loginLink.click();
		return PageFactory.initElements(driver, LogIntoMakemytrip.class);
	}
	
}


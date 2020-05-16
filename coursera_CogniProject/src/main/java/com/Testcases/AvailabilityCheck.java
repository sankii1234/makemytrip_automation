package com.Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.DriverSetup.DriverSetup;
import com.Login.LogIntoMakemytrip;
import com.aventstack.extentreports.Status;
import com.cabBooking.BookingXuv;
import com.cabBooking.ClickonCab;
import com.cabBooking.SearchCabPage;

@Listeners(Transformation.class)
public class AvailabilityCheck extends DriverSetup {

	WebDriver driver;
	DriverSetup ds= new DriverSetup();
	LogIntoMakemytrip login;
	ClickonCab cabclick;
	SearchCabPage searchcab;
	BookingXuv book;
	
	
	

	
	
	/*********************************** Test Cases ****************************/
	//Automated testcases for every action
	@Test (priority=1)
	public void TestCaseOne() throws Exception
	{
		logger = report.createTest("Test One");
		logger.log(Status.INFO, "Fetching Browser Data From Excel");
		getBrowser();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseOne" })
	public void TestCaseTwo() throws Exception
	{
		logger = report.createTest("Test Two");
		String browser = getBrowser();
		logger.log(Status.INFO, "Opening Browser "+browser+" ");
		openBrowser(browser);
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseTwo" })
	public void TestCaseThree() throws Exception
	{
		logger = report.createTest("Test Three");
		logger.log(Status.INFO, "Fetching Url Data From Excel");
		ds.getUrl();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseThree" })
	public void TestCaseFour()	throws Exception
	{
		logger = report.createTest("Test Four");
		logger.log(Status.INFO, "Opening Url In Browser");
		String url = ds.getUrl();
		ds.openWebsite(url);
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseFour" })
	public void TestCaseFive()	throws Exception
	{
		logger = report.createTest("Test Five");
		logger.log(Status.INFO, "Action Performed : clicking on LogIn");
		login = ds.clickLoginLink();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseFive" })
	public void TestCaseSix() throws Exception
	{
		logger = report.createTest("Test Six");
		logger.log(Status.INFO, "Fetching Username Data From Excel");
		getUsername();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseSix" })
	public void TestCaseSeven() throws Exception
	{
		logger = report.createTest("Test Seven");
		logger.log(Status.INFO, "Fetching Password Data From Excel");
		getPassword();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseSeven" })
	public void TestCaseEight() throws Exception
	{
		logger = report.createTest("Test Eight");
		logger.log(Status.INFO, "Action Performed : Sign In With The Details");
		String username = getUsername();
		String password = getPassword();
		cabclick = login.DoLogin(username,password);
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseEight" })
	public void TestCaseNine() throws Exception
	{
		logger = report.createTest("Test Nine");
		logger.log(Status.INFO, "Action Performed : Clicking On Cab Icon");
		searchcab = cabclick.CabClick();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	
	@Test (dependsOnMethods = { "TestCaseNine" })
	public void  TestCaseTen() throws Exception
	{
		logger = report.createTest("Test Ten");
		logger.log(Status.INFO, "Fetching Fromcity Data From Excel");
		getFromCity();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseTen" })	
	public void TestCaseEleven() throws Exception
	{
		logger = report.createTest("Test Eleven");
		logger.log(Status.INFO, "Action Performed : Filling Fromcity");
		String fromcity = getFromCity();
		searchcab.SearchCabFrom(fromcity);
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseEleven" })
	public void TestCaseTweleve() throws Exception
	{
		logger = report.createTest("Test Tweleve");
		logger.log(Status.INFO, "Fetching Tocity Data From Excel");
		getToCity();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseTweleve" })
	public void TestCaseThirteen() throws Exception
	{
		logger = report.createTest("Test Thirteen");
		logger.log(Status.INFO, "Action Performed : Filling Tocity");
		String tocity = getToCity();
		searchcab.SearchCabTo(tocity);
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	
	@Test (dependsOnMethods = { "TestCaseThirteen" })
	public void TestCaseFourteen() throws Exception
	{
		//String checkindate=   sheet.getRow(6).getCell(1).getStringCellValue();
		//String date = getCheckinDate();
		logger = report.createTest("Test Fourteen");
		logger.log(Status.INFO, "Fetching CheckInDate Data ");
		searchcab.checkInDate("23");
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseFourteen" })
	public void TestCaseFifteen() throws Exception
	{
		logger = report.createTest("Test Fifteen");
		logger.log(Status.INFO, "Action Performed : On CheckinBox ");
		getCheckinTime();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseFifteen" })
	public void TestCaseSixteen() throws Exception
	{
		logger = report.createTest("Test Sixteen");
		logger.log(Status.INFO, "Fetching CheckinTime Data From Excel");
		String checkintime =  getCheckinTime();
		searchcab.checkInTime(checkintime);
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseSixteen" })
	public void TestCaseSeventeen()
	{
		logger = report.createTest("Test Seventeen");
		logger.log(Status.INFO, "Action Performed : On CheckinTimeBox");
		book=searchcab.ClickOnSearch();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseSeventeen" })
	public void TestCaseEighteen() throws Exception
	{
		logger = report.createTest("Test Eighteen");
		logger.log(Status.INFO, "Fetching CarType Data From Excel");
		getCartype();
		logger.log(Status.PASS, "Test Execution sucessful");
		
	}
	@Test (dependsOnMethods = { "TestCaseEighteen" })
	public void TestCaseNineteen() throws Exception
	{
		logger = report.createTest("Test Nineteen");
		logger.log(Status.INFO, "Displayed Results On Search And Fetching Car Rates");
		String fromcity=getFromCity();
		String tocity =getToCity();
		String cartype =  getCartype();
		book.xuvBooking(cartype,fromcity,tocity);
		book.takeScreenShoton();
		logger.log(Status.PASS, "Test Execution sucessful");
	}
	@Test (dependsOnMethods = { "TestCaseNineteen" })
	public void TestCaseTwenty() throws Exception
	{
		logger = report.createTest("Test Twenty");
		logger.log(Status.INFO, "Closing browser");
		book.closeBrowser();
		logger.log(Status.PASS, "Test Execution Completed And Browser Closed Sucessfully ");
	}
	@AfterTest
	public void endReport() 
	{
		
		report.flush();
	}
	
}

	 


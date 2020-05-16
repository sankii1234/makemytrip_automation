package com.Testcases;

import com.DriverSetup.DateWiseUpdate;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

//thirdparty extentreport class to create the html report of the testcases
public class extentHtmlReport {
		//public static ExtentHtmlReporter htmlReporter;
		public static 	ExtentReports report;   // this actually creates the report of the test file 
		
		public static ExtentReports getReportInstance()
		{
			if (report ==null)
			{
				String reportname = DateWiseUpdate.getTimeStamp()+".html";
				ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportname);
				report = new ExtentReports();
				report.attachReporter(htmlReporter);
				
				report.setSystemInfo("OS", "WINDOWS 10");
				report.setSystemInfo("Environment", "UAT");
				report.setSystemInfo("Browser","chrome ");
				report.setSystemInfo("Java Version","13.0.2" );
				/* 
				 * build version - 3.141.59
				 * os.arch - amd64
				 * os.version - 10.0
				 * java version -13.0.2
				 * os.name- windows 10
				 * */
				
				htmlReporter.config().setDocumentTitle("Automation Results of MakeMyTrip");
				htmlReporter.config().setReportName("Test Report ");
				htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
				
			}
			return report ;
		}
		
		
}

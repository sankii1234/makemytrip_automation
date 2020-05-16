package com.Testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Failed testcases can be re excuted by testng itself , test-output-testng.failed shows which are the testcases failed . We can re excute 
// only the failed testcases from this xml file 
//Retry class to retry the failed testcases
public class Retry implements IRetryAnalyzer {
	int counter =0 ,retrycount =2;
	
	public boolean retry(ITestResult result) {
		if(counter <retrycount)
		{
			counter++;
			return true;
		}
		return false;
	}

}

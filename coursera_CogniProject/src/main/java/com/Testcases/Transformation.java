package com.Testcases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;


//The transform class is to add the annonation to the testcases where the retry annotation is not added 
public class Transformation implements IAnnotationTransformer {
	
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod )
	{
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		
		if(retry == null)
		{
			annotation.setRetryAnalyzer(Retry.class);
		}
	}
	
}

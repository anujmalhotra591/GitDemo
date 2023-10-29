package com.anuj.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTestNg 
{	
	static ExtentReports extent;
	public static ExtentReports configEX() 
	{
		//String path=System.getProperty(("user.dir")+"\\reports\\index.html");
		String path="C:\\Users\\123\\eclipse-workspace\\AppiumFramework\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Mobile Automation Learning");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Anuj");
		return extent;
	}
}
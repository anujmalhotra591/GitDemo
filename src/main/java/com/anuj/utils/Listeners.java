package com.anuj.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class Listeners implements ITestListener 
{
	AndroidDriver driver;
	AndroidActions actions;
	ExtentTest test;
	ExtentReports extent=ExtentReportsTestNg.configEX();
	@Override
	public void onTestStart(ITestResult result) 
	{
		test=extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS,"Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getThrowable());
		actions= new AndroidActions(driver);
		try 
		{
			driver=(AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(actions.getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
}

package com.anuj.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anuj.pageObjects.android.FormPage;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class EcomTest1 extends BaseConfig
{
	/*@Test(dataProvider="getData")
	public void addToCart(String name, String country) throws MalformedURLException, InterruptedException
	{
		
		fpage.setNameField(name);
		fpage.setspinnerCountry();
		fpage.scrollIntoView(country);
		fpage.setselectCountry();
		fpage.setsubmitPage();
	}*/
	@Test(dataProvider="getData")
	public void addToCart(HashMap<String, String> input) throws MalformedURLException, InterruptedException
	{
		fpage.setNameField(input.get("name"));
		fpage.setspinnerCountry();
		fpage.scrollIntoView(input.get("country"));
		//fpage.setselectCountry();
		fpage.setsubmitPage();
	}
	@BeforeMethod
	public void preSetup() 
	{
		fpage.setActivity();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		//return new Object[][] {{"Anuj","India"},{"Golu","India"}};
		List<HashMap<String, String>> data=fpage.getJsonData("C:\\Users\\123\\eclipse-workspace\\AppiumFramework\\src\\main\\java\\com\\anuj\\testData\\ecom.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
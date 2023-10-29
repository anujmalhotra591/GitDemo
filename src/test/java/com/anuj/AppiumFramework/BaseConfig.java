package com.anuj.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.anuj.pageObjects.android.FormPage;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseConfig 
{
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public FormPage fpage;
	
	@BeforeClass
	public void config() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\123\\eclipse-workspace\\AppiumFramework\\src\\main\\java\\com\\anuj\\dataProperties\\data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		int port=Integer.parseInt(prop.getProperty("port"));
		String deviceName=prop.getProperty("deviceName");
		String appPath=prop.getProperty("appPath");
		String mainJS=prop.getProperty("mainJS");
		
		service= new AppiumServiceBuilder().withAppiumJS(new File(mainJS)).withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		UiAutomator2Options options =new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp(appPath);
		driver=new AndroidDriver(service.getUrl(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		fpage=new FormPage(driver);
	}
	@AfterClass
	public void terminate()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
		service.stop();
	}

}

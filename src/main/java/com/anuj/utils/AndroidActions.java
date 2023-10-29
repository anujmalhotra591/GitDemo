package com.anuj.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions 
{
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{
		this.driver=driver;
	}
	public void scrollIntoView(String country)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"))"));
	}
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException
	{
		//System.getProperty(("Users.dir")+"\\src\\main\\java\\com\\anuj\\testData\\ecom.json"
		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;	
	}
	
	public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile="C:\\Users\\123\\eclipse-workspace\\AppiumFramework\\reports"+testCaseName+".png";
		FileUtils.copyFile(source,new File (destinationFile));
		return destinationFile;
	}
}

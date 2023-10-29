package com.anuj.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.anuj.utils.AndroidActions;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions
{
	AndroidDriver driver;
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anuj");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement spinnerCountry;
	
	//driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
	@AndroidFindBy(xpath="//android.widget.TextView[@text='India']")
	private WebElement selectCountry;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submitPage;
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
	}
	public void setspinnerCountry() {
		spinnerCountry.click();
	}
	
	public void setselectCountry() {
		selectCountry.click();
	}
	public void setsubmitPage() {
		submitPage.click();
	}
	public void setActivity() {
		Activity activity=new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
}

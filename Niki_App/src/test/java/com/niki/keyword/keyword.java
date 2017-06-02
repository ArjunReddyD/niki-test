package com.niki.keyword;

import io.appium.java_client.MobileDriver;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;



import java.io.File;
import java.io.IOException;
import java.text.DateFormat;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





public class keyword {

	public AndroidDriver andriver;
	public static String Stepdescription;
	 
	
	public keyword(AndroidDriver andriver) {
		
		this.andriver=andriver;
		
	}
	
	public boolean isElementPresent(By object) throws InterruptedException 
	{
		
			if(andriver.findElement(object).isDisplayed())
				{
				CaptureScreen(andriver);
					return true;
				}
				else
				{
					return false;
				}
			
		}
	
	public void type(By object, String data) throws Exception 
	{
		try{
			
		
			andriver.findElement(object).sendKeys(data);
			CaptureScreen(andriver);
		}
		catch (Exception e) {
			System.out.println("type failure");
			e.printStackTrace();
			
		
		}
	} 

	
	
	
	public String getText(By object) throws InterruptedException {
		String value = null;
		
				
			andriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			value = andriver.findElement(object).getText();	
			CaptureScreen(andriver);
		
		return value;
	}
	
	
	public void click(By object)
	{
				
			andriver.findElement(object).click();
			CaptureScreen(andriver);
			
		} 
	
	
	
	public WebElement findElement(By object) throws InterruptedException {
		
		
			WebElement element = andriver.findElement(object);	
			getTimeStamp();
			CaptureScreen(andriver);
			return element;
		
	}
	
	public void SwitchToWindow(int index) throws Exception {	
		
		try{
			andriver.switchTo().window(andriver.getWindowHandles().toArray()[index].toString());
			CaptureScreen(andriver);
		} catch(Exception e){
			
		
		}
	}
		
	public void selectBy(By object,String name) throws Exception {
		try{
			Select select = new Select(andriver.findElement(object));
			
			select.selectByVisibleText(name);
			CaptureScreen(andriver);
			Thread.sleep(1000);
			
		}catch(Exception e){
			System.out.println("Exception:");
			e.printStackTrace();
		}
		}

		public static String getTimeStamp(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyyHH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String dateformat = dateFormat.format(cal.getTime());
		System.out.println("inside time stamp method:"+dateFormat.format(cal.getTime()));
		return dateformat;
	}
		
	public void selectvalue(String name) throws Exception
	{
		try
		{
			andriver.findElementByName(name).click();
			CaptureScreen(andriver);
		}
		catch (Exception e)
		{
			
		}
	}
	
	public void scrollClick(String data) {
		andriver.scrollTo(data).click();
		CaptureScreen(andriver);
		
	}
	public static String CaptureScreen(AndroidDriver driver)
	{
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		String ImagesPath = new File("").getAbsolutePath();
		File oDest = new File(ImagesPath+".jpg");
		String timestamp = getTimeStamp();	
		timestamp = timestamp.replace("/", "_");
		timestamp = timestamp.replace(":", "_");
		System.out.println("timestamp:"+timestamp);
		try {
			FileUtils.copyFile(oScnShot, new File(".\\Screenshot\\Screenshot"+timestamp+".png"));
			} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			}
		return ImagesPath+".jpg";
     }
	
	
	public void Datepicker(By object)
	{
		List<WebElement> date = andriver.findElements(object);
	    date.get(0).sendKeys("April");
	    date.get(1).sendKeys("17");
	    date.get(2).sendKeys("1987"); 
	}
	
	
}


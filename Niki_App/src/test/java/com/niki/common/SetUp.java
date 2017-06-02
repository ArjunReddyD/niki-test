package com.niki.common;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SetUp {
	
	static readFromProperties prop = new readFromProperties();
	
	
	public static DesiredCapabilities capSetUP(String grid, String deviceName, String port) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String directory = new File("").getAbsolutePath();
		directory = directory+"\\app_apk";
		
		System.out.println("app apk path:"+directory);
		
		if(grid.equals("No")){
			
			System.out.println("Within no in Setup"+grid);
		 
		
		File app = new File(directory, "app-test-apk.apk");
					
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformName", "Android");   
		capabilities.setCapability("platformVersion", "4.4.4");    
	    capabilities.setCapability("app", app.getAbsolutePath());
	  
	    capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
			}
		
		System.out.println("Before return cap");
	    return capabilities;
	}
	
	
}

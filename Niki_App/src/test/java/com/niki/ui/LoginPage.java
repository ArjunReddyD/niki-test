package com.niki.ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.niki.common.SetUp;
import com.niki.common.readFromProperties;
import com.niki.keyword.keyword;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class LoginPage extends keyword{
	
	readFromProperties prop = new readFromProperties();
	
	public LoginPage(AndroidDriver andriver) {
		
		super(andriver);
	}

	public boolean isPhoneSubmit() throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		Boolean value = false;
		String actualValue = getText(By.id(prop.getAppProperty("niki_signup_yourphone_id")));
		String expectedValue = prop.getAppProperty("niki_signup_yourphone_text");
		
		System.out.println("currentActivity in launch:"+andriver.currentActivity());
		
		if(actualValue.equals(expectedValue)){
			value = true;
		}
		return value;
	}

	public void enterPhoneNumber(String phoneNumber) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("phone number mtd"+phoneNumber);
		type(By.id(prop.getAppProperty("niki_signup_phonenumber_id")),phoneNumber);
	}

	public void clickPhoneSubmit() throws Exception {
		// TODO Auto-generated method stub
		click(By.id(prop.getAppProperty("niki_signup_phonesubmit_id")));
	}

	public String getOtp() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(6000);
		System.out.println("parent driver"+andriver);
		AndroidDriver parentdriver = andriver;
		System.out.println("currentActivity:"+andriver.currentActivity());
		andriver.startActivity("com.android.mms", "com.android.mms.ui.ConversationList");
		String msgTitle = andriver.findElement(By.id("com.android.mms:id/from")).getText();
		System.out.println("message title"+msgTitle);
		System.out.println("child driver:"+andriver);
		String msgOTP = andriver.findElement(By.id("com.android.mms:id/subject")).getText();
		System.out.println("message body:"+msgOTP);
		
		int startIndex = msgOTP.indexOf("OTP");
		System.out.println("start indez:"+startIndex);
		
		int endIndex = msgOTP.indexOf(". D");
		System.out.println("end index"+endIndex);
		startIndex=startIndex+4;
		msgOTP = msgOTP.substring(startIndex, endIndex);
		
		System.out.println("message OTP:"+msgOTP);
		
		//andriver.launchApp();
		Thread.sleep(2000);
		
		//Thread.sleep(5000);
		return msgOTP;
	}

	public void switchToApp() throws InterruptedException {
		// TODO Auto-generated method stub
		andriver.sendKeyEvent(AndroidKeyCode.HOME);
		andriver.sendKeyEvent(0x000000bb);
		
		Thread.sleep(1000);
		andriver.findElement(By.name("Niki")).click();
		Thread.sleep(1000);
		/**
		List<WebElement> elem = andriver.findElements(By.className("android.widget.TextView"));
		for (int i=0;i<elem.size()-1;i++){
			System.out.println("elem.get(i).getAttribute(name) :: " + elem.get(i).getAttribute("text")) ;
			if (elem.get(i).getAttribute("text").equals("Niki")){
				
				andriver.tap(2, elem.get(i), 100);
				//andriver.findElement(By.name("Niki")).click();
				break;
			}

		} */		
		
	}

	public void enterOTP(String otpValue) throws Exception {
		// TODO Auto-generated method stub
		
		
		type(By.id(prop.getAppProperty("niki_login_otp_id")),otpValue);
	}

	public void skipHelpPage() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		click(By.name(prop.getAppProperty("niki_signup_skipbtn_name")));
		
	}

	public void allowLocation() throws Exception {
		// TODO Auto-generated method stub
		click(By.id(prop.getAppProperty("niki_signup_DeviceLocation_Allow_id")));
	}

	
	
}


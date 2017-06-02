package com.niki.test;
import io.appium.java_client.android.AndroidDriver;



import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.niki.common.SetUp;
import com.niki.common.poi_reader;
import com.niki.common.readFromProperties;
import com.niki.ui.DashboardPage;
import com.niki.ui.ReminderPage;
import com.niki.ui.SignupPage;

public class TestSignup{
	
	String directory= new File("").getAbsolutePath();
	
	public  AndroidDriver andriver;
	public  SignupPage signuppage;
	public ReminderPage reminderpage;
	public DashboardPage dashboardpage;
	
	public String device;
	
	readFromProperties prop = new readFromProperties();
	
	/**
	 * 
	 * @param Grid
	 * @param deviceName
	 * @param port
	 * @throws Exception
	 */
	@BeforeClass
	@Parameters({"Grid","deviceName","port"})
	public void setup(String Grid, String deviceName,String port) throws Exception{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities = SetUp.capSetUP(Grid,deviceName,port);
		
		andriver = new AndroidDriver(new URL("http://localhost:"+port+"/wd/hub"), capabilities);	
			    
		andriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);	
		
		signuppage  = new SignupPage(andriver);
		dashboardpage = new DashboardPage(andriver);
		
	}
	
	
	@DataProvider(name = "Signup_Details")
		public Object[][] dataProvider_ClientName_name() {
		Object[][] testData = poi_reader.readExcelData("..//Niki_App//input_data//SignupDetails.xlsx", "signup","Valid_SignupDetails");
		return testData;
	}

	@Test(dataProvider = "Signup_Details")
	public void validSignup(String phoneNumber,String name,String email) throws Exception  {
		
		Assert.assertTrue(signuppage.isPhoneSubmit());
		signuppage.enterPhoneNumber(phoneNumber);
		signuppage.clickPhoneSubmit();
		Thread.sleep(5000);
		String otpValue = signuppage.getOtp();
		System.out.println("otpvalue"+otpValue);
		signuppage.switchToApp();
		signuppage.enterFormDetails(name,email,otpValue);
		signuppage.skipHelpPage();
		signuppage.allowLocation();
		Assert.assertTrue(dashboardpage.isDashboardPage());
	}
	

	@AfterTest
		public void teardown()throws Exception {
		andriver.quit();
	
	}

}

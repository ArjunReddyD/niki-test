package com.niki.test;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidKeyCode;

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
import com.niki.ui.LoginPage;
import com.niki.ui.MenuPage;
import com.niki.ui.ReferPage;
import com.niki.ui.SignupPage;

public class TestReferrelEarn{
	
	String directory= new File("").getAbsolutePath();
	
	public  AndroidDriver andriver;
	
	public  SignupPage signuppage;
	public MenuPage menupage;
	public ReferPage referpage; 
	public DashboardPage dashboardpage; 
	public LoginPage loginpage;
	
	
	
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
		menupage  = new MenuPage(andriver); 
		referpage  = new ReferPage(andriver); 
		dashboardpage = new DashboardPage(andriver);
		loginpage = new LoginPage(andriver);
		

	}

	@DataProvider(name = "Login_Details")
	public Object[][] dataProvider_ClientName_name() {
	Object[][] testData = poi_reader.readExcelData("..//Niki_App//input_data//LoginDetails.xlsx", "login","Valid_loginDetails");
	return testData;
}
	@Test(dataProvider = "Login_Details")
	public void referralEarn(String phoneNumber) throws Exception{
		Assert.assertTrue(loginpage.isPhoneSubmit());
		
		loginpage.enterPhoneNumber(phoneNumber);
		loginpage.clickPhoneSubmit();
		Thread.sleep(5000);
		String otpValue = loginpage.getOtp();
		otpValue = otpValue.trim();
		System.out.println("otpvalue"+otpValue);
		loginpage.switchToApp();
		loginpage.enterOTP(otpValue);
		loginpage.skipHelpPage();
		loginpage.allowLocation();
		Assert.assertTrue(dashboardpage.isDashboardPage());
		menupage.clickHambugerMenu();
		menupage.clickReferMenu();
		Assert.assertTrue(referpage.isreferpage());
		referpage.clickWhtsappIcon();
		referpage.selectContact();
		referpage.clickSend();
		referpage.clickSendMsg();
		referpage.backNav();
	
	}
	

	@AfterTest
		public void teardown()throws Exception {
		andriver.quit();
		andriver.resetApp();
	}

}

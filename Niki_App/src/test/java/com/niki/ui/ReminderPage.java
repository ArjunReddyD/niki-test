package com.niki.ui;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import com.niki.common.readFromProperties;
import com.niki.keyword.keyword;

public class ReminderPage extends keyword {

	readFromProperties prop = new readFromProperties();
	
	public ReminderPage(AndroidDriver andriver) {
		
		super(andriver);
	}
	
	public void hamburgerMenu() throws Exception {
		
		click(By.name(prop.getAppProperty("niki_OpenNavigationDrawer_Name")));
	}
	
	public void createANewReminder() throws Exception{
		
		click(By.name(prop.getAppProperty("niki_OpenNavigationDrawer_ImpMyExperience_Name")));
		
		click(By.name(prop.getAppProperty("niki_ImpMyExperience_CREATEANEWREMINDER_Name")));
		
	}
	
	public void reminderCategory() throws Exception{
		
		click(By.id(prop.getAppProperty("niki_ImpMyExperience_reminderCategorySpinner_Cab_id")));
		
		click(By.name(prop.getAppProperty("niki_ImpMyExperience_Recharge_Name")));
		
	}
	
	public void remindertitle() throws Exception{
		
		andriver.findElement(By.id(prop.getAppProperty("niki_ImpMyExperience_ReminderTitle_id"))).sendKeys("RC");
		
		click(By.name(prop.getAppProperty("niki_ImpMyExperience_Done_Name")));
	}
	
	public void startDate() throws Exception{
		
		click(By.id(prop.getAppProperty("niki_ImpMyExperience_Date_id")));
		
		click(By.name(prop.getAppProperty("niki_ImpMyExperience_10_Name")));
		
		click(By.id(prop.getAppProperty("niki_ImpMyExperience_Date_Ok_id")));
	}

	public void time() throws Exception{
		
		click(By.id(prop.getAppProperty("niki_ImpMyExperience_time_id")));
		
		click(By.id(prop.getAppProperty("niki_ImpMyExperience_time_Ok_id")));
		
	}
	
	public void frequency() throws Exception{
		
		click(By.id(prop.getAppProperty("niki_ImpMyExperience_Frequency_Monthly_id")));
		
		
	}
	
	public void saveANDcontinue() throws Exception{
		
		andriver.findElement(By.id(prop.getAppProperty("niki_ImpMyExperience_SaveAndContinue_id"))).click();
	}
	
	public void backNav(){
		
		andriver.sendKeyEvent(AndroidKeyCode.BACK);
	}
}

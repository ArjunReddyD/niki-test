package com.niki.ui;

import org.openqa.selenium.By;

import com.niki.common.readFromProperties;
import com.niki.keyword.keyword;

import io.appium.java_client.android.AndroidDriver;

public class ImproveMyExperiencePage extends keyword {
	readFromProperties prop = new readFromProperties();
	
	public ImproveMyExperiencePage(AndroidDriver andriver) {
		
		super(andriver);
	}
	
	public void scrollToHome() throws Exception{
		
		// Home ID
		click(By.id(prop.getAppProperty("niki_ImproveMyExperience_Home_id")));
		// Home Name
		click(By.name(prop.getAppProperty("niki_ImproveMyExperience_Home_Name")));
		
	}
	
	public void AddAddress(String HouseNoOrBuilding, String Street, String Landmark) throws Exception {
		
		type(By.id(prop.getAppProperty("niki_ImproveMyExperience_Home_HouseNoOrBuilding_id")), HouseNoOrBuilding);
		
		click(By.name(prop.getAppProperty("niki_ImproveMyExperience_Home_Next_Name")));
		
		type(By.id(prop.getAppProperty("niki_ImproveMyExperience_Home_Street_id")),Street);
		
		click(By.name(prop.getAppProperty("niki_ImproveMyExperience_Home_Next_Name")));
		
		andriver.hideKeyboard();
		
		type(By.id(prop.getAppProperty("niki_ImproveMyExperience_Home_Landmark_id")), Landmark);
		
		click(By.name(prop.getAppProperty("niki_ImproveMyExperience_Home_Name")));
		
		click(By.id(prop.getAppProperty("niki_ImproveMyExperience_Home_Save&Submit_id")));
		
	}
}

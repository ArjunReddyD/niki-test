package com.niki.ui;

import org.openqa.selenium.By;

import com.niki.common.readFromProperties;
import com.niki.keyword.keyword;

import io.appium.java_client.android.AndroidDriver;

public class MenuPage extends keyword{

	readFromProperties prop = new readFromProperties();
	
	public MenuPage(AndroidDriver andriver) {
		// TODO Auto-generated constructor stub
		super(andriver);
	}

	public void clickHambugerMenu() throws Exception {
		// TODO Auto-generated method stub
		click(By.name(prop.getAppProperty("niki_menu_hamburger_name")));
	}

	public void clickReferMenu() throws Exception {
		// TODO Auto-generated method stub
		click(By.name(prop.getAppProperty("niki_menu_refer_name")));
	}

}

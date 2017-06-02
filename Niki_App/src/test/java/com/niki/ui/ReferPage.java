package com.niki.ui;

import org.openqa.selenium.By;

import com.niki.common.readFromProperties;
import com.niki.keyword.keyword;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ReferPage extends keyword{

	readFromProperties prop = new readFromProperties();
	
	public ReferPage(AndroidDriver andriver) {
		// TODO Auto-generated constructor stub
		super(andriver);
	}

	public void clickWhtsappIcon() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		click(By.id(prop.getAppProperty("niki_refer_socialwhtsapp_id")));
	}

	public void selectContact() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		click(By.name(prop.getAppProperty("niki_refer_whtsapp_selectContact_id")));
	}

	public void clickSend() throws Exception {
		// TODO Auto-generated method stub
		click(By.id(prop.getAppProperty("niki_refer_whtsapp_send_id")));
	}

	public void clickSendMsg() throws Exception {
		// TODO Auto-generated method stub
		click(By.id(prop.getAppProperty("niki_refer_whtsapp_send_id")));
	}

	public void backNav() {
		// TODO Auto-generated method stub
		andriver.sendKeyEvent(AndroidKeyCode.BACK);
		andriver.sendKeyEvent(AndroidKeyCode.BACK);
	}

	
	public boolean isreferpage() throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		
		boolean value = isElementPresent(By.id(prop.getAppProperty("niki_refer_socialwhtsapp_id")));
		return value;
	}

}

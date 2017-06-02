package com.niki.ui;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

import com.niki.common.readFromProperties;
import com.niki.keyword.keyword;

public class OffersAndPromocodesPage extends keyword {

readFromProperties prop = new readFromProperties();
	
	public OffersAndPromocodesPage(AndroidDriver andriver) {
		
		super(andriver);
	}
	
	public void offers_promocodeslink() throws Exception{
	
		click(By.name(prop.getAppProperty("niki_OpenNavigationDrawer_offers_promocodeslink_name")));
		
    }
	
	public void viewOffers() throws Exception{
		
		click(By.id(prop.getAppProperty("niki_offers_promocodeslink_ViewOffers_id")));
		
	}
	
	public void OffersPage() throws Exception{
		
		click(By.name(prop.getAppProperty("niki_offers_ViewOffersPage_LaunderyBooking_Name")));
	}
}

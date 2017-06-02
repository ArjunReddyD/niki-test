package com.niki.ui;

import org.openqa.selenium.By;

import com.niki.common.readFromProperties;
import com.niki.keyword.keyword;

import io.appium.java_client.android.AndroidDriver;

public class DashboardPage extends keyword {

	readFromProperties prop = new readFromProperties();
	
	public DashboardPage(AndroidDriver andriver) {
		// TODO Auto-generated constructor stub
		super(andriver);
	}

	public boolean isDashboardPage() throws Exception {
		// TODO Auto-generated method stub
		andriver.scrollTo(prop.getAppProperty("niki_movie_helptext_txt"));
		boolean value = isElementPresent(By.name(prop.getAppProperty("mniki_ovie_helptext_txt")));
		
		return value;
	}

	public void clickMovieTickets() throws Exception {
		// TODO Auto-generated method stub
		click(By.name(prop.getAppProperty("niki_movie_ticketslink_name")));
	}

	public boolean isMovieOptionsDisplayed() throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		boolean value = isElementPresent(By.name(prop.getAppProperty("niki_movie_selectmovie_name")));
		return value;
	}

	public void clickSelectMovie() throws Exception {
		// TODO Auto-generated method stub
		andriver.swipe(710, 790, 213, 790, 5000);
		Thread.sleep(5000);
		click(By.name(prop.getAppProperty("niki_movie_selectmovie_name ")));
	}

	public void clickViewSeatsLink() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		click(By.name(prop.getAppProperty("niki_movie_viewseats_name")));
	}

	public void clickBookMySeat() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		click(By.name(prop.getAppProperty("niki_movie_bookseats_name")));
	}

	public void clickBuyTickets() throws Exception {
		// TODO Auto-generated method stub
		andriver.swipe(370, 1080, 388, 432, 5000);
		andriver.swipe(365, 1070, 370, 390, 5000);
		click(By.id(prop.getAppProperty("niki_movie_buytickets_id")));
		
	}

	public boolean isPayNow() throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		boolean value = isElementPresent(By.name(prop.getAppProperty("niki_movie_paynow_name")));
		return value;
	}

	public void selectTheSeat() throws Exception {
		// TODO Auto-generated method stub
		click(By.name("1"));
		Thread.sleep(1000);
		andriver.scrollToExact("I");
		Thread.sleep(1000);
		click(By.id(prop.getAppProperty("niki_movie_seat_id=")));
		click(By.name(prop.getAppProperty("niki_movie_proceed_name ")));
		Thread.sleep(5000);
		click(By.name(prop.getAppProperty("niki_movie_proceed_name ")));
	}

	public void clickPayNow() throws Exception {
		// TODO Auto-generated method stub
		click(By.name(prop.getAppProperty("niki_movie_paynow_name")));
	}

	public boolean isCheckOutPage() {
		// TODO Auto-generated method stub
		return false;
	}

}

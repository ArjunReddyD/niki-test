package com.niki.common;

import org.testng.annotations.DataProvider;

public class Dataprovider_Repository {
	
	@DataProvider(name = "Signup_Details")
	public Object[][] dataProvider_ClientName_name() {
	Object[][] testData = poi_reader.readExcelData(".//Niki_App//input_data//SignupDetails.xlsx", "signup","Valid_SignupDetails");
	return testData;
}

	
	
}

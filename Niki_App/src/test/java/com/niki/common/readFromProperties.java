package com.niki.common;


import java.io.FileInputStream;
import java.util.Properties;

public class readFromProperties {

	public String getAppProperty(String object) throws Exception{
		FileInputStream fs = new FileInputStream(".//properties//app.properties");		
		Properties or= new Properties();													
		or.load(fs);	
		System.out.println("**************************Properties Read *********************");
		System.out.println(or.getProperty(object));
		return or.getProperty(object);		
	}
	public String getConfigProperty(String object) throws Exception{		
		FileInputStream fs = new FileInputStream(".//properties//config.properties");		
		Properties text= new Properties();													
		text.load(fs);	
		return text.getProperty(object);
	}
	
}

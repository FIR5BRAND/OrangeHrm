package com.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropFile {
	
	public static Properties readProperties(String filename) {
		Properties prop=null;
	
	try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+filename);//read the file
		prop = new Properties();// Initiate Properties
		prop.load(fis); // load properties from file to prop variable
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	return prop;
	}

}

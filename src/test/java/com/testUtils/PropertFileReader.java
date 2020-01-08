package com.testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertFileReader {	
	
	public static String getPropertyValue(String key) throws IOException {		
			File file = new File("C:\\Users\\sonal\\eclipse-workspace\\seleniumSmoketest\\actiTimeTask\\src\\test\\java\\com\\testUtils\\testData.properties");
		
			FileInputStream filestream = new FileInputStream(file);			
			Properties prop = new Properties();		
			prop.load(filestream);		
			String value = prop.getProperty(key);			
			return value;
		}
	
/*public static void main (String [] args) throws IOException {
	
	String str =PropertFileReader.getPropertyValue("server");
	
	System.out.println(str);
*/	
}
	
	


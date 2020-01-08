package com.pageObjects;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.testUtils.CommonUtility;
import com.testUtils.PropertFileReader;

public class LoginPage extends CommonUtility {
	
	WebDriver driver;
	PageFactory page;
	
	@FindBy(xpath="//*[@id='username']")
	public static WebElement userName;
	
	@FindBy(name="pwd") 
	public static WebElement password;
	
	@FindBy(id="loginButton") 
	public static WebElement buttonLogin;
	
	/**
	 *  Getter Methods
	 */
	public void getURL(WebDriver driver) {
		
		String strUrl = null;
		//PropertFileReader reader = new PropertFileReader();
		try {
			strUrl = PropertFileReader.getPropertyValue("server");
			System.out.println("***reading userName value : " + strUrl);
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.get(strUrl);
		
	}
	
	
	public String getUsername()
	{
		String uName = null;
		//PropertFileReader reader = new PropertFileReader();
		try {
			uName = PropertFileReader.getPropertyValue("userName");
			System.out.println("***reading userName value : " + uName);
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uName;		
	}

	public String getPassword() 
	{
		String uName = null;
		//PropertFileReader reader = new PropertFileReader();
		try {
			uName = PropertFileReader.getPropertyValue("password");
			System.out.println("***reading password value...");
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uName;
	}
	
	public String getCustomerName() 
	{
		System.out.println("***reading customerName...");
		
		String custName = null;
		//PropertFileReader reader = new PropertFileReader();
		try {
			custName = PropertFileReader.getPropertyValue("customerName");
			
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custName;
	}
	
	public String getprojectName() 
	{
		System.out.println("***reading projectName...");
		
		String projName = null;
		//PropertFileReader reader = new PropertFileReader();
		try {
			projName = PropertFileReader.getPropertyValue("projectName");
			
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projName;
	}

	/**
	 * Setter Methods
	 */
	
	public void enterUsername() 
	{	
		System.out.println("***Entering Username...");
		String user = getUsername();
		CommonUtility.waitforElement(driver, userName);		
		userName.sendKeys(user);
	}
	
	public void enterPassword() 
	{	
		System.out.println("***Entering password...");
		password.sendKeys(getPassword());		
	}
	
	public void clickLogin()
	{
		System.out.println("***Clicking Login Button...");
		BasePage.clickElement(buttonLogin);		
	}
	
	/*
	 * Verification Methods
	 */	
	
	
	/*
	 * User defined Constructor
	 */
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}

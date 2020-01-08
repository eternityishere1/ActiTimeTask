package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.BasePage;
import com.pageObjects.DashboardPage;
import com.pageObjects.LoginPage;
import com.testUtils.PropertFileReader;

public class ActiTimeLogintest {
	WebDriver driver;
	BasePage basepage;
	LoginPage loginpage;
	DashboardPage homepage;
	
	@BeforeTest
	public void driverinit() throws IOException 
	{		
		basepage = new BasePage();
		driver = basepage.getDriver();
	}
	
	@Test
	public void launchBrowser() throws IOException, InterruptedException
	{
		String url = PropertFileReader.getPropertyValue("server");
		driver.get(url);
		System.out.println("***Navigatig to url"+" "+url+"***");		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='username']")).isDisplayed());
		loginpage = new LoginPage(driver);
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickLogin();
		homepage = new DashboardPage(driver);
		Thread.sleep(3000);
		homepage.clickTask();
		homepage.validateClickTask();
	}	
	
	
	/*
	public void validateActiTimeLogin() throws IOException 
	{		
		//BasePage basepage = new BasePage();
		//loginpage = new LoginPage(driver);		
		//loginpage.launchBrowser();		
		//loginpage.enterUsername();
			
	}*/
	
	
	
	
}

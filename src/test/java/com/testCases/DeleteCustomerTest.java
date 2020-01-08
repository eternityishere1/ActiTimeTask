package com.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.BasePage;
import com.pageObjects.CustomerAndProjectPage;
import com.pageObjects.DashboardPage;
import com.pageObjects.LoginPage;
import com.pageObjects.TaskPage;

public class DeleteCustomerTest {
	
	WebDriver driver;
	BasePage basepage;
	ActiTimeLogintest login;
	CustomerAndProjectPage page;
	DashboardPage homepage;
	TaskPage taskpage;
	
	
	@BeforeTest
	public void driverinit() throws IOException 
	{		
		basepage = new BasePage();
		driver = basepage.getDriver();
	}
	
	@Test
	public void createNewCustomer() throws IOException, InterruptedException 
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.getURL(driver);
		/*		
		login = new ActiTimeLogintest();  //
		login.launchBrowser();*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickLogin();
		//Thread.sleep(1000);
		homepage = new DashboardPage(driver);
		homepage.clickTask();
		Thread.sleep(10000);
//		page = new CustomerAndProjectPage(driver);
//		page.clickAddNewDropdown();
//		page.clickNewCustomer();
//		basepage.waitTime(driver, 05);
//		page.validateCreateCustomerPageDisplayed();
//		page.enterCustomerName();
//		page.enterDescription();
//		page.deSelectImportProjectcheckbox();
//		page.deSelectImportTaskCheckbox();
//		page.clickCreateCustomerButton();
//		taskpage = new TaskPage(driver);
//		taskpage.dragAndClickCustomerSettings(driver);
//		taskpage.clickActionButton(driver);
//		taskpage.clickDeleteButton(driver);
//		//driver.manage().window().maximize();
//		//driver.manage().deleteAllCookies();
//		loginpage.enterUsername();
//		loginpage.enterPassword();
//		loginpage.clickLogin();
	}

	/*
	@AfterTest
	public void tearDown() 
	{		
		driver.quit();
	}*/

}

package com.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.BasePage;
import com.pageObjects.CustomerAndProjectPage;
import com.pageObjects.DashboardPage;
import com.pageObjects.LoginPage;

public class CreateCustomerTest {
	
	WebDriver driver;
	BasePage basepage;
	ActiTimeLogintest login;
	CustomerAndProjectPage page;
	DashboardPage homepage;
	
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
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickLogin();
		Thread.sleep(3000);
		homepage = new DashboardPage(driver);
		homepage.clickTask();
		page = new CustomerAndProjectPage(driver);
		page.clickAddNewDropdown();
		page.clickNewCustomer();
		basepage.waitTime(driver, 05);
		page.validateCreateCustomerPageDisplayed();
		page.enterCustomerName();
		page.enterDescription();
		page.deSelectImportProjectcheckbox();
		page.deSelectImportTaskCheckbox();
		page.clickCreateCustomerButton();
	}

}

package com.pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//a[div[text()='TASKS']]") //
	public static WebElement buttonTask;
	
	
	//#topnav > tbody > tr:nth-child(1) > td:nth-child(3) > a > div.img
	
	// 
	/**
	 * Methods
	 */
	public void clickTask()
	{
		System.out.println("***Clicking TaskButton***");
		//BasePage.clickElement(buttonTask);
		//BasePage.waitforElement(driver, buttonTask);
		buttonTask.click();
		/*//WebElement element = driver.findElement(By.id("gbqfd"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", buttonTask);
		*/
		/*
		Actions action = new Actions(driver);
		action.moveToElement(buttonTask).click().build().perform();   //click(buttonTask).build();
		*/
	}
	
	public void validateClickTask() throws IOException
	{
		String strTitle = driver.getTitle();
		String strActualTitle = BasePage.getPropertyValue("title");
		System.out.println(strActualTitle);
		Assert.assertEquals(strTitle, strActualTitle);
		//Assert.assertEquals(strActualTitle, strTitle);
	}
	
	

	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// //*[@id="taskListBlock"]/div[1]/div[1]/div[2]
	
	

}

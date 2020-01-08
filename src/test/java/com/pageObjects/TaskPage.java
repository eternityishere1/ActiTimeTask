package com.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testUtils.CommonUtility;

public class TaskPage {
	
	WebDriver driver;
	PageFactory page;
	
	@FindBy(css = "#cpTreeBlock > div.customersProjectsPanel > div.customersProjectsTreeContainer > div > div.filteredContainer > div > div.innerContainer > div.itemsContainer > div.node.customerNode.selected > div.editButton.available")
	public static WebElement ButtonCustomerSetting;
	
	@FindBy(xpath="//*[@id='taskListBlock']/div[2]/div[1]/div[4]/div/div")
	public static WebElement buttonAction;
	
	@FindBy(xpath="//*[@id='taskListBlock']/div[2]/div[4]/div/div[3]/div")
	public static WebElement buttonDelete;
	
	public void dragAndClickCustomerSettings(WebDriver driver) 
	{
		System.out.println("***Clicking Customer settings button***");
		BasePage.waitforElement(driver, ButtonCustomerSetting);
		//BasePage.clickElement(ButtonCustomerSetting);
		Actions action = new Actions(driver);
		Action navigateTo = action.click(ButtonCustomerSetting).build();
		navigateTo.perform();
				// moveToElement(ButtonCustomerSetting).click(ButtonCustomerSetting).build().perform();
	}
	
	public void clickActionButton(WebDriver driver)
	{
		System.out.println("***Clicking Action button***");
		Actions action = new Actions(driver);
		CommonUtility.waitforElement(driver, buttonAction);
		action.click().click(buttonAction).build().perform();		
	}
	
	public void clickDeleteButton(WebDriver driver)
	{
		System.out.println("***Clicking Delete button***");
		Actions action = new Actions(driver);
		CommonUtility.waitforElement(driver, buttonDelete);
		action.click().click(buttonDelete).build().perform();
	}
	
	/**
	 * Verification Methods
	 * @throws IOException 
	 */
	public void validateClickTask() throws IOException
	{
		String strTitle = driver.getTitle();
		String strActualTitle = BasePage.getPropertyValue("title");
		System.out.println(strActualTitle);
		Assert.assertEquals(strTitle, strActualTitle);
		//Assert.assertEquals(strActualTitle, strTitle);
	}


	public TaskPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}

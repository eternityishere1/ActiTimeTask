package com.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testUtils.CommonUtility;


public class CustomerAndProjectPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='cpTreeBlock']/div[2]/div[1]/div[2]/div/div[3]")
	public static WebElement dropdownAddNew;
	
	@FindBy(xpath="/html/body/div[14]/div[1]")
	public static WebElement selectNewCustomer;
	
	@FindBy(xpath="//*[@id='customerLightBox_titlePlaceholder']")
	public static WebElement textCreateNewCustomer;
	
	@FindBy(xpath="//*[@id='customerLightBox_nameField']")
	public static WebElement inputboxCustomerName;
	
	@FindBy(xpath="//*[@id='customerLightBox_descriptionField']")
	public static WebElement textboxCustomerDescritpion;
	
	@FindBy(xpath="//*[@id='customerLightBox_importProjectsDescriptions']")
	public static WebElement checkboxImportProject;
	
	@FindBy(xpath="//*[@id='customerLightBox_importTasksDescriptions']")
	public static WebElement checkboxImportTask;
	
	@FindBy(xpath="//*[@id='customerLightBox_commitBtn']")
	public static WebElement buttonCreateCustomer;
	
	/**
	 * User defined Constructor
	 * @param driver
	 */
	
	public CustomerAndProjectPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	
	/**
	 * Setter Methods
	 * @return 
	 */
	
	public void clickAddNewDropdown() {		
		BasePage.clickElement(dropdownAddNew);
	}
	
	public void selectNewCustomer() throws IOException 
	{
		String newCustomer = BasePage.getPropertyValue("NewCustomer");
		CommonUtility.selectElementByVisibleText(driver, newCustomer, selectNewCustomer);
	}
	
	public void clickNewCustomer() 
	{
		BasePage.clickElement(selectNewCustomer);
	}
	
	public void enterCustomerName() throws IOException 
	{		
		String CustomerName = BasePage.getPropertyValue("customerName");
		CommonUtility.sendKeystoElement(driver, CustomerName, inputboxCustomerName);
	}
	
	public void enterDescription() throws IOException 
	{
		String description = BasePage.getPropertyValue("descriptiontext");
		CommonUtility.sendKeystoElement(driver, description, textboxCustomerDescritpion);	
	}
	
	public void deSelectImportProjectcheckbox() 
	{		
		CommonUtility.deselectCheckBox(driver, checkboxImportProject);
	}
	
	public void deSelectImportTaskCheckbox() 
	{
		CommonUtility.deselectCheckBox(driver, checkboxImportTask);
	}
	
	public void clickCreateCustomerButton() 
	{
		BasePage.clickElement(buttonCreateCustomer);
	}
	
	/**
	 * Validation Methods
	 */
	
	public void validateCreateCustomerPageDisplayed() 
	{		
		Assert.assertTrue(textCreateNewCustomer.isDisplayed());		
	}

}


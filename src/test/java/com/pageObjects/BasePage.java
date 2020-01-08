package com.pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.testUtils.CommonUtility;
import com.testUtils.PropertFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage extends CommonUtility {
	
	public static WebDriver driver;
	
	public WebDriver getDriver() throws IOException {
		//reader = new PropertFileReader();
		//WebDriver driver = null;
		String BrwValue = PropertFileReader.getPropertyValue("browser");
		switch(BrwValue) {	
		case "chrome": {	
		WebDriverManager.chromedriver().setup();
		System.out.println("***launching  " + BrwValue + "  browser***");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		break;
		}	
		case ("FireFox"): {	
		driver = new FirefoxDriver();	
		break;
		}	
		case ("IE"): {	
		System.setProperty("webdriver.ie.driver","C://Users//sonal//Desktop//Selenium//IEDriverServer_x64_3.11.0//IEDriverServer.exe");
		driver = new InternetExplorerDriver();		
		break;			
		}
		default:{		
		System.out.println("Invalid browser value");
		}	
		}
		return driver;
	}
	
	public void waitTime(WebDriver driver, long seconds) {		
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);		
	}
	
	public static WebElement getWebelement(WebDriver driver, String locator, String locatorVal) 
	{	
		System.out.println("Finding element with" +locator+ ": " + locatorVal + " ");		
		WebElement ele = null;		
		switch (locator.toLowerCase()) {		
		
		case ("xpath"):{			
			ele = driver.findElement(By.xpath(locatorVal));
			break;			
		}
		
		case ("id"):{			
			ele = driver.findElement(By.id(locatorVal));
			break;			
		}
		
		case ("css"):{			
			ele = driver.findElement(By.cssSelector(locatorVal));
			break;			
		}
		
		case ("classname"):{			
			ele = driver.findElement(By.cssSelector(locatorVal));
			break;			
		}
		case ("linktext"):{		
			ele = driver.findElement(By.linkText(locatorVal));
			break;
		}
		
		}
		return ele;
		
	}
		
	public static void waitforElement(WebDriver driver, WebElement ele) {		
		WebDriverWait wait = new WebDriverWait(driver, 5);		
		wait.until(ExpectedConditions.visibilityOf(ele));		
	}

			
	public static void waitforElementToAppear(WebDriver driver, WebElement ele)
	{		
		WebDriverWait wait = new WebDriverWait(driver,10);			
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void clickElement(WebElement ele) 
	{		
		waitforElementToAppear(driver, ele);
		ele.click();		
	}
	
	
		
}

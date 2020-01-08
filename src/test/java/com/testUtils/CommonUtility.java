package com.testUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtility extends PropertFileReader {

	//private WebDriver driver;

	//static PropertFileReader reader = null;

	public WebDriver driverInit(WebDriver driver) throws IOException {
		//reader = new PropertFileReader();
		//WebDriver driver = null;
		String BrwValue = PropertFileReader.getPropertyValue("browser");
		switch(BrwValue) {	
		case "chrome": {	
		WebDriverManager.chromedriver().setup();
		System.out.println("***launching  " + BrwValue + "  browser***");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		break;
		
		}	
		case ("FireFox"): {
			
		System.setProperty("webdriver.gecko.marionette", "./geckodriver.exe");
		//WebDriverManager.firefoxdriver().setup();
		System.out.println("***launching  " + BrwValue + "  browser***");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		//driver = new WebDriver(capabilities); 
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		break;
		}	
		case ("IE"): {
		System.setProperty("webdriver.ie.driver","C:\\Users\\sonal\\Desktop\\Selenium\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();		
		break;			
		}
		default:{		
		System.out.println("Invalid browser value");
		}	
		}	
		//return driver;
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
		
	public static void waitforElement(WebDriver driver, WebElement ele) 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 5);		
		wait.until(ExpectedConditions.visibilityOf(ele));		
	}
	
	public static void selectElementByVisibleText(WebDriver driver, String strName, WebElement element) 
	{		
		waitforElement(driver,element);
		Select select = new Select(element);
		select.selectByVisibleText(strName);		
	}
	
	public static void sendKeystoElement(WebDriver driver, String strText, WebElement element) 
	{
		waitforElement(driver,element);
		element.sendKeys(strText);
	}
	
	public static void deselectCheckBox(WebDriver driver, WebElement element) 
	{
		waitforElement(driver,element);
		boolean isSelected = element.isSelected();
		
		if(isSelected = true) {			
			element.click();
		} else {		
			System.out.println("Checkbox is not checked");
		}
	}
	
/*
	public DriverUtils() {
		this.driver=driver;
		System.out.println("i m here 3");
	}
	/*
	public static void main(String args[]) {
		
		DriverUtils abc = new DriverUtils();
		
		try {
			abc.driverInit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/	
	
}

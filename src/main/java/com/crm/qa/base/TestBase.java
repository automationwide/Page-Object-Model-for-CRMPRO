package com.crm.qa.base;
/*
 * Author - Jolomi Thompson
 * 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utilities.TestUtility;
import com.crm.qa.utilities.WebEventListener;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	
public TestBase() {
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/Users/jolomi.thompson/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/configuration/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public static void initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/jolomi.thompson/Selenium/workspace/Drivers/chromedriver");
		driver = new ChromeDriver();
	}
	else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "/Users/jolomi.thompson/Selenium/workspace/geckodriver");	
		driver = new FirefoxDriver(); 
	}
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	//driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtility.Page_Load_Timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtility.Implicit_Wait, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
}
}

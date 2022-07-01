package com.qa.Selenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Samarth.Pukale
 *
 */
public class BasePage 

{
	public WebDriver driver;
	public Properties prop;
	/**
	 * This method will initialize the browser on the basis of given browser
	 * @param browser
	 * @return This will return the WebDriver driver
	 */

	public WebDriver init_Browser(String browser)
	{
		System.out.println("Bowser value is : " + browser );
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}

		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		else 
		{
			System.out.println("Please enter the valid browser value :" + browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	/**
	 * This method is use to load and return the properties file and its reference
	 * @return it returns Properties prop reference
	 */

	public Properties init_properties()
	{
		prop = new Properties();
		try 
		{
			FileInputStream fip=new FileInputStream("./src/main/java/com/qa/Selenium/config/Config.properties");
			prop.load(fip);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return prop;
	}
}
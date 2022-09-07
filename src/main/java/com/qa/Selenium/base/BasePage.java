package com.qa.Selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	/**
	 * This method will initialize the browser on the basis of given browser
	 * @param browser
	 * @return This will return the WebDriver driver
	 */

	public WebDriver init_Browser(String browser)
	{
		System.out.println("Bowser value is : " + browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		//	driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			

		}
				
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		//	driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());

		}
		else 
		{
			System.out.println("Please enter the valid browser value :" + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return getDriver();
	}
	/**
	 * This method is use to load and return the properties file and its reference
	 * @return 
	 * @return it returns Properties prop reference
	 */
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}

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
	/**
	 * This Method will capture the screenshot
	 * @return the path of the captured screenshot
	 */
	public String getScreenshot()
	{
		File src=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destpath=new File(path);
		try 
		{
			FileUtils.copyFile(src,destpath);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return path;
	}
}
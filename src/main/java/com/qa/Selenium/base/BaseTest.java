package com.qa.Selenium.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.SeleniumFramework.pages.CalendarProductionPage;
import com.qa.SeleniumFramework.pages.HomePage;
import com.qa.SeleniumFramework.pages.Login;

public class BaseTest 
{
	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public Login loginPage;
	public HomePage homePage;
	public CalendarProductionPage calendarPage;

	@BeforeTest
	public void setUp()
	{
		basepage=new BasePage();
		prop=basepage.init_properties();
		String browser = prop.getProperty("browser");
		driver=basepage.init_Browser(browser);
		loginPage=new Login(driver);
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}

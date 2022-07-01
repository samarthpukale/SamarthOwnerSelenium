package com.qa.SeleniumFramework.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Selenium.base.BaseTest;
import com.qa.Selenium.utils.Constants;


public class HomePageTest extends BaseTest
{
	@BeforeClass
	public void homePageSetup()
	{
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void validateHomePageTitle()
	{
			String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title is :" + title);
		Assert.assertEquals(Constants.HOME_PAGE_TITLE, title);
		
	}
	
	
	@Test(priority=2)
	public void navigateToProductionModule() throws InterruptedException
	{
		homePage.navigateToModulePage(prop.getProperty("modProduction"));
		homePage.navigateToSubModule(prop.getProperty("subModProduction"));
	}


}

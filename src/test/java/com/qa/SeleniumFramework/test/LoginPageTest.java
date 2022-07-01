package com.qa.SeleniumFramework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Selenium.base.BaseTest;
import com.qa.Selenium.utils.Constants;

public class LoginPageTest extends BaseTest
{

	@Test(priority = 1)
	public void verifyLoginPageTitle()
	{
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is : " + title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void loginToSchoolCafe()
	{
		loginPage.doLogin(prop.getProperty("username"),"password");
	}
}

package com.qa.SeleniumFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.qa.Selenium.base.BasePage;
import com.qa.Selenium.utils.Constants;
import com.qa.Selenium.utils.ElementUtil;


public class Login extends BasePage
{
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
/**
 * Login Page Locators
 */
	
	private By emailId = By.id("email");
	private By password = By.id("password");
	private By signINButton = By.id("btnSignIn");
	
	
	/**
	 * Creation of Constructor
	 * @param driver
	 */
	public Login(WebDriver driver)
	{
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
	}

	public String getLoginPageTitle()
	{
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public HomePage doLogin(String un,String pwd)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,250)"," ");
		
		System.out.println("Login with :" + un + " and " + pwd);
		elementUtil.doActionsSendKeys(emailId, un);
		elementUtil.doActionsSendKeys(password, pwd);
		elementUtil.doActionsClick(signINButton);

		try 
		{
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return new HomePage(driver);
	}
	
}

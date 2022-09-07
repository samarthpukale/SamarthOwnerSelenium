package com.qa.SeleniumFramework.pages;

import static org.testng.Assert.expectThrows;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.qa.Selenium.base.BasePage;
import com.qa.Selenium.utils.Constants;
import com.qa.Selenium.utils.ElementUtil;

public class HomePage extends BasePage
{
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header= By.xpath("//div[contains(@class,'MuiToolbar-root')]//*[local-name()='svg' and @id='SchoolCafe_svg__Layer_1']");
	private By accountName=By.xpath("//span[contains(@class,'MuiIconButton-label')]//div");
	private String moduleName="//nav[contains(@class,'jss')]//div[@title='~']";		
	private String submoduleName="//div[contains(@class,'jss')]//div[@id='context-menu']//button[@title='~']";
	
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil=new ElementUtil(this.driver);
		
	}
	/**
	 * This Method will get the Title of the Home Page
	 * @return Will Return Title of the Home Page
	 * @throws InterruptedException 
	 */
	
	

	public String getHomePageTitle()
	{
				
		return elementUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE, 10);
		
	}
	
	public String getAccountName()
	{
		if(elementUtil.getElement(accountName).isDisplayed())
		{
			return elementUtil.getElement(accountName).getText();
		}
		return null;
	}
	/**
	 * This Method will Click on the Provided Module Name from the Main Category
	 * @param module
	 * @throws InterruptedException
	 */
	public void navigateToModulePage(String module) throws InterruptedException
	{
		String modulename = moduleName.replace("~",module);
		By ModuleName = By.xpath(modulename);
		elementUtil.getElement(ModuleName).click();		
		
		
		
		
		
	//	driver.findElement(By.xpath(modulename)).click();		
		
	}
	/**
	 * This Method will click on the Provided Sub Module Name From the Sub Module Category
	 * @param subModule
	 * @throws InterruptedException
	 */
	public CalendarProductionPage navigateToSubModule(String subModule) throws InterruptedException
	{
		String submodulename = submoduleName.replace("~",subModule);
		driver.findElement(By.xpath(submodulename)).click();
		Thread.sleep(5000);
		System.out.println("User Navigated to" + subModule + "Page");
		
		return new CalendarProductionPage(driver);
	}
	
	public void HandleWindows()
	{
		
		
		 
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowid = windows.iterator();
		
		String id = windowid.next();
		driver.switchTo().window(id);
		
	}
	
}


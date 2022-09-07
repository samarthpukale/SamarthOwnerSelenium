package com.qa.SeleniumFramework.pages;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdown 
{

	public static void main(String[] args) throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
	//	driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		driver.manage().window().maximize();
		
//		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(5000);
		WebElement weather = driver.findElement(By.xpath("//div[@title='Sign In']"));
		
		int a=15;
		int b=25;
		 String c = String.valueOf(a);
		 String d = String.valueOf(b);
		 
		String e = c+d;
		System.out.println(c);
		Actions act=new Actions(driver);
		act.moveToElement(weather).contextClick().perform();
		Thread.sleep(2000);
		String tooltiptext = weather.getAttribute("validationMessage");
		System.out.println("Txt is " +tooltiptext);
		String colour = weather.getCssValue("background-color");
		System.out.println("Colut of the background is " +colour);
		
		int val=weather.getLocation().getX();
		int height=weather.getSize().height;
		int width=weather.getSize().width;
		System.out.println("X loacation of element is  " + val);
		System.out.println("height of element is  " + height);
		System.out.println("width of element is  " + width);
		/**
		 * Fluent Wait Declaration
		 */
		Wait<WebDriver> wa=new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		
		
		
	//	SelectMultipleDropdown(driver,"choice 2","choice 3");
	}
		
	/*
	 * public static void SelectMultipleDropdown(WebDriver driver,String ...value) {
	 * // List<WebElement> multiples =
	 * driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
	 * List<WebElement> multiples = driver.findElements(By.xpath(
	 * "(//div[@class='comboTreeDropDownContainer'])[1]//li/span"));
	 * 
	 * for(WebElement values:multiples) { String name=values.getText(); for(String
	 * dnames:value) { if(name.equalsIgnoreCase(dnames)) { values.click(); } } }
	 * 
	 * 
	 * }
	 */

}

package com.qa.SeleniumFramework.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.jsoup.select.Evaluator.IsEmpty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeadLinks
{

	public static void main(String[] args) throws Exception
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.in.amazon.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println();
		
		for(WebElement link:links)
		{
			String linkText = link.getAttribute("href");
			if(linkText==null || linkText.isEmpty())
			{
				System.out.println("Link is empty");
				continue;
			}
			URL url=new URL(linkText);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			if(connection.getResponseCode()>=400)
			{
				System.out.println(linkText + "Link is Broken");
			}
			else {
				System.out.println(linkText + "Link is Not Broken");
			}
			
			
		}
		
		
	}

}

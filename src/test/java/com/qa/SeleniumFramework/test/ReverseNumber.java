package com.qa.SeleniumFramework.test;

public class ReverseNumber
{

	public static void main(String[] args) 
	{

		String s="Samarth Jeevan Pukale";
		
		String newString = s.replaceAll("[^a-zA-Z]","");
		System.out.println(newString);
	}

}

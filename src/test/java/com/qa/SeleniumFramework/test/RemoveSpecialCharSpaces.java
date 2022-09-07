package com.qa.SeleniumFramework.test;

public class RemoveSpecialCharSpaces 
{

	public static void main(String[] args) 
	{
String s= "My  hfjahf  hlakjhkla   hiklajhflk ";

String newString = s.replaceAll("\\s","");
System.out.println(newString);
		
		
	}

}

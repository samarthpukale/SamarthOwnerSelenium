package com.qa.SeleniumFramework.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OccuranceOfWordInString 
{

	public static void main(String[] args)
	{

			
		String s="My name Is Samarth and My Surname Is Samarth";
		String s2="My";
		int count=0;
		
		String[] s1=s.split(" ");
		
		for(int i=0;i<s1.length;i++)
		{
			if(s2.equals(s1[i]))
			{
				count++;
			}
		}
		System.out.println("My is Repeating " + count );
		
	}

}

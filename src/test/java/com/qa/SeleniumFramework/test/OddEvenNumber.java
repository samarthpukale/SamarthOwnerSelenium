package com.qa.SeleniumFramework.test;

public class OddEvenNumber 
{

	public static void main(String[] args) 
	{

		int num=45127565;
		int evencount=0;
		int oddcount=0;
		
		while(num>0)
		{
			int val = num%10;
			if(val%2==0)
			{
				evencount++;
			}
			else
			{
				oddcount++;
			}
			num=num/10;
		}
		System.out.println("Even numbers in the number are " +evencount);
		System.out.println("Even numbers in the number are " +oddcount);
		
		
		
	}

}

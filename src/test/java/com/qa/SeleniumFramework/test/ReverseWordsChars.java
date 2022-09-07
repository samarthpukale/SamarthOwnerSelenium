package com.qa.SeleniumFramework.test;

public class ReverseWordsChars 
{

	public static void main(String[] args) 
	{

		String s="My name is Samarth";
		String[] words=s.split(" ");
	    String reverseWords=" ";
	    
	    for(String w:words)
	    {
	    	String reversechars= " ";
	    	for(int i=w.length()-1;i>=0;i--)
	    	{
	    		reversechars=reversechars+w.charAt(i);
	    		
	    	}
	    	reverseWords=reverseWords+reversechars;
	    	
	    }
	    System.out.println("Reverse Words in a string are " + reverseWords);
		
		
		
	}

}

/* Write a program to find the occurrences of a particular input substring in an input string. */

import java.util.Scanner;

class Pr10
{
	public static void main(String[] args)
	{
		int count=0, i=0;	
		Scanner stdIn= new Scanner(System.in);
		System.out.println("Please enter a string:");
		String str= stdIn.nextLine();
	 	System.out.println("Please enter the substring:");
		String sub= stdIn.nextLine();
		for(i=0; i<=str.length()-sub.length(); i++)
		{
			if(sub.equalsIgnoreCase(str.substring(i, i+sub.length())))
			{
				count++;
				System.out.println("Case:" + i);
				i=i+sub.length()-1;
			}

		}
		
		System.out.println("No. of occurences of the substring are: " + count);
	}





}
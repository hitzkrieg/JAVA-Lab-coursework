import java.util.Scanner;

class Pr3
{
	public static void main(String args[])
	{
		int i=0,j=0, vowels=0, spaces=0, spchar=0, flag=0;
		Scanner StdIn = new Scanner(System.in);
		String sorted=""; StringBuilder input1; char a;int count=0;
		System.out.println("Please enter a line to analyse no. of duplicate characters:");
		String input= StdIn.nextLine();
		System.out.println("You entered: "+ input);
		input1.append(input);
		while(input1.toString().equals("")!=false)
		{
			a=input1.charAt(0);
			flag=0;
			for(j=0; j<input1.length(); j++)
			{
				if(input1.charAt(j).compareToIgnoreCase(a) <0)
				{a= input1.charAt(j);flag=j;}


			}
			sorted = sorted + a;
			input1.deleteCharAt(flag);
			
			 
		}
		for(i=0; i<input1.length()-1; i++)
		{
			if(sorted.charAt(i)==sorted.charAt(i+1))
			{
				count++;
				while(sorted.charAt(i)==sorted.charAt(i+1))
				i++;
			}
		}
		System.out.println("The number of duplicate characters are: "+ count);
	}


}
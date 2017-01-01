import java.util.Scanner;

/* Write a program in java to check whether a number is an Armstrong
number or not. */

class Pr5
{
	public static void main(String args[])
	{
		Scanner StdIn= new Scanner(System.in);
		int n, n1, test=0, i;
		System.out.println("Please enter a number to check if it is an Armstrong number:");
		n= StdIn.nextInt();
		n1=n;
		while(n1!=0)
		{
			test = test+ (int)Math.pow(n1%10,3);
			n1= n1/10;			

		}
		if(n==test)
		System.out.println("The entered number is an Armstrong number!");
		else
		System.out.println("The entered number is not an Armstrong number!");
	}	
}
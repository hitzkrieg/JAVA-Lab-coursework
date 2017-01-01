/* Write a recursive program in java to find the Fibonacci series till a given
input number*/

import java.util.Scanner;

class Pr9
{
	public static int fib( int n, int n1, int n2)
	{
		
		if(n2>n)
		return(n1);

		else 
		{
		System.out.print(n1 + " ");
		n2= n2+n1;
		n1= n2-n1;
		return(fib(n, n1, n2));
		}  	
		
	} 


	public static void main(String[] args)	
	{	
		Scanner stdIn = new Scanner(System.in);
		int fibo;

		
		System.out.println("Enter the value of n:");
		int n= 	stdIn.nextInt();
		System.out.println("The series till " + n + ": ");
		fibo= fib(n, 0,1);
	}
	
}
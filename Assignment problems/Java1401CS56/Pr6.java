import java.util.Scanner;

/*Write a program in java to check whether a number is perfect number or
not.(ex: 6 is a perfect number as the factors of 6 are 1,2,3 whose
summation adds to the number 6.)*/

class Pr6
{
	public static void main(String[] args)
	{
		Scanner stdIn= new Scanner(System.in);
		System.out.println("Please enter a number to check if it is a perfect number:");
		int n= stdIn.nextInt();	
		int i=0; int n1=0;

		for(i=1; i<=n/2;i++)
		{
			if(n%i==0)
			n1= n1+ i;
			
		}	
		if(n==n1)
		System.out.println("The entered number is a perfect number.");
		else 
		System.out.println("The entered number is not a perfect number.");

	}
}
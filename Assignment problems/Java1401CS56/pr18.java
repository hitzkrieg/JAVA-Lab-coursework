import java.util.Scanner;

class Pr18
{
	public static void main(String[] args)
	{
		int n, even=0, odd=0, temp=0;
		Scanner stdIn= new Scanner(System.in);
		System.out.println("Please enter a number to find the sum of its even and odd digits");
		n= stdIn.nextInt();
		while (n!=0)
		{
			temp= n%10;
			n=n/10;
			if (temp%2==0)
			even= even + temp;
			else odd = odd + temp;
		}
		System.out.println("The sum of the even digits is:" + even);
		System.out.println("The sum of the odd digits is:" + odd);
 
	}
}
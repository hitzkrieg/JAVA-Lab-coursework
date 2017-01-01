import java.util.Scanner;

class Pr4
{
	public static void main( String[] args)
		{
		Scanner StdIn = new Scanner(System.in);
		int n=0, i=0, j=0;
		System.out.println("Please enter the number of integers:");
		n= StdIn.nextInt();
		int[] a= new int[n];
		System.out.println("Please enter the " + n + " number of integers:");	
		
		for(i=0; i<n; i++)
		{
		a[i]= StdIn.nextInt();
		}

		/*Sorting starts here */

		for(i=0; i<n; i++)
		{
			for(j=i+1; j<n; j++)
			{
			if(a[i]> a[j])
				{
				a[i]= a[i]+ a[j];
				a[j]= a[i] - a[j];
				a[i]= a[i]- a[j];
				}
			}
		
		}
		
		System.out.println("The numbers in sorted order are:");
		for(i=0; i<n; i++)
			{
			System.out.print(a[i] + " ");
			}
		}
}
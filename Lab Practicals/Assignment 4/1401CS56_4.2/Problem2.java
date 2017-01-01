import java.util.Scanner;
import java.util.Random;

class Problem2
{
	static int a[];
	static  int n;
	static int x;
	/*static{
		Scanner stdIn= new Scanner(System.in);
		System.out.println("Please enter the number of marbles:");
		n= stdIn.nextInt();
	}*/


	static int weight(int low, int high)
	{
		int i=0, sum=0;
		for(i=low; i<=high; i++)
		{
			sum+= a[i];
		}
		return(sum);
	}

	static void search(int low, int high)
	{
		
		int mid=(int)( (low+high)/2.0);
		if(low==high)
		{
			System.out.println("Odd number found at position" + high);

		}
		else
		{
			if(weight(mid, high)== (x* (high+1-mid)))
				search(low,mid);
			else 
				search(mid, high);
		}
		
	}

	static void initialize()
	{
		int x1=0, x2=0, n1;int i=0;
		
		x1= (int)(5*Math.random());
		do
		{
			x2= (int)(5*Math.random());
		}while(x2==x1);
		
		n1= (int)(n*Math.random());
		for(i=0; i<n; i++)
		{
			a[i]=x1;
		}
		a[n1]=x2;
		x=x2;
		System.out.print("x1= "+ x1 + " x2= "+ x2 + "n1= " + n1);
		System.out.println("The generated array is the following:");
		for(i=0; i<n; i++)
		{
			System.out.print( a[i] + " ");
		}

		


	}

	public static void main(String[] args)
	{
		
		
		Scanner stdIn= new Scanner(System.in);
		System.out.println("Please enter the number of marbles:");
		n= stdIn.nextInt();
		a= new int[n];
		System.out.println("\n Initializing: \n");
		initialize();
		
		search(0,n-1);
		
		






	}
	

s}
import java.util.Scanner;

class Pr19
{
	public static void main(String[] args)
	{	
		int i=1, j=1,n1=1, n=0, flag=0;
		Scanner stdIn= new Scanner(System.in);
		System.out.println("Enter the limit of the Floyd's triangle:");
		n=stdIn.nextInt();
		while(flag==0)
		{	if((n1+ i) <= n)
			{
				for(j=1; j<=i; j++)
				{
					System.out.print(n1 + " ");
					n1++;
				}
				System.out.print("\n");
				i++;
			}
			if((n1+ i) >= n)
			flag=1;
		}			



	}

}
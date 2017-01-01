import java.util.Scanner;

class Pr15
{


	public static void main(String[] args)
	{
	Scanner stdIn= new Scanner(System.in);
	System.out.println("Please enter a number to reverse it:");
	int n1 = stdIn.nextInt();
	int n2=0;
	while(n1!=0)
	{
		n2= n2*10 + n1%10;
		n1=n1/10;
	}

	System.out.println("The reversed number is :" + n2);
	
			
	}


}
import java.util.Scanner;

class Pr14
{

public static int fact( int a)
{
	if(a==1)
	return(a);
	else 
	return(a* fact(a-1));
}



	public static void main(String[] args)
	{
	Scanner stdIn= new Scanner(System.in);
	int n1,n2,temp;int sum=0;
	System.out.println("Please enter a number to find if it is strong");
	n1= stdIn.nextInt();
	n2=n1;
	while(n2!=0)
	{
		temp=n2%10;
		sum= sum+ fact(temp);
		n2= n2/10;
	}

	
	if(sum==n1)	
	System.out.println("The number is a strong number");
	else
	System.out.println("The number is not a strong number");
	
	}




} 
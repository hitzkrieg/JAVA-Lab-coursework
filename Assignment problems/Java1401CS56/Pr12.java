import java.util.Scanner;

class Pr12
{

public static int gcd( int a, int b)
{
	if(b == 0)
	{ 
		return a; 
	} 
	else 
	return gcd(b, a%b);
}



	public static void main(String[] args)
	{
	Scanner stdIn= new Scanner(System.in);
	int n1, n2, n3, d1, d2, d3;
	System.out.println("Please enter three nos to find the gcd");
	n1= stdIn.nextInt();
	n2= stdIn.nextInt();
	n3= stdIn.nextInt();
	d1= gcd(n1, n2);
	d2= gcd(n2, n3);
	d3= gcd(d1,d2);
	System.out.println("The gcd of the three numbers is: "+ d3);
	
	}




} 
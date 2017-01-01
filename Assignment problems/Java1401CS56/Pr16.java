import java.util.Scanner;

class Pr16
{


	public static void main(String[] args)
	{
	Scanner stdIn= new Scanner(System.in);
	int n1 = 0; int n2=0; char a; int n=0, temp=0;
	System.out.println("Enter a 4 digit integer:");
	n1= stdIn.nextInt();
	while (!((n1>=1000)&&(n1<=9999)))
	{
		
		System.out.println("Try again. Wrong input.Enter a 4 digit integer:");
		n1= stdIn.nextInt();
		
	}
	System.out.println("Enter an integer between 0 and 9:");
	
	do
	{
		n2= stdIn.nextInt();
		if(!((n2>=0)&&(n2<=9)))
		{System.out.println("Try again. Wrong input.Enter an integer between 0 and 9:");}
	
	}while (!(n2>=0)&&(n2<=9));
	
	System.out.println("Enter a character: ");
	a= stdIn.next().charAt(0);
	System.out.print((char)(a-1));
	
		
	temp= n1 - (((n1%1000)/100)*100) - n1%10 + n2+ n2*100;

	System.out.print(temp); 
	System.out.print((char)(a+1));


	}	
	
}
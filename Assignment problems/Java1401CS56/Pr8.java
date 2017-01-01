import java.util.Scanner;

class Pr8
{
	public static void main(String[] args)
	{
	int i,num=0, temp=1;
	Scanner StdIn = new Scanner(System.in);
	StdIn.nextInt(num);
	
	while(temp<=num)
	{temp= temp*2;}
	if(temp==num) System.out.println("the number is power of two.");
	else System.out.println("the number is not a power of two.");
	
	}
}
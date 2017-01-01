import java.util.Scanner;

class ArrayImplementation
{

	public static void main(String[] args)
	{
		Scanner stdIn= new Scanner(System.in);
		int temp=0, i=0;
		Queue q= new Queue();
		System.out.println("How many elements do you want to enqueue initially(<100)?");
		temp= stdIn.nextInt();
		System.out.println("Enter the "+ temp+ "elements:");
		for(i=0; i<temp;i++)
		{
			q.enqueue(stdIn.nextInt());	
		}
		System.out.println("How many elements do you want to dequeue?");
		do
		{
			temp= stdIn.nextInt();
			if(temp>q.n)
			System.out.println("Cannot dequeue more than "+ q.n + "elements. Enter again:");
		}
		 while(temp>q.n);
		
		System.out.println("Dequeuing!");
		for(i=0; i<temp; i++)
		{
			System.out.println(q.dequeue() + " ");
		}
		
	}




}

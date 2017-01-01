import java.util.Scanner;
import java.util.ArrayList;



class Hanoi
{
	
	
	public static void move(Stack a1, Stack a2)
	{
		if((a1.size!=0)||(a2.size!=0))
		{
			if(a1.stack.get(a1.size)> a2.stack.get(a2.size))
			a1.push(a2.pop());

			else if(a2.stack.get(a2.size)> a1.stack.get(a1.size))
			a2.push(a1.pop());
		}

		else if(a1.size==0)
		{
			a1.push(a2.pop());
		}
		else if(a2.size==0)
		{
			a2.push(a1.pop());
		}

	}
	public static void printing(Stack a1, Stack b1, Stack c1, int steps)
		{
			System.out.println("**********************************");
			System.out.println("Step number:" + steps);
			System.out.println("\n A:" + a1.stack + "\n B: "+ b1.stack + "\n C: "+ c1.stack);
		}

	public static void main(String[] args)
	{
		Scanner StdIn= new Scanner(System.in);
		int i, n, step=0;
		System.out.println("Please enter the number of Disks:"); 
		n=StdIn.nextInt();
		Stack a = new Stack();
                Stack b = new Stack();
                Stack c = new Stack();

		

		for(i=n; i<=1; i++)
		{
			a.push(i);	
		}
		System.out.println(a.stack);
		
		*/
		if(n%2==0)
		{
			while(c.size!= n)
			{
				if(c.size!= n) {move(a,b); step++; printing(a,b,c,step); }
				if(c.size!= n) {move(b,c); step++; printing(a,b,c,step); }
				if(c.size!= n) {move(a,c); step++; printing(a,b,c,step); }

			}
		}
		
		else 
		{
			while(c.size!= n)
			{
				if(c.size!= n) {move(a,c); step++; printing(a,b,c,step); }
				if(c.size!= n) {move(a,b); step++; printing(a,b,c,step); }
				if(c.size!= n) {move(c,b); step++; printing(a,b,c,step); }

			}
		}
		*/


	}
	

}
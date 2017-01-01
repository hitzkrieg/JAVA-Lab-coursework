import java.util.Scanner;
	
	

class Calculator
{
public static void operate(int n1, int n2, char ch)
	{
		if(ch == '+')
		System.out.println(n1+n2);
		if(ch=='-')
		System.out.println(n1-n2);
		if(ch=='*')
		System.out.println(n1*n2);
		if(ch=='/')
		System.out.println(n1/n2);
		if(ch=='^')
		System.out.println(Math.pow(n1,n2));

	}
	public static void operate(double n1, int n2, char ch)
	{
		if(ch == '+')
		System.out.println(n1+n2);
		if(ch=='-')
		System.out.println(n1-n2);
		if(ch=='*')
		System.out.println(n1*n2);
		if(ch=='/')
		System.out.println(n1/n2);
		if(ch=='^')
		System.out.println(Math.pow(n1,n2));

	}

	public static void operate(int n1, double n2, char ch)
	{
		if(ch == '+')
		System.out.println(n1+n2);
		if(ch=='-')
		System.out.println(n1-n2);
		if(ch=='*')
		System.out.println(n1*n2);
		if(ch=='/')
		System.out.println(n1/n2);
		if(ch=='^')
		System.out.println(Math.pow(n1,n2));

	}
	public static void operate(double n1, double n2, char ch)
	{
		if(ch == '+')
		System.out.println(n1+n2);
		if(ch=='-')
		System.out.println(n1-n2);
		if(ch=='*')
		System.out.println(n1*n2);
		if(ch=='/')
		System.out.println(n1/n2);
		if(ch=='^')
		System.out.println(Math.pow(n1,n2));

	}

		public static void main(String[] args)
	{
		Scanner stdIn= new Scanner(System.in);
		
		int i=0; Double n1=new Double(0);Double n2= new Double(0); String a1="", a2=""; 
		char ch;
		int flag1=0, flag2=0; Integer a=new Integer(0); Integer b=new Integer(0);
		System.out.println("Enter expression (for eg 9+11 and enter; without spaces):");
		String cmd = stdIn.nextLine();
		i=0;
		{
			while(((cmd.charAt(i)>='0')&&(cmd.charAt(i)<='9'))||(cmd.charAt(i)== '.'))
			{
				a1= a1 + cmd.charAt(i);
				if(cmd.charAt(i)=='.')flag1=1;
				i++;
			}
			
			ch= cmd.charAt(i);i++;
			
			while(i<cmd.length())
			{
				a2 = a2+ cmd.charAt(i);
				if(cmd.charAt(i)=='.')flag2=1;
				i++;
			}
		}
		
		if(flag1==1 && flag2==1)
		{n1= n1.parseDouble(a1);
		n2= n2.parseDouble(a2);
		operate(n1, n2, ch);
		}

		if(flag1==1 && flag2==0)
		{n1= n1.parseDouble(a1);
		b= b.parseInt(a2);
		operate(n1, b, ch);
		}
		
		if(flag1==0 && flag2==1)
		{a= a.parseInt(a1);
		n2= n2.parseDouble(a2);
		operate(a, n2, ch);
		}
		
		if(flag1==0 && flag2==0)
		{a= a.parseInt(a1);
		b= b.parseInt(a2);
		operate(a, b, ch);
		}

		
		




	}


}
import java.util.Scanner;

class Pr20
{
	public static void main(String[] args)
	{
		double x1, y1, x2, y2, x3, y3, i=0;
		Double c1, c2, d1, d2, d3, d;
		
		Scanner stdIn= new Scanner(System.in);
		do
		{
		System.out.println("Enter x1: ");
		x1= stdIn.nextDouble();
		System.out.println("Enter y1: ");
		y1= stdIn.nextDouble();
		System.out.println("Enter x2: ");
		x2= stdIn.nextDouble();
		System.out.println("Enter y2: ");
		y2= stdIn.nextDouble();
		System.out.println("Enter x3: ");
		x3= stdIn.nextDouble();
		System.out.println("Enter y3: ");
		y3= stdIn.nextDouble();
		if(((y2-y1)/(x2-x1))== ((y3-y2)/(x3-x2)))
		System.out.println("Entered points cannot form a triangle, try again.");
		}	
		while(((y2-y1)/(x2-x1))== ((y3-y2)/(x3-x2)));

		c1= (x1+x2+x3)/3;
		c2= (y1+y2+y3)/3;
		System.out.println("The centroid of the triangle is: ("+c1 + "," + c2 + ")");
		d1= Math.pow(x1-c1,2)+ Math.pow(y1-c2,2);
		d2= Math.pow(x2-c1,2)+ Math.pow(y2-c2,2);
		d3= Math.pow(x3-c1,2)+ Math.pow(y3-c2,2);
		if((d1>=d2)&&(d1>=d3)) d=d1;
		else if((d2>=d3)&&(d2>=d1)) d=d2;
		else d= d3;
		System.out.println("The equation of the circle is (x-" + c1 + ")^2 + " + "(y-" + c2 + ")^2 = " + d);
		

		


		
  
			






	}
}
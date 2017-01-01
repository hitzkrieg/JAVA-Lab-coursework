import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner stdIn= new Scanner(System.in);
        
        double grade1, grade2;
        boolean  passed1, passed2;
        
        System.out.println("Creating a new object of Grad");
        System.out.println("Enter grade of the Grad object: ");
        grade1= stdIn.nextDouble();
        Grad g= new Grad("Himesh", "1401pcs26", grade1, 24, "Patna");
        
        System.out.println("Creating a new object of Grad");
        System.out.println("Enter grade of the Undergrad object: ");
        grade2= stdIn.nextDouble();
        Undergrad ug= new Undergrad("Hitesh", "1401cs56", grade2, 20, "Patna");
        
        System.out.println("Calling the isPassed() of Grad object");
        passed1= g.isPassed(g.grade);
        if(passed1==true)
            System.out.println("Passed");
        else
            System.out.println("Not Passed");
        
        System.out.println("Calling the isPassed() of Undergrad object");
        passed2= ug.isPassed(ug.grade);
        if(passed2==true)
            System.out.println("Passed");
        else
            System.out.println("Not Passed");
            
        
        
        
        
        
        
        
    }
            
    
    
    
    
    
    
}
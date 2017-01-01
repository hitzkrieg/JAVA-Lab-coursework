import java.util.Scanner;

class MyException extends Throwable
{
    void inputFormat()
            {
               System.out.println("Input is not in proper format");
            }
    void negative()
    {
        System.out.println("Both numbers should be non negative");
    }
    
    /*void integer()
    {
        System.out.println("Both numbers should be integers");
    }*/
    
    void divideByZero()
    {
        System.out.println("Cannot divide by zero");
    }
    
    
        
}


abstract class MyCalculator
{
   public abstract double calculate(double a, double b);
    
}

class Add
{
    double calculate(double a, double b)
    {
        return(a+b);
    }
}

class Subtract
{
    double calculate(double a, double b)
    {
        return(a-b);
    }
}

class Multiply
{
    double calculate(double a, double b)
    {
        return(a*b);
    }
}

class Divide
{
    double calculate(double a, double b)
    {
        try
        {
            if(b==0)
                throw(new MyException());
            return(a/b);
        }
        catch(MyException m)
        {
            m.divideByZero();
            System.exit(1);
        }
        return(0);
    }
}


class Exponent
{
    double calculate(double a, double b)
    {
        /* try
        {
            if((a%1!=0)&&(b%1!=0))
            {
                throw (new MyException());
            }
        int a1 =(int)a;
        int b1= (int)b;*/
        return(Math.pow(a, b));
        /*}
        catch(MyException n)
        {
            n.integer();
        }
        return(0);*/
    }
}

class Remainder
{
    double calculate(double a, double b)
    {
        return(a%b);
    }
    
}

class Test
{
    public static void main(String[] args)
    {
        Scanner stdIn= new Scanner(System.in);
        String cmd; int i=0;
        double a=0,b=0;
        String a1="", a2="";char operator= '+'; 
        System.out.println("Enter the command to compute (no spaces between operand and operators)");
        cmd= stdIn.nextLine();
        
        while((cmd.charAt(i)!='+')|| (cmd.charAt(i)!='-')|| (cmd.charAt(i)!='*')|| (cmd.charAt(i)!='/')|| (cmd.charAt(i)!='^')|| (cmd.charAt(i)!='%'))
                {
                    try
                    {
                        if( ((cmd.charAt(i)<'0')||(cmd.charAt(i)>'9')) && (cmd.charAt(i)!='.') && (cmd.charAt(i)!='-') )
                            throw(new MyException());
                    a1= a1+ cmd.charAt(i);
                    i++;
                    if(i==cmd.length()-1)
                        break;
                    }
                    catch(MyException n)
                    {
                        n.inputFormat();
                        /*System.out.println("1"); */
                        System.exit(1);
                    }
                    
                }
        try
        {
        if(i==(cmd.length()-1))
            throw(new MyException());
        }
        
        catch(MyException n)
                {
                    n.inputFormat();
                    /* System.out.println("2");*/
                    System.exit(1);
                }
        
        try
        {
        if((cmd.charAt(i)!='+')|| (cmd.charAt(i)!='-')|| (cmd.charAt(i)!='*')|| (cmd.charAt(i)!='/')|| (cmd.charAt(i)!='^')|| (cmd.charAt(i)!='%'))
            throw(new MyException());
        operator= cmd.charAt(i);
        i++;
        }
        
        catch(MyException n)
                {
                    n.inputFormat();
                    /* System.out.println("3");*/
                    System.exit(1);
                }
        
        while(i<cmd.length())
        {
           
                    
                    try
                    {
                        if( ((cmd.charAt(i)<'0')||(cmd.charAt(i)>'9')) && cmd.charAt(i)!='.' )
                            throw(new MyException());
                    a2= a2+ cmd.charAt(i);
                    i++;
                    
                    }
                    catch(MyException n)
                    {
                        n.inputFormat();
                        /*System.out.println("4");*/
                        System.exit(1);
                    }
        }
        try
        {
        a= Double.parseDouble(a1);
        b= Double.parseDouble(a2);
        if((a<0)||(b<0))
                throw(new MyException() );
        }
        
        catch(MyException n)
                {
                    n.negative();
                }
        
        
        
        if(operator=='+')
        {
            Add add= new Add();
            add.calculate(a, b);
        }
        else if(operator=='-')
        {
            Subtract sub= new Subtract();
            sub.calculate(a, b);
        }
        else if(operator=='*')
        {
            Multiply mult= new Multiply();
            mult.calculate(a, b);
        }
        else if(operator=='/')
        {
            Divide div= new Divide();
            div.calculate(a, b);
        }
        else if(operator=='%')
        {
            Remainder rem= new Remainder();
            rem.calculate(a, b);
        }
        else if(operator=='^')
        {
            Exponent exp= new Exponent();
            exp.calculate(a, b);
        }
        
    }
}


    
    




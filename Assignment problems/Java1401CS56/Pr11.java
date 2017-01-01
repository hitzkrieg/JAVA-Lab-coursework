import java.util.Scanner;

class Pr11
{
        public static void main(String[] args)
        {
                        
        int i=0;
        Scanner stdIn= new Scanner(System.in);
        System.out.println("Please enter your full name: ");
        String name= stdIn.nextLine();
        
        String[] name1= name.split(" ");
        if (name1.length==1)
        {
                System.out.println("Name: "+ name1[0]);
        }
        
        else if(name1.length==2)
        {
                System.out.println("Name: " + name1[0].charAt(0)+ "."+name1[1]);
        }
        
        else if(name1.length==3)
        {
                System.out.println("Name: " + name1[0].charAt(0)+ "."+ name1[1].charAt(0)+ "." + name1[2]);
        }
        



        }

}
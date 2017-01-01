import java.io.*;
import java.util.Scanner;

class RunMe
{
    public static void main(String[] args)
    {
        int temp;
        BST tree= new BST();
        BstMirror mirror = new BstMirror();
        Scanner sc= null;
        
        try
        {
            sc= new Scanner(new File("data.txt"));
        }
        catch(Exception e)
                {
                   System.out.println("Error in file reading");
                }
    
    
    
    
    while(sc.hasNext())
    {
        temp= sc.nextInt();
        tree.insert(temp);
        mirror.insert(temp);
        
    }
    System.out.println("********************************************************");
    
    System.out.println("Printing the original tree level wise: ");
    tree.levelOrder();
    System.out.println("\n********************************************************");
    
    System.out.println("\nPrinting the mirror tree level wise: ");
    mirror.levelOrder();
     System.out.println("\n********************************************************");
      
    } 
    
}

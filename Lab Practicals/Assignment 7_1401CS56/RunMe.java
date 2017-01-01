import java.util.Scanner;

class RunMe
{
    public static void main(String[] args)
    {
        System.out.println("Creating a tree and adding data");
        
        FamilyTree tree = new FamilyTree("Node1", "27-10-1994", "Patna", "123"); /*Details of the head of the family*/
        
        tree.insert("Node2", "12-12-1993", "Guwahati", "235","Node1" );
        tree.insert("Node3", "14-06-1993", "Guwahati", "134","Node1" );
        tree.insert("Node4", "16-02-1994", "Kolkata", "340","Node2" );
        tree.insert("Node5", "06-03-1993", "Kolkata", "239","Node2" );
        tree.insert("Node6", "09-03-1994", "Bangalore", "864","Node3" );
        tree.insert("Node7", "25-04-1995", "Bangalore", "268","Node3" );
        tree.insert("Node8", "15-05-1993", "Kanpur", "367","Node4" );
        tree.insert("Node9", "27-06-1994", "Mumbai", "265","Node4" );
        tree.insert("Node10", "17-06-1997", "Chennai", "228","Node5" );
        tree.insert("Node11", "21-07-1992", "Chennai", "168","Node5" );
        tree.insert("Node12", "22-08-1993", "Rohtak", "238","Node6" );
        tree.insert("Node13", "22-09-1994", "Coimbatore", "334","Node6" );
        tree.insert("Node14", "24-10-1993", "Hyderabad", "138","Node7" );
        tree.insert("Node15", "18-07-1994", "Silchar", "168","Node7" );
        
        boolean flag= true;
        Scanner stdIn= new Scanner(System.in);
        String name, parent, firstChild,secondChild, dob,contact;
        
       
        
        
        while(flag==true)
        {
            int choice;
            System.out.println("\n ************************************************ \n ");
            
            System.out.println("Select the fields to search: (Input 1 for yes and any other digit for no)");
            System.out.println("Name (enter 1 or 0): ");
            choice= stdIn.nextInt();
            if(choice==1)
            {
                System.out.println("Enter name to be searched: ");
                name= stdIn.next();
            }
            else
            {
                name= null;
            }
            
            System.out.println("DOB (enter 1 or 0): ");
            choice= stdIn.nextInt();
            if(choice==1)
            {
                System.out.println("Enter DOB to be searched: ");
                dob= stdIn.next();
            }
            else
            {
                dob= null;
            }
            
            System.out.println("Parent (enter 1 or 0): ");
            choice= stdIn.nextInt();
            if(choice==1)
            {
                System.out.println("Enter name of Parent to be searched: ");
                parent= stdIn.next();
            }
            else
            {
                parent= null;
            }
            
            System.out.println("First Child (enter 1 or 0): ");
            choice= stdIn.nextInt();
            if(choice==1)
            {
                System.out.println("Enter name of the first child to be searched: ");
                firstChild = stdIn.nextLine();
                
            }
            else
            {
                firstChild = null;
            }
            
            System.out.println("Second Child (enter 1 or 0): ");
            choice= stdIn.nextInt();
            if(choice==1)
            {
                System.out.println("Enter name of the second child to be searched: ");
                secondChild = stdIn.nextLine();
                
            }
            else
            {
                secondChild = null;
            }
            
            System.out.println("Contact (enter 1 or 0): ");
            choice= stdIn.nextInt();
            if(choice==1)
            {
                System.out.println("Enter the contact to be searched: ");
                contact = stdIn.nextLine();
                
            }
            else
            {
                contact = null;
            }
            
            System.out.println("\n ************************************************ \n ");
            System.out.println("Now enter by which method do you want to search: ");
            System.out.println("1. Pre Order Traversal");
            System.out.println("2. In Order Traversal(same as DFS)");
            System.out.println("3. Post Order Traversal");
            System.out.println("4. Level Ordered Traversal(same as BFS)");
            System.out.println("5. Breadth First search");
            System.out.println("6. Depth First Search");
            
            do
            {
                choice= stdIn.nextInt();
                if((choice<1)||(choice>6))
                {
                    System.out.println("Wrong input.Enter again(number between 1 and 6): ");
                }
            }while((choice<1)||(choice>6));
            
            switch(choice)
            {
                case (1): tree.searchPreOrdered(name,dob,parent,firstChild,secondChild,contact);break;
                case (2): tree.searchInOrdered(name,dob,parent,firstChild,secondChild,contact); break;
                case (3): tree.searchPostOrdered(name,dob,parent,firstChild,secondChild,contact); break;    
                case (4): tree.searchLevelOrdered(name,dob,parent,firstChild,secondChild,contact); break;
                case (5): tree.BFS(name,dob,parent,firstChild,secondChild,contact); break;    
                case (6): tree.DFS(name,dob,parent,firstChild,secondChild,contact); break;  
                default: System.out.println(" Some error here. Find me.");
            }
            System.out.println("\n ************************************************ \n ");
            System.out.println("Do you want to search more? Press 1 to continue, 0 to exit");
            do
            {
                choice= stdIn.nextInt();
                if(!((choice == 0)||(choice== 1)))
                    System.out.println("Wrong input.Press 1 to continue search, 0 to exit ");
            }while(!((choice == 0)||(choice== 1)));
            
            if(choice==0)
            {
                flag= false;
                System.out.println("Thank you");
            }
            
        }
            
        
        
        
    }
    
    
    
}
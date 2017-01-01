
import java.util.ArrayList;

class Queue<T>
{
    ArrayList<T> queue= new ArrayList();
    int size;
    
    Queue()
    {
        size=0;
    }
    
    void enqueue(T item)
    {
        queue.add(item);
        size++;
    }
    
    T dequeue()
    {
        T temp;
      if(queue.isEmpty()== true)
          return(null);
      else
      {
          temp = queue.get(0);
          queue.remove(0);
                  
          size--;
          return(temp);
      }
      
    }
    
}

class FamilyTree
{
     private class Node
    {
        
        Node parent;
        
        String name;
        String address;
        String contact;
        
        Node first; /*First child*/
        Node second;
        
        String dob;
        
        
        Node(String name, String dob, String address,String contact, Node parent, Node first, Node second)
        {
            this.name= name;
            this.dob= dob;
            this.address= address;
            this.contact= contact;
            this.first= first;
            this.second= second;
            this.parent= parent;
            
        }
    }
    
    Node head;
    int size;
    static int count;
    
    FamilyTree(String name, String dob, String address, String contact)
    {
        head= new Node(name,dob,address, contact, null, null, null);
        size=0;
        
    }
    
    boolean insert(String name, String dob, String address,String contact, String parent)
    {
        Node p = search(parent, null, null, null, null, null);
        if(p==null)
        {
            return(false);
        }
        else
        {
            Node n= new Node(name,dob,address,contact,p, null,null );
            if(p.first== null)
            {
                p.first= n;
                size++;
                return(true);
            }
            else if(p.second== null)
            {
                p.second= n;
                size++;
                return(true);
            }    
            else
            {
                return(false);
            }
            
        }
    }
    
    
    Node search(String name, String dob, String parent, String first, String second, String contact)
    {
        Queue<Node> q1=new Queue();
        q1.enqueue(head);
        
        while(q1.size!=0)
        {
            Node s= q1.dequeue();
            boolean flag= true;
            
            if(!((name == null )|| (s.name.equalsIgnoreCase(name))))
                flag= false;
            
            if(!((dob == null )|| (s.dob.equalsIgnoreCase(dob))))
                flag= false;
            
            if(!((contact == null )|| (s.contact.equalsIgnoreCase(contact))))
                flag= false;
            
            if((parent!=null)&&(s.parent==null))
            {
                
                flag= false;
            }
            if((first!=null)&&(s.first==null))
            {
                
                flag= false;
            }
            
            if((second!=null)&&(s.second==null))
            {
                flag= false;
            }
            
            if(s.parent!=null)
            {
                if(!((parent == null )|| (s.parent.name.equalsIgnoreCase(parent))))
                flag= false;
            }
            
            if(s.first!=null)
            {
                if(!((first == null )|| (s.first.name.equalsIgnoreCase(first))))
                flag= false;
            }
            
            if(s.second!=null)
            {
                if(!((second == null )|| (s.second.name.equalsIgnoreCase(second))))
                flag= false;
            }
            
            if(flag==true)
            {
                return(s);
            }
            
            else
            {    
                if(s.first!= null)
                    q1.enqueue(s.first);
                if(s.second!= null)
                    q1.enqueue(s.second);
                    
            }        
        }
        
        return(null);
        
                
        
        
    }
    
    void printDetails(Node n) /*Assuming n is not null */
    {
        
        System.out.println("\n ************************************************ \n ");
        System.out.println("Name: "+ n.name);
        System.out.println("DOB: "+ n.dob);
        if(n.parent!= null)
        {
            System.out.println("Parent: "+ n.parent.name);
        }
        if(n.first!= null)
        {
            System.out.println("First Child: "+ n.first.name);
        }
        if(n.second!= null)
        {
            System.out.println("Second Child: "+ n.second.name);
        }
        System.out.println("Contact: "+ n.contact);
        
        System.out.println("\n ************************************************ \n ");
        
        
    }

    Node searchLevelOrdered(String name, String dob, String parent, String first, String second, String contact)
    {
        System.out.println("\n ************************************************ \n ");
        System.out.println("Making a level ordered search");
        Queue<Node> q1=new Queue();
        q1.enqueue(head);
        int count= 0;
        
        while(q1.size!=0)
        {
            Node s= q1.dequeue();
            count++;
            System.out.println("Current Node: " + s.name + " Count: "+ count);
            boolean flag= true;
            
            if(!((name == null )|| (s.name.equalsIgnoreCase(name))))
                flag= false;
            
            if(!((dob == null )|| (s.dob.equalsIgnoreCase(dob))))
                flag= false;
            
            if(!((contact == null )|| (s.contact.equalsIgnoreCase(contact))))
                flag= false;
            
            if((parent!=null)&&(s.parent==null))
            {
                
                flag= false;
            }
            if((first!=null)&&(s.first==null))
            {
                
                flag= false;
            }
            
            if((second!=null)&&(s.second==null))
            {
                flag= false;
            }
            
            if(s.parent!=null)
            {
                if(!((parent == null )|| (s.parent.name.equalsIgnoreCase(parent))))
                flag= false;
            }
            
            if(s.first!=null)
            {
                if(!((first == null )|| (s.first.name.equalsIgnoreCase(first))))
                flag= false;
            }
            
            if(s.second!=null)
            {
                if(!((second == null )|| (s.second.name.equalsIgnoreCase(second))))
                flag= false;
            }
            
            if(flag==true)
            {
                System.out.println("Found");
                System.out.println("Details: ");
                printDetails(s);
                return(s);
            }
            
            else
            {    
                if(s.first!= null)
                    q1.enqueue(s.first);
                if(s.second!= null)
                    q1.enqueue(s.second);
                    
            }        
        }
        
        System.out.println("Not found. ");
        return(null);
        
                
        
        
    }
    
    void searchInOrdered(String name, String dob, String parent, String first, String second, String contact)
    {   System.out.println("Making a in-ordered search");    
        count= 0;
            
            Node k= inOrder(head, name, dob, parent, first, second, contact);
            if(k== null)
            {
                System.out.println("Not found!");
            }
    }
    void searchPostOrdered(String name, String dob, String parent, String first, String second, String contact)
        {
            System.out.println("Making a post ordered search");
            count= 0;
            Node k= postOrder(head, name, dob, parent, first, second, contact);
            if(k== null)
            {
                System.out.println("Not found!");
            }
        }
        
    void searchPreOrdered(String name, String dob, String parent, String first, String second, String contact)
        {
            System.out.println("Making a pre ordered search");
            count= 0;
            Node k= preOrder(head, name, dob, parent, first, second, contact);
            if(k== null)
            {
                System.out.println("Not found!");
            }
        }
    
    void DFS(String name, String dob, String parent, String first, String second, String contact)
    {
            System.out.println("Making a depth first search");
            count= 0;
            Node k= inOrder(head, name, dob, parent, first, second, contact);
            if(k== null)
            {
                System.out.println("Not found!");
            }
    }
    
    Node BFS(String name, String dob, String parent, String first, String second, String contact)
    {
        System.out.println("Making a breadth first search");    
        return(searchLevelOrdered(name,dob,parent,first,second,contact));
    }
    
    Node inOrder(Node s, String name, String dob, String parent, String first, String second, String contact)
    {
        
        if(s== null)
        {
            System.out.println("Empty family Tree");
            
            
        }
        else
        {   Node k1, k2;
        
            if(s.first!=null)
            {
               k1= inOrder(s.first, name, dob, parent, first, second, contact);
               if(k1!= null)
                   return(k1);
            }   
            
            boolean flag= true;
            count++;
            
            if(!((name == null )|| (s.name.equalsIgnoreCase(name))))
                flag= false;
            
            if(!((dob == null )|| (s.dob.equalsIgnoreCase(dob))))
                flag= false;
            
            if(!((contact == null )|| (s.contact.equalsIgnoreCase(contact))))
                flag= false;
            
            if((parent!=null)&&(s.parent==null))
            {
                
                flag= false;
            }
            if((first!=null)&&(s.first==null))
            {
                
                flag= false;
            }
            
            if((second!=null)&&(s.second==null))
            {
                flag= false;
            }
            
            if(s.parent!=null)
            {
                if(!((parent == null )|| (s.parent.name.equalsIgnoreCase(parent))))
                flag= false;
            }
            
            if(s.first!=null)
            {
                if(!((first == null )|| (s.first.name.equalsIgnoreCase(first))))
                flag= false;
            }
            
            if(s.second!=null)
            {
                if(!((second == null )|| (s.second.name.equalsIgnoreCase(second))))
                flag= false;
            }
            
            if(flag==true)
            {
                System.out.println("Found");
                System.out.println("Node: " + s.name + " Count: "+ count);
                System.out.println("Details: ");
                printDetails(s);
                return(s);
                
            }
            
            else
            {
                System.out.println("Node: " + s.name + " Count: "+ count);
            }
            
                
        
                if(s.second!=null)
                {
                    k2= inOrder(s.second,name, dob, parent, first, second, contact);
                    if(k2!= null)
                        return(k2);
                }
                
            }
        return(null);
        
        } 
    Node preOrder(Node s, String name, String dob, String parent, String first, String second, String contact)
    {
        if(s== null)
        {
            System.out.println("Empty family Tree");
            
            
        }
        else
        {
            
            
            boolean flag= true;
            count++;
            
            if(!((name == null )|| (s.name.equalsIgnoreCase(name))))
                flag= false;
            
            if(!((dob == null )|| (s.dob.equalsIgnoreCase(dob))))
                flag= false;
            
            if(!((contact == null )|| (s.contact.equalsIgnoreCase(contact))))
                flag= false;
            
            if((parent!=null)&&(s.parent==null))
            {
                
                flag= false;
            }
            if((first!=null)&&(s.first==null))
            {
                
                flag= false;
            }
            
            if((second!=null)&&(s.second==null))
            {
                flag= false;
            }
            
            if(s.parent!=null)
            {
                if(!((parent == null )|| (s.parent.name.equalsIgnoreCase(parent))))
                flag= false;
            }
            
            if(s.first!=null)
            {
                if(!((first == null )|| (s.first.name.equalsIgnoreCase(first))))
                flag= false;
            }
            
            if(s.second!=null)
            {
                if(!((second == null )|| (s.second.name.equalsIgnoreCase(second))))
                flag= false;
            }
            
            if(flag==true)
            {
                System.out.println("Found");
                System.out.println("Node: " + s.name + " Count: "+ count);
                System.out.println("Details: ");
                printDetails(s);
                return(s);
                
            }
            
            else
            {
                System.out.println("Node: " + s.name + " Count: "+ count);
            }
            
            Node k1, k2;
            if(s.first!=null)
            {
               k1= preOrder(s.first, name, dob, parent, first, second, contact);    
               if(k1!=null)
                   return(k1);
            }
        
                if(s.second!=null)
                {
                    k2= preOrder(s.second,name, dob, parent, first, second, contact);
                    if(k2!= null)
                        return(k2);
                    
                }
            }
        return(null);
        
        }
    
    
    
    Node postOrder(Node s, String name, String dob, String parent, String first, String second, String contact)
    {
        if(s== null)
        {
            System.out.println("Empty family Tree");
            
            
        }
        else
        {
            Node k1, k2;
            if(s.first!=null)
            {
               k1= postOrder(s.first, name, dob, parent, first, second, contact);
               if(k1!= null)
                   return(k1);
               
            }
            
             if(s.second!=null)
             {
                   k2= postOrder(s.second,name, dob, parent, first, second, contact);
                   if(k2!= null)
                   return(k2);
             }
            
            boolean flag= true;
            count++;
            
            if(!((name == null )|| (s.name.equalsIgnoreCase(name))))
                flag= false;
            
            if(!((dob == null )|| (s.dob.equalsIgnoreCase(dob))))
                flag= false;
            
            if(!((contact == null )|| (s.contact.equalsIgnoreCase(contact))))
                flag= false;
            
            if((parent!=null)&&(s.parent==null))
            {
                
                flag= false;
            }
            if((first!=null)&&(s.first==null))
            {
                
                flag= false;
            }
            
            if((second!=null)&&(s.second==null))
            {
                flag= false;
            }
            
            if(s.parent!=null)
            {
                if(!((parent == null )|| (s.parent.name.equalsIgnoreCase(parent))))
                flag= false;
            }
            
            if(s.first!=null)
            {
                if(!((first == null )|| (s.first.name.equalsIgnoreCase(first))))
                flag= false;
            }
            
            if(s.second!=null)
            {
                if(!((second == null )|| (s.second.name.equalsIgnoreCase(second))))
                flag= false;
            }
            
            if(flag==true)
            {
                System.out.println("Found");
                System.out.println("Node: " + s.name + " Count: "+ count);
                System.out.println("Details: ");
                printDetails(s);
                
                return(s);
                
            }
            
            else
            {
                System.out.println("Node: " + s.name + " Count: "+ count);
            }
            
                
        
               
            }
        return(null);
        
        }
    
    }
        
    
    
    
    
    

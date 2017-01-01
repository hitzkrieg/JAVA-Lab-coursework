/* package codechef; // don't place package name! */

import java.util.*;


class Queue
{
    
    class Node
    {
        String name;
        double rank;
        Node next;
        
        Node(String s1)
        {
            name=s1;
            rank= (int)(10* Math.random());
            
        }
        
    }
    
    Node ranker;
    Node tail;
    Node head;
    
    Queue()
    {
        head=null;
        tail=null;
        ranker=null;
    }
    
    void enqueue(String s)
    {
        if (head==null)
        {
         head= new Node(s);
         ranker=head;
         tail=head;
        }
        
        else 
        {
            tail.next= new Node(s);
	    tail=tail.next;
            updateRanker();

        }
    }
    
    void updateRanker()
    {
        Node temp= head;
        ranker = head;
        while(head!=null)
        {
            if(head.rank < ranker.rank)
            {
                ranker=head;
            }
            head=head.next;
        }
        head=temp;
    }
            
    String dequeue()
    {
        if(head==null)
        {
            return("Cannot Dequeue more!");
        }
        
        else if(head==ranker)
            {
                Node temp= ranker;
                if(head.next==null)
                {   
	            head=null;
                    tail=null;
		    ranker=null;
		    return(temp.name);

                }
		head=ranker.next;
                updateRanker();
		return(temp.name);
            }    
        else
        {
            Node temp=head;
            Node temp2= ranker;
            while(head!=null)
            {
                if(head.next==ranker)
                {   head.next=ranker.next;
                    
                    if(ranker==tail)
                    {
                        tail=head;
                    }
                    head= temp;
                    updateRanker();
                    return(temp2.name);
                }
                
                head=head.next;
            }
        }
               
            
            
        
     return("Something's Wrong: Reached Line 108");   
    }
            
    
    void print()
    {
        System.out.println("**********************");
        System.out.println("The current list:");
        Node temp= head;
        while(temp!=null)
        {
            System.out.println("Name= " + temp.name + "   Rank = " + temp.rank);
	    temp= temp.next;
        }
	System.out.println("**********************");
        
    }

}



class Priority
{
	public static void main (String[] args) throws java.lang.Exception
	{
            Queue q= new Queue();
            
		Scanner stdIn= new Scanner(System.in);
                System.out.println("Enter number of participants: ");
                int N= stdIn.nextInt();
                System.out.println("Enter their names: ");
                String s;
                for(int i=0; i<N; i++)
                {
                    s= stdIn.next();
                    q.enqueue(s);
                }
                
                q.print();
                
                System.out.println("\n Here are the winners in order:");
                for(int i=0; i<N; i++)
                {   
                    s= q.dequeue();
                    System.out.println("Prize "+ (i+1) + " :" + s);
		   
                    
                }
                
	}
}

import java.util.Scanner;

class LinkedList
{
    class Node
    {
        Node next;
        char item;
        
        Node(char ch, Node n)
        {
            item= ch;
            next= n;
        }
        
        
    }
    
    Node head;
    Node tail;
    int size;
    
    LinkedList()
    {
        head=null;
        tail=null;
        size=0;
    }
    
    void addAtEnd(char ch)
    {
        if(tail==null)
        {
            tail=head=new Node(ch, null);
            size++;
        }
        else
        {
            Node temp= new Node(ch, null);
            tail.next= temp;
            tail= temp;
            size++;
            
        }
        
    }
    
    boolean removeEnd()
    {   if(tail==null)
        {
            System.out.println("Cannot remove more");
            return(false);
        }
        else if(head==tail)
        {
            head=null;
            tail=null;
            size--;
            return(true);
            
        }
        else 
        {
            Node temp= head;
            while(temp.next!=tail)
            {
                temp= temp.next;
            }
            tail=temp;
            temp.next=null;
            size--;
            return(true);
        }
    }
    
    char getLast()
    {
        if(tail==null)
        {   
            System.out.println("Invalid operation");
            return('a');
        }
        else
        {
            return(tail.item);
        }
    }
                
            
}


class Stack
{
    LinkedList l;
    int size;
    
    Stack()
    {
        l= new LinkedList();
        size=0;
    }
    
    void push(char ch)
    {
        l.addAtEnd(ch);
        size= l.size;
    }
    
    char pop()
    {   char ch= l.getLast();
        l.removeEnd();
        size= l.size;
        return(ch);
    }
    
    char peek()
    {
        return(l.tail.item);
    }
    
}

class Balanced
{   
    static boolean complement(char ch1, char ch2)
    {
        if((ch1==']')&&(ch2=='['))
        {
                return(true);
        }
        
        else if((ch1=='}')&&(ch2=='{'))
        {
                return(true);
        }
        else if((ch1==')')&&(ch2=='('))
        {
                return(true);
        }
        else
        {
            return(false);
        }
        
                      
    }
    public static void main(String[] args)
    {
        String input;
        boolean flag=true;
        Stack s= new Stack();
        
        Scanner stdIn= new Scanner(System.in);
        System.out.println("Please enter the expression in a single line");
        input= stdIn.nextLine();
        for(int i=0; i<input.length(); i++)
        {
            if( (input.charAt(i)=='{') || (input.charAt(i)=='}') || (input.charAt(i)=='[') || (input.charAt(i)==']') || (input.charAt(i)=='(')|| (input.charAt(i)==')'))
            s.push(input.charAt(i));
        }
        
        
        if(s.size %2 !=0) /* If number of brackets are odd, then obviously false */
        {
            System.out.println("FALSE");
            flag=false;
        }
        
        else
        {
            Stack s1= new Stack(); /*We make another stack */
            char ch;
            
            while(s.size!=0) /*We pop from s and push into s1, if two consecutive elements in s1 are complementary, (eg '{' and '}') then both are popped. */
            {
                ch= s.pop();
                if(s1.size==0)
                {
                    s1.push(ch);
                }
                else if(complement(s1.peek(),ch))
                {
                    s1.pop();
                }
                else
                {
                    s1.push(ch);
                }
            }
            
            if(s1.size==0)
                System.out.println("TRUE");
            else 
                System.out.println("FALSE");
                
               
            
            
            
            
            
        }
        
        
        
        
        
        
    }
    
        
    
    
    
}
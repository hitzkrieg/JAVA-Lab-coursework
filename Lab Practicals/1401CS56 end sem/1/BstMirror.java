import java.util.Scanner;
import java.util.*;

   
class BstMirror
{
    private class Queue<T>
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
    
    private class Node
    {
        int data;
        Node left;
        Node right;
        Node parent;
        int detail;
        
        Node(int data)
        {
            this.data= data;
            left= null;
            right= null;
            parent= null;
            detail=0;
        }
    }
    
    Node root;
    int size;
    int count;
    int count1;
   
    BstMirror()
            {
                root= null;
                size=0;
                count=0;
                count1=0;
            }
    
    
    void insert(int item)
    {   
        Node temp= new Node(item);
        addNode(root, temp);
    }
    
    void addNode(Node n, Node item) 
    {
        if(n==null)
        {
          root= item;
          size++;  
        }    
        else if(n.data< item.data)
        {
            if(n.left==null)
            {
                n.left= item;
                size++;
            }
            else
            {
            addNode(n.left, item);
            }
        }    
        else
        {
            if(n.right==null)
            {
                n.right= item;
                size++;
            }
            else
            {
            addNode(n.right, item);
            }
        }    
       
    }
    
    void levelOrder()
    {
        Queue<Node> q1= new Queue();
        if(root!=null)
        {
            q1.enqueue(root);
        }
        
        while(q1.size!=0)
        {
            
            Node s= q1.dequeue();
            if(s.detail!= count1)
            {
                System.out.print("\n");
                count1++;
            }
            System.out.print(s.data + " ");
            if(s.left!=null)
            {
                s.left.detail= s.detail + 1;
                q1.enqueue(s.left);
            }
            if(s.right!=null)
            {
                s.right.detail= s.detail + 1;
                q1.enqueue(s.right);
            }    
          
        }
        
        
    }
    
    
}
    
    

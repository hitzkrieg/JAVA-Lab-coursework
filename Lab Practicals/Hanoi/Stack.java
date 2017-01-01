import java.util.ArrayList;

public class Stack
	{
		public ArrayList<Integer>stack= new ArrayList<Integer>(); 
		int size;
		
		void push(int i)
		{
			this.stack.add(i);
			size++;
		}
		
		int pop()
		{	int temp=0;
                        if(size!=0)
			{
				temp= this.stack.get(this.size-1);
				this.stack.remove(this.size-1);
				this.size= this.size-1;
			}
			return(temp);
		}
		
		Stack()
		{
			this.size=0;
		}
	}
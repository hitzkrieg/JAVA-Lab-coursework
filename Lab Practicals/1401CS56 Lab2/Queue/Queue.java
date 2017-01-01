class Queue
{
	int[]a = new int[MAX];

	int n;
	static final int MAX=100;
	
	void enqueue(int a1)
	{
		if (n<MAX-1)
		{
			a[this.n]=a1;
			n++;
		}
		else
		System.out.println("Limit Exceeded, can't Enqueue!");

	}
	
	int dequeue()
	{
		int j=0; int temp=0;
		if(n!=0)
		{
			
			temp= a[0];
		
			for(j=0; j<n-1; j++)
			{
				this.a[j]= this.a[j+1];
			}
			n--;
                        return(temp);
		}	

                else return(-1);
        }

	Queue()
	{
		this.n=0;
	}
}
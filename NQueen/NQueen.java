import java.util.*;



class Queen 
        {
    
   
    int number;
    int row;
    int column;
    
    Queen(int row, int column, int number)
    {
        this.number=number;
        this.row=row;
        this.column=column;
    }
    
    
}





class NQueen
{
    static int[][] a =new int[8][8]; /* To find available positions */ 
    static int[][] b= new int[8][8]; /* To place the queens */
    static int n;
    static Stack S= new Stack();
    
    static void initialize()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
               a[i][j]=1;
               b[i][j]=0;
                
            }
        }
        n=0;
    }
    
    static void print()
    {
        System.out.println("***********************************");
     for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                System.out.print(b[i][j] + " ");
            }
            System.out.println("");
        }   
    }
    
    static void add()
    {
       int i;
       for(i=0; i<8; i++)
                {
                    if(a[i][n]==1)
                        break;
                }
       S.push(new Queen(i,n,n));
       b[i][n]=1;
       n++;
       update();
       print();
       
             
    }
    
    static void Backtrack()
    {
        boolean k= nextMove((Queen)S.peek());
        if((k==false)&&(n>1))
        {
            Queen q= (Queen)S.pop();
            b[q.row][q.column]=0;
	    System.out.println("Hello" + q.row + " " + q.column);	
            n--;
            update();
            print();
            
            Backtrack();
        }
        else if((k==false)&&(n==1))
        {
            n--;
        }
    }
    static boolean available()
            {
                for(int i=0; i<8; i++)
                {
                    if(a[i][n]==1)
                        return(true);
                }
                
                return(false);
            }
    
    static boolean nextMove(Queen q)
    {   
        int i; boolean r=false;
        
            for(i=q.row; i<8; i++)
            {
                if(a[i][q.column]==1) /*Check this space for logical error later regarding break statement */
                {
                    b[q.row][q.column]=0;
                    q.row=i;
                    b[q.row][q.column]=1;
                    
                    update();
                    r=true;
                    print();
                    break;
                    
                    
                    
                }
            }
        
        return(r);
        
    }
    
    static void update()
    {
     for(int i1=0; i1<8; i1++)
     {
        for(int i2=0; i2<8; i2++)
        {
                    if(b[i1][i2]==1)
                    {
                        
                    
                        for(int j=0; j<8; j++)
                        {
                            for(int k=0; k<8; k++)
                            {
                                if(j==i1)
                                    a[j][k]=0;
                                else if(k==i2)
                                    a[j][k]=0;
                                else if(Math.abs(j-i1)== Math.abs(k-i2))
                                     a[j][k]=0;
                                    
                            
                            
                            }
                        }
                        
                    }
        
        }
    }    
        
        
    }
public static void main(String[] args)
{
    initialize();
    while (n!=8)
    {
        boolean k= available();
        if(k==true)
        {
            add();
        }
        
        else
        {
            Backtrack();
        }
        if(n==0)
        {
            System.out.println("There exists no way!");
            break;
        }    
    }
    
    if(n==8)
    {
        print();
    }
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
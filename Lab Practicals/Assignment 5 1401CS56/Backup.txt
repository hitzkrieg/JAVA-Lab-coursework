#include<stdio.h>



#define MAX 16 /* Max number of variables in a product term */

typedef unsigned short WORD; /* We use 16-bit words */

int n; /* Number of minterms */
int n1; /*No of variables*/

struct term{
WORD uc; /* Bits 1 for uncomplemented variables. */
WORD c; /* Bits 1 for complemented variables. */
};
typedef struct term Term;


void convert(WORD k, Term* T) /*Convert the minterms to our format */
{
    T->uc=k;
    T->c= (~k);
    
}


int EqualTerms(Term T1, Term T2) 
{
    if( (T1.uc == T2.uc) && (T1.c == T2.c) )
        return(1);
    else return(0);
}

int SingleOne(WORD w) /*To check if only one of the bits of the word is 1 */
{
    int ones=0,i;
    for(i=0; i<MAX; i++)
    {
        if(((w>>i)&1)==1)
        {
            ones++;
        }
    }
    
    if(ones==1)
        return(1);
    else return(0);
}

int Ones(Term t)
{
    int i, ones=0;
    for(i=0; i<MAX; i++)
    {
        if(((t.uc>>i)&1)==1)
        {
            ones++;
        }
    }
    return(ones);
}

void printTerm(Term t)
{
    char A[MAX+1]; int i;
    for(i=0; i<MAX; i++)
    {
        if(  ( ((t.uc>>i)&1) == 0)&& (  ((t.c>>i)&1) ==0 ) )
                A[MAX-i-1]= '-';
        else A[MAX-i-1]= (char)( ((t.uc>>i)&1)+ 48); /* 48 is (int)'0' */
    }
    A[MAX]='\0';
    printf("%s", A);
}

int reducable(Term T1, Term T2)
{
    WORD w1, w2;
    w1= T1.uc ^ T2.uc;
    w2= T1.c ^ T2.c;
    if((w1==w2)&&(SingleOne(w1))==1)
    {
        return(1);
    }
    else 
        return(0);
        
}

void reduce(Term T1, Term T2, Term* T3)
{
    T3->uc = T1.uc & T2.uc;
    T3->c = T1.c & T2.c;
}

int reducedFrom(Term t1, Term t2) /*Check if t1 has been reduced from t2 */
{
    WORD temp1,temp2;
    temp1= ~(t1.uc ^ t1.c);
    temp2= (   (t1.uc ^ t2.uc)  |  (t1.c ^ t2.c)  );
    if(temp1==temp2)
        return(1);
    else 
        return(0);
}





int main()
{
    int i,j,k;
    printf("\n Welcome to the Quine McCluskey Algorithm Implementing Program! \n");
    printf("Enter the number of min terms: ");
    scanf("%d", &n);
    WORD a[n];
    Term t[n];
    
   
    
    printf("\n Enter the min terms(no duplicates): (eg 1 4 5 9 11) ");
    
    for(i=0; i<n; i++)
    {
        scanf("%hu", &a[i]);
    }
    for(i=0; i<n; i++)
    {
        convert(a[i], &t[i]);
    }
    
    
    
    printf("\n Finding the essential prime implicants by comparing two consecutive levels:");
    
    Term table[MAX+1][n];
    int numTerms[MAX+1]; /* Number of terms in each row of table*/
    int covered[MAX+1][n]; /* Which terms of table have been covered*/ 
    int m;
    
    for(i=0; i<MAX+1; i++)
    {
        for(j=0; j<n; j++)
        {
        covered[i][j]=0;
        }
    }
    
    for(i=0; i<MAX+1; i++)
    {
        
        numTerms[i]=0;
    }
    
    
    
    
    for(i=0; i<n; i++)
    {
        
        m= Ones(t[i]);
        table[m][numTerms[m]]= t[i];
        numTerms[m]++;
        
    }
    
    printf("\n Generated table:\n ");
    
    
    for(i=0; i<MAX+1; i++)
    {
        for(j=0; j<numTerms[i]; j++)
        {   
             printTerm(table[i][j]); 
            printf(" ");
        }
        if(numTerms[i]!=0)
            printf("\n");
    }
    
    int flag=1;
    
    Term tempTable[MAX+1][n];
    int tempNumTerms[MAX+1];
    
    
    
    
    for(i=0; i<MAX+1; i++)
    {
        for(j=0; j<numTerms[i]; j++)
        {   
            tempTable[i][j]= table[i][j];
            
        }
        tempNumTerms[i]= numTerms[i];
        
    }
    
    
    int tempCovered[MAX+1][n];
    
    
    Term primeImplicants[n];
    int numPI=0; /*Number of prime implicants */
        
    
    while(flag==1)
        
    {
        
        printf("****************************");
        printf("\n Operations in next step:\n ");
        flag=0;
    Term table1[MAX+1][n];
    int numTerms1[MAX+1]; /* Number of terms in each row of table*/
    
    
    for(i=0; i<MAX+1; i++)
    {
        for(j=0; j<n; j++)
        {
            tempCovered[i][j]=0;
        }
    }
    
    for(i=0; i<MAX+1; i++)
    {
        
        numTerms1[i]=0;
    }
    
    Term temp;
    
        for (i=0; i<MAX; i++) /* We do for all levels except the last */
        {
        for (j=0; j<tempNumTerms[i]; j++) /* Do for all terms at this level */
            {
             
            for(k=0; k<tempNumTerms[i+1]; k++)
            {
                if(reducable(tempTable[i][j], tempTable[i+1][k])==1)
                {
                    printf("\n These are being reduced:" );
                    printTerm(tempTable[i][j]); printf(" ");
                    printTerm(tempTable[i+1][k]);
                    reduce(tempTable[i][j], tempTable[i+1][k], &temp);
                    printf("\n Reduced to "); printTerm(temp); 
                    m= Ones(temp);
                    table1[m][numTerms1[m]]= temp;
                    numTerms1[m]++;
                    
                    tempCovered[i][j]=1;
                    tempCovered[i+1][k]=1; 
                }
            }
            
              
            } 
        }
    
    printf("\n In this step, these are not covered(ie. prime implicants generated in this step) : \n ");
    
    for(i=0; i<MAX+1; i++)
    {
        for(j=0; j<tempNumTerms[i]; j++)
        {
            if(tempCovered[i][j]==0)
            {
                printTerm(tempTable[i][j]);
                primeImplicants[numPI]= tempTable[i][j];
                numPI++;
                printf(" ");
            }
        }
        
    }
    printf("\n In this step, these are the newly generated terms:\n  ");
     for(i=0; i<MAX+1; i++)
    {
        for(j=0; j<numTerms1[i]; j++)
        {        
                printTerm(table1[i][j]);
                printf(" ");
                flag=1;
            
        }
        if(numTerms1[i]!=0) 
            printf("\n");
    }
    
    for(i=0; i<MAX+1; i++)
    {
        for(j=0; j<numTerms1[i]; j++)
        {   
            tempTable[i][j]= table1[i][j];
            
        }
        tempNumTerms[i]= numTerms1[i];
        
    }
    
    
    
    if(flag==0)
    {   printf("\n No new terms.");
        printf("\n End of these steps of finding Prime Implicants");
    }
    

    
    }
    
    



    printf("\n These are the Prime Implicants: \n ");
    for(i=0; i<numPI; i++)
    {
        printTerm(primeImplicants[i]);
        printf(" ");
    }
    printf("\n ****************************");
    printf("\n To identify the essential set of prime implicants:");
    printf("\n The rows are the prime implicants and columns are the covered minterms(in the same order as above)\n ");
    

    
    int PIT[numPI][n]; /*Temporary Prime implicant table*/
    Term essPrimeImplicants[n]; /*To store the essential prime implicants */
    int numEssPI=0; /*Number of essential prime implicants */
    for(i=0; i<numPI; i++)
    {
        for(j=0; j<n; j++)
        {
            if(reducedFrom(primeImplicants[i], t[j])==1)  /*Check if primeImplicants[i] has been reduced from t[j] */
                PIT[i][j]=1;
            else PIT[i][j]=0;
            
        }
        
    }
    
    for(i=0; i<numPI; i++)
    {   
        printf("\n");
        for(j=0; j<n; j++)
        {
            
              printf("%d ",  PIT[i][j]);
           
            
        }
        
    }
    
    int coveredRows[numPI];
    int coveredColumns[n];
    
    for(i=0; i<numPI; i++)
    {
        coveredRows[i]=0;
    }

    for(i=0; i<n; i++)
    {
        coveredColumns[i]=0;
    }
    
    printf("\n *****************************\n ");
    printf("Selecting essential prime implicants and checking their rows and columns:\n ");
    
    int tempi, count=0;
    for(j=0; j<n; j++)
    {
        count=0;
        for(i=0; i<numPI; i++)
        {
            
            if(PIT[i][j]==1)
            {
                tempi=i;
                count++;
            }
            

               
        }
        if(count==1)
            {   
                essPrimeImplicants[numEssPI]=primeImplicants[i];
                numEssPI++;

                coveredRows[tempi]=1;
                for(k=0; k<n; k++)
                {
                    if(PIT[tempi][k]==1)
                    {
                        coveredColumns[k]=1;
                    }
                }
            }
    }
    
    printf(" ");
    for(i=0; i<n; i++)
    {
        if(coveredColumns[i]==1)
            printf("*");
        else printf(" ");

    }
    for(i=0; i<numPI; i++)
    {   
        printf("\n");
        if(coveredRows[i]==1)
            printf("*");
        else printf(" ");
        for(j=0; j<n; j++)
        {
            
              printf("%d ",  PIT[i][j]);
           
            
        }
        
    }
    printf("\n Covered rows: \n ");
    for(i=0; i<numPI; i++)
    {
        printf("%d ", coveredRows[i]);
    }
    
    printf("\n Covered columns: \n ");
    for(i=0; i<n; i++)
    {
        printf("%d ", coveredColumns[i]);
    }
    
    printf("\n Only minimization by eliminating redundant rows is left. Other steps have been implemented in this c code ");

    return(0);

}

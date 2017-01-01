import java.util.Scanner;
import java.util.Random;

class Team
{
        int points;
        int goalsFor;
        int goalsAgainst;

        void printTeam()
        {
            System.out.println("{Points: "+ this.points + ", Goals For: " + this.goalsFor + ", Goals Against: " +
this.goalsAgainst + "}" );
        }

        int compare(Team t)
        {
            int flag=0;
            if(this.points > t.points)
            return(1);
            else if(this.points< t.points)
            return(-1);
            else if(this.points==t.points)
            {
                if(this.goalsFor > t.goalsFor)
                return(1);
                else if(this.goalsFor< t.goalsFor)
                return(-1);
                else if(this.goalsFor==t.goalsFor)
                {
                    if(this.goalsAgainst > t.goalsAgainst)
                    return(-1);
                    else if(this.goalsAgainst< t.goalsAgainst)
                    return(1);
                    else if(this.goalsAgainst== t.goalsAgainst)
                    return(0);
                }
            }
	return(0);
        }
}

class Problem1
{
		static Scanner stdIn= new Scanner(System.in);

            static Team[] teams1;
            static Team[] teams2 ; /* To sort by goalsFor */
            static Team[] teams3 ; /* To sort by goalsAgainst */
	static Team[] teams; 
            

static void options()
{	int flag=0; int opt=0;
	do
	{
	System.out.println("Please enter one of the options ( ) to access different functions:");
	System.out.println("1. Display teams in non increasing order of rankings");
	System.out.println("2. Search for teams with user entered value of Points/Goals For/ Goals Against");
	System.out.println("3. Search for teams within user entered range of Points/Goals For/ Goals Against");
	System.out.println("4. Exit");
	opt= stdIn.nextInt();
	if((opt>0)&&(opt<=3)) flag=1;
	else System.out.println("Invalid input try again");
	}while(flag==0);

	switch(opt)
	{
		case 1: ranking();break;
		case 2: searchValue();break;
		case 3: searchRange(); break;
		case 4: break;
		default: System.out.println("Error in switch case");
	}

}

static void ranking()
{ int i=0;

	System.out.println("\n Tally of teams in non-increasing order:");

            for(i=0; i<teams1.length; i++)
    {
        teams1[i].printTeam();
    }
options();


}

static void searchValue()
{	
	int opt; int flag=0;
	do
	{
	System.out.println("Please enter one of the options ( ) to access different functions:");
	System.out.println("1. Search by points");
	System.out.println("2. Search by Goals For");
	System.out.println("3. Search by Goals Against");
	
	opt= stdIn.nextInt();
	if((opt>0)&&(opt<=3)) flag=1;
	else System.out.println("Invalid input try again");
	}while(flag==0);

	if(opt==1)
		
	{
		System.out.println("Enter the points:");
		int p= stdIn.nextInt();
		search(p,1,0,teams1.length-1);
	}
	else if(opt==2)
	{
		System.out.println("Enter the Goals For:");
		int gf= stdIn.nextInt();
		search(gf,2, 0, teams2.length-1);
	}
	else if(opt==3)
	{
		
		System.out.println("Enter the Goals Against:");
		int ga= stdIn.nextInt();
		search(ga,3, 0, teams3.length-1);
	}
	

}

static void search(int a, int opt, int low, int high)
{	int i=0; int j=0;

	if(opt==1)
	{
		if(low==high)
		{
			if (teams1[low].points==a)
			i=low;
			{
				while((teams1[i].points==a)&&(i>=0)
					{
						if(i>0) i--;
					}
				
				while(teams1[i].points==a)
				{
					teams1[i].printTeam();

					if(i<(teams1.length-1))
					i++;
					else break;
				}
		

			
			}
			else System.out.println("\n No team found.");
			
			
		}

		else
		{
			int mid= (low + high)/2;
			if(teams1[mid].points>=a)
			search(a, opt, mid, high);
			else
			search(a, opt, low, mid);


		}
	}

	else if(opt==2)
	{
		if(low==high)
		{
			if (teams1[low].goalsFor==a)
			{
				while((teams1[Math.abs(low -i)].goalsFor==a)&&(!((low-i)<0)))
					{i++;}
				i=low-i;
				while(teams1[i].goalsFor==a)
				{
					teams1[i].printTeam();
					if(i<(teams1.length-1))
					i++;
					else break;
				}
		

			
			}
			else System.out.println("\n No team found.");
			
			
		}

		else
		{
			int mid= (low + high)/2;
			if(teams1[mid].goalsFor>=a)
			search(a, opt, mid, high);
			else
			search(a, opt, low, mid);


		}
	}
	else if(opt==3)
	{
		if(low==high)
		{
			if (teams1[low].goalsAgainst==a)
			{
				while((teams1[Math.abs(low -i)].goalsAgainst==a)&&(!((low-i)<0)))
					{i++;}
				i=low-i;
				while(teams1[i].goalsAgainst==a)
				{
					teams1[i].printTeam();
					if(i<(teams1.length-1))
					i++;
					else break;
				}
		

			
			}
			else System.out.println("\n No team found.");
			
			
		}

		else
		{
			int mid= (low + high)/2;
			if(teams1[mid].goalsAgainst>=a)
			search(a, opt, mid, high);
			else
			search(a, opt, low, mid);


		}
	}





}


static void searchRange()
{
int opt; int flag=0, r1, r2; int i=0;
	do
	{
	System.out.println("Please enter one of the options (1-3 ) to access different functions:");
	System.out.println("1. Search by points");
	System.out.println("2. Search by Goals For");
	System.out.println("3. Search by Goals Against");
	
	opt= stdIn.nextInt();
	if((opt>0)&&(opt<=3)) flag=1;
	else System.out.println("Invalid input try again");
	}while(flag==0);

		System.out.println("Enter the range min:");
		r1= stdIn.nextInt();
		System.out.println("Enter the range max:");
		r2= stdIn.nextInt();
		for(i=r1; i<=r2; i++)
		search(i,opt,0,teams1.length-1);
	
}

public static void sort(Team[] teams, int k)
{
    int i=0, j=0, l=0; int temp; Team t;
    if(k==1) /* Sort by points */
    {
     for(i=0; i<teams.length; i++)
     {
         for(j=0; j< i; j++)
         {
		if(k==1)
		{
             		if((teams[i].compare(teams[j]))>=0)
             		{
                 		t=teams[i];
                 		for(l=i-1; l>=j; l--)
                 		{
                     			teams[l+1]= teams[l];
                 		}
                		 teams[j]=t;

             		}
		}

		else if(k==2)
		{
             		if(teams[i].goalsFor >= teams[j].goalsFor)
             		{
                 		t=teams[i];
                 		for(l=i-1; l>=j; l--)
                 		{
                     			teams[l+1]= teams[l];
                 		}
                		 teams[j]=t;

             		}
		}
		else if(k==3)
		{
             		if(teams[i].goalsAgainst >= teams[j].goalsAgainst)
             		{
                 		t=teams[i];
                 		for(l=i-1; l>=j; l--)
                 		{
                     			teams[l+1]= teams[l];
                 		}
                		 teams[j]=t;

             		}
		}
	


         }
     }

    }

}




public static void initialize(Team[] teams)
{   Random rand= new Random();
    int i;
    for(i=0; i<teams.length; i++)
    {
        teams[i]= new Team();
        teams[i].points= rand.nextInt(teams.length);
        teams[i].goalsFor= rand.nextInt(5*teams.length);
        teams[i].goalsAgainst= rand.nextInt(5*teams.length);
    }
    System.out.println("Generating a random data for " + teams.length +
"number of teams");
    for(i=0; i<teams.length; i++)
    {
        teams[i].printTeam();
    }

}
        public static void main (String[] args)
        {
            int n, i;
            
            System.out.println("Please enter number of teams:");
            n= stdIn.nextInt();
		
            teams = new Team[n];
            initialize(teams);
		
            teams1 = new Team[n]; /* To sort by points */
            teams2 = new Team[n]; /* To sort by goalsFor */
            teams3 = new Team[n]; /* To sort by goalsAgainst */

            
            for(i=0; i<n; i++)
            {
                teams1[i]= teams[i];
            }
            sort(teams1, 1);
            

            for(i=0; i<n; i++)
            {
                teams2[i]= teams[i];
            }
            sort(teams2, 2);

            for(i=0; i<n; i++)
            {
                teams3[i]= teams[i];
            }
            sort(teams3, 3);

	options();


        }
}
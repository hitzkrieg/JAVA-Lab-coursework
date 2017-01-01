import java.math.*;
import java.util.Scanner;


class RunMe
{
    public static void main(String[] args)
    {
    Scanner stdIn= new Scanner(System.in);
    int N;
    
    System.out.println("Please enter the no of players: ");
    N= stdIn.nextInt();
    Game game= new Game(N);
    game.printWinner();
    
    
    
    }
}    

class Game
{
    int[] players;
    int N;
    int left;
    int[] tally ;
    
    Game(int N)
    {
        this.N= N;
        players= new int[N];
        for(int i=0; i<N; i++)
        {
            players[i]=1;
        }
        
        tally= new int[N];
        for(int i=0; i<N; i++)
        {
            tally[i]=0;
        }
        
        left= N;
        
    }
    
    void printWinner()
    {
        while(left!= 1)
        {
            play();
        }
        
        System.out.println("Final tally: ");
        tally();
        for(int i=0; i<N; i++)
        {
            if(players[i]== 1)
            {
                
                System.out.println("The winner is ****Player "+ (i+1)+ "****");
                
            }
        }
        
        
        
    }
    
    void tally()
    {
        for(int i=0; i<N; i++)
        {
            System.out.println("Player "+ (i+1) +": " + tally[i]);
        }
    }
    
    void play()
    {
        int player1= -1, player2= -1;
        boolean flag= false;
        while(flag== false)
        {
            int n= (int)((Math.random())*N);
            if(players[n]== 1)
            {
                flag= true;
                player1= n;
            }
        }
        flag = false;
        
        while((flag== false)&&(player2!= player1))
        {
            int n= (int)((Math.random())*N);
            if(players[n]== 1)
            {
                flag= true;
                player2= n;
            }
        }
        
        int win= winner(player1, player2);
        if (win==1)
        {
            players[player2]= 0;
            left--;
        }
        else
        {
            players[player1]= 0;
            left--;
        }
        
        
        
    }
    
    int winner(int player1, int player2)
    {
        int score1=0;
        int score2= 0;
        int dice1=0, dice2=0;
        for(int i= 1; i<=5; i++)
        {
            dice1= (int)((Math.random())*6)+1;
            dice2= (int)((Math.random())*6)+1;
            if(dice1== dice2)
            {
                score1++;
                score2++;
                tally[player1]++;
                tally[player2]++;
            }
            else if(dice1<dice2)
            {
                score1--;
                score2++;
                tally[player1]--;
                tally[player2]++;
                
            }
             else
            {
                score2--;
                score1++;
                tally[player2]--;
                tally[player1]++;
                
            }
            
        }
        if(score1== score2)
        {
            do
            {
                 dice1= (int)((Math.random())*6)+1;
            dice2= (int)((Math.random())*6)+1;
            if(dice1== dice2)
            {
                score1++;
                score2++;
                tally[player1]++;
                tally[player2]++;
            }
            else if(dice1<dice2)
            {
                score1--;
                score2++;
                tally[player1]--;
                tally[player2]++;
                
            }
             else
            {
                score2--;
                score1++;
                tally[player2]--;
                tally[player1]++;
                
            }
            
            }while(score1!= score2);
            
        }
        
        if(score1>score2)
        {
            return(1);
        }
        else
        {
            return(2);
        }
        
        
    }
            
        
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
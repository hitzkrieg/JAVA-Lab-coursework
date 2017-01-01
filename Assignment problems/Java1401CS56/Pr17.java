import java.util.Scanner;

public class Pr17
{
	public static void main( String[] args)
	{
		Scanner stdIn= new Scanner(System.in);
		String word;
		int i;
		String word1="";
		System.out.print("\n Please enter your full name:");
		word= stdIn.nextLine();
		for(i=0; i<word.length(); i++)
		{
			if((word.charAt(i)=='z')||(word.charAt(i)=='Z'))
			word1= word1+ (char)(word.charAt(i)-25);
			else if(word.charAt(i)==' ')
			word1= word1 + word.charAt(i);
			else word1= word1 + (char)(word.charAt(i)+1);
			
		}		
		
                
                System.out.println("Your Name: "+ word);
		System.out.println("Changed Name: "+ word1);
		
	

	}

}
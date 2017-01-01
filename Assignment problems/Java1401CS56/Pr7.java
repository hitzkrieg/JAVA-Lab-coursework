import java.util.Scanner;

public class Pr7
{
	public static void main( String[] args)
	{
		Scanner StdIn= new Scanner(System.in);
		String word;
		int i;
		String image="";
		System.out.print("\n Please enter a word to store its reverse:");
		word= StdIn.nextLine();
		for(i=0; i<word.length(); i++)
		{
			image= image+ word.charAt(word.length() -i-1);		
		}		


		
                
                System.out.println("Reverse of the word "  + word + " is " + image );
		
	

	}

}
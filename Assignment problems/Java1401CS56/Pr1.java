import java.util.Scanner;

public class Pr1
{
	public static void main( String[] args)
	{
		Scanner StdIn= new Scanner(System.in);
		String word;
		int i;
		String image="";
		System.out.print("\n Please enter a word to check if it is a Palindrome:");
		word= StdIn.nextLine();
		for(i=0; i<word.length(); i++)
		{
			image= image+ word.charAt(word.length() -i-1);		
		}		


		
                if(!image.equalsIgnoreCase(word))
                     System.out.println("\n Not a palindrome.");
		else System.out.println("\n Entered word is a palindrome");
	

	}

}
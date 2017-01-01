import java.util.Scanner;

class Pr3
{
	public static void main(String args[])
	{
		int i, vowels=0, spaces=0, spchar=0;
		Scanner StdIn = new Scanner(System.in);
		System.out.println("Please enter a line to analyse its characters:");
		String input= StdIn.nextLine();
		System.out.println("You entered: "+ input);
		for(i=0; i<input.length(); i++)
		{
			if((input.charAt(i)=='a')||(input.charAt(i)=='A')||(input.charAt(i)=='e')||(input.charAt(i)=='E')||(input.charAt(i)=='i')||(input.charAt(i)=='O')||(input.charAt(i)=='o')||(input.charAt(i)=='U')||(input.charAt(i)=='u'))
			vowels++;
			
			else if(input.charAt(i)==' ')
			spaces++;
			
			else if(!(((input.charAt(i)>='a')&&(input.charAt(i)<='z'))||((input.charAt(i)>='A')&&(input.charAt(i)<='Z'))||((input.charAt(i)>='0')&&(input.charAt(i)<='9'))))
                        spchar++;   
		}
		System.out.println("Vowels: " + vowels);
                System.out.println("Spaces: " + spaces);
                System.out.println("Special Characters: " + spchar);
	}
/* ||(input.charAt(i)>='0')&&(input.charAt(i)<='9'))*/

}
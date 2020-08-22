package studentCode;

import java.util.Scanner;

public class MultilingualGreetings {
	private static String greetingString;
	

	//CODE ABOVE HERE IS GIVEN TO YOU - DO NOT ALTER IT
	//YOUR CODE SHOULD USE THE ABOVE VARIABLE 

	
	
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		//YOUR CODE IN HERE - THE COMMENTS ARE THERE TO HELP GUIDE YOU
		
		//System.out.println( "Please choose one of the following languages");
		System.out.println ( "1) English   2) Espanol   3) Francais: ");
		
		int choice = myScanner.nextInt();
		
		//Ask what language they would like to use.
		
		switch (choice) {
		
		case 1:
			greetingString = "Hello World!";
			break;
			
		case 2:
			greetingString = "Hola Mundo!";
			break;
			
		case 3: 
			greetingString = "Bonjour le Monde!";
			break;
		default:
			greetingString = "###########";
		}

		
		//Based on the language selected above, set the greetingString 
		//  variable in that language.
		
		
		//YOUR CODE IN HERE
		
		
		
		//Now, we'll print out the greeting...
		System.out.println(greetingString);
		
		myScanner.close();
	}
}

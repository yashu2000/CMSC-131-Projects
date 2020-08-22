package studentCode;
import java.util.Scanner;


public class CryptoQuiz {
	//NOTE: You MUST use these named constants.  The submit server will
	//      fail you on the Task 4 tests if you do not use these named
	//      constants in your code but rather use the actual values.
	static int NUM_BITS1 = 80, NUM_BITS2 = 128, NUM_BITS3 = 168;
	static String CRYPT1 = "Skipjack", CRYPT2 = "Rijndael", CRYPT3 = "TripleDES";
		
		
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		
		//YOUR CODE IN HERE
		System.out.print( "Enter 1 to guess a cryptographic system, 2 to guess how many BITs: " + 
				"");   //asks for choice
		
		int choice = myScanner.nextInt();
		
		if (choice == 1) {  //condition for choice 1
			
			System.out.print( "Choose number of BITs: ");
			int response = myScanner.nextInt();
			//myScanner.nextLine();
			
			if ((response == NUM_BITS1) 
					|| (response == NUM_BITS2) 
					|| (response == NUM_BITS3)) {
				
				System.out.print( "Which cryptographic system uses " + response + " BITs? ");
				String answer = myScanner.next();
				
				if ( (response == NUM_BITS1 && answer.equals( CRYPT1)) 
						|| (response == NUM_BITS2 && answer.equals( CRYPT2))
						|| (response == NUM_BITS3 && answer.equals( CRYPT3))) {
					System.out.println( "Correct!");
				}
				else
					System.out.println( "Incorrect!");
			}
			else {
				System.out.println( "Invalid choice.");
			}
			
			
		}
		else if (choice == 2) {   //condition for choice 2
			
			System.out.print( "Choose a cryptographic system: ");
			String response1 = myScanner.next();
			
			if (response1.equals (CRYPT1) 
					|| response1.equals (CRYPT2) 
					|| response1.equals (CRYPT3)) {
				
				System.out.print( "How many BITs used in a " + response1 + " system? ");
				int choice1 = myScanner.nextInt();
				
				
				if ( (choice1 == NUM_BITS1 && response1.equals( CRYPT1)) 
						|| (choice1 == NUM_BITS2 && response1.equals( CRYPT2))
						|| (choice1 == NUM_BITS3 && response1.equals( CRYPT3))) {
					
					System.out.println( "Correct!");
				
					}
				else
					System.out.println( "Incorrect!");
				}
			else {
				System.out.println("Invalid choice.");
				}
		}
		
		
		
		
		else
			System.out.println( "Invalid choice.");
			
			

		
		//YOUR CODE IN HERE		
		
		
		myScanner.close();
	}
}

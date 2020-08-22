package studentCode;

import java.util.Scanner;

public class NextInteger {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Please enter an integer: ");
		int value;
		value = myScanner.nextInt();
		
		//YOUR CODE IN HERE
		
		System.out.println ("The next integer would be " + (value + 1) + ".");


		
		//YOUR CODE IN HERE
		

		myScanner.close();
	}
	
	
}

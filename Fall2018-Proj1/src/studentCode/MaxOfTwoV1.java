package studentCode;

import java.util.Scanner;

public class MaxOfTwoV1 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		
		//YOUR CODE IN HERE
		
		int first, second;
		//System.out.println( "Please enter the first number");
		first = myScanner.nextInt();
		
		//System.out.println ("Please enter the second number");
		second = myScanner.nextInt();
		
		if (first > second) {
			System.out.println(first + " is greater than " + second);
		}
		else if (second >= first)
			System.out.println( second + " is greater than or equal to " + first);
		
		//I tried to get extra points by adding the last else statement but I realised thats part of V2

		//YOUR CODE IN HERE
		
		
		myScanner.close();
	}
	
	
}

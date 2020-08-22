package exampleCode;

import java.util.Scanner;

public class SingleShift {

	public static char shiftPlusOne(char plain) {
		//Thinking of 'a' as the 0th letter, determine which letter we
		//  are going to be dealing with.
		int letterNumber = plain - 'a';
		//NOTE: For math on char items in Java, Java will convert the
		//      character to it's UNICODE numeric value and then do
		//      the math on that value.


		letterNumber++; //shift it over one position

		
		//We want to now go back to dealing with characters, so we
		//   have to compute the right UNICODE value and then "force"
		//   Java to treat that value as a char rather than a number
		//   using the (char) casting instruction.
		char retval = (char)('a' + letterNumber);

		
		//Return that character.
		return retval;

		
		//NOTE: This will always shift one over.  That means a
		//      becomes b, b becomes c, etc. but also means that
		//      z becomes { because that's the next character 
		//      in the UNICODE list.  
		//
		//      Consider what you might do if you only wanted the
		//      output to be within the a to z range and the input
		//      value shifted "too far" and what you really want is
		//      to wrap around to the front of the range of values.
	}


	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Type a single lower-case letter, then press return/enter: ");
		char plain = myScanner.next().charAt(0);

		System.out.println(plain + " became " + shiftPlusOne(plain));

		myScanner.close();


	}
}
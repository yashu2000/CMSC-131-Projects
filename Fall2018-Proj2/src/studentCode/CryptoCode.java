package studentCode;

import testingCode.SampleTests;

public class CryptoCode {
	//Handles ASCII/UNICODE 32 through ASCII/UNICODE 91
	static final char LEFT_BOUNDARY = ' ';
	static final char RIGHT_BOUNDARY = '[';

	static final int RANGE = RIGHT_BOUNDARY-LEFT_BOUNDARY+1;
	
	
	
	//YOUR CODE WILL BE DOWN HERE
	//AS YOU WORK ON EACH METHOD, DELETE THE "throw" LINE AND
	//   ADD YOUR CODE TO IMPLEMENT THE METHOD
	//TEST AS YOU GO TASK BY TASK
	
	public static boolean safeToUse(String plaintext) {
		
		String text = plaintext.toUpperCase();
		boolean truer = false;
		
		for (int i = 0; i<plaintext.length(); i++) {
			
			if (text.charAt(i) >= LEFT_BOUNDARY && text.charAt(i) <= RIGHT_BOUNDARY) {
				truer = true;
			}
			else {
				truer = false;
				break;
			}
				
		}
		
		return truer;
		
		//throw new RuntimeException("You need to design and implement this!");
		
		
	}
	
	//range between 32 to 91
	
	public static String rot30(String message)
	{	
		String m1 = message.toUpperCase();
		
		String replier = "";
		
		for (int i = 0; i < m1.length(); i++) {
			
			char y = m1.charAt(i);
			
			y+=30;
			if (y> RIGHT_BOUNDARY) {
				y = (char)(y - RANGE);
			}
			
			
			
			replier += y;
		}
		
		return replier;
		/*
		char [] arr = m1.toCharArray();   //converted to char array so we can influence element by element
		
		
		for (int i = arr.length -1; i>=0; i--) {
			
			//makes sure that all characters are within the range 32-91
				
				while ((int) arr[i] > 91) {
					
					arr[i] = (char) (arr[i] - 60);
				}
			
			
			// makes sure the value of character isnt above 91 when incremented
			if ((int)arr[i] + 30  > 91) {
				
				arr [i] = (char) (((arr[i] + 30) - 60));
			}
			
			
			
			// final value just increments by 30
			else {
				
				arr[i] = (char)(arr[i] + 30);
			}
		}
		
		
		String replier = "";        //When doing array .toString() it returns location of first element
		
		
		//enhanced for loop easier as we use an array
		for (char y: arr) {
			replier += y;		
			}
		
		return replier;
		*/
		//throw new RuntimeException("You need to design and implement this!");
	}

	//range between 32 to 91
	
	public static String toCaesar(String plaintext, int shift)
	{
		String m1 = plaintext.toUpperCase();
		//checks if shift inputed is within the range of 1-60
		if (shift > RANGE) {
			
			while (shift > RANGE) {
				
				shift -= RANGE;
			}
		}
		
		//converts to upper case
		//String mess = plaintext.toUpperCase();
		String replier = "";
		
		for (int i = 0; i < m1.length(); i++) {
			
			char y = m1.charAt(i);
			
			y+=shift;
			if (y> RIGHT_BOUNDARY) {
				y = (char)(y - RANGE);
			}
			
			
			
			replier += y;
		}
		
		return replier;
		/*
		char [] message = mess.toCharArray();
		
		
		for (int i = message.length - 1; i >=0; i--) {
			
			int char_val = message[i] + shift;  
			//char_val checks to see if we are beyond range when shifted
			
			
			if (char_val > 91) {
				
				char_val -= 92; 
				
				message[i] = (char) (32 + char_val);
			}
			else {
				message[i] = (char) (message[i] + shift);
			}
			
			
		}
		
		String replier = "";
		
		for (char y: message) {
			
			replier += y;
		}
		
		return replier;
		*/
		//throw new RuntimeException("You need to design and implement this!");
	}

	public static String fromCaesar(String ciphertext, int shift)
	{

		
		//checks if shift inputed is within the range of 1-60
		
			
			while (shift > RANGE) {
				
				shift -= RANGE;
			}
		
		
		//converts to upper case
		String mess = ciphertext.toUpperCase();
		
		String replier = "";
		
		for (int i = 0; i < mess.length(); i++) {
			
			char y = mess.charAt(i);
			int z = (int) y;
			z-=shift;
			
			while (z< 32) {
				
				z += 60;
			}
			
			replier += (char)z;
		}
		
		return replier;
		/*
		char [] message = mess.toCharArray();
		
		
		for (int i = message.length - 1; i >=0; i--) {
			
			int char_val = message[i] - shift;  
			//char_val checks to see if we are beyond range when shifted
			
			
			if (char_val < 32) {
				
				char_val += 60; 
				
				message[i] = (char) (char_val);
			}
			else {
				message[i] = (char) (message[i] + shift);
			}
			
			
		}
		
		String replier = "";
		
		for (char y: message) {
			
			replier += y;
		}
		
		return replier;
		
		*/
		//throw new RuntimeException("You need to design and implement this!");
	}
	
	//subtract by 60 when >91
	

	public static String toBellaso(String plaintext, String keyword){
		
		String replier = "";
		String m1 = plaintext.toUpperCase();
		keyword = keyword.toUpperCase();
		
		while (m1.length() > keyword.length()) {
			
			keyword = keyword + keyword;
		}
		
		for (int i = 0; i < m1.length(); i++) {
			
			char x = m1.charAt(i);
			char y = (char) (keyword.charAt(i) - LEFT_BOUNDARY);
			
			char val = (char) (x + y);
			
			if (val > RIGHT_BOUNDARY) {
				
				val = (char) (val - RANGE);
			}
			
			replier += val;
		}
		
		return replier;
		/*
		char [] text = plaintext.toUpperCase().toCharArray();
		char [] key = keyword.toUpperCase().toCharArray();
		
		for (int i = 0, j = 0; i < text.length; i++, j++) {
			
			if (j == key.length ) {
				j = 0;
			}
			
			if (text[i] + key [j] > 91) {
				key[j] -= 32;
				text [i] = (char)(text[i] + key[j]);
			}
			else {
				text[i] += key[j];
				text[i] = (char) text[i];
			}
		}
		
		String replier = "";
		
		for (char y: text) {
			replier += y;
		}
		
		return replier;
		//throw new RuntimeException("You need to design and implement this!");
		*/
	}

	public static String fromBellaso(String ciphertext, String keyword){
		
		
		String replier = "";
		String m1 = ciphertext.toUpperCase();
		keyword = keyword.toUpperCase();
		
		while (m1.length() > keyword.length()) {
			
			keyword = keyword + keyword;
		}
		
		for (int i = 0; i < m1.length(); i++) {
			
			char x = m1.charAt(i);
			char y = (char) (keyword.charAt(i));
			
			int shift = y - LEFT_BOUNDARY;
			/*
			char val = (char) (x - shift);
			
			if (val < LEFT_BOUNDARY) {
				
				val = (char) (val + RANGE);
			} */
			
			
			replier += fromCaesar ("" + x, shift);
		}
		
		return replier;
		
		/*
		char [] cipher = ciphertext.toUpperCase().toCharArray();
		char [] key = keyword.toUpperCase().toCharArray();
		
		for (int i = 0, j = 0; i < cipher.length; i++, j++) {
			
			if (j == key.length ) {
				j = 0;
			}
			
			if (cipher[i] - key [j] < 32) {
				
				key[j] -= 32;
				cipher [i] = (char)(cipher[i] - key[j]);
			}
			else {
				cipher[i] -= key[j];
				cipher[i] = (char) cipher[i];
			}
		}
		String n = "";
		for (char d: cipher) {
			n+=d;
		}
		
		return n;
		*/
		//throw new RuntimeException("You need to design and implement this!");
	}
	


}



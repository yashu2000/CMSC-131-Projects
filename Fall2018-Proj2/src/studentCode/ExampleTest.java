package studentCode;

public class ExampleTest {

	public static void main(String[] args) {
		//An example of how you might test out your code on more complex
		//  things without having to type things in over and over.
		String plaintext;
		String ciphertext;
		int shift;
		String myAnswer;
		
		
		plaintext = "ABCDE";
		
		if (CryptoCode.safeToUse(plaintext)) {
			System.out.println("Yay, it's a valid message to crypt!");
		}
		else {
			System.out.println("Ooops.");
		}
		
		
		
		plaintext = " !^_";
		ciphertext = ">?@A";
		myAnswer = CryptoCode.rot30(plaintext);
		if (myAnswer.equals(ciphertext)) {
			System.out.println("Whoo-hoo!  One test of rot32 working!");
		}
		else {
			System.out.println(
					"Uh-oh...  You got " + myAnswer + 
					", not " + ciphertext + " for it." 
			);
		}
		
		shift = 5;
		plaintext = "ABCDE";
		ciphertext = "FGHIJ";
		myAnswer = CryptoCode.toCaesar(plaintext, shift);
		
		if (myAnswer.equals(ciphertext)) {
			System.out.println("Yes, a shift test worked!");
		}
		else {
			System.out.println(
				"Should have been " + ciphertext +
				" but ended up being " + myAnswer
			); 
		}
		
		
	}
}

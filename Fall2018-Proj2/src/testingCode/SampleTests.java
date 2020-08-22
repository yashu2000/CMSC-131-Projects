package testingCode;
import static org.junit.Assert.*;

import org.junit.Test;


public class SampleTests  {

	@Test
	public void testIsItSafe() {
		assertTrue(studentCode.CryptoCode.safeToUse("CMSC131"));
	}
	
	@Test
	public void testRotate30() {
		String plaintext = "CMSC 131";
		String ciphertext = "%/5%>OQO";
		assertEquals(
			ciphertext,
			studentCode.CryptoCode.rot30(plaintext)
		);
	}
		
	@Test
	public void testCaesar() {
		String plaintext = "Computer Science";
		int shift = 131;
		String ciphertext = "NZX[$#P!+\"NTPYNP";

		assertEquals(
			ciphertext,
			studentCode.CryptoCode.toCaesar(plaintext, shift)
		);
		
		assertEquals (
				plaintext.toUpperCase(), studentCode.CryptoCode.fromCaesar(ciphertext, shift));
	}

	@Test
	public void testBellaso() {
		String plaintext = "Computer Science";
		String keyword = "CMSC131";
		String ciphertext = "*@D7*+V9MJ*ZX#*6";

		assertEquals(
			ciphertext,
			studentCode.CryptoCode.toBellaso(plaintext, keyword)
		);
		
		assertEquals (
				plaintext.toUpperCase(), studentCode.CryptoCode.fromBellaso(ciphertext, keyword));
	}
	
	
	
	





}

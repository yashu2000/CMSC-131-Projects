package p5_testing;
import static org.junit.Assert.*;

import org.junit.Test;

import p5_cubicpoly.CubicPoly;
import p5_utility.DoubleWithAppx;


public class YourTests {
	//Some example JUnit tests to get you started thinking about 
	//  writing your own JUnit tests.
	@Test
	public void testDefaultConstructor() {
		CubicPoly testCubicPoly = new CubicPoly();
		assertTrue(testCubicPoly.getA().isZero()
				&& testCubicPoly.getB().isZero()
				&& testCubicPoly.getC().isZero()
				&& testCubicPoly.getD().isZero());
	}
	
	
	@Test
	public void testSingleValConstructor() {
		DoubleWithAppx dVal = new DoubleWithAppx(27.8);
				
		CubicPoly testCubicPoly = new CubicPoly(dVal);
		assertTrue(testCubicPoly.getA().isZero()
				&& testCubicPoly.getB().isZero()
				&& testCubicPoly.getC().isZero()
				&& testCubicPoly.getD().equals(dVal));
	}

	
	@Test
	public void testTwoValConstructor() {
		DoubleWithAppx cVal = new DoubleWithAppx(23.2);
		DoubleWithAppx dVal = new DoubleWithAppx(-4.7);
				
		CubicPoly testCubicPoly = new CubicPoly(cVal, dVal);
		assertTrue(testCubicPoly.getA().isZero()
				&& testCubicPoly.getB().isZero()
				&& testCubicPoly.getC().equals(cVal)
				&& testCubicPoly.getD().equals(dVal));
	}

	
	@Test
	public void testThreeValConstructor() {
		DoubleWithAppx bVal = new DoubleWithAppx(15.7);
		DoubleWithAppx cVal = new DoubleWithAppx(-23.7);
		DoubleWithAppx dVal = new DoubleWithAppx(4.3);
				
		CubicPoly testCubicPoly = new CubicPoly(bVal, cVal, dVal);
		assertTrue(testCubicPoly.getA().isZero()
				&& testCubicPoly.getB().equals(bVal)
				&& testCubicPoly.getC().equals(cVal)
				&& testCubicPoly.getD().equals(dVal));
	}
	
	
	@Test
	public void testFourValConstructor() {
		DoubleWithAppx aVal = new DoubleWithAppx(43.1);
		DoubleWithAppx bVal = new DoubleWithAppx(15.7);
		DoubleWithAppx cVal = new DoubleWithAppx(-23.7);
		DoubleWithAppx dVal = new DoubleWithAppx(4.3);
				
		CubicPoly testCubicPoly = new CubicPoly(aVal, bVal, cVal, dVal);
		assertTrue(testCubicPoly.getA().equals(aVal)
				&& testCubicPoly.getB().equals(bVal)
				&& testCubicPoly.getC().equals(cVal)
				&& testCubicPoly.getD().equals(dVal));
	}
	
	
	

	@Test
	public void testCopyConstructor() {
		DoubleWithAppx aVal = new DoubleWithAppx(-19.2);
		DoubleWithAppx bVal = new DoubleWithAppx(24.2);
		DoubleWithAppx cVal = new DoubleWithAppx(-3.2);
		DoubleWithAppx dVal = new DoubleWithAppx(18.7);
		
		CubicPoly testCubicPoly = new CubicPoly(aVal, bVal, cVal, dVal);
		CubicPoly testCopyCubic = new CubicPoly(testCubicPoly);
		
		// Check to be sure they are not aliased!
		assertTrue(testCubicPoly != testCopyCubic);     
		
		assertTrue(testCubicPoly.getA().equals(testCopyCubic.getA())
				&& testCubicPoly.getB().equals(testCopyCubic.getB())
				&& testCubicPoly.getC().equals(testCopyCubic.getC())
				&& testCubicPoly.getD().equals(testCopyCubic.getD()));
		
		assertEquals(testCubicPoly, testCopyCubic);
	}
	
	
	@Test
	public void testGetters() {
		DoubleWithAppx one = new DoubleWithAppx(1.1);
		DoubleWithAppx two = new DoubleWithAppx(2.2);
		DoubleWithAppx three = new DoubleWithAppx(3.3);
		DoubleWithAppx four = new DoubleWithAppx(4.4);
		
		CubicPoly p = new CubicPoly(one, two, three, four);

		assertTrue(p.getA().equals(one));
		assertTrue(p.getB().equals(two));
		assertTrue(p.getC().equals(three));
		assertTrue(p.getD().equals(four));
	}
	

	@Test 
	public void testEval() {
		CubicPoly mc1 = new CubicPoly(
				new DoubleWithAppx(5),
				new DoubleWithAppx(-3),
				new DoubleWithAppx(2),
				new DoubleWithAppx(4)
			);
		
		assertEquals(new DoubleWithAppx(564), mc1.eval(new DoubleWithAppx(5)));
	}
	
	
	//YOU NEED TO IMPLEMENT AT LEAST THREE JUNIT TESTS BELOW
	@Test
	public void testAdd() {
		
		CubicPoly pol1 = new CubicPoly (
				new DoubleWithAppx (3),
				new DoubleWithAppx (5), 
				new DoubleWithAppx (8), 
				new DoubleWithAppx (-20));
		
		CubicPoly pol2 = new CubicPoly (
				new DoubleWithAppx (6),
				new DoubleWithAppx (7), 
				new DoubleWithAppx (-14), 
				new DoubleWithAppx (19));	
		
		CubicPoly pol3 = pol1.add(pol2);
		
		if (pol3.getA().compareTo(pol1.getA().add(pol2.getA())) == 0 &&
				pol3.getB().compareTo(pol1.getB().add(pol2.getB())) == 0 &&
				pol3.getC().compareTo(pol1.getC().add(pol2.getC())) == 0 && 
				pol3.getD().compareTo(pol1.getD().add(pol2.getD())) == 0) {
			
			assertTrue (true);
		}
		else
			fail();
			
	}

	@Test
	public void testSubtract() {
		
		CubicPoly pol1 = new CubicPoly (new DoubleWithAppx (6), new DoubleWithAppx (9), 
				new DoubleWithAppx (3)
				, new DoubleWithAppx (2));
		
		CubicPoly pol2 = new CubicPoly (new DoubleWithAppx (14), new DoubleWithAppx (5), 
				new DoubleWithAppx (3), new DoubleWithAppx (5));
		
		CubicPoly pol1MINUSpol2 = new CubicPoly (new DoubleWithAppx (-8), new DoubleWithAppx (4), 
				new DoubleWithAppx (0), new DoubleWithAppx (-3));
		
		assertTrue (pol1.subtract(pol2).equals(pol1MINUSpol2));
	}

	@Test
	public void testDeriv() {
		
		CubicPoly pol1 = new CubicPoly (new DoubleWithAppx (8), new DoubleWithAppx (5), 
				new DoubleWithAppx (9), new DoubleWithAppx (1000));
		
		CubicPoly der1 = new CubicPoly (new DoubleWithAppx (24), new DoubleWithAppx (10), 
				new DoubleWithAppx (9));
		
		CubicPoly pol2 = new CubicPoly (new DoubleWithAppx (30), new DoubleWithAppx (500), 
				new DoubleWithAppx (10000), new DoubleWithAppx (10000000));
		
		CubicPoly der2 = new CubicPoly (new DoubleWithAppx (90), new DoubleWithAppx (1000),
				new DoubleWithAppx (10000));
		
		assertTrue (pol1.deriv().equals (der1) && pol2.deriv().equals(der2));
	}

	@Test
	public void testCompareTo() {
		
		CubicPoly pol1 = new CubicPoly (new DoubleWithAppx (8), new DoubleWithAppx (5), 
				new DoubleWithAppx (9), new DoubleWithAppx (1000));
		
		CubicPoly comp1 = new CubicPoly (new DoubleWithAppx (8), new DoubleWithAppx (5), 
				new DoubleWithAppx (9), new DoubleWithAppx (1000));
		
		CubicPoly pol2 = new CubicPoly (new DoubleWithAppx (30), new DoubleWithAppx (500), 
				new DoubleWithAppx (10000), new DoubleWithAppx (10000000));
		
		assertTrue (pol1.compareTo(comp1) == 0 && pol1.compareTo(pol2) == -1);
	}
	
	@Test
	public void testMult () {
		
		CubicPoly pol1 = new CubicPoly (new DoubleWithAppx (5), new DoubleWithAppx (7));
		CubicPoly pol2 = new CubicPoly (new DoubleWithAppx (3));
		CubicPoly pol3 = new CubicPoly (new DoubleWithAppx (7), new DoubleWithAppx (9));
		
		CubicPoly pol1MULTpol2 = new CubicPoly (new DoubleWithAppx (15), new DoubleWithAppx (21));
		CubicPoly pol1MULTpol3 = new CubicPoly (new DoubleWithAppx (35), new DoubleWithAppx (94),
				new DoubleWithAppx (63));
		
		
		assertTrue (pol1.mult(pol2).equals(pol1MULTpol2) && pol1.mult(pol3).equals(pol1MULTpol3));
	}
	


	
}

package p5_cubicpoly;

import p5_utility.DoubleWithAppx;

/**
 * A general representation of a Cubic polynomial of the form:
 *     (a*x^3 + b*x^2 + c*x + d)
 * 
 * @author Yashaswi Sharma
 * @date October-November 2018
 */

public class CubicPoly {
	private final DoubleWithAppx a;
	private final DoubleWithAppx b;
	private final DoubleWithAppx c;
	private final DoubleWithAppx d;
	
	public CubicPoly() {
		a = new DoubleWithAppx (DoubleWithAppx.ZERO);
		b = new DoubleWithAppx (DoubleWithAppx.ZERO);
		c = new DoubleWithAppx (DoubleWithAppx.ZERO);
		d = new DoubleWithAppx (DoubleWithAppx.ZERO);
		
	}

	public CubicPoly(DoubleWithAppx dIn) {
		
		a = new DoubleWithAppx (DoubleWithAppx.ZERO);
		b = new DoubleWithAppx (DoubleWithAppx.ZERO);
		c = new DoubleWithAppx (DoubleWithAppx.ZERO);
		d = new DoubleWithAppx (dIn);
	}

	public CubicPoly(DoubleWithAppx cIn, DoubleWithAppx dIn) {
		
		a = new DoubleWithAppx (DoubleWithAppx.ZERO);
		b = new DoubleWithAppx (DoubleWithAppx.ZERO);
		c = new DoubleWithAppx (cIn);
		d = new DoubleWithAppx (dIn);
	}

	public CubicPoly(DoubleWithAppx bIn, DoubleWithAppx cIn, DoubleWithAppx dIn) {
		
		a = new DoubleWithAppx (DoubleWithAppx.ZERO);
		b = new DoubleWithAppx (bIn);
		c = new DoubleWithAppx (cIn);
		d = new DoubleWithAppx (dIn);
	}
	
	public CubicPoly(DoubleWithAppx aIn, DoubleWithAppx bIn, DoubleWithAppx cIn, DoubleWithAppx dIn) {
		
		a = new DoubleWithAppx (aIn);
		b = new DoubleWithAppx (bIn);
		c = new DoubleWithAppx (cIn);
		d = new DoubleWithAppx (dIn);
	}
	
	public CubicPoly(CubicPoly other) {
		
		a = new DoubleWithAppx (other.getA());
		b = new DoubleWithAppx (other.getB());
		c = new DoubleWithAppx (other.getC());
		d = new DoubleWithAppx (other.getD());
	}
	
	public DoubleWithAppx getA() {
		
		return a;
	}
	
	public DoubleWithAppx getB() {
		
		return b;
	}
	
	public DoubleWithAppx getC() {
		
		return c;
	}
	
	public DoubleWithAppx getD() {
		
		return d;
	}
	
	
	
	
	
	public DoubleWithAppx eval(DoubleWithAppx x) {
		
		DoubleWithAppx val1 = a.multiply(x.power(3));
		DoubleWithAppx val2 = b.multiply(x.power(2));
		DoubleWithAppx val3 = c.multiply (x.power(1));
		
		DoubleWithAppx returner = val1.add(val2.add(val3.add(d)));
		
		return returner;
		//HINT: Think about how to chain method calls to make this compact. 
	}
	
	
	public CubicPoly add(CubicPoly cubicPolyIn) {
		
		DoubleWithAppx newa = this.a.add(cubicPolyIn.a);
		DoubleWithAppx newb = this.b.add(cubicPolyIn.b);
		DoubleWithAppx newc = this.c.add(cubicPolyIn.c);
		DoubleWithAppx newd = this.d.add(cubicPolyIn.d);
		
		return new CubicPoly (newa, newb, newc, newd);
		
		//throw new RuntimeException("You need to implement this!");
	}

	public CubicPoly subtract(CubicPoly cubicPolyIn) {
		
		DoubleWithAppx newa = this.a.subtract(cubicPolyIn.a);
		DoubleWithAppx newb = this.b.subtract(cubicPolyIn.b);
		DoubleWithAppx newc = this.c.subtract(cubicPolyIn.c);
		DoubleWithAppx newd = this.d.subtract(cubicPolyIn.d);
		
		return new CubicPoly (newa, newb, newc, newd);
		
		
		//throw new RuntimeException("You need to implement this!");
	}


	//does this "order" term mean that take out x^6 and x^5 etc??
	public CubicPoly mult(CubicPoly cubicPolyIn) {
		
		//switched this around prbs shudnt result in err
		DoubleWithAppx ae = this.a.multiply(cubicPolyIn.a);
		
		DoubleWithAppx afPLUSbe = this.a.multiply(cubicPolyIn.b).add(this.b.multiply(cubicPolyIn.a));
		
		DoubleWithAppx agPLUSbfPLUSce = this.a.multiply(cubicPolyIn.c).add(
				this.b.multiply(cubicPolyIn.b).add(
				this.c.multiply(cubicPolyIn.a)));
		
		//is this correct to use .isZero
		
		if (ae.isZero() && afPLUSbe.isZero() && agPLUSbfPLUSce.isZero()) {
			
			DoubleWithAppx newa = this.a.multiply(cubicPolyIn.d).add(
					this.b.multiply(cubicPolyIn.c).add(
					this.c.multiply (cubicPolyIn.b).add(
							this.d.multiply(cubicPolyIn.a))));

			DoubleWithAppx newb = this.b.multiply(cubicPolyIn.d).add(
					this.c.multiply (cubicPolyIn.c).add(
					this.d.multiply(cubicPolyIn.b)));

			DoubleWithAppx newc = this.c.multiply(cubicPolyIn.d).add(
					this.d.multiply(cubicPolyIn.c));

			DoubleWithAppx newd = this.d.multiply(cubicPolyIn.d);
			
			


			return new CubicPoly (newa, newb, newc, newd);
		}
		else {
			
			return null;
		}
	}

	
	
	
	public CubicPoly deriv() {
		
		DoubleWithAppx der1 = new DoubleWithAppx (3.0);
		DoubleWithAppx der2 = new DoubleWithAppx (2.0);
		DoubleWithAppx der3 = new DoubleWithAppx (1.0);
		
		return new CubicPoly (this.a.multiply (der1), this.b.multiply (der2), this.c.multiply(der3));
		//throw new RuntimeException("You need to implement this!");
	}


	
	public int compareTo(CubicPoly cubicPolyIn) {
		
		//declared earlier for operational efficiency, CPU doesn't have to execute methods everytime
		int compA = this.a.compareTo(cubicPolyIn.a);
		int compB = this.b.compareTo(cubicPolyIn.b);
		int compC = this.c.compareTo(cubicPolyIn.c);
		int compD = this.d.compareTo(cubicPolyIn.d);
		
		if (compA == 0 && compB ==0 && compC ==0 && compD ==0) {
			
			return 0;
		}
		else {
			
			if (compA != 0) {
				return compA;
			}
			else if (compB != 0) {
				
				return compB;
			}
			else if (compC != 0) {
				
				return compC;
			}
			else {
				return compD;
			}
			
		}
		//throw new RuntimeException("You need to implement this!");
	}

	
	
	//Challenge Problem
    public String toString() { 
    	return "a:"+a+", b:"+b+", c:"+c+", d:"+d;
		//You only need to implement this for a challenge.
    } 
	

	
    
    
    
    
    
    
	
	
	
	
	//NOTE: THIS JAVA EQUALS METHOD IS WRITTEN FOR YOU - DO NOT CHANGE
	@Override
	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			CubicPoly casted = (CubicPoly)other;
			return (
					a.equals(casted.a) && 
					b.equals(casted.b) && 
					c.equals(casted.c) && 
					d.equals(casted.d)
			);
		}
	}
	
	
}
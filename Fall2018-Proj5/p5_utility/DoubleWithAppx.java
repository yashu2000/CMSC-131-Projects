package p5_utility;
/**
 * IMPORTANT:  THIS CLASS HAS BEEN WRITTEN FOR YOU.  DO NOT MODIFY IT!
 * 
 * DoubleWithAppx objects represent floating point values.
 * The DoubleWithAppx is immutable.
 * 
 * @author Fawzi Emad & Jan Plane & Ben Bederson 
 *         & Evan Golub (changed things like equals, pow, root)
 */
public class DoubleWithAppx {	
	private double doubleValue;
	private final static double EPSILON = .0001;
	
	/* We don't want students calling toString anywhere except while writing
	 * their own polynomial toString method.
	 */
	@SuppressWarnings("unused")
	private static boolean toStringUsed = false;  // set to true in toString.  
								//JUnit tests will make use of this to
	                            // cause failures if student is 
	                            // illegally using toString

	/**
	 * A readily available zero value of type DoubleWithAppx
	 */
	public static DoubleWithAppx ZERO = new DoubleWithAppx(0);
	
	/**
	 * Returns a new DoubleWithAppx initialized to the value represented by the 
	 * specified String, as performed by the valueOf method of class Double. 
	 * @param str - the string to be parsed
	 * @return the DoubleWithAppx value represented by the string argument. 
	 * @throws NumberFormatException - if the string does not contain a parsable 
	 *            DoubleWithAppx.
	 */
	public static DoubleWithAppx parseDouble(String str) {
		return new DoubleWithAppx(Double.parseDouble(str));
	}
	
	/**
	 * Initializes the new DoubleWithAppx object so that it represents the value of 
	 * the parameter.
	 * @param passedDouble value to be "wrapped" in the object
	 */
	public DoubleWithAppx(double passedDouble) {
		this.doubleValue = passedDouble;
	}
	
	/**
	 * Copy Constructor.  Initializes the new DoubleWithAppx object so that it 
	 * represents the same value as that of the parameter. 
	 * @param passedMyDouble existing DoubleWithAppx object that is being copied
	 */
	public DoubleWithAppx(DoubleWithAppx passedMyDouble) {
		doubleValue = passedMyDouble.doubleValue;
	}
	
	/**
	 * Returns the sum of the current object and the parameter.
	 * Note:  This method does not modify the current object.
	 * @param passedVal the value that serves as the second operand for the addition
	 * @return a DoubleWithAppx object that represents the sum of the current 
	 *         object and the parameter
	 */
	public DoubleWithAppx add(DoubleWithAppx passedVal) {
		return new DoubleWithAppx(this.doubleValue + passedVal.doubleValue);
	}
	
	/**
	 * Returns the difference obtained by subtracting the parameter from the 
	 * current object.
	 * Note:  This method does not modify the current object.
	 * @param passedVal the value to be subtracted
	 * @return a DoubleWithAppx object that represents the current object minus
	 * the parameter
	 */
	public DoubleWithAppx subtract(DoubleWithAppx passedVal) {
		return new DoubleWithAppx(this.doubleValue - passedVal.doubleValue);
	}
	
	/**
	 * Returns the product of the current object and the parameter.
	 * Note:  This method does not modify the current object.
	 * @param passedVal the value that serves as the second operand for the 
	 *        multiplication
	 * @return the product of the current object and the parameter
	 */
	public DoubleWithAppx multiply(DoubleWithAppx passedVal) {
		return new DoubleWithAppx(this.doubleValue * passedVal.doubleValue);
		
	}
	
	/**
	 * Returns the quotient obtained when dividing the current object by the 
	 * parameter.
	 * Note:  This method does not modify the current object. 
	 * @param passedVal the value that serves as the divisor
	 * @return the result of dividing the current object by the parameter
	 */
	public DoubleWithAppx divide(DoubleWithAppx passedVal) {
		return new DoubleWithAppx(this.doubleValue / passedVal.doubleValue);
	}
	
	/**
	 * Returns a DoubleWithAppx representing the root of the current 
	 * object based on the parameter.
	 * Note:  This method does not modify the current object.
	 * @return the root of the current object based on the parameter.
	 */
	public DoubleWithAppx realroot(int degree) {
		return new DoubleWithAppx(Math.pow(doubleValue, 1.0/degree));
	}
	
	/**
	 * Returns a DoubleWithAppx representing the current object's
	 * value raised to the indicated power.
	 * Note:  This method does not modify the current object.
	 * @return the specified power of the current object
	 */
	public DoubleWithAppx power(int exp) {
		return new DoubleWithAppx(Math.pow(doubleValue,exp));
	}

	/**
	 * Compares the current object to the parameter.
	 * @param passedVal the object being compared with the current object
	 * @return -1 if the current object is less than the parameter,
	 * zero if the current object equals the parameter, +1 if the 
	 * current object is larger than the parameter.  NOTE:  Due to the lack
	 * of precision in comparing floating point values, in cases where the two
	 * values are NEARLY equal, this method will return 0.
	 */
	public int compareTo(DoubleWithAppx passedVal) {
		if (Math.abs(this.doubleValue - passedVal.doubleValue) < EPSILON)
			return 0;
		else if (this.doubleValue < passedVal.doubleValue)
			return -1;
		else
			return 1;
	}
	
	/**
	 * Checks if the current object is equal to the parameter.  
	 * 
	 * @param passedVal the object being compared for equality with the current 
	 *        object
	 * @return true if the current object is equal to the parameter, false
	 *         otherwise.  NOTE:  Due to the lack of precision in comparing 
	 *         floating point values, in cases where the two values are NEARLY 
	 *         equal, this method will return true.
	 */
	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			DoubleWithAppx casted = (DoubleWithAppx)other;
			return Math.abs(this.doubleValue - casted.doubleValue) < EPSILON;
		}
	}

	
	/**
	 * Checks if the current object is equal to 0. 
	 * @return true if the current object is equal to 0, false
	 * otherwise.  NOTE:  Due to the lack
	 * of precision in comparing floating point values, in cases where the
	 * value is NEARLY 0, this method will return true.
	 */
	public boolean isZero() {
		return (Math.abs(this.doubleValue) < EPSILON);
	}
	
	/**
	 * Returns the absolute value of the current object.
	 * @return a DoubleWithAppx representing the absolute value of the current object.
	 */
	public DoubleWithAppx abs() {
		return new DoubleWithAppx(Math.abs(this.doubleValue));
	}

	
	
	/**
	 * YOU MAY NOT CALL THIS METHOD EXCEPT WHILE YOU ARE IMPLEMENTING
	 * THE toString METHOD OF THE CubicPoly CLASS!!
	 * 
	 * Returns a String representation of the current object.
	 * If the fractional part of the string is 0, then it is converted in 
	 * integer format.
	 *    eg: the number 23.7 is converted to the string "23.7",
	 *        but the number 23.0 is converted to the string "23"
	 */
	public String toString() {
		toStringUsed = true;
		if (((int)this.doubleValue) == this.doubleValue) {
			return new Integer((int)this.doubleValue).toString();
		} else {
			return new Double(this.doubleValue).toString();
		}
	}

}
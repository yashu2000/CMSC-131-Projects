package studentCode;


/** 
 * A mutable class that represents a Website item that might be subject
 * to critique in our game.  As such, it implements the Critiqueable interface.
 * <br><br>
 * A Website object has a title (String) and a number of fans (int) as well as 
 * an internal hype level (int) that will be used as part of the item's overall 
 * "Media Hype" computation, and an internal counter for how many victories it 
 * has had (int) since the last time internal hype level increased.
 */
public class Website implements Critiqueable {
	
	private String title;
	private int numberOfFans;
	private int hype;
	private int winsSinceHypeBump;

	/**
	 * Standard constructor.  
	 * 
	 * @param titleIn desired title for this Website
	 * @param numberOfFansIn starting number of fans for this Website
	 */
	public Website(String titleIn, int numberOfFansIn) {
		
		title = titleIn;
		numberOfFans = numberOfFansIn;
		hype = 0;
		winsSinceHypeBump = 0;
	}

	
	/**
	 * Copy constructor.  
	 * 
	 * @param other reference to the existing object which is the basis of the new one
	 */
	public Website(Website other) {
		
		title = other.title;
		numberOfFans = other.numberOfFans;
		hype = other.hype;
		winsSinceHypeBump = other.winsSinceHypeBump;
	}
	
	
	/**
	 * Getter for the media hype of the Website, which is based on the
	 * first character of its title and the internal hype it has.
	 * Specifically, the UNICODE value of the first character in its name
	 * taken %8 plus the internal hype level.
	 * 
	 * @return media hype level of the Website
	 */
	@Override
	public int getMediaHype() {
		
		char character1 = title.charAt(0);
		int val = (int) character1;
		
		val %= 8;
		
		return hype + val;
	}
	
	
	/**
	 * Getter for name of the Website.
	 * 
	 * @return reference to the title of the Website
	 */
	@Override
	public String getTitle() {
		
		return title;
	}


	
	/**
	 * Getter for the number of fans of the Website.
	 * 
	 * @return number of fans of the Website
	 */
	@Override
	public int getFans() {
		
		return numberOfFans;
	}

	
	/**
	 * Setter for the number of fans of the Website.
	 * @param newNumberOfFans the new number of fans value for the Website
	 */
	@Override
	public void setFans(int newNumberOfFans) {
		
		numberOfFans = newNumberOfFans;
	}

	
	
	/**
	 * This method is sent the "outcome" of a critique "battle" that takes place in
	 * the game being written by our theoretical other GUI team.  There are several
	 * possible Outcomes defined in the Universe.  Based on that outcome, this method
	 * need to increment internal hype level if and only if the number of critique 
	 * victories since the last time the internal hype was increased has reached the 
	 * Universe's THRESHOLD.  A critique victory is defined as an outcome of FRESH.
	 *    
	 * However, it sets the numberOfFans to 0 if the outcome was a loss
	 *   
	 * A critique victory is defined as an outcome of FRESH.
	 * A critique lose is defined as an outcome of ROTTEN.  
	 *   
	 *  
	 * @param outcome the outcome of the critique in which this Website was involved
	 * @return true if the outcome conveyed caused the internal hype level to go up
	 */
	@Override
	public boolean inform(Universe.Outcomes outcome) {
		
		if (outcome == Universe.Outcomes.FRESH) {
			
			winsSinceHypeBump++;
			
			if (winsSinceHypeBump == Universe.THRESHOLD) {
				
				winsSinceHypeBump = 0;
				hype++;
				return true;
			}
			
		}
		else if (outcome == Universe.Outcomes.ROTTEN) {
			
			numberOfFans = 0;
		}
		
		return false;
	}

	
	
	
	/**
	 * Method to create an independent copy of the Website.
	 * @return independent copy of the Website
	 */
	@Override
	public Critiqueable returnClone() {
		
		Website copy = new Website (title, numberOfFans);
		copy.hype = hype;
		copy.winsSinceHypeBump = winsSinceHypeBump;
		
		return copy;
	}
	
	
	/**
	 * The "usual suspect" toString method.
	 * @return a String describing the Website
	 */
	@Override
	public String toString() {
		return "Website<Title: " + getTitle() + 
				"  Fans: " + getFans() +
				"  Hype: " + getMediaHype() +
				">";
	}
	
	
	
	/**
	 * The "usual suspect" equals method.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			Website casted = (Website)other;
			return 
					this.getTitle().equals(casted.getTitle()) 
					&& 
					this.getFans() == casted.getFans() 
					&& 
					this.getMediaHype() == casted.getMediaHype();
		}
	}
	
}

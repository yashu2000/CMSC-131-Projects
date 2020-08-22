package studentCode;


/** 
 * A mutable class that represents a Movie item that might be subject
 * to critique in our game.  As such, it implements the Critiqueable interface.
 * <br><br>
 * A Movie object has a title (String) and a number of fans (int) as well as 
 * an internal hype level (int) that will be used as part of the item's overall 
 * "Media Hype" computation, and an internal counter for how many victories it 
 * has had (int) since the last time internal hype level increased.
 */
public class Movie implements Critiqueable {
	
	private String title;
	private int numberOfFans;
	private int hype;
	private int winsSinceHypeBump;

	/**
	 * Standard constructor.  
	 * 
	 * @param titleIn desired title for this Movie
	 * @param numberOfFansIn starting number of fans for this Movie
	 */
	public Movie(String titleIn, int numberOfFansIn) {
		
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
	public Movie(Movie other) {
		
		title = other.title;
		numberOfFans = other.numberOfFans;
		hype = other.hype;
		winsSinceHypeBump = other.winsSinceHypeBump;
		
	}
	
	
	/**
	 * Getter for media hype of the Movie, which is always 7 more than
	 * the internal hype level.
	 * 
	 * @return hype level of the Movie
	 */
	@Override
	public int getMediaHype() {
		
		return hype + 7;
	}
	
	
	/**
	 * Getter for name of the Movie.
	 * 
	 * @return reference to the title of the Movie
	 */
	@Override
	public String getTitle() {
		
		return title;
		
	}


	
	/**
	 * Getter for the number of fans of the Movie.
	 * 
	 * @return number of fans of the Movie
	 */
	@Override
	public int getFans() {
		
		return numberOfFans;
	}

	
	/**
	 * Setter for the number of fans of the Movie.
	 * @param newNumberOfFans the new number of fans value for the Movie
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
	 * @param outcome the outcome of the critique in which this Movie was involved
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
		
		return false;
		
	}

	
	
	
	/**
	 * Method to create an independent copy of the Movie.
	 * @return independent copy of the Movie
	 */
	@Override
	public Critiqueable returnClone() {
		
		Movie copy = new Movie (title, numberOfFans);
		copy.hype = hype;
		copy.winsSinceHypeBump = winsSinceHypeBump;
		
		return copy;
	}
	
	
	/**
	 * The "usual suspect" toString method.
	 * @return a String describing the Movie
	 */
	@Override
	public String toString() {
		return "Movie<Title: " + getTitle() + 
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
			Movie casted = (Movie)other;
			return 
					this.getTitle().equals(casted.getTitle()) 
					&& 
					this.getFans() == casted.getFans() 
					&& 
					this.getMediaHype() == casted.getMediaHype();
		}
	}
	
}

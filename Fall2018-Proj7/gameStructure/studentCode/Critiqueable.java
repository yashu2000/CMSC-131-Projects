package studentCode;


/**
 * Objects that implement this interface can be put into a CritiqueDeck.
 */
public interface Critiqueable {
		
	/**
	 * Getter for the title of the item.
	 * @return title of the item
	 */
	public String getTitle();
	
	
	/**
	 * Getter for the amount of media hype the item has .
	 * @return amount of media hype of the item
	 */
	public int getMediaHype();
	
	
	
	/**
	 * Getter for the number of fans the item currently has.
	 * @return number of fans the item currently has
	 */
	public int getFans();
	
	
	
	/**
	 * Setter for the number of fans the item currently has.
	 * @param newFanCount the number of fans the item currently has
	 */
	public void setFans(int newFanCount);
	
	
	
	/**
	 * Method to create an independent copy of the item.
	 * @return independent copy of the item
	 */
	public Critiqueable returnClone();
	
	
	
	/**
	 * Method that takes the outcome of a critique and increments the media hype
	 *   ratings by 1 if the number of critique wins has passed the threshold.
	 * @param outcome the outcome of the critique in which this item was involved
	 * @return true if the outcome conveyed caused the media hype value to go up
	 */
	public boolean inform(Universe.Outcomes outcome);
	
	
	
	/**
	 * String generator for the item.
	 * @return String representing the item
	 */
	public String toString();
	
	

}

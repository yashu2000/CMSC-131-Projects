package studentCode;

import java.util.ArrayList;


/** 
 * A data structure class that stores deep copies of any Critiqueable items 
 * that are sent to be critiqued.  By having deep copies, the player's
 * Critiqueable item does not get permanently altered in their personal 
 * library, only in this playing of the game.
 * <br><br>
 * A CardsAgainstCriticsDeck object has a list of Critiqueable items
 * held in an ArrayList object.  It cannot be used to hold anything that
 * doesn't implement the Critiqueable interface.
 */
public class CardsAgainstCriticsDeck<T extends Critiqueable> {
	private ArrayList<Critiqueable> arr;
	boolean addchecker = false;
	//You might add private fields up here for one or two things...
	


	/**
	 * Standard constructor.  It needs to initialize the ArrayList object 
	 * and do any other setup that you deem necessary for this class object.
	 */
	public CardsAgainstCriticsDeck() {
		
		arr = new ArrayList<Critiqueable>();
	}

	
	
	/**
	 * Adds an item to the CardsAgainstCriticsDeck in a very special way.  
	 * The structure is double-ended; this means that the "side" to which
	 * objects are added alternates with every other item added.  If things
	 * are added in the order 1,2,3,4,5 then the CardsAgainstCriticsDeck 
	 * would grow as the following:<br>
	 * &nbsp;&nbsp;&nbsp;1<br>
	 * &nbsp;&nbsp;&nbsp;2,1<br>
	 * &nbsp;&nbsp;&nbsp;2,1,3<br>
	 * &nbsp;&nbsp;&nbsp;4,2,1,3<br>
	 * &nbsp;&nbsp;&nbsp;4,2,1,3,5<br>
	 * It is your job to determine a good way to ensure this alternation.
	 * 
	 * You can add an instance field to the class if needed in making this
	 * method work correctly.
	 * 
	 * @param newItem refers to a Critiqueable item to be added to this CardsAgainstCriticsDeck
	 */
	public void add(T newItem) {
		
		
		if (addchecker == false) {
			
			arr.add(newItem);
			addchecker = true;
		}
		else {
			
			arr.add(0, newItem);
			addchecker = false;
		}
	}

	
	
	/**
	 * Goes through each item in the CardsAgainstCriticsDeck and adds the 
	 * specified number of fans to every Critiqueable item it contains.
	 * 
	 * @param fanGain the value to add to the number of fans
	 */
	public void freshenUp(int fanGain) {
		
		for (int i = 0; i < arr.size(); i++) {
			
			int fano = arr.get(i).getFans() + fanGain;
			
			arr.get(i).setFans(fano);
		}
	}
	
	/**
	 * Goes through each item in the CardsAgainstCriticsDeck and deducts the 
	 * specified number of fans from every Critiqueable item it contains.
	 * 
	 * @param fanLoss the value to deduct from the number of fans
	 */
	public void rottenDown(int fanLoss) {
		
		for (int i = 0; i < arr.size(); i++) {
			
			int fano = arr.get(i).getFans() - fanLoss;
			
			arr.get(i).setFans(fano);
		}
	}
	
	//individually created method
	public void rottenDownI (int index, int fanloss) {
		
		int fano = arr.get(index).getFans() - fanloss;
		
		arr.get(index).setFans(fano);
	}
	
	/**
	 * Removes any Critiqueable item currently in the critique deck that have
	 * fewer than two fans left.
	 */
	public void sweepDeck() {
		
		for (int i = arr.size() - 1; i >= 0; i--) {
			
			if (arr.get(i).getFans() < 2) {
				
				arr.remove(i);
			}
		}
	}
	
	
	
	/**
	 * Shuffles the contents of the deck in the way described here. 
	 * The deck will be divided into two "packets" (we will call them 
	 * the top half and the bottom half).  
	 * 
	 * The shuffled CardsAgainstCriticsDeck will consist of 
	 *    the first card from the bottom packet, 
	 *    followed by the first card from the top packet, 
	 *    followed by the second card from the bottom packet, 
	 *    followed by the second card from the top packet, etc. 
	 * 
	 * Important: If there are an odd number of cards, the bottom packet 
	 * should have one more card than the top packet and as a special situation
	 * that last card in the bottom packet should be made the first card in the
	 * shuffled deck.
	 * 
	 * Remember that the top of the deck is considered to be the front 
	 * of the ArrayList. 
	 * 
	 */
	
	//not working 
	public void shuffle() {
		
		int size = arr.size();
		ArrayList<Critiqueable> newarr = new ArrayList<Critiqueable> ();
		
		for (int i = 0, j = size/2; i < size/2 && j < size; i++, j++) {
			
			newarr.add(arr.get(j));
			newarr.add(arr.get(i));
		}
		
		if (size % 2 == 1) {
			
			newarr.add(0, arr.get(arr.size() - 1));
		}
		arr = newarr;
		/*
		ArrayList<Critiqueable> newarr = new ArrayList<Critiqueable> ();
		ArrayList<Critiqueable> beginarr = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> endarr = new ArrayList<Critiqueable>();
		
		int arrsize = arr.size();
		
		for (int i = 0; i < arrsize/2; i++) {
			
			beginarr.add(arr.get(i));
		}
		for (int j = arrsize/2; j < arrsize; j++) {
			
			endarr.add(arr.get(j));
		}
		
		if (arrsize % 2 == 1) {
			
			for (int i = 0; i < beginarr.size(); i++) {
				
				newarr.add(beginarr.get(i));
				newarr.add(endarr.get(i));
			}
			
			newarr.add(endarr.get(endarr.size()-1));
		}
		else {
			
			for (int i = 0; i < beginarr.size(); i++) {
				
				newarr.add(beginarr.get(i));
				newarr.add(endarr.get(i));
			}
		}
		
		arr = newarr;
		*/
	}
	
	/**
	 * The method is meant to allow the next two Critiqueable items to be critiqued
	 * against each other, and for the winner to be returned.
	 * <br><br>
	 * If there are no Critiqueable items in the structure, returns null.<br>
	 * If there is only one Critiqueable item in the structure, it is removed
	 * and declared the winner<br>
	 * Otherwise, there is a series of events that takes place.
	 * The following presents the events and the order in which 
	 * the events must take place:<br>
	 * 1. One Critiqueable item is removed from each end of the structure
	 *       and they will later be critiqued.<br>
	 * 2. All Critiqueable items remaining in the CardsAgainstCriticsDeck have their fan
	 *       counts reduced by the following rules:<br>
	 *         * If they have media hype of more than 100, they lose 10 fans.<br>
	 *         * Otherwise, if they have media hype of more than 50, they lose 5 fans.<br>
	 *         * Otherwise, they lose 1 fan.<br>
	 * 3. The CardsAgainstCriticsDeck is cleared of any Critiqueable items who no longer
	 *       have enough fans to stay in the game.<br>
	 * 4. Use the freshenUp method to make it so that each Critiqueable item still in 
	 *       the CardsAgainstCriticsDeck gets one new fan. <br>
	 * 5. The winner in solitaire critiques between the two Critiqueable items removed
	 *    in the first step above are determined in by two-step process; 
	 *       (a) if they have different media hype values, the one with the higher 
	 *           value wins but if they have the same media hype values then 
	 *       (b) the one with the larger number of fans wins.  
	 *    If they have the same media hype values and the same number of fans, then 
	 *    whichever of the two Critiqueable items came from the front of the deck wins.
	 * <br><br>
	 * NOTE: The @SuppressWarnings("unchecked") indicator is to inform
	 * the compiler that even though we don't test to make sure the cast
	 * to T is valid, we are sure of our logic.
	 * 
	 * @return reference to the winning Critiqueable item
	 */
	
	//created new method rottenDownI to use in the else statement triggers
	@SuppressWarnings("unchecked")
	public T solitaireCritique() {
		
		if (arr.size() == 0) {
			
			return null;
		}
		else if (arr.size() == 1) {
			
			T returner = (T) arr.get(0);
			arr.remove(0);
			
			return returner;
		}
		else {
			
			T first = (T) arr.get(0);
			T last = (T) arr.get(arr.size() - 1);
			
			arr.remove(0);
			arr.remove(arr.size()-1);
			
			for (int i = 0; i < arr.size(); i++) {
				
				if (arr.get(i).getMediaHype() > 100) {
					
					rottenDownI (i, 10);
				}
				else if (arr.get(i).getMediaHype() > 50) {
					
					rottenDownI (i, 5);
				}
				else {
					
					rottenDownI (i, 1);
				}
			}
			
			sweepDeck();
			freshenUp (1);
			
			if (first.getMediaHype() > last.getMediaHype()) {
				
				return first;
			}
			else if (first.getMediaHype() < last.getMediaHype()) {
				
				return last;
			}
			else {
				
				if (first.getFans() > last.getFans()) {
					
					return first;
				}
				else if (first.getFans() < last.getFans()) {
					
					return last;
				}
				else {
					
					return first;
				}
					
			}
		}
	}
	
	
	
	
	/**
	 * The method will return a ragged 2D structure using the Java array.
	 * It will have references to deep copies of the Critiqueable items 
	 * currently stored in the CardsAgainstCriticsDeck.  
	 * 
	 * The 2D structure will have one row for each single-digit media hype
	 *  value (0 through 9) and then a row for all with higher media
	 *  values.  The items with negative media hype will go into the "0" row.
	 *  
	 * Within each row the order will be based on the "front to back" order 
	 * of them in the deck's single-dimensional structure.
	 * 
	 * NOTE: To build the ragged 2D structure, you'll need to read
	 * through the list of Critiqueable items once to determine how big each 
	 * row will need to be and then another time to populate the 
	 * ragged structure with the references to the copies of the 
	 * Critiqueable items.
	 * 
	 * @return reference to a ragged 2D structure using the java array
	 */
	public Critiqueable[][] export2Darray() {
		Critiqueable[][] retVal = new Critiqueable[11][];
		
		//YOUR CODE HERE
		int [] rows = new int [11];
		int [] counter = new int [11];
		
		for (Critiqueable c : arr) {
			
			if (c.getMediaHype() < 0) {
				
				rows[0]++;
			}
			else if (c.getMediaHype() < 10) {
				
				rows [c.getMediaHype()]++;
			}
			else {
				
				rows [10]++;
			}
		}
		
		for (int i = 0; i < 11; i++) {
			
			retVal [i] = new Critiqueable [rows[i]];
		}
		
		for (Critiqueable c : arr) {
			
			int hype = c.getMediaHype();
			
			if (hype < 0) {
				
				Critiqueable copy = c.returnClone();
				retVal [0][counter[0]] = copy;
				counter[0]++;
			}
			else if (hype < 10) {
				
				Critiqueable copy = c.returnClone();
				retVal [hype] [counter[hype]] = copy;
				counter[hype]++;
			}
			else {
				
				Critiqueable copy = c.returnClone();
				retVal [10][counter[10]] = copy;
				counter[10]++;
			}
		}

		return retVal;
	}

	
	
	/**
	 * The method will return a ragged 2D structure using the ArrayList
	 * data type - it will have references to deep copies of the Critiqueable 
	 * items currently stored in the CardsAgainstCriticsDeck.  
	 * 
	 * The 2D structure will have one row for each single-digit media hype
	 *  value (0 through 9) and then a row for all with higher media
	 *  values.  The items with negative media hype will go into the "0" row. 
	 *  
	 * Within each row the order will be based on the "front to back" order 
	 * of them in the deck's single-dimensional structure.
	 * 
	 * NOTE: To build this ragged 2D structure, you should only need
	 * to go through the deck once!
	 * 
	 * @return reference to a ragged 2D structure using ArrayLists
	 */
	//how do you add in a 2D array or perform any functions/call methods
	public ArrayList<ArrayList<Critiqueable>> export2Darraylist() {
		ArrayList<ArrayList<Critiqueable>> retVal =
				new ArrayList<ArrayList<Critiqueable>>();
		
		
		//YOUR CODE HERE
		
		ArrayList<Critiqueable> arrL1 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL2 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL3 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL4 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL5 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL6 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL7 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL8 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL9 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL10 = new ArrayList<Critiqueable>();
		ArrayList<Critiqueable> arrL0 = new ArrayList<Critiqueable>();
		
		retVal.add(arrL0);
		retVal.add(arrL1);
		retVal.add(arrL2);
		retVal.add(arrL3);
		retVal.add(arrL4);
		retVal.add(arrL5);
		retVal.add(arrL6);
		retVal.add(arrL7);
		retVal.add(arrL8);
		retVal.add(arrL9);
		retVal.add(arrL10);
		
		for (Critiqueable c : arr) {
			
			if (c.getMediaHype() < 10 && c.getMediaHype() >= 0) {
				
				Critiqueable copy = c.returnClone();
				retVal.get(c.getMediaHype()).add(copy);
			}
			else if (c.getMediaHype() < 0) {
				
				Critiqueable copy = c.returnClone();
				retVal.get(0).add(copy);
			}
			else {
				
				Critiqueable copy = c.returnClone();
				retVal.get(10).add(copy);
			}
		}

		return retVal;
	}
	
	
	
	
	/**
	 * The method will return a String object containing a representation
	 * of the Critiqueable items currently held in the CardsAgainstCriticsDeck, 
	 * shown in order from "front to back" of the ArrayList holding the references.
	 * 
	 * @return String representing the CardsAgainstCriticsDeck
	 */
	@Override
	public String toString() {
		StringBuffer retVal = new StringBuffer("Contents: ");
		retVal.append("[ ");
		for (Critiqueable val : arr) {
			retVal.append(val + ", ");
		}
		if (retVal.lastIndexOf(", ") == retVal.length()-2) {
			retVal.delete(retVal.length()-2, retVal.length());
		}
		retVal.append(" ]");

		return new String(retVal);
	}







}

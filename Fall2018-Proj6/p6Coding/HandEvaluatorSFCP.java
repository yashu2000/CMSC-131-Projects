package p6Coding;

public class HandEvaluatorSFCP {
	//ALL OF THESE ARE PASSED AN ARRAY OF LENGTH 5

	
	
	//Cluster 1: Think about how a helper might be useful for these...
	//not working figure out why
	public static boolean hasPair(Card[] cards) {
		/*
		boolean pair = false;
		for (int i = 0; i < 4; i++) {
			
			for (int j = 0; j < 4; j++) {
				
				if (cards [i].getValue() == cards[j].getValue() && i != j) {
					
					pair = true;
				}
			}
		}
		
		return pair;
		*/
		
		int [] cardcounter = new int [11];
		
		for (Card c : cards) {
			
			cardcounter [c.getValue()]++;
		}
		
		boolean double1 = false;
		
		for (int i = 0; i < cardcounter.length; i++) {
			
			if (cardcounter[i] >= 2) {
				
				double1 = true;
			}
		}
		
		return double1;
		//throw new RuntimeException("You need to implement this...");
	}
	
	
	public static boolean hasThreeOfAKind(Card[] cards) {
		
		
		int [] cardcounter = new int [11];
		
		for (Card c : cards) {
			
			cardcounter [c.getValue()]++;
		}
		
		boolean triple = false;
		for (int i = 0; i < cardcounter.length; i++) {
			
			if (cardcounter[i] >= 3) {
				
				triple = true;
			}
		}
		
		return triple;
		//throw new RuntimeException("You need to implement this...");
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		
		int [] cardcounter = new int [11];
		
		for (Card c : cards) {
			
			cardcounter [c.getValue()] ++;
		}
		
		boolean quadruple = false;
		for (int i = 0; i < cardcounter.length; i++) {
			
			if (cardcounter [i] >= 4) {
				
				quadruple = true;
			}
		}
		return quadruple;
		//throw new RuntimeException("You need to implement this...");
	}

	public static boolean hasFiveOfAKind(Card[] cards) {
		/*
		int [] cardcounter = new int [11];
		
		for (Card c : cards) {
			
			cardcounter [c.getValue()]++;
		}
		
		boolean cinqo = false;
		
		for (int i = 0; i < cardcounter.length; i++) {
			
			if (cardcounter [i] > 4) 
				cinqo = true;
		}
		
		return cinqo;
		*/
		
		if (cards[0].getValue() == cards[1].getValue() && cards[0].getValue() == cards [2].getValue()
				&& cards[0].getValue() == cards[3].getValue() && 
				cards[0].getValue() == cards[4].getValue()) {
			
			return true;
		}
		else {
			
			return false;
		}
		
		//throw new RuntimeException("You need to implement this...");
	}



	//Cluster 2
	public static boolean hasRainbow(Card[] cards) {
		
		int suits1 = cards[0].getSuit(), suits2 = cards[1].getSuit(), suits3 = cards[2].getSuit(), 
				suits4 = cards[3].getSuit(), suits5 = cards[4].getSuit();
		
		if (suits1 != suits2 && suits1 != suits3 && suits1 != suits4 && suits1 != suits5 && 
				suits2 != suits3 && suits2 != suits4 && suits2 != suits5 && 
				suits3 != suits4 && suits3 != suits5 &&
				suits4 != suits5) {
			
			return true;
		}
		else {
			return false;
		}
		//throw new RuntimeException("You need to implement this...");
	}
	
	
	//156 lines of code LOL
	public static boolean hasStraight(Card [] cards) {
		
		
		int val1 = cards[0].getValue(), val2 = cards[1].getValue(), val3 = cards[2].getValue(), 
				val4 = cards[3].getValue(), val5 = cards[4].getValue();
		
		int acecounter = 0;
		for (int i = 0; i < 5; i++) {
			
			if (cards[i].getValue() == 1) {
				acecounter++;
			}
		}
		//if there is more than 0 aces there can be a straight
		if (acecounter > 0) {
			
			//if there are more than one ace, automatically there is no straight
			if (acecounter > 1) {
				
				return false;
			}
			
			else {
				//only two forms of aces -> where it is A,2,3,4,5 or 
				// 6,7,8,9,A
				//it goes through both combinations. if either doesnt exist then there is no straight
				if (val1 == 2 || val2 == 2 || val3 == 2 || val4 == 2 || val5 == 2) {
					
					//since we know there is a 2, checks if 3, 4, 5 all exist
					boolean third = false, fourth = false, fifth = false;
					for (Card c4 : cards) {
						
						if (c4.getValue() == 3) {
							
							third = true;
						}
						else if (c4.getValue() == 4) {
							
							fourth = true;
						}
						else if (c4.getValue() == 5) {
							
							fifth = true;
						}
					}
					//if 3 and 4 and 5 exist, and since we know 2 exists and A is present its a straight
					if (third == true && fourth == true && fifth == true) {
						
						return true;
					}
					else {
						return false;
					}
				}
				//same concept as the prior 2 based execution
				else if (val1 == 6 || val2 == 6 || val3 == 6 || val4 == 6 || val5 == 6) {
					
					boolean seventh = false, eigth = false, ninth = false;
					
					for (Card c4 : cards) {
						
						if (c4.getValue() == 7) {
							
							seventh = true;
						}
						else if (c4.getValue() == 8) {
							
							eigth = true;
						}
						else if (c4.getValue() == 9) {
							
							ninth = true;
						}
					}
					
					if (seventh == true && eigth == true && ninth == true) {
						
						return true;
					}
					else {
						return false;
					}
					
				}
				else {
					
					return false;
				}
			}
			
		}
		else {
			//gets the smallest value within your dealt cards
			int smallest = val1;
			for (Card c2 : cards) {
				
				if (smallest > c2.getValue()) {
					
					smallest = c2.getValue();
				}
			}
			
			/*if we have the smallest, then if it is a straight all following values must be increments
			 * of the smallest term. So we can pre-define them
			 */
			int second = smallest + 1, third = smallest + 2, fourth = smallest + 3, fifth = smallest+4;
			
			//if the aforementioned increments do exist 
			//then all of these will be turned true in the enhanced for loop.
			boolean isSecond = false, isThird = false, isFourth = false, isFifth = false;
			
			for (Card c3 : cards) {
				
				if (second == c3.getValue()) {
					
					isSecond = true;
				}
				else if (third == c3.getValue()) {
					
					isThird = true;
				}
				else if (fourth == c3.getValue()) {
					
					isFourth = true;
				}
				else if (fifth == c3.getValue()) {
					
					isFifth = true;
				}
			}
			
			//if all the increments did exist within your deal, then there is a straight
			if (isSecond == true && isThird == true && isFourth == true && isFifth == true) {
				
				return true;
			}
			else {
				return false;
			}
			
		}
		
	}

	public static boolean hasFlush(Card[] cards) {
		
		if (cards[0].getSuit() == cards [1].getSuit() && cards [0].getSuit() == cards [2].getSuit() &&
				cards[0].getSuit() == cards[3].getSuit() && cards [0].getSuit() == cards [4].getSuit()) {
			
			return true;
		}
		else {
			
			return false;
		}
		//throw new RuntimeException("You need to implement this...");
	}




	//Cluster 3: Think about how to make use of existing methods to
	//           make the following ones easier to write...
	public static boolean hasStraightRainbow(Card[] cards) {
		
		if (hasStraight (cards) == true && hasRainbow (cards) == true) {
			
			return true;
		}
		else {
			
			return false;
		}
		
	}

	public static boolean hasStraightFlush(Card[] cards) {
		
		if (hasStraight (cards) == true && hasFlush (cards) == true) {
			
			return true;
		}
		else {
			
			return false;
		}
		
	}

	public static boolean hasTwoPair(Card[] cards) {
		
		int[] cardcounter = new int [11];
		
		for (Card c : cards) {
			
			cardcounter [c.getValue()]++;
		}
		
		boolean double1 = false, double2 = false;
		int num1 = -1, num2 = -1;
		for (int i = 0; i < cardcounter.length; i++) {
			
			if (cardcounter [i] >= 2) {
				
				double1 = true;
				num1 = i;
			}
		}
		
		for (int i = 0; i < cardcounter.length; i++) {
			
			if (cardcounter [i] >= 2 && i != num1) {
				
				double2 = true;
				num2 = i;
			}
		}
		
		if (double1 == true && double2 == true && num1 != num2) {
			
			return true;
		}
		else {
			
			return false;
		}
	}




	//Challenge
	public static boolean hasFullHouse(Card[] cards) {
		
		if (hasPair (cards) == true && hasThreeOfAKind (cards) == true && hasTwoPair (cards) == true) {
			
			return true;
		}
		else {
			return false;
		}
		//throw new RuntimeException("You need to implement this...");
	}




}


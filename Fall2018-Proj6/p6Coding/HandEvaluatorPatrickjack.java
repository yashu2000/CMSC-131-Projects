package p6Coding;

import java.util.ArrayList;

public class HandEvaluatorPatrickjack {
	//Each of these is passed a reference to an ArrayList<Card> object 
	//  with "UNKNOWN" length (so you'll need to "ask" it).

	public static int eval(ArrayList<Card> hand) {
		
		int sumval = 0, handval = 0, fivecounter = 0;
		
		for (Card d : hand) {
			
			if (d.getValue() == 5) {
				fivecounter++;
			}
			sumval = sumval + d.getValue();
			
		}
		
		if (sumval > 21) {
			
			handval = 0;
		}
		else if (hand.size() == 2 && ((hand.get(0).getValue() == 2 && hand.get(1).getValue() == 4) 
				|| hand.size() == 2 && (hand.get(0).getValue() == 4 && hand.get(1).getValue() == 2))) {
			
			handval = 22;
		}
		else if (hand.size() == 2 && ((hand.get(0).getValue() == 6 && hand.get(1).getValue() == 9) 
				|| (hand.get(0).getValue() == 9 && hand.get(1).getValue() == 6))) {
			
			handval = 21;
		}
		
		//check for 5s within parameter
		else if (fivecounter > 0) {
			
			
			if (fivecounter >= 1 && sumval + 10 <= 21) {
				
				sumval += 10;
			}
			
			handval = sumval;
		}
		
		else {
			
			handval = sumval;
		}
		
		return handval;
		/*
		if (handval > 21) {
			return 0;
		}
		else {
			return handval;
		}*/
		//throw new RuntimeException("You need to implement this...");
	}


	public static boolean houseWins(ArrayList<Card> player, ArrayList<Card> dealer) {
		
		int playerval = eval (player);
		int dealerval = eval (dealer);
		
		if (playerval >= dealerval) {
			
			return false;
		}
		else
			return true;
		
		//throw new RuntimeException("You need to implement this...");
	}

}

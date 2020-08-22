package p6Coding;

import java.util.ArrayList;

public class Deck {

	//You need to use this ArrayList<Card> structure to hold the deck
	//  
	//Your cannot use regular arrays in this class other than in the
	//  deal method, which needs to return an array
	private ArrayList<Card> cards;
	
	

	public Deck() {
		
		cards = new ArrayList<Card>();
		int suit, card;
		
		for (suit = 0; suit < 5; suit++) {
			
			for (card = 1; card < 10; card++) {
				
				cards.add(new Card (card, suit));
			}
		}
		
	}

	public Deck(Deck other) {
		
		cards = new ArrayList<Card>();
		
		for (Card c : other.cards) {
			
			cards.add(c);
		}
		
	}

	public Card getCardAt(int position) {
		
		return cards.get(position);
		
	}

	public int getNumCards() {
		
		return cards.size();
		
	}


	public Card[] deal(int numCards) {
		
		Card [] deal = new Card [numCards];
		
		for (int i = 0; i <numCards; i++) {
			
			deal [i] = cards.get(i);
		}
		for (int r = 0, c = 0; c < numCards; r++, c++) {
			
			cards.remove(r);
			r--;
		}
		
		return deal;
		
	}


	public void cut(int position) throws StarDeckException {
		
		if (position < 3 || position > cards.size()-3) {
			
			throw new StarDeckException ("Too few cards in one part of the cut.");
		}
		else {
			
			Card [] saver = new Card [position];
			
			for (int t = 0; t < position; t++) {
				
				Card save = new Card (cards.get(0).getValue(), cards.get(0).getSuit());
				saver[t] = save;
				cards.remove(0);
				
			}
			
			for (int i = 0; i < position; i++) {
				
				cards.add(saver [i]);
			}
			
		
		}
		
	}
	
	
	
	
	public void shuffle() {
		
		if (cards.size() % 2 == 0) {
			Card [] arr1 = new Card [cards.size()/2], arr2 = new Card [cards.size()/2];
		
			for (int i = 0, j = 0, k = cards.size()/2; i < cards.size()/2 && j < cards.size()/2 && 
				k < cards.size(); i++, j++, k++) {
			
				arr1 [i] = cards.get(j);
				arr2 [i] = cards.get(k);
			}
		
			ArrayList<Card> copy = new ArrayList<Card> ();
		
			for (int i = 0; i < cards.size()/2; i++) {
			
				copy.add(arr1[i]);
				copy.add(arr2[i]);
			}
		
			cards = copy;
		}
		else {
			
			Card [] arr1 = new Card [cards.size()/2], arr2 = new Card [cards.size()/2 + 1];
			
			for (int i = 0, j = 0, k = cards.size()/2, n = 0; i < cards.size()/2 && j < cards.size()/2 && 
				k < cards.size() && n < cards.size()/2 + 1; i++, j++, k++, n++) {
			
				arr1 [i] = cards.get(j);
				arr2 [n] = cards.get(k);
			}
		
			ArrayList<Card> copy = new ArrayList<Card> ();
		
			for (int i = 0, j = 0; i < cards.size()/2 && j < cards.size()/2 + 1; i++, j++) {
			
				copy.add(arr1[i]);
				copy.add(arr2[j]);
			}
		
			cards = copy;
		}
		
	}
	

}

package p6Testing;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import p6Coding.Card;
import p6Coding.Deck;
import p6Coding.HandEvaluatorSFCP;
import p6Coding.HandEvaluatorPatrickjack;

public class StudentTests {

	@Test
	public void testExampleTest_SinglePairTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(5,1);
		assertFalse(HandEvaluatorSFCP.hasPair(testHand));
	}


	@Test
	public void testExampleTest_SingleRainbowTest() {
		Card testHand[] = new Card[5];

		testHand[0] = new Card(4,0);
		testHand[1] = new Card(5,1);
		testHand[2] = new Card(5,2);
		testHand[3] = new Card(5,3);
		testHand[4] = new Card(9,4);
		assertTrue(HandEvaluatorSFCP.hasRainbow(testHand));
	}


	@Test
	public void testExampleTest_SinglePatrickjackEvalTest() {
		ArrayList<Card> player = new ArrayList<Card>();
		player.add(new Card(3,1));
		player.add(new Card(2,1));

		assertEquals(5, HandEvaluatorPatrickjack.eval(player));
	}


	@Test
	public void testExampleTest_DeckDealCardsLengthTest() {
		Deck theDeck = new Deck();
		Card[] cards = theDeck.deal(41);
		assertEquals(41, cards.length);
	}


	//You will add many other tests here.  You can also modify the ones above.




}

package testCode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import studentCode.Movie;
import studentCode.CardsAgainstCriticsDeck;
import studentCode.VideoGame;
import studentCode.Critiqueable;
import studentCode.Website;
import studentCode.Universe.Outcomes;

public class ExampleTests {

	@Test
	public void testOne() {
		CardsAgainstCriticsDeck<VideoGame> cacd = new CardsAgainstCriticsDeck<VideoGame>();
		cacd.add(new VideoGame("one", 1));
		cacd.add(new VideoGame("two", 2));
		cacd.add(new VideoGame("three", 3));
		cacd.add(new VideoGame("four", 4));

		assertEquals(
				"Contents: [ VideoGame<Title: four  Fans: 4  Hype: -1>, VideoGame<Title: two  Fans: 2  Hype: -1>, VideoGame<Title: one  Fans: 1  Hype: -1>, VideoGame<Title: three  Fans: 3  Hype: -1> ]",
				cacd.toString()
				);
	}


	@Test
	public void testTwo() {
		CardsAgainstCriticsDeck<VideoGame> cacd = new CardsAgainstCriticsDeck<VideoGame>();
		cacd.add(new VideoGame("one", 11));
		cacd.add(new VideoGame("two", 12));
		cacd.add(new VideoGame("three", 13));
		cacd.add(new VideoGame("four", 14));

		assertEquals(
				"Contents: [ VideoGame<Title: four  Fans: 14  Hype: -1>, VideoGame<Title: two  Fans: 12  Hype: -1>, VideoGame<Title: one  Fans: 11  Hype: -1>, VideoGame<Title: three  Fans: 13  Hype: -1> ]",
				cacd.toString()
				);

		assertEquals(
				"VideoGame<Title: four  Fans: 14  Hype: -1>",
				cacd.solitaireCritique().toString()
				);

		assertEquals(
				"VideoGame<Title: two  Fans: 12  Hype: -1>",
				cacd.solitaireCritique().toString()
				);
	}


	@Test
	public void testThree() {
		CardsAgainstCriticsDeck<VideoGame> cacd = new CardsAgainstCriticsDeck<VideoGame>();
		cacd.add(new VideoGame("four", 14));
		cacd.add(new VideoGame("three", 13));
		cacd.add(new VideoGame("two", 12));
		cacd.add(new VideoGame("one", 11));

		assertEquals(
				"Contents: [ VideoGame<Title: one  Fans: 11  Hype: -1>, VideoGame<Title: three  Fans: 13  Hype: -1>, VideoGame<Title: four  Fans: 14  Hype: -1>, VideoGame<Title: two  Fans: 12  Hype: -1> ]",
				cacd.toString()
				);

		assertEquals(
				"VideoGame<Title: two  Fans: 12  Hype: -1>",
				cacd.solitaireCritique().toString()
				);

		assertEquals(
				"VideoGame<Title: four  Fans: 14  Hype: -1>",
				cacd.solitaireCritique().toString()
				);

	}


	@Test
	public void testFour() {
		CardsAgainstCriticsDeck<VideoGame> cacd = new CardsAgainstCriticsDeck<VideoGame>();
		cacd.add(new VideoGame("one", 2));
		cacd.add(new VideoGame("two", 2));
		cacd.add(new VideoGame("three", 4));
		cacd.add(new VideoGame("one", 2));
		cacd.add(new VideoGame("two", 3));

		assertEquals(
				"Contents: [ VideoGame<Title: one  Fans: 2  Hype: -1>, VideoGame<Title: two  Fans: 2  Hype: -1>, VideoGame<Title: one  Fans: 2  Hype: -1>, VideoGame<Title: three  Fans: 4  Hype: -1>, VideoGame<Title: two  Fans: 3  Hype: -1> ]",
				cacd.toString()
				);

		assertEquals(
				"VideoGame<Title: two  Fans: 3  Hype: -1>",
				cacd.solitaireCritique().toString()
				);


		assertEquals(
				"Contents: [ VideoGame<Title: three  Fans: 4  Hype: -1> ]",
				cacd.toString()
				);

		assertEquals(
				"VideoGame<Title: three  Fans: 4  Hype: -1>",
				cacd.solitaireCritique().toString()
				);

		assertEquals(
				"Contents: [  ]",
				cacd.toString()
				);

		assertEquals(
				null,
				cacd.solitaireCritique()
				);

	}


	@Test
	public void testFive() {
		CardsAgainstCriticsDeck<Critiqueable> cacd = new CardsAgainstCriticsDeck<Critiqueable>();

		cacd.add(new Movie("one", 11));
		cacd.add(new VideoGame("two", 12));
		cacd.add(new Movie("three", 13));
		cacd.add(new VideoGame("four", 14));

		assertEquals(
				"Contents: [ VideoGame<Title: four  Fans: 14  Hype: -1>, VideoGame<Title: two  Fans: 12  Hype: -1>, Movie<Title: one  Fans: 11  Hype: 7>, Movie<Title: three  Fans: 13  Hype: 7> ]",
				cacd.toString()
				);

		assertEquals(
				"Movie<Title: three  Fans: 13  Hype: 7>",
				cacd.solitaireCritique().toString()
				);

		assertEquals(
				"Movie<Title: one  Fans: 11  Hype: 7>",
				cacd.solitaireCritique().toString()
				);
	}



	@Test
	public void testSix() {
		CardsAgainstCriticsDeck<Critiqueable> cacd = new CardsAgainstCriticsDeck<Critiqueable>();

		cacd.add(new Movie("one", 11));
		cacd.add(new Website("A", 7));
		cacd.add(new VideoGame("two", 12));
		cacd.add(new Website("Z", 7));
		cacd.add(new Movie("three", 13));
		cacd.add(new Website("L", 7));
		cacd.add(new VideoGame("four", 14));

		assertEquals(
				"Contents: [ Website<Title: L  Fans: 7  Hype: 4>, Website<Title: Z  Fans: 7  Hype: 2>, Website<Title: A  Fans: 7  Hype: 1>, Movie<Title: one  Fans: 11  Hype: 7>, VideoGame<Title: two  Fans: 12  Hype: -1>, Movie<Title: three  Fans: 13  Hype: 7>, VideoGame<Title: four  Fans: 14  Hype: -1> ]",
				cacd.toString()
				);

		assertEquals(
				"Website<Title: L  Fans: 7  Hype: 4>",
				cacd.solitaireCritique().toString()
				);

		assertEquals(
				"Movie<Title: three  Fans: 13  Hype: 7>",
				cacd.solitaireCritique().toString()
				);	

		assertEquals(
				"Website<Title: A  Fans: 7  Hype: 1>",
				cacd.solitaireCritique().toString()
				);

	}


	@Test
	public void testSeven() {
		CardsAgainstCriticsDeck<Critiqueable> cacd = new CardsAgainstCriticsDeck<Critiqueable>();

		cacd.add(new Movie("one", 11));
		cacd.add(new Website("A", 7));
		cacd.add(new VideoGame("two", 12));
		cacd.add(new Website("Z", 7));
		cacd.add(new Movie("three", 13));
		cacd.add(new Website("L", 7));
		cacd.add(new VideoGame("four", 14));

		assertEquals(
				"[VideoGame<Title: two  Fans: 12  Hype: -1>, VideoGame<Title: four  Fans: 14  Hype: -1>]",
				Arrays.toString(cacd.export2Darray()[0])
				);
		assertEquals(
				"[Website<Title: A  Fans: 7  Hype: 1>]",
				Arrays.toString(cacd.export2Darray()[1])
				);
		assertEquals(
				"[Website<Title: Z  Fans: 7  Hype: 2>]",
				Arrays.toString(cacd.export2Darray()[2])
				);	
		assertEquals(
				"[]",
				Arrays.toString(cacd.export2Darray()[3])
				);	
		assertEquals(
				"[Website<Title: L  Fans: 7  Hype: 4>]",
				Arrays.toString(cacd.export2Darray()[4])
				);	
		assertEquals(
				"[]",
				Arrays.toString(cacd.export2Darray()[5])
				);	
		assertEquals(
				"[]",
				Arrays.toString(cacd.export2Darray()[6])
				);	
		assertEquals(
				"[]",
				Arrays.toString(cacd.export2Darray()[8])
				);	
		assertEquals(
				"[]",
				Arrays.toString(cacd.export2Darray()[9])
				);	
	}

	@Test
	public void testEight() {
		CardsAgainstCriticsDeck<Critiqueable> cacd = new CardsAgainstCriticsDeck<Critiqueable>();


		Critiqueable thing1 = new VideoGame("A", 5);
		for (int i=0; i<10000; i++) {
			thing1.inform(Outcomes.FRESH);
		}
		Critiqueable thing2 = new VideoGame("B", 5);
		for (int i=0; i<500; i++) {
			thing2.inform(Outcomes.FRESH);
		}
		Critiqueable thing3 = new VideoGame("C", 5);
		for (int i=0; i<20; i++) {
			thing3.inform(Outcomes.FRESH);
		}

		cacd.add(thing1);
		cacd.add(thing2);
		cacd.add(thing3);
		
		System.out.println(thing3);

		assertEquals(
				"[VideoGame<Title: C  Fans: 5  Hype: 0>]",
				Arrays.toString(cacd.export2Darray()[0])
				);	

		assertEquals(
				"[VideoGame<Title: B  Fans: 5  Hype: 40>, VideoGame<Title: A  Fans: 5  Hype: 832>]",
				Arrays.toString(cacd.export2Darray()[10])
				);	
	}


}

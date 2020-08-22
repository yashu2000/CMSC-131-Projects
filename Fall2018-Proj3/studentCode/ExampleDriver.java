package studentCode;

import java.util.Scanner;

import cmsc131_GridTools.Grid_3x5;
/**
 *  THIS CLASS IS PROVDED FOR YOU - YOU SHOULD NOT MAKE ANY
 *  CHANGES TO THIS FILE AT ALL.  USE IT TO TEST EACH FLAG
 *  AS YOU WORK ON IT.
 *   
 *  This driver relies on the "drawFlag" method of the "FlagMaker"
 *  class.  It prompts the user to enter information about what flag
 *  he/she would like to see and in what size.  
 *  Then it creates a Grid_1x2 (of the appropriate size), and calls
 *  the drawFrag method of the FlagMaker class to actually draw
 *  the flag.
 */
public class ExampleDriver {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		/* Get input from user about what flag to draw */
		System.out.println("Type the number corresponding to the name:  ");
		System.out.println("0 for a silly example");
		System.out.println("1 Sultanate of Muscat");
		System.out.println("2 Rif");
		System.out.println("3 Canton of Ticino");
		System.out.println("4 Prague");
		System.out.println("5 Santa Catarina");
		System.out.println("6 Norfolk");
		System.out.println("7 Vincent");
		System.out.println("8 Hour Glassville");
		System.out.println("9 Sheltopia");
		System.out.println("10 Youville");
		System.out.print("Your choice here:");
		int choice = scanner.nextInt();
		System.out.print("Choose a scale (2 or larger): ");
		int scale = scanner.nextInt();
		if (scale < 2 || scale > 12){
			scale = 2;
			choice = 99; //an invalid choice number to make it easy to test for in drawFlag 
		}
		
		/* Create drawing grid of the height requested */
		Grid_3x5 grid = new Grid_3x5(scale);

		/* Draw the letter on the grid */
		FlagMaker.drawFlag(grid, choice);
		
		
		scanner.close();
	}
}

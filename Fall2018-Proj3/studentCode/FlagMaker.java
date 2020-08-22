package studentCode;
import java.awt.Color;

import cmsc131_GridTools.Grid_3x5;


public class FlagMaker {
	private static Color AZURE = new Color(0,127,255);
	private static Color OLIVE = new Color(169, 208, 70);

	//You should read and get comfortable with these provided methodS
	//  as your first step - understand what they do and why.

	//Think about how you can write your "draw" methods and some other 
	//  helper methods as you work on the remaining flags.




	private static void helperField(Grid_3x5 grid, Color theColor) {
		//We want to paint the whole flag this one color.  To do
		//  this we can iterate through each row, and within that
		//  row iterate through each column.  At each position, 
		//  we'll set the color there to the one passed in.
		//The background color of a flag is known as the field 
		//  in the world of vexillology.
		for (int row=0; row<grid.getHt(); row++) {
			for (int col=0; col<grid.getWd(); col++) {
				grid.setColor(row, col, theColor);
			}
		}
	}
	
	/***Hello*/

	private static void drawSillyExample(Grid_3x5 grid) {
		grid.setColor(3, 3, Color.RED);
		grid.setColor(0, 2, Color.BLUE);

		grid.setColor(grid.getHt()-1, grid.getWd()-1, Color.CYAN);
		grid.setColor(grid.getHt()-2, grid.getWd()-2, Color.CYAN);
		grid.setColor(grid.getHt()-3, grid.getWd()-3, Color.CYAN);
		grid.setColor(grid.getHt()-4, grid.getWd()-4, Color.CYAN);
		//HINT: Think about how these last four instructions 
		//      could have been done utilizing a for loop.
	}

	private static void drawSultanateOfMuscat(Grid_3x5 grid) {
		//Since this is just a solid red flag, we'll call the
		//  helper we have to do the work.
		helperField(grid, Color.RED);
	}





	//This is a more complex helper method that we provide
	//  it draws a diamond in the center of a grid that is 
	//  sent to it, using the specified color.
	//You might find it interesting to read the code, but
	//  you can use this helper without doing that since 
	//  you do know what it does at the abstract level.
	private static void helperCenterDiamond(Grid_3x5 grid, Color theColor) {
		//The diamond will be 2/3rds the height of the flag and centered.

		int anchorRow = grid.getHt()/3 * 3/2;
		int anchorCol = grid.getWd()/2;

		int totalRadius=grid.getHt()/3;

		for (int currRadius=0; currRadius<totalRadius; currRadius++) {
			int sizeOfSegment = totalRadius-currRadius;
			for (int distFromAnchor=0; distFromAnchor<sizeOfSegment; distFromAnchor++) {
				grid.setColor(anchorRow-currRadius, anchorCol-distFromAnchor, theColor);
				grid.setColor(anchorRow-currRadius, anchorCol+distFromAnchor, theColor);
				grid.setColor(anchorRow+currRadius, anchorCol-distFromAnchor, theColor);
				grid.setColor(anchorRow+currRadius, anchorCol+distFromAnchor, theColor);
			}
		}
	}




	/* Draws a single flag as indicated by the second parameter
	 * into the grid passed as the first parameter.  We provide 
	 * the starter code here that will correctly call the helper
	 * to draw the silly example flag and the flag of the Sultanate 
	 * Of Muscat.  
	 * 
	 * As you work on the flag for each task, you'll need to 
	 * (a) modify this method to add the option, and 
	 * (b) write the helper method(s) that it calls.
	 */
	public static void drawFlag(Grid_3x5 grid, int flagCode) {
		//Our silly example flag just needs to have flagCode as 0
		if (flagCode==0) {
			drawSillyExample(grid);	
		}

		//Our next flag is that of the Sultanate of Muscat
		//so our condition has:
		//   - a check for that flag's code, 1
		//   - a check to make sure the height of the grid
		//      passed in is odd
		//   - a check to make sure the height of the grid
		//      passed in is at least 7
		else if (flagCode==1   &&   grid.getHt()%2==1   &&   grid.getHt()>=7) {
			drawSultanateOfMuscat(grid);
		}

		//ADD THE TESTS/FILTERS FOR EACH ADDITIONAL FLAG HERE
		//  AS YOU IMPLEMENT THE TASKS
		else if (flagCode == 2 && grid.getHt() %2 ==1) {
			drawRif(grid);
		}
		
		else if(flagCode == 3) {
			
			drawCanton (grid);
		}
		
		else if (flagCode == 4) {
			
			drawPrague (grid);
		}
		
		else if (flagCode == 5) {
			
			drawCatarina (grid);
		}
		else if (flagCode == 6 && grid.getWd() % 10 == 0) {
			
			drawNorfolk (grid);
		}
		
		else if (flagCode == 7 && grid.getWd() % 10 == 0) {
			
			drawVincent (grid);
		}
		
		else if (flagCode == 8 && grid.getHt() % 2 ==1) {
			
			drawGlassville (grid);
		}
		else if (flagCode == 9 && grid.getHt() % 2 == 1) {
			
			drawSheltopia (grid);
		}
		
		else if (flagCode == 10 && grid.getHt() %2 ==1) {
			
			drawMe(grid);
		}







		//THE LAST "ELSE" IN THE CHAIN SHOULD CALL THE ERROR FLAG
		else{
			drawError(grid);
		}
	}



	//YOUR FIRST TASK'S DRAW METHOD GOES HERE - WE'VE PROVIDED THE
	//  SIGNATURE TO HELP POINT YOU IN THE RIGHT DIRECTION FOR THIS
	//  AND FUTURE FLAG DRAWING METHODS
	private static void drawError(Grid_3x5 grid){
		//YOUR CODE HERE
		
		int rowL = grid.getHt();
		int colL = grid.getWd();
		
		helperField (grid, Color.WHITE);
		grid.setColor(0, 0, Color.RED);
		grid.setColor(rowL-1, 0, Color.BLUE);
		grid.setColor(0, colL-1, Color.GREEN);
		grid.setColor(rowL-1, colL-1, Color.ORANGE);

	}
	



	//Your individual drawing methods for the flags, 
	//  and any helpers that you write for the tasks 
	//  should be added by you down here as you go...
	
	public static void drawRif (Grid_3x5 grid) {
		//gets dimensions of flag inputed
		//int rowL = grid.getHt();
		//int colL = grid.getWd();
		
		//sets the entire flag to red first
		helperField (grid, Color.RED);
		
		//draws the diamond in the middle
		helperCenterDiamond (grid, Color.WHITE);
	}
	
	public static void drawCanton (Grid_3x5 grid) {
		
		int rowl = grid.getHt();
		int coll = grid.getWd();
		
		if (rowl % 2 == 1) {
			
			drawError(grid);
		}
		else {
			
			helperField (grid, Color.PINK);
			for (int j = rowl/2; j <rowl; j++) {
				
				for (int k = 0; k < coll; k++) {
		
					grid.setColor(j, k, Color.CYAN);
				}
			}
		}
	}
	
	public static void drawPrague (Grid_3x5 grid) {
		
		int rowl = grid.getHt();
		int coll = grid.getWd();
		
		if (rowl%2 == 1) {
			drawError(grid);
		}
		else {
			
			helperField (grid, Color.RED);
			for (int i = 0; i < rowl/2; i++) {
				
				for (int k = 0; k < coll; k++) {
					
					grid.setColor(i, k, Color.YELLOW);
				}
			}
			
		}
	}
	
	public static void drawCatarina (Grid_3x5 grid) {
		
		int rowl = grid.getHt();
		int coll = grid.getWd();
		
		
		if (coll %2 == 0) {
			
			drawError(grid);
		}
		else {
			
			for (int i = 0, k = rowl/3, m = 2 * rowl/3; i < rowl/3 && k < 2*rowl/3 && m < rowl; 
					i++, k ++, m++) {
				
				for (int j = 0; j < coll; j++) {
					
					grid.setColor(i, j, Color.RED);
					grid.setColor( k, j, Color.WHITE);
					grid.setColor(m, j, Color.RED);
				}
			}
			
			helperCenterDiamond (grid, OLIVE);
		}
	}
	
	public static void drawNorfolk (Grid_3x5 grid) {
		
		int rowl = grid.getHt();
		int coll = grid.getWd();
	
		helperField (grid, Color.GREEN);
		int n = coll / 10;
		
		
		for (int i = 3 * n; i < 7 * n; i++) {
			
			for (int j = 0; j < rowl; j++) {
				
				grid.setColor(j, i, Color.WHITE);
			}
		}
		
	}
	
	public static void drawVincent (Grid_3x5 grid) {
		
		int rowl = grid.getHt();
		int coll = grid.getWd();
		
		helperField (grid, Color.YELLOW);
		
		int n = coll / 10;
		for (int i = 0, k = 7 * n; i < 3*n && k < coll; i++, k++) {
			
			for (int j = 0; j < rowl; j++) {
				
				grid.setColor(j, i, Color.BLUE);
				grid.setColor(j, k, Color.GREEN);
			}
		}
	}
	
	public static void drawGlassville (Grid_3x5 grid) {
		
		int rowl = grid.getHt();
		int coll = grid.getWd();
		
		helperField (grid, Color.GREEN);
		int rowB = 0, rowLA = coll-1;
		for (int i = 0, k = rowl; i <= k; i++, k--) {
			
			for (int j = i; j <k;  j++) {
				
				grid.setColor(j, rowB, Color.BLACK);
				grid.setColor(j, rowLA, Color.BLACK);
			}
			rowB++;
			rowLA--;
		}
	}
	
	public static void drawSheltopia (Grid_3x5 grid) {
		
		int rowl = grid.getHt();
		int coll = grid.getWd();
		
		helperField (grid, AZURE);
		
		//rowl % 4 + 1 is how many concentric squares we draw
		int max_Concentrics = rowl % 4 +1;
		
		//number iterations we put the while loop through to ensure that the exact number of concentrics
		int number_of_concs = 0;
		
		//start1 is the top corner going forward, fin1 is the right top, fin2 is the bottom right
		int start1= 0, fin1 = rowl - 1, fin2 = coll -1;
		
		while (number_of_concs < max_Concentrics) {
			
			
			
			
			for (int i = start1; i <= fin2; i++) {
				
				grid.setColor(start1, i, Color.YELLOW);
			}
			for (int j = start1; j<= fin1; j++) {
				
				grid.setColor(j, start1, Color.YELLOW);
			}
			for (int k = start1; k <= fin2; k++) {
				
				grid.setColor(fin1, k, Color.YELLOW);
			}
			for (int m = start1; m <=fin1; m++) {
				
				grid.setColor(m, fin2, Color.YELLOW);
			}
			
			start1 += 2;
			fin1 -= 2;
			fin2 -= 2;
			number_of_concs++;
		}
	}
	
	public static void drawMe (Grid_3x5 grid) {
		
		int rowl = grid.getHt();
		int coll = grid.getWd();
		
		helperField (grid, Color.MAGENTA);
		
		
		
		Color coolDiamond = new Color (100, 0, 200);
		//helperCenterDiamond (grid, coolDiamond);
		
		
		
		for (int i = 0, k = coll -1; i <= coll/3 && k >= (2*coll/3); i+=2, k-=2) {
			
			for (int j = 0; j < rowl; j++) {
				
				grid.setColor(j, i, Color.BLACK);
				grid.setColor(j, k, Color.BLACK);
			}
		}
		
		
	}
	



	
	
	
	
	
	


}

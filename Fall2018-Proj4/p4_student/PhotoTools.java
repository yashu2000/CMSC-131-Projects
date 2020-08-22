package p4_student;

import java.awt.Color;

import cmsc131PhotoLibrary.Photograph;
import cmsc131PhotoLibrary.Pixel;

/**
 * The methods in this class are to be implemented by you.  
 * This class starter file provides various static methods that take 
 * a photograph and produce a new one based on it, but with various 
 * modifications.
 * 
 * See the project description for details of method implementations.
 * 
 * @author PUT YOUR NAME HERE
 *
 */
public class PhotoTools {


	//This method is provided as a starting point.  Please read through
	//  it and think about what it does and why - if you aren't sure of
	//  something, ask us in office hours.  
	//Do not alter this code.  It is used by the GUI.
	
	
	public static Photograph copy(Photograph photo) {
		Photograph newPhoto = new Photograph(photo.getWd(), photo.getHt());
		
		for (int x=0; x<photo.getWd(); x++) {
			
			for (int y=0; y<photo.getHt(); y++) {
				
				newPhoto.setPixel(x, y, photo.getPixel(x, y));
			
			}
		
		}
		
		return newPhoto;
	}






	public static Photograph isolateColor(Photograph photo, int type) {
		
		Photograph newphoto = new Photograph(photo.getWd(), photo.getHt());
		
		
		int rowl = photo.getHt();
		int coll = photo.getWd();
		
		if (type == 1) {
			
			for (int i = 0; i < coll; i++) {
				
				for (int j = 0; j < rowl; j++) {
					
					newphoto.setPixel(i, j, new Pixel (0, 0, photo.getPixel(i, j).getBlue()));
				}
			}
		}
		else if (type == 0) {
			
			for (int i = 0; i < coll; i++) {
				
				for (int j = 0; j < rowl; j++) {
					
					newphoto.setPixel(i, j, new Pixel (photo.getPixel(i, j).getRed(), 0, 0));
				}
			}
		}
		
		else {
			
			newphoto = copy (photo);
		}
		
		return newphoto;
		
		//throw new RuntimeException("You'll implement this...");
	}





	public static Photograph makeGrayscale(Photograph photo) {
		
		Photograph newphoto = new Photograph (photo.getWd(), photo.getHt());
		int rowl = photo.getHt();
		int coll = photo.getWd();
		
		for (int i = 0; i < coll; i ++) {
			
			for (int j = 0; j < rowl; j++) {
				
				int greyval = (int)(photo.getPixel(i, j).getRed() * 0.1) + 
						(int) (photo.getPixel(i, j).getGreen() * 0.1) + 
						(int) (photo.getPixel(i, j).getBlue() * 0.8);
				
				
				newphoto.setPixel(i, j, new Pixel (greyval, greyval, greyval));
				
			}
		}
		
		return newphoto;
		//throw new RuntimeException("You'll implement this...");
	}



	public static Photograph makeArtistic(Photograph photo) {
		
		Photograph newphoto = new Photograph (photo.getWd(), photo.getHt());
		int coll = photo.getWd();
		int rowl = photo.getHt();
		
		for (int i = 0; i < coll; i++) {
			
			for (int j =0; j < rowl; j++) {
				
				int greyval1 = (int) ((int)photo.getPixel(i,j).getRed() + 
						(int)photo.getPixel(i, j).getGreen()+
						(int)photo.getPixel(i, j).getBlue());
				
				if (greyval1 <= 191) {
					
					newphoto.setPixel(i, j, new Pixel (0,0,0));
				}
				else if (greyval1 > 191 && greyval1 <= 343) {
					
					newphoto.setPixel(i, j, new Pixel (63, 63, 63));
				}
				
				else if (greyval1 > 343 && greyval1 <= 575) {
					
					newphoto.setPixel(i, j, new Pixel (127, 127, 127));
				}
				else {
					
					newphoto.setPixel(i, j, new Pixel (255, 255, 255));
				}
			}
		}
		
		return newphoto;
		
		//throw new RuntimeException("You'll implement this...");
	}



	public static Photograph censorIt(Photograph photo) {
		
		
		int coll = photo.getWd();
		int rowl = photo.getHt();
		Photograph newphoto = new Photograph (coll, rowl);
		
		
		
		
		for (int k = 0; k < coll; 
				k+=10) {
			
			for (int m = 0; m < rowl; m+=10 ) {
				
				int red = 0;
				int green = 0;
				int blue = 0;
				int count = 0;
				for (int i = k; i < k + 10; i++) {
				
					for (int j = m; j < m+10; j++) {
						
						if (i< coll && j < rowl) {
					
							red  = red + photo.getPixel(i, j).getRed();
							green = green + photo.getPixel(i, j).getGreen();
							blue = blue + photo.getPixel(i, j).getBlue();
							count++;
						}
						
					
					}
				}
				
				red = red /count;
				blue = blue/count;
				green = green/count;
				
				for (int i = k; i < k + 10; i++) {
					
					for (int j = m; j < m+10; j++) {
					
						newphoto.setPixel(i, j, new Pixel (red, green, blue));
					
					}
				}
			}
			
		}
		
		


		//HINT: To deal with the edge cases, you'll want to 
		//      check you aren't going out of bounds in the
		//      middle of your nested nesting of loops...
		
		return newphoto;


	}


	public static Photograph stretched(Photograph photo, int type) {
		
		Photograph newphoto1 = new Photograph (2 * photo.getWd(), photo.getHt());
		Photograph newphoto2 = new Photograph (photo.getWd(), 2 * photo.getHt());
		
		if (type == 0) { //hoziontal stretch
			
			for (int i = 0, k = 0; i < photo.getWd() && k < 2 * photo.getWd(); i++, k++) {
				
				boolean counterToMakeSureTwoRowsHaveBeenFilled = false;
				
				for (int j = 0; j < photo.getHt(); j++) {
					
					newphoto1.setPixel(k, j, photo.getPixel(i, j));
					
					
					//if statement only triggers if we have successfully copied the first column 
					if (counterToMakeSureTwoRowsHaveBeenFilled == false && j == (photo.getHt() - 1)) {
						
						counterToMakeSureTwoRowsHaveBeenFilled = true;
						j = -1;
						k++;
					}
				}
			}
			
			return newphoto1;
		}
		
		else if (type == 1) { //vertical stretch
			
			for (int j = 0, m = 0; j < photo.getHt() && m < 2 * photo.getHt(); j++, m++) {
				
				boolean counterToMakeSureTwoRowsHaveBeenFilled = false;
				
				for (int i = 0; i < photo.getWd(); i++) {
					
						
						newphoto2.setPixel(i, m, photo.getPixel(i, j));
						
					//problem with logic here
					if (counterToMakeSureTwoRowsHaveBeenFilled == false && i == photo.getWd() -1) {
						
						counterToMakeSureTwoRowsHaveBeenFilled = true;
						i = -1;
						m++;
						
					}
					
					
				}
				
				}
			
			return newphoto2;
		}
		else { 
			
			return photo;
		}
		
		
		
		//throw new RuntimeException("You'll implement this...");
	}



	public static Photograph mirrorIt(Photograph photo) {
		
		Photograph newphoto = new Photograph (photo.getWd(), photo.getHt());
		
		int coll = photo.getWd();
		int rowl = photo.getHt();
		
		for (int i = 0, k = coll - 1; i < coll && k >=0; i++, k--) {
			
			for (int j  = 0; j < rowl; j++) {
				
				newphoto.setPixel(k, j, photo.getPixel(i, j));
			}
		}
		
		return newphoto;
		
		//throw new RuntimeException("You'll implement this...");
	}



	public static Photograph makeDoubleWithMirror(Photograph photo) {
		
		Photograph newphoto1 = copy (photo);
		Photograph newphoto2 = mirrorIt (photo);
		Photograph returnphoto = new Photograph ( 2 *photo.getWd(), photo.getHt()); 
		//all changed was removed 2 * photo.getHt()
		
		int coll = photo.getWd();
		int rowl = photo.getHt();
		
		for (int i = 0, k = coll; i < coll && k < 2*coll; i++, k++) {
			
			for (int j = 0; j < rowl; j ++) {
				
				returnphoto.setPixel(i, j, newphoto2.getPixel(i, j));
				returnphoto.setPixel(k, j, newphoto1.getPixel(i, j));
			}
		}
		
		return returnphoto;
		//throw new RuntimeException("You'll implement this...");
	}



	//Challenges down here.

	public static Photograph rotated(Photograph photo) {
		
		Photograph newphoto = new Photograph (photo.getHt(), photo.getWd()); 
		//has to be opposite lengths of width and height cuz we rotating
		
		int coll = photo.getWd();
		int rowl = photo.getHt();
		
		for (int i = 0; i < coll; i ++) {
			
			for (int j = 0; j < rowl; j++) {
				
				newphoto.setPixel(j, rowl - 1 - i, photo.getPixel(i, j));
			}
		}
		
		return newphoto;
	}

	public static Photograph upsideDown(Photograph photo) {
		
		return rotated (rotated (photo));
		
		//throw new RuntimeException("You might implement this...");

		//DON'T FORGET - THIS ONE SHOULD BE ONE LINE OF CODE!
		//  THIS CHALLENGE INVOLVES MORE THINKING THAN CODING!
	}
	
	
	

	public static Photograph wacky(Photograph photo) {
		throw new RuntimeException("You might implement this...");

		//This one is just a place for you to explore ideas if you want to...
	}



}

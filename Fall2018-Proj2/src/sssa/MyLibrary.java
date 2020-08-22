package sssa;

import java.awt.Component;

public class MyLibrary {

	public static Integer isInteger(String s, int ifInvalid) {
		try { 
			return Integer.parseInt(s); 
		} catch(Exception e) { 
			return ifInvalid; 
		}
	}

	
	public static void displayError(Component parent, String message) {
		System.err.println(message);
		javax.swing.JOptionPane.showMessageDialog(parent, message);
	}

}

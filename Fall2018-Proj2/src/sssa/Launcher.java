package sssa;

public class Launcher {

    public static void main(String args[]) {
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuperSecretSpyApp().setVisible(true);
            }
        });
    }

}

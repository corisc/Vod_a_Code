package bwl.swing.basic;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    DeinFrame df = new DeinFrame();
    
    df.setTitle("Niklas");

    //df.getContentPane().add(mainPanel);
    df.setSize(1000, 800);
    df.setResizable(true);
    df.setVisible(true);
    
    df.addWindowListener(new WindowListener() {
        public void windowActivated(WindowEvent e){}
        public void windowClosed(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });


    
    
  }

}


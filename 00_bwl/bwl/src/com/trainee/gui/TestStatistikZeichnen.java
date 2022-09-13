package com.trainee.gui;

import javax.swing.JPanel;

public class TestStatistikZeichnen {

  public TestStatistikZeichnen()
  {
    // Aufruf ZeichenPanel
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}


/*
class EinfacheAnimation {
  int x = 40;
  int y = 40;
  int a = 40;
  int b = 180;
  
  public static void main(String[] args) {
    EinfacheAnimation gui = new EinfacheAnimation();
    System.out.println("los wird jetzt aufgerufen");
    gui.los();
  }
  public void los()
  { 
    JFrame frame = new JFrame();
    frame.setTitle("Bunte Linien zum Stern");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    MeinZeichenPanel meinZeichenPanel = new MeinZeichenPanel();
    frame.getContentPane().add(meinZeichenPanel);
    frame.setSize(300, 300);
    frame.setVisible(true);
    System.out.println("Panel erstellt, gesetzt");
    
    for (int i = 0; i < 140; i++)
    { x++; // nach rechts
      y++; // nach unten
      System.out.println("x+y inc");
      meinZeichenPanel.repaint();
      a++;
      b--;
      System.out.println("x inc y dec");
      meinZeichenPanel.repaint();
    }
  }
}
*/
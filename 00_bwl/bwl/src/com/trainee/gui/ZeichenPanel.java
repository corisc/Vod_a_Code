package com.trainee.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.*;

public class ZeichenPanel extends JFrame{
  
  AffineTransform FLIP_X_COORDINATE;
  
  public ZeichenPanel()
  {
    super("Koordinatensystem Test");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 300);
    FLIP_X_COORDINATE = new AffineTransform(1, 0, 0, -1, 0, getHeight());
    setVisible(true);
  }
  
  
  public static void main(String[] args) {
    new ZeichenPanel();
  }
  
  
  public void paint(Graphics graphics) {
      Graphics2D g = (Graphics2D) graphics;
//      g.transform(FLIP_X_COORDINATE);         // durchsichtig (test)
      g.setTransform(FLIP_X_COORDINATE);      // durchsichtig     // wenn weggelassen schraege linie von oben nach unten
      g.drawLine(0, 0, 250, 250);
//      g.fill3DRect(0, 0, 500, 700, true);       // Fenster ausfuellen (test)
  }
}

/* Koordinatensystem:
public class CoordinateSystemExample extends JFrame {
 
    final AffineTransform FLIP_X_COORDINATE;
 
    public CoordinateSystemExample() {
        super("CoordinateSystemExample");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        FLIP_X_COORDINATE = new AffineTransform(1, 0, 0, -1, 0, getHeight());
        setVisible(true);
    }

    public static void main(String[] args) {
        new CoordinateSystemExample();
    }
 
    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setTransform(FLIP_X_COORDINATE);
        g.drawLine(0, 0, 250, 250);
    }
}
*/

/* Punkte zeichnen
class MeinZeichenPanel extends JPanel
{ public void paintComponent(Graphics g)
  {
    g.setColor(Color.red);
    g.fillOval(x, y, 40, 40); // Kreis
    System.out.println("Graphic g erstellt");
    
    g.setColor(Color.orange);
    g.fillOval(a, b, 40, 40);
    System.out.println("Graphic e erstellt");
    
    g.setColor(Color.green);
    g.fillOval(110, b, 40, 40);
    
    g.setColor(Color.blue);
    g.fillOval(a, 110, 40, 40);
  }
}
*/
package com.ml.views;

import java.awt.*;

import javax.swing.JPanel;

public class Linie extends JPanel {

  private static final long serialVersionUID = -4126168345806373792L;
  
  int x1 = 0;
  int y1 = 100;
  int x2 = 0;
  int y2 = 100;
  float breite = 1;
  String farbe = null;
  
  public Linie(int x1, int y1, int x2, int y2, int breite, String farbe){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.breite = (float) breite;
    this.farbe = farbe;
  }

  public void paint(Graphics g) {
    Graphics2D g1 = (Graphics2D)g;
    g1.setStroke(new BasicStroke(this.breite));
    Color schreibColor = new HilfsKlasseFarbEntscheidung().farbeNachWort(this.farbe);
    g1.setColor(schreibColor);
    g1.drawLine(this.x1, this.y1, this.x2, this.y2);
    g1.setColor(Color.BLACK);
  }
} 
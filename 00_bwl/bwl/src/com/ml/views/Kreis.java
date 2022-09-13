package com.ml.views;

import java.awt.*;

import javax.swing.JPanel;

public class Kreis extends JPanel {

  private static final long serialVersionUID = -4126168345806373792L;
  
  int x1 = 0;
  int y1 = 100;
  int radius = 1;
  
  public Kreis(int x1, int y1, int radius){
    this.x1 = x1;
    this.y1 = y1;
    this.radius = (int) radius;
  }

  public void paint(Graphics g) {
    Graphics2D g1 = (Graphics2D)g;
    g1.setStroke(new BasicStroke(5));
    g1.drawOval(this.x1 - this.radius, this.y1 - this.radius, this.radius*2, this.radius*2);
  }
} 
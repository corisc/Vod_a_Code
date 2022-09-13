package com.ml.views;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javax.swing.JPanel;

public class TextGrafik extends JPanel {

  private static final long serialVersionUID = -4126168345806373792L;
  
  int x1 = 0;
  int y1 = 100;
  String text = "";
  int textSize = 11;
  boolean fett = false;
  String farbe = "schwarz";
  
  public TextGrafik(String text, int x1, int y1){
    this.x1 = x1;
    this.y1 = y1;
    this.text = text;
  }

  public TextGrafik(String text, int x1, int y1, String farbe){
    this.x1 = x1;
    this.y1 = y1;
    this.text = text;
    this.farbe = farbe;
  }

  public TextGrafik(String text, int x1, int y1, int textSize, boolean fett, String farbe){
    this.x1 = x1;
    this.y1 = y1;
    this.text = text;
    this.textSize = textSize;
    this.fett = fett;
    this.farbe = farbe;
    
  }

  public void paint(Graphics g) {
    Graphics2D g1 = (Graphics2D)g;
    g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    int dicke = Font.PLAIN;
    if(this.fett){
      dicke = Font.BOLD;
    }
    Font plainFont = new Font("Arial", dicke, this.textSize);
    AttributedString as = new AttributedString(this.text);
    as.addAttribute(TextAttribute.FONT, plainFont);
    Color malFarbe = new HilfsKlasseFarbEntscheidung().farbeNachWort(this.farbe);
    g1.setColor(malFarbe);
    g1.drawString(as.getIterator(), x1, y1);
    g1.setColor(Color.BLACK);
  }
} 
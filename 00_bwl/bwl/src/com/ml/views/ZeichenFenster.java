package com.ml.views;

import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * 
 * @author chrhof12069
 * 
 */
public class ZeichenFenster extends JFrame
{
  private static final long serialVersionUID = -4126168345806373794L;
  private static final String STANDARD_FARBE = "schwarz";
  
  private MainPanel       mainPanel;
  private TastenKeyListener myKeyListener = new TastenKeyListener();

  public ZeichenFenster(String titel, int breite, int hoehe){
    this(titel);
    this.setSize(breite, hoehe);
  }
  
  public ZeichenFenster(String titel)
  {
    this.mainPanel = new MainPanel();
    this.myKeyListener = new TastenKeyListener();
    this.setTitle(titel);
    this.addKeyListener(this.myKeyListener);

    this.getContentPane().add(mainPanel);
    this.setSize((int)BasicFenster.BREITE, (int)BasicFenster.HOEHE);
    this.setResizable(false);
    this.setVisible(true);

    this.addWindowListener(new WindowListener() {
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
  
  public char getNeuerTastendruck(){
    return this.myKeyListener.getLetzteGedrueckteTaste();
  }

  public long getNeueZeitTastendruck(){
    return this.myKeyListener.getLetzteGedrueckteZeit();
  }

  public void anzeigen()
  {
    this.setVisible(true);
  }
  
  public void loeschen(){
    synchronized(this.mainPanel){
      this.mainPanel.loeschen();
    }
  }

  public void allesBeenden(){
    this.setVisible(false);
    System.exit(1);
  }

  public void setzeGroesse(int breite, int hoehe)
  {
    this.setSize(breite, hoehe);
    this.setVisible(true);
  }

  /**
   *  LinieZeichen
   */
  
  public void linieZeichnen(double xa,double ya,double xb,double yb){
    ya = Monitor.rechneYUmAufNullPunkt(ya);
    yb = Monitor.rechneYUmAufNullPunkt(yb);
    this.mainPanel.addline(xa, ya, xb, yb, 1, STANDARD_FARBE);
  }
  
  public void linieZeichnen(double xa,double ya,double xb,double yb, int breite){
    ya = Monitor.rechneYUmAufNullPunkt(ya);
    yb = Monitor.rechneYUmAufNullPunkt(yb);
    this.mainPanel.addline(xa, ya, xb, yb, breite, STANDARD_FARBE);
  }

  public void linieZeichnen(double xa,double ya,double xb,double yb, String farbe){
    ya = Monitor.rechneYUmAufNullPunkt(ya);
    yb = Monitor.rechneYUmAufNullPunkt(yb);
    this.mainPanel.addline(xa, ya, xb, yb, 1, farbe);
  }

  public void linieZeichnen(double xa,double ya,double xb,double yb, int breite, String farbe){
    ya = Monitor.rechneYUmAufNullPunkt(ya);
    yb = Monitor.rechneYUmAufNullPunkt(yb);
    this.mainPanel.addline(xa, ya, xb, yb, breite, farbe);
  }

  /**
   *  Quadrat Zeichen
   */

  public void quadratZeichnen(double x,double y, double kantenlaenge){
    y = Monitor.rechneYUmAufNullPunkt(y);
    this.mainPanel.addline(x, y, x, y+kantenlaenge, 2, STANDARD_FARBE);
    this.mainPanel.addline(x, y+kantenlaenge, x+kantenlaenge, y+kantenlaenge, 2, STANDARD_FARBE);
    this.mainPanel.addline(x+kantenlaenge, y+kantenlaenge, x+kantenlaenge, y, 2, STANDARD_FARBE);
    this.mainPanel.addline(x+kantenlaenge, y, x, y, 2, STANDARD_FARBE);
  }

  /**
   *  Punkt Zeichen
   */

  public void punktZeichnen(double x,double y){
    y = Monitor.rechneYUmAufNullPunkt(y);

    this.mainPanel.addline(x - 1, y , x +1 , y, 1, STANDARD_FARBE);
    this.mainPanel.addline(x, y + 1 , x , y - 1, 1, STANDARD_FARBE);
  }
  
  /**
   *  Kreis Zeichen
   */
  public void kreisZeichnen(double x,double y, double radius){
    y = Monitor.rechneYUmAufNullPunkt(y);
    this.mainPanel.addKreis(x,y,radius);
  }

  /**
   *  Polygon zeichnen
   */
  public void polygonZeichnen(Farbe farbe, double ... punkte){
    this.mainPanel.addPolygon(farbe, punkte);
  }
  
  public void polygonZeichnen(int ebene, Farbe farbe, double ... punkte){
    this.mainPanel.addPolygon(ebene, farbe, punkte);
  }
  
  /**
   *  Text Zeichen
   */
  // MASTER
  // Master String
  private void masterZeichnen(Double zahlText, String text, double x,double y, int schriftgroesse, String farbe, boolean loeschbarFlag){
    y = Monitor.rechneYUmAufNullPunkt(y);
    if(text == null){
      try{
        text = "" + zahlText.toString();
      }
      catch(Exception e){
        text = "0";
      }
    }
    this.mainPanel.addText(text, x, y, schriftgroesse, false, farbe, loeschbarFlag); 
  }

  
  // String
  public void textZeichnen(String text, int x, int y){
    this.textZeichnen(text, (double)x, (double)y);
  }
  public void textZeichnen(String text, double x,double y){
    this.masterZeichnen(null, text, x, y, 12, "schwarz", false);
  }

  public void textZeichnen(String text, int x, int y, String farbe){
    this.textZeichnen(text, (double)x, (double)y, farbe);
  }
  public void textZeichnen(String text, double x,double y, String farbe){
    this.masterZeichnen(null, text, x, y, 12, farbe, false);
  }

  public void textZeichnen(String text, int x, int y, int schriftgroesse){
    this.textZeichnen(text, (double)x, (double)y, schriftgroesse);
  }
  public void textZeichnen(String text, double x,double y, int schriftgroesse){
    this.masterZeichnen(null, text, x, y, schriftgroesse, "schwarz", false);
  }

  public void textZeichnen(String text, int x, int y, int schriftgroesse, String farbe){
    this.textZeichnen(text, (double)x, (double)y, schriftgroesse, farbe);
  }
  public void textZeichnen(String text, double x,double y, int schriftgroesse, String farbe){
    this.masterZeichnen(null, text, x, y, schriftgroesse, farbe, false);
  }

  // String loeschbar
  public void loeschbarenTextZeichnen(String text, int x, int y){
    this.loeschbarenTextZeichnen(text, (double)x, (double)y);
  }
  public void loeschbarenTextZeichnen(String text, double x,double y){
    this.masterZeichnen(null, text, x, y, 12, "schwarz", true);
  }

  public void loeschbarenTextZeichnen(String text, int x, int y, String farbe){
    this.loeschbarenTextZeichnen(text, (double)x, (double)y, farbe);
  }
  public void loeschbarenTextZeichnen(String text, double x,double y, String farbe){
    this.masterZeichnen(null, text, x, y, 12, farbe, true);
  }

  public void loeschbarenTextZeichnen(String text, int x, int y, int schriftgroesse){
    this.loeschbarenTextZeichnen(text, (double)x, (double)y, schriftgroesse);
  }
  public void loeschbarenTextZeichnen(String text, double x,double y, int schriftgroesse){
    this.masterZeichnen(null, text, x, y, schriftgroesse, "schwarz", true);
  }

  public void loeschbarenTextZeichnen(String text, int x, int y, int schriftgroesse, String farbe){
    this.loeschbarenTextZeichnen(text, (double)x, (double)y, schriftgroesse, farbe);
  }
  public void loeschbarenTextZeichnen(String text, double x,double y, int schriftgroesse, String farbe){
    this.masterZeichnen(null, text, x, y, schriftgroesse, farbe, true);
  }
  
  // double
  public void textZeichnen(double text, int x, int y){
    this.textZeichnen(text, (double)x, (double)y);
  }
  public void textZeichnen(double text, double x,double y){
    this.masterZeichnen(text, null, x, y, 12, "schwarz", false);
  }

  public void textZeichnen(double text, int x, int y, String farbe){
    this.textZeichnen(text, (double)x, (double)y, farbe);
  }
  public void textZeichnen(double text, double x,double y, String farbe){
    this.masterZeichnen(text, null, x, y, 12, farbe, false);
  }

  public void textZeichnen(double text, int x, int y, int schriftgroesse){
    this.textZeichnen(text, (double)x, (double)y, schriftgroesse);
  }
  public void textZeichnen(double text, double x,double y, int schriftgroesse){
    this.masterZeichnen(text, null, x, y, schriftgroesse, "schwarz", false);
  }

  public void textZeichnen(double text, int x, int y, int schriftgroesse, String farbe){
    this.textZeichnen(text, (double)x, (double)y, schriftgroesse, farbe);
  }
  public void textZeichnen(double text, double x,double y, int schriftgroesse, String farbe){
    this.masterZeichnen(text, null, x, y, schriftgroesse, farbe, false);
  }

  // double loeschbar 
  public void loeschbarenTextZeichnen(double text, int x, int y){
    this.loeschbarenTextZeichnen(text, (double)x, (double)y);
  }
  public void loeschbarenTextZeichnen(double text, double x,double y){
    this.masterZeichnen(text, null, x, y, 12, "schwarz", true);
  }

  public void loeschbarenTextZeichnen(double text, int x, int y, String farbe){
    this.loeschbarenTextZeichnen(text, (double)x, (double)y, farbe);
  }
  public void loeschbarenTextZeichnen(double text, double x,double y, String farbe){
    this.masterZeichnen(text, null, x, y, 12, farbe, true);
  }

  public void loeschbarenTextZeichnen(double text, int x, int y, int schriftgroesse){
    this.loeschbarenTextZeichnen(text, (double)x, (double)y, schriftgroesse);
  }
  public void loeschbarenTextZeichnen(double text, double x,double y, int schriftgroesse){
    this.masterZeichnen(text, null, x, y, schriftgroesse, "schwarz", true);
  }

  public void loeschbarenTextZeichnen(double text, int x, int y, int schriftgroesse, String farbe){
    this.loeschbarenTextZeichnen(text, (double)x, (double)y, schriftgroesse, farbe);
  }
  public void loeschbarenTextZeichnen(double text, double x,double y, int schriftgroesse, String farbe){
    this.masterZeichnen(text, null, x, y, schriftgroesse, farbe, true);
  }

  public void loescheAlleTexte(){
    this.mainPanel.loescheTexte();
  }
  
  public void labelLoeschen(Label label){
    if(label == null){
      return;
    }
    this.mainPanel.loescheLabel(label);
  }

}

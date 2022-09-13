package com.ml.views;

import java.awt.*;
import java.util.Vector;

import javax.swing.JPanel;

public class Polygon extends JPanel {

  private static final long serialVersionUID = -4126168344806333792L;

  Vector<Integer> koordinaten = new Vector<Integer>();

  Farbe farbe = new Farbe(0, 0, 0);

  public Polygon(Farbe farbe, double ... x) {
    if (farbe == null) {
      System.out
          .println("ACHTUNG, Farbe ist nicht gueltig. Schwarz wird angenommen.");
    }
    else{
      this.farbe = farbe;
    }

    if (x == null) {
      System.out.println("ACHTUNG, Koordinaten sind nicht gesetzt.");
      this.koordinaten.add(1);
      this.koordinaten.add(1);
    }

    for (int t = 0; t < x.length; t++) {
      int xx = (int)Math.round(x[t]);
      if(t%2!=0){
        xx = Monitor.rechneYUmAufNullPunkt(xx);
      }
      this.koordinaten.add(xx);
    }

    if ((x.length % 2) != 0) {
      System.out
          .println("ACHTUNG, die Anzahl der x und y Koordinaten ist nicht gleich. 0 wird hinzugefuegt.");
      System.out.println(this.baueKoordinatenAusgabe(this.koordinaten));
      this.koordinaten.add(0);
    }

    int anzahlZumSchluss = this.koordinaten.size();
    if (this.koordinaten.get(0).intValue() != this.koordinaten.get(
        anzahlZumSchluss - 2).intValue()
        || this.koordinaten.get(1).intValue() != this.koordinaten.get(
            anzahlZumSchluss - 1).intValue()) {
      System.out.println("ACHTUNG, erster Punkt ("
          + this.koordinaten.get(0).intValue() + ","
          + Monitor.rechneYZurueckUmAufNullPunkt(koordinaten.get(1).intValue()) + ") ist nicht gleich letztem Punkt "
          + "(" + this.koordinaten.get(anzahlZumSchluss - 2) + ","
          + Monitor.rechneYZurueckUmAufNullPunkt(this.koordinaten.get(anzahlZumSchluss - 1).intValue()) + ")" + "\n"
          + "Wird automatisch ergaenzt");
      this.koordinaten.add(this.koordinaten.get(0).intValue());
      this.koordinaten.add(this.koordinaten.get(1).intValue());
    }
  }

  public void paint(Graphics g) {
    Graphics2D g1 = (Graphics2D) g;
    //g1.setStroke(new BasicStroke(5));
    g1.setColor(new Color(this.farbe.getR(), this.farbe.getG(), this.farbe
        .getB()));
    int xpoints[] = new int[this.koordinaten.size() / 2];
    int ypoints[] = new int[this.koordinaten.size() / 2];
    
    //System.out.println("this.koordinaten.size()" + this.koordinaten.size());
    
    for (int t = 0; t < this.koordinaten.size(); t = t + 2) {
      //System.out.println("t "+ t);
      xpoints[t/2] = this.koordinaten.get(t).intValue();
      ypoints[t/2] = this.koordinaten.get(t + 1).intValue();
    }
    int npoints = this.koordinaten.size()/2;

    g.fillPolygon(xpoints, ypoints, npoints);
  }

  private String baueKoordinatenAusgabe(Vector<Integer> x) {
    String result = "";
    String testY = "";
    int zeahler = 1;
    result = result + "Koordinaten (x/y):" + "\n";
    for (int t = 0; t < x.size(); t = t + 2) {
      if (t + 1 == x.size()) {
        testY = "fehlt !";
      } else {
        testY = "" + x.get(t + 1);
      }
      result = result + zeahler + " - (" + x.get(t) + "/" + testY + ")" + "\n";
      zeahler++;
    }
    return result;
  }
}
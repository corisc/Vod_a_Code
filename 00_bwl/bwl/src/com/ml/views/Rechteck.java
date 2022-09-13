package com.ml.views;

import java.util.Vector;

public class Rechteck {

  private int x;
  private int y;
  private int breite;
  private int hoehe;
  private Farbe farbe;
  private int linienBreite = 1;
  
  public Rechteck(int breite, int hoehe, Farbe farbe) {
    super();
    this.breite = breite;
    this.hoehe = hoehe;
    this.farbe = farbe;
  }

  public Rechteck(int breite, int hoehe, int linienBreite, Farbe farbe) {
    this(breite, hoehe, farbe);
    this.linienBreite = linienBreite;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getBreite() {
    return breite;
  }

  public int getHoehe() {
    return hoehe;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Farbe getFarbe() {
    return farbe;
  }

  public int getLinienBreite() {
    return linienBreite;
  }
  
  @Override
  public String toString(){
    String message = "\n";
    message = message + "x: " + this.x + "\n";
    message = message + "y: " + this.y + "\n";
    message = message + "breite: " + this.breite + "\n";
    message = message + "hoehe: " + this.hoehe + "\n";
    message = message + "farbe: " + this.farbe + "\n";
    message = message + "linienbreite: " + this.linienBreite + "\n";

    return message;
  }
  
}


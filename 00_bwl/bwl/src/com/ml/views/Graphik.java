package com.ml.views;

import java.util.Vector;

public class Graphik {

  private Vector<Double> werte = new Vector<Double>();
  private Vector<String> texte = new Vector<String>();
  
  public Graphik() {
  }
  
  public void wertHinzufuegen(double wert, String text){
    if(werte.size() > 20){
      System.out.println("Mehr als 20 Werte geht nicht");
      return;
    }
    
    if(text == null){
      text = "";
    }
    if(wert<0){
      wert = 0;
      System.out.println("Ein Wert mit Text " + text + " war kleiner 0 dies geht nicht in einem Balken");
    }
    this.werte.add(wert);
    this.texte.add(text);
  }

  public Vector<Double> getWerte() {
    return werte;
  }

  public void setWerte(Vector<Double> werte) {
    this.werte = werte;
  }

  public Vector<String> getTexte() {
    return texte;
  }

  public void setTexte(Vector<String> texte) {
    this.texte = texte;
  }
  
}


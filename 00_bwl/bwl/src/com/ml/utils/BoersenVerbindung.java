package com.ml.utils;

import java.util.Vector;

public class BoersenVerbindung {

  private String boerseOrt;
  private Vector<Kurs> kurse;
  private long zeitpunktLetzteAnfrage;
  private int kursAusgeliefertCounter = -1;
  
  public BoersenVerbindung(String boerse){
    this.boerseOrt = boerse;
    this.kurse = new Einleser().lesenDatenBestandEinUndSortiere("Dax");
    this.zeitpunktLetzteAnfrage = System.currentTimeMillis();
  }
  
  public double neuenKursHolen(){
    long aktuell = System.currentTimeMillis();
    while((aktuell-this.zeitpunktLetzteAnfrage)<1000){
      
      try {
        Thread.sleep(50);
      }
      catch (InterruptedException e){
        e.printStackTrace();
      }
      aktuell = System.currentTimeMillis();
    }
    this.kursAusgeliefertCounter++;
    this.zeitpunktLetzteAnfrage = System.currentTimeMillis();
    return kurse.get(this.kursAusgeliefertCounter).getWert();
  }

}


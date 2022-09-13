package com.ml.utils;

public class Kurs {
  
  private String    zeit;
  private double    wert;
  private long      unixZeit;
  
  public Kurs(String zeit, double wert, long unixZeit){
    this.zeit       = zeit;
    this.wert       = wert;
    this.unixZeit   = unixZeit;
  }

  public Kurs(String zeit, double wert){
    this.zeit       = zeit;
    this.wert       = wert;
  }

  public String getZeit() {
    return zeit;
  }

  public double getWert() {
    return wert;
  }

  public long getUnixZeit() {
    return unixZeit;
  }
  
  
  
  
  

}


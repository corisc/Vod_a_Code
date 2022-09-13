package com.ml.utils;

public class MatheHelfer {

  public MatheHelfer() {
    super();
  }
  
  public double quadratwurzel(double wert){
    return Math.sqrt(wert);
  }
  
  public double zumQuadrat(double wert){
    return Math.pow(wert, 2);    
  }
  
  public double absoluterWert(double wert){
    return Math.abs(wert);
  }
  
  public double liefereKleinerenWert(double ... werte){
    if(werte == null){
      System.out.println("Fehler! Keine Werte uebergeben worden.");
      return 0;
    }
    if(werte.length == 1){
      return werte[0];
    }
    double derKleinste = werte[0];
    for(int t=0;t<werte.length;t++){
      if(werte[t]<derKleinste){
        derKleinste = werte[t]; 
      }
    }
    return derKleinste;
  }

}


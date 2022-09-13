package com.ml.utils;

import bwl.main.auktionshaus2.Punkt;

import com.ml.views.DatenReihe;

public class MultiStreckenBerechner {
  
  public MultiStreckenBerechner(){};
  
  // kein Startpunkt
  public double punkteReiheBerechner(DatenReihe datenReihe){
    double result = 0;
    int sizeReihe = datenReihe.liefereZahlDerEintraege();
    Punkt start = new Punkt(0,0, "start");
    double zwErgebnis = 0;
    for(int t=1; t<sizeReihe; t=t+1){
      zwErgebnis = streckeBerechnen(datenReihe.holePunktAnStelle(t-1), datenReihe.holePunktAnStelle(t));
      result = result + zwErgebnis;
    }
    zwErgebnis = streckeBerechnen(datenReihe.holePunktAnStelle(0), start);
    result = result + zwErgebnis;
    zwErgebnis = streckeBerechnen(datenReihe.holePunktAnStelle(datenReihe.liefereZahlDerEintraege()-1), start);
    result = result + zwErgebnis;
    
    return result;
  }
  
  public double streckeBerechnen(Punkt p1, Punkt p2){
    double ergebnis = 0;
    double a = p1.x - p2.x;
    double b = p1.y - p2.y;
    MatheHelfer matheHelfer = new MatheHelfer();
    a = matheHelfer.absoluterWert(a);
    b = matheHelfer.absoluterWert(b);
    double cquadrat = matheHelfer.zumQuadrat(a) + matheHelfer.zumQuadrat(b);
    ergebnis = matheHelfer.quadratwurzel(cquadrat);
    
    return ergebnis;
  }


}


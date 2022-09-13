package bwl.oo.paket6;

import java.util.Random;
import java.util.Vector;

public class Filiale {
  
  private Besitzer besitzer;
  private String standort;

  public Filiale(Besitzer besitzer, String standort) {
    super();
    this.besitzer = besitzer;
    this.standort = standort;
  }
  
  public double liefereUmsatz(){
    Random rn = new Random();
    return rn.nextDouble() * 500 +1;
  }
  
  public Besitzer getBesitzer() {
    return besitzer;
  }
  
  public String getStandort() {
    return standort;
  }
  
  
  

}


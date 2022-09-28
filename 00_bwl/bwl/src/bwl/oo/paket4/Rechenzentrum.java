package bwl.oo.paket4;

import java.util.Vector;

public class Rechenzentrum {
  
  public String ort;
  public Angestellter leiter;
  public ITAbteilung abteilung;

  
  public Rechenzentrum(String ort, Angestellter leiter) {
    super();
    this.ort = ort;
    this.leiter = leiter;
  }
  public void setOrt(){
    this.ort = ort;
  }
  public String getOrt(){
    return ort;
  }
  public void setLeiter(){
    this.leiter = leiter;
  }
  public Angestellter getLeiter(){
    return leiter;
  }
  public void setAbteilung(){
    this.abteilung = abteilung;
  }
  public ITAbteilung getAbteilung(){
    return abteilung;
  }
  
}


package bwl.oo.paket1;

import java.util.Vector;

public class Tankstelle {
  
  public Paechter paechter;
  public Vector<Tankstelle> filiale = new Vector<Tankstelle>();
  public String standort;

  public Tankstelle(Paechter paechter, String standort) {
    super();
    this.paechter = paechter;
    this.standort = standort;
  }
  
  public void aenderePaechter(Paechter neuerPaechter){
    this.paechter = neuerPaechter;
  }
  
  public void fuegeFilialeHinzu(Tankstelle filiale){
    this.filiale.add(filiale);
  }
  
  public int wievieleFilialenHatDieseTankstelle(){
    return filiale.size();
  }
  
  public Tankstelle liefereFiliale(int filialNummer){
    if(filialNummer<1){
      System.out.println("Es gibt keine Filiale mit der Nummer: " + filialNummer);
      return null;
    }
    if(filialNummer>this.filiale.size()){
      System.out.println("Es gibt keine Filiale mit der Nummer: " + filialNummer);
      return null;
    }
    return filiale.get(filialNummer-1);
  }
  
  

}


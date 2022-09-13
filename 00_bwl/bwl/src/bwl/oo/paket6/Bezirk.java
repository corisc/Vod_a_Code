package bwl.oo.paket6;

import java.util.Vector;

public class Bezirk {

  public Vector<Filiale> filialen = new Vector<Filiale>();
  private String name;
  
  public Bezirk(String name){
    this.name = name;
  }
  
  public void fuegeFilialeHinzu(Filiale filiale){
    this.filialen.add(filiale);
  }
  
  public int wievieleFilialenHatDieserBezirk(){
    return filialen.size();
  }
  
  public Filiale liefereFiliale(String vorname, String nachname){
    for(Filiale fi : filialen){
      if(fi.getBesitzer().getVorname().equalsIgnoreCase(vorname) && fi.getBesitzer().getNachname().equalsIgnoreCase(nachname)){
        return fi;
      }
    }
    System.out.println("Unter dem Namen " + vorname + " " + nachname + " ist keine Filiale im Bezirk vorhanden");
    return null;
    
  }
  
  public String getName() {
    return name;
  }

  
}


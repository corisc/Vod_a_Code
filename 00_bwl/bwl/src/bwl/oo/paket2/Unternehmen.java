package bwl.oo.paket2;

import java.util.Vector;


public class Unternehmen {
  
  public String name;
  public Mitarbeiter geschaeftsfuehrer;
  public int eintragHandelsRegister;
  public Vector<Abteilung> abteilungen = new Vector<Abteilung>();
  public Vector<Projekt> projekte = new Vector<Projekt>();
    
  public int liefereWievieleAbteilungen(){
    return abteilungen.size();
  }
  
  public Abteilung liefereAbteilung(int abteilungsNummer){
    if(abteilungsNummer<1){
      System.out.println("Es gibt keine Abteilung mit der Nummer: " + abteilungsNummer);
      return null;
    }
    if(abteilungsNummer>this.abteilungen.size()){
      System.out.println("Es gibt keine Abteilung mit der Nummer: " + abteilungsNummer);
      return null;
    }
    return abteilungen.get(abteilungsNummer-1);
  }
  
  public void fuegeAbteilungHinzu(Abteilung abteilung){
    this.abteilungen.add(abteilung);
  }

  public int liefereWievieleProjekte(){
    return projekte.size();
  }
  
  public Projekt liefereProjekt(int projektNummer){
    if(projektNummer<1){
      System.out.println("Es gibt kein Projekt mit der Nummer: " + projektNummer);
      return null;
    }
    if(projektNummer>this.projekte.size()){
      System.out.println("Es gibt kein Projekt mit der Nummer: " + projektNummer);
      return null;
    }
    return projekte.get(projektNummer-1);
  }
  
  public void fuegeProjektHinzu(Projekt projekt){
    this.projekte.add(projekt);
  }

  
  public Unternehmen(String name, Mitarbeiter geschaeftsfuehrer,
      int eintragHandelsRegister) {
    super();
    this.name = name;
    this.geschaeftsfuehrer = geschaeftsfuehrer;
    this.eintragHandelsRegister = eintragHandelsRegister;
  }
  
  public int liefereAnzahlDerMitarbeiter(){
    int anzahlMitarbeiter = 0;
    int anzahlDerAbteilungen = liefereWievieleAbteilungen();
    for(int t=1; t<=anzahlDerAbteilungen; t=t+1){
      anzahlMitarbeiter = anzahlMitarbeiter + liefereAbteilung(t).liefereAnzahlMitarbeiter();
    }
    anzahlMitarbeiter = anzahlMitarbeiter + 2;
    return anzahlMitarbeiter;
  }


}


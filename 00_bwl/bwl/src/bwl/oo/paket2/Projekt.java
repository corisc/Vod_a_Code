package bwl.oo.paket2;

import java.util.Vector;

public class Projekt {
  
  public String titel;
  public Mitarbeiter projektLeiter;
  public Vector<Aufgabe> aufgaben = new Vector<Aufgabe>();
  
  public int liefereAnzahlAufgaben(){
    return aufgaben.size();
  }
  
  public Aufgabe liefereAufgabe(int aufgabenNummer){
    if(aufgabenNummer<1){
      System.out.println("Es gibt keine Aufgabe mit der Nummer: " + aufgabenNummer);
      return null;
    }
    if(aufgabenNummer>this.aufgaben.size()){
      System.out.println("Es gibt keine Aufgabe mit der Nummer: " + aufgabenNummer);
      return null;
    }
    return aufgaben.get(aufgabenNummer-1);
  }
  
  public void fuegeAufgabeHinzu(Aufgabe aufgabe){
    this.aufgaben.add(aufgabe);
  }

  public Projekt(String titel, Mitarbeiter projektLeiter) {
    super();
    this.titel = titel;
    this.projektLeiter = projektLeiter;
  }
  
  public double liefereAufwandGesamt(){
    double gesamt = 0;
    for(int t=1; t<liefereAnzahlAufgaben(); t=t+1){
      gesamt = gesamt + liefereAufgabe(t).aufwandStunden;
    }
    return gesamt;
  }
  
}


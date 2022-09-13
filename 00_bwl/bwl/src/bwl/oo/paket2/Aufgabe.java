package bwl.oo.paket2;

public class Aufgabe {
  
  public String titel;
  public String beschreibung;
  public Mitarbeiter verantwortlicher;
  public double aufwandStunden = 0;
  
  public Aufgabe(String titel, Mitarbeiter verantwortlicher) {
    super();
    this.titel = titel;
    this.verantwortlicher = verantwortlicher;
  }
  
  

}


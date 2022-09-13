package bwl.oo.paket2;

import java.util.Vector;

public class Abteilung {
  
  public String name;
  public Mitarbeiter abteilungsLeiter;
  public Vector<Mitarbeiter> mitarbeiter = new Vector<Mitarbeiter>();
  
  public int liefereAnzahlMitarbeiter(){
    return mitarbeiter.size();
  }
  
  public Mitarbeiter liefereMitarbeiter(int mitarbeiterNummer){
    if(mitarbeiterNummer<1){
      System.out.println("Es gibt keinen Mitarbeiter mit der Nummer: " + mitarbeiterNummer);
      return null;
    }
    if(mitarbeiterNummer>this.mitarbeiter.size()){
      System.out.println("Es gibt keinen Mitarbeiter mit der Nummer: " + mitarbeiterNummer);
      return null;
    }
    return mitarbeiter.get(mitarbeiterNummer-1);
  }
  
  public void fuegeMitarbeiterHinzu(Mitarbeiter mitarbeiter){
    this.mitarbeiter.add(mitarbeiter);
  }

  public Abteilung(String name, Mitarbeiter abteilungsLeiter) {
    super();
    this.name = name;
    this.abteilungsLeiter = abteilungsLeiter;
  }


}


package bwl.oo.paket9;

import java.util.ArrayList;
import java.util.Vector;

public class Wahlkreis {

  public int nummer;
  public String name;
  private Vector<Abgeordneter> abgeordnete = new Vector<Abgeordneter>();
  private Person wahlleiter;
  private ArrayList<Waehler> waehler;

  public Wahlkreis(int nummer, String name, Person wahlleiter) {
    this.name = name;
    this.nummer = nummer;
    this.wahlleiter = wahlleiter;
    this.waehler = new ArrayList<Waehler>();

  }

  // ABGEORDNETER

  public int lieferAnzahlAbgeordnete() {
    return abgeordnete.size();
  }

  public void fuegeAbgeordnetenhinzu(Abgeordneter abgeordneter) {
    this.abgeordnete.add(abgeordneter);
  }

  public Abgeordneter holeAbgeordneten(String vorname) {
    for (Abgeordneter aktuellerAbgeordneter : this.abgeordnete) {
      if (aktuellerAbgeordneter.liefereVorname().equalsIgnoreCase(vorname)) {
        return aktuellerAbgeordneter;
      }
    }

    System.out.println("Sie haben nach einem Abgeordneten namens: " + vorname
        + " gesucht. Dieser ist nicht vorhanden");
    return null;

  }

  public Abgeordneter liefereAbgeordneten(int abgeordneterSortiertNachAnlage) {
    if (abgeordneterSortiertNachAnlage < 1) {
      System.out.println("Es gibt keinen Abgeordneten mit der Nummer: "
          + abgeordneterSortiertNachAnlage);
      return null;
    }
    if (abgeordneterSortiertNachAnlage > this.abgeordnete.size()) {
      System.out.println("Es gibt keinen Abgeordneten mit der Nummer: "
          + abgeordneterSortiertNachAnlage);
      return null;
    }
    return abgeordnete.get(abgeordneterSortiertNachAnlage - 1);
  }

  //WAHLLEITER
  
  public Person liefereWahlleiter() {
    return wahlleiter;
  }
  
  public void setzeWahlleiter(Person wahlleiterNeu){
    this.wahlleiter = wahlleiterNeu;
  }
  
  //WAEHLER
  
  public int liefereWaehlerAnzahl(){
    int anzahl = 0;
    for(int i=0; i < waehler.size(); i++)
    {
      anzahl++;
    }
    return anzahl;
  }
  
  public void fuegeWaehlerhinzu(Waehler w){
    waehler.add(w);
  }
  
  public Waehler holeWaehler(String vorname){
    for(int i=0; i < waehler.size(); i++)
    {
      if(waehler.get(i).liefereVorname().equalsIgnoreCase(vorname));
      {
        return waehler.get(i);
      } 
    }
    return null;
  }
  
  public Waehler liefereWaehler(int waehlerSortiertNachAnlage) {
      if (waehlerSortiertNachAnlage < 1) {
        System.out.println("Es gibt keinen Mitglied mit der Nummer: "
            + waehlerSortiertNachAnlage);
        return null;
      }
      if (waehlerSortiertNachAnlage > this.waehler.size()) {
        System.out.println("Es gibt kein Mitglied mit der Nummer: "
            + waehlerSortiertNachAnlage);
        return null;
      }
      return waehler.get(waehlerSortiertNachAnlage - 1);
    }
  
 
}

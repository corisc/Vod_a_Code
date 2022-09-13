package bwl.oo.paket9;

import java.util.ArrayList;

public class Landesparlament {
  
  private ArrayList<Abgeordneter> mitglieder = new ArrayList<Abgeordneter>();
  private Landtagspraesident praesident;
  
  //////////////////////////////////////////////////////////////////
  public Landesparlament(Landtagspraesident praesident) {
	  this.praesident = praesident;
  }
  
  
  public int lieferAnzahlAbgeordnete() {
    return mitglieder.size();
  }

  public void fuegeAbgeordnetenhinzu(Abgeordneter mitglied) {
    this.mitglieder.add(mitglied);
  }

  public Abgeordneter holeAbgeordneten(String vorname) {
    for (Abgeordneter aktuellesMitglied : this.mitglieder) {
      if (aktuellesMitglied.liefereVorname().equalsIgnoreCase(vorname)) {
        return aktuellesMitglied;
      }
    }

    System.out.println("Sie haben nach einem Mitglied namens: " + vorname
        + " gesucht. Dieser ist nicht vorhanden");
    return null;
  }

  public Abgeordneter liefereAbgeordneten(int abgeordneterSortiertNachAnlage) {
    if (abgeordneterSortiertNachAnlage < 1) {
      System.out.println("Es gibt keinen Mitglied mit der Nummer: "
          + abgeordneterSortiertNachAnlage);
      return null;
    }
    if (abgeordneterSortiertNachAnlage > this.mitglieder.size()) {
      System.out.println("Es gibt kein Mitglied mit der Nummer: "
          + abgeordneterSortiertNachAnlage);
      return null;
    }
    return mitglieder.get(abgeordneterSortiertNachAnlage - 1);
  }
  
  public Landtagspraesident liefereLandtagspraesident() {
	  return praesident;
  }
  public void setzeLandtagspraesident(Landtagspraesident praesident) {
	  this.praesident = praesident;
  }
}

package bwl.oo.paket9;

import java.util.ArrayList;

public class Bundesrat {

	private ArrayList<Bundesratsabgeordneter> bundesratsabgeordneter;
	private Bundesratspraesident praesident;
	

    public Bundesrat(Bundesratspraesident praesident) {
        this.bundesratsabgeordneter = new ArrayList<Bundesratsabgeordneter>();
        this.praesident = praesident;
      }
    public Bundesrat(ArrayList<Bundesratsabgeordneter> bundesratsabgeordneter, Bundesratspraesident praesident) {
      this.bundesratsabgeordneter = bundesratsabgeordneter;
      this.praesident = praesident;
    }
   
    public void fuegeBundesratsabgeordnetenhinzu(Bundesratsabgeordneter abgeordneter) {
      bundesratsabgeordneter.add(abgeordneter);
    }
    
    public boolean artikelBeschlossen() {
      return Math.random()<0.5;
    }
     //////////////////////////////////////////////////////////////////
    
    public int lieferAnzahlBundesratsabgeordnete() {
      return bundesratsabgeordneter.size();
    }

    public Bundesratsabgeordneter holeBundesratsabgeordneten(String vorname) {
      for (Bundesratsabgeordneter aktuellerBundesratsabgeordneter : this.bundesratsabgeordneter) {
        if (aktuellerBundesratsabgeordneter.liefereVorname().equalsIgnoreCase(vorname)) {
          return aktuellerBundesratsabgeordneter;
        }
      }

      System.out.println("Sie haben nach einem Mitglied namens: " + vorname
          + " gesucht. Dieser ist nicht vorhanden");
      return null;

    }

    public Bundesratsabgeordneter liefereBundesratsabgeordneten(int abgeordneteSortiertNachAnlage) {
      if (abgeordneteSortiertNachAnlage < 1) {
        System.out.println("Es gibt keinen Abgeordneten mit der Nummer: "
            + abgeordneteSortiertNachAnlage);
        return null;
      }
      if (abgeordneteSortiertNachAnlage > this.bundesratsabgeordneter.size()) {
        System.out.println("Es gibt keinen Abgeordneten mit der Nummer: "
            + abgeordneteSortiertNachAnlage);
        return null;
      }
      return bundesratsabgeordneter.get(abgeordneteSortiertNachAnlage - 1);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Bundesratsabgeordneter> liefereBundesratsabgeordnete() {
      return bundesratsabgeordneter;
    }
    public void setzeBundesratsabgeordnete(ArrayList<Bundesratsabgeordneter> abgeordnete) {
      this.bundesratsabgeordneter = abgeordnete;
    }
    public Bundesratspraesident lieferePraesident() {
      return praesident;
    }
    public void setzePraesident(Bundesratspraesident praesident) {
      this.praesident = praesident;
    }
	
	
}

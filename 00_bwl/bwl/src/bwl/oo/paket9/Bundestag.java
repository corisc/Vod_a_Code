package bwl.oo.paket9;

import java.util.ArrayList;

public class Bundestag {
	////////////////////////////////////////////////////////////////CHANGED////////////////////////////////////////////////////////////////////////
	
	private ArrayList<GekoreneMitgliederBundestag> mitglieder = new ArrayList<GekoreneMitgliederBundestag>();
	private Bundestagspraesident bundestagspraesident;
	

	public ArrayList<Partei> vertreteneParteien() {
	  ArrayList<Partei> parteien = new ArrayList<Partei>();
	  for(int i=0; i<mitglieder.size(); i++) {
	    boolean vorhanden = false;
	    for(Partei p : parteien) {
	      vorhanden = p.liefereName().equalsIgnoreCase(mitglieder.get(i).lieferePartei().liefereName());
	    }
	    if(!vorhanden)
	      parteien.add(mitglieder.get(i).lieferePartei());
	    vorhanden = false;
	  }
	  return parteien;
	}
	
	public Bundeskanzler waehleBundeskanzler(ArrayList<Parteimitglied> anwaerter){
	  int gewaehlt = (int) (Math.random()*anwaerter.size());
	  Parteimitglied p = anwaerter.get(gewaehlt);
	  Bundeskanzler bk = new Bundeskanzler(p.liefereVorname(), p.liefereNachname(), p.liefereAdresse(), 0);
	  return bk;
	}
	
	public boolean artikelBeschlossen() {
      return Math.random()<0.6;
    }
	

    //////////////////////////////////////////////////////////////////
    
    public int lieferAnzahlMitglieder() {
      return mitglieder.size();
    }

    public void fuegeMitgliedhinzu(GekoreneMitgliederBundestag mitglied) {
      this.mitglieder.add(mitglied);
    }

    public GekoreneMitgliederBundestag holeMitglied(String vorname) {
      for (GekoreneMitgliederBundestag aktuellesMitglied : this.mitglieder) {
        if (aktuellesMitglied.liefereVorname().equalsIgnoreCase(vorname)) {
          return aktuellesMitglied;
        }
      }

      System.out.println("Sie haben nach einem Mitglied namens: " + vorname
          + " gesucht. Dieser ist nicht vorhanden");
      return null;

    }

    public GekoreneMitgliederBundestag liefereMitglied(int mitgliederSortiertNachAnlage) {
      if (mitgliederSortiertNachAnlage < 1) {
        System.out.println("Es gibt keinen Mitglied mit der Nummer: "
            + mitgliederSortiertNachAnlage);
        return null;
      }
      if (mitgliederSortiertNachAnlage > this.mitglieder.size()) {
        System.out.println("Es gibt kein Mitglied mit der Nummer: "
            + mitgliederSortiertNachAnlage);
        return null;
      }
      return mitglieder.get(mitgliederSortiertNachAnlage - 1);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<GekoreneMitgliederBundestag> liefereMitglieder() {
      return mitglieder;
    }
  
    public void setzeMitglieder(ArrayList<GekoreneMitgliederBundestag> mitglieder) {
      this.mitglieder = mitglieder;
    }
  
    public Bundestagspraesident liefereBundestagspraesident() {
      return bundestagspraesident;
    }
  
    public void setzeBundestagspraesident(Bundestagspraesident bundestagspraesident) {
      this.bundestagspraesident = bundestagspraesident;
    }
}

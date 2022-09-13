package bwl.oo.paket9;

import java.util.ArrayList;
import java.util.Vector;

public class Landkreis {

  private String name;
  private ArrayList<Stadt> staedte;
  private int nummer;
  private int einwohnerzahl;

  public Landkreis(String name, int nummer) {
    this.name = name;
    this.nummer = nummer;
    this.staedte = new ArrayList<Stadt>();
  }
  
  public Landkreis(String name, int nummer, int einwohnerzahl) {
	this.name = name;
	this.nummer = nummer;
	this.einwohnerzahl = einwohnerzahl;
	this.staedte = new ArrayList<Stadt>();
  }
  
  public int liefereEinwohnerzahl() {
	  return einwohnerzahl;
  }
  public void setzeEinwohnerzahl(int einwohnerzahl) {
	  this.einwohnerzahl = einwohnerzahl;
  }
  
  public void setzeNummer(int nummer) {
	  this.nummer = nummer;
  }
  public int liefereNummer() {
	  return nummer;
  }
  
  public void setzeName(String name) {
	  this.name = name;
  }
  public String liefereName() {
	  return name;
  }
  
  public void fuegeStadtHinzu(Stadt stadt) {
	  staedte.add(stadt);
  }
  
  public Stadt liefereStadt(int stadtSortiertNachAnlage) {
	  if (stadtSortiertNachAnlage < 1) {
	    System.out.println("Es gibt in dem Landkreis keine Stadt mit der Nummer: "
	        + stadtSortiertNachAnlage);
	    return null;
	  }
	  if (stadtSortiertNachAnlage > this.staedte.size()) {
	    System.out.println("Es gibt in dem Landkreis keine Stadtmit der Nummer: "
	        + stadtSortiertNachAnlage);
	    return null;
	  }
	  return staedte.get(stadtSortiertNachAnlage - 1);
  }
  
  public Stadt holeStadt(String name) {
	  for (Stadt aktuelleStadt : this.staedte) {
	  if (aktuelleStadt.name.equalsIgnoreCase(name)) {
	    return aktuelleStadt;
	  }
	}

	System.out.println("Sie haben nach der Stadt: " + name
	        + " gesucht. Diese ist nicht vorhanden");
	return null;
  }
  
  public ArrayList<Stadt> liefereStaedte() {
	return staedte;
  }

  public void setzeStaedte(ArrayList<Stadt> staedte) {
    this.staedte = staedte;
  }
}

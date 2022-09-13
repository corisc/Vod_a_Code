package bwl.oo.paket9;

import java.util.ArrayList;

public class Partei {

	private String name;
	private ArrayList<Parteimitglied> mitglieder;
  
  public Partei(String name) {
    this.name = name;
    mitglieder = new ArrayList<Parteimitglied>();
  }
  public Partei(String name, ArrayList<Parteimitglied> mitglieder) {
    this.name = name;
    this.mitglieder = mitglieder;
  }
  
  public void fuegeMitgliederhinzu(Parteimitglied mitglied) {
    mitglieder.add(mitglied);
  }
  
  public String liefereName() {
    return name;
  }
  public void setzeName(String name) {
    this.name = name;
  }
  public Parteimitglied liefereMitglied(int mitgliedSortiertNachAnlage) {
	  if (mitgliedSortiertNachAnlage < 1) {
	    System.out.println("Es gibt kein Parteimitglied mit der Nummer: "
	        + mitgliedSortiertNachAnlage);
	    return null;
	  }
	  if (mitgliedSortiertNachAnlage > this.mitglieder.size()) {
	    System.out.println("Es gibt kein Parteimitglied mit der Nummer: "
	        + mitgliedSortiertNachAnlage);
	    return null;
	  }
	  return mitglieder.get(mitgliedSortiertNachAnlage - 1);
	}
  
  public ArrayList<Parteimitglied> liefereMitglieder() {
    return mitglieder;
  }
  public void setzeMitglieder(ArrayList<Parteimitglied> mitglieder) {
    this.mitglieder = mitglieder;
  }
  
}

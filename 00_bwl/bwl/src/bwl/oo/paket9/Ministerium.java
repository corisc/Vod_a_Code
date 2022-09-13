package bwl.oo.paket9;

import java.util.ArrayList;

public class Ministerium {
	private String name;
	private Minister leitenderMinister;
	private ArrayList<Person> mitarbeiter = new ArrayList<Person>();
	
  	public Ministerium(String name, Minister leitenderMinister) {
      super();
      this.name = name;
      this.leitenderMinister = leitenderMinister;
    }
  	
  	public String liefereName() {
      return name;
    }

    public void setzeAlleMitarbeiter(String name) {
      this.name = name;
    }
  	
    public void fuegeMitarbeiterhinzu(Person p) {
  	  mitarbeiter.add(p);
  	}

    public Minister liefereLeitenderMinister() {
      return leitenderMinister;
    }

    public void setzeLeitenderMinister(Minister leitenderMinister) {
      this.leitenderMinister = leitenderMinister;
    }

    
    public Person liefereMitarbeiter(int mitarbeiterSortiertNachAnlage) {
  	  if (mitarbeiterSortiertNachAnlage < 1) {
  	    System.out.println("Es gibt kein Parteimitglied mit der Nummer: "
  	        + mitarbeiterSortiertNachAnlage);
  	    return null;
  	  }
  	  if (mitarbeiterSortiertNachAnlage > this.mitarbeiter.size()) {
  	    System.out.println("Es gibt kein Parteimitglied mit der Nummer: "
  	        + mitarbeiterSortiertNachAnlage);
  	    return null;
  	  }
  	  return mitarbeiter.get(mitarbeiterSortiertNachAnlage - 1);
  	}
    
    public ArrayList<Person> liefereAlleMitarbeiter() {
      return mitarbeiter;
    }

    public void setzeAlleMitarbeiter(ArrayList<Person> mitarbeiter) {
      this.mitarbeiter = mitarbeiter;
    }
}

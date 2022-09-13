package bwl.oo.paket9;

import java.util.ArrayList;

public class Senat {

    private String typ;
    private ArrayList<Richter> mitglieder = new ArrayList<Richter>();
  
    public Senat(String typ, ArrayList<Richter> mitglieder) {
      super();
      this.typ = typ;
      this.mitglieder = mitglieder;
    }
    
    public String liefereTyp() {
      return typ;
    }
    
    public void setzeTyp(String typ) {
      this.typ = typ;
    }
    
    public void fuegeMitgliedhinzu(Richter mitglied) {
      mitglieder.add(mitglied);
    }
    
    public Richter liefereMitglied(int mitgliedSortiertNachAnlage) {
  	  if (mitgliedSortiertNachAnlage < 1) {
  	    System.out.println("Es gibt keinen Richter im Senat mit der Nummer: "
  	        + mitgliedSortiertNachAnlage);
  	    return null;
  	  }
  	  if (mitgliedSortiertNachAnlage > this.mitglieder.size()) {
  	    System.out.println("Es gibt kein Sichter im Senat mit der Nummer: "
  	        + mitgliedSortiertNachAnlage);
  	    return null;
  	  }
  	  return mitglieder.get(mitgliedSortiertNachAnlage - 1);
  	}
  
    public ArrayList<Richter> liefereMitglieder() {
      return mitglieder;
    }
  
    public void setzeMitglieder(ArrayList<Richter> mitglieder) {
      this.mitglieder = mitglieder;
    }
}

package bwl.oo.paket9;

import java.util.ArrayList;

public class Kammer {
  
    private String typ;
	private ArrayList<Richter> mitglieder = new ArrayList<Richter>();

	 public Kammer(String typ) {
      super();
      this.typ = typ;
      this.mitglieder = new ArrayList<Richter>();
    }
    public Kammer(String typ, ArrayList<Richter> mitglieder) {
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

    public Richter liefereMitglied(int mitgliederSortiertNachAnlage) {
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
    
    public ArrayList<Richter> liefereMitglieder() {
      return mitglieder;
    }

    public void setzeMitglieder(ArrayList<Richter> mitglieder) {
      this.mitglieder = mitglieder;
    }
    
}

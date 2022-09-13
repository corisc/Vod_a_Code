package bwl.oo.paket9;

import java.util.ArrayList;

public class Gesetzbuch {

	private ArrayList<Gesetz> gesetze;

	public Gesetzbuch() {
	    gesetze = new ArrayList<Gesetz>();
	}
	
    public Gesetzbuch(ArrayList<Gesetz> gesetze) {
      super();
      this.gesetze = gesetze;
    }
    
    public void fuegeGesetzhinzu(Gesetz gesetz)
    {
      gesetze.add(gesetz);
    }
    
    public Gesetz liefereGesetz(int gesetzSortiertNachAnlage) {
	    if (gesetzSortiertNachAnlage < 1) {
	      System.out.println("Es gibt kein Gesetz mit der Nummer: "
	          + gesetzSortiertNachAnlage);
	      return null;
	    }
	    if (gesetzSortiertNachAnlage > this.gesetze.size()) {
	      System.out.println("Es gibt kein Gesetz mit der Nummer: "
	          + gesetzSortiertNachAnlage);
	      return null;
	    }
	    return gesetze.get(gesetzSortiertNachAnlage - 1);
	  }
    
    public ArrayList<Gesetz> liefereGesetze() {
      return gesetze;
    }
 
}

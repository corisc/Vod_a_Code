package bwl.oo.paket9;

import java.util.ArrayList;

public class Bundesverfassungsgericht {

	private Stadt sitz;
	private Grundgesetz grundgesetz;
	private ArrayList<Senat> senate = new ArrayList<Senat>();
	private ArrayList<Kammer> kammern = new ArrayList<Kammer>();
	private Bundesverfassungsgerichtspraesident praesident;
	
	
  	public Bundesverfassungsgericht(Stadt sitz, Grundgesetz grundgesetz, Bundesverfassungsgerichtspraesident praesident) {
      this.sitz = sitz;
      this.grundgesetz = grundgesetz;
    }

  	public void fuegeSenathinzu(Senat senat) {
		if(senate.size() <= 2) {
			senate.add(senat);
		}
	}
	
	public void fuegeKammerhinzu(Kammer kammer) {
		if(kammern.size() <= 7) {
			kammern.add(kammer);
		}
	}

    public Stadt liefereSitz() {
      return sitz;
    }
    public void setzeSitz(Stadt sitz) {
      this.sitz = sitz;
    }
    public Grundgesetz liefereGrundgesetz() {
      return grundgesetz;
    }
    public void setzeGrundgesetz(Grundgesetz grundgesetz) {
      this.grundgesetz = grundgesetz;
    }
  
    public Senat liefereSenat(int senatSortiertNachAnlage) {
        if (senatSortiertNachAnlage < 1) {
          System.out.println("Es gibt keinen Mitglied mit der Nummer: "
              + senatSortiertNachAnlage);
          return null;
        }
        if (senatSortiertNachAnlage > this.senate.size()) {
          System.out.println("Es gibt kein Mitglied mit der Nummer: "
              + senatSortiertNachAnlage);
          return null;
        }
        return senate.get(senatSortiertNachAnlage - 1);
    }
    
    public ArrayList<Senat> liefereSenate() {
      return senate;
    }
  
    public void setzeSenate(ArrayList<Senat> senate) {
      this.senate = senate;
    }
  
    public Kammer liefereKammer(int kammerSortiertNachAnlage) {
        if (kammerSortiertNachAnlage < 1) {
          System.out.println("Es gibt keinen Mitglied mit der Nummer: "
              + kammerSortiertNachAnlage);
          return null;
        }
        if (kammerSortiertNachAnlage > this.kammern.size()) {
          System.out.println("Es gibt kein Mitglied mit der Nummer: "
              + kammerSortiertNachAnlage);
          return null;
        }
        return kammern.get(kammerSortiertNachAnlage - 1);
    }
    public ArrayList<Kammer> liefereKammern() {
      return kammern;
    }
  
    public void setzeKammern(ArrayList<Kammer> kammern) {
      this.kammern = kammern;
    }
    
    public Bundesverfassungsgerichtspraesident lieferePraesident() {
        return praesident;
      }
      public void setzePraesident(Bundesverfassungsgerichtspraesident praesident) {
        this.praesident = praesident;
      }

	
}

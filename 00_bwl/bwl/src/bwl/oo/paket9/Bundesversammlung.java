package bwl.oo.paket9;

import java.util.ArrayList;

public class Bundesversammlung {

	private int anzahlMitglieder;

    public Bundesversammlung(int anzahlMitglieder) {
      super();
      this.anzahlMitglieder = anzahlMitglieder;
    }
    
    public Bundespraesident waehleBundespraesident(ArrayList<Parteimitglied> anwaerter){
      int gewaehlt = (int) (Math.random()*anwaerter.size());
      Parteimitglied p = anwaerter.get(gewaehlt);
      Bundespraesident bp = new Bundespraesident(p.liefereVorname(), p.liefereNachname(), p.liefereAdresse(), 0);
      return bp;
    }

    public int liefereAnzahlMitglieder() {
      return anzahlMitglieder;
    }

    public void setzeAnzahlMitglieder(int anzahlMitglieder) {
      this.anzahlMitglieder = anzahlMitglieder;
    }
    
}

package bwl.oo.paket9;

import java.util.ArrayList;

public class Bundesregierung {

	private ArrayList<Minister> bundesminister = new ArrayList<Minister>();
	private Bundeskanzler bundeskanzler;
	
	
    public Bundesregierung(Bundeskanzler bundeskanzler) {
      this.bundeskanzler = bundeskanzler;
    }


    
    ///////////////////////////////////////////////////////////////////////////////////
    
    public int lieferAnzahlBundesminister() {
      return bundesminister.size();
    }

    public void fuegeBundesministerhinzu(Minister minister) {
      this.bundesminister.add(minister);
    }

    public Minister holeBundesminister(String vorname) {
      for (Minister aktuellerBundesminister : this.bundesminister) {
        if (aktuellerBundesminister.liefereVorname().equalsIgnoreCase(vorname)) {
          return aktuellerBundesminister;
        }
      }

      System.out.println("Sie haben nach einem Bundesminister namens: " + vorname
          + " gesucht. Dieser ist nicht vorhanden");
      return null;

    }

    public Minister liefereBundesminister(int bundesministerSortiertNachAnlage) {
      if (bundesministerSortiertNachAnlage < 1) {
        System.out.println("Es gibt keinen Bundesminister mit der Nummer: "
            + bundesministerSortiertNachAnlage);
        return null;
      }
      if (bundesministerSortiertNachAnlage > this.bundesminister.size()) {
        System.out.println("Es gibt kein Bundesminister mit der Nummer: "
            + bundesministerSortiertNachAnlage);
        return null;
      }
      return bundesminister.get(bundesministerSortiertNachAnlage - 1);
    }
    
   //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Minister> liefereAlleBundesminister() {
      return bundesminister;
    }
    public void setzeAlleBundesminister(ArrayList<Minister> bundesminister) {
      this.bundesminister = bundesminister;
    }


    public Bundeskanzler liefereBundeskanzler() {
      return bundeskanzler;
    }
    public void setzeBundeskanzler(Bundeskanzler bundeskanzler) {
      this.bundeskanzler = bundeskanzler;
    }
}

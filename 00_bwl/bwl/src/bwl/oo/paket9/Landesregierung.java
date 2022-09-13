package bwl.oo.paket9;

import java.util.ArrayList;

public class Landesregierung {
    private Regierungschef regierungschef;
    private ArrayList<Minister> minister = new ArrayList<Minister>();
    
    public Landesregierung(Regierungschef regierungschef) {
      super();
      this.regierungschef = regierungschef;
      this.minister = minister;
    }
    

     //////////////////////////////////////////////////////////////////
    
    public int liefereAnzahlMinister() {
      return minister.size();
    }

    public void fuegeMinisterhinzu(Minister mitglied) {
      this.minister.add(mitglied);
    }

    public Minister holeMinister(String vorname) {
      for (Minister aktuellesMitglied : this.minister) {
        if (aktuellesMitglied.liefereVorname().equalsIgnoreCase(vorname)) {
          return aktuellesMitglied;
        }
      }

      System.out.println("Sie haben nach einem Minister namens: " + vorname
          + " gesucht. Dieser ist nicht vorhanden");
      return null;

    }

    public Minister liefereMinister(int ministerSortiertNachAnlage) {
      if (ministerSortiertNachAnlage < 1) {
        System.out.println("Es gibt keinen Minister mit der Nummer: "
            + ministerSortiertNachAnlage);
        return null;
      }
      if (ministerSortiertNachAnlage > this.minister.size()) {
        System.out.println("Es gibt kein Minister mit der Nummer: "
            + ministerSortiertNachAnlage);
        return null;
      }
      return minister.get(ministerSortiertNachAnlage - 1);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    public Regierungschef liefereRegierungschef() {
      return regierungschef;
    }

    public void setzeRegierungschef(Regierungschef regierungschef) {
      this.regierungschef = regierungschef;
    }

    public ArrayList<Minister> liefereMinister() {
      return minister;
    }

    public void setzeMinister(ArrayList<Minister> minister) {
      this.minister = minister;
    }
    
    
}

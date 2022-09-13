package bwl.oo.paket9;

import java.util.ArrayList;

public class Gesetz {

    private boolean istBeschlossen;
	private ArrayList<String> artikel = new ArrayList<String>();
	
	public Gesetz() {
	  istBeschlossen = false;
	}
	public Gesetz(boolean istBeschlossen) {
      this.istBeschlossen = istBeschlossen;
    }
	
	public void fuegeArtikelhinzu(String a) {
	  artikel.add(a);
  	}
	public String liefereArtikel(int artikelSortiertNachAnlage) {
      if (artikelSortiertNachAnlage < 1) {
        System.out.println("Es gibt keinen Artikel mit der Nummer: "
            + artikelSortiertNachAnlage);
        return null;
      }
      if (artikelSortiertNachAnlage > this.artikel.size()) {
        System.out.println("Es gibt kein Artikel mit der Nummer: "
            + artikelSortiertNachAnlage);
        return null;
      }
      return artikel.get(artikelSortiertNachAnlage - 1);
    }
    public ArrayList<String> liefereAlleArtikel() {
      return artikel;
    }
    public void setzeAlleArtikel(ArrayList<String> artikel) {
      this.artikel = artikel;
    }	
    public boolean liefereBeschluss() {
      return istBeschlossen;
    }
    public void setzeBeschluss(boolean istBeschlossen) {
      this.istBeschlossen = istBeschlossen; 
    }
}


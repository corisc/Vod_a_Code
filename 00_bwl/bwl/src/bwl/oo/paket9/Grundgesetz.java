package bwl.oo.paket9;

import java.util.ArrayList;


public class Grundgesetz {
    private int entstehungsjahr;
    private int letzteAenderung;
    private ArrayList<String> artikel = new ArrayList<String>();
    
    
    public Grundgesetz() {
      entstehungsjahr = 1949;
      letzteAenderung = 2017;
    }

    public Grundgesetz(int jahr, int letzteAenderung) {
      super();
      this.entstehungsjahr = jahr;
      this.letzteAenderung = letzteAenderung;
    }
    
    
    
    public void fuegeArtikelhinzu(String a, Bundesrat bundesrat, Bundestag bundestag) {
      if(bundesrat.artikelBeschlossen() && bundestag.artikelBeschlossen())
      {
        artikel.add(a);
        System.out.println("Bundesrat und Bundestag haben dem Hinzuf�gen des Artikels zugestimmt.");
      }
      else 
        System.out.println("Bundesrat und Bundestag haben dem Hinzuf�gen des Artikels nicht zugestimmt.");
    
    }
    
    
    public void aendereArtikel(int artikelNummer, String a, Bundesrat bundesrat, Bundestag bundestag) {
      if(artikelNummer>=0 && artikelNummer<artikel.size())
      {
        if(bundesrat.artikelBeschlossen() && bundestag.artikelBeschlossen()) {
          artikel.set(artikelNummer, a);
          System.out.println("Bundesrat und Bundestag haben der Aenderung des Artikels nicht zugestimmt");
        }
        else 
          System.out.println("Bundesrat und Bundestag haben der Aenderung des Artikels nicht zugestimmt");
      }
      else  
        System.out.println("Artikelnummer nicht vorhanden");
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
      if(artikel == null)
        this.artikel = artikel;
      else
        System.out.println("Es besteht schon ein Grundgesetz");
    }

    public void setzeEntstehungsjahr(int jahr) {
      this.entstehungsjahr = jahr;
    }

    public int liefereEntstehungsjahr() {
      return entstehungsjahr;
    }

    public int liefereLetzteAenderung() {
      return letzteAenderung;
    }

    public void setzeLetzteAenderung(int letzteAenderung) {
      this.letzteAenderung = letzteAenderung;
    } 
}

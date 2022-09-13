package bwl.oo.paket901;

import com.ml.views.AusgabeFenster;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Bundesminister bundesminister1 = new Bundesminister("M1", "M1", "M1");
    Bundesminister bundesminister2 = new Bundesminister("M2", "M2", "M2");
        
    Ministerium ministerium1 = new Ministerium("str", bundesminister1);
    Ministerium ministerium2 = new Ministerium("str", bundesminister2);

    ministerium1.setzeRessort("Innen");
    ministerium1.setzeRessort("Aussen");
    
    bundesminister1.setzeMinisterium(ministerium1);
    bundesminister2.setzeMinisterium(ministerium2);
    
    ministerium1.setzeLeitenderMinister(bundesminister1);
    
    
    
    
    Bundeskanzler bk = new Bundeskanzler("A", "K", "", 5);

    Bundesregierung br = new Bundesregierung(bk);
    
    br.fuegeBundesministerHinzu(bundesminister1);
    br.fuegeBundesministerHinzu(bundesminister2);
    
    AusgabeFenster ausA = new AusgabeFenster();
    AusgabeFenster ausB = new AusgabeFenster();
    
    ausA.ausgeben(br.liefereBundeskanzler().liefereVorname());
    ausA.ausgeben(br.liefereBundeskanzler().liefereNachname());
    ausA.ausgeben(br.liefereBundeskanzler().liefereAdresse());
    ausA.ausgeben(br.liefereBundeskanzler().liefereAmtszeit());
    
    ausB.ausgeben(br.liefereBundesminister(1).liefereNachname() + br.liefereBundesminister(1).liefereMinisterium().liefereRessort());
    ausB.ausgeben(br.liefereBundesminister(2).liefereNachname() + br.liefereBundesminister(2).liefereMinisterium().liefereRessort());
    
    int anzahl = br.lieferAnzahlBundesminister();
    for(int t=1;t<=anzahl;t=t+1){
      System.out.println(""+br.liefereBundesminister(t).liefereMinisterium().liefereRessort());
    }

    
    
  }

}


package bwl.tuttlingen;

import bwl.main.auktionshaus.Lagerhaus;
import bwl.main.auktionshaus2.Berechner;

import com.ml.utils.MatheHelfer;
import com.ml.views.AusgabeFenster;
import com.ml.views.DatenReihe;
import com.ml.views.Permutator;
import com.ml.views.ZeichenFenster;

public class Programm1 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    ZeichenFenster fe2 = new ZeichenFenster("Punkte");

    
    Lagerhaus lagerhaus = new Lagerhaus();
    DatenReihe alleProdukte = lagerhaus.liefereProduktNamen();
    DatenReihe alleOrteX = lagerhaus.liefereProduktOrteX();
    DatenReihe alleOrteY = lagerhaus.liefereProduktOrteY();

    
    AusgabeFenster fe1 = new AusgabeFenster();
    for(int t=0;t<alleProdukte.liefereZahlDerEintraege();t++){
      fe1.ausgeben(t + ". Eintrrage in der DatenReihe:");
      fe1.ausgeben("Produkt: " + alleProdukte.holeStringAnStelle(t));
      fe1.ausgeben("Ist an Postion: x=" + alleOrteX.holeDoubleAnStelle(t) + " y=" + alleOrteY.holeDoubleAnStelle(t));
      fe1.ausgeben("==============================================");
    }

    
    
    String p1 = alleProdukte.holeStringAnStelle(4);
    double x1 = alleOrteX.holeDoubleAnStelle(4);
    double y1 = alleOrteY.holeDoubleAnStelle(4);
    
    String p2 = alleProdukte.holeStringAnStelle(5);
    double x2 = alleOrteX.holeDoubleAnStelle(5);
    double y2 = alleOrteY.holeDoubleAnStelle(5);
    
    fe2.kreisZeichnen(x1, y1, 5);
    fe2.kreisZeichnen(x2, y2, 5);

    fe2.textZeichnen(p1, x1+10, y1+10,15, "lila");
    fe2.textZeichnen(p2, x2+10, y2+10,15, "lila");
    
    fe2.linieZeichnen(x1, y1, x2, y2, 3, "rot");
    fe2.linieZeichnen(x1, y1, x1, y2, 3, "blau");
    fe2.linieZeichnen(x1, y2, x2, y2, 3, "blau");
    
    fe2.textZeichnen(x2-x1, (x2-x1)/2+x1, y2+20,15,"blau");
    fe2.textZeichnen(y2-y1, x1-40, (y2-y1)/2+y1,15,"blau");
    
    MatheHelfer ma = new MatheHelfer();
    
    double strecke = ma.quadratwurzel(ma.zumQuadrat((x2-x1)) + ma.zumQuadrat((y2-y1)));
    fe2.textZeichnen(strecke, (x2-x1)/2+x1+10, (y2-y1)/2+y1, 15, "lila");

    
    
    
    
    
    
    
    
    double x;
    double y;
    int z = alleProdukte.liefereZahlDerEintraege();
    AusgabeFenster aus = new AusgabeFenster();

    // Neu
    ZeichenFenster f = new ZeichenFenster("Lager");
    double seitenlaenge = 0;
    double letztesx = 0;
    double letztesy = 0;
    String name;
    MatheHelfer m = new MatheHelfer();
    for(int t=0;t<z;t=t+1){
      name = alleProdukte.holeStringAnStelle(t);
      x = alleOrteX.holeDoubleAnStelle(t);
      y = alleOrteY.holeDoubleAnStelle(t);
      aus.ausgeben("zeile " + t +" der Datenriehe produkt: " + name);
      aus.ausgeben("zeile " + t +" x ist " + x + " y ist " +y );
      // Neu
      f.kreisZeichnen(x, y, 4);
      f.textZeichnen(name + "(" + t + ")", x+6, y+6);
      f.linieZeichnen(letztesx, letztesy, x, y, "rot");
      Berechner berechner = new Berechner();
      seitenlaenge = berechner.streckeBerechnen(x, y, letztesx, letztesy);
      //f.textZeichnen(seitenlaenge, x+6, y-10, 14, "rot");      
      f.textZeichnen(seitenlaenge, m.liefereKleinerenWert(x,letztesx) + m.absoluterWert(x-letztesx)/2+5, m.liefereKleinerenWert(y,letztesy) + m.absoluterWert(y-letztesy)/2+5, 14, "rot");      
      f.kreisZeichnen(m.liefereKleinerenWert(x,letztesx) + m.absoluterWert(x-letztesx)/2, m.liefereKleinerenWert(y,letztesy) + m.absoluterWert(y-letztesy)/2, 4);
      letztesx = x;
      letztesy = y;
    }
    
    Permutator permutator = new Permutator();
    String permutierteAusgabe = permutator.zeigeAllePermutationen(    "Batterie",
        "Lampe",
        "Tisch",
        "Tresor");
    System.out.println(""+permutierteAusgabe);

    
    
    
    
  }

}

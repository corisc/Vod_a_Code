package bwl.main.auktionshaus2;

import com.ml.utils.MatheHelfer;
import com.ml.utils.MultiStreckenBerechner;
import com.ml.views.AusgabeFenster;
import com.ml.views.DatenReihe;
import com.ml.views.Permutator;
import com.ml.views.ZeichenFenster;

public class Programm {

  public static void main(String[] args) {
    Punkt a = new Punkt(50,100,"a");
    Punkt b = new Punkt(30,110,"b");
    Punkt c = new Punkt(280,220,"c");
    Punkt d = new Punkt(100,310,"d");
    Punkt e = new Punkt(400,110,"e");
    Punkt start = new Punkt(0,0,"start");
    
    ZeichenFenster fenster = new ZeichenFenster("Lager");
    fenster.kreisZeichnen(start.x, start.y, 4);
    fenster.textZeichnen("start", start.x + 10, start.y +10);
    fenster.kreisZeichnen(a.x, a.y, 4);
    fenster.textZeichnen("a", a.x + 10, a.y +10);
    fenster.kreisZeichnen(b.x, b.y, 4);

    fenster.textZeichnen("b", b.x + 10, b.y +10);
    fenster.kreisZeichnen(c.x, c.y, 4);
    fenster.textZeichnen("c", c.x + 10, c.y +10);
    fenster.kreisZeichnen(d.x, d.y, 4);
    fenster.textZeichnen("d", d.x + 10, d.y +10);
    fenster.kreisZeichnen(e.x, e.y, 4);
    fenster.textZeichnen("e", e.x + 10, e.y +10);
    
    AusgabeFenster aus = new AusgabeFenster();
    //Berechner be = new Berechner();
    double startNacha = streckeBerechnen(start, a);
    aus.ausgeben("von start nach a: " + startNacha);
    double summe = startNacha;
    summe = summe + streckeBerechnen(a, b);
    summe = summe + streckeBerechnen(b, c);
    summe = summe + streckeBerechnen(c, d);
    summe = summe + streckeBerechnen(d, start);
    aus.ausgeben("erste runde: " + summe);
    
    DatenReihe zuPermutieren = new DatenReihe();
    zuPermutieren.hinzufuegen(a);
    zuPermutieren.hinzufuegen(b);
    zuPermutieren.hinzufuegen(c);
    zuPermutieren.hinzufuegen(d);
    zuPermutieren.hinzufuegen(e);
    
    Permutator permutator = new Permutator();
    DatenReihe permutiert = permutator.punktePermutieren(zuPermutieren);
    // Errechnung der gesamten Strecke
    MultiStreckenBerechner multiStreckenBerechner = new MultiStreckenBerechner();
    double kleinsteStrecke = 9000;
    DatenReihe kleinsteDatenReihe = null;
    
    int anzahl = permutiert.liefereZahlDerEintraege();
    for(int t=0;t<anzahl; t++){
      DatenReihe aktuelleReihe = permutiert.holeDatenReiheAnStelle(t);
      int anzahlReihe = aktuelleReihe.liefereZahlDerEintraege();
      for(int tt=0;tt<anzahlReihe;tt++){
        aus.zeilenumbruchlosesAusgeben(aktuelleReihe.holePunktAnStelle(tt).name);
      }
      double erg = multiStreckenBerechner.punkteReiheBerechner(aktuelleReihe);
      aus.ausgeben("");
      aus.ausgeben("stecke: " + erg);
      if(erg < kleinsteStrecke){
        kleinsteStrecke = erg;
        kleinsteDatenReihe = aktuelleReihe;
      }
    }
    aus.ausgeben("kleinste Strecke: " + kleinsteStrecke);
    for(int tt=0;tt<kleinsteDatenReihe.liefereZahlDerEintraege();tt++){
      aus.zeilenumbruchlosesAusgeben(kleinsteDatenReihe.holePunktAnStelle(tt).name);
    }
  }
  
  public static double streckeBerechnen(Punkt p1, Punkt p2){
    double ergebnis = 0;
    double a = p1.x - p2.x;
    double b = p1.y - p2.y;
    MatheHelfer matheHelfer = new MatheHelfer();
    a = matheHelfer.absoluterWert(a);
    b = matheHelfer.absoluterWert(b);
    double cquadrat = matheHelfer.zumQuadrat(a) + matheHelfer.zumQuadrat(b);
    ergebnis = matheHelfer.quadratwurzel(cquadrat);
    
    return ergebnis;
  }

}


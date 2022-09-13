package bwl.main.auktionshaus2;

import bwl.main.auktionshaus.Lagerhaus;

import com.ml.utils.MatheHelfer;
import com.ml.views.AusgabeFenster;
import com.ml.views.DatenReihe;
import com.ml.views.ZeichenFenster;

public class Variante_2014_wi {

  public static void main(String args[]) {
    Lagerhaus la = new Lagerhaus();
    DatenReihe drProdukte = la.liefereProduktNamen();
    DatenReihe drx = la.liefereProduktOrteX();
    DatenReihe dry = la.liefereProduktOrteY();
    int anzahlDerEintraege = drProdukte.liefereZahlDerEintraege();
    AusgabeFenster aus = new AusgabeFenster();
    ZeichenFenster ze = new ZeichenFenster("e");

    for (int t = 0; t < anzahlDerEintraege; t = t + 1) {
      aus.ausgeben("Produkt" + t + ":" + drProdukte.holeStringAnStelle(t));
      aus.ausgeben("Stellex" + t + ":" + drx.holeDoubleAnStelle(t));
      aus.ausgeben("Stelley" + t + ":" + dry.holeDoubleAnStelle(t));
      double x = drx.holeDoubleAnStelle(t);
      double y = dry.holeDoubleAnStelle(t);
      String produkt = drProdukte.holeStringAnStelle(t);
      ze.kreisZeichnen(x, y, 5);
      ze.textZeichnen(produkt, x + 10, y + 10);
    }

    double letztesX = 0;
    double letztesY = 0;
    double gesamt = 0;

    for (int t = 0; t < anzahlDerEintraege; t = t + 1) {
      double x = drx.holeDoubleAnStelle(t);
      double y = dry.holeDoubleAnStelle(t);
      ze.linieZeichnen(letztesX, letztesY, x, y, 2, "rot");
      double a = letztesX - x;
      double b = letztesY - y;
      MatheHelfer ma = new MatheHelfer();
      double summe = ma.zumQuadrat(a) + ma.zumQuadrat(b);
      double wurzel = ma.quadratwurzel(summe);
      ze.textZeichnen(wurzel, x + 10, y + 20, 15, "rot");
      letztesX = x;
      letztesY = y;
      gesamt = gesamt + wurzel;
    }

    ze.textZeichnen(gesamt, 50, 700, 30, "blau");
  }

}

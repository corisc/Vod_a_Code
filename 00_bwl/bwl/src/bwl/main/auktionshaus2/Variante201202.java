package bwl.main.auktionshaus2;

import com.ml.connection.*;
import com.ml.utils.*;
import com.ml.views.*;
import com.ml.datenbank.*;

import bwl.main.auktionshaus2.Punkt;

public class Variante201202 {

  public static void main(String[] args) {
    // ab hier wird gestartet
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Programm startet");
    Datenbank d = new Datenbank();
    String name;
    name = d.zeileAbfragen("produkt", "name", 0);
    aus.ausgeben("zeile 0 der tabelle produkt: " + name);
    name = d.zeileAbfragen("produkt", "name", 1);
    aus.ausgeben("zeile 1 der tabelle produkt: " + name);
    
    double x;
    double y;
    int z = d.anzahlDerZeilen("produkt");
    // Neu
    ZeichenFenster f = new ZeichenFenster("Lager");
    double seitenlaenge = 0;
    double letztesx = 0;
    double letztesy = 0;
    double neua,neub;
    MatheHelfer ma = new MatheHelfer();
    for(int t=0;t<z;t=t+1){
      name = d.zeileAbfragen("produkt", "name", t);
      x = d.zeileAbfragenDouble("produkt", "posx", t);
      y = d.zeileAbfragenDouble("produkt", "posy", t);
      aus.ausgeben("zeile " + t +" der tabelle produkt: " + name);
      aus.ausgeben("zeile " + t +" x ist " + x + " y ist " +y );
      neua = x - letztesx;
      neub = y - letztesy;
      seitenlaenge = ma.quadratwurzel(ma.zumQuadrat(neua) +
         ma.zumQuadrat(neub) );
      aus.ausgeben("seitenlaenge (" + x + "," + y + ")" + "(" + letztesx + 
          "," + letztesy + ") ist " + seitenlaenge);
      letztesx = x; letztesy = y;
      // Neu
      f.kreisZeichnen(x, y, 4);
      f.textZeichnen(name, x+6, y+6);
    }

    
    
    
    double ergebnis = 0;
    double x1 = 0;
    double y1 = 0;
    double x2 = 50;
    double y2 = 100;
    MatheHelfer mathe = new MatheHelfer();
    double a = y2 - y1;
    double b = x2 - x1;
    ergebnis = mathe.quadratwurzel(mathe.zumQuadrat(a) 
        + mathe.zumQuadrat(b));
    aus.ausgeben("seitenlaenge ist " + ergebnis);
    
  }
}




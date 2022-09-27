package bwl.main.winkel;

import com.ml.utils.Helfer;
import com.ml.views.KreisBerechner;
import com.ml.views.ZeichenFenster;

public class ProgrammBac{

  // Einsprungpunkt
  public static void main(String[] args) {
    ZeichenFenster f1 = new ZeichenFenster("Mein Zeichenfenster");

    f1.linieZeichnen(0,0,400,400);
    f1.loeschen();
    
    
    double anfangX;
    double anfangY;
    double endeX;
    double endeY;
    
    anfangX = 300;
    anfangY = 400;
    endeX   = 700;
    endeY   = 400;
    
    f1.linieZeichnen(anfangX, anfangY, endeX, endeY);
    Helfer h = new Helfer();
    h.warteSeks(3);
    f1.loeschen();
    
    f1.linieZeichnen(300, 200, 700, 200, 20);
    f1.linieZeichnen(700, 200, 700, 600, 20);
    f1.linieZeichnen(700, 600, 300, 600, 20);
    f1.linieZeichnen(300, 600, 300, 200, 20);

    h.warteSeks(3);
    f1.loeschen();
    
    for(double verschiebenY = 0; verschiebenY < 50; verschiebenY = verschiebenY + 10){
      f1.linieZeichnen(anfangX, anfangY + verschiebenY, endeX, endeY + verschiebenY);
      h.warteMillis(1000);
      f1.loeschen();
    }
    
    double abstand = 0;
    KreisBerechner k = new KreisBerechner();
    for(double winkel = 0; winkel < 3600; winkel = winkel + 2){
      abstand = 200 * k.berechneSinus(winkel);
      f1.linieZeichnen(300 + abstand, 400, 700 - abstand , 400);

      h.warteMillis(50);
      f1.loeschen();
    }
    
//    double mittex = 500;
//    double mittey = 400;
//
//    KreisBerechner kViereck = new KreisBerechner();
//    for(int winkel=90; winkel< 3600; winkel++){
//      
//      abstand = 200 * k.berechneSinus(winkel);
//      f1.linieZeichnen(300 + abstand, 400, 700 - abstand , 400);
//
//      double sinWert        = kViereck.berechneCosinus(winkel);
//
//      double linksObenX     = mittex - sinWert * 200;
//      double linksObenY     = mittey - 100;
//      double linksUntenX    = mittex - sinWert * 200;
//      double linksUntenY    = mittey + 100;
//          
//      double rechtsObenX     = mittex + sinWert * 200;
//      double rechtsObenY     = mittey - 100;
//      double rechtsUntenX    = mittex + sinWert * 200;
//      double rechtsUntenY    = mittey + 100;
//
//      double sinWertStreckung = kViereck.berechneCosinus(winkel-90);
//      double streckungLinks = (50 * sinWertStreckung);
//      
//      f1.linieZeichnen(linksObenX, linksObenY - streckungLinks, rechtsObenX, rechtsObenY + streckungLinks);
//      f1.linieZeichnen(rechtsObenX, rechtsObenY + streckungLinks, rechtsUntenX, rechtsUntenY - streckungLinks);
//      f1.linieZeichnen(rechtsUntenX, rechtsUntenY - streckungLinks, linksUntenX, linksUntenY + streckungLinks);
//      f1.linieZeichnen(linksUntenX, linksUntenY + streckungLinks, linksObenX, linksObenY - streckungLinks);
//
//
//      Trivials.warteMillis(50);
//      f1.loeschen();
//    }
  }
}

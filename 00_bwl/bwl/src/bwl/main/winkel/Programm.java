package bwl.main.winkel;

import com.ml.utils.Trivials;
import com.ml.views.ZeichenFenster;

public class Programm {

  // Einsprungpunkt
  public static void main(String[] args) {
    
    // Hier geht es los
    ZeichenFenster f1 = new ZeichenFenster("Mein erstes Fenster");
    
//    f1.linieZeichnen(100, 100, 100, 200);
//    f1.linieZeichnen(100, 200, 200, 200);
//    f1.linieZeichnen(200, 200, 200, 100);
//    f1.linieZeichnen(200, 100, 100, 100);
//    
//    Trivials.warteSeks(1);
//    f1.loeschen();
    
    
    
    
    double mittex = 500;
    double mittey = 400;

//    f1.linieZeichnen(mittex - 100, mittey - 100, mittex - 100, mittey + 100);
//    f1.linieZeichnen(mittex - 100, mittey + 100, mittex + 100, mittey + 100);
//    f1.linieZeichnen(mittex + 100, mittey + 100, mittex + 100, mittey - 100);
//    f1.linieZeichnen(mittex + 100, mittey - 100, mittex - 100, mittey - 100);

    double faktor = 100;
    
    f1.linieZeichnen(mittex - faktor, mittey - faktor, mittex - faktor, mittey + faktor);
    f1.linieZeichnen(mittex - faktor, mittey + faktor, mittex + faktor, mittey + faktor);
    f1.linieZeichnen(mittex + faktor, mittey + faktor, mittex + faktor, mittey - faktor);
    f1.linieZeichnen(mittex + faktor, mittey - faktor, mittex - faktor, mittey - faktor);

    Trivials.warteSeks(1);
    f1.loeschen();
    
    faktor = 150;
    
    f1.linieZeichnen(mittex - faktor, mittey - faktor, mittex - faktor, mittey + faktor);
    f1.linieZeichnen(mittex - faktor, mittey + faktor, mittex + faktor, mittey + faktor);
    f1.linieZeichnen(mittex + faktor, mittey + faktor, mittex + faktor, mittey - faktor);
    f1.linieZeichnen(mittex + faktor, mittey - faktor, mittex - faktor, mittey - faktor);
    
    Trivials.warteSeks(1);
    f1.loeschen();
    
    faktor = 200;
    
    f1.linieZeichnen(mittex - faktor, mittey - faktor, mittex - faktor, mittey + faktor);
    f1.linieZeichnen(mittex - faktor, mittey + faktor, mittex + faktor, mittey + faktor);
    f1.linieZeichnen(mittex + faktor, mittey + faktor, mittex + faktor, mittey - faktor);
    f1.linieZeichnen(mittex + faktor, mittey - faktor, mittex - faktor, mittey - faktor);
    
    Trivials.warteSeks(1);
    f1.loeschen();

    
    for(int winkel=0; winkel<= 360; winkel++){
      
      double sinWert    = Math.sin(Math.PI*(winkel)/180);
      double cosWert    = Math.cos(Math.PI*(winkel)/180);

      double punktX     = 500 + sinWert * 200;
      double punkty     = 400 + cosWert * 200;
      
      f1.punktZeichnen(punktX, punkty);
    }
    
    for(int winkel=90; winkel< 360; winkel++){
    
      double sinWert    = Math.sin(Math.PI*(winkel)/180);

      double linksObenX     = mittex - sinWert * 200;
      double linksObenY     = mittey - 100;
      double linksUntenX    = mittex - sinWert * 200;
      double linksUntenY    = mittey + 100;
          
      double rechtsObenX     = mittex + sinWert * 200;
      double rechtsObenY     = mittey - 100;
      double rechtsUntenX    = mittex + sinWert * 200;
      double rechtsUntenY    = mittey + 100;

      double sinWertStreckung = Math.sin(Math.PI*(winkel-90)/180);
      double streckungLinks = (50 * sinWertStreckung);
      
      f1.linieZeichnen(linksObenX, linksObenY - streckungLinks, rechtsObenX, rechtsObenY + streckungLinks);
      f1.linieZeichnen(rechtsObenX, rechtsObenY + streckungLinks, rechtsUntenX, rechtsUntenY - streckungLinks);
      f1.linieZeichnen(rechtsUntenX, rechtsUntenY - streckungLinks, linksUntenX, linksUntenY + streckungLinks);
      f1.linieZeichnen(linksUntenX, linksUntenY + streckungLinks, linksObenX, linksObenY - streckungLinks);


//      linksObenX = linksObenX + 100;
//      linksUntenX = linksUntenX + 100;
//      rechtsObenX = rechtsObenX + 100;
//      rechtsUntenX = rechtsUntenX + 100;
//      
//      f1.linieZeichnen(linksObenX, linksObenY - streckungLinks, rechtsObenX, rechtsObenY + streckungLinks);
//      f1.linieZeichnen(rechtsObenX, rechtsObenY + streckungLinks, rechtsUntenX, rechtsUntenY - streckungLinks);
//      f1.linieZeichnen(rechtsUntenX, rechtsUntenY - streckungLinks, linksUntenX, linksUntenY + streckungLinks);
//      f1.linieZeichnen(linksUntenX, linksUntenY + streckungLinks, linksObenX, linksObenY - streckungLinks);
      

      Trivials.warteMillis(50);
      f1.loeschen();
    }
    
  }

}


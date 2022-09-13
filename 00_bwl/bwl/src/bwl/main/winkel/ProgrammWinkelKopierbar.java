package bwl.main.winkel;

import com.ml.utils.Trivials;
import com.ml.views.ZeichenFenster;

public class ProgrammWinkelKopierbar {

  // Einsprungpunkt
  public static void main(String[] args) {
    
    ZeichenFenster dreh1 = new ZeichenFenster("Mein erstes Fenster");
    
    double mittex = 500;
    double mittey = 400;

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
      
      dreh1.linieZeichnen(linksObenX, linksObenY - streckungLinks, rechtsObenX, rechtsObenY + streckungLinks);
      dreh1.linieZeichnen(rechtsObenX, rechtsObenY + streckungLinks, rechtsUntenX, rechtsUntenY - streckungLinks);
      dreh1.linieZeichnen(rechtsUntenX, rechtsUntenY - streckungLinks, linksUntenX, linksUntenY + streckungLinks);
      dreh1.linieZeichnen(linksUntenX, linksUntenY + streckungLinks, linksObenX, linksObenY - streckungLinks);

      Trivials.warteMillis(50);
      dreh1.loeschen();
    }
    
  }

}


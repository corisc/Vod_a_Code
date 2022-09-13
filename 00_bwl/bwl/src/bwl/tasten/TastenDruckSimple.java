package bwl.tasten;

import com.ml.utils.Helfer;
import com.ml.views.Farbe;
import com.ml.views.ZeichenFenster;

public class TastenDruckSimple {

  public static void main(String[] args) {

    ZeichenFenster z1 = new ZeichenFenster("Yannic's erstes Spiel");
    
    
    char letzteGedrueckteTaste = 0;
    Helfer hi = new Helfer();
    long letzteZeit = 0;

    int farbe = 10;
    int ebene = 5;
    
    for (;;) {

      for (;;) {
        letzteGedrueckteTaste = z1.getNeuerTastendruck();

        long holeZeit = z1.getNeueZeitTastendruck();
        if (holeZeit == letzteZeit) {
          hi.warteMillis(100);
        } else {
          letzteZeit = holeZeit;
          break;
        }
      }
      // Eine Taste wurde gedrueckt
      

      z1.polygonZeichnen(ebene, new Farbe(farbe,0,0), 100,100,100,200,200,200,200,100,100,100);
      farbe = farbe + 5;
      ebene = ebene + 1;
      
      System.out.println("X: " + letzteGedrueckteTaste);
      if (letzteGedrueckteTaste == 'e') {
        System.out.println("gedrueckt");
      }
      if(System.currentTimeMillis() == 1){
        break;
      }
    }
  }

}


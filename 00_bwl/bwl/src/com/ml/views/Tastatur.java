package com.ml.views;

import com.ml.utils.Helfer;

public class Tastatur {
  static char letzteGedrueckteTaste = 0;
  static Helfer hi = new Helfer();
  static long letzteZeit = 0;

  public static String liefereTastaturEingabe(ZeichenFenster zeichenFenster) {


    for (;;) {

      for (;;) {
        letzteGedrueckteTaste = zeichenFenster.getNeuerTastendruck();

        long holeZeit = zeichenFenster.getNeueZeitTastendruck();
        if (holeZeit == letzteZeit) {
          hi.warteMillis(100);
        } else {
          letzteZeit = holeZeit;
          System.out.println(letzteZeit + " " + holeZeit);
          break;
        }
      }
      
      return "" + letzteGedrueckteTaste;
    }
  }
}

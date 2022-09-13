package com.ml.utils;

import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Ueberschrift;

public class KonstruktZweiButton {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    boolean tru = true;
    while (tru) {

      Fenster fenster = new Fenster("Entscheidung");

      Schalter beenden = new Schalter("Beenden");
      Schalter neu = new Schalter("Neues Produkt eingeben");

      fenster.zeige(neu, 300, 300, 200);
      fenster.zeige(beenden, 100, 300, 200);

      Helfer helfer = new Helfer();

      while (true) {
        if (beenden.wurdeGedrueckt()) {
          fenster.loeschen();
          Fenster fenster1 = new Fenster("Alternative 1");
          Ueberschrift ue1 = new Ueberschrift("1");
          fenster1.zeige(ue1, 300, 300);

          tru = false;
          break;

        } else {
          if (neu.wurdeGedrueckt()) {
            fenster.loeschen();
            Fenster fenster2 = new Fenster("Alternative 2");
            Ueberschrift ue2 = new Ueberschrift("2");
            fenster2.zeige(ue2, 300, 300);
            tru = false;
            break;
          }
          helfer.warteMillis(100);

        }
      }
    }
    
    
    
  }

}


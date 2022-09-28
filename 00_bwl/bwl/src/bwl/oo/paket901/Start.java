package bwl.oo.paket901;

import java.util.ArrayList;

import com.ml.views.AusgabeFenster;
import com.ml.views.Fenster;
import com.ml.views.Schalter;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    //Fenster f1 = startFenster();
    //f1.anzeigen();

    Bundesregierung brd = Bundesregierung.createNewBRD();
  }


  public static Fenster startFenster(){
    Fenster start = new Fenster("Mitarbeiter Verwaltungssystem", 1300, 1000);
    Schalter kabinett = new Schalter("Kabinettsverwaltung");
    start.zeige(kabinett,200,500,900);
    Schalter partei = new Schalter("Parteiverwaltung");
    start.zeige(partei,200,600,900);
    Schalter regierung = new Schalter("Regierungsübersicht");
    start.zeige(regierung,200,700,900);
    return start;

  }
}


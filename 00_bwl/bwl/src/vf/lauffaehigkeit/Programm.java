package vf.lauffaehigkeit;

import com.ml.utils.SMSSender;
import com.ml.views.Bild;
import com.ml.views.Fenster;
import com.ml.views.EingabeFeld;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Programm {

  /**
   * @param args
   */
  public static void main(String[] args) {

//    AusgabeFenster ausgabeFenster = new AusgabeFenster("dddd");
//    int a = 1;
//    ausgabeFenster.ausgeben("a hat den Wert: " + a);
//    a = 2;
//    ausgabeFenster.ausgeben("a hat den Wert: " + a);
//    String ersterString = "Hallo dies ist ein Text";
//    ausgabeFenster.ausgeben(ersterString);    
//
//    // Anfangsbild
//    SplashScreen splash = new SplashScreen(1000,
//        "BWL Applikation - 2009", "start_bild.jpg");
//    
//    //splash.anzeigenUndBeenden();
//
//    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("banner.jpg");
    w.zeige(b, 50, 50);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Sende Programm");
    w.zeige(u, 50, 200);

    Text t1 = new Text("Geben sie ein Nummer ein");
    w.zeige(t1, 50, 300);

    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 320, 200);

    Text t2 = new Text("Geben Sie einen Text ein");
    w.zeige(t2, 50, 360);

    EingabeFeld e2 = new EingabeFeld();
    w.zeige(e2, 50, 380, 200);

    Schalter s1 = new Schalter("Senden");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();
    
    String nummer       = e1.getText();
    String nachricht    = e2.getText();

    SMSSender m1 = new SMSSender();
    m1.sende(nummer, nachricht);
  }
}

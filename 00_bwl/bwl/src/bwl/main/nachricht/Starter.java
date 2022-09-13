package bwl.main.nachricht;

import com.ml.utils.SMSSender;
import com.ml.views.AusgabeFenster;
import com.ml.views.Bild;
import com.ml.views.Fenster;
import com.ml.views.EingabeFeld;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Starter {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Fenster w = new Fenster();

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
    
    String nummer       = e1.getText();
    String text         = e2.getText();

//    Nachricht unsereNachricht = new Nachricht();
//    unsereNachricht.nummer      = nummer;
//    unsereNachricht.text        = text;
//    
//    SMSSender m1 = new SMSSender();
//    m1.sende(unsereNachricht);
//    unsereNachricht.errechnePreis();
  }
}

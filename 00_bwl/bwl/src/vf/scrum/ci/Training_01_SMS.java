package vf.scrum.ci;

import com.ml.utils.SMSSender;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Farbe;
import com.ml.views.Fenster;
import com.ml.views.Rechteck;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Training_01_SMS {
  public static void main(String[] args) {

    SplashScreen splash = new SplashScreen(1000, "Sender", "vf_logo.jpg", 400, 160);
    splash.anzeigen();
    
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("vf_logo.jpg");
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
    
    Farbe farbe = new Farbe(230, 0, 0);
    Rechteck r = new Rechteck(650, 150, farbe);
    w.zeige(r, 20, 280);
    
    Schalter s1 = new Schalter("Senden");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();

    String nummer = e1.getText();
    String nachricht = e2.getText();

    SMSSender m1 = new SMSSender();
    m1.sende(nummer, nachricht);
  }

}

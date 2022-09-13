package vf.scrum.ci;

import com.ml.connection.WebServer;
import com.ml.views.AusgabeFenster;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Farbe;
import com.ml.views.Fenster;
import com.ml.views.Rechteck;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Training_03_Client_Calculate {

  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    SplashScreen splash = new SplashScreen(1000, "Sender", "vf_logo.jpg", 400, 160);
    splash.anzeigen();
    
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("vf_logo.jpg");
    w.zeige(b, 50, 50);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Shop Software");
    w.zeige(u, 50, 200);

    Text t1 = new Text("Shop Number");
    w.zeige(t1, 50, 300);

    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 320, 200);

    Text t2 = new Text("Amount of sales");
    w.zeige(t2, 50, 360);

    EingabeFeld e2 = new EingabeFeld();
    w.zeige(e2, 50, 380, 200);
    
    Farbe farbe = new Farbe(230, 0, 0);
    Rechteck r = new Rechteck(650, 150, farbe);
    w.zeige(r, 20, 280);
    
    Schalter s1 = new Schalter("Submit");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();

    double revenue = e2.getWert() * 25;
    
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" + 
    "<SALES>"                                                   + "\n" +
      "<SHOPNUMBER>"     +   e1.getText()      + "</SHOPNUMBER>"        + "\n" +
      "<AMOUNT>"     +   e2.getText()      + "</AMOUNT>"        + "\n" +
      "<REVENUE>"     +   revenue      + "</REVENUE>"        + "\n" +
    "</SALES>";

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben(xml);
    
  }

}


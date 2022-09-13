package bwl.main.tuttlingen;

import com.ml.connection.Anfrage;
import com.ml.views.Fenster;
import com.ml.utils.XMLAnalyse;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.TextFeld;
import com.ml.views.Ueberschrift;

public class ProgrammZentrale {

  // Einstiegspunkt
  public static void main(String[] args) {

    // Anfangsbild
    SplashScreen splash = new SplashScreen(1000,
        "wi",
        "banner_ohm.jpg");
    splash.anzeigen();
    
    // Banner setzen auf 50,50
    Fenster w = new Fenster("Abruf");
    Bild b = new Bild("banner_ohm.jpg");
    w.zeige(b, 50, 50);
    
    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Zentrales Controlling");
    w.zeige(u, 50, 200);
    
    Text t1 = new Text("Verkaufstellen-Rechner-IP");
    w.zeige(t1, 50, 300);
    
    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 320, 200);
    
    Schalter s1 = new Schalter("Server anfragen");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();
    
    Anfrage a = new Anfrage();
    String xml = a.durchfuehren(e1.getText());
    
    Fenster w2 = new Fenster("Datenempfang");
    Bild b2 = new Bild("banner.jpg");
    w2.zeige(b2, 50, 50);
    
    // Ueberschrift
    Ueberschrift u2 = new Ueberschrift("Aral Controlling");
    w2.zeige(u2, 50, 200);
        
    w2.anzeigen();
    
    XMLAnalyse x = new XMLAnalyse(xml);
    double umsatz1 = x.liefereZahl("//PRODUKTDATENSATZ/BEZEICHNER");
    double umsatz2 = x.liefereZahl("//PRODUKTDATENSATZ/ID");
    double umsatz = umsatz1 +umsatz2;
    
    Text tums = new Text("Gesamter Umsatz: " + umsatz);
    w2.zeige(tums, 600, 300);
    
    TextFeld f = new TextFeld(xml);
    w2.zeige(f, 50, 300);
  }

}



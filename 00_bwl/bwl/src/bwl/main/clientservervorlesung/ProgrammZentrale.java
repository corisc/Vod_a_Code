package bwl.main.clientservervorlesung;


import com.ml.connection.Anfrage;
import com.ml.utils.XMLAnalyse;
import com.ml.views.AusgabeFenster;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class ProgrammZentrale {

  // Einstiegspunkt
  public static void main(String[] args) {

    // Anfangsbild
    SplashScreen splash = new SplashScreen(1000, "Server Abruf Applikation", "start_bild.jpg");
    splash.anzeigen();
    
    // Banner setzen auf 50,50
    Fenster w = new Fenster("Abruf");
    Bild b = new Bild("banner.jpg");
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
    
    
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben(xml);
    
    Fenster w2 = new Fenster("Datenempfang");
    Bild b2 = new Bild("banner.jpg");
    w2.zeige(b2, 50, 50);
    
    // Ueberschrift
    Ueberschrift u2 = new Ueberschrift("Aral Controlling");
    w2.zeige(u2, 50, 200);
        
    w2.anzeigen();
    
    XMLAnalyse x = new XMLAnalyse(xml);
    double umsatz1 = x.liefereZahl("//ABSATZDATENSATZ/SUPER");
    double umsatz2 = x.liefereZahl("//ABSATZDATENSATZ/DIESEL");
    
    AusgabeFenster aus1 = new AusgabeFenster("Aral");
    aus1.ausgeben(umsatz1);
    aus1.ausgeben(umsatz2);
    
    double gesamtUmsatz = umsatz1 * 1.33 + umsatz2 * 1.14;
    
    aus.ausgeben(gesamtUmsatz);
    
    
  }

}



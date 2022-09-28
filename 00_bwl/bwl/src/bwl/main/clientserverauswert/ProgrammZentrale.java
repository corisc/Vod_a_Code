package bwl.main.clientserverauswert;

//import com.conf.BasicEnvConfiguration;
import com.conf.BasicEnvConfiguration;
import com.ml.connection.AnfrageWeb;
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
    
    // lokal
    //Anfrage a = new Anfrage();
    //String xml = a.durchfuehren(e1.getText());
    
    //web
    AnfrageWeb anfrageWeb = new AnfrageWeb();
    //String xml = anfrageWeb.durchfuehren("81.169.154.70", 80, "http", "/daten/tankstelle.xml", BasicEnvConfiguration.PROXY_HOST, BasicEnvConfiguration.PROXY_PORT, null, "", true);
    String xml = anfrageWeb.durchfuehren(e1.getText(), 80, "http", "/daten/tankstelle.xml", BasicEnvConfiguration.PROXY_HOST, BasicEnvConfiguration.PROXY_PORT, null, "", true);
    System.out.println(""+xml);
    
    Fenster w2 = new Fenster("Datenempfang");
    Bild b2 = new Bild("banner.jpg");
    w2.zeige(b2, 50, 50);
    
    // Ueberschrift
    Ueberschrift u2 = new Ueberschrift("Aral Controlling");
    w2.zeige(u2, 50, 200);
    
    TextFeld f = new TextFeld(xml);
    w2.zeige(f, 50, 300);
    
    w2.anzeigen();
    
    XMLAnalyse x = new XMLAnalyse(xml);
    double umsatz1 = x.liefereZahl("//TANKE/ABSATZDATENSATZ1/SUPER");
    double umsatz2 = x.liefereZahl("//TANKE/ABSATZDATENSATZ1/DIESEL");
    double umsatz3 = x.liefereZahl("//TANKE/ABSATZDATENSATZ2/SUPER");
    double umsatz4 = x.liefereZahl("//TANKE/ABSATZDATENSATZ2/DIESEL");
    double umsatz = umsatz1 + umsatz2 + umsatz3 + umsatz4; 
    
    Text tums = new Text("Gesamter Umsatz: " + umsatz);
    w2.zeige(tums, 600, 300);
    
    Diagramm diagramm = new Diagramm();
    diagramm.zeichneChart(umsatz1, umsatz3);
  }

}


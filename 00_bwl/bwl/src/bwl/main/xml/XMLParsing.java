package bwl.main.xml;

import com.ml.connection.WebServer;
import com.ml.utils.XMLAnalyse;
import com.ml.views.AusgabeFenster;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class XMLParsing {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

//    SplashScreen splash = new SplashScreen(1000,
//        "BWL Diplom Applikation - 2008", "start_bild.jpg");
//    splash.anzeigen();
//
//    // Banner setzen auf 50,50
//    Fenster w = new Fenster("Eingabe");
//    Bild b = new Bild("banner.jpg");
//    w.zeige(b, 50, 50);
//
//    // Ueberschrift
//    Ueberschrift u = new Ueberschrift("Aral Verkaufsstatistik");
//    w.zeige(u, 50, 200);
//
//    Text t1 = new Text("Verkaufsreihe Super Kraftstoff (0-500)");
//    w.zeige(t1, 50, 300);
//    Text t2 = new Text("Verkaufsreihe Diesel Kraftstoff (0-500)");
//    w.zeige(t2, 50, 360);
//
//    EingabeFeld e1 = new EingabeFeld();
//    w.zeige(e1, 50, 320, 50);
//
//    EingabeFeld e2 = new EingabeFeld();
//    w.zeige(e2, 50, 380, 50);
//
//    EingabeFeld e3 = new EingabeFeld();
//    w.zeige(e3, 120, 320, 50);
//
//    EingabeFeld e4 = new EingabeFeld();
//    w.zeige(e4, 120, 380, 50);
//
//    Schalter s1 = new Schalter("Eingabe");
//    w.zeige(s1, 450, 380, 200);
//
//    s1.warteAufEingabe();
//    w.loeschen();
//
//    double verkaufSuper1 = e1.getWert();
//    double verkaufDiesel1 = e2.getWert();
//    double verkaufSuper2 = e3.getWert();
//    double verkaufDiesel2 = e4.getWert();

    String infoImXMLFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "\n" + "<TANKE>" + "\n" + "<ABSATZDATENSATZ1>" + "\n" + "<SUPER>"
        + 235
        + "</SUPER>"
        + "\n"
        + "<DIESEL>"
        + 144
        + "</DIESEL>"
        + "\n"
        + "</ABSATZDATENSATZ1>"
        + "\n"
        + "<ABSATZDATENSATZ2>"
        + "\n"
        + "<SUPER>"
        + 478
        + "</SUPER>"
        + "\n"
        + "<DIESEL>"
        + 129
        + "</DIESEL>"
        + "\n"
        + "</ABSATZDATENSATZ2>" + "\n" + "</TANKE>";
    
    infoImXMLFormat =
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" +
      "<TANKE>             "                   + "\n" +
      "<ABSATZDATENSATZ1>  "                   + "\n" +
      "<SUPER>235</SUPER>  "                   + "\n" +
      "<DIESEL>144</DIESEL>"                   + "\n" +
      "</ABSATZDATENSATZ1> "                   + "\n" +
      "<ABSATZDATENSATZ2>  "                   + "\n" +
      "<SUPER>478</SUPER>  "                   + "\n" +
      "<DIESEL>129</DIESEL>"                   + "\n" +
      "</ABSATZDATENSATZ2> "                   + "\n" +
      "</TANKE>            "                   + "\n";      

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgebenMonospaced(infoImXMLFormat);

    System.out.println(infoImXMLFormat);

    // Simulierte Uebertragung

    XMLAnalyse x = new XMLAnalyse(infoImXMLFormat);
    double umsatz1 = x.liefereZahl("//TANKE/ABSATZDATENSATZ1/SUPER");
    double umsatz2 = x.liefereZahl("//TANKE/ABSATZDATENSATZ1/DIESEL");
    double umsatz3 = x.liefereZahl("//TANKE/ABSATZDATENSATZ2/SUPER");
    double umsatz4 = x.liefereZahl("//TANKE/ABSATZDATENSATZ2/DIESEL");
    double umsatzGesamt = umsatz1 + umsatz2 + umsatz3 + umsatz4;

    AusgabeFenster aus2 = new AusgabeFenster();
    aus2.ausgeben("Wert 1 aus dem XML: " + umsatz1);
    aus2.ausgeben("Wert 1 aus dem XML: " + umsatz2);
    aus2.ausgeben("Wert 1 aus dem XML: " + umsatz3);
    aus2.ausgeben("Wert 1 aus dem XML: " + umsatz4);
    aus2.ausgeben("Wert 1 aus dem XML: " + umsatzGesamt);
    
    
  }

}

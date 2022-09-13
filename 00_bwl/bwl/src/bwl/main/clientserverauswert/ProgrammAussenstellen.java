package bwl.main.clientserverauswert;


import com.ml.connection.WebServer;
import com.ml.views.Fenster;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class ProgrammAussenstellen {

  // Einsprungpunkt
  public static void main(String[] args) {

    // Anfangsbild
    SplashScreen splash;
    splash = new SplashScreen(1000, "BWL Diplom Applikation - 2008", "start_bild.jpg");
    splash.anzeigen();
    
//    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("banner.jpg");
    w.zeige(b, 50, 50);
    
    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Aral Verkaufsstatistik");
    w.zeige(u, 50, 200);
    
    Text t1 = new Text("Verkaufsreihe Super Kraftstoff");
    w.zeige(t1, 50, 300);
    Text t2 = new Text("Verkaufsreihe Diesel Kraftstoff");
    w.zeige(t2, 50, 360);
    
    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 320, 50);
    
    EingabeFeld e2 = new EingabeFeld();
    w.zeige(e2, 50, 380, 50);
    
    EingabeFeld e3 = new EingabeFeld();
    w.zeige(e3, 120, 320, 50);

    EingabeFeld e4 = new EingabeFeld();
    w.zeige(e4, 120, 380, 50);

    Schalter s1 = new Schalter("Eingabe");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();
    
    double verkaufSuper1  = e1.getWert();
    double verkaufDiesel1 = e2.getWert();
    double verkaufSuper2  = e3.getWert();
    double verkaufDiesel2 = e4.getWert();
        
    String infoImXMLFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"    + "\n" + 
    "<TANKE>"                                                                + "\n" +
    "<ABSATZDATENSATZ1>"                                                     + "\n" +
      "<SUPER>"     +   verkaufSuper1      + "</SUPER>"                      + "\n" +
      "<DIESEL>"    +   verkaufDiesel1     + "</DIESEL>"                     + "\n" +
    "</ABSATZDATENSATZ1>"                                                    + "\n" +
    "<ABSATZDATENSATZ2>"                                                     + "\n" +
      "<SUPER>"     +   verkaufSuper2      + "</SUPER>"                      + "\n" +
      "<DIESEL>"    +   verkaufDiesel2     + "</DIESEL>"                     + "\n" +
    "</ABSATZDATENSATZ2>"                                                    + "\n" +
    "</TANKE>";

    System.out.println(infoImXMLFormat);
    WebServer webserver = new WebServer(infoImXMLFormat);
    webserver.start();
  }
  
  
  
  
  
  /**
    String infoImXMLFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"    + "\n" + 
    "<TANKE>"                                                                + "\n" +
    "<ABSATZDATENSATZ1>"                                                     + "\n" +
      "<SUPER>"     +   verkaufSuper1      + "</SUPER>"                      + "\n" +
      "<DIESEL>"    +   verkaufDiesel1     + "</DIESEL>"                     + "\n" +
    "</ABSATZDATENSATZ1>"                                                    + "\n" +
    "<ABSATZDATENSATZ2>"                                                     + "\n" +
      "<SUPER>"     +   verkaufSuper2      + "</SUPER>"                      + "\n" +
      "<DIESEL>"    +   verkaufDiesel2     + "</DIESEL>"                     + "\n" +
    "</ABSATZDATENSATZ2>"                                                    + "\n" +
    "</TANKE>";
   */

}


package bwl.main.tuttlingen;

import com.ml.connection.WebServer;
import com.ml.connection.WebService;
import com.ml.views.AusgabeFenster;
import com.ml.views.DatenReihe;
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

    DatenReihe alleProdukteAlsXML = new DatenReihe();
    
    // Anfangsbild
    SplashScreen splash = new SplashScreen(1000,
                                           "wi",
                                           "banner_ohm.jpg");
    splash.anzeigen();
    
    String infoImXMLFormat = null;
    
    for(;;){
    
    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("banner_ohm.jpg");
    w.zeige(b, 50, 50);
    
    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Aral Verkaufsstatistik");
    w.zeige(u, 50, 200);
    
    Text t1 = new Text("Verkauf Super Kraftstoff");
    w.zeige(t1, 50, 300);
    
    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 320, 200);
    
    Text t2 = new Text("Verkauf Diesel Kraftstoff");
    w.zeige(t2, 50, 360);
    
    EingabeFeld e2 = new EingabeFeld();
    w.zeige(e2, 50, 380, 200);
    
    Schalter s1 = new Schalter("Eingabe");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();
    
    String verkaufSuper  = e1.getText();
    String verkaufDiesel = e2.getText();
        
    if(e1.getText().length() < 1){
      break;
    }
    
    infoImXMLFormat = 
    "\n" + 
    "<PRODUKTDATENSATZ>"                                                   + "\n" +
      "<BEZEICHNER>"     +   verkaufSuper      + "</BEZEICHNER>"                    + "\n" +
      "<ID>"    +   verkaufDiesel     + "</ID>"                   + "\n" +
    "</PRODUKTDATENSATZ>";

    alleProdukteAlsXML.hinzufuegen(infoImXMLFormat);
    }
    
    for(int t=1;t<=alleProdukteAlsXML.liefereZahlDerEintraege();t++){
      infoImXMLFormat = alleProdukteAlsXML.holeStringAnStelle(t);
    
      WebService webserver = new WebService(infoImXMLFormat);
      webserver.start();
    }
  }
}

/**
String infoImXMLFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" + 
"<ABSATZDATENSATZ>"                                                   + "\n" +
  "<SUPER>"     +   verkaufSuper      + "</SUPER>"             + "\n" +
  "<DIESEL>"    +   verkaufDiesel     + "</DIESEL>"            + "\n" +
"</ABSATZDATENSATZ>";
*/


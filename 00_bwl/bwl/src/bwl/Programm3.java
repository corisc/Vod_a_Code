package bwl;


import com.framework.SQLFenster;
import com.framework.server.BasicServer;
import com.framework.server.ParameterServer;
import com.ml.connection.*;
import com.ml.utils.*;
import com.ml.views.*;
import com.ml.datenbank.*;

import bwl.oo.paket1.*;
import bwl.oo.paket2.*;
import bwl.oo.paket3.*;
import com.ml.views.Fenster;

public class Programm3 {
 
  /**
   * The function `main` is called when the program starts. It creates a window, shows some text and waits for the user to
   * press a button
   */
  public static void main(String[] args) {
    
    // Hau rein
//    SplashScreen splash = new SplashScreen(500,"SAP","vf_logo.jpg");
//    splash.anzeigen();
    Fenster w = new Fenster("schoen");
//    Bild b = new Bild("vf_logo.jpg");
//    w.zeige(b,50,50);
    Ueberschrift u = new Ueberschrift("Eingabe");
    w.zeige(u,50,200);
    // Weiter
    Text t1 = new Text("Personal Nummer:");
    w.zeige(t1,50,250);
    Text t2 = new Text("Nachname:");
    w.zeige(t2,50,300);
    Text t3 = new Text("Gehalt:");
    w.zeige(t3,50,350);
    
    EingabeFeld eins = new EingabeFeld();
    w.zeige(eins,50,270,100);
    EingabeFeld zwei = new EingabeFeld();
    w.zeige(zwei,50,320,100);
    EingabeFeld drei = new EingabeFeld();
    w.zeige(drei,50,370,100);
    
    Schalter s = new Schalter("Drueck mich hart!");
    w.zeige(s,400,400,100);
    s.warteAufEingabe();
    
    AusgabeFenster aus = new AusgabeFenster();
    
    String wertAusEingabeFeldEins = eins.getText();
    aus.ausgeben(wertAusEingabeFeldEins);
    //Weiter
    double wertAusEingabeFeldZwei = zwei.getWert(); //<- Achtung hier getWert()!!!
    aus.ausgeben(wertAusEingabeFeldZwei);
    String wertAusEingabeFeldDrei = drei.getText();
    aus.ausgeben(wertAusEingabeFeldDrei);
    w.loeschen();
    
    ZeichenFenster zei = new ZeichenFenster("wunderschoen");
    zei.polygonZeichnen(new Farbe(255,0,0),100,100,100
        ,wertAusEingabeFeldZwei,200,wertAusEingabeFeldZwei,200,
        100,100,100);


    
  }
}




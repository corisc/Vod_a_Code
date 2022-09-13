package bwl.main.fb;

import com.ml.datenbank.Datenbank;
import com.ml.views.Bild;
import com.ml.views.Fenster;
import com.ml.views.EingabeFeld;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Programm {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // Anfangsbild
    SplashScreen splash = new SplashScreen(1000,
        "BWL Applikation - 2009", "start_bild.jpg");
    
    //splash.anzeigenUndBeenden();

    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("banner.jpg");
    w.zeige(b, 50, 50);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Sende Programm");
    w.zeige(u, 50, 200);

    Text t1 = new Text("Name");
    w.zeige(t1, 50, 300);

    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 320, 200);

    Text t2 = new Text("Vorname");
    w.zeige(t2, 50, 360);

    EingabeFeld e2 = new EingabeFeld();
    w.zeige(e2, 50, 380, 200);

    Schalter s1 = new Schalter("Speichern");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();
    
    String name       = e1.getText();
    String vorname    = e2.getText();

    //CREATE TABLE PERSON(name VARCHAR(20), vorname VARCHAR(20));
    Datenbank datenbank = new Datenbank();
    datenbank.verarbeiteSQLBefehl("INSERT INTO PERSON VALUES ('"+ name + "','"+ vorname + "');");  
    
    
  }
}

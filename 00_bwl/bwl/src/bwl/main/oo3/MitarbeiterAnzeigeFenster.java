package bwl.main.oo3;

import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class MitarbeiterAnzeigeFenster {

  public MitarbeiterAnzeigeFenster(Mitarbeiter ma) {
    Fenster w = new Fenster("Anzeige eines Mitarbeiters");
    Bild b = new Bild("sap.jpg");
    w.zeige(b, 50, 50);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Human Resources");
    w.zeige(u, 200, 50);

    Text t1 = new Text("Nummer:");
    w.zeige(t1, 50, 150);
    Text d1 = new Text(ma.interneNummer, 14);
    w.zeige(d1, 100, 175);

    Text t2 = new Text("Nachname:");
    w.zeige(t2, 50, 200);
    Text d2 = new Text(ma.nachname, 14);
    w.zeige(d2, 100, 225);

    Text t3 = new Text("Vorname:");
    w.zeige(t3, 50, 250);
    Text d3 = new Text(ma.vorname, 14);
    w.zeige(d3, 100, 275);

    Text t4 = new Text("Abteilung:");
    w.zeige(t4, 50, 300);
    Text d4 = new Text(ma.abteilung, 14);
    w.zeige(d4, 100, 325);

    Text t5 = new Text("Gehalt:");
    w.zeige(t5, 50, 350);
    Text d5 = new Text(ma.gehalt, 14);
    w.zeige(d5, 100, 375);

    Schalter s1 = new Schalter("Schliessen");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();
    
  }
  
  
  

}


package bwl.main.datenbank;

import java.util.Vector;

import com.framework.server.BasicServer;
import com.framework.server.ParameterServer;
import com.ml.connection.*;
import com.ml.utils.*;
import com.ml.views.*;
import com.ml.datenbank.*;

import bwl.main.auktionshaus.Lagerhaus;
import bwl.main.auktionshaus2.*;
import bwl.main.oo.Boerse;

public class Programm6 {

  public static void main(String[] args) {

    // Zur Verfuegung stehende Bilder:
    // ausrufezeichen.jpg
    // banner.jpg
    // bannerfh.JPG (Viereckiges FH Logo)
    // fragezeichen.jpg
    // haken.jpg
    // sap_breit.jpg
    // sap.jpg
    // herz.jpg
    // start_bild.jpg (Fuer Splashscreens geeignet)

    // ab hier wird gestartet
    Datenbank db = new Datenbank();
    AusgabeFenster aus = new AusgabeFenster();
    String abt = db.zeileAbfragen("abteilung", "name", 0);
    aus.ausgeben("in zeile 1 steht " + abt);
    int anzahlDerZeilen = db.anzahlDerZeilen("abteilung");
    ComboBox co = new ComboBox();
    for (int t = 0; t < anzahlDerZeilen; t = t + 1) {
      abt = db.zeileAbfragen("abteilung", "name", t);
      aus.ausgeben("in zeile " + t + " steht " + abt);
      co.eintragHinzufuegen(abt);
    }
    Fenster f1 = new Fenster();
    f1.zeige(co, 100, 100);
    Schalter s1 = new Schalter("Auswaehlen");
    f1.zeige(s1, 200, 200, 200);
    s1.warteAufEingabe();
    int ent = co.zahlDerEntscheidung();
    aus.ausgeben("es wurde dieser Eintrag gewaehlt: " + ent);
  }
}
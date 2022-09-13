package vf.hr;

import com.ml.views.AusgabeFenster;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Start {

  public static void main(String[] args) {

    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("vf_logo.jpg");
    w.zeige(b, 530, 20);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Erfassung");
    w.zeige(u, 50, 20);

    Text t1 = new Text("Vorname");
    w.zeige(t1, 50, 200);

    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 220, 200);

    Text t2 = new Text("Nachname");
    w.zeige(t2, 50, 260);

    EingabeFeld e2 = new EingabeFeld();
    w.zeige(e2, 50, 280, 200);

    Text t3 = new Text("Abteilung");
    w.zeige(t3, 50, 320);

    EingabeFeld e3 = new EingabeFeld();
    w.zeige(e3, 50, 340, 200);

    Text t4 = new Text("Gehalt");
    w.zeige(t4, 50, 380);

    EingabeFeld e4 = new EingabeFeld();
    w.zeige(e4, 50, 400, 200);

    Schalter s1 = new Schalter("Erfassen");
    w.zeige(s1, 530, 400, 200);

    s1.warteAufEingabe();
    w.loeschen();

    String vorname = e1.getText();
    String nachname = e2.getText();
    String abteilung = e3.getText();
    double gehalt = e4.getWert();
    
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Folgende Daten wurden eingegeben: ");
    aus.ausgeben("Vorname :" + vorname);
    aus.ausgeben("Nachname :" + nachname);
    aus.ausgeben("Abteilung :" + abteilung);
    aus.ausgeben("Gehalt :" + gehalt);
    
    
    
    Fenster ergebnisFenster = new Fenster("Anzeige eines Mitarbeiters");
    Bild b1 = new Bild("sap.jpg");
    ergebnisFenster.zeige(b1, 50, 50);

    // Ueberschrift
    Ueberschrift u1 = new Ueberschrift("Human Resources");
    ergebnisFenster.zeige(u1, 200, 50);

    Text t12 = new Text("Nachname:");
    ergebnisFenster.zeige(t12, 50, 200);
    Text d2 = new Text(nachname, 14);
    ergebnisFenster.zeige(d2, 100, 225);

    Text t13 = new Text("Vorname:");
    ergebnisFenster.zeige(t13, 50, 250);
    Text d3 = new Text(vorname, 14);
    ergebnisFenster.zeige(d3, 100, 275);

    Text t14 = new Text("Abteilung:");
    ergebnisFenster.zeige(t14, 50, 300);
    Text d4 = new Text(abteilung, 14);
    ergebnisFenster.zeige(d4, 100, 325);

    Text t15 = new Text("Gehalt:");
    ergebnisFenster.zeige(t15, 50, 350);
    Text d5 = new Text(gehalt, 18);
    ergebnisFenster.zeige(d5, 100, 370);

    Schalter s2= new Schalter("Schliessen");
    ergebnisFenster.zeige(s2, 450, 380, 200);

    s2.warteAufEingabe();
    ergebnisFenster.loeschen();

    
  }

}

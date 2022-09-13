package bwl.main.oo3;

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
    Bild b = new Bild("sap.jpg");
    w.zeige(b, 50, 20);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Erfassung");
    w.zeige(u, 350, 50);

    Text t0 = new Text("Nummer");
    w.zeige(t0, 50, 140);

    EingabeFeld e0 = new EingabeFeld();
    w.zeige(e0, 50, 160, 200);

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
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();

    int nummer = e0.getGanzahligenWert();
    String vorname = e1.getText();
    String nachname = e2.getText();
    String abteilung = e3.getText();
    double gehalt = e4.getWert();

    Mitarbeiter m1 = new Mitarbeiter(nummer, vorname, nachname, gehalt,
        abteilung);
    
    MitarbeiterAnzeigeFenster mf1 = new MitarbeiterAnzeigeFenster(m1);
    m1.gehaltErhoehen(2000);
    MitarbeiterAnzeigeFenster mf2 = new MitarbeiterAnzeigeFenster(m1);
  }

}

package vf.group.presentation;

import com.ml.views.AusgabeFenster;
import com.ml.views.Farbe;
import com.ml.views.ZeichenFenster;

import bwl.oo.paket2.*;

public class _2017_2_uebung_4 {

  public static void main(String[] args) {
    
    Mitarbeiter cheffe = new Mitarbeiter("Prof", "Gerhardt");
    Unternehmen unternehmen = new Unternehmen("Walter Gebaeudereinigung", cheffe, 123456);
    
    Mitarbeiter abteilungsleiter1 = new Mitarbeiter("Anton", "Albert");
    Abteilung planung = new Abteilung("Planung", abteilungsleiter1);    
    unternehmen.fuegeAbteilungHinzu(planung);

    Mitarbeiter abteilungsleiter2 = new Mitarbeiter("Beate", "Bause");
    Abteilung produktion = new Abteilung("Produktion", abteilungsleiter2);    
    unternehmen.fuegeAbteilungHinzu(produktion);

    Mitarbeiter m01 = new Mitarbeiter("Anton", "Aurus");
    Mitarbeiter m02 = new Mitarbeiter("Beate", "Bobbel");
    Mitarbeiter m03 = new Mitarbeiter("Chris", "Cross");
    Mitarbeiter m04 = new Mitarbeiter("Doris", "Duese");
    Mitarbeiter m05 = new Mitarbeiter("Ernst", "Eigen");
    Mitarbeiter m06 = new Mitarbeiter("Fritz", "Fummel");
    Mitarbeiter m07 = new Mitarbeiter("Gabi", "Geht");
    Mitarbeiter m08 = new Mitarbeiter("Hans", "Hau");
    Mitarbeiter m09 = new Mitarbeiter("Irina", "Igitt");
    Mitarbeiter m10 = new Mitarbeiter("Julius", "Ceasar");
    
    m01.gehalt = 1233.45;
    m02.gehalt = 2345.02;
    m03.gehalt = 3009.22;
    m04.gehalt = 4710.71;
    m05.gehalt = 2344.93;
    m06.gehalt = 1945.44;
    m07.gehalt = 2003.99;
    m08.gehalt = 3885.27;
    m09.gehalt = 1333.69;
    m10.gehalt = 3988.34;

    planung.fuegeMitarbeiterHinzu(m01);
    planung.fuegeMitarbeiterHinzu(m02);
    planung.fuegeMitarbeiterHinzu(m03);
    planung.fuegeMitarbeiterHinzu(m04);
    planung.fuegeMitarbeiterHinzu(m05);

    produktion.fuegeMitarbeiterHinzu(m06);
    produktion.fuegeMitarbeiterHinzu(m07);
    produktion.fuegeMitarbeiterHinzu(m08);
    produktion.fuegeMitarbeiterHinzu(m09);
    produktion.fuegeMitarbeiterHinzu(m10);
    
    ZeichenFenster zf = new ZeichenFenster("SAP");
    zf.textZeichnen("Hauptansicht", 30, 700, 40, "rot");
    zf.linieZeichnen(30, 690, 260, 690, 2, "rot");

    zf.textZeichnen(unternehmen.name, 30, 650, 20, "blau");
    zf.textZeichnen("Leiter: " + unternehmen.geschaeftsfuehrer.nachname, 30, 620, 15, "blau");

    zf.textZeichnen("Abteilung: " + unternehmen.liefereAbteilung(1).name, 30, 570, 20, "rot");
    zf.textZeichnen("Leiter: " + unternehmen.liefereAbteilung(1).abteilungsLeiter.nachname, 30, 540, 15, "blau");
    zf.textZeichnen("Anzahl Mitarbeiter: " + unternehmen.liefereAbteilung(1).liefereAnzahlMitarbeiter(), 30, 520, 15, "blau");

    zf.textZeichnen("Abteilung: " + unternehmen.liefereAbteilung(2).name, 530, 570, 20, "rot");
    zf.textZeichnen("Leiter: " + unternehmen.liefereAbteilung(2).abteilungsLeiter.nachname, 530, 540, 15, "blau");
    zf.textZeichnen("Anzahl Mitarbeiter: " + unternehmen.liefereAbteilung(2).liefereAnzahlMitarbeiter(), 530, 520, 15, "blau");

    
    zf.linieZeichnen(10, 20, 10, 600, 2, "blau");
    zf.linieZeichnen(10, 600, 490, 600, 2, "blau");
    zf.linieZeichnen(490, 600, 490, 20, 2, "blau");
    zf.linieZeichnen(490, 20, 10, 20, 2, "blau");

    zf.linieZeichnen(510, 20, 510, 600, 2, "blau");
    zf.linieZeichnen(510, 600, 990, 600, 2, "blau");
    zf.linieZeichnen(990, 600, 990, 20, 2, "blau");
    zf.linieZeichnen(990, 20, 510, 20, 2, "blau");
    
    // Balken
    Farbe fa = new Farbe(255, 0, 0);
    zf.polygonZeichnen(fa, 50, 50, 50, unternehmen.liefereAbteilung(1).liefereMitarbeiter(1).gehalt / 10 + 50, 100,
        unternehmen.liefereAbteilung(1).liefereMitarbeiter(1).gehalt / 10 + 50, 100, 50, 50, 50);
    zf.textZeichnen("1", 65, 60, 35, "weiss");
    
    fa = new Farbe(245, 0, 0);
    zf.polygonZeichnen(fa, 100, 50, 100, unternehmen.liefereAbteilung(1).liefereMitarbeiter(2).gehalt / 10 + 50, 150,
        unternehmen.liefereAbteilung(1).liefereMitarbeiter(2).gehalt / 10 + 50, 150, 50, 100, 50);
    zf.textZeichnen("2", 115, 60, 35, "weiss");

    fa = new Farbe(235, 0, 0);
    zf.polygonZeichnen(fa, 150, 50, 150, unternehmen.liefereAbteilung(1).liefereMitarbeiter(3).gehalt / 10 + 50, 200,
        unternehmen.liefereAbteilung(1).liefereMitarbeiter(3).gehalt / 10 + 50, 200, 50, 150, 50);
    zf.textZeichnen("3", 165, 60, 35, "weiss");

    fa = new Farbe(225, 0, 0);
    zf.polygonZeichnen(fa, 200, 50, 200, unternehmen.liefereAbteilung(1).liefereMitarbeiter(4).gehalt / 10 + 50, 250,
        unternehmen.liefereAbteilung(1).liefereMitarbeiter(4).gehalt / 10 + 50, 250, 50, 200, 50);
    zf.textZeichnen("4", 215, 60, 35, "weiss");
    
    fa = new Farbe(215, 0, 0);
    zf.polygonZeichnen(fa, 250, 50, 250, unternehmen.liefereAbteilung(1).liefereMitarbeiter(5).gehalt / 10 + 50, 300,
        unternehmen.liefereAbteilung(1).liefereMitarbeiter(5).gehalt / 10 + 50, 300, 50, 250, 50);
    zf.textZeichnen("5", 265, 60, 35, "weiss");

    // Balken
    fa = new Farbe(0, 255, 0);
    zf.polygonZeichnen(fa, 550, 50, 550, unternehmen.liefereAbteilung(2).liefereMitarbeiter(1).gehalt / 10 + 50, 600,
        unternehmen.liefereAbteilung(2).liefereMitarbeiter(1).gehalt / 10 + 50, 600, 50, 550, 50);
    zf.textZeichnen("6", 565, 60, 35, "weiss");
    
    fa = new Farbe(0, 245, 0);
    zf.polygonZeichnen(fa, 600, 50, 600, unternehmen.liefereAbteilung(2).liefereMitarbeiter(2).gehalt / 10 + 50, 650,
        unternehmen.liefereAbteilung(2).liefereMitarbeiter(2).gehalt / 10 + 50, 650, 50, 600, 50);
    zf.textZeichnen("7", 615, 60, 35, "weiss");

    fa = new Farbe(0, 235, 0);
    zf.polygonZeichnen(fa, 650, 50, 650, unternehmen.liefereAbteilung(2).liefereMitarbeiter(3).gehalt / 10 + 50, 700,
        unternehmen.liefereAbteilung(2).liefereMitarbeiter(3).gehalt / 10 + 50, 700, 50, 650, 50);
    zf.textZeichnen("8", 665, 60, 35, "weiss");

    fa = new Farbe(0, 225, 0);
    zf.polygonZeichnen(fa, 700, 50, 700, unternehmen.liefereAbteilung(2).liefereMitarbeiter(4).gehalt / 10 + 50, 750,
        unternehmen.liefereAbteilung(2).liefereMitarbeiter(4).gehalt / 10 + 50, 750, 50, 700, 50);
    zf.textZeichnen("9", 715, 60, 35, "weiss");
    
    fa = new Farbe(0, 215, 0);
    zf.polygonZeichnen(fa, 750, 50, 750, unternehmen.liefereAbteilung(2).liefereMitarbeiter(5).gehalt / 10 + 50, 800,
        unternehmen.liefereAbteilung(2).liefereMitarbeiter(5).gehalt / 10 + 50, 800, 50, 750, 50);
    zf.textZeichnen("10", 760, 60, 35, "weiss");


  }

}

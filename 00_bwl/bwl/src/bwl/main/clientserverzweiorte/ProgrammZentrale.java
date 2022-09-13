package bwl.main.clientserverzweiorte;

import com.ml.connection.Anfrage;
import com.ml.utils.XMLAnalyse;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.TextFeld;
import com.ml.views.Ueberschrift;
import com.ml.views.ZeichenFenster;

public class ProgrammZentrale {

  // Einstiegspunkt
  public static void main(String[] args) {

    // Anfangsbild
    SplashScreen splash = new SplashScreen(1000, "wi", "banner.jpg");
    splash.anzeigen();

    // Banner setzen auf 50,50
    Fenster fensterIpAbfrage = new Fenster("Abruf");
    Bild bildIpAbfrage = new Bild("banner.jpg");
    fensterIpAbfrage.zeige(bildIpAbfrage, 50, 50);

    // Ueberschrift
    Ueberschrift ueberschriftIpAbfrage = new Ueberschrift("Zentrales Controlling");
    fensterIpAbfrage.zeige(ueberschriftIpAbfrage, 50, 200);

    Text textIpAbfrageHinweis = new Text("Verkaufstellen-Rechner-IP's eintragen");
    fensterIpAbfrage.zeige(textIpAbfrageHinweis, 50, 300);

    EingabeFeld eingabeFeldMuenchen = new EingabeFeld();
    fensterIpAbfrage.zeige(eingabeFeldMuenchen, 50, 320, 200);
    EingabeFeld eingabeFeldHamburg = new EingabeFeld();
    fensterIpAbfrage.zeige(eingabeFeldHamburg, 50, 360, 200);

    Schalter knopf = new Schalter("Server anfragen");
    fensterIpAbfrage.zeige(knopf, 450, 380, 200);

    knopf.warteAufEingabe();
    fensterIpAbfrage.loeschen();

    Anfrage anfrageDatenVomServer = new Anfrage();
    String xmlAusMuenchen = anfrageDatenVomServer.xmlHolenVonServer(eingabeFeldMuenchen.getText());

    Fenster fensterDatenempfangMuenchen = new Fenster("Datenempfang");
    Bild bildDatenempfangMuenchen = new Bild("banner.jpg");
    fensterDatenempfangMuenchen.zeige(bildDatenempfangMuenchen, 50, 50);

    // Ueberschrift
    Ueberschrift ueberschriftDatenempfangMuenchen = new Ueberschrift("Aral Controlling Muenchen");
    fensterDatenempfangMuenchen.zeige(ueberschriftDatenempfangMuenchen, 50, 200);

    fensterDatenempfangMuenchen.anzeigen();

    XMLAnalyse xmlAnalyse = new XMLAnalyse(xmlAusMuenchen);
    double umsatzSuperMuenchen = xmlAnalyse.liefereZahl("//ABSATZDATENSATZ/SUPER");
    double umsatzDieselMuenchen = xmlAnalyse.liefereZahl("//ABSATZDATENSATZ/DIESEL");
    double umsatzGesamtMuenchen = umsatzSuperMuenchen + umsatzDieselMuenchen;

    Text textUmsatzGesamtMuenchen = new Text("Gesamter Umsatz Hamburg: " + umsatzGesamtMuenchen);
    fensterDatenempfangMuenchen.zeige(textUmsatzGesamtMuenchen, 500, 300);

    TextFeld textFeldXmlMuenchen = new TextFeld(xmlAusMuenchen);
    fensterDatenempfangMuenchen.zeige(textFeldXmlMuenchen, 50, 300);

    // Zweites Fenster
    String xmlAusHamburg = anfrageDatenVomServer.xmlHolenVonServer(eingabeFeldHamburg.getText());

    Fenster fensterDatenempfangHamburg = new Fenster("Datenempfang");
    Bild bildDatenempfangHamburg = new Bild("banner.jpg");
    fensterDatenempfangHamburg.zeige(bildDatenempfangHamburg, 50, 50);

    // Ueberschrift
    Ueberschrift ueberschriftDatenempfangHamburg = new Ueberschrift("Aral Controlling Hamburg");
    fensterDatenempfangHamburg.zeige(ueberschriftDatenempfangHamburg, 50, 200);

    fensterDatenempfangHamburg.anzeigen();

    xmlAnalyse = new XMLAnalyse(xmlAusHamburg);
    double umsatzSuperHamburg = xmlAnalyse.liefereZahl("//ABSATZDATENSATZ/SUPER");
    double umsatzDieselHamburg = xmlAnalyse.liefereZahl("//ABSATZDATENSATZ/DIESEL");
    double umsatzGesamtHamburg = umsatzDieselHamburg + umsatzSuperHamburg;

    Text textUmsatzGesamtHamburg = new Text("Gesamter Umsatz Hamburg: " + umsatzGesamtHamburg);
    fensterDatenempfangHamburg.zeige(textUmsatzGesamtHamburg, 500, 300);

    TextFeld textFeldXmlHamburg = new TextFeld(xmlAusHamburg);
    fensterDatenempfangHamburg.zeige(textFeldXmlHamburg, 50, 300);

    // Hier geht es los
    ZeichenFenster zeichenFensterChartBalken = new ZeichenFenster("Chart Balken");

    zeichenFensterChartBalken.linieZeichnen(100, 100, 100, 600);
    zeichenFensterChartBalken.linieZeichnen(100, 100, 600, 100);

    double anzeigeKurs = 0;
    zeichenFensterChartBalken.textZeichnen("(Hinweis: Bitte die kleinen Kreise mit einer Schleife zeichnen)", 10, 10, 10);

    for (double yskala = 100; yskala <= 600; yskala = yskala + 100) {
      zeichenFensterChartBalken.kreisZeichnen(100, yskala, 4);
      zeichenFensterChartBalken.textZeichnen(anzeigeKurs, 50, yskala - 20);
      anzeigeKurs = anzeigeKurs + 20;
    }

    zeichenFensterChartBalken.textZeichnen("Umsatzuebersicht Super", 100, 50, 50);
    zeichenFensterChartBalken.linieZeichnen(200, 100, 200, umsatzSuperMuenchen * 5 + 100, 5, "rot");
    zeichenFensterChartBalken.linieZeichnen(200, umsatzSuperMuenchen * 5 + 100, 300, umsatzSuperMuenchen * 5 + 100, 5, "rot");
    zeichenFensterChartBalken.linieZeichnen(300, umsatzSuperMuenchen * 5 + 100, 300, 100, 5, "rot");
    zeichenFensterChartBalken.textZeichnen("Muenchen", 200, umsatzSuperMuenchen * 5 + 110, 20, "rot");
    zeichenFensterChartBalken.textZeichnen(umsatzSuperMuenchen, 220, umsatzSuperMuenchen * 5 + 80, 20, "rot");

    zeichenFensterChartBalken.linieZeichnen(400, 100, 400, umsatzSuperHamburg * 5 + 100, 5, "blau");
    zeichenFensterChartBalken.linieZeichnen(400, umsatzSuperHamburg * 5 + 100, 500, umsatzSuperHamburg * 5 + 100, 5, "blau");
    zeichenFensterChartBalken.linieZeichnen(500, umsatzSuperHamburg * 5 + 100, 500, 100, 5, "blau");
    zeichenFensterChartBalken.textZeichnen("Hamburg", 400, umsatzSuperHamburg * 5 + 110, 20, "blau");
    zeichenFensterChartBalken.textZeichnen(umsatzSuperHamburg, 420, umsatzSuperHamburg * 5 + 80, 20, "blau");

    ZeichenFenster zeichenFensterKreisChart = new ZeichenFenster("Chart Kreis");

    
    double gesamtUmsatz = umsatzGesamtMuenchen + umsatzGesamtHamburg;
    double winkelWert = umsatzGesamtMuenchen / gesamtUmsatz * 360;

    zeichenFensterKreisChart.kreisZeichnen(500,400,200);
    zeichenFensterKreisChart.textZeichnen("Umsatzaufteilung Muenchen / Hamburg: " + gesamtUmsatz, 100, 50, 20);
    
    double sinWert    = Math.sin(Math.PI*(winkelWert)/180);
    double cosWert    = Math.cos(Math.PI*(winkelWert)/180);

    double punktX     = 500 + sinWert * 200;
    double punkty     = 400 + cosWert * 200;

    zeichenFensterKreisChart.linieZeichnen(500,400,500,600,10,"rot");
    zeichenFensterKreisChart.linieZeichnen(500,400,punktX, punkty,10,"rot");
    zeichenFensterKreisChart.textZeichnen("Muenchen: " + umsatzGesamtMuenchen, punktX+10, punkty+10, 30, "rot");
    zeichenFensterKreisChart.textZeichnen("Hamburg: " + umsatzGesamtHamburg, 150,150, 30, "rot");
    
  }

}

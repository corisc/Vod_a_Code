package bwl;

import com.ml.views.*;

public class Programm4 {

  public static void main(String[] args){
    ZeichenFenster zei1 = new ZeichenFenster("Eins");
    zei1.linieZeichnen(100,0,100,500,3);
    zei1.linieZeichnen(90,200,110,200);
    zei1.linieZeichnen(90,300,110,300);
    zei1.textZeichnen("5000",40,20,18);
    zei1.textZeichnen("6000",40,120,18);
    zei1.linieZeichnen(90,100,110,100);
    
    zei1.polygonZeichnen(new Farbe(255,0,0),100,0,100,100,200,100,200,0
        ,100,0);
    zei1.textZeichnen("wenig",130,110,18);
    // Weiter
    Fenster f = new Fenster("Eingabe");
    Ueberschrift u = new Ueberschrift("Eingabe");
    f.zeige(u,100,50);
    Text t = new Text("Bitte eine Zahl zwischen 5.000 - 10.000:");
    f.zeige(t,100,150);
    EingabeFeld e = new EingabeFeld();
    f.zeige(e,100,200,100);
    //NEU !!!! Richtige Stelle !
    EingabeFeld eingabeFeldNEU = new EingabeFeld();
    f.zeige(eingabeFeldNEU,300,200,100);
    
    Schalter s = new Schalter("Feuer!");
    f.zeige(s,300,200,100);
    s.warteAufEingabe();
    // NEU Richtige Stelle !
    double dieZweiteZahl = eingabeFeldNEU.getWert();
    
    double zahl = e.getWert();
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Es wurde dieser Wert eingegeben: " + zahl);
    double richtigeHoeheInPixel = (zahl-5000)/10;
    aus.ausgeben("Die Hoehe im Diagramm ist in Pixel: " +
        richtigeHoeheInPixel);
    zei1.polygonZeichnen(new Farbe(0,255,0),
        400,0,400,richtigeHoeheInPixel,
        500,richtigeHoeheInPixel,500,0,
        400,0);
    double neueHoeheZweiteInPixel = (dieZweiteZahl-5000)/10;
    zei1.polygonZeichnen(new Farbe(0,0,255),
        500,0,500,neueHoeheZweiteInPixel,
        500,neueHoeheZweiteInPixel,600,0,
        500,0);
    
    
  }
}

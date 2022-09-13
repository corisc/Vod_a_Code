package vf.hr.eins;

import com.ml.utils.Helfer;
import com.ml.views.AusgabeFenster;
import com.ml.views.Farbe;
import com.ml.views.Fenster;
import com.ml.views.ZeichenFenster;

public class Programm2 {

  public static void main(String[] args) {
    /**
     * Unten sind Befehle aufgefuehrt. Bitte fuehren Sie diese Zeile fuer Zeile durch
     * und testen Sie jede neue Zeile durch Druecken des "Play Buttons".
     * Anhand dieser Befehle ist es Ihnen moeglich die Anwendung, wie sie auf der
     * Web Seite "http://www.mleue.de/..." aufgefuehrt ist selbst zu programmieren.
     */
    
    String titel;
    titel = "bla";
    ZeichenFenster zf;
    zf = new ZeichenFenster(titel);
    
    zf.polygonZeichnen(new Farbe(255, 0, 0), 100, 100, 100, 500, 200, 500, 200, 100, 100, 100);
    zf.polygonZeichnen(new Farbe(200,200,200), 100, 100, 300, 200, 400, 200, 200, 100, 100, 100);

    zf.polygonZeichnen(new Farbe(255, 0, 0), 400, 100, 400, 500, 500, 500, 500, 100, 400, 100);
    zf.polygonZeichnen(new Farbe(200,200,200), 400, 100, 600, 200, 700, 200, 500, 100, 400, 100);
    
    zf.textZeichnen("2000,00 Euro", 520, 480, 20);
    zf.polygonZeichnen(new Farbe(200,200,200), 710, 200, 770, 200, 765, 195, 705, 195, 710, 200);

}

}


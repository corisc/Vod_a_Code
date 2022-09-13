package bwl.main.frontend;

import java.math.BigDecimal;

import com.ml.utils.Helfer;
import com.ml.utils.ZahlenKonvertierer;
import com.ml.views.Text;
import com.ml.views.ZeichenFenster;

public class Uhr {

  public static void main(String[] args) {
    /**
     * Unten sind Befehle aufgefuehrt. Bitte fuehren Sie diese Zeile fuer Zeile
     * durch und testen Sie jede neue Zeile durch Druecken des "Play Buttons".
     * Anhand dieser Befehle ist es Ihnen moeglich die Anwendung, wie sie auf
     * der Web Seite "http://www.mleue.de/..." aufgefuehrt ist selbst zu
     * programmieren.
     */

    Helfer h = new Helfer();

    double sinWertStreckung;
    double cosWertStreckung;

    ZeichenFenster zf = new ZeichenFenster("bla");
    Helfer he = new Helfer();

    // Scheife fuer die Punkte der Uhr

    for (double st = 1; st <= 12; st = st + 1) {

      for (double mi = 0; mi <= 59; mi = mi + 1) {

        for (double w = 0; w <= 360; w = w + 6) {
          sinWertStreckung = Math.sin(Math.PI * (w / 180));
          cosWertStreckung = Math.cos(Math.PI * (w / 180));

          if (w % 90 == 0) {
            zf.kreisZeichnen(400 + 200 * sinWertStreckung,
                400 + 200 * cosWertStreckung, 10);
          } else {
            if (w % 30 == 0) {
              zf.kreisZeichnen(400 + 200 * sinWertStreckung,
                  400 + 200 * cosWertStreckung, 3);
            } else {
              zf.kreisZeichnen(400 + 200 * sinWertStreckung,
                  400 + 200 * cosWertStreckung, 1);
            }
          }
        }

        // Schleife fuer die Uhrzeit Labels der Uhr

        double aktuellerwinkel = 30;
        for (double time = 1; time <= 12; time = time + 1) {
          sinWertStreckung = Math.sin(Math.PI * (aktuellerwinkel / 180));
          cosWertStreckung = Math.cos(Math.PI * (aktuellerwinkel / 180));
          if (aktuellerwinkel % 30 == 0) {
            BigDecimal b = new BigDecimal(time);
            b.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
            zf.textZeichnen(b + " Uhr", 370 + 290 * sinWertStreckung,
                390 + 290 * cosWertStreckung, 21);

          } else {
            zf.textZeichnen(time + " Uhr", 300 + 250 * sinWertStreckung,
                300 + 250 * cosWertStreckung, 17);

          }

          aktuellerwinkel = aktuellerwinkel + 30;
        }

        // Mitte Kreis

        zf.kreisZeichnen(400, 400, 3);

        // Uhrzeit erstellen

        double aktuellerwinkel1 = mi * 6;
        sinWertStreckung = Math.sin(Math.PI * (aktuellerwinkel1 / 180));
        cosWertStreckung = Math.cos(Math.PI * (aktuellerwinkel1 / 180));
        zf.linieZeichnen(400 + 200 * sinWertStreckung,
            400 + 200 * cosWertStreckung, 400, 400, 2);

        double aktuellerwinkel2 = (mi * 30 / 60) + (30 * st);
        sinWertStreckung = Math.sin(Math.PI * (aktuellerwinkel2 / 180));
        cosWertStreckung = Math.cos(Math.PI * (aktuellerwinkel2 / 180));
        zf.linieZeichnen(400 + 100 * sinWertStreckung,
            400 + 100 * cosWertStreckung, 400, 400, 3);

        he.warteSeks(1);
        zf.loeschen();
      }
    }
  }
}

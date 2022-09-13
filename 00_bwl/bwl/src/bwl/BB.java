package bwl;

import com.ml.utils.Dax;
import com.ml.views.AusgabeFenster;
import com.ml.views.Farbe;
import com.ml.views.ZeichenFenster;

public class BB {
  public static void main(String[] args) {

    Dax d = new Dax();
    double kurs = d.getQuoteDax();
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Kurs:" + kurs);
    ZeichenFenster zf = new ZeichenFenster("");

    Farbe f = new Farbe(255, 0, 0);
    zf.polygonZeichnen(f, 100, 100, 100, 500, 200, 500, 200, 100, 100, 100);
    zf.polygonZeichnen(new Farbe(200, 200, 200), 100, 100, 300, 300, 400, 300,
        200, 100, 100, 100);
  }

}

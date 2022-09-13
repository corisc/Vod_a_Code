package vf.scrum.coding;

import com.ml.utils.XMLAnalyse;
import com.ml.views.AusgabeFenster;
import com.ml.views.Farbe;
import com.ml.views.ZeichenFenster;

public class Training_2_Zeichnen {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
//    // Man sieht nichts aber die Variable ist da
//    int a;
//    // Man sieht nichts aber die Variable hat jetzt einen Wert
//    a = 1;
//    // Jetzt will ich was sehen
//    AusgabeFenster aus = new AusgabeFenster();
//    aus.ausgeben(a);
//    // Wenn man nicht den Variablenwert ausgeben will sondern a
//    aus.ausgeben("a");
//    // Jetzt aendern wir den Wert von a
//    a=200;
//    
//    //=========================================================
//    
//    // TODO Auto-generated method stub
    ZeichenFenster zf = new ZeichenFenster("bla");
    Farbe f1 = new Farbe(255, 0, 0);
    
    zf.linieZeichnen(50, 100, 50, 500, 3);
    zf.linieZeichnen(40, 100, 60, 100, 3);

    zf.textZeichnen("Unten", 10, 100, 10);
    
    
    zf.polygonZeichnen(f1, 100, 100, 100, 500, 200, 500, 200, 100, 100, 100);
    zf.polygonZeichnen(new Farbe(200,200,200), 100, 100, 300, 300, 400, 300, 200, 100, 100, 100);
    

  }

}


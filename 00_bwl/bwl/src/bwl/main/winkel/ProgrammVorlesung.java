package bwl.main.winkel;

import com.ml.utils.Dax;
import com.ml.utils.Helfer;
import com.ml.views.AusgabeFenster;
import com.ml.views.KreisBerechner;
import com.ml.views.ZeichenFenster;
import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

public class ProgrammVorlesung{

  // Einsprungpunkt
  public static void main(String[] args) {

    ZeichenFenster f1 = new ZeichenFenster("zeichnen");

    f1.linieZeichnen(300,200,700,200,20);

    Helfer h = new Helfer();
    h.warteSeks(3);
    f1.loeschen();

    f1.linieZeichnen(300,300,700,300,20);

    
    
    
    for(double y = 200; y < 400; y = y + 10){
      f1.linieZeichnen(300,y,700,y,20);
      h.warteMillis(500);
      f1.loeschen();
    }

    
    double abstand = 0;
    KreisBerechner k = new KreisBerechner();
    for(double winkel = 0; winkel < 3600; winkel = winkel + 2){
      abstand = 200 * k.berechneSinus(winkel);
      f1.linieZeichnen(300 + abstand, 400, 700 - abstand , 400, 20);

      h.warteMillis(50);
      f1.loeschen();
    }
    
    Dax d = new Dax();
    
    double kurs;
    AusgabeFenster a = new AusgabeFenster("");
    for(int t=0; t<1000; t=t+1){
      kurs = d.getQuoteDax();
      a.ausgeben(kurs);
      h.warteMillis(1000);
    }

  }
}



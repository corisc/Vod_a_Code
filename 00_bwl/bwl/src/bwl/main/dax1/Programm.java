package bwl.main.dax1;

import com.ml.utils.BoersenVerbindung;
import com.ml.utils.Helfer;
import com.ml.views.AusgabeFenster;
import com.ml.views.ZeichenFenster;

public class Programm {

  // Einsprungpunkt
  public static void main(String[] args) {
    
    // Hier geht es los
    ZeichenFenster f1 = new ZeichenFenster("Mein erstes Fenster");

    BoersenVerbindung d = new BoersenVerbindung("ffm");
    
    double kurs = d.neuenKursHolen();
    AusgabeFenster a = new AusgabeFenster("");
    a.ausgeben(kurs);
    
    
    f1.linieZeichnen(100, 100, 100, 600);
    f1.linieZeichnen(100, 100, 600, 100);
    
    double  anzeigeKurs     = 6400;
    
    for(double yskala = 100; yskala <=600; yskala=yskala + 100){
      f1.kreisZeichnen(100, yskala, 4);
      f1.textZeichnen(anzeigeKurs, 50, yskala - 20);
      anzeigeKurs = anzeigeKurs + 10;
    }
    
    anzeigeKurs     = 6400;
    Helfer h = new Helfer();
    //NewsServer n = new NewsServer(BasicEnvConfiguration.PROXY_HOST, BasicEnvConfiguration.PROXY_PORT);
    for(int time=100; time<=2000; time = time+1){
      kurs = d.neuenKursHolen();
      //String nachricht = n.getNachricht();
      //System.out.println(""+nachricht);
      f1.kreisZeichnen(time, 100 + (kurs - anzeigeKurs) * 10,5);
      a.ausgeben(kurs);
      h.warteSeks(1);
    }
  }
}



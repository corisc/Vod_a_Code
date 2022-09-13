package bwl.main.clientserverauswert;

import com.ml.views.ZeichenFenster;

public class Diagramm {
  
  public void zeichneChart(double werty1, double werty2){
    ZeichenFenster f1 = new ZeichenFenster("Mein erstes Fenster");

    f1.linieZeichnen(100, 100, 100, 600);
    f1.linieZeichnen(100, 600, 600, 600);
    
    double  hoechsterWert     = 0;
    
    for(double yskala = 600; yskala >=100; yskala=yskala - 100){
      f1.kreisZeichnen(100, yskala, 4);
      f1.textZeichnen(hoechsterWert, 50, yskala - 20);
      hoechsterWert = hoechsterWert + 10;
    }
    
    hoechsterWert     = 0;

    f1.punktZeichnen(300, 600 - (werty1) * 10);
    f1.punktZeichnen(600, 600 - (werty2) * 10);

  }
}


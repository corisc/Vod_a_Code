package bwl.main.oo;

import com.ml.utils.Dax;
import com.ml.utils.Kurs;
import com.ml.views.AusgabeFenster;
import com.ml.views.ZeichenFenster;

public class Chart {
  
  private double kleinsterKurs = 7000;
  private ZeichenFenster f1;
  private int xStelle = 100; 

  public Chart(double kleinsterKurs){
    this.kleinsterKurs = kleinsterKurs;
    // Hier geht es los
    this.f1 = new ZeichenFenster("Chart Fenster");

    this.f1.linieZeichnen(100, 100, 100, 600);
    this.f1.linieZeichnen(100, 100, 600, 100);
    
    double k = this.kleinsterKurs;
    for(double yskala = 100; yskala <=600; yskala=yskala + 100){
      this.f1.kreisZeichnen(100, yskala, 4);
      this.f1.textZeichnen(k, 50, yskala - 20);
      k = k + 10;
    }
  }
  
  public void zeichneKurs(Kurs kurs){
    this.f1.punktZeichnen(this.xStelle, 100 + (kurs.getWert() - this.kleinsterKurs) * 10);
    this.xStelle = this.xStelle + 1;
  }
  
  

}


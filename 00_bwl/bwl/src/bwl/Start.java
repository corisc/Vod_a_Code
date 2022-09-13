package bwl;

import com.ml.utils.Dax;
import com.ml.views.AusgabeFenster;
import com.ml.views.Farbe;
import com.ml.views.ZeichenFenster;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ZeichenFenster zf = new ZeichenFenster("bla");

    zf.linieZeichnen(700,100,700,200);
    zf.linieZeichnen(700,100,850,100);

    zf.linieZeichnen(690,125,710,125);
    zf.linieZeichnen(690,150,710,150);
    zf.linieZeichnen(690,175,710,175);
    zf.linieZeichnen(690,200,710,200);

    zf.linieZeichnen(600,100,600,600);
    zf.linieZeichnen(600,100,100,100);

    
    zf.textZeichnen("5", 660, 100);
    zf.textZeichnen("10", 660, 125);
    zf.textZeichnen("15", 660, 150);
    zf.textZeichnen("20", 660, 175);
    zf.textZeichnen("25", 660, 200);

    
    
    
    int bezeichner = 9070;
    for(int t=100;t<=600;t=t+100){
      zf.linieZeichnen(t,90,t,110,2);
      zf.textZeichnen(bezeichner, t-7, 80, 18);
      bezeichner = bezeichner - 10;
    }

    Dax d = new Dax();
    double kurs;
    kurs = 0;
    kurs = d.getQuoteDax();
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("kurs hat den Wert: " + kurs);
    
    for(int t=150; t<=450; t=t+100){
      aus.ausgeben("t hat den Wert: " + t);
      kurs = d.getQuoteDax();
      aus.ausgeben("kurs hat den Wert: " + kurs);
      double xHoehe = (kurs - 9020)*10+100;
      zf.polygonZeichnen(new Farbe(0,255,0),600,t,700-xHoehe,t,700-xHoehe,t+50,600,t+50,600,t);
      
      double zertifikat = (kurs - 8000)/100;
      aus.ausgeben("Dax Kurs ist: " + kurs);
      aus.ausgeben("Zert. Preis ist: " + zertifikat);
      aus.ausgeben("t: " + t);
      double yHoeheDesZertifikates = (zertifikat - 5) * 5 + 100;
      aus.ausgeben("y: " + yHoeheDesZertifikates);
      zf.kreisZeichnen( (700+((t-150)/100)*50), yHoeheDesZertifikates, 4);
    }
  }
}


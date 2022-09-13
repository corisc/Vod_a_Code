package bwl;

import com.ml.utils.*;
import com.ml.views.*;

public class Programm2 {

  public static void main(String[] args) {
    
    // Hau rein
    ZeichenFenster zf = new ZeichenFenster("bla");

    zf.linieZeichnen(600,100,600,600);
    zf.linieZeichnen(600,600,100,600);

    zf.linieZeichnen(590,100,610,100);
    zf.linieZeichnen(590,200,610,200);
    
    
    
    zf.linieZeichnen(590,300,610,300);
    zf.linieZeichnen(590,400,610,400);
    zf.linieZeichnen(590,500,610,500);
    zf.linieZeichnen(590,600,610,600);
    
    zf.textZeichnen("1.0", 620, 100, 18);
    zf.textZeichnen("0.9", 620, 200, 18);
    zf.textZeichnen("0.8", 620, 300, 18);
    zf.textZeichnen("0.7", 620, 400, 18);
    zf.textZeichnen("0.6", 620, 500, 18);
    zf.textZeichnen("0.5", 620, 600, 18);

    zf.textZeichnen("9020", 680, 100, 18);
    zf.textZeichnen("9040", 680, 200, 18);
    zf.textZeichnen("9060", 680, 300, 18);
    zf.textZeichnen("9080", 680, 400, 18);
    zf.textZeichnen("9100", 680, 500, 18);
    zf.textZeichnen("9120", 680, 600, 18);

    
    zf.textZeichnen("Dax Long Zertifikat Preis Knock-Out bei 9000", 100, 650, 30);

    
    Dax d = new Dax();
    double kurs;
    kurs = 0;
    kurs = d.getQuoteDax();
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("kurs hat den Wert: " + kurs);
    
    for(int t=450; t>=150; t=t-100){
      aus.ausgeben("t hat den Wert: " + t);
      kurs = d.getQuoteDax();
      double zertifikat = (kurs - 9000)/100;
      aus.ausgeben("kurs hat den Wert: " + kurs);
      aus.ausgeben("Zert. Preis ist: " + zertifikat);
      double yHoehe = 600 - ((zertifikat - 0.5)*1000);
      
      zf.linieZeichnen(t,600,t,yHoehe);
      zf.linieZeichnen(t,yHoehe,t+50,yHoehe);
      zf.linieZeichnen(t+50,yHoehe,t+50,600);
      double yhoeheDax = (kurs-9020)* 5 + 100;
      zf.kreisZeichnen(t+25, yhoeheDax, 10);
      zf.linieZeichnen(t+25, 100, t+25, yhoeheDax-5);
      zf.textZeichnen(kurs, t+20, yhoeheDax + 20, 14);
    }
    
    
    
    
  }

}
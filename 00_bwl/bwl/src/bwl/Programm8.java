package bwl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ml.utils.Dax;
import com.ml.views.AusgabeFenster;
import com.ml.views.Farbe;
import com.ml.views.ZeichenFenster;



public class Programm8 {

  public static void main(String[] args) {
    Dax d = new Dax();
    double kurs;
    kurs = 0;
    kurs = d.getQuoteDax();
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("kurs hat den Wert: " + kurs);
    ZeichenFenster zf = new ZeichenFenster("bla");
    
    for(int t=150; t<=450; t=t+100){
      aus.ausgeben("t hat den Wert: " + t);
      kurs = d.getQuoteDax();
      aus.ausgeben("kurs hat den Wert: " + kurs);
      double yHoehe = (kurs - 9020)*10+100;
      zf.polygonZeichnen(new Farbe(0,255,0),t,100,t,yHoehe,t+50,yHoehe,t+50,100,t,100);
    }
    zf.linieZeichnen(100,100,100,600);
    zf.linieZeichnen(100,100,500,100);
    int bezeichner = 9020;
    for(int t=100;t<=600;t=t+100){
      zf.linieZeichnen(90,t,110,t,2);
      zf.textZeichnen(bezeichner, 20, t-7,18);
      bezeichner = bezeichner + 10;
    }
  }
}



 

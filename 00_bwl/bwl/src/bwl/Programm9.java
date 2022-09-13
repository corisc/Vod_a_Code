package bwl;

import java.util.Vector;

import com.framework.SQLFenster;
import com.framework.server.BasicServer;
import com.framework.server.ParameterServer;
import com.ml.connection.*;
import com.ml.utils.*;
import com.ml.views.*;
import com.ml.datenbank.*;

import bwl.main.auktionshaus2.Punkt;
import bwl.oo.paket1.*;
import bwl.oo.paket2.*;
import bwl.oo.paket3.*;
import bwl.thread.ErsteLaeufer;
import bwl.thread.Zaehler;

public class Programm9 {

  public static void main(String[] args) {
    ZeichenFenster zf = new ZeichenFenster("bla");
    zf.linieZeichnen(100,100,100,200);
    zf.linieZeichnen(100,100,350,100);

    zf.linieZeichnen(90,125,110,125);
    zf.linieZeichnen(90,150,110,150);
    zf.linieZeichnen(90,175,110,175);
    zf.linieZeichnen(90,200,110,200);

    
    zf.linieZeichnen(150,250,150,390);
    zf.linieZeichnen(150,250,400,250);

    zf.linieZeichnen(140,270,160,270);
    zf.linieZeichnen(140,290,160,290);
    zf.linieZeichnen(140,310,160,310);
    zf.linieZeichnen(140,330,160,330);
    zf.linieZeichnen(140,350,160,350);
    zf.linieZeichnen(140,370,160,370);
    zf.linieZeichnen(140,390,160,390);

    zf.linieZeichnen(450,200,450,600);
    zf.linieZeichnen(450,200,700,200);

    for(int t=200;t<=600;t=t+50){
      zf.kreisZeichnen(450,t,5);
    }

    
    
    
    
    int werte = 9038;
    for(int t=200;t<=600;t=t+50){
      zf.textZeichnen(werte, 400, t);
      werte = werte + 2;
    }

    
    zf.textZeichnen("8940", 110, 250);
    zf.textZeichnen("8960", 110, 270);
    zf.textZeichnen("8980", 110, 290);
    zf.textZeichnen("9000", 110, 310);
    zf.textZeichnen("9020", 110, 330);
    zf.textZeichnen("9040", 110, 350);
    zf.textZeichnen("9060", 110, 370);
    zf.textZeichnen("9080", 110, 390);

    zf.textZeichnen("9030", 60, 100);
    zf.textZeichnen("9040", 60, 125);
    zf.textZeichnen("9050", 60, 150);
    zf.textZeichnen("9060", 60, 175);
    zf.textZeichnen("9070", 60, 200);
    
    
    Dax d = new Dax();
    double kurs;
    kurs = 0;
    AusgabeFenster aus = new AusgabeFenster();
    
    for(int t=100; t<=350; t=t+5){
      aus.ausgeben("t hat den Wert: " + t);
      kurs = d.getQuoteDax();
      aus.ausgeben("kurs hat den Wert: " + kurs);
      double yHoehe1 = (kurs - 9030)*2.5+100;
      double yHoehe2 = (kurs - 8940)*1+250;
      double yHoehe3 = (kurs - 9038)*25+200;
      zf.kreisZeichnen(t, yHoehe1, 3);
      zf.linieZeichnen(t+45, yHoehe2+5, t+55, yHoehe2-5, 3, "rot");
      zf.linieZeichnen(t+45, yHoehe2-5, t+55, yHoehe2+5, 3, "rot");
      zf.textZeichnen(kurs, t+350, yHoehe3+10);
      zf.polygonZeichnen(new Farbe(0,255,0),t+350,200,t+350,yHoehe3,t+355,yHoehe3,t+355,200,t+350,200);
    }



  }
}

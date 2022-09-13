package bwl;

import com.ml.connection.WebServer;
import com.ml.datenbank.Datenbank;
import com.ml.utils.BoersenVerbindung;
import com.ml.utils.Dax;
import com.ml.utils.Helfer;
import com.ml.views.AusgabeFenster;
import com.ml.views.Farbe;
import com.ml.views.FrageFenster;
import com.ml.views.SplashScreen;
import com.ml.views.ZeichenFenster;

import e.com.ml.utils.StockQuoteProvider;
import e.com.ml.views.copy.DrawWindow;
import e.com.ml.views.copy.TextOutputWindow;

public class Programm7 {

  public static void main(String[] args) {
    
    
    Dax d = new Dax();
    double kurs = 0;
    double zertifikat = 0;
    AusgabeFenster aus = new AusgabeFenster();
    
    ZeichenFenster z = new ZeichenFenster("");
    z.linieZeichnen(100,100,100,500,5);
    z.linieZeichnen(90,100,110,100,2);
    z.linieZeichnen(90,200,110,200,2);
    z.linieZeichnen(90,300,110,300,2);
    z.linieZeichnen(90,400,110,400,2);
    z.linieZeichnen(90,500,110,500,2);
    
    double anzeigeKurs = 0.25;
    for(int t=100;t<=500;t=t+100){
      z.textZeichnen(anzeigeKurs, 50, t, 20);
      anzeigeKurs = anzeigeKurs + 0.01;
    }
    
    double yHoeheDesZertifikates = 0;
    
    for(int t=100;t<=500;t=t+5){
      kurs = d.getQuoteDax();
      zertifikat = (kurs - 9030)/100;
      aus.ausgeben("Dax Kurs ist: " + kurs);
      aus.ausgeben("Zert. Preis ist: " + zertifikat);
      aus.ausgeben("t: " + t);
      yHoeheDesZertifikates = (zertifikat - 0.25) * 10000 + 100;
      aus.ausgeben("y: " + yHoeheDesZertifikates);
      z.kreisZeichnen(t, yHoeheDesZertifikates, 4);
      
    }
    
    
    
  }
}

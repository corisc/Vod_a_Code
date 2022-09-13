package bwl.main.dax2;

import com.conf.BasicEnvConfiguration;
import com.ml.utils.Dax;
import com.ml.utils.GoldmanSachs;
import com.ml.utils.Helfer;
import com.ml.views.Bild;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.ZeichenFenster;

public class Programm {

  // Einsprungpunkt
  public static void main(String[] args) {
    
    
  
    Dax d = new Dax(BasicEnvConfiguration.PROXY_HOST, BasicEnvConfiguration.PROXY_PORT);
    //Dax d = new Dax();
    double kurs = d.getQuoteDax();
    
    // Hier geht es los
    ZeichenFenster f1 = new ZeichenFenster("Mein erstes Fenster");
    
    f1.linieZeichnen(100, 100, 100, 600);
    f1.linieZeichnen(100, 100, 600, 100);
    
    double anzeigeKurs = 6200;
    for(double yskala = 100; yskala <=600; yskala=yskala + 100){
      f1.linieZeichnen(95, yskala, 105, yskala, 3);
      f1.textZeichnen(anzeigeKurs, 60, yskala);
      anzeigeKurs = anzeigeKurs + 10;
    }
    
    Fenster fDaxKurs = new Fenster("Dax");
    Text t1 = new Text("Daxkurs:", 30);
    fDaxKurs.zeige(t1, 50, 10);
    
    Text t2 = new Text(kurs, 50);
    fDaxKurs.zeige(t2, 50, 90);
    
    Helfer h = new Helfer();
    String zeit = h.liefereZeit();
    Text t4 = new Text("Zeitpunkt: " + zeit, 20);
    fDaxKurs.zeige(t4, 50, 200);
    
    Fenster kaufFenster = new Fenster("Eingabe");
    kaufFenster.setzePosition(50,500);
    
    Bild b = new Bild("banner.jpg");
    kaufFenster.zeige(b, 50, 50);
    
    Text t3 = new Text("Kauf / Verkauf");
    kaufFenster.zeige(t3, 50, 300);
    
    Schalter schalterKaufen = new Schalter("Kaufen");
    kaufFenster.zeige(schalterKaufen, 50, 250, 100);
    
    Schalter schalterVerkaufen = new Schalter("Verkaufen");
    kaufFenster.zeige(schalterVerkaufen, 200, 250, 100);

    double summeKauf = 0;
    double summeVerkauf = 0;
    for(int t = 1; t < 100; t=t+1){
      kurs = d.getQuoteDax();

      f1.punktZeichnen(t+100, 600 - (kurs-5750) * 10);
      
      fDaxKurs.loeschen();        
      fDaxKurs.zeige(t1, 50, 10);
      
      t2 = new Text(kurs, 50);        
      fDaxKurs.zeige(t2, 50, 90);
      
      zeit = h.liefereZeit();
      t4 = new Text("Zeitpunkt: " + zeit, 20);
      fDaxKurs.zeige(t4, 50, 200);
      
      if(schalterKaufen.wurdeGedrueckt()){
        GoldmanSachs g = new GoldmanSachs();
        double wertZertifikatKauf = g.holeZertifikatWert(kurs, 5750);
        
        summeKauf = 10000 * wertZertifikatKauf; 
        Text t5 = new Text("Wert Zertifikat: " + wertZertifikatKauf + " Kaufsumme: " + summeKauf + " (" + kurs + ")");
        kaufFenster.zeige(t5, 50, 350);
        
        schalterKaufen.schalterZuruecksetzen();
      }
      if(schalterVerkaufen.wurdeGedrueckt()){
        GoldmanSachs g = new GoldmanSachs();
        double wertZertifikatVerkauf = g.holeZertifikatWert(kurs, 5750);
        
        summeVerkauf = 10000 * wertZertifikatVerkauf; 
        Text t6 = new Text("Wert Zertifikat: " + wertZertifikatVerkauf + " Verkaufsumme: " + summeVerkauf + " (" + kurs + ")");
        kaufFenster.zeige(t6, 50, 380);
        double gewinn = summeVerkauf - summeKauf;
        Text t7 = new Text("Gewinn: " + gewinn, 30);
        kaufFenster.zeige(t7, 100, 400);
        
        schalterVerkaufen.schalterZuruecksetzen();
      }
    }
  }
}


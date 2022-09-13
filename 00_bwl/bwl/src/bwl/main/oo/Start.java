package bwl.main.oo;

import com.ml.utils.Helfer;
import com.ml.utils.Kurs;
import com.ml.views.AusgabeFenster;

public class Start {

  public static void main(String[] args) {
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Programm startet");
    
    Boerse b = new Boerse("Frankfurt");
    Chart chart = new Chart(6050);
    Kurs aktuellerKurs;
    Helfer helfer = new Helfer();
    for(int t = 0; t<=100; t=t+1){
      aktuellerKurs = b.holeNeuenKurs("DE0008469008");
      aus.ausgeben("Zeit des Kurses: " + aktuellerKurs.getZeit());
      aus.ausgeben("Wert des Kurses: " + aktuellerKurs.getWert());
      helfer.warteSeks(1);
      chart.zeichneKurs(aktuellerKurs);
    }
  }

}


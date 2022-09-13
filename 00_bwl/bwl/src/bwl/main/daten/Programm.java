package bwl.main.daten;

import com.ml.views.AusgabeFenster;
import com.ml.views.DatenReihe;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Ueberschrift;

public class Programm {

  public static void main(String[] args) {
    AusgabeFenster a = new AusgabeFenster();
    DatenReihe daten = new DatenReihe();
    
    for(int t=1; t<=10; t=t+1){
      Fenster w = new Fenster("Eingabe");

      // Ueberschrift
      Ueberschrift u = new Ueberschrift("Tag " + t);
      w.zeige(u, 50, 200);
      
      EingabeFeld e1 = new EingabeFeld();
      w.zeige(e1, 50, 320, 200);
      
      Schalter s1 = new Schalter("Eingabe");
      w.zeige(s1, 450, 380, 200);
  
      s1.warteAufEingabe();
      w.loeschen();
      
      double wert = e1.getWert();
      if(wert == 0){
        break;
      }
      a.ausgeben("wert: " + wert);
      daten.hinzufuegen(wert);
    }
    
    int anzahlEintraege = daten.liefereZahlDerEintraege();
    a.ausgeben("Es sind " + anzahlEintraege + " in der Datenreihe vorhanden");
    for(int t=0; t<anzahlEintraege; t=t+1){
      double aktuellerWert = daten.holeDoubleAnStelle(t);
      a.ausgeben("Eintrag " + t + " ist " + aktuellerWert);
    }
    
    
  }
}


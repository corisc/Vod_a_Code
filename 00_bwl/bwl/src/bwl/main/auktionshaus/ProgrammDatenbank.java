package bwl.main.auktionshaus;

import com.ml.connection.WebServer;
import com.ml.datenbank.Datenbank;
import com.ml.utils.Helfer;
import com.ml.views.AusgabeFenster;
import com.ml.views.DatenReihe;

public class ProgrammDatenbank {

  /**
   * @param args
   */
  public static void main(String[] args) {
    //CREATE TABLE produkt(name VARCHAR(20), preis INTEGER);
    //INSERT INTO produkt VALUES ('Handschuh', 12);
    //INSERT INTO produkt VALUES ('Schaal', 9);
    AusgabeFenster aus = new AusgabeFenster();
    
    Datenbank datenbank     = new Datenbank();
    DatenReihe dr = datenbank.abfrageDatenReihe("produkt", "NAME");
    int size = dr.liefereZahlDerEintraege();
    for(int t=0; t<size; t=t+1){
      aus.ausgeben("dr an Stelle: " + t + " " + dr.holeStringAnStelle(t));
    }
    DatenReihe dr2 = datenbank.abfrageDatenReihe("produkt", "PREIS");
    int size2 = dr2.liefereZahlDerEintraege();
    for(int t=0; t<size2; t=t+1){
      aus.ausgeben("dr2 an Stelle: " + t + " " + dr2.holeStringAnStelle(t));
    }
    
    Helfer helfer = new Helfer();
    String uhrzeit = helfer.liefereZeit();
    String webseite = "<HTML><TITLE>Hallo</TITLE><BODY><H1>Ich bin die Ueberschrift</H1><BR><P>";
    webseite = webseite + "</P><P><H1>Uhrzeit beim Start des Programmes war " + uhrzeit + "<H1></P><BR>";
    webseite = webseite + "</BODY></HTML>"; 
    
    WebServer webServer = new WebServer(webseite);
    webServer.start();

    
  }

}


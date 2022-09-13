package bwl.main.bericht;

import com.ml.connection.WebServer;
import com.ml.datenbank.Datenbank;

public class GeschaeftsberichtServer {

  public static void main(String[] args) {
    
    //CREATE TABLE absatz(ort VARCHAR(10), liter INTEGER);
    //INSERT INTO absatz VALUES ('muenchen', 1200);
    //INSERT INTO absatz VALUES ('augsburg', 900);

    int gesamt = 0;
    String webseite = "<HTML><TITLE>Bilanz 2010</TITLE><BODY><H1>Aral Konzern</H1><BR><P>";
    Datenbank datenbank     = new Datenbank();
    String[] verkaefeOrt    = datenbank.abfragenDatensaetze("absatz", "ort");
    int[] verkaefeLiter     = datenbank.abfragenDatensaetzeAlsInt("absatz", "liter");
    
    for(int t=0; t<verkaefeOrt.length; t++){
      webseite = webseite + "Verkauf Nr. " + t + " - ort: " + verkaefeOrt[t] + " Menge: " + verkaefeLiter[t] + "<BR>";
      gesamt    = gesamt + verkaefeLiter[t];
    }
    webseite = webseite + "</P><P><H1>Gesamtumsatz " + gesamt + "<H1></P><BR>";    
    webseite = webseite + "</BODY></HTML>"; 
    
    WebServer webServer = new WebServer(8080, webseite);
    webServer.start();
  }

}


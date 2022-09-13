package bwl;

import com.ml.connection.WebServer;
import com.ml.datenbank.Datenbank;

public class ServerVanessa {

  /**
   * @param args
   */
  public static void main(String[] args) {
  //   
  String webseite = "<HTML><TITLE>Von meinem Rechner</TITLE><BODY><H1>Aus einem Java Programm</H1><BR>";
  webseite = webseite + "<P>HALLO</P><BR>";
  
  Datenbank d = new Datenbank();
  String erg[] = d.abfragenDatensaetze("CITY", "NAME");
  for(int t=0; t<d.anzahlDerZeilen("CITY"); t=t+1){
    System.out.println("erg: " + erg[t]);    
  }
  
  // freechart.jar 
  // Chart c = new PieChart("Umsatz Mai",25%,rot, erg[].....)
  // c.generatePicture("c:/0_ml/0_ml_muell/fireworks.gif\");
  
  webseite = webseite + "<img src=\"c:/0_ml/0_ml_muell/fireworks.gif\"><BR>";
  
  webseite = webseite + "</BODY></HTML>"; 
  WebServer webServer = new WebServer(webseite);
  webServer.start();
  
  }

}


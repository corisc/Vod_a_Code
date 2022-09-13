package vf.scrum.coding;

import com.ml.connection.WebServer;
import com.ml.views.AusgabeFenster;

public class Training_3_Client {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    double modemVersion = 3.4;
    
    String infoImXMLFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" + 
    "<HARDWARE>"                                                   + "\n" +
      "<MODEMTYPE>"     +   modemVersion      + "</MODEMTYPE>"        + "\n" +
    "</HARDWARE>";

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben(infoImXMLFormat);
    
    WebServer webserver = new WebServer(infoImXMLFormat);
    webserver.start();
  }

}


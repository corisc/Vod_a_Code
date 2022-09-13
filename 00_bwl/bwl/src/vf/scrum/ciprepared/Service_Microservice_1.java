package vf.scrum.ciprepared;

import com.ml.connection.WebServer;
import com.ml.utils.Helfer;
import com.ml.views.AusgabeFenster;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Farbe;
import com.ml.views.Fenster;
import com.ml.views.Rechteck;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Service_Microservice_1 {

  /**
   //* @param args
   */
    public Service_Microservice_1(){
  
    Helfer h = new Helfer();

    String infoImXMLFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" + 
    "<SALES>"                                                   + "\n" +
      "<SHOPNUMBER>"     +   h.liefereZufallsZahl1bis100()      + "</SHOPNUMBER>"        + "\n" +
      "<AMOUNT>"     +   h.liefereZufallsZahl1bis1000()      + "</AMOUNT>"        + "\n" +
    "</SALES>";

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben(infoImXMLFormat);
    
    WebServer webserver = new WebServer(infoImXMLFormat);
    webserver.start();
  }

}


package vf.scrum.ci;

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

public class Training_06_MicroService {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    Helfer h = new Helfer();
    double shopnumber = h.liefereZufallsZahl1bis100();
    double amount = h.liefereZufallsZahl1bis1000();
    double revenue = amount * 25;

    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" + 
    "<SALES>"                                                   + "\n" +
      "<SHOPNUMBER>"     +    shopnumber     + "</SHOPNUMBER>"        + "\n" +
      "<AMOUNT>"     +     amount    + "</AMOUNT>"        + "\n" +
      "<REVENUE>"     +   revenue      + "</REVENUE>"        + "\n" +
    "</SALES>";

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Microservice started");
    
    WebServer webserver = new WebServer(xml);
    webserver.start();
  }

}


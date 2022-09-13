package bwl.main.nachricht;

import com.ml.views.AusgabeFenster;

public class Nachricht {
  
  public String nummer;
  public String text;
  
  public void errechnePreis(){
    AusgabeFenster a = new AusgabeFenster();
    double preis = (text.length() %160 + 1) * 29;
    a.ausgeben("Preis der sms: " + preis);
  }

}


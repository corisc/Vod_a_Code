package vf.scrum.ci;

import com.ml.connection.Anfrage;
import com.ml.utils.XMLAnalyse;
import com.ml.views.AusgabeFenster;
import com.ml.views.Text;
import com.ml.views.TextFeld;

import e.com.ml.utils.Test;

public class Training_07_Client {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Anfrage a = new Anfrage();
    String xml = a.durchfuehren("127.0.0.1");
    
    XMLAnalyse x = new XMLAnalyse(xml);
    
    double shopnumber = x.liefereZahl("//SALES/SHOPNUMBER");
    double amount = x.liefereZahl("//SALES/AMOUNT");
    double revenue = x.liefereZahl("//SALES/REVENUE");

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("shopnumber");
    aus.ausgeben(shopnumber);
    aus.ausgeben("amount");
    aus.ausgeben(amount);
    aus.ausgeben("revenue");
    aus.ausgeben(revenue);
    
  }

}


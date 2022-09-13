package vf.scrum.ci;

import com.ml.connection.Anfrage;
import com.ml.utils.XMLAnalyse;
import com.ml.views.AusgabeFenster;
import com.ml.views.Text;
import com.ml.views.TextFeld;

public class Training_5_Receive {

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

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Shopnumber: " + shopnumber);
    aus.ausgeben("Amount: " + amount);
    
    
  }

}


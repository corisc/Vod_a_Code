package vf.scrum.ci;

import com.ml.connection.Anfrage;
import com.ml.utils.XMLAnalyse;
import com.ml.views.AusgabeFenster;
import com.ml.views.Text;
import com.ml.views.TextFeld;

import e.com.ml.utils.Test;

public class Training_08_TestClient {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    
    Anfrage a = new Anfrage();
    String xml = a.durchfuehren("127.0.0.1");
    
    XMLAnalyse x = new XMLAnalyse(xml);
    
    double shopnumber = x.liefereZahl("//SALES/SHOPNUMBER");
    
    Test.wertGroesserNull("Shopnummer pruefen ob groesser 0", shopnumber);
    
    double amount = x.liefereZahl("//SALES/AMOUNT");
    double revenue = x.liefereZahl("//SALES/REVENUE");

    double erwarteterRevenue = amount * 25;
    Test.gleichheitFeststellen("Sales Anzahl", erwarteterRevenue, revenue);
  }

}


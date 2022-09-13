package vf.scrum.coding;

import com.ml.connection.Anfrage;
import com.ml.utils.XMLAnalyse;
import com.ml.views.AusgabeFenster;
import com.ml.views.Text;
import com.ml.views.TextFeld;

public class Training_4_Receive {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Anfrage a = new Anfrage();
    String xml = a.durchfuehren("127.0.0.1");

    XMLAnalyse x = new XMLAnalyse(xml);
    double modemVersion = x.liefereZahl("//HARDWARE/MODEMTYPE");

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Verison: " + modemVersion);
    
  }

}


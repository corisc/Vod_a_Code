package bwl.oo.paket10;

import com.ml.views.AusgabeFenster;

public class Zeit {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    Unternehmen u1 = new Unternehmen();
    u1.name = "SAP";
    u1.eintragHandelsRegister = 111;
    Unternehmen u2 = new Unternehmen();
    u2.name = "SAP";
    u2.eintragHandelsRegister = 111;
    Unternehmen u3 = new Unternehmen();
    u3.name = "SAP";
    u3.eintragHandelsRegister = 111;
    Unternehmen u4 = new Unternehmen();
    u4.name = "SAP";
    u4.eintragHandelsRegister = 111;
    
    String html = "<body><h1>" + u1.name + "</h1></body>";

    
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben(u1.name);
    aus.ausgeben(u1.eintragHandelsRegister);
  }

}


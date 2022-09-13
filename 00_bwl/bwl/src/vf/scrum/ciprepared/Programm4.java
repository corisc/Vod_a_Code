package vf.scrum.ciprepared;

import com.framework.SQLFenster;
import com.framework.server.BasicServer;
import com.framework.server.ParameterServer;
import com.ml.connection.*;
import com.ml.utils.*;
import com.ml.views.*;
import com.ml.datenbank.*;

import bwl.oo.paket1.*;
import bwl.oo.paket2.*;
import bwl.oo.paket3.*;

public class Programm4 {

  public static void main(String[] args) {

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

package bwl.main.baum;

import com.framework.server.ParameterServer;
import com.ml.utils.Helfer;
import com.ml.views.AusgabeFenster;

public class Programm {
  
  //http://127.0.0.1/bwl?para1=wert&para2=zzuuii&para3=zzz
  public static void main(String[] args) {

    ParameterServer parameterServer = new ParameterServer();
    parameterServer.start();
    Helfer h = new Helfer();
    AusgabeFenster a = new AusgabeFenster();
    
    for(int t=0; t<1000; t=t+1){
      if(parameterServer.datenEmpfangen() == true){
        String para1 = parameterServer.holeLetzteParameter().getProperty("para1");
        a.ausgeben("para1: " + para1);
      }
      h.warteMillis(1000);
      a.ausgeben("nix passiert");
    }
  }

}


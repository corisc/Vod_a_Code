package bwl;

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

public class Programm5 {

  public static void main(String[] args) {
    ZeichenFenster zei = new ZeichenFenster("Dax");
    zei.linieZeichnen(100, 100, 100, 500);
    zei.linieZeichnen(80, 100, 120, 100);
    zei.linieZeichnen(80, 300, 120, 300);
    zei.linieZeichnen(80, 500, 120, 500);
    zei.textZeichnen("9040", 50, 100, 16);
    zei.textZeichnen("9050", 50, 300, 16);
    zei.textZeichnen("9060", 50, 500, 16);

    
    
    Dax d = new Dax();
    AusgabeFenster aus = new AusgabeFenster();
    double kurs = d.getQuoteDax();
    double y = (kurs - 9040) * 20 + 100;
    double steps = y / 10;

    for (double t = 100; t <= y; t = t + steps) {
      zei.textZeichnen("Dax hat diesen Wert:" + kurs, 300,300,18);
      
    }
  }
}

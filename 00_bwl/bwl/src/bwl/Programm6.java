package bwl;

import bwl.oo.paket2.Abteilung;
import bwl.oo.paket2.Aufgabe;
import bwl.oo.paket2.FensterProjekte;
import bwl.oo.paket2.FensterUnternehmensHierarchie;
import bwl.oo.paket2.Mitarbeiter;
import bwl.oo.paket2.Projekt;
import bwl.oo.paket2.Unternehmen;

import com.framework.SQLFenster;
import com.ml.connection.WebServer;
import com.ml.datenbank.Datenbank;
import com.ml.utils.Dax;
import com.ml.utils.Helfer;
import com.ml.utils.XMLAnalyse;
import com.ml.views.AusgabeFenster;
import com.ml.views.Farbe;
import com.ml.views.Fenster;
import com.ml.views.Text;
import com.ml.views.ZeichenFenster;

public class Programm6 {

  public static void main(String[] args) {
    
    new Thread() {
      public void run() {
        SQLFenster s = new SQLFenster();
      }
    }.start();

    Datenbank datenbank = new Datenbank();
    datenbank.verarbeiteSQLBefehl("CREATE TABLE XYZ(FF VARCHAR(20));");

  }
}

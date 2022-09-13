package bwl.main.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.framework.SQLFenster;
import com.ml.datenbank.Datenbank;
import com.ml.utils.Helfer;

public class Programm7 {

  public static void main(String[] args) {

    // Zur Verfuegung stehende Bilder:
    // ausrufezeichen.jpg
    // banner.jpg
    // bannerfh.JPG (Viereckiges FH Logo)
    // fragezeichen.jpg
    // haken.jpg
    // sap_breit.jpg
    // sap.jpg
    // herz.jpg
    // start_bild.jpg (Fuer Splashscreens geeignet)

    // ab hier wird gestartet
    
    new Thread() {
      public void run() {
        SQLFenster s = new SQLFenster();
      }
    }.start();

    Datenbank datenbank = new Datenbank();
    datenbank.verarbeiteSQLBefehl("drop table PERSON2VERANSTALTUNG;");
    datenbank.verarbeiteSQLBefehl("drop table VERANSTALTUNG;");
    datenbank.verarbeiteSQLBefehl("drop table PERSON;");
    datenbank.loescheAlleTabellen();
    
    datenbank.verarbeiteSQLBefehl("CREATE TABLE PERSON(id CHAR(20),name CHAR(20), vorname CHAR(20), PRIMARY KEY(id));");

    datenbank.verarbeiteSQLBefehl("insert into person values('1','M','eee');");
    datenbank.verarbeiteSQLBefehl("insert into person values('2','Anni','fff');");
    datenbank.verarbeiteSQLBefehl("insert into person values('3','N','ggg');");
    
    try{
      Connection conn = null;
      Helfer h = new Helfer();
      String arbeitsverzeichnis = h.aktuellesArbeitsverzeichnis();
      Class.forName("org.hsqldb.jdbcDriver").newInstance();
      String url = "jdbc:hsqldb:file:"+ arbeitsverzeichnis + "/20_db/hsqldb/mydb";
      //String url = "jdbc:hsqldb:file:C:\\bwl2\\20_db\\hsqldb\\mydb";
      System.out.println("url " + url);
      conn = DriverManager.getConnection(url, "sa", "");       // Connection mit DB+Zugangsdaten fuettern
      conn.setAutoCommit(true);
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM PERSON");      

      while (rs.next()) {
        System.out.println("e: "+rs.getRow());
      }
      st.close();
    }
    catch (Exception se) {
      se.printStackTrace();
    }
    
    
    
//    Datenbank db = new Datenbank();
//    AusgabeFenster aus = new AusgabeFenster();
//    String abt = db.zeileAbfragen("abteilung", "name", 0);
//    aus.ausgeben("in zeile 1 steht " + abt);
//    int anzahlDerZeilen = db.anzahlDerZeilen("abteilung");
//    ComboBox co = new ComboBox();
//    for (int t = 0; t < anzahlDerZeilen; t = t + 1) {
//      abt = db.zeileAbfragen("abteilung", "name", t);
//      aus.ausgeben("in zeile " + t + " steht " + abt);
//      co.eintragHinzufuegen(abt);
//    }
//    Fenster f1 = new Fenster();
//    f1.zeige(co, 100, 100);
//    Schalter s1 = new Schalter("Auswaehlen");
//    f1.zeige(s1, 200, 200, 200);
//    s1.warteAufEingabe();
//    int ent = co.zahlDerEntscheidung();
//    aus.ausgeben("es wurde dieser Eintrag gewaehlt: " + ent);
  }
}
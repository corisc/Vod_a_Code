package bwl.main.datenbank;

import com.ml.datenbank.Datenbank;

public class DBWegraeumer {

  
  public static void main(String args[]){
    new DBWegraeumer();
  }
  
  /**
   //* @param args
   */
  public DBWegraeumer() {
    

    Datenbank datenbank = new Datenbank();
    datenbank.verarbeiteSQLBefehl("drop table staedte");
    datenbank.verarbeiteSQLBefehl("drop table personen");
    datenbank.verarbeiteSQLBefehl("drop table staedte");
    datenbank.verarbeiteSQLBefehl("drop table verkauf");
    datenbank.verarbeiteSQLBefehl("drop table cross_inhaber_tankstelle");
    datenbank.verarbeiteSQLBefehl("drop table tankstelle");
    datenbank.verarbeiteSQLBefehl("drop table inhaber");
    datenbank.verarbeiteSQLBefehl("drop table produkt");
    datenbank.verarbeiteSQLBefehl("drop table person");
    datenbank.verarbeiteSQLBefehl("drop table veranstaltung");
    datenbank.verarbeiteSQLBefehl("drop table student2veranstaltung");
    datenbank.verarbeiteSQLBefehl("drop table dozent2veranstaltung");
    datenbank.verarbeiteSQLBefehl("drop table student");
    datenbank.verarbeiteSQLBefehl("drop table dozent");

    datenbank.verarbeiteSQLBefehl("drop table bezleiter2filleiter");
    datenbank.verarbeiteSQLBefehl("drop table bezirksleiter");
    datenbank.verarbeiteSQLBefehl("drop table supermarkt");
    datenbank.verarbeiteSQLBefehl("drop table filialleiter");
    datenbank.verarbeiteSQLBefehl("drop table lehrer2zugang");
    datenbank.verarbeiteSQLBefehl("drop table lehrer");
    datenbank.verarbeiteSQLBefehl("drop table zugang");
    datenbank.verarbeiteSQLBefehl("drop table frz2eigtmer");
    datenbank.verarbeiteSQLBefehl("drop table fahrzeuge");
    datenbank.verarbeiteSQLBefehl("drop table eigentuemer");
  }

}

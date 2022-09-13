package bwl.main.datenbank;

import com.framework.SQLFenster;
import com.ml.datenbank.Datenbank;

public class InnerJoin {

  /**
   * @param args
   */
  public static void main(String[] args) {

    new Thread() {
      public void run() {
        SQLFenster s = new SQLFenster();
      }
    }.start();

    // https://www.script-example.com/sql-joins
    
    new DBWegraeumer();
    
    Datenbank datenbank = new Datenbank();
    datenbank.verarbeiteSQLBefehl("create table personen(id CHAR(100), vorname CHAR(100), nachname CHAR(100), plz CHAR(100), primary key (id));");

    datenbank.verarbeiteSQLBefehl("insert into personen VALUES ('1','Hannah','Mueller','10115');");
    datenbank.verarbeiteSQLBefehl("insert into personen VALUES ('2','Mia','Huber','1010');");
    datenbank.verarbeiteSQLBefehl("insert into personen VALUES ('3','Emilia','Gruber','80331');");
    datenbank.verarbeiteSQLBefehl("insert into personen VALUES ('4','Emma','Schmidt','3000');");
    datenbank.verarbeiteSQLBefehl("insert into personen VALUES ('5','Sophia','Weber','5020');");
    datenbank.verarbeiteSQLBefehl("insert into personen VALUES ('6','Lea','Meyer','22111');");
    
    datenbank.verarbeiteSQLBefehl("create table staedte(id CHAR(100), stadt CHAR(100), plz CHAR(100), primary key (id));");
    
    datenbank.verarbeiteSQLBefehl("insert into staedte VALUES ('1','Berlin','10115');");
    datenbank.verarbeiteSQLBefehl("insert into staedte VALUES ('2','Wien','1010');");
    datenbank.verarbeiteSQLBefehl("insert into staedte VALUES ('3','Salzburg','5020');");
    datenbank.verarbeiteSQLBefehl("insert into staedte VALUES ('4','Salzburg','5026');");
    datenbank.verarbeiteSQLBefehl("insert into staedte VALUES ('5','Muenchen','80331');");
    datenbank.verarbeiteSQLBefehl("insert into staedte VALUES ('6','Graz','8010');");
    
    
  }

}


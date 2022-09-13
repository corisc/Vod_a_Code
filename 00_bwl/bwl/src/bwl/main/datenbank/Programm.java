package bwl.main.datenbank;

import com.ml.datenbank.Datenbank;
import com.ml.views.AusgabeFenster;

public class Programm {

  public static void main(String[] args) {

    // http://www.hsqldb.org/doc/guide/ch09.html
    
    Datenbank datenbank = new Datenbank();
    //datenbank.verarbeiteSQLBefehl("INSERT INTO ML1 VALUES (1, 'andrew');");
    //datenbank.verarbeiteSQLBefehl("CREATE TABLE PERSON(id CHAR(2),name VARCHAR(20), PRIMARY KEY(id));");
    //String erg[] = datenbank.abfragenDatensaetze("PERSON", "NAME");
    //System.out.println("erg: " + erg[0]);
    //datenbank.verarbeiteSQLBefehl("CREATE TABLE ML2(a INTEGER, b VARCHAR(10));");
    //datenbank.verarbeiteSQLBefehl("INSERT INTO ML2 VALUES (1, 2);");
    //String erg[] = datenbank.abfragenDatensaetze("ML2", "a");
    //System.out.println("erg: " + erg[0]);
    //datenbank.verarbeiteSQLBefehl("CREATE TABLE SUPER (LITER VARCHAR(10));");
    
    //CREATE TABLE ort (id INTEGER, bezeichner VARCHAR(10));
    //ALTER TABLE ort ADD PRIMARY KEY (id);
    //INSERT INTO ort VALUES (0, 'augsburg');
    //CREATE TABLE absatz(id INTEGER, liter INTEGER, FOREIGN KEY (id) REFERENCES ort (id));
    //INSERT INTO absatz VALUES (0, 1200);
    //INSERT INTO absatz VALUES (3, 1200);
    //INSERT INTO absatz VALUES (1, 300);

    //ALTER TABLE absatz ADD COLUMN (typus VARCHAR(10));
    //UPDATE absatz SET typus = 'SUPER' WHERE ID = 0;
    //UPDATE absatz SET typus = 'SUPER' WHERE ID = 1;
    //ALTER TABLE absatz DROP COLUMN typus;
    
    
    //CREATE TABLE treibstoff (id INTEGER, treibstoffart VARCHAR(10), PRIMARY KEY (id));
    //INSERT INTO treibstoff VALUES (0, 'super');
    //INSERT INTO treibstoff VALUES (1, 'diesel');
    
    //ALTER TABLE absatz ADD COLUMN id_treibstoff INTEGER;
    //ALTER TABLE absatz ADD FOREIGN KEY (id_treibstoff) REFERENCES treibstoff (id);
    //UPDATE absatz SET id_treibstoff = 0 WHERE ID = 0;
    //UPDATE absatz SET id_treibstoff = 1 WHERE ID = 1;
        
    String erg[] = datenbank.abfragenDatensaetze("ort", "bezeichner");
    System.out.println("erg: " + erg[0]);
    for(int t=0; t<erg.length; t++){
      System.out.println(t + ". Eintrag: " + erg[t]);
    }

    String erg1[] = datenbank.abfragenDatensaetze("absatz", "liter");
    for(int t=0; t<erg1.length; t++){
      System.out.println(t + ". Eintrag: " + erg1[t]);
    }

    
  }
}

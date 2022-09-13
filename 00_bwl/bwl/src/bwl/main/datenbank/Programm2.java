package bwl.main.datenbank;

import com.ml.datenbank.Datenbank;

public class Programm2 {

  /**
   * @param args
   */
  public static void main(String[] args) {
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
    
    Datenbank datenbank     = new Datenbank();
    datenbank.verarbeiteSQLBefehl("drop table verkauf");
    datenbank.verarbeiteSQLBefehl("drop table cross_inhaber_tankstelle");
    datenbank.verarbeiteSQLBefehl("drop table tankstelle");
    datenbank.verarbeiteSQLBefehl("drop table inhaber");
    datenbank.verarbeiteSQLBefehl("drop table produkt");

    datenbank.verarbeiteSQLBefehl("create table tankstelle(id CHAR(2),ort VARCHAR(20), PRIMARY KEY(id));");
    datenbank.verarbeiteSQLBefehl("insert into tankstelle VALUES (1, 'Coburg');");
    datenbank.verarbeiteSQLBefehl("insert into tankstelle VALUES (2, 'Nuernberg');");
    datenbank.verarbeiteSQLBefehl("insert into tankstelle VALUES (3, 'Augsburg');");
    datenbank.abfragen("select * from tankstelle");
    
    datenbank.verarbeiteSQLBefehl("create table inhaber(name VARCHAR(20), id CHAR(2), FOREIGN KEY (id) REFERENCES tankstelle (id));");
    datenbank.verarbeiteSQLBefehl("insert into inhaber VALUES ('Markus', 1);");
    datenbank.verarbeiteSQLBefehl("insert into inhaber VALUES ('Stefan', 2);");
    
    datenbank.abfragen("select * from inhaber");

    datenbank.verarbeiteSQLBefehl("drop table inhaber");

    datenbank.verarbeiteSQLBefehl("drop table inhaber");
    datenbank.verarbeiteSQLBefehl("insert into inhaber VALUES (1, 'Markus');");
    datenbank.verarbeiteSQLBefehl("insert into inhaber VALUES (2, 'Stefan');");
    
    datenbank.abfragen("select * from inhaber");
    
    datenbank.verarbeiteSQLBefehl("create table cross_inhaber_tankstelle (id_inh CHAR(2),id_tankstelle CHAR(2), " +
    		"FOREIGN KEY (id_inh) REFERENCES inhaber(id), FOREIGN KEY (id_tankstelle) REFERENCES tankstelle(id));");
    datenbank.verarbeiteSQLBefehl("insert into cross_inhaber_tankstelle VALUES (1, 1);");
    datenbank.verarbeiteSQLBefehl("insert into cross_inhaber_tankstelle VALUES (1, 2);");
    datenbank.verarbeiteSQLBefehl("insert into cross_inhaber_tankstelle VALUES (2, 3);");
   
    datenbank.abfragen("select * from cross_inhaber_tankstelle");
    datenbank.abfragen("select inhaber.id from inhaber where inhaber.name = 'Markus'");
    datenbank.abfragen("select * from inhaber, cross_inhaber_tankstelle, tankstelle where inhaber.id = cross_inhaber_tankstelle.id_inh and cross_inhaber_tankstelle.id_tankstelle = tankstelle.id;");
    datenbank.abfragen("select * from inhaber, cross_inhaber_tankstelle, tankstelle where inhaber.id = cross_inhaber_tankstelle.id_inh and cross_inhaber_tankstelle.id_tankstelle = tankstelle.id and inhaber.name='Markus';");
    datenbank.abfragen("select ort from inhaber, cross_inhaber_tankstelle, tankstelle where inhaber.id = cross_inhaber_tankstelle.id_inh and cross_inhaber_tankstelle.id_tankstelle = tankstelle.id and inhaber.name='Markus';");
    
    datenbank.verarbeiteSQLBefehl("create table produkt(id CHAR(2), name VARCHAR(20), PRIMARY KEY (id));");
    datenbank.verarbeiteSQLBefehl("insert into produkt VALUES (0, 'super');");
    datenbank.verarbeiteSQLBefehl("insert into produkt VALUES (1, 'diesel');");
    datenbank.abfragen("select * from produkt");
    
    datenbank.verarbeiteSQLBefehl("create table verkauf(zeit TIMESTAMP, id_ort CHAR(2), betrag DECIMAL(10,2), FOREIGN KEY (id_ort) REFERENCES tankstelle (id));");
    datenbank.verarbeiteSQLBefehl("insert into verkauf VALUES ('2010-11-28 16:42:58',1,55.76);");
    datenbank.verarbeiteSQLBefehl("insert into verkauf VALUES ('2010-11-28 16:55:58',1,89.22);");
    datenbank.abfragen("select * from verkauf");
    
  }

}


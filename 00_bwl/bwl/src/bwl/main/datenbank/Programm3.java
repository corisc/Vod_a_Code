package bwl.main.datenbank;

import com.ml.datenbank.Datenbank;
import com.ml.utils.SortierungKurs;
import com.ml.views.Bild;
import com.ml.views.ComboBox;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Programm3 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    Datenbank datenbank     = new Datenbank();
    datenbank.verarbeiteSQLBefehl("drop table kurs");
    datenbank.verarbeiteSQLBefehl("drop table student");

    datenbank.verarbeiteSQLBefehl("create table student(id CHAR(2),nachname VARCHAR(20), PRIMARY KEY(id));");
    datenbank.verarbeiteSQLBefehl("insert into student VALUES (1, 'Triller');");
    datenbank.verarbeiteSQLBefehl("insert into student VALUES (2, 'Huber');");
    datenbank.verarbeiteSQLBefehl("insert into student VALUES (3, 'Maier');");
    datenbank.abfragen("select * from student");
    
    datenbank.verarbeiteSQLBefehl("create table kurs(kursid CHAR(2), name VARCHAR(20), id CHAR(2), FOREIGN KEY (id) REFERENCES student (id));");
    datenbank.verarbeiteSQLBefehl("insert into kurs VALUES (1, 'wi', 1);");
    datenbank.verarbeiteSQLBefehl("insert into kurs VALUES (2, 'buchhaltung', 2);");
    
    datenbank.abfragen("select * from kurs");

    datenbank.verarbeiteSQLBefehl("drop table kurs");

    datenbank.verarbeiteSQLBefehl("create table kurs(kursid CHAR(2), name VARCHAR(20), id CHAR(2), FOREIGN KEY (id) REFERENCES student (id));");
    datenbank.verarbeiteSQLBefehl("insert into kurs VALUES (1, 'wi', 1);");
    datenbank.verarbeiteSQLBefehl("insert into kurs VALUES (2, 'buchhaltung', 2);");
    
    datenbank.abfragen("select * from kurs");
    
    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("banner.jpg");
    w.zeige(b, 50, 50);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Studentenverwaltung");
    w.zeige(u, 50, 200);

    Text t1 = new Text("Geben sie eine Nummer ein");
    w.zeige(t1, 50, 300);

    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 320, 200);

    Text t2 = new Text("Geben Sie einen Namen ein");
    w.zeige(t2, 50, 360);

    EingabeFeld e2 = new EingabeFeld();
    w.zeige(e2, 50, 380, 200);

    Schalter s1 = new Schalter("Speichern");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();
    
    String nummer       = e1.getText();
    String name         = e2.getText();
    
    datenbank.verarbeiteSQLBefehl("insert into student VALUES (" + nummer + ", '" + name + "');");
    
    int anzahlEintraegeKurse = datenbank.anzahlDerZeilen("kurs");
    
    Fenster w1 = new Fenster("Eingabe");
    Bild b1 = new Bild("banner.jpg");
    w1.zeige(b1, 50, 50);

    // Ueberschrift
    Ueberschrift u1 = new Ueberschrift("Kurse");
    w1.zeige(u1, 50, 200);

    Text t3 = new Text("Kurs von " + name);
    w1.zeige(t3, 50, 300);
    
    ComboBox co = new ComboBox();
    
    for(int t = 0;t<anzahlEintraegeKurse; t++){
      String kursname = datenbank.zeileAbfragen("kurs", "name", t);
      System.out.println(""+kursname);
      co.eintragHinzufuegen(kursname);
    }
    w1.zeige(co, 50, 400);
    
    Schalter s2 = new Schalter("Speichern");
    w1.zeige(s2, 450, 380, 200);

    s2.warteAufEingabe();

    System.out.println(""+ co.zahlDerEntscheidung());
  }
}


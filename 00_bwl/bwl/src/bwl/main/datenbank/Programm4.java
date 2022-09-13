package bwl.main.datenbank;

import com.ml.datenbank.Datenbank;
import com.ml.utils.SortierungKurs;
import com.ml.views.AusgabeFenster;
import com.ml.views.Bild;
import com.ml.views.ComboBox;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Programm4 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    Datenbank datenbank     = new Datenbank();
    datenbank.verarbeiteSQLBefehl("drop table pinnwandeintrag");
    datenbank.verarbeiteSQLBefehl("drop table partner");
    datenbank.verarbeiteSQLBefehl("drop table greeting");
    datenbank.verarbeiteSQLBefehl("drop table person");

    datenbank.verarbeiteSQLBefehl("create table person(id CHAR(2),nickname VARCHAR(20), PRIMARY KEY(id));");
    datenbank.verarbeiteSQLBefehl("insert into person VALUES (1, 'tom');");
    datenbank.verarbeiteSQLBefehl("insert into person VALUES (2, 'jerry');");
    datenbank.verarbeiteSQLBefehl("insert into person VALUES (3, 'spike');");
    datenbank.abfragen("select * from person");
    
    datenbank.verarbeiteSQLBefehl("create table greeting(text VARCHAR(200), id CHAR(2), FOREIGN KEY(id) REFERENCES person(id));");
    datenbank.verarbeiteSQLBefehl("insert into greeting VALUES ('jaeger', 1);");
    datenbank.verarbeiteSQLBefehl("insert into greeting VALUES ('gejagter', 2);");
    datenbank.verarbeiteSQLBefehl("insert into greeting VALUES ('frisst alle', 3);");
    
    datenbank.abfragen("select * from greeting");

    datenbank.verarbeiteSQLBefehl("create table partner(id_profil_person CHAR(2), id_profil_partner CHAR(2), FOREIGN KEY(id_profil_person) REFERENCES person(id), FOREIGN KEY(id_profil_partner) REFERENCES person(id));");
    datenbank.verarbeiteSQLBefehl("insert into partner VALUES (1, 2);");
    datenbank.verarbeiteSQLBefehl("insert into partner VALUES (2, 3);");
    
    datenbank.abfragen("select * from partner");
    
    datenbank.verarbeiteSQLBefehl("create table pinnwandeintrag(id CHAR(2),text VARCHAR(200), id_person CHAR(2), PRIMARY KEY(id), FOREIGN KEY(id_person) REFERENCES person(id));");
    datenbank.verarbeiteSQLBefehl("insert into pinnwandeintrag VALUES (1, 'ist gerne maeuse',1);");
    datenbank.verarbeiteSQLBefehl("insert into pinnwandeintrag VALUES (2, 'ist gerne kaese',2);");
    datenbank.verarbeiteSQLBefehl("insert into pinnwandeintrag VALUES (3, 'haengt an der kette',3);");

    datenbank.abfragen("select * from pinnwandeintrag");

    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("banner.jpg");
    w.zeige(b, 50, 50);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Facebook Verwaltung");
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
    
    datenbank.verarbeiteSQLBefehl("insert into person VALUES (" + nummer + ", '" + name + "');");
    
    int anzahlEintraegePersonen = datenbank.anzahlDerZeilen("person");
    
    Fenster w1 = new Fenster("Eingabe");
    Bild b1 = new Bild("banner.jpg");
    w1.zeige(b1, 50, 50);

    // Ueberschrift
    Ueberschrift u1 = new Ueberschrift("Verwaltung Nachrichten");
    w1.zeige(u1, 50, 200);

    ComboBox co = new ComboBox();
    
    for(int t = 0;t<anzahlEintraegePersonen; t++){
      String nickname = datenbank.zeileAbfragen("person", "nickname", t);
      System.out.println(""+nickname);
      co.eintragHinzufuegen(nickname);
    }
    w1.zeige(co, 50, 400);
    
    Schalter s2 = new Schalter("Speichern");
    w1.zeige(s2, 450, 380, 200);

    s2.warteAufEingabe();

    System.out.println(""+ co.zahlDerEntscheidung());
    int entscheidung = co.zahlDerEntscheidung();
    
    Text t4 = new Text("Bitte gib die Nachricht ein");
    w1.zeige(t4, 50, 360);

    EingabeFeld e3 = new EingabeFeld();
    w1.zeige(e3, 50, 380, 200);

    Schalter s3 = new Schalter("Speichern");
    w1.zeige(s3, 250, 380, 200);

    s3.warteAufEingabe();
    w1.loeschen();

    int anzahlEintraegeNachrichten = datenbank.anzahlDerZeilen("pinnwandeintrag");
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("insert into pinnwandeintrag VALUES (" + (anzahlEintraegeNachrichten+1) + ", " + entscheidung + ", '" + e3.getText() + "');");
    datenbank.verarbeiteSQLBefehl("insert into pinnwandeintrag VALUES (" + (anzahlEintraegeNachrichten+1) + ", '" + e3.getText() + "'," + entscheidung + ");");

  }
}


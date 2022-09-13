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

public class Programm5 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    Datenbank datenbank     = new Datenbank();
//    datenbank.verarbeiteSQLBefehl("drop table halter");
//    datenbank.verarbeiteSQLBefehl("drop table man");

//    datenbank.verarbeiteSQLBefehl("create table man(id CHAR(2),name CHAR(20), PRIMARY KEY(id));");
//    datenbank.verarbeiteSQLBefehl("insert into man VALUES (1, 'pkw');");
//    datenbank.verarbeiteSQLBefehl("insert into man VALUES (2, 'lkw');");
//    datenbank.verarbeiteSQLBefehl("insert into man VALUES (3, 'anhaenger');");
//
//    datenbank.verarbeiteSQLBefehl("create table halter(kennzeichen VARCHAR(10), name CHAR(200), id_man char(2));");
//    datenbank.abfragen("select * from halter");

    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("banner.jpg");
    w.zeige(b, 50, 50);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Zulassungsstelle");
    w.zeige(u, 50, 150);

    ComboBox co = new ComboBox();
    int anzahlEintraegeKategorie = datenbank.anzahlDerZeilen("man");
    System.out.println("www "+anzahlEintraegeKategorie);
    
    for(int t = 0;t<anzahlEintraegeKategorie; t++){
      String nickname = datenbank.zeileAbfragen("man", "name", t);
      System.out.println(""+nickname);
      co.eintragHinzufuegen(nickname);
    }
    w.zeige(co, 50, 250);
    
    Schalter s2 = new Schalter("Waehlen");
    w.zeige(s2, 300, 250, 200);

    s2.warteAufEingabe();

    int entscheidung = co.zahlDerEntscheidung();
    System.out.println(""+ entscheidung);


    Text t1 = new Text("Geben sie eine Kennzeichen ein");
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
    
    datenbank.verarbeiteSQLBefehl("insert into halter VALUES ('" + nummer + "', '" + name + "', " + entscheidung + ");");
    
    AusgabeFenster aus = new AusgabeFenster("Alle Kennzeichen");
    aus.ausgeben("Alle Kennzeichen");
    int anzahlReiheHalter = datenbank.anzahlDerZeilen("halter");
    for(int t=0; t<anzahlReiheHalter; t=t+1){
      String halter = datenbank.zeileAbfragen("halter", "kennzeichen", t);
      aus.ausgeben(halter);
    }
    

  }
}


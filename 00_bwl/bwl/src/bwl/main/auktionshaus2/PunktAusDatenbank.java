package bwl.main.auktionshaus2;

import com.ml.datenbank.Datenbank;
import com.ml.views.AusgabeFenster;
import com.ml.views.DatenReihe;
import com.ml.views.Permutator;
import com.ml.views.ZeichenFenster;

public class PunktAusDatenbank {

  public static void main(String[] args) {
//    Datenbank datenbank = new Datenbank();
//    datenbank.verarbeiteSQLBefehl("DROP TABLE amazon;");
//    datenbank.verarbeiteSQLBefehl("CREATE TABLE produkt(produktid VARCHAR(20), name VARCHAR(20), posx VARCHAR(20), posy VARCHAR(20), PRIMARY KEY(produktid));");
//    datenbank.verarbeiteSQLBefehl("INSERT INTO produkt VALUES ('1000110', 'auto', 100, 100);");
//    datenbank.verarbeiteSQLBefehl("INSERT INTO produkt VALUES ('1000111', 'besen', 150, 300);");
//    datenbank.verarbeiteSQLBefehl("INSERT INTO produkt VALUES ('1000112', 'chlor', 200, 250);");
//    datenbank.verarbeiteSQLBefehl("INSERT INTO produkt VALUES ('1000113', 'dose', 50, 150);");
//    datenbank.verarbeiteSQLBefehl("INSERT INTO produkt VALUES ('1000114', 'eimer', 350, 300);");

    Datenbank d = new Datenbank();
    int anzahlDerZeilen = 0;
    anzahlDerZeilen = d.anzahlDerZeilen("produkt");
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben(anzahlDerZeilen);
    for(int t=0;t<anzahlDerZeilen;t=t+1){
      aus.ausgeben(d.zeileAbfragen("produkt", "produktid" , t));
    }
    for(int t=0;t<anzahlDerZeilen;t=t+1){
      aus.ausgeben(d.zeileAbfragen("produkt", "name" , t));
    }
    for(int t=0;t<anzahlDerZeilen;t=t+1){
      aus.ausgeben(d.zeileAbfragen("produkt", "posx" , t));
    }
    for(int t=0;t<anzahlDerZeilen;t=t+1){
      aus.ausgeben(d.zeileAbfragen("produkt", "posy" , t));
    }

    ZeichenFenster fenster = new ZeichenFenster("Lager");
    fenster.kreisZeichnen(0,0,4);
    fenster.textZeichnen("start", 0+10, 0+10);
    fenster.linieZeichnen(0, 0, 100, 100);
    
    String name;
    double posx=0;
    double posy=0;
    for(int t=0;t<anzahlDerZeilen;t=t+1){
      name = d.zeileAbfragen("produkt", "name" , t);
      posx = d.zeileAbfragenDouble("produkt", "posx" , t);
      posy = d.zeileAbfragenDouble("produkt", "posy" , t);
      //Punkt p = new Punkt(posx, posy, name);
      fenster.kreisZeichnen(posx,posy,4);
      fenster.textZeichnen(name, posx+10, posy+10);
    }
    
    Permutator per = new Permutator();
    String perms = per.zeigeAllePermutationen("a","b","c","d","e","f");
    AusgabeFenster aus3 = new AusgabeFenster();
    aus3.zeilenumbruchlosesAusgeben(perms);
    
    per = new Permutator();
    AusgabeFenster aus4 = new AusgabeFenster();
    for(int a=0;a<24;a++){
      DatenReihe re = per.permutiere(a, 10,10,20,20,30,30,40,40);
      for(int t=0;t<re.liefereZahlDerEintraege();t++){
        aus4.zeilenumbruchlosesAusgeben(re.holeDoubleAnStelle(t) + " ");
      }
      aus4.ausgeben("");
    }
    
    
  }
}


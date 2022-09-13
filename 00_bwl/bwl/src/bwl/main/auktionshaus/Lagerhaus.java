package bwl.main.auktionshaus;

import com.ml.views.DatenReihe;

public class Lagerhaus {

  public int        lagerhausnummer;
  public DatenReihe lagerplaetze;

  public Lagerhaus() {
    super();
  }

  public Lagerhaus(int lagerhausnummer) {
    this.lagerhausnummer = lagerhausnummer;
    this.lagerplaetze = new DatenReihe();
  }

  public void lagerplatzHinzufuegen(Lagerplatz lp){
    this.lagerplaetze.hinzufuegen(lp);
  }
  
  public DatenReihe liefereProduktOrteX(){
    DatenReihe datenReihe = new DatenReihe();
    datenReihe.hinzufuegen(600d);
    datenReihe.hinzufuegen(690d);
    datenReihe.hinzufuegen(250d);
    datenReihe.hinzufuegen(475d);
    datenReihe.hinzufuegen(300d);
    datenReihe.hinzufuegen(490d);
    datenReihe.hinzufuegen(130d);
    datenReihe.hinzufuegen(630d);
    datenReihe.hinzufuegen(440d);
    datenReihe.hinzufuegen(475d);
    datenReihe.hinzufuegen(210d);
    datenReihe.hinzufuegen(250d);
    datenReihe.hinzufuegen(640d);
    datenReihe.hinzufuegen(375d);
    datenReihe.hinzufuegen(20d);
    datenReihe.hinzufuegen(30d);
    datenReihe.hinzufuegen(775d);
    datenReihe.hinzufuegen(700d);
    datenReihe.hinzufuegen(730d);
    datenReihe.hinzufuegen(730d);
    datenReihe.hinzufuegen(790d);
    return datenReihe;
  }
  
  public DatenReihe liefereProduktOrteY(){
    DatenReihe datenReihe = new DatenReihe();
    datenReihe.hinzufuegen(250d);
    datenReihe.hinzufuegen(640d);
    datenReihe.hinzufuegen(375d);
    datenReihe.hinzufuegen(20d);
    datenReihe.hinzufuegen(30d);
    datenReihe.hinzufuegen(475d);
    datenReihe.hinzufuegen(500d);
    datenReihe.hinzufuegen(630d);
    datenReihe.hinzufuegen(530d);
    datenReihe.hinzufuegen(390d);
    datenReihe.hinzufuegen(510d);
    datenReihe.hinzufuegen(600d);
    datenReihe.hinzufuegen(90d);
    datenReihe.hinzufuegen(450d);
    datenReihe.hinzufuegen(75d);
    datenReihe.hinzufuegen(500d);
    datenReihe.hinzufuegen(90d);
    datenReihe.hinzufuegen(630d);
    datenReihe.hinzufuegen(430d);
    datenReihe.hinzufuegen(40d);
    datenReihe.hinzufuegen(75d);
    return datenReihe;
  }
  
  public DatenReihe liefereProduktNamen(){
    DatenReihe datenReihe = new DatenReihe();
    datenReihe.hinzufuegen("Batterie");
    datenReihe.hinzufuegen("Lampe");
    datenReihe.hinzufuegen("Tisch");
    datenReihe.hinzufuegen("Tasse");
    datenReihe.hinzufuegen("Monitor");
    datenReihe.hinzufuegen("Blume");
    datenReihe.hinzufuegen("Tresor");
    datenReihe.hinzufuegen("Zucker");
    datenReihe.hinzufuegen("Fernseher");
    datenReihe.hinzufuegen("Bild");
    datenReihe.hinzufuegen("Heizer");
    datenReihe.hinzufuegen("Stuhl");
    datenReihe.hinzufuegen("Glas");
    datenReihe.hinzufuegen("Ziegel");
    datenReihe.hinzufuegen("Label");
    datenReihe.hinzufuegen("Empfaenger");
    datenReihe.hinzufuegen("Holzente");
    datenReihe.hinzufuegen("Rad");
    datenReihe.hinzufuegen("CD");
    datenReihe.hinzufuegen("Platte");
    datenReihe.hinzufuegen("Tastatur");
    return datenReihe;
  }
  
  
  public DatenReihe liefereProduktOrteX10(){
    DatenReihe datenReihe = new DatenReihe();
    datenReihe.hinzufuegen(600d);
    datenReihe.hinzufuegen(690d);
    datenReihe.hinzufuegen(250d);
    datenReihe.hinzufuegen(475d);
    return datenReihe;
  }
  
  public DatenReihe liefereProduktOrteY10(){
    DatenReihe datenReihe = new DatenReihe();
    datenReihe.hinzufuegen(250d);
    datenReihe.hinzufuegen(640d);
    datenReihe.hinzufuegen(375d);
    datenReihe.hinzufuegen(20d);
    return datenReihe;
  }
  
  public DatenReihe liefereProduktNamen10(){
    DatenReihe datenReihe = new DatenReihe();
    datenReihe.hinzufuegen("Batterie");
    datenReihe.hinzufuegen("Lampe");
    datenReihe.hinzufuegen("Tisch");
    datenReihe.hinzufuegen("Tasse");
    return datenReihe;
  }

}


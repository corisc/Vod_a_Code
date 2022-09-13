package bwl.main.oo2;

import java.util.Vector;

import com.ml.views.AusgabeFenster;

public class Lager {

  public Vector<Produkt> produkte = new Vector<Produkt>(11);
  public Vector<String> produktart = new Vector<String>(11);

  public Lager(){
  }
  
  public void neuesProduktAnlegen(Produkt produkt){
    this.produkte.add(produkt);
    this.produktart.add(produkt.name);
  }
  
  public void zeigeAlleProdukte(){
    AusgabeFenster aus = new AusgabeFenster("Produktbestand");
    for(Produkt p : this.produkte){
      aus.ausgeben("Name: " + p.name + " Bestand: " + p.bestand);
      aus.ausgeben("==========================");
    }
  }
  
  public void verkaufProdukt(String name, int anzahl){
    for(Produkt p : this.produkte){
      if(p.name.equals(name)){
        p.bestand = p.bestand - anzahl;
      }
    }
  }
}


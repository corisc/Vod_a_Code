package bwl.main.oo2;

import com.ml.utils.Helfer;

public class Start {

  public static void main(String[] args) {
    Helfer h = new Helfer();
    
    Lager l = new Lager();
    LagerDarstellung lDarstellung = new LagerDarstellung();
    lDarstellung.zeigeLagerZustand(l);

    h.warteSeks(3);
    
    Produkt p1 = new Produkt("Wodka", 5);
    l.neuesProduktAnlegen(p1);
    lDarstellung.zeigeLagerZustand(l);
    
    h.warteSeks(3);

    Produkt p2 = new Produkt("Rum", 3);
    l.neuesProduktAnlegen(p2);
    lDarstellung.zeigeLagerZustand(l);
    
    h.warteSeks(3);

    l.verkaufProdukt("Wodka", 2);
    lDarstellung.zeigeLagerZustand(l);

    
  }

}


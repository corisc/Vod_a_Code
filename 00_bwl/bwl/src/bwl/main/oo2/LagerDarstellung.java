package bwl.main.oo2;

import java.util.Vector;

import com.ml.views.ZeichenFenster;

public class LagerDarstellung {
  
  private ZeichenFenster zf;
  
  public LagerDarstellung(){
    this.zf = new ZeichenFenster("Lager");
  }
  
  public void zeigeLagerZustand(Lager lager){
    zf.loeschen();
    double aktuelleSpalteobenLinks = 200;
    
    for(Produkt p : lager.produkte){
      zf.kreisZeichnen(aktuelleSpalteobenLinks, this.bestimmeZeileIndex(lager, p) * 240, 80);
      zf.textZeichnen(p.name , aktuelleSpalteobenLinks - 28, this.bestimmeZeileIndex(lager, p) * 240, 24, "rot");
      zf.textZeichnen(""+p.bestand , aktuelleSpalteobenLinks - 28, this.bestimmeZeileIndex(lager, p) * 240 - 40, 24, "rot");
    }
  }
  
  private int bestimmeZeileIndex(Lager l, Produkt p){
    for(int t=0;t < l.produktart.size(); t++){
      if(l.produktart.get(t).equalsIgnoreCase(p.name)){
        return t+1;
      }
    }
    return 0;
  }

}


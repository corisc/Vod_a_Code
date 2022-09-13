package bwl.oo.paket2;

import com.ml.views.ZeichenFenster;

public class FensterUnternehmensHierarchie {
  
  public Unternehmen unternehmen;

  public FensterUnternehmensHierarchie(Unternehmen unternehmen) {
    super();
    this.unternehmen = unternehmen;
  }
  
  public void anzeigen(){
    ZeichenFenster zf = new ZeichenFenster("Unternehmen");
    
    // Koordinatensystem
    zf.linieZeichnen(50, 600, 850, 600, 5);
    zf.linieZeichnen(50, 500, 850, 500, 5);
    
    int anzahlDerAbteilungen = unternehmen.liefereWievieleAbteilungen();
    int abstandZwischenDenVertikalenStrichen =  800 / anzahlDerAbteilungen;
    
    int xKoordinate = 50;
    for(int durchlauf = 1; durchlauf <= anzahlDerAbteilungen; durchlauf = durchlauf +1){
      zf.linieZeichnen(xKoordinate, 600, xKoordinate, 500, 3);
      zf.textZeichnen(unternehmen.liefereAbteilung(durchlauf).name, xKoordinate + (abstandZwischenDenVertikalenStrichen/2) - 50, 550, 16);
      xKoordinate = xKoordinate + abstandZwischenDenVertikalenStrichen;
    }
    zf.linieZeichnen(850, 600, 850, 500, 3);
    
    zf.textZeichnen(unternehmen.name, 430, 630, 20, "blau");
    
  }

}


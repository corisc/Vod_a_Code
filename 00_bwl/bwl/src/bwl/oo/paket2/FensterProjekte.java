package bwl.oo.paket2;

import com.ml.views.ZeichenFenster;

public class FensterProjekte {
  
  public Unternehmen unternehmen;

  public FensterProjekte(Unternehmen unternehmen) {
    super();
    this.unternehmen = unternehmen;
  }
  
  public void anzeigen(){
    ZeichenFenster zf = new ZeichenFenster("Unternehmen");
    
    // Koordinatensystem
    zf.linieZeichnen(50, 600, 450, 600, 5);
    zf.linieZeichnen(50, 100, 450, 100, 5);
    zf.linieZeichnen(50, 100, 50, 600, 5);
    zf.linieZeichnen(450, 100, 450, 600, 5);
    
    int anzahlDerProjekte = unternehmen.liefereWievieleProjekte();
    int abstandZwischenDenHorizontalenStrichen =  500 / anzahlDerProjekte;
    
    int yKoordinate = 100+abstandZwischenDenHorizontalenStrichen;
    for(int durchlauf = 1; durchlauf <= anzahlDerProjekte; durchlauf = durchlauf +1){
      zf.linieZeichnen(50, yKoordinate, 450, yKoordinate, 3);
      yKoordinate = yKoordinate + abstandZwischenDenHorizontalenStrichen;
    }

    yKoordinate = 100;
    for(int durchlauf = 1; durchlauf <= anzahlDerProjekte; durchlauf = durchlauf +1){
      zf.textZeichnen(unternehmen.liefereProjekt(durchlauf).titel, 120, yKoordinate + (abstandZwischenDenHorizontalenStrichen/2), 16);
      yKoordinate = yKoordinate + abstandZwischenDenHorizontalenStrichen;
    }

    zf.textZeichnen(unternehmen.name, 430, 630, 20, "blau");
    
  }

}


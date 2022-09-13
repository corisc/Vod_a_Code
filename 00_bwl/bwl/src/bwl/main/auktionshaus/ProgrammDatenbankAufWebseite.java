package bwl.main.auktionshaus;

import com.ml.connection.WebServer;
import com.ml.views.AusgabeFenster;
import com.ml.views.DatenReihe;

public class ProgrammDatenbankAufWebseite {

  public static void main(String[] args) {
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("hallo");
    String seite = "<html>" + "\n";
    seite = seite + "<head>" + "\n";
    seite = seite + "<title>" + "\n";
    seite = seite + "amazon light" + "\n";
    seite = seite + "</title>" + "\n";
    seite = seite + "</head>" + "\n";
    seite = seite + "<body>" + "\n";
    seite = seite + "<h1>" + "\n";
    seite = seite + "Kaufhaus" + "\n";
    seite = seite + "</h1>" + "\n";
    
    seite = seite + "<h2>" + "\n";
    seite = seite + "Produkte" + "\n";
    seite = seite + "</h2>" + "\n";

    DatenReihe d = new DatenReihe();
    d.hinzufuegen("Muetze");
    d.hinzufuegen("Schaal");
    d.hinzufuegen("Handschuh");

    DatenReihe dp = new DatenReihe();
    dp.hinzufuegen("2.5");
    dp.hinzufuegen("2.8");    
    dp.hinzufuegen("4.6");
    
    for(int t = 0;t<d.liefereZahlDerEintraege();t=t+1){
      seite = seite + d.holeStringAnStelle(t);
      seite = seite + "&nbsp;" + dp.holeStringAnStelle(t);
      seite = seite + "<br>";
    }
    
    seite = seite + "</body>" + "\n";
    seite = seite + "</html>" + "\n";
    aus.ausgeben("So sieht unsere Seite aus:");
    aus.ausgeben(seite);
    WebServer web = new WebServer(seite);
    web.start();

  
  }
}


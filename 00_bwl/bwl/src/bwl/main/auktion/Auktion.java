package bwl.main.auktion;

import com.ml.connection.WebServer;
import com.ml.datenbank.Datenbank;
import com.ml.views.FrageFenster;

public class Auktion {

  public static void main(String[] args) {
    
    String webseite = "<HTML><TITLE>Auktionshaus</TITLE><BODY><H1>Auktionshaus</H1><BR>";
    
    if(false){
    
      for(int t=1; t<1000; t++){
        FrageFenster nameDesArtikelsFenster = new FrageFenster("Auktion: " + t, "Name des Artikels:");
        String nameDesArtikels = nameDesArtikelsFenster.getText();
        
        if(nameDesArtikels.equals("")){
          break;
        }
        
        FrageFenster preisDesArtikelsFenster = new FrageFenster("Auktion: " + t, "Preis des Artikels:");
        int preisDesArtikels = preisDesArtikelsFenster.getZahl();
        
        webseite = webseite + "<P>Artikel Nr. " + t + ":" + nameDesArtikels + " Preis: " + preisDesArtikels + "</P><BR>"; 
        
      }
    }
    else{
      Datenbank d = new Datenbank();
      String produkt = d.zeileAbfragen("produkt", "name", 9);
      webseite = webseite + "<P>Produkt " + produkt + "</P><BR>";       
    }
    
    
    webseite = webseite + "</BODY></HTML>"; 
    System.out.println(""+ webseite);
    
    WebServer webServer = new WebServer(webseite);
    webServer.start();
  }

}


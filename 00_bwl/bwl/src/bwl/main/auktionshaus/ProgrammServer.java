package bwl.main.auktionshaus;

// import com.ml.connection.WebServer;
// import com.ml.utils.Helfer;
import com.ml.views.DatenReihe;

public class ProgrammServer {

  public static void main(String[] args) {
//    Helfer helfer = new Helfer();
//    String uhrzeit = helfer.liefereZeit();
//    String webseite = "<HTML><TITLE>Hallo</TITLE><BODY><H1>Ich bin die Ueberschrift</H1><BR><P>";
//    webseite = webseite + "</P><P><H1>Uhrzeit beim Start des Programmes war " + uhrzeit + "<H1></P><BR>";    
//    webseite = webseite + "</BODY></HTML>"; 
//    
//    WebServer webServer = new WebServer(webseite);
//    webServer.start();

    DatenReihe reiheVonArtikeln = new DatenReihe();
    
    reiheVonArtikeln.hinzufuegen("Produkt A");
    reiheVonArtikeln.hinzufuegen("Produkt B");
    reiheVonArtikeln.hinzufuegen("Produkt C");
  }

}


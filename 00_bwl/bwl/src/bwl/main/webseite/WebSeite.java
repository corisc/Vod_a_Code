package bwl.main.webseite;

import com.framework.SQLFenster;
import com.ml.connection.WebServer;
import com.ml.datenbank.Datenbank;
import com.ml.utils.Helfer;
import com.ml.views.FrageFenster;
import com.ml.views.QuestionWindow;

public class WebSeite {

  public static void main(String[] args) {
    
        
    new Thread() {
      public void run() {
        Helfer helfer = new Helfer();
        String uhrzeit = helfer.liefereZeit();
        String webseite = "<HTML><TITLE>Hallo</TITLE><BODY><H1>Ich bin die Ueberschrift</H1><BR><P>";
        webseite = webseite + "</P><P><H1>Uhrzeit beim Start des Programmes war " + uhrzeit + "<H1></P><BR>";    
        webseite = webseite + "</BODY></HTML>"; 
        WebServer webServer = new WebServer(80, webseite);
        webServer.start();
      }
    }.start();
    
    
    System.out.println(""+11111);
  }

}


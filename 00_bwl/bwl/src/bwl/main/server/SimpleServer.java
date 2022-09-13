package bwl.main.server;

import com.ml.connection.WebServer;
import com.ml.views.FrageFenster;
import com.ml.views.QuestionWindow;

public class SimpleServer {

  public static void main(String[] args) {
    
//    String webseite = "<HTML><TITLE>Von meinem Rechner</TITLE><BODY><H1>Aus einem Java Programm</H1><BR>";
//    webseite = webseite + "<P>HALLO</P><BR>"; 
//    webseite = webseite + "</BODY></HTML>"; 
//    WebServer webServer = new WebServer(webseite);
//    webServer.start();
    
    String info = "";
    FrageFenster einFenster = new FrageFenster("Eingabe", "Info zum Anzeigen:");
    info = einFenster.getText();
    WebServer webServer = new WebServer(info);
    webServer.start();
  }

}


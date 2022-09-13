package micro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MicroserviceKontostand {

  // http://127.0.0.1:80/microserviceKontostand?token=2222

  public MicroserviceKontostand() {
  }

  public void antworteAufRequest() {

    ServerSocket s;

    // System.out.println("Webserver starting up on port 80");
    // System.out.println("(press ctrl-c to exit)");
    try {
      // create the main server socket
      s = new ServerSocket(80);
    } catch (Exception e) {
      System.out
          .println("Vermutlich laeuft noch das vorher gestartete Fenster. Das Programm kann nicht zweimal laufen, bitte das alte Fenster erst schlie�en.");
      System.out.println("");
      System.out.println("Ergebenste Grue�e, Markus Leue");
      System.out.println("Error: " + e);
      return;
    }

    System.out.println("Waiting for connection");
    for (;;) {
      try {
        // wait for a connection
        Socket remote = s.accept();
        // remote is now the connected socket
        System.out.println("Connection, sending data.");
        BufferedReader in = new BufferedReader(new InputStreamReader(
            remote.getInputStream()));
        PrintWriter out = new PrintWriter(remote.getOutputStream());

        // read the data sent. We basically ignore it,
        // stop reading once a blank line is hit. This
        // blank line signals the end of the client HTTP
        // headers.
        String str = ".";
        StringBuffer sb = new StringBuffer();
        while (!str.equals("")) {
          str = in.readLine();
          sb.append(str);
        }
        System.out.println("Anfrage: " + sb);
        String wasKamVomBrowserAn = sb.toString();
        // Send the response
        // Send the headers
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        // Send the HTML page
        out.flush();
        remote.close();
      } catch (Exception e) {
        System.out.println("Error: " + e);
      }
    }
  }
}

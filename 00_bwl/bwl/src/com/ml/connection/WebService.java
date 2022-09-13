package com.ml.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import com.conf.BasicEnvConfiguration;

// https://coderanch.com/t/560718/java/Socket-interrupt-serverSocket-accept

public class WebService {
  private static final byte END_WAITING = 66;
  
  private String antwort;

  private int port = BasicEnvConfiguration.AUSSENSTELLE_PORT;

  public WebService(String antwort) {
    this.antwort = antwort;
  }

  public WebService(int port, String antwort) {
    this.antwort = antwort;
    this.port = port;
  }

  /**
   * WebServer constructor.
   */
  public void start() {
    this.zeigeIPAdresse();

    ServerSocket s;

    // System.out.println("Webserver starting up on port 80");
    // System.out.println("(press ctrl-c to exit)");
    try {
      // create the main server socket
      s = new ServerSocket(this.port);
    } catch (Exception e) {
      System.out
          .println("Vermutlich laeuft noch das vorher gestartete Fenster. Das Programm kann nicht zweimal laufen, bitte das alte Fenster erst schließen.");
      System.out.println("");
      System.out.println("Ergebenste Grueße, Markus Leue");
      System.out.println("Error: " + e);
      return;
    }

    System.out.println("Waiting for connection");
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
//        if (sb.substring(0, 2).equals(END_WAITING)
//        /*&& clientSock.getInetAddress().getHostAddress().equals(myIp)*/) {
//          // End waiting clients code detected
//          break;
//        }
        // Send the response
        // Send the headers
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        // Send the HTML page
        if (this.antwort.length() > 100) {
          out.println(this.antwort);
        } else {
          out.println(this.antwort);
          // out.println("<H1>" + this.antwort + "</H1>");
        }
        out.flush();
        remote.close();
        this.acceptClients();
      } catch (Exception e) {
        System.out.println("Error: " + e);
      }
    }

  private void zeigeIPAdresse() {
    String text = "";
    Vector<String> ipAdressen = this.ipAdresseBestimmen();

    for (int t = 0; t < ipAdressen.size(); t++) {
      text = "  " + "IP: " + ipAdressen.get(t) + "  ";

      System.out.println("" + text);
    }

  }

  private Vector<String> ipAdresseBestimmen() {

    Vector<String> ipAdressen = new Vector<String>(1);

    try {
      InetAddress address = InetAddress.getLocalHost();
      String ipAdresse = address.getHostName();

      for (InetAddress ia : InetAddress.getAllByName(ipAdresse)) {
        ipAdressen.add(ia.getHostAddress());
      }

    } catch (UnknownHostException e) {
      ipAdressen.add("???.???.???.???");
    }

    return ipAdressen;
  }
  
  void acceptClients() {
    try {
         Socket s = new Socket("127.0.0.1", 80);
         s.getOutputStream().write(END_WAITING);
         s.getOutputStream().flush();
         s.close();
    } catch (IOException e) {
    }
}

}
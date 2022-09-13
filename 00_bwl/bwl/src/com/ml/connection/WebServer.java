package com.ml.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.conf.BasicEnvConfiguration;

public class WebServer {

  private String antwort;
  private int    port = BasicEnvConfiguration.AUSSENSTELLE_PORT;
  
  public WebServer(String antwort){
    this.antwort = antwort;
  }
  
  public WebServer(int port, String antwort){
    this.antwort = antwort;
    this.port    = port;
  }

  /**
   * WebServer constructor.
   */
  public void start() {
    this.zeigeIPAdresse();
    
    ServerSocket s;

//    System.out.println("Webserver starting up on port 80");
//    System.out.println("(press ctrl-c to exit)");
    try {
      // create the main server socket
      s = new ServerSocket(this.port);
    } catch (Exception e) {
      System.out.println("Vermutlich laeuft noch das vorher gestartete Fenster. Das Programm kann nicht zweimal laufen, bitte das alte Fenster erst schließen.");
      System.out.println("");
      System.out.println("Ergebenste Grueße, Markus Leue");
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
        BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
        PrintWriter out = new PrintWriter(remote.getOutputStream());

        // read the data sent. We basically ignore it,
        // stop reading once a blank line is hit. This
        // blank line signals the end of the client HTTP
        // headers.
        String str = ".";
        StringBuffer sb= new StringBuffer();
        while (!str.equals("")){
          str = in.readLine();
          sb.append(str);
        }
        System.out.println("Anfrage: "  + sb);
        // Send the response
        // Send the headers
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        // Send the HTML page
        if(this.antwort.length() > 100){
          out.println(this.antwort);
        }
        else{
          out.println(this.antwort);
          //out.println("<H1>" + this.antwort + "</H1>");
        }
        out.flush();
        remote.close();
      }
      catch (Exception e) {
        System.out.println("Error: " + e);
      }
    }
  }
  
  private void zeigeIPAdresse(){
    IPAdressFenster ipAdressFenster = new IPAdressFenster(50,50);
    
  }
}
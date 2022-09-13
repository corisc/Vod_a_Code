package com.framework.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicServer extends Thread{
  private String                    antwort;
  private InetAddress               askingAdress;
  private ServerSocket              s;
  private volatile boolean          stop = false;
  private HttpAnswerThread          httpAnswerThread;
  private ParameterServer           parameterServer;
  
  public BasicServer(ParameterServer parameterServer){
    this.parameterServer = parameterServer;
  }
  
  /**
   * WebServer constructor.
   */
  public void start() {
    ServerSocket s;

    try {
      // create the main server socket
      s = new ServerSocket(80);
    } catch (Exception e) {
      System.out.println("Kann nicht starten. Wahrscheinlich lauft das Programm nochmal. Erst das Alte stoppen und dann nochmal starten bitte.");
      return;
    }

    //System.out.println("Waiting for connection");
    for (;;) {
      try {
        Socket remote = s.accept();
        this.httpAnswerThread = new HttpAnswerThread(remote);
        this.httpAnswerThread.start();
        while(!this.httpAnswerThread.isFlagAbgearbeitet()){
        }
        this.parameterServer.empfange(this.httpAnswerThread.getParaProperties());
      }
      catch (Exception e) {
        System.out.println("Error aus Basic: " + e);
        e.printStackTrace();
      }
    }
  }

  public HttpAnswerThread getHttpAnswerThread() {
    return httpAnswerThread;
  }
  
  
}


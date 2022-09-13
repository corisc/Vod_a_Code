package com.framework.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Properties;

public class HttpAnswerThread extends Thread{

  
  private Socket                    remote;
  private InetAddress               askingAdress;
  private Properties                paraProperties;
  private boolean                   flagAngekommen      = false;
  private boolean                   flagAbgearbeitet    = false;
  
  public HttpAnswerThread(Socket remote) {
    super();
    this.remote                     = remote;
  }

  public void run(){
    try {
      this.askingAdress    =            remote.getInetAddress();
      BufferedReader  in              = new BufferedReader(new InputStreamReader(remote.getInputStream()));
      PrintWriter     out             = new PrintWriter(remote.getOutputStream());
  
      String requestData = "";
      String userInput;
      userInput = in.readLine();
      requestData = requestData + userInput;
      try{
        this.paraProperties = this.readRequestParams(requestData);
        //Nur schnell
        if(this.paraProperties.containsKey("nummer")){
          System.out.println("nummer Parameter gefunden");
        }
      }
      catch(Exception e){
        System.out.println("Es war kein lesbarer Parameter vorhanden");
        e.printStackTrace();
      }
      this.flagAngekommen = true;
      String antwort = this.generateError();
      if(userInput != null && userInput.indexOf("bwl") > -1){
        antwort = this.generateAnswer();
      }
      out.println("HTTP/1.0 200 OK");
      out.println("Content-Type: text/html");
      out.println("Server: Bot");
      // this blank line signals the end of the headers
      out.println("");
      out.println(antwort);          
      out.flush();
      System.out.println("Antwort wird gesendet");
      remote.close();
      this.flagAbgearbeitet = true;
    }
    catch (Exception e) {
      System.out.println("Error aus Thread: " + e);
    }
  }

  private String generateError(){
    String answer = "";
    answer = answer + "<html>" + "\n";
    answer = answer + " <head>" + "\n";
    answer = answer + "     <title>Servus</title>" + "\n";
    answer = answer + "     " + "\n";
    answer = answer + " </head>" + "\n";
    answer = answer + "" + "\n";
    answer = answer +   "<body bgcolor=\""+ "#" + "AAAAAA" + "\" style=\"margin:0px; padding:0px;\">" + "\n";
    answer = answer + " <!-- Trenner -->" + "\n";
    answer = answer + " Die Seite die angefordert wurde existiert nicht. " + "\n";
    answer = answer + " </body>" + "\n";
    answer = answer + "" + "\n";
    answer = answer + "</html>"    + "\n";

    return answer;
  }
  
  private String generateAnswer(){
    String answer = "";
    answer = answer + "<html>" + "\n";
    answer = answer + " <head>" + "\n";
    answer = answer + "     <title>Servus</title>" + "\n";
    answer = answer + "     " + "\n";
    answer = answer + " </head>" + "\n";
    answer = answer + "" + "\n";
    answer = answer +   "<body bgcolor=\""+ "#" + "AAAAAA" + "\" style=\"margin:0px; padding:0px;\">" + "\n";
    answer = answer + " <!-- Trenner -->" + "\n";
    answer = answer + " Ergebnis angekommen. Naechste Seite." + "\n";
    answer = answer + " </body>" + "\n";
    answer = answer + "" + "\n";
    answer = answer + "</html>"    + "\n";

    return answer;
  }

  // http://127.0.0.1/bwl.html?para=1&para=2
  public Properties readRequestParams(String req){
    System.out.println("req: " + req);
    String[]    answer  = null;
    String      word    = "";
    req = req.substring(0,req.lastIndexOf(" "));
    if(req.contains("?")){
      word =   req.substring(req.lastIndexOf("?")+1);
      answer = word.split("&");
    }
    String s;
    for(int t=0; t<answer.length;t++){
      s = answer[t];
      try {
        answer[t] = URLDecoder.decode(s,"UTF-8");
      } catch (UnsupportedEncodingException e) {
        System.out.println("Der Parameter \"" + s + "\" enthielt ein Zeichen das nicht UTF 8 entsprach");
        return null;
      }
      System.out.println("t:" + s);
    }
    Properties pAnswer = new Properties();
    String key;
    String value;
    try{
      for(String ganz:answer){
        key   = ganz.substring(0, ganz.indexOf("="));
        value = ganz.substring(ganz.indexOf("=")+1);
        pAnswer.setProperty(key, value);
      }
    }
    catch(Exception e){
      System.out.println("Es konnte ein Parameter nicht isoliert werden");
    }
    System.out.println("p: " + pAnswer);
    return pAnswer;
  }

  public Properties getParaProperties() {
    return paraProperties;
  }

  public boolean isFlagAngekommen() {
    return flagAngekommen;
  }

  public boolean isFlagAbgearbeitet() {
    return flagAbgearbeitet;
  }

  
}


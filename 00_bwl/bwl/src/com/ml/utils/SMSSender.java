package com.ml.utils;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

//import bwl.main.nachricht.Nachricht;

import com.conf.BasicEnvConfiguration;

public class SMSSender {
  
  private String    proxyUrl;
  private int       proxyPort;

  private String    serverHost      = "gateway2.mobilant.net";

  private String    serverUrl       = "/index.php";
  private String    serverProtocol  = "http";
  private int       serverPort      = 8080;
  


  public SMSSender(String proxyUrl, int proxyPort){
    this.proxyUrl   = proxyUrl;
    this.proxyPort  = proxyPort;
  }
  
  public SMSSender(){
    this.proxyPort = BasicEnvConfiguration.PROXY_PORT;
    this.proxyUrl = BasicEnvConfiguration.DECIDE_PROXY();
  }

  public SMSSender(boolean auto){
    if(auto){
      Authenticator.setDefault(new ProxyAuthenticator("user", "password"));
      System.setProperty("http.proxyHost", "proxy host");
      System.setProperty("http.proxyPort", "port");
    }
    else{
      this.proxyUrl = BasicEnvConfiguration.DECIDE_PROXY();
    }
  }

//  public void sende(Nachricht nachricht){
//    this.sende(nachricht.nummer, nachricht.text);
//  }

  public boolean send(String sendNumber, String sendText){
    return this.sende(sendNumber, sendText);
  }
  
  public boolean sende(String sendeNummer, String sendeText){
    // String k = this.getMIS().trim(); Wenn Server lokal
    String k = BasicEnvConfiguration.DECIDE_MIS_VIA_WEB_OR_MASTER();
    if(k.equals("nix")){
      System.out.println("Passwort fuer den SMS Versand konnte nicht geholt werden. Dies geht nur waehrend der Uebung.");
      System.out.println("Die Nachricht: " + sendeText + " waere sonst an die nummer " + sendeNummer + " gesendet worden");
      return true;
    }
    
    String ersteZahl = sendeNummer.substring(0,1);
    if(ersteZahl.equals("0")){
      sendeNummer = sendeNummer.substring(1,sendeNummer.length());
    }
    // System.out.println("Nummer an die gesendet wird: 0" + sendeNummer);
    
    PostMethod                          method            = null;
    NameValuePair[]                     requestParameters = null;
    boolean                             success           = true;
    MultiThreadedHttpConnectionManager  manager;
    HttpClient                          httpClient;

    
    
    try {
      HostConfiguration hostConfig = new HostConfiguration();
      if(this.proxyUrl != null){
        hostConfig.setProxy(this.proxyUrl, this.proxyPort);
      }
      
      hostConfig.setHost(this.serverHost,this.serverPort,this.serverProtocol);
      manager  = new MultiThreadedHttpConnectionManager();
      
      httpClient = new HttpClient(manager);
      httpClient.setHostConfiguration(hostConfig);
      
      // Convert Properties to NameValuePair
      
      requestParameters = new NameValuePair[5];
      requestParameters[0] = new NameValuePair("key", k);
      requestParameters[1] = new NameValuePair("service","sms");
      requestParameters[2] = new NameValuePair("originator","mba");
      requestParameters[3] = new NameValuePair("receiver","0049" + sendeNummer);
      requestParameters[4] = new NameValuePair("message", sendeText);
      // requestParameters[5] = new NameValuePair("type","low");
      
      method = new PostMethod(this.serverUrl);
      method.setQueryString(requestParameters);

      // System.out.println("sending this request: " + hostConfig.getHostURL() + this.serverUrl + "?" + method.getQueryString());
      long timeStart = System.currentTimeMillis();
      // execute
      int result = httpClient.executeMethod(method);
      // int result = HttpStatus.SC_OK;
      // int result = 999;
      long timeStop = System.currentTimeMillis();
      
      double timeTook = (timeStop - timeStart);
      
      // System.out.println("request answer status: "  + result);
      // System.out.println("duration for request: "   + timeTook);
      
      if(result == HttpStatus.SC_OK){
        String answer = new String(method.getResponseBody());
        System.out.println(""+answer);
        System.out.println("sms sent");
      }
      else{
      success = false;
      System.out.println("sms failed");
      }
    }
    catch(Exception e){
      e.printStackTrace();
      success = false;
    }
    finally {
      try{
        method.releaseConnection();
        //System.exit(0);
      }
      catch(Exception ex){
      }
    }
    
    return success;
  }
    
  public static void main(String[] args) {
    //SMSSender httpSender = new SMSSender(BasicEnvConfiguration.PROXY_HOST, BasicEnvConfiguration.PROXY_PORT);
    //httpSender.sende("01774861717", "bla");
    
    SMSSender httpSender = new SMSSender(true);
    httpSender.sende("01774861717", "bla");

  }
  
  class ProxyAuthenticator extends Authenticator {

    private String user, password;

    public ProxyAuthenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password.toCharArray());
    }
}

}

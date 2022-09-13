package com.ml.connection;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import com.conf.BasicEnvConfiguration;

public class AnfrageWeb {

  private final int          port                = 80;
  private final String       protocol            = "http";
  private final String       url                 = "";
  private final String       proxyUrl            = null;
  private final int          proxyPort           = 3128;
  private final Properties   requestProperties   = null;
  private final String       controlPattern      = "";
  private final boolean      showAnswer          = false;
  

  public String durchfuehren(String server){
    String result = "";
    result = this.durchfuehren(server, this.port, this.protocol, this.url, this.proxyUrl, this.proxyPort, this.requestProperties, this.controlPattern, this.showAnswer);
    return result;
  }
  
  public String durchfuehrenOhneServerMuenchen(String server){
    String result = 
      "<VERKAUF>"            + "\n" +
      "<MANTEL>"            + "\n" +
        "<PREIS>175</PREIS>"         + "\n" +
        "<ANZAHL>22</ANZAHL>"       + "\n" +
      "</MANTEL>"            + "\n" +
      "<HOSEN>"            + "\n" +
        "<PREIS>90</PREIS>"         + "\n" +
        "<ANZAHL>43</ANZAHL>"       + "\n" +
      "</HOSEN>"            + "\n" +
    "</VERKAUF>"            + "\n";
    return result;
  }
  
  public String durchfuehrenOhneServerBerlin(String server){
    String result = 
    "<VERKAUF>"            + "\n" +
    "<MANTEL>"            + "\n" +
      "<PREIS>163</PREIS>"         + "\n" +
      "<ANZAHL>43</ANZAHL>"       + "\n" +
    "</MANTEL>"            + "\n" +
    "<HOSEN>"            + "\n" +
      "<PREIS>87</PREIS>"         + "\n" +
      "<ANZAHL>73</ANZAHL>"       + "\n" +
    "</HOSEN>"            + "\n" +
  "</VERKAUF>"            + "\n";
    return result;
  }
  
  public String durchfuehren(String host, int port, String protocol, String url, String proxyUrl, int proxyPort, Properties requestProperties,
      String controlPattern, boolean showAnswer) {

    // Zur Identifizierung um die Aufrufzeit zu loggen
    boolean           isQuoteRequestFlag                    = false;
    String            answer = "nix";

    // Fuer die Identifikation ob logout gelungen
    PostMethod                          method              = null;
    NameValuePair[]                     requestParameters   = null;

    MultiThreadedHttpConnectionManager  manager;
    HttpClient                          httpClient;

    try {
      HostConfiguration hostConfig = new HostConfiguration();
      hostConfig.setHost(host, port, protocol);
      if (proxyUrl != null) {
        hostConfig.setProxy(proxyUrl, proxyPort);
      }

      HttpConnectionManagerParams httpConnectionManagerParams = new HttpConnectionManagerParams();
      httpConnectionManagerParams.setStaleCheckingEnabled(true);
      manager = new MultiThreadedHttpConnectionManager();
      manager.setParams(httpConnectionManagerParams);
      httpClient = new HttpClient();
      httpClient.setHostConfiguration(hostConfig);
      httpClient.getParams().setSoTimeout(100);
      // Convert Properties to NameValuePair
      if(requestProperties !=  null){
        requestParameters = new NameValuePair[requestProperties.size()];
        Enumeration<Object> parametersEnum = requestProperties.keys();
        int count = 0;
        String key;
        String value;
        while (parametersEnum.hasMoreElements()) {
          key   = (String) parametersEnum.nextElement();
          value = requestProperties.getProperty(key);
          requestParameters[count] = new NameValuePair(key, value);
          // Um die quoteRequestzeit zu loggen
          count++;
        }
      }

      method = new PostMethod(url);
      if(requestParameters != null){
        method.setQueryString(requestParameters);
      }

      // info
      if(showAnswer){
        System.out.println("sending this request: " + hostConfig.getHostURL() + url + "?"
          + method.getQueryString());
      }
      long timeStart = System.currentTimeMillis();
      // execute
      int result = httpClient.executeMethod(method);
      long timeStop = System.currentTimeMillis();
      
      // loggen der Quoteaufrufzeit
      if(isQuoteRequestFlag){
        System.out.println("Aufrufzeit Quote Request: " + (timeStop - timeStart));
      }

      if (result == HttpStatus.SC_OK
          || result == HttpStatus.SC_MOVED_TEMPORARILY
          || result == HttpStatus.SC_MOVED_PERMANENTLY) {
        
        byte[] responseBody = new byte[10240];             

        InputStream istream = method.getResponseBodyAsStream();
        int pos = 0;
        int read = 0;
        while ((read = istream.read(responseBody, pos,
                responseBody.length - pos)) >= 0) {
            pos += read;
            if (pos >= responseBody.length) {
                byte[] tmp = new byte[pos + 51200];
                System.arraycopy(responseBody, 0, tmp, 0, pos);
                responseBody = tmp;
            }
        }

        answer = new String(responseBody, 0, pos);
        
        
      } else {
        System.out.println("request failed");
      }
    } catch (Exception e) {
    } finally {
      try {
        method.releaseConnection();
      } catch (Exception ex) {
      }
    }    
    return answer;
  }
  
  public static void main(String args[]){
    AnfrageWeb anfrageWeb = new AnfrageWeb();
    // server, this.port, this.protocol, this.url, this.proxyUrl, this.proxyPort, this.requestProperties, this.controlPattern, this.showAnswer
    // private String durchfuehren(String host, int port, String protocol, String url, String proxyUrl, int proxyPort, Properties requestProperties,
    System.out.println("!!!" + anfrageWeb.durchfuehren("81.169.154.70", 80, "http", "/sender/erste.html", BasicEnvConfiguration.PROXY_HOST, BasicEnvConfiguration.PROXY_PORT, null, "", true));    
  }
}


package com.conf;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ml.connection.Anfrage;
import com.ml.connection.AnfrageWeb;
import com.ml.utils.XMLAnalyse;

/**
 * Klasse die die Einstellungen ueber alle Uebungsklassen hinweg setzt.
 * 
 * 
 */
public class BasicEnvConfiguration {

  public static final boolean VIA_MASTER_RECHNER = false;

  public static final String MASTER_RECHNER = "127.0.0.1";

  public static final boolean PASSWORT_DIREKT = true;

  public static final String PROXY_HOST = "webproxy.kabeldeutschland.de"; // "vproxy.kabeldeutschland.de";

  public static String publisherUser = "testuser2";
  public static String publicPWD = "3333";

  // public static final String PROXY_HOST = null;
  // //"webgit-dev.kabeldeutschland.de"; //"vproxy.kabeldeutschland.de";
  public static final int PROXY_PORT = 3128;

  // public static final String PROXY_HOST = null; //"proxy.elaxy.org";
  // public static final int PROXY_PORT = 3128;
  public static final int AUSSENSTELLE_PORT = 80;

  public static String HELPER_ARBEITSVERZEICHNIS_OVERWRITE = null; //".";

  public static String DECIDE_MIS_VIA_WEB_OR_MASTER() {
    if (PASSWORT_DIREKT) {
      return day("05851cebd121a88f2d4b57963c34d37");
    }
    if (VIA_MASTER_RECHNER) {
      return BasicEnvConfiguration.getMIS();
    } else {
      return BasicEnvConfiguration.getMISWeb();
    }
  }

  public static int calculate(){
    return (new Integer(BasicEnvConfiguration.publicPWD).intValue() * 3);
  }

  /**
   * Hier wird eingestellt, dass bei einem Geschaeftsrechner der Proxy verwendet
   * wird.
   * 
   * @return
   */
  public static String DECIDE_PROXY() {
    String computername = "";
    Map<String, String> env = System.getenv();
    if (env.containsKey("COMPUTERNAME")) {
      computername = env.get("COMPUTERNAME");
    } else {
      if (env.containsKey("HOSTNAME")) {
        computername = env.get("HOSTNAME");
      }
    }
    System.out.println("PC Name: " + computername);
    
    return null;
    /**
    if (computername == null) {
      return null;
    }
    if (computername.startsWith("L")) {
      System.out.println("Computer Name beginnt mit L vermutlich VKD");
      return "webproxy.kabeldeutschland.de";
    }
    if (computername != null && computername.startsWith("E")) {
      System.out.println("Computer Name beginnt mit E vermutlich VF");
      return "139.7.95.74";
    }
    return null;
    **/
  }

  private static String getMIS() {
    Anfrage anfrage = new Anfrage();
    String res = anfrage.durchfuehren(BasicEnvConfiguration.MASTER_RECHNER);
    if (res.equals("nix")) {
      return "nix";
    }
    XMLAnalyse xmAnalyse = new XMLAnalyse(res);
    String ort = xmAnalyse.liefere("//MIS");
    // System.out.println("Der Ort wurde analysiert: " + ort);

    return ort.trim();
  }

  private static String getMISWeb() {
    AnfrageWeb anfrageWeb = new AnfrageWeb();
    // String res = anfrageWeb.durchfuehren("81.169.154.70", 80, "http",
    // "/sender/erste.html", BasicEnvConfiguration.PROXY_HOST,
    // BasicEnvConfiguration.PROXY_PORT, null, "", false);
    String res = anfrageWeb.durchfuehren("81.169.154.70", 80, "http",
        "/sender/erste.html", BasicEnvConfiguration.PROXY_HOST,
        BasicEnvConfiguration.PROXY_PORT, null, "", false);
    if (res.equals("nix")) {
      return "nix";
    }
    XMLAnalyse xmAnalyse = new XMLAnalyse(res);
    String ort = xmAnalyse.liefere("//html/body");
    // System.out.println("Der Ort wurde analysiert: " + ort);

    return ort.trim();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    BasicEnvConfiguration.testProxy();
  }

  private static String day(String pw) {
    SimpleDateFormat formatter = new SimpleDateFormat("d");
    Date currentTime = new Date();
    return pw
        + new Integer((new Integer(formatter.format(currentTime)) + 7))
            .toString();
  }

  public static void testProxy() {
    try {
      System.setProperty("java.net.useSystemProxies", "true");
      List<Proxy> l = ProxySelector.getDefault().select(
          new URI("http://www.yahoo.com/"));

      for (Iterator<Proxy> iter = l.iterator(); iter.hasNext();) {

        Proxy proxy = iter.next();

        System.out.println("proxy hostname : " + proxy.type());

        InetSocketAddress addr = (InetSocketAddress) proxy.address();

        if (addr == null) {

          System.out.println("No Proxy");

        } else {
          System.out.println("proxy hostname : " + addr.getHostName());
          System.out.println("proxy port : " + addr.getPort());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  

}

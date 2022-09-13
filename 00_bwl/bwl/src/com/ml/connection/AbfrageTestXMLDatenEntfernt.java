package com.ml.connection;

public class AbfrageTestXMLDatenEntfernt {

  /**
   * @param args
   */
  public static void main(String[] args) {
//    String result = "";
//    result = this.durchfuehren(server, this.port, this.protocol, this.url,
//        this.proxyUrl, this.proxyPort, this.requestProperties,
//        this.controlPattern, this.showAnswer);
//    return result;
      
    Anfrage a = new Anfrage();
    String r = a.durchfuehren("85.214.207.250", 80, "http", "/bwl/10/leue.xml", null, 8080, null, "", true);
    System.out.println(""+r);
  }

}


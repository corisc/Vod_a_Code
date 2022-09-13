package com.ml.utils;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class XMLAnalyse {
  
  private String xml;
  
  public XMLAnalyse(String xml) {
    this.xml = xml;
  }
  
  public String liefere(String datensatz){

    String ergebnis = "no result";
    
    if(datensatz == "" || datensatz.equals("")){
      return ergebnis;
    }
    
    try{
      DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
      domFactory.setNamespaceAware(true); // never forget this!
      DocumentBuilder builder = domFactory.newDocumentBuilder();

      StringReader reader = new StringReader( xml );
      InputSource inputSource = new InputSource( reader );
      Document doc = builder.parse( inputSource );
      reader.close();
  
      XPathFactory factory = XPathFactory.newInstance();
      XPath xpath = factory.newXPath();
      XPathExpression expr = xpath.compile(datensatz + "/text()");
      
      Object result = expr.evaluate(doc, XPathConstants.NODE);
      Node n = (Node) result;
      
      ergebnis = n.getNodeValue();
    }
    catch(Exception e){
      // e.printStackTrace();
    }
    
    return ergebnis;
  }
  
  public double liefereZahl(String datensatz){

    double ergebnis = -9999;
    
    if(datensatz == "" || datensatz.equals("")){
      return ergebnis;
    }
    
    try{
      DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
      domFactory.setNamespaceAware(true); // never forget this!
      DocumentBuilder builder = domFactory.newDocumentBuilder();

      StringReader reader = new StringReader( xml );
      InputSource inputSource = new InputSource( reader );
      Document doc = builder.parse( inputSource );
      reader.close();
  
      XPathFactory factory = XPathFactory.newInstance();
      XPath xpath = factory.newXPath();
      XPathExpression expr = xpath.compile(datensatz + "/text()");
      
      Object result = expr.evaluate(doc, XPathConstants.NODE);
      Node n = (Node) result;
      
      String e = n.getNodeValue();
      ergebnis = Double.parseDouble(e);
    }
    catch(Exception e){
      //e.printStackTrace();
    }
    
    return ergebnis;
  }
//  public static void main(String args[]){
//    String infoImXMLFormat;
//    infoImXMLFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"                  + "\n" + 
//                      "<VERKAUFSDATENSATZ>"                                          + "\n" +
//                        "<ORT>"         + "Muenchen"                + "</ORT>"      + "\n" +
//                        "<ORT>"         + "Muenchen1"                + "</ORT>"      + "\n" +
//                        "<HOSEN>"       + 20       + "</HOSEN>"    + "\n" +
//                        "<PULLOVER>"    + 20    + "</PULLOVER>" + "\n" +
//                      "</VERKAUFSDATENSATZ>";
//    XMLAnalyse xmlAnalyse = new XMLAnalyse(infoImXMLFormat);
//    System.out.println("res: " + xmlAnalyse.liefere("//VERKAUFSDATENSATZ/ORT"));
//    
//  }
}


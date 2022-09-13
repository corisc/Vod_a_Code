package com.ml.utils;

import java.util.HashMap;
import java.util.Vector;

import bwl.main.auktionshaus2.Punkt;

//import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

public class Liste {
  
  Vector<Object> reihe = new Vector<Object>(11);
  HashMap<Integer, Object> kopie = new HashMap<Integer, Object>(); 
  private int permutationVorgangsnummer = 0;
  private Vector<Object> ursprungsDatenreihen = null;

  public Liste(){
  }

  public void hinzufuegen(double zahl){
    this.reihe.add(zahl);
  }
  
  public void hinzufuegen(int zahl){
    this.reihe.add(zahl);
  }

  public void hinzufuegen(Punkt punkt){
    this.reihe.add(punkt);
  }

  public void hinzufuegen(String wert){
    this.reihe.add(wert);
  }

  public void hinzufuegen(Object wert){
    this.reihe.add(wert);
  }

  public void hinzufuegen(Liste datenReihe){
    this.reihe.add(datenReihe);
  }

  public int holeIntAnStelle(int stelle){
    int result = 0;
    try{
      result = (Integer)this.reihe.get(stelle);
    }
    catch(Exception e){
      try{
        result = Integer.parseInt((String)this.reihe.get(stelle));
      }
      catch(Exception ex){
      }
    }
    
    return result;
  }

  public double holeDoubleAnStelle(int stelle){
    double result = 0;
    try{
      result = (Double)this.reihe.get(stelle);
    }
    catch(Exception e){
      try{
        result = Double.parseDouble((String)this.reihe.get(stelle));
      }
      catch(Exception ex){
      }
    }
    
    return result;
  }

  public Punkt holePunktAnStelle(int stelle){
    Punkt result = new Punkt(0,0,"kein Punkt gefunden");
    try{
      result = (Punkt)this.reihe.get(stelle);
    }
    catch(Exception e){
      System.out.println("In der DatenReihe ist kein Punkt !!");
    }
    
    return result;
  }

  public Punkt holePunktAnStelle(int posx, int posy){
    Punkt result = new Punkt(0,0,"kein Punkt gefunden");
    Liste current = null;
    try{
      current = (Liste)this.holeDatenReiheAnStelle(posx);
    }
    catch(Exception e){
      System.out.println("hier ist keine DatenReihe: " + posx);
      return null;
    }
    if(current == null){
      System.out.println("hier ist keine DatenReihe: " + posx);
      return null;
    }
    try{
      result = current.holePunktAnStelle(posy);
    }
    catch(Exception e){
      System.out.println("hier ist kein punkt: " + posx + " - " + posy);
      return null;      
    }
    if(result == null){
      System.out.println("hier ist kein punkt: " + posx + " - " + posy);
      return null;      
    }
    return result;
  }

  public Liste holeDatenReiheAnStelle(int stelle){
    Liste result = new Liste();
    try{
      result = (Liste)this.reihe.get(stelle);
    }
    catch(Exception e){
      System.out.println("In der DatenReihe ist keine DatenReihe !!");
    }
    
    return result;
  }

  public Object holeObjektAnStelle(int stelle){
    Object result = null;
    try{
      result = this.reihe.get(stelle);
    }
    catch(Exception ex){
    }
    
    return result;
  }

  public String holeStringAnStelle(int stelle){
    String result = "";
    try{
      result = (String)this.reihe.get(stelle);
    }
    catch(Exception e){
      try{
        result = ""+((Integer)this.reihe.get(stelle));
      }
      catch(Exception ex){
        try{
          result = ""+((Double)this.reihe.get(stelle));
        }
        catch(Exception exx){
        }
      }
    }
    
    return result;
  }
  
  public int liefereZahlDerEintraege(){
    int result = 0;
    try{
      result = this.reihe.size();
    }
    catch(Exception e){
    }
    return result;
  }
  
//  public void inhaltPermutieren(){
//    if(this.reihe.size() < 1){
//      System.out.println("DatenReihe ist leer ! Permutieren geht nicht.");
//      return;
//    }
//    if(ursprungsDatenreihen == null){
//      this.ursprungsDatenreihen = this.reihe;
//    }
//
//    int anzahl = this.reihe.size();
//    int[] val = new int[anzahl]; 
//    for(int t=0;t<anzahl;t++){
//      val[t] = t;
//    }
//
//    Object[] o = Permutator.permut(val);
//    for(int t=0; t<o.length; t++){
//      if(t == permutationVorgangsnummer){
//        int[] all = (int[])o[t];
//        for(int tt=0;tt<anzahl;tt++){
//          this.kopie = new HashMap<Integer, Object>();
//          System.out.println("tt: "+tt+ "  " + all[tt]);
//          this.ursprungsDatenreihen.get(tt);
//          this.kopie.put(all[tt],this.ursprungsDatenreihen.get(all[tt]));
//        }
//        this.reihe = new Vector<Object>(anzahl);
//        for(int i=0;i<anzahl;i++){
//          this.reihe.add(this.kopie.get(i));
//        }
//        permutationVorgangsnummer++;
//        return;
//      }
//    }

//    for(int t=0;t<result.liefereZahlDerEintraege();t++){
//      DatenReihe datenReihe2 = result.holeDatenReiheAnStelle(t);
//      for(int tt=0;tt<datenReihe2.liefereZahlDerEintraege(); tt++){
//        System.out.print(datenReihe2.holePunktAnStelle(tt).x);
//      }
//      System.out.println();
//    }
    
//    System.out.println("Es sind keine Permutationen mehr uebrig");
//    return;
//  }
  
  
    public String inhalteAusgeben(){
      String result = "";
      for(Object o : this.reihe){
        result = result + o + " ";
      }
      return result;
    }
}


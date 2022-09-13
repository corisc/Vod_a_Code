package bwl.oo.paket7;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

  public class Many <T extends One>{
  
  private ArrayList<T> vieleOnes = new ArrayList<T>();
  
  public One holeOneNumber1(int sucheOneNumber1){
    if(sucheOneNumber1 < 1){
      System.out.println("Es wurde bei der Suche in " + this.getGenericName() + " eine Nummer kleiner 1 gesucht");
      return null;
    }
    for(One t : this.vieleOnes) {
      if(t.getOneNumber1() == sucheOneNumber1) {
        return t;
      }
    }
    System.out.println("Es wurde bei der Suche in " + this.getGenericName() + " keine Nummer " + sucheOneNumber1 + " gefunden");
    return null;
  }
  
  public One holeOneName1(String oneName1Suche){
    if(oneName1Suche == null || oneName1Suche.length()<1){
      System.out.println("Es wurde bei der Suche in " + this.getGenericName() + " nichts angegeben");
      return null;
    }
    
    for(One t : this.vieleOnes) {
      if(t.getOneName1().equalsIgnoreCase(oneName1Suche)) {
        return t;
      }
    }
    
    System.out.println("Bei der Suche in " + this.getGenericName() + " wurde ein Eintrag mit dem Namen: " + oneName1Suche + " nicht gefunden");
    return null;
  }

  public One holeOneName2(String oneName2Suche){
    if(oneName2Suche == null || oneName2Suche.length()<1){
      System.out.println("Es wurde bei der Suche in " + this.getGenericName() + " nichts angegeben");
      return null;
    }
    
    for(One t : this.vieleOnes) {
      if(t.getOneName2().equalsIgnoreCase(oneName2Suche)) {
        return t;
      }
    }
    
    System.out.println("Bei der Suche in " + this.getGenericName() + " wurde ein Eintrag mit dem Namen: " + oneName2Suche + " nicht gefunden");
    return null;
  }
  
  public One holeOneName1Name2(String oneName1Suche, String oneName2Suche){
    if(oneName1Suche == null || oneName1Suche.length()<1){
      System.out.println("Es wurde bei der Suche in " + this.getGenericName() + " nichts angegeben");
      return null;
    }

    if(oneName2Suche == null || oneName2Suche.length()<1){
      System.out.println("Es wurde bei der Suche in " + this.getGenericName() + " nichts angegeben");
      return null;
    }
    
    for(One t : this.vieleOnes) {
      if(t.getOneName2().equalsIgnoreCase(oneName2Suche) && t.getOneName1().equalsIgnoreCase(oneName1Suche)) {
        return t;
      }
    }
    
    System.out.println("Bei der Suche in " + this.getGenericName() + " wurde ein Eintrag mit dem Namen: " + oneName2Suche + " nicht gefunden");
    return null;
  }

 
  public void oneHinzufuegen(T t){
    this.vieleOnes.add(t);
  }
 
  @SuppressWarnings("unchecked")
  protected String getGenericName()
  {
      return ((Class<One>) ((ParameterizedType) getClass()
              .getGenericSuperclass()).getActualTypeArguments()[0]).getCanonicalName();
  }

}

package e.com.ml.utils;

import com.ml.views.AusgabeFenster;

public class Test{

  
  public static AusgabeFenster ausgabeFenster = new AusgabeFenster("Tests");
  
  public static void gleichheitFeststellen(String testName, double erwarteterWert, double aktuellerWert){
    if(erwarteterWert == aktuellerWert){
      checkPositiv(testName);
    }
    else{
      checkNegativ(testName);
    }
  }

  public static void ganzzahlVorhanden(String testName, String aktuellerWert){
    try {
      Integer.getInteger(aktuellerWert);
      checkPositiv(testName);
   }
   catch(NumberFormatException e) {
      checkNegativ(testName);
   }
  }

  public static void wertGroesserNull(String testName, double aktuellerWert){
    if(aktuellerWert>0){
      checkPositiv(testName);
    }
    else{
      checkNegativ(testName);
    }
  }

  
  private static void checkPositiv(String name){
    ausgabeFenster.ausgeben(name + " - ok");
  }

  private static void checkNegativ(String name){
    ausgabeFenster.ausgeben(name + " - failed");
  }

}


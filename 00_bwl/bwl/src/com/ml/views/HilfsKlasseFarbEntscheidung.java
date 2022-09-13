package com.ml.views;

import java.awt.Color;

public class HilfsKlasseFarbEntscheidung {

  public HilfsKlasseFarbEntscheidung() {
    super();
    
  }
  
  public Color farbeNachWort(String farbe){
    Color result = Color.BLACK;
    if(farbe == null){
      return result;
    }
    if(farbe.equalsIgnoreCase("schwarz")){
      result = Color.BLACK;
      return result;
    }
    if(farbe.equalsIgnoreCase("blau")){
      result = Color.BLUE;
      return result;
    }
    if(farbe.equalsIgnoreCase("rosa")){
      result = Color.CYAN;
      return result;
    }
    if(farbe.equalsIgnoreCase("dunkelgrau")){
      result = Color.DARK_GRAY;
      return result;
    }
    if(farbe.equalsIgnoreCase("grau")){
      result = Color.GRAY;
      return result;
    }
    if(farbe.equalsIgnoreCase("gruen")){
      result = Color.GREEN;
      return result;
    }
    if(farbe.equalsIgnoreCase("gruen")){
      result = Color.GREEN;
      return result;
    }
    if(farbe.equalsIgnoreCase("hellgrau")){
      result = Color.LIGHT_GRAY;
      return result;
    }
    if(farbe.equalsIgnoreCase("lila")){
      result = Color.MAGENTA;
      return result;
    }
    if(farbe.equalsIgnoreCase("orange")){
      result = Color.ORANGE;
      return result;
    }
    if(farbe.equalsIgnoreCase("pink")){
      result = Color.PINK;
      return result;
    }
    if(farbe.equalsIgnoreCase("rot")){
      result = Color.RED;
      return result;
    }
    if(farbe.equalsIgnoreCase("weiss")){
      result = Color.WHITE;
      return result;
    }
    if(farbe.equalsIgnoreCase("weiﬂ")){
      result = Color.WHITE;
      return result;
    }
    if(farbe.equalsIgnoreCase("gelb")){
      result = Color.YELLOW;
      return result;
    }
    
    
    return result;
  }
  
  

}


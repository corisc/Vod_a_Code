package com.ml.views;

public class Farbe {
  
  int r;
  int g;
  int b;
  
  public Farbe(int r, int g, int b) {
    super();

    this.r = r;
    this.g = g;
    this.b = b;

    if(r<0 || r>255){
      this.r = 0;
      System.out.println("ACHTUNG der hexadizemale Farbwert kann nur zwischen 0 und 255 liegen.");
    }
    if(g<0 || g>255){
      this.g = 0;
      System.out.println("ACHTUNG der hexadizemale Farbwert kann nur zwischen 0 und 255 liegen.");
    }
    if(b<0 || b>255){
      this.b = 0;
      System.out.println("ACHTUNG der hexadizemale Farbwert kann nur zwischen 0 und 255 liegen.");
    }
    
  }

  public int getR() {
    return r;
  }

  public int getG() {
    return g;
  }

  public int getB() {
    return b;
  }
  
  @Override
  public String toString(){
    String message = "";
    message = message + "rot: " + this.r + " ";
    message = message + "gruen: " + this.g + " ";
    message = message + "blau: " + this.b;

    return message;
  }
  
  

}


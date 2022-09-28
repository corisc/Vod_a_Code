package bwl.oo.paket5;


public class Stadt extends One{

  private Buergermeister buergermeister;
  
  public Stadt(String name, int einwohnerzahl, Buergermeister buergermeister){
    this.buergermeister = buergermeister;
    this.oneName1 = name;
    this.oneNumber1 = einwohnerzahl;
  }
  
  public String getName(){
    return this.oneName1;
  }
  
  public int getEinwohnerzahl(){
    return this.oneNumber1;
  }
  
  public Buergermeister getBuergermeister() {
    return buergermeister;
  }
  
  
  
}


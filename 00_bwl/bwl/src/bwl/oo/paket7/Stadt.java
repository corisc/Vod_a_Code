package bwl.oo.paket7;

public class Stadt{

  private Buergermeister buergermeister;
  private One one;

  public Stadt(String name, int einwohnerzahl, Buergermeister buergermeister){
    this.buergermeister = buergermeister;
    this.one.setOneName1(name);
    this.one.setOneNumber1(einwohnerzahl);
  }
  
  public String getName(){
    return this.one.getOneName1();
  }
  
  public int getEinwohnerzahl(){
    return this.one.getOneNumber1();
  }
  
  public Buergermeister getBuergermeister() {
    return buergermeister;
  }
  
  
  
}


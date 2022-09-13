package bwl.oo.paket5;

public class Landkreis extends One {
  
  public Landkreis(String name, int einwohnerzahl){
    this.oneName1 = name;
    this.oneNumber1 = einwohnerzahl;
  }
  
  public String getName(){
    return this.oneName1;
  }
  
  public int getEinwohnerzahl(){
    return this.oneNumber1;
  }
  
}


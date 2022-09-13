package bwl.oo.paket9;

public class Stadt {

  public String name;
  public int einwohnerzahl;
  public Buergermeister buergermeister;

  //private Vector<Stadt> staedte = new Vector<Stadt>();
  
  public Stadt(String name, int einwohnerzahl, Buergermeister buergermeister) {
    this.name = name;
    this.einwohnerzahl = einwohnerzahl;
    this.buergermeister = buergermeister;

  }

  public String liefereName() {
    return name;
  }

  public void setzeName(String name) {
    this.name = name;
  }

  public int liefereEinwohnerzahl() {
    return einwohnerzahl;
  }

  public void setzeEinwohnerzahl(int einwohnerzahl) {
    this.einwohnerzahl = einwohnerzahl;
  }
  
  public Buergermeister liefereBuergermeister() {
    return buergermeister;
  }

  public void setzeBuergermeister(Buergermeister buergermeister) {
    this.buergermeister = buergermeister;
  }
  
  
  
}


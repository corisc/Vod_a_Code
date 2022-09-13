package bwl.oo.paket1;

import java.util.Random;

public class Paechter {
  
  public int paechterId;
  public String vorname;
  public String nachname;
  
  
  public Paechter(String vorname, String nachname) {
    super();
    Random rn = new Random();
    this.paechterId = rn.nextInt(1000000) + 1;
    System.out.println(""+this.paechterId);
    this.vorname = vorname;
    this.nachname = nachname;
  }
  
  

}


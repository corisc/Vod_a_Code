package bwl.oo.paket5;

import java.util.ArrayList;

public class Bundestag {
  
  private ArrayList<Abgeordneter> abgeordnete;
  
  public Abgeordneter getAbgeordneten(String name){
    return this.abgeordnete.get(2);
  }
  
  public void abgeordnetenHinzufuegen(Abgeordneter abgeordneter){
    this.abgeordnete.add(abgeordneter);
  }


}


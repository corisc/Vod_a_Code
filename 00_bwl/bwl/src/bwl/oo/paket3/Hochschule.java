package bwl.oo.paket3;

import java.util.Vector;


public class Hochschule {
  
  public String name;
  public Angestellter praesident;
  public Vector<Fachschaft> fachschaften = new Vector<Fachschaft>();
    
  public int liefereWievieleFachschaften(){
    return fachschaften.size();
  }
  
  public Fachschaft liefereFachschaft(String name){
    if(name == null || name.length()<1){
      System.out.println("Es wurde nichts angegeben");
      return null;
    }
    for(Fachschaft f : this.fachschaften){
      if(f.name.equalsIgnoreCase(name)){
        return f;
      }
    }   
    System.out.println("Die Fachschaft: " + name + " gibt es nicht");
    return null;
  }
  
  public void fuegeFachschaftHinzu(Fachschaft fachschaft){
    this.fachschaften.add(fachschaft);
  }

  public Hochschule(String name, Angestellter preasident) {
    super();
    this.name = name;
    this.praesident = preasident;
  }
  
  public Fachschaft liefereFachschaft(int fachschaftSortiertNachAnlage){
    if(fachschaftSortiertNachAnlage<1){
      System.out.println("Es gibt keine Fachschaft mit der Nummer: " + fachschaftSortiertNachAnlage);
      return null;
    }
    if(fachschaftSortiertNachAnlage>this.fachschaften.size()){
      System.out.println("Es gibt keine Fachschaft mit der Nummer: " + fachschaftSortiertNachAnlage);
      return null;
    }
    return fachschaften.get(fachschaftSortiertNachAnlage-1);
  }

}


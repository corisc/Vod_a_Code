package bwl.main.oo4;

import java.util.Vector;

public class Liga {
  
  String name;
  Vector<Fussballmannschaft> fussballmannschaften = new Vector<Fussballmannschaft>();
  
  public Liga(String name){
    this.name  = name;
  }
  
  public void fuegeFussballmannschaftHinzu(Fussballmannschaft fussballmannschaft){
    this.fussballmannschaften.add(fussballmannschaft);
  }

}


package bwl.main.oo4;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("start");
    
    
    Liga l1 = new Liga("Bundesliga");
    
    System.out.println(""+ l1.name);

    Fussballmannschaft f = new Fussballmannschaft("Bayern");
    Fussballmannschaft f1 = new Fussballmannschaft("Bayern");
    Fussballmannschaft f2 = new Fussballmannschaft("Bayern");
    Fussballmannschaft f3 = new Fussballmannschaft("Bayern");
    Fussballmannschaft f4 = new Fussballmannschaft("Bayern");
    Fussballmannschaft f5 = new Fussballmannschaft("Bayern");
    
    System.out.println(""+ f.name);
    
    l1.fuegeFussballmannschaftHinzu(f);
    l1.fuegeFussballmannschaftHinzu(f1);
    l1.fuegeFussballmannschaftHinzu(f2);
    l1.fuegeFussballmannschaftHinzu(f3);
    l1.fuegeFussballmannschaftHinzu(f4);
    l1.fuegeFussballmannschaftHinzu(f5);

    
    for(int t=0;t<l1.fussballmannschaften.size();t=t+1){
      System.out.println(""+l1.fussballmannschaften.get(t).name);
    }
    
  }

}


package bwl.oo.paket5;

public class Bundesland { //extends Many<Wahlkreis> {

  private String name;
  private Stadt hauptstadt;
  
  public Bundesland(String name, Stadt Hauptstadt) {
    this.name = name;
  }
  
//  public void wahlkreisHinzufuegen(Wahlkreis wahlkreis){
//    this.oneHinzufuegen(wahlkreis);
//  }
//  
//  public Wahlkreis holeWahlkreis(int wahlkreisNummer){
//    return this.holeOne(wahlkreisNummer);
//  }
//  
//  public Stadt getHauptstadt() {
//    return hauptstadt;
//  }

}


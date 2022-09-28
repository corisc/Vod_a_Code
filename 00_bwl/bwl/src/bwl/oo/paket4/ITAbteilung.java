package bwl.oo.paket4;

import java.util.Vector;

public class ITAbteilung {
  
  public String bezeichner;
  public Vector<Angestellter> mitarbeiter = new Vector<Angestellter>();
  public Budget budget;

  public ITAbteilung(String bezeichner) {
    super();
    this.bezeichner = bezeichner;
  }
  
  public Angestellter liefereMitarbeiter(int rangNachReihenfolgeDerAnlage){
    if(rangNachReihenfolgeDerAnlage<1){
      System.out.println("Es gibt keinen Angestellten mit der Nummer: " + rangNachReihenfolgeDerAnlage);
      return null;
    }
    if(rangNachReihenfolgeDerAnlage>this.mitarbeiter.size()){
      System.out.println("Es gibt keinen Angestellten mit der Nummer: " + rangNachReihenfolgeDerAnlage);
      return null;
    }
    return mitarbeiter.get(rangNachReihenfolgeDerAnlage-1);
  }
  
  public void fuegeBudgetHinzu(Budget budget){
    this.budget = budget;
  }
  
  void fuegeMitarbeiterHinzu(Angestellter ma){
    this.mitarbeiter.add(ma);
  }

  public void setBezeichner(){
    this.bezeichner = bezeichner;
  }
  public String getBezeichner(){
    return bezeichner;
  }
  public void setBudget(){
    this.budget = budget;
  }
  public Budget getBudget(){
    return budget;}

}


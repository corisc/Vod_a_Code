package bwl.main.auktionshaus;

public class Lagerplatz {
  
  public double    positionX;
  public double    positiony;
  
  public Produkt   produkt;
  public boolean   besetzt;
  
  public Lagerplatz(double positionX, double positiony) {
    this.positionX = positionX;
    this.positiony = positiony;
    this.besetzt   = false;
  }
  
  
  

}


package bwl.thread;

public class Zaehler {

  private int howMany = 0;
  
  public Zaehler() {
  }
  
  public void incrZ(){
    String e = null;
    
    synchronized(e){
    e = "";
    this.howMany++;
    }
    
  }
  

}


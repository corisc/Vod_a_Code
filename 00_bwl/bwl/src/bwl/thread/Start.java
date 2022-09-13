package bwl.thread;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Zaehler z = new Zaehler();
    
    ErsteLaeufer e1 = new ErsteLaeufer("Erster", 1, z);
    e1.start();
    
    ErsteLaeufer e2 = new ErsteLaeufer("Zweiter", 2, z);
    e2.start();
    
   
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    e1.setKeepRunning(false);
  }

}


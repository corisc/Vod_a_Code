package bwl.thread;

public class ErsteLaeufer extends Thread {

  private String nameDesLaeufers;
  private int wartezeitInSeks;
  private boolean keepRunning = true;
  private Zaehler z;
  
  public ErsteLaeufer(String nameDesLaeufers, int wartezeitInSeks, Zaehler z) {
    this.nameDesLaeufers = nameDesLaeufers;
    this.wartezeitInSeks = wartezeitInSeks;
    this.z = z;
    System.out.println("Created " + nameDesLaeufers + System.currentTimeMillis());
  }

  public void run() {

    while (keepRunning) {
      // keep doing what this thread should do.
      System.out.println("Running " + nameDesLaeufers);

      try {
        Thread.sleep(this.wartezeitInSeks * 1000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }      
    }
    


  }

  public void setKeepRunning(boolean keepRunning) {
    this.keepRunning = keepRunning;
  }

}

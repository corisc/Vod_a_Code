package mvc;

public class Event {

  private boolean fired = false;
  
  public Event() {
    
  }
  
  public void fireEvent(){
    this.fired = true;
    System.out.println("fire !!");
  }

}


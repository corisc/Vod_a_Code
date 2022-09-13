package mvc;

public class Controller {

  private Event event;
  
  public Controller(Event event) {
    this.event = event;
  }
  
  public void fireEvent(){
    this.event.fireEvent();
  }

}


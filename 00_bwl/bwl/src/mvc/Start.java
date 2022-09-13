package mvc;

import com.ml.utils.Helfer;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Event event = new Event();
    Controller c = new Controller(event);
    
    System.out.println("ich tue noch nichts");
    Helfer h = new Helfer();
    h.warteSeks(4);
    System.out.println("Event fired");
    c.fireEvent();


  }

}


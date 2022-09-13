package e.com.ml.views.copy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Button
{
  private String text;
  private boolean clicked;
  
  public Button(String text)
  {
    this.text = text;
  }
  
  public JButton getButton()
  {
    JButton button = new JButton();
    button.setText(text);

    button.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        clicked = true;
      }
    });

    return button;
  }
  
  public void awaitClick()
  {
    while(!clicked){
      
    }
    this.clicked = false;
  }

  public void aktiviereEingabe()
  {
    new Runnable() {
      public void run() {
        while(!clicked)
          ;
      }
    };
  }

  public boolean wurdeGedrueckt() {
    return clicked;
  }

  public void schalterZuruecksetzen() {
    this.clicked = false;
  }
  
}

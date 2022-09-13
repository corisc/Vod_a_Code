package com.ml.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

public class RadioButton
{
  private String[] texts;
  private boolean clicked;
  private int whichOneClicked = 0;
  private MyActionListener myActionListener;
  
  public RadioButton(String ... texts)
  {
    if(texts == null || texts.length == 0){
      System.out.println("Es muss mindestens ein Text fuer einen RadioButton angegeben werden.");
      System.exit(1);
    }
    this.texts = texts;
    this.myActionListener = new MyActionListener();
  }
  
  public JRadioButton[] getButtons()
  {
    JRadioButton[] result = new JRadioButton[texts.length];
    for(int t=0;t<texts.length; t++){
      //System.out.println(""+t);
      JRadioButton button = new JRadioButton();
      button.setText(texts[t]);
      button.setActionCommand(""+t);
      button.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e)
        {
          clicked = true;
        }
      });
      button.addActionListener(this.myActionListener);
      result[t] = button;
    }

    return result;
  }
  
  public void warteAufEingabe()
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
  
  public int zahlDerEntscheidung(){
    return this.myActionListener.getWhichCommand()+1;
  }

  private class MyActionListener implements ActionListener{
    private int whichCommand = 0;
    public void actionPerformed(ActionEvent e) {
      String c = e.getActionCommand();
      this.whichCommand = Integer.parseInt(c);
    }
    public int getWhichCommand() {
      return whichCommand;
    }
  }

  
}


package com.ml.views;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuestionWindow{

  private JDialog frame;
  private String titel;
  private String text;
  private JTextField textField;
  
  public QuestionWindow(String titel, String text){
    this.titel  = titel;
    this.text   = text;
  }
  
  public void createEntryValue(){
    this.frame = new JDialog();
    this.frame.setLayout(null);

    this.frame.setTitle(this.titel);
    this.frame.setSize(300, 140);
    this.frame.setLocation(300, 300);

    this.frame.addWindowListener(new WindowListener() {
        public void windowActivated(WindowEvent e){}
        public void windowClosed(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e) {
          textField.setText(null);
          frame.dispose();
        }
    });   
    
    JLabel label = new JLabel(this.text);
    label.setBounds(10, 10, 280, 20);
    this.frame.add(label);
    
    
    
    this.textField = new JTextField();
    this.textField.setBounds(9, 30, 280, 20);
    this.textField.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
          frame.dispose();
        }
      }
    });
    this.frame.add(this.textField);
    
    this.frame.setModal(true);
    this.frame.setVisible(true);
  }
  
  public String getEntry(){
    if(this.textField != null){
      return this.textField.getText();
    }
    else{
      return null;
    }
  }
}
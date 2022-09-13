package com.ml.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class AusgabeFenster{

  private String contentText = "";
  private JTextArea textArea;
  private JFrame frame;
  private JScrollPane scrollPane;

  public AusgabeFenster(String title, boolean beamerVersion) {
    this.initiateDisplayFrame(title, beamerVersion);
  }

  public AusgabeFenster(boolean beamerVersion) {
    this.initiateDisplayFrame(" ", beamerVersion);
  }

  public AusgabeFenster() {
    this.initiateDisplayFrame(" ", false);
  }

  public AusgabeFenster(String title) {
    this.initiateDisplayFrame(title, false);
  }

  private void initiateDisplayFrame(String title, boolean beamerVersion) {
    // TextArea
    textArea = new JTextArea();
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(false);
    if(beamerVersion){
      textArea.setFont(new Font("Courier New", Font.BOLD, 20));
    }
    DefaultCaret caret = (DefaultCaret)textArea.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

    // ScrollPane
    scrollPane = new JScrollPane(textArea);
    
    // Panel
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(scrollPane);

    // Frame
    this.frame = new JFrame(title);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setLocation(10,10);
    frame.setSize(804, 410);
    this.frame.getContentPane().add(panel);
    this.frame.setVisible(true);
    
  }


  public void ausgebenMonospaced(String textToAdd) {
    textArea.setFont(new Font("Courier New", Font.BOLD, 12));
    this.contentText = this.contentText + textToAdd + "\n";
    this.textArea.setText(this.contentText);
  }
  
  public void ausgeben(String textToAdd) {
    this.contentText = this.contentText + textToAdd + "\n";
    this.textArea.setText(this.contentText);
  }
  
  public void zeilenumbruchlosesAusgeben(String textToAdd){
    this.contentText = this.contentText + textToAdd;
    this.textArea.setText(this.contentText);
  }

  public void ausgeben(int intToAdd){
    String textzeile = "zahl konnte nicht gelesen werden";
    try{  
      textzeile = String.valueOf(intToAdd);
    }
    catch(Exception e){
      textzeile = "zahl konnte nicht gelesen werden";
    }

    this.contentText = this.contentText + textzeile + "\n";
    this.textArea.setText(this.contentText);
  }

  public void ausgeben(double doubleToAdd){
    String textzeile = "zahl konnte nicht gelesen werden";
    try{  
      textzeile = String.valueOf(doubleToAdd);
    }
    catch(Exception e){
      textzeile = "zahl konnte nicht gelesen werden";
    }

    this.contentText = this.contentText + textzeile + "\n";
    this.textArea.setText(this.contentText);
  }
}



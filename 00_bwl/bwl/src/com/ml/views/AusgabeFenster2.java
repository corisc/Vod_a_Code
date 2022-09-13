package com.ml.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class AusgabeFenster2{

    private String        contentText   = "";
    private JTextArea     textArea;
    private JFrame        frame;
    private JScrollPane   scrollPane;
    
    public AusgabeFenster2(){
      this(" ");
    }

    public AusgabeFenster2(String title){
      this.initiateDisplayFrame(title);
    }
    
    private void initiateDisplayFrame(String title){
    this.frame = new JFrame(title);
    frame.setLayout(null);
    frame.setSize(804, 410);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  
    frame.setLocation(10,10);
    
    this.textArea = new JTextArea();
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setAutoscrolls(true);
    textArea.setBackground(Color.LIGHT_GRAY);
    textArea.setEditable(false);
    textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
    textArea.setRows(300);
    textArea.setSize(800, 350);
    this.scrollPane = new JScrollPane(textArea);
    scrollPane.setSize(790, 340);
    frame.add(scrollPane);

    // Knopf fuer Stop
    // Knopf zum Testen dab
    JButton stopKnopf = new JButton("Schlie�en");
    stopKnopf.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        frame.dispose();
        System.exit(0);
        return;
      }
    });
    stopKnopf.setBounds(690, 342, 100, 30);
    this.frame.getContentPane().add(stopKnopf);
    
    
    frame.setVisible(true);
    
    //this.ausgeben("start");
  }

  public void ausgeben(String textToAdd){
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

  public void scrollDown(){
    this.scrollPane.getVerticalScrollBar().setValue(this.contentText.length());
  }
}


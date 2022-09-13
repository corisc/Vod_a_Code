package com.ml.views;

import java.awt.Font;

import javax.swing.JTextField;

public class EingabeFeld {

  private JTextField textField = new JTextField();
  private Font       font;
  
  public EingabeFeld(){
  }
  
  public EingabeFeld(Font font) {
    super();
    this.font = font;
    this.textField.setFont(font);
  }

  public EingabeFeld(String defaultText){
    if(defaultText == null){
      defaultText = "";
    }
    this.textField.setText(defaultText);
  }

  public String getText() {
    return this.textField.getText();
  }

  public void setText(String text) {
    if(text == null){
      text = "";
    }
    this.textField.setText(text);    
  }
	
  public double getWert() {
    double ergebnis = 0;
    try{
      ergebnis = Double.parseDouble(this.textField.getText());
    }
    catch(Exception e){
    }
    return ergebnis;
  }

  public int getGanzahligenWert() {
    int ergebnis = 0;
    try{
      ergebnis = Integer.parseInt(this.textField.getText());
    }
    catch(Exception e){
    }
    return ergebnis;
  }

  public JTextField getTextField() {
    return textField;
  }

  public Font getFont() {
    return font;
  }
  
}

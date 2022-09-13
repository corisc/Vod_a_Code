package com.ml.views;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TastenKeyListener implements KeyListener {

  private char letzteGedrueckteTaste;
  private long zeit;
  
  public TastenKeyListener() {
  }

  public void keyPressed(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }

  public void keyReleased(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }

  public void keyTyped(KeyEvent arg0) {
    this.letzteGedrueckteTaste = arg0.getKeyChar();
    this.zeit = System.currentTimeMillis();
  }

  public char getLetzteGedrueckteTaste() {
    return letzteGedrueckteTaste;
  }
  
  public long getLetzteGedrueckteZeit() {
    return this.zeit;
  }
  

}


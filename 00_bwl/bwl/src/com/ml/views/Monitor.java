package com.ml.views;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Monitor {


  private Vector<Rectangle> allFountRects = new Vector<Rectangle>(1); 
  
  public Monitor(){
  }
  
  public Vector<Rectangle> checkBoundsOnMultiMonitor(){
    
    Rectangle virtualBounds = new Rectangle();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] gs = ge.getScreenDevices();
    for (int j = 0; j < gs.length; j++) {
      GraphicsDevice gd = gs[j];
      //System.out.println("Device " + j + ": " + gd);
      GraphicsConfiguration[] gc = gd.getConfigurations();

      for (int i=0; i < gc.length; i++) {
        //System.out.println("  Configuration " + i + ": " + gc[i]);
        //System.out.println("    Bounds: " + gc[i].getBounds());
        Rectangle newOne = gc[i].getBounds();
        if(!this.isAlreadyInThereRect(newOne)){
          this.allFountRects.add(newOne);
        }
        virtualBounds = virtualBounds.union(gc[i].getBounds());
      }
      //System.out.println("Overall bounds: " + virtualBounds);
    }
    Collections.sort(this.allFountRects, new SortierungRecs());
    for(Rectangle rec : this.allFountRects){
      //System.out.println(" XXX: " + rec);
    }
    return this.allFountRects;
  }
  
  private boolean isAlreadyInThereRect(Rectangle reca){
    if(this.allFountRects.size() == 0){
      return false;
    }
    boolean result = false;
    for(Rectangle rec : this.allFountRects){
      if(rec.x == reca.x && rec.y == reca.y && rec.width == reca.width &&rec.height == reca.height){
        return true;
      }
    }
    
    return result;
  }
  
  private class SortierungRecs implements Comparator<Rectangle>{
    // -1 = a1 gewinnt 1= a2 gewinnt
    public int compare(Rectangle p1, Rectangle p2) {

      if(p1.x < p2.x){
        return -1;
      }
      if(p1.x > p2.x){
        return 1;
      }
      
      return 0;
    }
  }
  
  public static double rechneYUmAufNullPunkt(double punktY){
    return (BasicFenster.HOEHE-30 - punktY);
  }
  
  public static int rechneYUmAufNullPunkt(int punktY){
    return (int)(BasicFenster.HOEHE - 30 - (double)punktY);
  }

  public static int rechneYZurueckUmAufNullPunkt(int punktY){
    return (int)(BasicFenster.HOEHE - ((double)punktY + 30));
  }

  public static double rechneYZurueckUmAufNullPunkt(double punktY){
    return (BasicFenster.HOEHE - ((double)punktY + 30));
  }

  public static void main(String[] args) {
    Monitor m = new Monitor();
    Vector monitore = m.checkBoundsOnMultiMonitor();
    System.out.println("" + monitore);
  }

}


package com.ml.views;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import com.ml.utils.Helfer;

public class Bild
{
  private Image img;
  private int breite = 0;
  private int hoehe = 0;
  
  public Bild(String dateiname)
  {
    Helfer h = new Helfer();
    String pfad = h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ dateiname;
    File f = new File(pfad);
    if(f.exists()){
      img = Toolkit.getDefaultToolkit().getImage(pfad);
    }
    else{
      System.out.println("Fehler: Es fehlt entweder des Verzeichnis " + h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ " oder das Bildes existiert nicht namens: " + dateiname);
    }
  }

  public Bild(String dateiname, int breite, int hoehe)
  {
    this.breite = breite;
    this.hoehe = hoehe;
    Helfer h = new Helfer();
    String pfad = h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ dateiname;
    File f = new File(pfad);
    if(f.exists()){
      img = Toolkit.getDefaultToolkit().getImage(pfad);
    }
    else{
      System.out.println("Fehler: Es fehlt entweder des Verzeichnis " + h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ " oder das Bildes existiert nicht namens: " + dateiname);
    }
  }
  
  public Bild(String dateiname, boolean mitPfad)
  {
    Helfer h = new Helfer();
    String pfad = dateiname;
    File f = new File(pfad);
    if(f.exists()){
      img = Toolkit.getDefaultToolkit().getImage(pfad);
    }
    else{
      System.out.println("Fehler: Es fehlt entweder des Verzeichnis " + h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ " oder das Bildes existiert nicht namens: " + dateiname);
    }
  }

  public Image getImage()
  {
    return img;
  }

  public int getBreite() {
    return breite;
  }

  public int getHoehe() {
    return hoehe;
  }

  public void setImg(Image img) {
    this.img = img;
  }
  
  
}

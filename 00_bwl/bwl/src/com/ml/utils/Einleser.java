package com.ml.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

public class Einleser {
  
  public Einleser() {
    super();
  }
  
  public Vector<Kurs> lesenDatenBestandEinUndSortiere(String isin){
    
    // Alle Dateien im Verzeichnis
    Helfer h = new Helfer();
    String pfad = h.aktuellesArbeitsverzeichnis() + "/50_daten/kurse_DE0008469008_2011-06-30.txt";
    File root = new File(pfad);
    if(!root.exists()){
      System.out.println("Datei exisitert nicht: " + pfad);
      System.exit(1);
    }
    Vector<Kurs> neueKurse = this.dateiEinlesenUndKonvertieren(root);
    
    Collections.sort(neueKurse, new SortierungKurs());

    return neueKurse;
  }
  
  private Vector<Kurs> dateiEinlesenUndKonvertieren(File file){
    Vector<Kurs> result = new Vector<Kurs>(40001);
    BufferedReader in = null;
    long lineNumber = 0;
    try {
      in = new BufferedReader(new FileReader(file));
      String str;
      while ((str = in.readLine()) != null) {
        lineNumber ++;
        result.add(this.convertLineInKurs(str));
      }
      in.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (NumberFormatException nfe){
      System.out.println("Fehler in Datei: " + file.getName() + " Zeile: " + lineNumber);
      System.exit(1);
    }
    finally{
      try {
        in.close();
      } catch (IOException e) {}      
    }
    
    System.out.println("Daten eingelesen fuer: " + file.getName() + " Anzahl: " + result.size());
    return result;
  }
  
  private Kurs convertLineInKurs(String str) throws NumberFormatException{
    String  readString;
    long    time;
    double  wert = 0;
    readString = str.substring(0, str.indexOf(";"));
    str = str.substring(str.indexOf(";") + 1, str.lastIndexOf(";"));
    time = Long.parseLong(readString);
    try{
      wert = Double.parseDouble(str);
    }
    catch(NumberFormatException nfe){
      System.out.println("Wert konnte nicht in double konvertiert werden: " + str);
      throw nfe;
    }
    String zuzeigenderWert = "" + DateConverter.deliverAsStringDatehhmmss(new Date(time));

    Kurs k = new Kurs(zuzeigenderWert, wert, time);
    return k;
  }
}


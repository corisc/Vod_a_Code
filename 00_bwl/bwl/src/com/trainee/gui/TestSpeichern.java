package com.trainee.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class TestSpeichern {
  
  public TestSpeichern()
  {
    final JFileChooser fc = new JFileChooser();   
    
    //      * Textdatei mit Datum+Uhrzeit abspeichern
    
    FileFilter filter = new FileFilter()
    {
      @Override
      public boolean accept(File file)
      {
        if (file.isDirectory())         // ist Datei ein Ordner?
        { return true;   }        
        
        // ***** Moeglichkeit 2 *****
        String filename = file.getName();       
        
        if (filename != null && !filename.equals(""))   // filename hat auch einen Inhalt
        {
          if (filename.toLowerCase().endsWith("_tab.txt"))    // Datei akzeptiert
          { return true;        }
          else      // Datei nicht akzeptiert
          { return false;       }
        }        
        return false;
      }
      @Override
      public String getDescription() 
      {
        return "Tabellendatei (*_tab.txt)";     // Beschriftung der Auswahloption
      }      
    };
    
    File file = fc.getSelectedFile();
    fc.accept(file);
        
    fc.addChoosableFileFilter(filter);        // Dateifilter einfuegen
    
        
    int returnVal;   
    returnVal = fc.showSaveDialog(fc);  
    fc.setVisible(true);
    if (returnVal == JFileChooser.APPROVE_OPTION) 
    {
      file = fc.getSelectedFile();       // gewaehlte Datei
      System.out.println(file.getAbsoluteFile());   // z.B: Q:\pro\trainee\Trivials.class
      if (file.getName().toLowerCase().endsWith("_tab.txt"))
      {        
        save(file);
      }
      else  
      {
        // ***** Moeglichkeit 1 *****
        File f = null;
        String path = fc.getSelectedFile().getPath();
         
        if (!path.toLowerCase().endsWith("_tab.txt"))
          path = path + "_tab.txt";
         
        f = new File(path);        
        
        save(f);
      }
    }
    else if (returnVal == JFileChooser.CANCEL_OPTION)
    {
      file = null;
      System.out.println("\tAuswahl abgebrochen!");
      fc.cancelSelection();
    }
  
  }// Ende Konstruktor
  
  /**
   * Speichert Datei
   * @param file
   */
  @SuppressWarnings("deprecation")
  public void save(File file)
  {
    // neue datei anlegen
    String path = file.getPath();
    System.out.println(file.getAbsolutePath());
    
    try 
    {       
      File f = new File(path);
      f.createNewFile(); 
      System.out.println( "Legte neue Datei an " + f ); 
    } catch ( IOException e ) { e.printStackTrace(); } 
    
    // Daten in Datei schreiben
    // Beispieldaten
    Date tabInhalt[][] = new Date[5][5];
    Date date = new Date();
    date.setHours(13);
    tabInhalt[0][0] = date;
    date.setHours(6);
    tabInhalt[1][1] = date;
    
    BufferedWriter out = null;
    String arrayString = "";
    for (int f = 0; f < 5; f++)
    {
      for (int i = 0; i < 5; i++)
      {
        arrayString = arrayString + tabInhalt[f][i];
        arrayString = arrayString + "|";
      }
      arrayString = arrayString + "\r\n";       // naechste Zeile  
      
      try {
        out = new BufferedWriter(new FileWriter(path));
        out.write(arrayString);          
      } catch (IOException e1) {     e1.printStackTrace();     }
    }// Ende for
    
    try {
      out.close();
    } catch (IOException e) {      e.printStackTrace();      }
/*
//    buffer.append("|");
    String[] zeilen = new String[5];
    for (int i = 0; i < 5; i++)
    {
      for (int f = 0; f < 5; f++)
      {
        buffer.append(tabInhalt[i][f].toString());
        buffer.append("|");     // Datentrenner
      }
      zeilen[i] = buffer.toString();    // String komplette Zeile abspeichern
    }
    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(path));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    
    
    // Beispiel Java eBook ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    Writer fw = null;  
    try 
    { 
      fw = new FileWriter( file.getName() ); 
      fw.write( "Zwei Jaeger treffen sich..." ); 
      fw.append( System.getProperty("line.separator") ); // e.g. "\n" 
    } 
    catch ( IOException e ) { 
      System.err.println( "Konnte Datei nicht erstellen" ); 
    } 
    finally { 
      if ( fw != null ) 
        try { fw.close(); } catch ( IOException e ) { } 
    }
    
    // Beispiel Forum ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    String arrayString = "";
    int[] array = {1,2,3,4,5,6,7,8,9};      

    for (int i = 0; i < array.length ; i++)
        arrayString = arrayString + array[i];

    try {
        BufferedWriter out = new BufferedWriter(new FileWriter(path));
        out.write(arrayString);
        out.close();
    } catch (IOException e) {
    }

    // Beispiel Buch ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*    
    try
    { 
      BufferedWriter writer = new BufferedWriter(new FileWriter(datei));
      for (QuizKarte karte : kartenListe)
      { writer.write(karte.getFrage() + "/");
        writer.write(karte.getAntwort() + "\n");
      }
      writer.close();
    }catch (IOException ex)
    {
      System.out.println("konnte die Kartenliste nicht schreiben!");
      ex.printStackTrace();
    }    
*/    
  }// Ende save(File)
  


  public static void main(String[] args) {    
    new TestSpeichern();
  }

}


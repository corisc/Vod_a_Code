package com.trainee.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;



/**
 * Test Datei Oeffnen - Dialog
 * @author Steres14130
 *
 */
public class TestOeffnen {

  public TestOeffnen()
  {
    final JFileChooser fc = new JFileChooser(); 
        
    
    // ***************** TEST ****************
    //              * Filter fuer Textdateien
    
    FileFilter filter = new FileFilter()
    {
      @Override
      public boolean accept(File file)
      {
        if (file.isDirectory())         // ist Datei ein Ordner?
        {   
//          System.out.println("file.isDirectory"); 
          return true;      
        }
        
        // ***** Moeglichkeit 1 *****
        String filename = file.getName();       
        
        if (filename != null && !filename.equals(""))   // filename hat auch einen Inhalt
        {
          if (filename.toLowerCase().endsWith(".txt"))    // Datei akzeptiert
          { return true;        }
          else      // Datei nicht akzeptiert
          { return false;       }
        }        
        return false;

        // ***** Moeglichkeit 2 *****
//        String extension = Utils.getExtension(f);
/*        // Dateiendung rausfinden
        String extension = null;
        String s = file.getName();
        int i = s.lastIndexOf('.');
    
        if (i > 0 &&  i < s.length() - 1) 
        {
          extension = s.substring(i+1).toLowerCase();
        }
         
        if (extension != null) {
          if (extension.equals("txt")) 
          {   
            System.out.print("\t" + file.getName() + " gewaehlt");
            System.out.println("\nDat   A K Z E P T I E R T"); 
            return true;     
          } 
          else 
          {  
//              System.out.println("\tDat   N I C H T   akzeptiert"); 
            return false;      
          }
        }
        System.err.println("extension == null");
        return false;
*/      
      }
      @Override
      public String getDescription() 
      {
        return "Textdatei (*.txt)";     // Beschriftung der Auswahloption
      }      
    };
    
    File file = fc.getSelectedFile();
    fc.accept(file);
    
//    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);       // 
    
    fc.addChoosableFileFilter(filter);        // Dateifilter einfuegen
    
        
    int returnVal;   
    returnVal = fc.showOpenDialog(fc);  
    fc.setVisible(true);
    if (returnVal == JFileChooser.APPROVE_OPTION) 
    {
      file = fc.getSelectedFile();       // gewaehlte Datei
      System.out.println("\n\nDatei " + file.getName() + " gewaehlt");
  //    fc.setAcceptAllFileFilterUsed(false);
      System.out.println(file.getAbsoluteFile());   // z.B: Q:\pro\trainee\Trivials.class
      if (file.getName().toLowerCase().endsWith("_tab.txt"))    // Endung muss "*_tab.txt" sein
      {
        open(file);
      }
      else  
      {   
        JOptionPane.showMessageDialog(null, "Bitte eine zugehoerige Tabellendatei (*_tab.txt) waehlen!"); 
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
   * Oeffnet Datei, liest enthaltene Tabellendaten ein, fuegt sie in neue Berechnungstabelle ein
   * @param file
   */
  @SuppressWarnings("deprecation")
  public void open(File file)
  {            
    // Datei oeffnen
    // Zeile (Beschriftung) auslesen (bei | beginnend
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      
      Date[][] tabInhalt = new Date[4][5];    //  4 Zeilen (Beg-Ges), 5 Spalten (Mo-Fr)
      String[] werte = null;
      int i = 0;
      
      while (true)
      {
        String zeile = reader.readLine();      
        if (zeile != null)      // Zeilenweise bis Textende lesen
        {       
          System.out.println("\n--- " + i + ". Zeile ---");
          System.out.println(zeile);
          
          werte = zeile.split("\\|");
//          SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // Format auf deutscher Uhrzeit (23:34)

          for (int m = 0; m < werte.length; m++)        
          {
            System.out.print("[" + m + "] " + werte[m] + "  *  ");
          }
          
          for (int t = 0; t < 5; t++)
          {
            String[] zeit = new String[2];
            zeit = werte[t].split(":");
            System.out.println("zeitelemente: " + zeit.length + "\tzeit: " + zeit[0] + " " + zeit[1]);
            Date date = new Date();
            date.setHours  (Integer.parseInt(zeit[0]));     
            date.setMinutes(Integer.parseInt(zeit[1]));
            
            System.out.println("tabInhalt: " + tabInhalt.length);
            
            tabInhalt[i][t] = date;     
            System.out.println("\n  ~~~~~~~~~~~~~~ korrekt ausgegeben?");
            System.out.println(tabInhalt[i][t].getHours() + ":" + tabInhalt[i][t].getMinutes() + " | ");
          }
            i++;
        }
        else
        {
          break;        // Spring aus Endlose-(while-)Schleife
        }        
      }
    } catch (IOException e) {
        System.err.println("konnte Zeilen nicht lesen und ausgeben");
    } 
    
    
    
    // Beispiel Buch ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*    
    private void dateiLaden(File datei)
    { 
      kartenliste = new ArrayList<QuizKarte>();
      try
      {
        BufferedReader reader = new BufferedReader(new FileReader(datei));
        String zeile = null;
        while ((zeile = reader.readLine()) != null)
        { 
          karteErstellen(zeile); }
          reader.close();
        }catch (Exception ex)
        {
          System.out.println("konnte Kartendatei nicht lesen");
          ex.printStackTrace();
        }
        naechsteKarteZeigen();
      }      
    }
*/    
  }// Ende open(File)
  
  public static void main(String[] args) {
    new TestOeffnen();    
  }
}


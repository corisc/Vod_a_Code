package com.trainee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/** 
 * @author Steres14130
 */
public class DlgDateiOeffnen {
 
  ArrayList<Bank> listeDerBanken;
  java.sql.Connection conn = null;
  
  public DlgDateiOeffnen(ArrayList<Bank> listeDerBanken)
  {
    this.listeDerBanken = listeDerBanken;
//    dateiOeffnen();
    
    try
    {
      Class.forName("org.hsqldb.jdbcDriver").newInstance();
      String url = "jdbc:hsqldb:file:c:/bwl/20_db/db_bank";      
      conn = DriverManager.getConnection(url, "sa", "");
      conn.setAutoCommit(false);    // Befehle werden erst in Batch gesammelt, dann commited   
      // statement.addBatch(...);  --> updateCounts = statement.executeBatch(); / conn.rollback(); 
      
      leseDB();
      
    }catch ( Exception e ) 
    { 
      e.printStackTrace();
      return; 
    } 
    finally{
      try {
        conn.close();
      } catch (SQLException e) {   e.printStackTrace();    }
    }
  }
  
  
  /**
   * Daten der Datenbank einlesen, Daten anlegen und in Variable abspeichern
   */
  public void leseDB()
  {
    try
    {
      Statement st = null;
      st = conn.createStatement();    // Statement anlegen und mit connection verbinden
      
      // Bankdaten abfragen + speichern
      ResultSet rs = st.executeQuery("SELECT DISTINCT Bank_blz, Bank_name, Bank_guthaben, Bank_kredite "+
                                      "FROM Bank ");  
      while ( rs.next() )           // Ergebnisse abfangen + speichern
      {
        Bank bank = new Bank(rs.getString(2), rs.getString(1));
        bank.setGesGuthaben(rs.getFloat(3));
        bank.setGesKredite(rs.getFloat(4));
        listeDerBanken.add(bank);
        System.out.printf("Bank: %s (%s)  Guthaben/Kredite: %s / %s%n", bank.getBankName(), bank.getBlz(),
                                                             bank.getGesGuthaben(), bank.getGesKredite());
      }
      
      ArrayList<Long> kundeIDs = new ArrayList<Long>();
      for (int i = 0; i < listeDerBanken.size(); i++)
      {
        // Kunden der Bank abfragen + speichern
        rs = st.executeQuery("SELECT DISTINCT Kunde_vname, Kunde_nname, Kunde_nr, Kunde_ID " +
                              "FROM Kunde, cro_Bank_Kunde_Konto " +
                              "WHERE cro_Bank_Kunde_Konto.Bank_blz = " + listeDerBanken.get(i).getBlz() + " " +
                              "AND cro_Bank_Kunde_Konto.kunde_id = Kunde.kunde_id " +
                              "ORDER BY Kunde_ID asc");          
        while ( rs.next() )           // Ergebnisse abfangen + speichern
        {
          Kunde kunde = new Kunde(rs.getString(1), rs.getString(2), rs.getInt(3));
          kundeIDs.add(rs.getLong(4));
          listeDerBanken.get(i).neuenKundenHinzufuegen(kunde);
          System.out.printf("Kunde: %s %s (%s) bei Bank: %s %n", kunde.getVName(), kunde.getNName(), 
                                                        kunde.getKundenNr(), listeDerBanken.get(i).getBankName());
        }
      }// Ende for Banken
      
      // Konten des Kunden abfragen + speichern
      for (int b = 0; b < listeDerBanken.size(); b++)
      {
        for (int ku = 0; ku < listeDerBanken.get(b).getKundenDerBank().size(); ku++)
        {  
          rs = st.executeQuery("SELECT DISTINCT Konto_art, Konto_nr, Konto_stand, Konto_ID " + 
                                "FROM Konto, Kunde, cro_Bank_Kunde_Konto " +
                                "WHERE cro_Bank_Kunde_Konto.bank_blz = " + listeDerBanken.get(b).getBlz() +
                                "AND cro_Bank_Kunde_Konto.kunde_id = " + kundeIDs.get(ku) +
                                "AND cro_Bank_Kunde_Konto.konto_id = Konto.konto_id " +
                                "ORDER BY Konto_ID asc");
          
          Konto konto = null;
          while ( rs.next() )           // Ergebnisse abfangen + speichern
          {
            konto = new Konto(rs.getString(1), rs.getLong(2));
            konto.setKontostand(rs.getDouble(3));
            listeDerBanken.get(b).getKundenDerBank().get(ku).addKonto(konto);
            System.out.printf("Kunde: " + listeDerBanken.get(b).getKundenDerBank().get(ku).getNName() + 
                              "\tKonto: %s (%s) %s %n", konto.getKontoArt(), konto.getKontoNr(), 
                                                        konto.getKontostand());
          }

          if (konto != null)        // Konto vorhanden --> nach Kredit von Konto suchen
          {
//            System.out.println("Kunde_ID: " + kundeIDs.get(ku));
            rs = st.executeQuery("SELECT DISTINCT Kredit.konto_ID, kredit_Ges, kredit_Rest, kredit_Tilgung, " + 
                                                                  "kredit_Verwendung, kredit_Laufzeit, " +
                                                                  "kredit_Restlaufzeit " +
                                  "FROM Kredit, Konto, cro_Bank_Kunde_Konto " +
                                  "WHERE cro_Bank_Kunde_Konto.bank_blz = " + listeDerBanken.get(b).getBlz() +
                                  "AND cro_Bank_Kunde_Konto.kunde_id = " + kundeIDs.get(ku) +
                                  "AND Konto.konto_nr = " + konto.getKontoNr() +
                                  "AND cro_Bank_Kunde_Konto.konto_id = kredit.konto_id");
            while ( rs.next() )           // Ergebnisse abfangen + speichern
            {
              
              if (rs.getLong(1) >= 0)      // Konto hat Kredit
              {
                konto.setKreditGesBetrag(rs.getDouble(2));
                konto.setKreditRestBetrag(rs.getDouble(3));
                konto.setKreditTeiltilgung(rs.getDouble(4));
                konto.setKreditVerwendung(rs.getString(5));
                konto.setKreditLaufzeit(rs.getInt(6));
                konto.setKreditRestLaufzeit(rs.getInt(7));
              
  //              listeDerBanken.get(b).getKundenDerBank().get(ku).addKonto(konto);
                System.out.printf("\t\tKonto: %s (%s) %s hat kredit: %s %s %n", 
                                  konto.getKontoArt(), konto.getKontoNr(), konto.getKontostand(),
                                  konto.getKreditGesBetrag(), konto.getKreditLaufzeit());
              }
            }
          }// Ende if Konto vorhanden
        }// Ende for Kundendurchlauf
      }// Ende for Bankendurchlauf
      
      st.close();
    }catch( Exception e ) 
    { 
      e.printStackTrace();
      return; 
    }    
  }
  
  
  
  
  
  /**
   * Dialog Datei oeffnen, gespeicherte Textdatei oeffnen, Datensaetze in Programm einlesen
   */
  public void dateiOeffnen()
  {
    JFileChooser fc     = new JFileChooser();
    FileFilter   filter = new FileFilter()
    {
      public boolean accept(File file)
      {
        if (file.isDirectory())         // ist Datei ein Ordner?
        { return true;   }
        
        String filename = file.getName();       
        
        if (filename != null && !filename.equals(""))   // filename hat auch einen Inhalt
        {
          if (filename.toLowerCase().endsWith(".data"))    // Datei akzeptiert
          { return true;        }
          else      // Datei nicht akzeptiert
          { return false;       }
        }        
        return false;        
      }
      @Override
      public String getDescription() 
      {
        return "Daten Datei (*.data)";     // Beschriftung der Dateioption
      }      
    };
    
    File file = fc.getSelectedFile();
    fc.accept(file);        
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
      if (file.getName().toLowerCase().endsWith(".data"))    // Endung muss "*.data" sein
      {
        open(file);
      }
      else  
      { JOptionPane.showMessageDialog(null, "Bitte eine Daten-Datei (*.data) waehlen!"); 
      }
    }
    else if (returnVal == JFileChooser.CANCEL_OPTION)
    {
      file = null;
      System.out.println("\tAuswahl abgebrochen!");
      fc.cancelSelection();
    }
       
    // ***************************************
  }
  
  InputStream fis = null;   
  public void open(File file)
  {    
    // Datei oeffnen, Zeile (Beschriftung) auslesen 
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));        
      int i = 0;
      Bank aktuelleBank = null;
      Kunde aktuellerKunde = null;
      
      System.out.println("\t***** Datei Inhalt *****\n");
      String[] werte = null;
      String zeileDavor = "";
      String zeile;      // Zeilenweise lesen
      while (true)
      { 
        zeile = reader.readLine();      // Zeilenweise lesen   
        
        if (zeile != null)      // lesen bis Dateiende kommt
        {       
          System.out.println("\n--- " + i + ". Zeile ---");
          System.out.println(zeile);
                    
          if (zeile.contains("|"))      // Auch wirklich ein Datensatz mit | ?
          {
            System.out.println("zeile ist Datensatz");
            werte = zeile.split("\\|");       // Daten durch | getrennt wieder auseinanderspalten
            
            for (int m = 0; m < werte.length; m++)        // Kontrollausgabe
            { System.out.print("[" + m + "] " + werte[m] + "  *  ");   }
            
            if (zeileDavor.contains("***Ba***"))
            {
              System.out.println("Bank");
              // Coburger Bank|2323|0.0|0.0
              aktuelleBank = new Bank(werte[0], werte[1]);       // Bankname, BLZ   
              aktuelleBank.setGesGuthaben(Double.parseDouble(werte[2]));
              aktuelleBank.setGesKredite(Double.parseDouble(werte[3]));
              
              listeDerBanken.add(aktuelleBank);
            }
            else if (zeileDavor.contains("---Ku---"))
            {
              System.out.println("Kunde");
              // Corinna|Corner|1001
              aktuellerKunde = new Kunde(werte[0], werte[1], Integer.parseInt(werte[2]));  // Vname, Nname, kuNr
              aktuelleBank.neuenKundenHinzufuegen(aktuellerKunde);              
            }
            else if (zeileDavor.contains("---Ko---"))
            {
              System.out.println("Konto");
              // Spar|1000001|33.0|0.0|0.0|0|0| |0.0
              Konto konto = new Konto(werte[0], Long.parseLong(werte[1]));  // Kontoart, koNr (long) 
              konto.setKontostand(Double.parseDouble(werte[2]));            // Kontostand (double)
              konto.setKreditGesBetrag(Double.parseDouble(werte[3]));       // Kreditbetrag (double)
              konto.setKreditRestBetrag(Double.parseDouble(werte[4]));      // Kreditrest (double)
              konto.setKreditLaufzeit(Integer.parseInt(werte[5]));          // Kreditlaufzeit (int)
              konto.setKreditRestLaufzeit(Integer.parseInt(werte[6]));      // Kreditrestlaufzeit (int)
              konto.setKreditVerwendung(werte[7]);                          // Verwendung (string)
              konto.setKreditTeiltilgung(Double.parseDouble(werte[8]));     // Tilgung (double)
              aktuellerKunde.addKonto(konto);              
            }            
          }// Ende Zeile ist Datensatz
          else if (zeile.contains("***") || zeile.contains("---") || zeile.contains("==="))
          {
            System.out.println("Zeile ist Trennzeichen zwischen Datensaetzen");
            zeileDavor = zeile;             
          }
          i++;          
        }// Ende Zeile hat Inhalt    
            
        else        // Zeile leer (Ende) --> Sprung aus Endlos-(while-)Schleife
        { 
          reader.close();
          break;   
        }        
      }// Ende while      
    } 
    catch (IOException e) {    System.err.println("konnte Zeilen nicht lesen und ausgeben");   }
  }
}


package com.trainee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/** 
 * @author Steres14130 
 */
public class DlgDateiSpeichern {
  
  ArrayList<Bank> listeDerBanken;
  Connection conn = null;
  
  public DlgDateiSpeichern(ArrayList<Bank> listeDerBanken)
  {
    this.listeDerBanken = listeDerBanken;
//    dateiSpeichern();
       
    try         // Treiber suchen, connection erstellen
    {
      Class.forName("org.hsqldb.jdbcDriver").newInstance();
      String url = "jdbc:hsqldb:file:c:/bwl/20_db/db_bank";      
      conn = DriverManager.getConnection(url, "sa", "");
      conn.setAutoCommit(false);    // Befehle werden erst in Batch gesammelt, dann commited   
      // statement.addBatch(...);  --> updateCounts = statement.executeBatch(); / conn.rollback(); 
      
      schreibeDB();
      
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
   * Userdaten aus Programm in Datenbank abspeichern
   */
  public void schreibeDB()
  {
    try
    {
      Statement st = null;
      st = conn.createStatement();    // statement anlegen und mit connection verbinden
      int i = 0;
      
      // Inhalt einfuegen (Banken, Kunden, Konten und Beziehungen zueinander)
      for (Bank bank : listeDerBanken)
      {
        System.out.println("\tBANK: " + bank.getBankName() + " " + bank.getBlz());
        // Bankdaten in Tabelle Bank einfuegen
//        i = st.executeUpdate("INSERT INTO Bank VALUES ('Coburger Bank', 2117233, 0.0, 0.0)");
        st.addBatch("INSERT INTO Bank VALUES ('" + bank.getBankName() + "', " +
                                 Integer.parseInt(bank.getBlz()) + ", " + // string --> int *OK*
                                                  bank.getGesGuthaben() + ", " + 
                                                  bank.getGesKredite() + ")");
//        pruefe(i);
        for (Kunde kunde : bank.getKundenDerBank())
        {
          System.out.println("\tKUNDE: " + kunde.getVName() + " " + kunde.getNName() + " " + kunde.getKundenNr());
          String croStatement = "";
          
//          i = st.executeUpdate("INSERT INTO Kunde VALUES('Hans', 'Mueller', 222)");
          st.addBatch("INSERT INTO Kunde VALUES('" + kunde.getVName() + "', '" + 
                                                    kunde.getNName() + "', " + 
                                                    kunde.getKundenNr() + ", null)"); // null wegen auto incr
//          pruefe(i);

          
          if (kunde.getKonten().isEmpty())      // kein konto vorhanden
          {
            JOptionPane.showMessageDialog(null, "Achtung, kein Konto vorhanden! Bitte erst eins anlegen!"); 
            st.close();
          }
          else
          {
            for (Konto konto : kunde.getKonten())
            {
              System.out.println("\tKONTO: " + konto.getKontoArt() + " " + konto.getKontoNr());
  //            i = st.executeUpdate("INSERT INTO Konto VALUES('Girokonto', 10012541, 50.0)");
              st.addBatch("INSERT INTO Konto VALUES('" + konto.getKontoArt() + "', " + 
                                     BigInteger.valueOf(konto.getKontoNr()) + ", " + // long --> bigint *OK*
                                                        konto.getKontostand() + ", null)");
              
              // Kredit vorhanden --> in DB eintragen
              if (konto.getKreditGesBetrag() > 0 && konto.getKreditRestBetrag() > 0)
              {
//                int[] updateCounts = 
                  st.executeBatch();
                long kontoID = kredit(bank, kunde, konto);
                
                // Kredit(Kredit_Ges double, Kredit_Rest double, Kredit_Tilgung double, 
                //        Kredit_Verwendung varchar(30), Kredit_Laufzeit int, Kredit_RestLaufzeit int, 
                //        Konto_ID bigint NOT NULL)
                st.addBatch("INSERT INTO Kredit VALUES(" + konto.getKreditGesBetrag() + ", " + 
                                                          konto.getKreditRestBetrag() + ", " +
                                                          konto.getKreditTeiltilgung() + ", '" +
                                                          konto.getKreditVerwendung() + "', " +
                                                          konto.getKreditLaufzeit() + ", " +
                                                          konto.getKreditRestLaufzeit() + ", " +
                                                          kontoID + ")");
              }              
//              pruefe(i);
              
              
              // kunde_ID + konto_ID abfragen vom jeweils angelegten kunde+konto
              croStatement = croBaKuKo(bank, kunde, konto);
              System.out.println("croStatement: " + croStatement);
              
              // cro_bank_kunde_konto Verbindungen herstellen
              i = st.executeUpdate(croStatement);       
              pruefe(i);
              
              
              // Inhalt der cro tabelle pruefen
              ResultSet rs = st.executeQuery("SELECT DISTINCT kunde_vname, kunde_nname, bank_name, konto_art, konto_stand "+
                                              "FROM Kunde, Bank, Konto, cro_bank_kunde_konto " + 
                                              "WHERE kunde.kunde_ID = cro_bank_kunde_konto.kunde_ID " + 
                                              "AND konto.konto_ID = cro_bank_kunde_konto.konto_ID " + 
                                              "AND bank.bank_blz = cro_bank_kunde_konto.bank_blz");  
              while ( rs.next() )           // Ausgabeschleife
              System.out.printf("Kunde: %s %s  Bank: %s (%s)%n", rs.getString(1), rs.getString(2),
                                                                 rs.getString(3), rs.getString(4));              
            }
          }
        }// Ende for kunde
      }// Ende for bank
      
      st.close();
    }catch( Exception e ) 
    { 
      e.printStackTrace();
      return; 
    }    
  }
  
  
  public String croBaKuKo(Bank selBank, Kunde selKunde, Konto selKonto)
  {
    String statement = " ";
    long kundeID = 0;
    long kontoID = 0;
    
   
    try
    {
      Statement state = conn.createStatement();    // statement anlegen und mit connection verbinden
      
      ResultSet rs = state.executeQuery("SELECT DISTINCT kunde_ID " + 
                                        "FROM Kunde, cro_bank_kunde_konto " + 
                                        "WHERE kunde_nr = " + selKunde.getKundenNr() +
                                        "AND kunde_vname = '" + selKunde.getVName() + "' " +
                                        "AND kunde_nname = '" + selKunde.getNName() + "' ");  
      
      while ( rs.next() )           // Ausgabeschleife
      kundeID = rs.getLong(1);      
      System.out.printf("Kunde_ID: %s, von Kunde %s %s (%s)%n", kundeID, 
                                                                selKunde.getVName(), selKunde.getNName(),
                                                                selKunde.getKundenNr());      
//      System.out.println(kundeID);
      
      rs = state.executeQuery("SELECT DISTINCT konto_ID " + 
                              "FROM Konto, cro_bank_kunde_konto " +
                              "WHERE konto_nr = " + selKonto.getKontoNr() + 
                              "AND konto_art = '" + selKonto.getKontoArt() + "' " + 
                              "AND konto_stand = " + selKonto.getKontostand());
      
      while ( rs.next() )           // Ausgabeschleife
      kontoID = rs.getLong(1);
      System.out.printf("Konto_ID: %s, von Konto %s %s (%s)%n", kontoID, 
                                                                selKonto.getKontoArt(), selKonto.getKontoNr(),
                                                                selKonto.getKontostand());      
//      System.out.println(kontoID);
      
      statement = "INSERT INTO cro_Bank_Kunde_Konto VALUES(" + selBank.getBlz() + ", " + 
                                                            kundeID + ", " + kontoID + ")";
    
    }catch( Exception e ) 
    { 
      e.printStackTrace();
      return null; 
    }       
    return statement;
  }
  
  
  public long kredit(Bank selBank, Kunde selKunde, Konto selKonto)
  {
    long kontoID = 0;
    
    try
    {
      Statement state = conn.createStatement();    // statement anlegen und mit connection verbinden
      
      ResultSet rs = state.executeQuery("SELECT DISTINCT konto_ID " + 
                                        "FROM Konto, Kunde, cro_Bank_Kunde_Konto " + 
                                        "WHERE cro_Bank_Kunde_Konto.bank_blz = " + selBank.getBlz() + 
                                        "AND Kunde.kunde_nr = " + selKunde.getKundenNr() +
                                        "AND Konto.konto_nr = " + selKonto.getKontoNr());
      
      while ( rs.next() )           // Ausgabeschleife
      kontoID = rs.getLong(1);      
      System.out.printf("Konto_ID: %s, von Konto_Nr %s  bei Bank %s (%s)%n", kontoID, selKonto.getKontoNr(), 
                                                                selBank.getBankName(), selBank.getBlz());
    }catch( Exception e ) 
    { 
      e.printStackTrace();
      return -1; 
    }       
    return kontoID;
  }
  
  
  /**
   * Basiskommandos wie Tabellen anlegen
   */
  /*
  public void basics()
  {
    try
    {
      Statement st = null;
      st = conn.createStatement();    // statement anlegen und mit connection verbinden
      int i = 0;
      
      // Tabellen anlegen
      i = st.executeUpdate("CREATE TABLE Bank (Bank_Name varchar(30), Bank_BLZ int, " +
                                              "Bank_Guthaben double, Bank_Kredite double)");  
      pruefe(i);
      i = st.executeUpdate("CREATE TABLE Kunde(Kunde_VName varchar(20), Kunde_NName varchar(20), Kunde_Nr int)");
      pruefe(i);
      i = st.executeUpdate("CREATE TABLE Konto(Konto_Art varchar(20), Konto_Nr bigint, Konto_Stand double)");
      pruefe(i);
      
      // Verknuepfungstabellen anlegen
      i = st.executeUpdate("CREATE TABLE cro_Bank_Kunde (Bank_BLZ int, Kunde_Nr int)"); // Kunde nicht eindeutig!
      pruefe(i);
      i = st.executeUpdate("CREATE TABLE cro_Kunde_Konto (Kunde_Nr int, Konto_Nr bigint)"); // Kunde nicht eindeutig!
      pruefe(i);
      
      
      st.close();
      
    }catch ( Exception e ) 
    { 
      e.printStackTrace();
      return; 
    }    
  }
  */
  public void pruefe(int i)
  {
    if (i == -1) {   System.out.println("db error");     }
  }
  
  
  /**
   * Datei speichern Dialog, anschlieﬂend Daten in *.data-Datei speichern
   */
  public void dateiSpeichern()
  {    
    if (listeDerBanken == null || listeDerBanken.isEmpty())
    {
      JOptionPane.showConfirmDialog(null, "Bitte erst Bank, Kunde und Konto anlegen!", 
                                    "Keine Daten verfuegbar!", JOptionPane.OK_CANCEL_OPTION);
      return;
    }
    JFileChooser fc = new JFileChooser();
    FileFilter filter = new FileFilter()
    {
      @Override
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
        return "Daten Dateien (*.data)";     // Beschriftung der Auswahloption
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
      if (file.exists())
      {
        JOptionPane.showConfirmDialog
        (null, "Datei " + file.getName() + " bereits vorhanden! Bitte anderen Namen waehlen!", 
            "Datei existiert bereits!", JOptionPane.OK_CANCEL_OPTION);
        return;
      }
      System.out.println(file.getAbsoluteFile());   // z.B: Q:\pro\trainee\Trivials.class
      if (! file.getName().toLowerCase().endsWith(".data"))      
      {        
        String path = file.getAbsolutePath() + ".data";         
        File f = new File(path);     
        save(f);
      }
    }
    else if (returnVal == JFileChooser.CANCEL_OPTION)
    {
      file = null;
      System.out.println("\tAuswahl abgebrochen!");
      fc.cancelSelection();
    }
  }
  
  /**
   * Hier werden die eingegebenen Daten in eine Daten-Datei (*.data) abgespeichert
   * @param file
   */
  public void save(File file)
  { 
    // Daten in Datei schreiben    
    BufferedWriter out = null;
    String arrayString = "***Ba***\r\n";    // Trennzeichen + Datentyp fuer fogende Daten
    for (Bank bank : listeDerBanken)     // Zeilendurchlauf
    { 
      String wert = (String) bank.getBankName() + "|" + bank.getBlz() + "|" + 
                             bank.getGesGuthaben() + "|" + bank.getGesKredite();    // Wert aus Tabelle holen  
      arrayString = arrayString + wert + "\r\n";    // neue Zeile ("\n" im Editor nur Kaestchen, kein Zeilenumbruch)
      
      for (Kunde kunde : bank.getKundenDerBank())
      {
        wert = "---Ku---\r\n";      // Trennzeichen + Datentyp fuer fogende Daten
        wert = wert + (String) kunde.getVName() + "|" + kunde.getNName() + "|" + kunde.getKundenNr();    
        arrayString = arrayString + wert + "\r\n---Ko---\r\n";    // Trennzeichen + Datentyp fuer fogende Daten
        
        for (Konto konto : kunde.getKonten())
        {
          wert = (String) konto.getKontoArt() + "|" + konto.getKontoNr() + "|" + 
                          konto.getKontostand() + "|" + 
                          konto.getKreditGesBetrag() + "|" + konto.getKreditRestBetrag() + "|" + 
                          konto.getKreditLaufzeit() + "|" + konto.getKreditRestLaufzeit() + "|" + 
                          konto.getKreditVerwendung() + "|" + konto.getKreditTeiltilgung();    
          arrayString = arrayString + wert + "\r\n";            
        }
        arrayString = arrayString + "=====\r\n";        // Markierung fuer Ende Kunde
      }
      arrayString = arrayString + "***Ba***\r\n";          // Markierung fuer naechste Bank
      try {     // Daten in arrayString in Datei schreiben
        out = new BufferedWriter(new FileWriter(file));
        out.write(arrayString);        
      } catch (IOException e1) {     e1.printStackTrace();     }      
    }// Ende for
    
    try {       // Datei wieder schlieﬂen
      out.close();
    } catch (IOException e) {      e.printStackTrace();      }
  }  
}
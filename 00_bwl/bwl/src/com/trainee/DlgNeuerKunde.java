package com.trainee;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DlgNeuerKunde {
  
//  ArrayList<Kunde> listeDerKunden = new ArrayList<Kunde>();
  DefaultListModel model;
  int   kundenNr;
  Bank  selectedBank;    // in Combobox vom User ausgewaehlte Bank
  final JFrame     dlgNeu   = new JFrame();
  final JTextField tKnr     = new JTextField();
  
  /** Array fuer bereits gewaehlte Banken, sozusagen lock/unlock array,
   * damit nicht bei jedem Auswahlwechsel kundenNr unnoetig erhoeht wird */
  ArrayList<Bank> vorherSelektierteBanken = new ArrayList<Bank>();
  
  /** 
   * Dialog fuer Benutzereingabe zum Anlegen eines neuen Kunden
   * benoetigte Eingaben:
   * String vName, String nName     (int kundenNr - automatisch)
   */
  public DlgNeuerKunde(final ArrayList<Bank>  listeDerBanken, DefaultListModel model)
  {
    if (listeDerBanken.isEmpty())   // Liste der Banken leer --> Fehlermeldung
    {
      JOptionPane.showMessageDialog(null, "Bitte zuerst eine Bank anlegen!");
    }
    else{   // Liste der Banken befuellt
//      System.out.println("\n==============================================\n" +
//                           "|              Dialog NeuerKunde             |\n" +
//                           "==============================================\n");
      
      dlgNeu.setTitle("Neuen Kunden anlegen");
      dlgNeu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
      this.model = model;
//      this.listeDerKunden = listeDerKunden;    
      
    
      // Layoutmanager einfuegen      
      /** 
       * Besonderheiten:
       * Bank Combobox,     * Textbox KundenNr readonly
       */
      Container con = dlgNeu.getContentPane();
      con.setLayout(new GridBagLayout());
      
      /**
       * Auswahl der Bank (aus Combobox)
       */
      JLabel lBank = new JLabel();
      lBank.setText("Bank");
      con.add(lBank,              // Nr., Anz, Gewichtung
              new GridBagConstraints(0,0, 1,1, 0.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                     new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
      
      /** listeDerBanken in Combobox einfuegen --> OK */
      final JComboBox cBank = new JComboBox();
      cBank.addItem(null);
      
      for (Bank b : listeDerBanken)     // Combobox mit Banken aus der Liste fuellen
      { cBank.addItem(b.getBankName());   }
      con.add(cBank,              // Nr., Anz, Gewichtung
              new GridBagConstraints(1,0, 2,1, 1.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                     new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf

      cBank.addActionListener(new ActionListener()
      {         
        public void actionPerformed (ActionEvent e) {
          
          // ist auch eine Bank gewaehlt?
          if (cBank.getSelectedIndex() != (-1) && cBank.getSelectedItem() != null)
          {
            // Bank verfuegbar, in Combobox angezeigt   
            selectedBank = new Bank(null, null);       
            // ausgewaehlte Bank in selectedBank abspeichern
            selectedBank.setBankName(cBank.getItemAt(cBank.getSelectedIndex()) .toString());
//            System.out.println("");
            for (Bank bank : listeDerBanken)    // gewaehlte Bank herausfinden
            { 
//              System.out.println("Bank: " + bank.getBankName());                
              
              // welche Bank ist gewaehlt (in Combobox)
              if (bank.getBankName().equals(selectedBank.getBankName())) 
              {                   
                selectedBank = bank;
                
                // Bank zuvor NICHT gewaehlt (benoetigt wegen korrektem inc d. KundenNr)
                if (! vorherSelektierteBanken.contains(selectedBank))
                {
                  // aktualisiert Dialogfeld mit naechster freien KundenNr
                  kundenNr = selectedBank.getNaechsteFreieKundennummer();                       
                  tKnr.setText(String.valueOf(kundenNr));
                  
//                  System.out.println("\nfortlaufende kundenNr: " + kundenNr + 
//                                     "\tder Bank: " + selectedBank.getBankName()); // Kontrollausgabe
                  
                  // Bank der Liste bereits gewaehlter Banken hinzufuegen (wegen inc KundenNr)
                  vorherSelektierteBanken.add(selectedBank);
                  
//                  System.out.println("selectedBank: " + selectedBank.getBankName() + 
//                                     " zur Liste vorherSelektierteBanken hinzugefuegt"); // Kontrollausgabe
                }                
                
                else      // Bank zuvor GEWAeHLT (in Liste vorherSelektierteBanken enthalten)
                {
                  // KundenNr ermitteln + im Feld ausgeben
                  kundenNr = selectedBank.getNaechsteFreieKundennummer();
                  tKnr.setText(String.valueOf(kundenNr));
//                  System.out.println("\n\n\ttKnr: " + tKnr.getText()); // Kontrollausgabe
                  
//                  System.out.print("\n========= Banken in vorherSelektierteBanken =========\n||");
//                  for (Bank b : vorherSelektierteBanken)
//                  {  System.out.print("\t\t" + b.getBankName());      }
//                  System.out.println("\t||\n======================================================");
                }                  
              }// Ende if gewaehlte Bank         
            }// Ende for gewaehlte Bank rausfinden
          }// Ende if ueberhaupt eine Bank gewaehlt
        }// Ende actionPerformed      
      });// Ende addItemListener
      
      /**
       * Benutzereingaben des Vornamens + Nachnamens
       */
      JLabel lVname = new JLabel();
      lVname.setText("Vorname");
      con.add(lVname,             // Nr., Anz, Gewichtung
              new GridBagConstraints(0,1, 1,1, 0.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                     new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
    
      final JTextField tVname = new JTextField();
      con.add(tVname,             // Nr., Anz, Gewichtung
              new GridBagConstraints(1,1, 2,1, 1.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                     new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
      
      JLabel lNname = new JLabel();
      lNname.setText("Nachname");
      con.add(lNname,             // Nr., Anz, Gewichtung
              new GridBagConstraints(0,2, 1,1, 0.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                     new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
      
    
      final JTextField tNname = new JTextField();
      con.add(tNname,             // Nr., Anz, Gewichtung
              new GridBagConstraints(1,2, 2,1, 1.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                     new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
      
      
      tVname.addKeyListener(new KeyListener()
      {
        public void keyPressed(KeyEvent e) {        }
        public void keyReleased(KeyEvent e) {        }
        public void keyTyped(KeyEvent e) 
        {
          // hier bisherige Eingabe auf Text pruefen (ggf Fehlermeldung)
          String eingabe = tVname.getText();
          int key = e.getKeyChar();
//          System.out.print("\n key Zeichen: " + e.getKeyChar());
        
         if (key >= 'a' && key <= 'z' ||
             key >= 'A' && key <= 'Z' ||
             key == '-' || key == '´')      // diese Zeichen zulassen
          {
            // richtig
            eingabe = eingabe.concat(String.valueOf(e.getKeyChar()));  // alle Zeichen zu String verketten
            tVname.setBackground(Color.WHITE);
//            System.out.print("\teingabe: " + eingabe);            
          }
          else      // sonstige Zeichen nicht zulassen + Feld rot einfaerben
          {
            tVname.setBackground(Color.RED);
            if (key == KeyEvent.VK_BACK_SPACE)  // bei Return - Feldfarbe zuruecksetzen
            {              
                tVname.setBackground(Color.WHITE);   
            }            
          }
        }// Ende keyTyped        
      });// Ende keyListner
      
      tNname.addKeyListener(new KeyListener()
      {
        public void keyPressed(KeyEvent e) {        }
        public void keyReleased(KeyEvent e) {        }
        public void keyTyped(KeyEvent e) 
        {
          // hier bisherige Eingabe auf Text pruefen (ggf Fehlermeldung)
          String eingabe = tNname.getText();
          int key = e.getKeyChar();
//          System.out.print("\n key Zeichen: " + e.getKeyChar());
        
         if (key >= 'a' && key <= 'z' ||
             key >= 'A' && key <= 'Z' ||
             key == '-' || key == '´')      // diese Zeichen zulassen
          {
            // richtig
            eingabe = eingabe.concat(String.valueOf(e.getKeyChar()));  // alle Zeichen zu String verketten
            tNname.setBackground(Color.WHITE);
//            System.out.print("\teingabe: " + eingabe);            
          }
          else      // sonstige Zeichen nicht zulassen + Feld rot einfaerben
          {
            tNname.setBackground(Color.RED);
            if (key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER)  // bei Return/Enter
            {              
                tNname.setBackground(Color.WHITE);   
            }            
          }
        }// Ende keyTyped        
      });// Ende keyListner
      
  
      /**
       * hoechste Kundennr aus Kundenliste der Bank entnehmen und erhoehen, nicht editierbar
       */
      JLabel lKnr = new JLabel();
      lKnr.setText("Kunden Nr.");
      con.add(lKnr,               // Nr., Anz, Gewichtung
              new GridBagConstraints(0,3, 1,1, 0.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                     new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf

      tKnr.setColumns(10);   // da int nur bis 2Mio geht
      con.add(tKnr,               // Nr., Anz, Gewichtung
              new GridBagConstraints(1,3, 2,1, 1.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                     new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
      tKnr.setEditable(false);  // schreibgeschuetzt      
      
    
      /** Buttons OK + Abbrechen */
      // TODO 2 Buttons selbe Groeße geht noch nicht!

      final JButton bOK = new JButton();
      bOK.setText("OK");
      con.add(bOK,                // Nr., Anz, Gewichtung
              new GridBagConstraints(0,5, 2,1, 1.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                     new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf      
      bOK.addActionListener(
        new ActionListener()
        { 
          public void actionPerformed(ActionEvent e)
          {
            // KEINE Bank ausgewaehlt --> Fehler
            if (cBank.getSelectedItem() == null)
            { JOptionPane.showMessageDialog(null, "Bitte eine Bank waehlen!");    }
            
            else        // Bank AUSGEWAeHLT --> Ok
            {
              boolean kundeBereitsAngelegt = speichern(tVname.getText(), tNname.getText(), 
                                                       cBank.getSelectedItem().toString());
              if (kundeBereitsAngelegt == false)     // Kunde gespeichert, Dialog schließen
              {              
                dlgNeu.setVisible(false);
                dlgNeu.dispose();
                
//                System.out.println(" ~~~~~~~~~~~~~~ listeDerKunden ~~~~~~~~~~~~~");
//                for (Kunde kunde : selectedBank.getKundenDerBank())       // TODO
//                {
//                  System.out.println("Name: " +kunde.getVName()+ " " +kunde.getNName()+ "\t" +kunde.getKundenNr());
//                }
//                System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
      
                selectedBank = null;
                // Liste vorherSelektierteBanken leeren, sodass kundenNr wieder hochgezaehlt werden kann
                vorherSelektierteBanken.clear();
              }
            }// Ende else Bank ausgewaehlt
          }// Ende actionPerformed
      });// Ende addActionListener
      
      
      JButton bAbbr = new JButton();
      bAbbr.setText("Abbrechen");
      con.add(bAbbr,              // Nr., Anz, Gewichtung
              new GridBagConstraints(1,5, 2,1, 1.0,0.0, 
                                     GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                     new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf
      bAbbr.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            dlgNeu.setVisible(false);
            dlgNeu.dispose();
            selectedBank = null;
          }
      });// Ende addActionListener
          
      
      /**
       * Fenstergroeße festlegen + mittig auf Bildschirm positionieren,
       * Komponenten hinzufuegen + anzeigen
       */
      dlgNeu.setSize(270, 230);
      dlgNeu.setLocation(
          (Toolkit.getDefaultToolkit().getScreenSize().width - dlgNeu.getSize().width) / 2,
          (Toolkit.getDefaultToolkit().getScreenSize().height - dlgNeu.getSize().height) / 2);
        
      dlgNeu.setContentPane(con);
      dlgNeu.setVisible(true);                
      
      tNname.addKeyListener(new KeyListener()
      {
        public void keyTyped(KeyEvent e) {        }
        public void keyPressed(KeyEvent e) {        }
        public void keyReleased(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER)
          {                
            // manueller klick auf ok bei Enter
            bOK.doClick();            
          }
        }         
      });// Ende addKeyListener      
      
     
       
    }    
    
    dlgNeu.repaint();  
  }// Ende DlgNeuerKunde(...)
 
  /**
   * prueft, ob Kunde bereits in Liste enthalten (true)
   * oder ob neu angelegt wurde (false)
   * @param vName des Kunden
   * @param nName des Kunden
   * @param bank gewaehlte Bank, bei der Person Kunde ist
   * @return kundeBereitsAngelegt (vorher schon angelegt?)
   */
  public boolean speichern (String vName, String nName, String bank)
  {
    Kunde neuerKunde = null;
    boolean kundeBereitsAngelegt = true;       // default: Kunde bereits in Liste
    
    // Ueberpruegung der Benutzereingaben
    if (vName.isEmpty() || nName.isEmpty())     // fehlende Text-Eingaben in Namensfeldern
    {     
      JOptionPane.showMessageDialog(null, "Bitte Vornamen und Nachnamen eingeben!");
      kundeBereitsAngelegt = true;
    }
   
    // Benutzereingaben sind ok    
    else if (selectedBank.getKundenDerBank().isEmpty())     // bei leerer Liste gleich anlegen
    {
      neuerKunde = new Kunde(vName, nName, kundenNr);   
      kundeBereitsAngelegt = false;           
//      System.out.println("\t1. Kunde erfolgreich angelegt\n");
      
      // Kunde in Modell einfuegen/erweitern
      model.addElement(neuerKunde.getVName()+ " " +neuerKunde.getNName());       
//      listeDerKunden.add(neuerKunde);
      selectedBank.neuenKundenHinzufuegen(neuerKunde);
    }
          
    else    // bei befuellter Liste pruefen ob bereits vorhanden
    {      
      int counter = 1;      // Zaehler fuer aktuell durchlaufendes Element
      for (Kunde k : selectedBank.getKundenDerBank())
      {
        if (k.getVName().equals(vName) && k.getNName().equals(nName))
        {
          // Kunde bereits in Liste vorhanden --> Fehler
          kundeBereitsAngelegt = true;
          JOptionPane.showMessageDialog(null, "Achtung! Kunde bereits vorhanden!");
          break;
        }
        // bei letztem Element der Liste ohne Fehler Kunde anlegen
        else if ((counter) == selectedBank.getKundenDerBank().size())  
        {              
          kundeBereitsAngelegt = false;          
        }
        counter++;
      }
      if (kundeBereitsAngelegt == false)
      {
        // Kunde noch nicht angelegt --> neu einfuegen
        neuerKunde = new Kunde(vName, nName, kundenNr);    
//        System.out.println("\n   Kunde ERFOLGREICH ANGELEGT!\n\n");
          
        // Kunde in Modell einfuegen/erweitern
        model.addElement(neuerKunde.getVName() + " " + neuerKunde.getNName());
//        listeDerKunden.add(neuerKunde);  
        selectedBank.kundenDerBankAktualisieren(neuerKunde);
      }
    }// Ende else if befuellte Liste pruefen
    
    return kundeBereitsAngelegt;
  }// Ende speichern
}


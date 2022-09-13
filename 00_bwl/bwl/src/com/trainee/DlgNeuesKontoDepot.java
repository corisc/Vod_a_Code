package com.trainee;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class DlgNeuesKontoDepot {
  
//  ArrayList<Konto> listeDerKonten = new ArrayList<Konto>();
  DefaultListModel model = new DefaultListModel();
  
  long  kontoNr;        // kontoNr
  
  Bank  selectedBank;    // in Combobox vom User ausgewaehlte Bank
  Kunde selectedKunde;   // in Combobox vom User ausgewaehlter Kunde (anhand der Kundennr pruefen?)
  
  final JTextField tKontoNr     = new JTextField();
  final JTextField tKunr         = new JTextField();     // KundenNr
  
  
  // Array fuer bereits gewaehlte kNr, sozusagen lock/unlock array,
  // damit nicht bei jedem Auswahlwechsel kundenNr unnoetig erhoeht wird
  ArrayList<Bank> vorherSelektierteBank = new ArrayList<Bank>();  // jetzt vorher selektierter Kunde (Kundennr)?

  /** 
   * Dialog fuer Benutzereingabe zum Anlegen eines neuen Kontos/Depots
   * Benutzereingaben:
   * Bank, Kunde/Kundennr, Kontoart
   */
  public DlgNeuesKontoDepot(final ArrayList<Bank>  listeDerBanken,
                            DefaultListModel model)
  {
    // Pruefung ob Kunden vorhanden
    ArrayList<Kunde> listeDerKunden = new ArrayList<Kunde>();
    for (Bank ban : listeDerBanken)
    { for (Kunde kun : ban.getKundenDerBank())
      { listeDerKunden.add(kun);     }      
    }    
    
    if (listeDerKunden.isEmpty())   // es muss erst ein Kunde existieren
    { JOptionPane.showMessageDialog(null, "Bitte zuerst einen Kunden anlegen!");  }
      
    else{           // Kunde existiert --> weiter machen
//      System.out.println("\n==============================================\n" +
//                           "|           Dialog NeuesKontoDepot           |\n" +
//                           "==============================================\n");
    
    final JFrame dlgNeu = new JFrame();
    dlgNeu.setTitle("Neues Konto/Depot anlegen");
    dlgNeu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.model = model;
//      this.listeDerKonten = listeDerKonten;

        
    // Layoutmanager einfuegen      
    /** 
     * Labels links untereinander im Fenster, 
     * Textboxen rechts auf gleicher Hoehe, gleiche (variable) Laenge
     * Buttons darunter in gleicher Laenge
     * 
     * Bank waehlen (Combobox)
     * Kunde waehlen (Combobox) -> Kundenliste nach aktueller Bank auswaehlen
     * Kundennr des gewaehlten Kunden (automatisch mittels Kundenliste oder Usereingabe +
     *                                Aktualisierung der Kundencombobox auf passenden Kunden)
     * Kontoart (Textbox)
     * Kontonr (Textbox, editable -> false) generiert sich selbst
     * Buttons OK, Abbrechen                                        
     */
    /**     Attribute von Kunde: 
     * String kontoArt, String kontoNr;
       double kontostand;         
       ( double kreditGesBetrag, double kreditRestBetrag, double kreditTeiltilgung;
         String kreditVerwendung;
         int    kreditLaufzeit, int    kreditRestLaufzeit;    )
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
    
    for (Bank b : listeDerBanken)
    { cBank.addItem(b.getBankName());   }
    con.add(cBank,              // Nr., Anz, Gewichtung
            new GridBagConstraints(1,0, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf  
    
    
    /**
     * Auswahl des Kunden (aus Combobox)
     */
    JLabel lKunde = new JLabel();
    lKunde.setText("Kunde");
    con.add(lKunde,             // Nr., Anz, Gewichtung
            new GridBagConstraints(0,1, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    
    
    /** listeDerKunden in Combobox einfuegen --> OK */
    final JComboBox cKunde = new JComboBox();
    cKunde.addItem(null);        
   
    con.add(cKunde,             // Nr., Anz, Gewichtung
            new GridBagConstraints(1,1, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
        
    
    /** Kundennummer je nach gewaehlten Kunden oder eingegebene Nr mit Combobox-Kunden abgleichen */ // --> ok
    JLabel lKuNr = new JLabel();
    lKuNr.setText("KundenNr");
    con.add(lKuNr,               // Nr., Anz, Gewichtung
            new GridBagConstraints(0,2, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    
    
    con.add(tKunr,               // Nr., Anz, Gewichtung
            new GridBagConstraints(1,2, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
    
    /** 
     * bei Usereingabe der Knr beim Tippen
     * auf Eingabefehler pruefen
     */
    tKunr.addKeyListener(new KeyListener()
    {
      public void keyPressed(KeyEvent e) {        }
      public void keyReleased(KeyEvent e) {        }
      public void keyTyped(KeyEvent e) 
      {
        // hier bisherige Eingabe auf int pruefen (ggf Fehlermeldung)
        String eingabe = tKunr.getText();
        char key = e.getKeyChar();
//        System.out.println(" key Zeichen: " + e.getKeyChar());
        int kuNu = 0;
        
        if (eingabe.equals(""))   // Feld leer
        {
          tKunr.setBackground(Color.WHITE);
        }          
        else if (key >= 48 && key <= 57)   // Code fuer Zahlen 0-9
        {
          // richtig
          eingabe = eingabe.concat(String.valueOf(key));  // alle Zeichen zu String verketten
          tKunr.setBackground(Color.WHITE);
//          System.out.println("eingabe: " + eingabe);
                      
          try     // versuchen String-zahlen in int zu wandeln
          {            
            kuNu = Integer.parseInt(eingabe);
            tKunr.setBackground(Color.WHITE);
          }catch (NumberFormatException nfe)
          {     
            tKunr.setBackground(Color.RED); 
            System.err.println("NumberFormatException");
          }
        }
        // Pruefung ob Enter gedrueckt
        else if (KeyEvent.VK_ENTER == e.getKeyChar())
        {            
          tKunr.setBackground(Color.WHITE);
          
          try     // eingegebenes Zeichen in (Kunden-)Nummer umwandeln
          {            
            kuNu = Integer.parseInt(eingabe);
            tKunr.setBackground(Color.WHITE);
          }catch (NumberFormatException nfe)
          {     
            tKunr.setBackground(Color.RED);    // Fehler - Feld rot hinterlegt
            System.err.println("NumberFormatException");
          }
//          System.out.println("hier in enter\tkundenNummer: " + kuNu);
          
          // Pruefung ob auch im Zahlenbereich der vorhandenen KundenNummern
          if (kuNu > 1000 && kuNu <= selectedBank.getHoechsteKundenNr())
          {
            // in cKunde kunde mit gewaehlter kuNu auswaehlen --> OK
            int index = 1;      // weil Index 0 -> Element null
            for (Kunde k : selectedBank.getKundenDerBank())
            {
              if (k.getKundenNr() == kuNu)    // Usereingabe mit Kunden in Liste vergleichen 
              {
                // Kunde mit entsprechender KundenNr in Combobox vor-auswaehlen
                cKunde.setSelectedItem(cKunde.getItemAt(index));      
//                System.out.println("\n\n Kunde in ckunde gesetzt auf " + k.getVName());
              }                
              index++;
            }
          }
          else    // KundenNummer bisher noch nicht vorhanden --> Fehler - Feld rot hinterlegt
          {
            tKunr.setBackground(Color.RED);
          }
        }// Ende Enter gedrueckt
        else      // sonstige Zeichen
        {
          tKunr.setBackground(Color.RED);
          if (key == KeyEvent.VK_BACK_SPACE)  // bei Return - Loeschen
          {
            try
            {            
              kuNu = Integer.parseInt(eingabe);   // Ergebnis wieder richtig
              tKunr.setBackground(Color.WHITE);
            }catch (NumberFormatException nfe)    // Ergebnis immernoch falsch
            {     
              tKunr.setBackground(Color.RED); 
              System.err.println("NumberFormatException");
            }
          }
        }
      }// Ende keyTyped        
    });// Ende keyListner
        
    
    /** Kontoart */ 
    JLabel lKontoArt = new JLabel();
    lKontoArt.setText("Art des Kontos");
    con.add(lKontoArt,               // Nr., Anz, Gewichtung
            new GridBagConstraints(0,3, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
      
    final JTextField tKontoArt = new JTextField();
    con.add(tKontoArt,          // Nr., Anz, Gewichtung
            new GridBagConstraints(1,3, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf

    
    /** KontoNr (automatisch hochzaehlen) schreibgeschuetzt */ 
    JLabel lKontoNr = new JLabel();
    lKontoNr.setText("Konto Nr.");
    con.add(lKontoNr,           // Nr., Anz, Gewichtung
            new GridBagConstraints(0,4, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf

    tKontoNr.setColumns(15);   // da int nur bis 2Mio geht
    con.add(tKontoNr,               // Nr., Anz, Gewichtung
            new GridBagConstraints(1,4, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
    tKontoNr.setEditable(false);  // schreibgeschuetzt      
    
    
    /** hier gehts weiter mit cBank ActionListener */
    cBank.addItemListener(new ItemListener()
    {  
      public void itemStateChanged(ItemEvent e) 
      {                 
        // ist auch eine Bank gewaehlt?
        if (cBank.getSelectedIndex() != 0 && cBank.getSelectedItem() != null)
        {       
          // Bank verfuegbar, in Combobox angezeigt
          selectedBank = new Bank(null, null);
          int i = cBank.getSelectedIndex();
          selectedBank.setBankName(cBank.getItemAt(i).toString());
          
          for (Bank bank : listeDerBanken)
          {
            // welche Bank ist gewaehlt (in Combobox)
            if (bank.getBankName().equals(selectedBank.getBankName())) 
            {
              // gewaehlte Bank in Liste gefunden
              selectedBank = bank;
              
              // Kundenliste aktualisieren
              cKunde.removeAllItems();      // Combobox leeren
              cKunde.addItem(null);         // leeres Item einfuegen
              
              // Combobox mit der bestimmten Auswahl an Kunden fuellen
//              System.out.println("\n+++++ kunden der bank " + selectedBank.getBankName() + " +++++");
              for (Kunde k : selectedBank.getKundenDerBank())
              { 
                cKunde.addItem(k.getNName() + " " + k.getVName());
//                System.out.println("Name: " + k.getNName() + " " + k.getVName());
              }
              
              /** Hier Kontonummer der Bank ermitteln + anzeigen lassen */
              // Bank zuvor NICHT gewaehlt (benoetigt wegen korrektem inc d. kontoNr)
              if ( ! vorherSelektierteBank.contains(selectedBank))  // nicht in Liste
              {
                // aktualisiert Dialogfeld mit naechster KontoNr
                kontoNr = selectedBank.getNaechsteFreieKontonummer();
                
//                System.out.println("fortlaufende kontoNr (aus NaechsteFreieKoNu): " + kontoNr + 
//                                   "\tder Bank: " + selectedBank.getBankName()); // Kontrollausgabe
                
                tKontoNr.setText(String.valueOf(kontoNr));
                
                // Bank der Liste bereits gewaehlter Banken hinzufuegen (kein doppeltes hochzaehlen d.konu)
                vorherSelektierteBank.add(selectedBank);    
                
                
//                System.out.println("Bank:  " + selectedBank.getBankName() + 
//                                   "  zur Liste vorherSelektierteBank hinzugefuegt\n"); // Kontrollausgabe
              }
              
              // Konto zuvor GEWAeHLT (in Liste vorherSelektiertekontoNr enthalten)
              else      
              {
                tKontoNr.setText(String.valueOf(selectedBank.getNaechsteFreieKontonummer()));
//                System.out.println("\n\n\ttKunr (aus HoechsteKoNu): " + tKunr.getText()); // Kontrollausgabe
                
//                System.out.print("\n========= Banken in vorherSelektierteBank =========\n||");
//                for (Bank b : vorherSelektierteBank)
//                {  System.out.print("\t\t" + b.getBankName());      }
//                System.out.println("\t||\n======================================================\n");
              }     
            }
          }
        }
      }// Ende actionPerformed        
    });// Ende addItemListener
    
    
    // bei aenderung bank muss aenderung combobox kunden erfolgen --> ok
    /** hier gehts weiter mit Combobox Kundenauswahl */
    cKunde.addItemListener(new ItemListener()
    {         
      public void itemStateChanged (ItemEvent e) {
        
        // ist auch ein Kunde gewaehlt?
        if (cKunde.getSelectedIndex() != 0 && cKunde.getSelectedItem() != null)
        {
          // ? vllt besser loesen ueber Referenzvariable auf Kunde?
          selectedKunde = new Kunde(null, null, 0);
          int i = cKunde.getSelectedIndex();
                      
          String Name = cKunde.getItemAt(i).toString();  // muss gesplittet werden wegen "Nach- Vornamen"
          String[] nachVorName = Name.split("\\s+");

          selectedKunde.setNName(nachVorName[0]);
          selectedKunde.setVName(nachVorName[1]);
          
//          System.out.println("\nselektierter Kundenvorname: " + selectedKunde.getVName() + " " + selectedKunde.getNName());
          
          // Kunde verfuegbar, in Combobox angezeigt
          for (Kunde kunde : selectedBank.getKundenDerBank())
          {
//            System.out.println("\tin for nach kunde suchen");
            //  bis hier ok, aber drunter geht noch nicht!
            
            // welcher Kunde ist gewaehlt (in Combobox)
            if (kunde.getVName().equals(selectedKunde.getVName()) &&
                kunde.getNName().equals(selectedKunde.getNName())) 
            {                   
//              System.out.println("kunde gefunden");
              selectedKunde = kunde;
              
//              System.out.println("\tkundennr des kunden " + selectedKunde.getVName() + " " 
//                                 + selectedKunde.getNName() + ": " + selectedKunde.getKundenNr());
//                  tKontoNr.setText(String.valueOf(selectedKunde.getKundenNr()));
              
//              System.out.println("kuNu gesetzt");
              
              tKunr.setText(String.valueOf(selectedKunde.getKundenNr()));                
                           
            }// Ende if gewaehltes Konto       
          }
        }
        else if (!tKunr.equals(""))
        {
          System.err.println("\n\tFehler in DlgNeuesKonto - cKunde - actionPerformed !!! ");
        }
      }// Ende actionPerformed      
    });// Ende cKunde.addItemListener
    
    
    /** Buttons OK + Abbrechen */ 
    // Test? 2 Buttons selbe Groeﬂe geht noch nicht!

    final JButton bOK = new JButton();
    bOK.setText("OK");
    con.add(bOK,               // Nr., Anz, Gewichtung
            new GridBagConstraints(0,6, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                   new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf      
    bOK.addActionListener(new ActionListener()
      { 
        public void actionPerformed(ActionEvent e)
        {
          // KEINE Bank ausgewaehlt --> Fehler
          if (cBank.getSelectedItem() == null)
          { JOptionPane.showMessageDialog(null, "Bitte eine Bank waehlen!");    }
          // Bank AUSGEWAeHLT --> Ok
          else
          {
            boolean kontoBereitsAngelegt = speichern(tKontoArt.getText(), kontoNr, listeDerBanken);
            if (kontoBereitsAngelegt == false)     // Kunde gespeichert, Dialog schlieﬂen
            {              
              dlgNeu.setVisible(false);
              dlgNeu.dispose();
              selectedBank = null;
              // Liste vorherSelektierteBanken leeren, sodass kundenNr wieder hochgezaehlt werden kann
              vorherSelektierteBank.clear();
            }              
          }// Ende else Bank ausgewaehlt
        }// Ende actionPerformed
    });// Ende addActionListener
    
    tKontoArt.addKeyListener(new KeyListener()
    {
      public void keyTyped(KeyEvent e) {      }
      public void keyPressed(KeyEvent e) {      }
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {          
//          System.out.println("\n\n\t========= Enter geklickt ===========");
          bOK.doClick();             
        }      
      }           
    });
    
    JButton bAbbr = new JButton();
    bAbbr.setText("Abbrechen");
    con.add(bAbbr,              // Nr., Anz, Gewichtung
            new GridBagConstraints(1,6, 2,1, 1.0,0.0, 
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
     * Fenstergroeﬂe festlegen + mittig auf Bildschirm positionieren,
     * Komponenten hinzufuegen + anzeigen
     */
    dlgNeu.setSize(270, 270);
    dlgNeu.setLocation(     // mittig auf Bildschirm platzieren
        (Toolkit.getDefaultToolkit().getScreenSize().width  - dlgNeu.getSize().width)  / 2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - dlgNeu.getSize().height) / 2);
      
    dlgNeu.setContentPane(con);
    dlgNeu.setVisible(true);            
    
   
    cBank .setSelectedIndex(0);
    cKunde.setSelectedIndex(0);
   
//    System.out.println(" ~~~~~~~~~~~~~~ listeDerKunden ~~~~~~~~~~~~~");
//    for (Bank b : listeDerBanken)
//    {
//      for (Kunde kunde : b.getKundenDerBank())
//      {
//        System.out.println("Name: " +kunde.getVName()+ " " +kunde.getNName()+ "\t" +kunde.getKundenNr());
//      }
//    }
//    System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");    
    
  }// Ende Pruefung sindAuchKundenAngelegt(true)
  }// Ende Konstruktor DlgNeues KontoDepot(...) ------------------------------------------------------ 
  

  
  public boolean speichern (String kontoArt, long kontoNr, ArrayList<Bank> listeDerBanken)
  {    
    boolean kontoBereitsAngelegt = true;       // default: Konto bereits in Liste angelegt
    
    // Ueberpruefung Benutzereingaben komplett     // falsche Eingaben
    if (kontoArt.isEmpty() || selectedBank == null || selectedKunde == null || kontoNr == 0)
    {
      JOptionPane.showMessageDialog(null, "Bitte Auswahl der Bank / des Kunden oder KontoArt pruefen!");
      kontoBereitsAngelegt = true;
    }
    
    // Benutzereingaben sind richtig
    else
    {
      Konto neuesKonto = null;
      // bei leerer Liste gleich anlegen
      if (selectedKunde.getKonten().isEmpty())
      {
        neuesKonto = new Konto(kontoArt, kontoNr);    
//        System.out.println("\t1. Konto erfolgreich angelegt\n");
        kontoBereitsAngelegt = false;        
        
        // Kunde in Modell einfuegen/erweitern  
//        listeDerKonten.add(neuesKonto);
        model.addElement(neuesKonto.getKontoArt() + " (" + neuesKonto.getKontoNr() + ")");     
        selectedKunde.neuesKontoHinzufuegen(neuesKonto);
//        selectedBank.kontenDerBankAktualisieren(neuesKonto);
      }
      
      // bei befuellter Liste pruefen ob vorhanden
      else if (selectedKunde.getKonten().isEmpty() == false)
      {
        // Konto bereits in Liste vorhanden --> Fehler
        if (selectedKunde.getKonten().contains(kontoNr))
        {
          kontoBereitsAngelegt = true;
          JOptionPane.showMessageDialog(null, "Achtung! Konto bereits vorhanden!");
        }
        // Kunde noch nicht angelegt --> neu einfuegen
        else    
        {          
          kontoBereitsAngelegt = false;
          neuesKonto = new Konto(kontoArt, kontoNr);         
//          System.out.println("\n   Kunde ERFOLGREICH ANGELEGT!\n\n");
          
          // Kunde in Modell einfuegen/erweitern
//          listeDerKonten.add(neuesKonto); 
          model.addElement(neuesKonto.getKontoArt() + " (" + neuesKonto.getKontoNr() + ")");       
          selectedKunde.neuesKontoHinzufuegen(neuesKonto);
//          selectedBank.kontenDerBankAktualisieren(neuesKonto);
        }                        
      }// Ende else if befuellte Liste pruefen
    }// Ende else - Kunde anlegen  
    
    return kontoBereitsAngelegt;
  }// Ende speichern
  
}


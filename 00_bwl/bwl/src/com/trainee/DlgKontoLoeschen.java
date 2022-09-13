package com.trainee;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class DlgKontoLoeschen {
  
//  private DefaultListModel modelBank;
//  private DefaultListModel modelKonto;
//  private ArrayList<Konto> listeDerKonten;
  
  Bank  selectedBank;
  Kunde selectedKunde;
  Konto selectedKonto;

  public DlgKontoLoeschen  (final ArrayList<Bank>  listeDerBanken,
                            final DefaultListModel modelBank, final DefaultListModel modelKonto)
  {
    final ArrayList<Konto> listeDerKonten = new ArrayList<Konto>();
 
    // Test ueberhaupt Konten vorhanden
    for (Bank ban : listeDerBanken)
    { for (Kunde kun : ban.getKundenDerBank())
      {
        if (!kun.getKonten().isEmpty())
        { for (Konto kon : kun.getKonten())
          { listeDerKonten.add(kon);   }
        }
      }
    }
      
    if (listeDerKonten.isEmpty())   // es muss erst ein Konto existieren
    {
      JOptionPane.showMessageDialog(null, "Bitte zuerst ein Konto anlegen!");
    }
    
    else{       // Konto existiert --> weiter machen
    
    final JFrame dlgNeu = new JFrame();
    dlgNeu.setTitle("Konto loeschen");
    dlgNeu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    this.modelBank  = modelBank;
//    this.modelKonto = modelKonto;
//    this.listeDerKonten = listeDerKonten;
    
    
    // Layoutmanager einfuegen      
    /** 
    * Labels links untereinander im Fenster, 
    * Comboboxen rechts auf gleicher Hoehe, gleiche Laenge
    * Buttons darunter in gleicher Laenge
    * 
    * Bank waehlen (Combobox)
    * Kunde waehlen (Combobox) -> Kundenliste nach aktueller Bank auswaehlen
    * Konto waehlen (Combobox) -> Kontoliste nach aktuellem Kunden auswaehlen
    * Buttons OK, Abbrechen                                        
    */
    /**     Attribute von Konto: 
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
    cKunde.addItem(null);     // damit KontoNr nicht mehrfach hochgezaehlt wird ?benoetigt?      
   
    con.add(cKunde,             // Nr., Anz, Gewichtung
            new GridBagConstraints(1,1, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    
    
    /**
     * Auswahl des Kontos (aus Combobox)
     */
    JLabel lKonto = new JLabel();
    lKonto.setText("Konto");
    con.add(lKonto,             // Nr., Anz, Gewichtung
            new GridBagConstraints(0,2, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    
    
    /** listeDerKonten in Combobox einfuegen */
    final JComboBox cKonto = new JComboBox();
    cKonto.addItem(null);     
   
    con.add(cKonto,             // Nr., Anz, Gewichtung
            new GridBagConstraints(1,2, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    
    
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
          selectedBank.setBankName(cBank.getItemAt(cBank.getSelectedIndex()).toString());
          
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
              for (Kunde k : selectedBank.getKundenDerBank())
              { cKunde.addItem(k.getNName() + " " + k.getVName());   }
            }
          }
        }
      }// Ende actionPerformed        
    });// Ende addItemListener
    
    /** hier gehts weiter mit Combobox Kundenauswahl */
    cKunde.addItemListener(new ItemListener()
    {         
      public void itemStateChanged (ItemEvent e) {
        
        // ist auch ein Kunde gewaehlt?
        if (cKunde.getSelectedIndex() != 0 && cKunde.getSelectedItem() != null)
        {
          // Test? vllt besser loesen ueber Referenzvariable auf Kunde?
          selectedKunde = new Kunde(null, null, 0);
          int i = cKunde.getSelectedIndex();
                      
          String Name = cKunde.getItemAt(i).toString();  // muss gesplittet werden wegen "Nach- Vornamen"
          String[] nachVorName = Name.split("\\s+");

          selectedKunde.setNName(nachVorName[0]);
          selectedKunde.setVName(nachVorName[1]);
          
          System.out.println("\nselektierter Kundenvorname: " + selectedKunde.getVName() + 
                             " " + selectedKunde.getNName());

          // Kunde verfuegbar, in Combobox angezeigt
          for (Kunde kunde : selectedBank.getKundenDerBank())
          {
//            System.out.println("\tin for nach kunde suchen");
            
            // welcher Kunde ist gewaehlt (in Combobox)
            if (kunde.getVName().equals(selectedKunde.getVName()) &&
                kunde.getNName().equals(selectedKunde.getNName())) 
            {                   
              System.out.println("kunde gefunden");
              selectedKunde = kunde;
              
              System.out.println("\tkundennr des kunden " + selectedKunde.getVName() + " " 
                                 + selectedKunde.getNName() + ": " + selectedKunde.getKundenNr()); 
            }// Ende if gewaehlter Kunde
          }
          
          // Konten-Combobox mit entsprechenden Werten fuellen
          for (Konto k : selectedKunde.getKonten())
          {   cKonto.addItem(k.getKontoNr());   }
        }
      }// Ende actionPerformed      
    });// Ende addItemListener
    
    cKonto.addItemListener(new ItemListener()
    {  
      public void itemStateChanged(ItemEvent e) 
      {                 
        // ist auch ein Konto gewaehlt?
        if (cKonto.getSelectedIndex() != 0 && cKonto.getSelectedItem() != null)
        { 
          selectedKonto = new Konto(null, 0);
          int i = cKonto.getSelectedIndex();          
                      
          selectedKonto.setKontoNr(Long.parseLong(cKonto.getItemAt(i).toString()));  // muss geparst werden
//          System.out.println("\n\n\tInhalt von Combobox Konto: " + Name);

//          // Konto verfuegbar, in Combobox angezeigt
//          for (Konto konto : selectedKunde.getKonten())
//          {
//            System.out.println("\tin for nach konto suchen");
//            
//            // welches Konto ist gewaehlt (in Combobox)
//            if (konto.getKontoNr() == selectedKonto.getKontoNr()) 
//            {                   
//              System.out.println("konto gefunden");
//              selectedKonto = konto;
//              
//              System.out.println("\tkontonr " + selectedKonto.getKontoNr() + " Konto von Kunde " 
//                                 + selectedKunde.getNName() + " bei bank " + selectedBank.getBankName());
                                         
//            }// Ende if gewaehltes Konto       
//          }
        }
      }// Ende actionPerformed        
    });// Ende addItemListener


    
    
    /** Buttons OK + Abbrechen */ 
    // Test? 2 Buttons selbe Groeﬂe geht noch nicht!

    final JButton bOK = new JButton();
    bOK.setText("OK");
    con.add(bOK,                // Nr., Anz, Gewichtung
            new GridBagConstraints(0,6, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                   new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf      
    bOK.addActionListener(new ActionListener()
      { 
        public void actionPerformed(ActionEvent e)
        {
          // KEINE Bank/Kunde/Konto ausgewaehlt --> Fehler
          if (cBank .getSelectedItem() == null || cKunde.getSelectedItem() == null || 
              cKonto.getSelectedItem() == null)
          { JOptionPane.showMessageDialog(null, "Bitte Bank, Kunde und Konto waehlen!");    }
          // Bank AUSGEWAeHLT --> Ok
          else
          {
            // Dialog Konto wirklich loeschen
            /*
             * / * Return value from class method if YES is chosen. * /
                  public static final int         YES_OPTION = 0;
                  /** Return value from class method if NO is chosen. * /
                  public static final int         NO_OPTION = 1;
                  /** Return value from class method if CANCEL is chosen. * /
                  public static final int         CANCEL_OPTION = 2;
                  /** Return value form class method if OK is chosen. * /
                  public static final int         OK_OPTION = 0;
                  /** Return value from class method if user closes window without selecting
                   * anything, more than likely this should be treated as either a
                   * <code>CANCEL_OPTION</code> or <code>NO_OPTION</code>. * /
                  public static final int         CLOSED_OPTION = -1;
             */
            int auswahl = JOptionPane.showConfirmDialog
                          (null, "Sind Sie sicher, dass Sie dieses Konto wirklich loeschen moechten?");
            
            if (auswahl == 0)   // YES_OPTION = 0;
            {
              // loeschen einleiten
              
              boolean geloescht = selectedBank.kontoLoeschen(selectedKonto);
              System.out.println("Bank geloescht: " + geloescht);
              
              geloescht = selectedKunde.kontoLoeschen(selectedKonto);
              System.out.println("Bank geloescht: " + geloescht);
              // TODO bei beiden Versionen geloescht = false, wird einfach nicht geloescht
              
              // Liste Konto aktualisieren
              modelKonto.clear();
              if (!selectedKunde.getKonten().isEmpty())
              {
                for (Konto k : selectedKunde.getKonten())
                {
                  modelKonto.addElement(k.getKontoArt() + " (" + k.getKontoNr() + ")");
                }
              }
              
              // TODO hier benoetigt?
//              for (Konto k : selectedKunde.getKonten())     // aus Kunden-Kontoliste loeschen
//              {
//                if (selectedKonto.getKontoNr() == k.getKontoNr())
//                {
//                  System.out.println("selected Konto: " + selectedKonto.getKontoNr() +
//                                     "\nKonto k       : " + k.getKontoNr());
//                  k = null;
//                }
//              }
              
              
//              for (Konto k : selectedBank.getKontenDerBank())     // aus Bank-Kontoliste loeschen
//              {
//                if (selectedKonto.getKontoNr() == k.getKontoNr())
//                {
//                  k = null;
//                }
//              }
//              for (Konto k : listeDerKonten)     // aus Kontoliste loeschen
//              {
//                if (selectedKonto.equals(k))
//                {
//                  k = null;
//                  break;
//                }
//              }
              
              // TODO wird noch nicht geloescht, immernoch vorhanden
              //   wie auf Objekte von GUIbankApp zugreifen, aendern und zurueckgeben?
              //   methode loeschen mit rueckgabe
              modelKonto.removeElement(selectedKonto);       // aus JList entfernen  
              
              modelKonto.clear();
              System.out.println("\n  modelKonto geleert, wird jetzt mit allen Konten des Kunden gefuellt");
              for (Konto k : selectedKunde.getKonten())
              {                
                System.out.println("Kontoart: " + k.getKontoArt() + " KontoNr: (" + k.getKontoNr() + ")");
                modelKonto.addElement(k.getKontoArt() + " (" + k.getKontoNr() + ")");                
              }
              
              // bei neues Konto folgender code
//              model.addElement(neuesKonto.getKontoArt() + " (" + neuesKonto.getKontoNr() + ")");       
//    ok          selectedKunde.neuesKontoHinzufuegen(neuesKonto);
              
              
              // Dialog schlieﬂen
              dlgNeu.setVisible(false);
              dlgNeu.dispose();
            }// Ende if auswahl == ja
            else
            {
              // nichts tun (zurueck zum Dialog)
            }            
            
          }// Ende else Bank ausgewaehlt
        }// Ende actionPerformed
    });// Ende addActionListener
    
        
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
        }
    });// Ende addActionListener
      
    
    /**
     * Fenstergroeﬂe festlegen + mittig auf Bildschirm positionieren,
     * Komponenten hinzufuegen + anzeigen
     */
    dlgNeu.setSize(270, 270);
    dlgNeu.setLocation(
        (Toolkit.getDefaultToolkit().getScreenSize().width - dlgNeu.getSize().width) / 2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - dlgNeu.getSize().height) / 2);
      
    dlgNeu.setContentPane(con);
    dlgNeu.setVisible(true);                
          
    cBank .setSelectedIndex(0);
    cKunde.setSelectedIndex(0);
    cKonto.setSelectedIndex(0);
   
  }// Ende Pruefung sindAuchKundenAngelegt(true)
  }// Ende Konstruktor DlgKontoLoeschen(...) ------------------------------------------------------ 
    
}


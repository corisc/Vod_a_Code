package com.trainee;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class DlgGeldgeschaefte {
  
  // Dialog fuer Geld ein- und auszahlen
  Bank  selectedBank;
  Kunde selectedKunde;
  Konto selectedKonto;
  
  boolean geldEinzahlen = true;     // true = Geld einzahlen; false = Geld auszahlen
  
 
  public DlgGeldgeschaefte(final ArrayList<Bank>  listeDerBanken,
                           boolean geldEinzahlen)
  {
    /** Attribute von Konto
     * private String kontoArt;         // Array mit vorgegebenen Kontoarten?
       private long   kontoNr;          // long ~19 Stellen
       private double kontostand;
     */
    this.geldEinzahlen = geldEinzahlen;
    
    // Pruefung ob Konten vorhanden
    final ArrayList<Konto> listeDerKonten = new ArrayList<Konto>();
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
    
    else{       // Konto existiert
    
    final JFrame dlgNeu = new JFrame();
    dlgNeu.setTitle("Geld einzahlen");
    dlgNeu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    
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
          // ? vllt besser loesen ueber Referenzvariable auf Kunde?
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
            System.out.println("\tin for nach kunde suchen");
            
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
          
          selectedKonto.setKontoNr(Long.parseLong(cKonto.getItemAt(i).toString()));  
//          System.out.println("\n\n\tInhalt von Combobox Konto: " + Name);
          

          // Konto verfuegbar, in Combobox angezeigt               
          for (Konto konto : selectedKunde.getKonten())
          {
            System.out.println("\tin for nach konto suchen");
            
            // welches Konto ist gewaehlt (in Combobox)
            if (konto.getKontoNr() == selectedKonto.getKontoNr()) 
            {                   
              System.out.println("konto gefunden");
              selectedKonto = konto;
              
              System.out.println("\tkontonr " + selectedKonto.getKontoNr() + " Konto von Kunde " 
                                 + selectedKunde.getNName() + " bei bank " + selectedBank.getBankName());
                                         
            }// Ende if gewaehltes Konto       
          }
        }
      }// Ende actionPerformed        
    });// Ende addItemListener
    
    
    // hier Betrag
    JLabel lBetrag = new JLabel();
    lBetrag.setText("Betrag in €: ");
    con.add(lBetrag,            // Nr., Anz, Gewichtung
            new GridBagConstraints(0,3, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    
    final JTextField tBetrag = new JTextField();
    con.add(tBetrag,            // Nr., Anz, Gewichtung
            new GridBagConstraints(1,3, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    
    tBetrag.setText("z.B. 1054.50");
    tBetrag.addFocusListener (new FocusListener()
    {
      public void focusLost(FocusEvent e) {      }      
      public void focusGained(FocusEvent e) {
        tBetrag.setText("");        
      }      
    });

    
    /** Buttons OK + Abbrechen */ 
    // Test? 2 Buttons selbe Groeße geht noch nicht!

    final JButton bOK = new JButton();
    bOK.setText("OK");
    con.add(bOK,               // Nr., Anz, Gewichtung
            new GridBagConstraints(0,6, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                   new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf      
    bOK.addActionListener(
      new ActionListener()
      { 
        public void actionPerformed(ActionEvent e)
        {
          // KEINE Bank/Kunde/Konto ausgewaehlt --> Fehler
          if (cBank .getSelectedItem() == null || cKunde.getSelectedItem() == null || 
              cKonto.getSelectedItem() == null)
          { JOptionPane.showMessageDialog(null, "Bitte Bank, Kunde und Konto waehlen!");    }
//          else if ()      // TODO hier Pruefung Betrag korrekt eingegeben
          // Bank AUSGEWAeHLT --> Ok
          else
          {
            boolean geldEinAusgezahlt = geldEinAuszahlen(tBetrag.getText(), listeDerKonten);
            if (geldEinAusgezahlt == true)     // Kunde gespeichert, Dialog schließen
            {            
              // Dialog schließen
              dlgNeu.setVisible(false);
              dlgNeu.dispose();
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
    bAbbr.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          dlgNeu.setVisible(false);
          dlgNeu.dispose();
        }
    });// Ende addActionListener
      
    
    tBetrag.addKeyListener(new KeyListener()
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
    
    
    /**
     * Fenstergroeße festlegen + mittig auf Bildschirm positionieren,
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
    
    
    // hier Daten von Geld einzahlen auf Geld auszahlen aendern
    if (geldEinzahlen == false)
    {
      dlgNeu.setTitle("Geld auszahlen");      
    }
   
  }// Ende Pruefung sindAuchKundenAngelegt(true)    
  }// Ende Konstruktor DlgGeldgeschaefte
  
  
  public boolean geldEinAuszahlen (String betrag, ArrayList<Konto> listeDerKonten)
  {    
    boolean geldEinAusgezahlt = false;       // default: kein Geld ein-/ausgezahlt
    
    // Ueberpruefung Benutzereingaben komplett     // falsche Eingaben
    if (selectedBank == null || selectedKunde == null || selectedKonto == null)
    {
      JOptionPane.showMessageDialog(null, "Bitte Auswahl Bank/Kunde/Konto pruefen!");
      geldEinAusgezahlt = false;
    }
    else if (betrag.isEmpty())
    {
      JOptionPane.showMessageDialog(null, "Bitte gewuenschten Betrag eingeben!");
      geldEinAusgezahlt = false;
    }
    // Benutzereingaben sind richtig
    else
    {
      // String betrag in double umwandeln
      double geldBetrag = 0.0;
      try
      {
        geldBetrag = Double.parseDouble(betrag);
      }catch (NumberFormatException nfe)
      {
        System.out.println("Betrag nicht in double konvertierbar!");
        JOptionPane.showMessageDialog(null, "Betrag nicht korrekt! Bitte versuchen Sie diese Formatierung: \n" +
                                            "€€€€.ctct \n €=Euro\t\t ct=Cent");
        nfe.printStackTrace();
      }
      
      // passendes Konto raussuchen
      for (Konto k : selectedKunde.getKonten())
      {
        if (selectedKonto.getKontoNr() == k.getKontoNr())
        {   selectedKonto = k;        }
      }   
      
      if (geldEinzahlen == true)    // Geld einzahlen
      {
        selectedKonto.geldEinzahlen(geldBetrag);
        selectedBank.geldEingezahlt(geldBetrag);      
        geldEinAusgezahlt = true;
      }
      else                          // Geld auszahlen
      {
        selectedKonto.geldAbheben(geldBetrag);
        selectedBank.geldAusgezahlt(geldBetrag);      
        geldEinAusgezahlt = true;
      }
            
//      listeDerKonten.add(neuesKonto);       // liste mit betrag aktualisieren? eig nur kopie.. sinnlos?      
    }// Ende else - Kunde anlegen  
    
    return geldEinAusgezahlt;
  }// Ende speichern

}
package com.trainee;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DlgBankOeffnen {
  
  private Bank selectedBank = null;  
  
  public Bank getSelectedBank() {
    return selectedBank;
  }
  private boolean bankOk = false;

  public DlgBankOeffnen(final ArrayList<Bank> listeDerBanken)       // Konstruktor
  {    
    final JFrame dlgNeu = new JFrame();
    dlgNeu.setTitle("Bank auswaehlen");
    dlgNeu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    dlgNeu.addWindowListener(new WindowListener()
    {
      public void windowActivated(WindowEvent e) {}
      public void windowClosed(WindowEvent e) {
        bankOk = true;
      }
      public void windowClosing(WindowEvent e) {}
      public void windowDeactivated(WindowEvent e) {}
      public void windowDeiconified(WindowEvent e) {}
      public void windowIconified(WindowEvent e) {}
      public void windowOpened(WindowEvent e) {}      
    });

        
    // Layoutmanager einfuegen      
    /** 
     * Labels links untereinander im Fenster, 
     * Textboxen rechts auf gleicher Hoehe, gleiche (variable) Laenge
     * Buttons darunter in gleicher Laenge
     */
    Container con = dlgNeu.getContentPane();
    con.setLayout(new GridBagLayout());
    
    
    JLabel lBank = new JLabel();
    lBank.setText("Bank");
    con.add(lBank,              // Nr., Anz, Gewichtung
            new GridBagConstraints(0,0, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
       
    final JComboBox cBank = new JComboBox();    
    cBank.addItem(" ");
    for (Bank bank : listeDerBanken)    // Daten in der ComboBox packen
    {
      cBank.addItem(bank.getBankName());
    }    
    con.add(cBank,              // Nr., Anz, Gewichtung
            new GridBagConstraints(1,0, 1,1, 1.0,0.0, 
                                   GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    

    JLabel lBLZ = new JLabel();
    lBLZ.setText("BLZ");
    con.add(lBLZ,               // Nr., Anz, Gewichtung
            new GridBagConstraints(0,1, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf

    final JTextField tBLZ = new JTextField();
    con.add(tBLZ,               // Nr., Anz, Gewichtung
            new GridBagConstraints(1,1, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,10,10), 0,0));      // Mindestplatzbedarf
    tBLZ.setEnabled(true);      // schreibschutz
    
    
    JLabel lKunden = new JLabel();
    lKunden.setText("Anzahl Kunden: ");
    con.add(lKunden,            // Nr., Anz, Gewichtung
            new GridBagConstraints(0,2, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,15,10), 0,0));      // Mindestplatzbedarf
    final JLabel lAnzKunden = new JLabel();
    lAnzKunden.setText(" ");
    con.add(lAnzKunden,         // Nr., Anz, Gewichtung
            new GridBagConstraints(1,2, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,15,10), 0,0));      // Mindestplatzbedarf
    
    JLabel lKonten = new JLabel();
    lKonten.setText("Anzahl Konten: ");
    con.add(lKonten,            // Nr., Anz, Gewichtung
            new GridBagConstraints(0,3, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,13,10), 0,0));      // Mindestplatzbedarf
    final JLabel lAnzKonten = new JLabel();
    lAnzKonten.setText(" ");
    con.add(lAnzKonten,         // Nr., Anz, Gewichtung
            new GridBagConstraints(1,3, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,10,13,10), 0,0));      // Mindestplatzbedarf

    
    cBank.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e) {
        System.out.println("\tin ItemListener - itemStateChanged");
        int index = cBank.getSelectedIndex();
        String name = cBank.getSelectedItem().toString();
        
        if (index == -1 || index == 0)     // keine Bank gewaehlt
        {
          System.out.println("keine Bank gewaehlt! " + index);
          // Felder zuruecksetzen
          tBLZ.setText(" ");
          lAnzKunden.setText(" ");
          lAnzKonten.setText(" ");
        }
        else        // Bank gewaehlt
        { 
          index--;      // weil 0. combobox-item leer         
          // nach passenden Index in listeDerBanken suchen + Bank rausfinden
          
          if (listeDerBanken.get(index).getBankName().equals(name))
          { // Bank gefunden
            selectedBank = listeDerBanken.get(index);
//            System.out.println("Bank: " + selectedBank.getBankName());
            tBLZ.setText(selectedBank.getBlz());
//            System.out.println("BLZ: " + selectedBank.getBlz());
            lAnzKunden.setText(String.valueOf(listeDerBanken.get(index).getKundenDerBank().size()));
//            System.out.println("Anz Kunden: " + lAnzKunden.getText());
            
            int anzKonten = 0;
            for (int f = 0; f < listeDerBanken.get(index).getKundenDerBank().size(); f++)
            {
              anzKonten = listeDerBanken.get(index).getKundenDerBank().get(f).getKonten().size();
            }
            lAnzKonten.setText(String.valueOf(anzKonten));
          }            
          
        }// Ende else
      }// Ende itemStateChanged      
    });
    
   
    // Buttons OK + Abbrechen
    final JButton bOK = new JButton();
    bOK.setText("OK");
    con.add(bOK,               // Nr., Anz, Gewichtung
            new GridBagConstraints(0,4, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                   new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf      
    bOK.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.out.println("gewaehlte Bank: " + selectedBank.getBankName());
        bankOk = true;
        dlgNeu.setVisible(false);
        dlgNeu.dispose();
      }
    });    
    
    JButton bAbbr = new JButton();
    bAbbr.setText("Abbrechen");
    con.add(bAbbr,              // Nr., Anz, Gewichtung
            new GridBagConstraints(1,4, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                   new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf
    bAbbr.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        selectedBank = null;
        bankOk = true;
        dlgNeu.setVisible(false);
        dlgNeu.dispose();
      }
    });
    
    
    /**
     * Fenstergroeße festlegen + mittig auf Bildschirm positionieren,
     * Komponenten hinzufuegen + anzeigen
     */
//    dlgNeu.setSize(300, 180);
    dlgNeu.pack();      // Dialog so klein wie moeglich machen
    dlgNeu.setLocation(
        (Toolkit.getDefaultToolkit().getScreenSize().width - dlgNeu.getSize().width) / 2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - dlgNeu.getSize().height) / 2);
      
    dlgNeu.setContentPane(con);
    dlgNeu.setVisible(true); 
    
    
    
  }// Ende Konstruktor
  
  /**
   * liefert Dialogergebnis zurueck, ob eine Bank ausgewaehlt wurde oder nicht
   * @return String angabeBankGewaehlt
   */
  public String getDialogResult()
  {
    if (selectedBank == null && bankOk == false)
    {
      return "keine Bank gewaehlt";
    }
    else
    {
      return "Bank wurde ausgewaehlt";
    }    
  }

  
  public static void main(String[] args)
  {
    ArrayList<Bank> listeDerBanken = new ArrayList<Bank>();
    listeDerBanken.add(new Bank("Sparkasse", "44444"));
    listeDerBanken.add(new Bank("Hypo", "5555"));
    listeDerBanken.get(0).neuenKundenHinzufuegen(new Kunde("Hans", "Mueller", 234234)); 
    listeDerBanken.get(0).getKundenDerBank().get(0).addKonto(new Konto("Giro", 50000));
    new DlgBankOeffnen(listeDerBanken);
  }
}


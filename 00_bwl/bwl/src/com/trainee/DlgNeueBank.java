package com.trainee;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DlgNeueBank {
  
  DefaultListModel model = new DefaultListModel();

  public DlgNeueBank(final ArrayList<Bank> listeDerBanken, DefaultListModel model)
  {
    /** 
     * Dialog fuer Benutzereingabe zum Anlegen einer neuen Bank
     */
    final JFrame dlgNeu = new JFrame();
    dlgNeu.setTitle("Neue Bank anlegen");
    dlgNeu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.model = model;

        
    // Layoutmanager einfuegen      
    /** 
     * Labels links untereinander im Fenster, 
     * Textboxen rechts auf gleicher Hoehe, gleiche (variable) Laenge
     * Buttons darunter in gleicher Laenge
     */
    Container con = dlgNeu.getContentPane();
    con.setLayout(new GridBagLayout());
    
    
    JLabel lBank = new JLabel();
    lBank.setText("Bankname");
    con.add(lBank,              // Nr., Anz, Gewichtung
            new GridBagConstraints(0,0, 1,1, 0.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.NONE,  // Ausrichtung+Ausfuellung 
                                   new Insets(10,10,10,10), 0,0));      // Mindestplatzbedarf
    
    final JTextField tBank = new JTextField();
    con.add(tBank,              // Nr., Anz, Gewichtung
            new GridBagConstraints(1,0, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
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

   
    // Buttons OK + Abbrechen
    final JButton bOK = new JButton();
    bOK.setText("OK");
    con.add(bOK,               // Nr., Anz, Gewichtung
            new GridBagConstraints(0,3, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                   new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf      
    bOK.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        boolean bankAngelegt = speichern(tBank.getText(), tBLZ.getText(), listeDerBanken);
        if (bankAngelegt == false)
        {
          dlgNeu.setVisible(false);
          dlgNeu.dispose();
        }
      }
    });    
    
    JButton bAbbr = new JButton();
    bAbbr.setText("Abbrechen");
    con.add(bAbbr,              // Nr., Anz, Gewichtung
            new GridBagConstraints(1,3, 2,1, 1.0,0.0, 
                                   GridBagConstraints.WEST, GridBagConstraints.REMAINDER,  // Ausrichtung+Ausfuellung 
                                   new Insets(20,10,10,10), 0,0));      // Mindestplatzbedarf
    bAbbr.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        dlgNeu.setVisible(false);
        dlgNeu.dispose();
      }
    });
    
    tBLZ.addKeyListener(new KeyListener()
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
    
    // TODO 2 Buttons selbe Groeﬂe geht noch nicht!
     

    
    /**
     * Fenstergroeﬂe festlegen + mittig auf Bildschirm positionieren,
     * Komponenten hinzufuegen + anzeigen
     */
    dlgNeu.setSize(300, 180);
    dlgNeu.setLocation(
        (Toolkit.getDefaultToolkit().getScreenSize().width - dlgNeu.getSize().width) / 2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - dlgNeu.getSize().height) / 2);
      
    dlgNeu.setContentPane(con);
    dlgNeu.setVisible(true);      
    
//    System.out.println(" ~~~~~~~~~~~~~~ listeDerBanken ~~~~~~~~~~~~~");
//    for (Bank bank : listeDerBanken)
//    {
//      System.out.println(bank.getBankName());
//    }
//    System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");    
  }// Ende Konstruktor
  
  
  public boolean speichern(String bankname, String blz, ArrayList<Bank> listeDerBanken)
  {    
    int i = -1;
        
    try{    i = new Integer(blz).intValue();     }
    catch(NumberFormatException nfe)
    { JOptionPane.showMessageDialog(null, "BLZ pruefen, es duerfen nur Zahlen vorkommen!");    }
    
    if (bankname.isEmpty() || blz.isEmpty() || i <= 0)
    {     
      JOptionPane.showMessageDialog(null, "Bitte Bankname und BLZ pruefen!");
    }
    
    else{       // Benutzereingaben richtig
      
      Bank neueBank = null;
      boolean bankAngelegt = true;
      
      // bei leerer Bank-Liste
      if (listeDerBanken.isEmpty()){
        neueBank = new Bank(bankname, blz);
        listeDerBanken.add(neueBank);
//        System.out.println("\t1. Bank erfolgreich angelegt\n");
        model.addElement(neueBank.getBankName());       // Bank in Modell einfuegen/erweitern
        bankAngelegt = false;
      }
      else{
        // Pruefung Bank bereits vorhanden?        
        for (Bank b : listeDerBanken)
        {
          if (bankname.equals(b.getBankName()) || blz.equals(b.getBlz())){
            JOptionPane.showMessageDialog(null, "ACHTUNG! Bank bereits angelegt!");
            bankAngelegt = true;
            break;
          }        
          else          // Bank noch nicht angelegt
            bankAngelegt = false;                
        }
        
        // Bank nicht vorhanden --> neu einfuegen
        if (bankAngelegt == false)
        {
          neueBank = new Bank(bankname, blz);
          listeDerBanken.add(neueBank);  
//          System.out.println("\n   Bank ERFOLGREICH ANGELEGT!\n");
          model.addElement(neueBank.getBankName());       // Bank in Modell einfuegen/erweitern
        }
      }// Ende else - listeDerBanken durchsuchen  
      return bankAngelegt;
    }    
    return true;    // default
  } 
}


package com.trainee;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


// TODO Bank waehlen --> 2 Tabellen (Kunde, Konto) mit Details


@SuppressWarnings("serial")
public class GUIbankApp extends JFrame
{
  private JFrame frame;

  private ArrayList<Bank>  listeDerBanken = new ArrayList<Bank>();
  
  Dimension breiteTabelle = new Dimension();
  
  public GUIbankApp() 
  {    
    this.frame = new JFrame();
    this.frame.setTitle("Bankapplication");
    this.frame.setExtendedState(this.frame.getExtendedState() | JFrame.MAXIMIZED_BOTH); // Fullscreen
    
    this.frame.addWindowListener(new WindowListener() {
      public void windowActivated(WindowEvent e){}
      public void windowClosed(WindowEvent e){}
      public void windowDeactivated(WindowEvent e){}
      public void windowDeiconified(WindowEvent e){}
      public void windowIconified(WindowEvent e){}
      public void windowOpened(WindowEvent e){}
      public void windowClosing(WindowEvent e)      
      {
        // Eingaben speichern in Textdatei        
        System.exit(0);
      }
    });
    breiteTabelle = frame.getSize();
    breiteTabelle.setSize(breiteTabelle.getWidth()/3, breiteTabelle.getHeight());
    menuleisteSetzen();
//    frame.add(new JLabel("   Bitte 'Bank' ==> 'Auswaehlen' klicken um die Ansicht zu vervollstaendigen!"));
    
    setTable();     // erst nach Aufruf DlgBankOeffnen, wenn Bank gewaehlt
//    listenSetzen();
    this.frame.setVisible(true);    
  }

  
  
  private DefaultTableModel model;
  private JTable grid;
  /**
   * TODO 
   * Menuepunkt Bank --> Auswaehlen
   * kleiner Dlg (Bank:  | Sparkasse      |v| (Auswahlfeld mit angelegten Banken))
   * Tabellen setzen (Kunden-der Bank) (Konten) - Haelfte Bildschirm Tabellen in extra Frame/Container/Fenster
   * Tabellen beschriften (Fensterueberschrift, Spaltenbeschriftung, Details einfuegen) 
   */
  public void setTable()
  {     
    String[] colNames = {"Vorname", "Nachname", "KundenNr.",
                          "Kontoart", "KontoNr.", "Kontostand",
                          "Kredit Verwendung", "Kredit gesamt", "Kredit Rest", 
                          "Kredit Laufzeit", "Restlaufzeit", "Teiltilgung"};    
    
    model = new DefaultTableModel(colNames, 10);    
    grid = new JTable(model);
    // Spaltenbeschriftungen einfaerben
    JTableHeader header = grid.getTableHeader();
    header.setBackground(Color.yellow);

    // Vertikale Trenn-Linie nach Kundendaten (KundenNr) und Kontodaten (Kontostand)
    BorderCellRenderer renderer = new BorderCellRenderer();
    // Definition Linien Eigenschaften  -->  Farbe, Positionierung mit jeweiliger Breite
    renderer.setColumnBorder(new LinesBorder(grid.getGridColor(), new Insets(0,0,0,2)));
    
    TableColumnModel mod = grid.getColumnModel();    
    mod.getColumn(2).setCellRenderer(renderer);     // Spalte "KundenNr"
    mod.getColumn(5).setCellRenderer(renderer);     // Spalte "Kontostand"
    
    // Spaltenbreite festlegen
    /**     Struktur Spalten mit entsprechender Breite
     *   0       1      2        3      4        5           6          7        8      9        10        11
     * VName | NName | KuNr || KoArt | KoNr | KoStand || KredVerw | Kred ges | Rest | Laufz | RestLaufz | Tilg
     *  150  |  150  |  90  ||  150  |  90  |   110   ||   150    |    90    |  90  |  70   |    70     |  70
     */
    for (int i = 0; i < mod.getColumnCount(); i++)      // Spaltendurchlauf
    {
      TableColumn col = mod.getColumn(i);
      
      if (i < 2 || i == 3 || i == 6)    // Vor-/Nachname, Kontoart, Kreditverwendung
      { col.setMinWidth(150);
      }
      else if (i == 2 || i == 4 || i == 7 || i == 8)    // KundenNr, KontoNr, Kredit gesamt, Kredit Rest
      { col.setMinWidth(90);
      }
      else if (i == 5)    // KontoStand
      { col.setMinWidth(110);
      }      
      else if (i > 8)    // Kredit Laufzeit, Rest Laufzeit, Teiltilgung
      { col.setMinWidth(70);
      }      
    }

    JScrollPane pane = new JScrollPane(grid);
       
    // Tabellen in Fenster adden
    Container con = frame.getContentPane();
    con.setLayout(new GridBagLayout());
    con.add(pane,               // Nr., Anz, Gewichtung
            new GridBagConstraints(0,0, 1,1, 0.5,0.0, 
                                   GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,  // Ausrichtung+Ausfuellung 
                                   new Insets(0,0,0,0), 0,0));      // Mindestplatzbedarf

    frame.setContentPane(con);
    frame.setVisible(true);   
  }
  
  /**
   * Tabelle mit Kunden- und Kontodaten der selectedBank fuellen
   */
  public void setTableData()
  {
    System.out.println("\n\thier in SET TABLE DATA");
    // zum Test einfach 1. Bank aus der Liste nehmen
    selectedBank = listeDerBanken.get(1);
    System.out.println("selectedBank: " + selectedBank.getBankName());
    
    int row = 0;    // zeile
    int column = 0;     // spalte
    for (Kunde kunde : selectedBank.getKundenDerBank())     // Kundendaten einfuegen
    {
      model.setValueAt(kunde.getVName(),    row, column++);
      model.setValueAt(kunde.getNName(),    row, column++);
      model.setValueAt(kunde.getKundenNr(), row, column++);
      
      for (Konto konto : kunde.getKonten())     // Kontodaten einfuegen
      {
        model.setValueAt(konto.getKontoArt(),   row, column++);
        model.setValueAt(konto.getKontoNr(),    row, column++);
        model.setValueAt(konto.getKontostand(), row, column++);
        
        if (konto.getKreditRestBetrag() > 0.0)      // Kredit vorhanden
        {
          model.setValueAt(konto.getKreditVerwendung(),   row, column++);
          model.setValueAt(konto.getKreditGesBetrag(),    row, column++);
          model.setValueAt(konto.getKreditRestBetrag(),   row, column++);
          model.setValueAt(konto.getKreditLaufzeit(),     row, column++);
          model.setValueAt(konto.getKreditRestLaufzeit(), row, column++);
          model.setValueAt(konto.getKreditTeiltilgung(),  row, column);
        }
        row++;
      }      
      column = 0;
    }
    frame.repaint();
  }
  
  
  private Bank selectedBank = null;
  /**
   * Menue mit Menuepunkten erstellen + Aktionen festlegen
   */  
  public void menuleisteSetzen()
  {
    /** 
     *      Menue:    
     * Datei --> Speichern (Speichern-Dialog)   // in textdatei abspeichern
     *           Oeffnen (Oeffnen-Dialog)
     *           Neu (Frage: Wirklich neu?) // fraglich
     *           
     * Bank  --> Neu (Dialog + Liste hinzufuegen)    // ok
     *           Bearbeiten                         // noch einfuegen
     * Kunde --> Neu (Dialog + Liste hinzufuegen)    // ok
     *           Bearbeiten                         // noch einfuegen
     * Konto --> Neu, Loeschen
     * Geld  --> einzahlen, auszahlen, Kredit beantragen
     */
    // *** Menueleiste ***
    JMenuBar  menueleiste = new JMenuBar();   
    
    /** */   
    
    // *** Menuepunkt *** 
    JMenu     menuDatei   = new JMenu("Datei");         
    JMenu     menuBank    = new JMenu("Bank");         
    JMenu     menuKunde   = new JMenu("Kunde");
    JMenu     menuKonto   = new JMenu("Konto"); 
    JMenu     menuGeld    = new JMenu("Geld"); 
    
    // *** Menueunterpunkt ***
    JMenuItem dateiOeffnen   = new JMenuItem("Oeffnen");      
    JMenuItem dateiSpeichern = new JMenuItem("Speichern");
//    JMenuItem testTabSize = new JMenuItem("TestTabSize");       // TODO
    
    JMenuItem bankNeu     = new JMenuItem("Neu");  
    JMenuItem bankOeffnen = new JMenuItem("Auswaehlen");
    
    JMenuItem kundeNeu = new JMenuItem("Neu"); 
    
    JMenuItem kontoNeu     = new JMenuItem("Neu");
    JMenuItem kontoLoeschen = new JMenuItem("Loeschen");
    
    JMenuItem geldEinzahlen = new JMenuItem("Einzahlen");
    JMenuItem geldAuszahlen = new JMenuItem("Auszahlen");
    JMenuItem geldKredit    = new JMenuItem("Kredit beantragen");
    
    // Menueunterpunkte den Menuepunkten zuweisen
    menuDatei.add(dateiOeffnen);
    menuDatei.add(dateiSpeichern);
//    menuDatei.add(testTabSize);     // TODO
    
    menuBank .add(bankNeu);
    menuBank .add(bankOeffnen);
    
    menuKunde.add(kundeNeu);
    
    menuKonto.add(kontoNeu);
    menuKonto.add(kontoLoeschen);
    
    menuGeld .add(geldEinzahlen);
    menuGeld .add(geldAuszahlen);
    menuGeld .add(geldKredit);
        
    // ActionListeners fuer Eintraege hinzufuegen
    /**
     * Eintraege:
     * bankNeu + kundeNeu   +   // ok
     * kontoNeu + kontoLoeschen   +
     * geldAuszahlen + geldEinzahlen + geldKredit
     */
    dateiOeffnen.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        new DlgDateiOeffnen(listeDerBanken);
        setTableData();
      }
    });
    dateiSpeichern.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        new DlgDateiSpeichern(listeDerBanken);
      }
    });
    
    // TODO
//    testTabSize.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent e){
//        TableColumnModel mod = grid.getColumnModel();
//        System.out.println("Maﬂe der Spalten: ");
//        for (int i = 0; i < mod.getColumnCount(); i++)
//        {
//          System.out.println("Spalte " + i);
//          TableColumn col = mod.getColumn(i);            
//          System.out.println("Width: " + col.getWidth());
//        }
//      }
//    });
    
    
    bankOeffnen.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        DlgBankOeffnen bo = new DlgBankOeffnen(listeDerBanken);
        
        do
        { // muss hier erst warten bis Dialog geschlossen! sonst null
          selectedBank = bo.getSelectedBank();
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e1) {
            e1.printStackTrace();
          }
        } while (bo.getDialogResult().equals("keine Bank gewaehlt"));
        
        if (selectedBank != null)       // nur wenn Bank in Dialog gewaehlt wurde
        {
          System.out.println("gewaehlte Bank in Dialog: " + selectedBank.getBankName());
          setTableData();          
        }
        else
        {          
          System.err.println("selectedBank = null!  --> Abbruch durch Benutzer");
          return;
        }
      }      
    });
    bankNeu.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        new DlgNeueBank(listeDerBanken, null/*modelBank*/);    
      } 
    });
    kundeNeu.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        new DlgNeuerKunde(listeDerBanken, null/*modelKunde*/);  
      }
    });    
    kontoNeu.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        new DlgNeuesKontoDepot(listeDerBanken, null/*modelKonto*/);        
      }      
    });    
    kontoLoeschen.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        new DlgKontoLoeschen(listeDerBanken, null, null/*modelBank, modelKonto*/);        
      }
    });
    
    geldEinzahlen.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        new DlgGeldgeschaefte(listeDerBanken, true);
      }
    });    
    geldAuszahlen.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        new DlgGeldgeschaefte(listeDerBanken, false);
      }
    });
  
    // ++++++++++++++++++++++++++++++++++++++++++    
    menueleiste.add(menuDatei);             // Menuepunkte zu Leiste hinzufuegen
    menueleiste.add(menuBank);
    menueleiste.add(menuKunde);
    menueleiste.add(menuKonto);
    menueleiste.add(menuGeld);
    // ++++++++++++++++++++++++++++++++++++++++++
        
    this.frame.getContentPane().add(menueleiste);
    this.frame.setJMenuBar(menueleiste);    
  }
  

  
  public static void main(String[] args)
  {
    new GUIbankApp();    
  }
}
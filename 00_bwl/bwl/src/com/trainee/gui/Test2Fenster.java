package com.trainee.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ProgressMonitor;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
* Klasse fuer einfache Datenbankverbindung
* mit Tabellen (ID, Name) anlegen,
* Datensatz in Tabelle eintragen,
* alle Tabellen mit Datensaetzen anzeigen
*
* @author Steres14130
* 20.01. - 27.01.2010
*/
public class Test2Fenster {
  
  //Variablen
  Connection conn = null;
  JFrame frame;
  Container cont;
  String dbName;
  
  
  /**
  * Konstruktor legt eine Memory-Datenbank an
  * @param dbName
  */
  public Test2Fenster(String dbName)
  {
    this.dbName = dbName;
     
    try         // Datenbank Treiber laden   
    {
      Class.forName("org.hsqldb.jdbcDriver").newInstance();
//      String url = "jdbc:hsqldb:hsqldb\\mydb";      // alles nur im Zwischenspeicher
      String url = "jdbc:hsqldb:mem:c:\\bwl\\20_db\\hsqldb\\mydb";     // alles auf Platte speichern
      conn = DriverManager.getConnection(url, "sa", "");       // Connection mit DB+Zugangsdaten fuettern
      conn.setAutoCommit(true);
    }
    catch ( Exception e ) 
    { 
      System.err.println("DB-Treiber laden fehlgeschlagen!");
      e.printStackTrace();
      return; 
    } 
    
    // GUI machen
    frame = new JFrame("Datenbank " + dbName);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = frame.getContentPane();
    cont.setLayout(new FlowLayout());
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(screenSize);
    frame.setVisible(true);
  }
  
  
  String TabName;
  /**
   * legt eine neue Tabelle der Datenbank an
   * @param TabName gewuenschter Name der neuen Tabelle (ohne Leer- und Sonderzeichen!)
   */
  public void erzeugeTabelle (String TabName)
  {
    this.TabName = TabName;
    try
    {
      Statement st = null;
      st = conn.createStatement();    // statement anlegen und mit connection verbinden
      int i = 0;
      
      // Tabellen anlegen
      try
      {
        i = st.executeUpdate("CREATE TABLE " + TabName + " (ID int, Name varchar(30))");  
        pruefe(i);   
        System.out.println("\tTabelle " + TabName + " erzeugt");
      }catch (SQLException sqle)
      {
        System.err.println("Achtung! Tabelle besteht bereits und wird verwendet");
//        sqle.printStackTrace();
      }
      st.close();      
    }catch ( Exception e ) 
    { 
      e.printStackTrace();
      return; 
    }    
  }// Ende erzeugeTabelle ====================================================
  private void pruefe(int i)
  {
    if (i == -1) {   System.err.println("Datenbank Fehler! Kann Anweisung nicht ausfuehren");     }
  }
  
  
  /**
  * fuegt in die angegebene Tabelle die Daten ein
  * @param tabName - Name der Tabelle, welche die Daten enthalten soll
  * @param ID - ID des Datensatzes (selbst waehlbar)
  * @param name - Name (< 30 Zeichen)
  */
  public void erzeugeDatensatz (String tabName, int ID, String name)
  {
    try
    {
      Statement st = null;
      st = conn.createStatement();    // statement anlegen und mit connection verbinden
      int i = 0;
      
      // Inhalt einfuegen 
      System.out.println("Tabelle: " + tabName + "  Daten --> ID: " + ID + ", Name: " + name);
      
      if (name.length() > 30)
      {
        System.err.println("Fehler! Name darf nur weniger als 30 Zeichen betragen! Datensatz wird nicht uebernommen!");
      }
      else
      {
        // Daten in Tabelle einfuegen
        i = st.executeUpdate("INSERT INTO " + tabName + " VALUES (" + ID + ", '" + name + "')");
        pruefe(i); 
        System.out.println("\tDaten eingefuegt");
      }
        
      st.close();
    }catch( Exception e ) 
    { 
      System.err.println("Achtung! Datensatz bereits vorhanden!"); 
      e.printStackTrace();      
      return; 
    }    
  }// Ende erzeugeDatensatz ==================================================
  
  
  /**
  * Auflistung aller erzeugten Tabellen mit entsprechenden Datensaetzen
  */
  public void zeigeDatenbank()
  {            
    // Namen der angelegten Tabellen ermitteln + Anzahl Tabellen
    String[] allTabNames = null;    // alle Tabellennamen der Datenbank rausfinden     
    int anzTab = 0;        // Anzahl Tabellen benoetigt fuer Anzahl der Panels(Fenster) 
         
    try 
    {       
      DatabaseMetaData dbMetaData = conn.getMetaData();
      
      // Ermittelt Anzahl der Tabellen in der Datenbank
      ResultSet rs = dbMetaData.getTables(null, null, "%", new String[]{"TABLE"});            
      while (rs.next())
      {
        anzTab++;
      }
      allTabNames = new String[anzTab];
      anzTab = 0;
      
      // Ermittelt alle Tabellennamen in der Datenbank
      rs = dbMetaData.getTables(null, null, "%", new String[]{"TABLE"});          
      while (rs.next())
      {
        allTabNames[anzTab++] = rs.getString("TABLE_NAME");
      }
      
      // Kontrollausgabe
      System.out.println("\n--- (" + anzTab + ") Tabellen der Datenbank: ---");
      for (String s : allTabNames)
      {
        System.out.println(s);
      }
    
    } catch (SQLException e) {
      System.err.println("Achtung! Fehler im SQL Statement");
      e.printStackTrace();
    }
    
    
    // TEST Fortschrittsbalken
    ProgressMonitor progress = new ProgressMonitor(cont, "Tabellen werden geladen...", "", 0, anzTab);
    double prozent = 100 / anzTab;      // % pro Tabelle ermitteln
    
    for (int i = 0; i < anzTab; i++)        // einzelne Tabellen anzeigen
    {
      // Fortschrittsbalken      
      String message = String.format("Completed %d%%.\n", (int)((i+1) * prozent));
      progress.setNote(message);        // wird unter Tabellen laden angezeigt
      progress.setProgress(i+1);

//      try {  Thread.sleep(1000);  }catch(InterruptedException e) {e.printStackTrace();}   // fuer Testzwecke
      
      // Methode aufrufen zum Anlegen eines neuen Fensters
      System.out.println("\n\t*******************");    // Kontrollausgabe
      JPanel komplett = createTableWindow(i, allTabNames);    // GUI Fenster anzeigen         
      cont.add(komplett);      
    }
    try
    {
      // Datenbank speichert sich und schlieﬂt sich ordnungsgemaeﬂ bei Programmende
      Statement st = conn.createStatement();
      st.execute("SHUTDOWN");
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Fehler! Kann Connection nicht schlieﬂen!");
      e.printStackTrace();
    }
    
    frame.setContentPane(cont);  
  }// Ende zeigeDatenbank ====================================================
  
  
  /**
   * hier neuen Panel anlegen, Tabelle einfuegen, 
   * Spalten beschriften (DB Abfrage)
   * Daten einfuegen (DB Abfrage)
   * @param allTabNames - Namen aller Tabellen
   * @param tabCounter  - Position fuer allTabNames[]
   */
  @SuppressWarnings("serial")
  private JPanel createTableWindow(int tabCounter, String[] allTabNames)  
  {
    // benoetigt zum Erstellen neuer Tabellenfenster:
    // JFrame frame, Container cont  --> schon vorhanden
    JPanel komplett = new JPanel(new BorderLayout());             // Panel beinhaltet alle Tabellen-Panels
    komplett.setBackground(Color.yellow);       // wird angezeigt komplettes Fenster befuellt
    
    DefaultTableModel mod;
    JTable tab;   
    

    // Tabellenname zentriert ueber Tabelle anzeigen
    JPanel lblpanel = new JPanel();
    lblpanel.setBackground(Color.YELLOW);
    lblpanel.add(new JLabel(allTabNames[tabCounter]));  
    komplett.add(lblpanel, BorderLayout.NORTH);      
    
    try     // DB-Daten abfragen
    {
      Statement st = conn.createStatement();    // Statement anlegen und mit Connection verbinden
      
      // Anzahl der Datensaetze (Tabellen-Zeilen) ermitteln
      int row = 0;
      ResultSet rs = st.executeQuery("SELECT COUNT (ID) FROM " + allTabNames[tabCounter]);
      while (rs.next())
      { row = rs.getInt(1);    }      
      System.out.println("Tabelle " + allTabNames[tabCounter] + " hat   # " + row + " #   Datensaetze");      
      
      // Tabellen-Modell+Tabelle anlegen
      String[] colNames = {"ID", "Name"};       // Namen der Spalten
      mod = new DefaultTableModel(colNames, row)      // colNames + row-Anzahl Zeilen
      { 
        // Spalte ID nach Zahlen sortieren (sonst 1, 10, 2) normal: String-Sortierung
        @SuppressWarnings("unchecked")
        public Class getColumnClass(int column) {
          Class returnValue;
          if ((column >= 0) && (column < getColumnCount())) {
            returnValue = getValueAt(0, column).getClass();
          } else {
            returnValue = Object.class;
          }
          return returnValue;
        }
      };
      tab = new JTable(mod);
      
      // bei Doppelklick auf Zwischenraum linke Spalte Breite an Inhalt anpassen
      tab.getTableHeader().addMouseListener(new ColumnFitAdapter()); //CFA selbst geschrieben

      // TODO Scrollbalken fuer Inhalt > Anzeige hinzufuegen      
      mod.addTableModelListener(new TableModelListener()
      {  
        public void tableChanged(TableModelEvent e) {
          
          System.out.println("\n\t ###### Tabelle geaendert! ######");
          if (e.getColumn() == 0)       // Spalte ID geaendert
          {
            System.out.println("\tSpalte ID geaendert");
            // TODO hier Spalte ID anpassen
          }
          else if (e.getColumn() == 1)  // Spalte Name geaendert
          {
            System.out.println("\tSpalte name geaendert");
            // TODO hier Spalte Name anpassen
          }          
        }        
      });
      
      // Scroller wenn noetig hinzufuegen
      JScrollPane scroller = new JScrollPane(tab);
      scroller.setVerticalScrollBarPolicy  (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);  // ok
      scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);   // scrollt nicht
      scroller.setPreferredSize(new Dimension(200,180));        // ca 10 Datensaetze werden angezeigt
      scroller.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.YELLOW));
      
      // Tabellendaten ID, Name abfragen + speichern
      rs = st.executeQuery("SELECT DISTINCT x.ID, x.Name "+
                            "FROM " + allTabNames[tabCounter] + " x");  // x = Alias (geht in HSQL)      
      
      // Ergebnisse abfangen + in Tabellenmodel speichern
      row = 0;
      while ( rs.next() )           
      {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        
        mod.setValueAt(id,   row,  0);     // ID,   Zeile, Spalte
        mod.setValueAt(name, row,  1);     // Name, Zeile, Spalte
        
        // Laenge von ID und Name herausfinden (wegen horizontalem Scrollbalken)
//        if (name.length() )

        row++;
      }
      st.close();
      
      
      // Tabellenspalten sortierbar machen (nach Namen - String-Sortierung)
      TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();     // Daten des Models sortieren      
      tab.setRowSorter( sorter );       // Sorter muss JTable bekannt sein   
      sorter.setModel( mod );       // Sorter muss wissen, welche Daten er sortieren muss      
      
      
      // Spaltenweite ungefaehr an Inhalt anpassen      
      TableColumn colID = tab.getColumnModel().getColumn(0);
      colID.setPreferredWidth(5);      // bringt nichts, geht hier nicht kleiner als 15
      colID.setWidth(5);        // bringt nichts, setzt nur getwidth auch auf 15
      colID.setMinWidth(15);    // kann nicht kleiner gezogen werden als 15 Pixel (Breite von 1 Ziffer)
      
      TableColumn colName = tab.getColumnModel().getColumn(1);
      colName.setPreferredWidth(100);
      colName.setMinWidth(40);  // kann nicht kleiner gezogen werden als 40 Pixel (Breite von Ueberschrift)
      
      colID.setMaxWidth((int) scroller.getPreferredSize().getWidth());
      colName.setMaxWidth((int) scroller.getPreferredSize().getWidth());
      
      System.out.println("Preferred Width colID: " + colID.getPreferredWidth() + "\tcolName: " + colName.getPreferredWidth());
      System.out.println("          Width colID: " + colID.getWidth() + "\tcolName: " + colName.getWidth());
      System.out.println("Max/Min   Width colID: " + colID.getMaxWidth() + "/" + colID.getMinWidth() +
                                     "\tcolName: " + colName.getMaxWidth() + "/" + colName.getMinWidth());      
      
//      scroller.setViewportView(tab);      // bringt nichts
      komplett.add(scroller, BorderLayout.CENTER);      // kleines Fenster in groﬂes Fenster einfuegen
      
      return komplett;
    }catch( Exception e ) 
    { 
      e.printStackTrace();
      return null; 
    }    
    
  }// Ende createTableWindow ============================================================

  
  public static void main(String[] args) {      
    Test2Fenster test = new Test2Fenster("ST-Test");  
    test.erzeugeTabelle("meineTabelle");
    test.erzeugeDatensatz("meineTabelle", 0, "Karl-Heinz Schubert");
    test.erzeugeDatensatz("meineTabelle", 1, "Horst Schlemmer");
    test.erzeugeTabelle("TestTab");
    test.erzeugeDatensatz("TestTab", 0, "Maria Meier");
    test.erzeugeDatensatz("TestTab", 1, "Mona Lisa");
    test.erzeugeDatensatz("TestTab", 2, "Rosa Rudolf");
    
//    test.erzeugeTabelle("meineneueschoeneTesttabelle");
//    test.erzeugeDatensatz("meineneueschoeneTesttabelle", 0, "Maria Meier");
    
    test.erzeugeTabelle("bla1");
    test.erzeugeDatensatz("bla1", 0, "lllll");
    test.erzeugeDatensatz("bla1", 1, "pppzzzzzzzzzzzzzzzzzzzzzzzzppp");
    test.erzeugeDatensatz("bla1", 2, "fffff");
    test.erzeugeDatensatz("bla1", 3, "ggggg");
    test.erzeugeDatensatz("bla1", 4, "rrrr");
    test.erzeugeDatensatz("bla1", 5, "cc");
    test.erzeugeDatensatz("bla1", 6, "ffddfff");
    test.erzeugeDatensatz("bla1", 7, "uuuu");
    test.erzeugeDatensatz("bla1", 8, "wwwww");
    test.erzeugeDatensatz("bla1", 9, "ssss");
    test.erzeugeDatensatz("bla1", 10, "aaa");
    test.erzeugeDatensatz("bla1", 11, "ddrtedfg");
    
    test.erzeugeTabelle("bla2");
    test.erzeugeDatensatz("bla2", 0, "Maria Meier");
    test.erzeugeDatensatz("bla2", 1, "Hannelore Riedel-Faber");
    test.erzeugeDatensatz("bla2", 2, "Rosa Rudolf");
    test.erzeugeTabelle("bla3");
    test.erzeugeDatensatz("bla3", 0, "Maria Meier");
    test.erzeugeDatensatz("bla3", 1, "Mona Lisa");
    test.erzeugeDatensatz("bla3", 2, "Rosa Rudolf");
    test.erzeugeTabelle("bla4");
    test.erzeugeDatensatz("bla4", 0, "Maria Meier");
    test.erzeugeDatensatz("bla4", 1, "Mona Lisa");
    test.erzeugeDatensatz("bla4", 2, "Rosa Rudolf");
    test.zeigeDatenbank();
  }
}
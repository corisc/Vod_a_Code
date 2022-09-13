package com.ml.datenbank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.ml.utils.Helfer;
import com.ml.views.DatenReihe;
import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;


/**
* Klasse fuer einfache Datenbankverbindung
* mit Tabellen (ID, Name) anlegen,
* Datensatz in Tabelle eintragen,
* alle Tabellen mit Datensaetzen anzeigen
* mit GUI
*
* @author Steres14130
* 20.01. - 27.01.2010
*/
public class Datenbank {

  public static final String ID_KEINE_TABELLEN = "[keine]";
  
  //Variablen
  public Connection conn = null;
  JFrame frame;
  Container cont;
  
  
  /**
  * Konstruktor legt eine Memory-Datenbank an
  //* @param dbName
  */
  public Datenbank()
  {
    this.connect();    
  }
  
  // http://stackoverflow.com/questions/4319993/multiple-java-applications-accessing-one-hsqldb-causes-app-to-hang
  private void connect(){
    try         // Datenbank Treiber laden   
    {
      Helfer h = new Helfer();
      String arbeitsverzeichnis = h.aktuellesArbeitsverzeichnis();
      Class.forName("org.hsqldb.jdbcDriver").newInstance();
      String url = "jdbc:hsqldb:file:"+ arbeitsverzeichnis + "/20_db/hsqldb/mydb";
      //String url = "jdbc:hsqldb:file:C:\\bwl2\\20_db\\hsqldb\\mydb";
      System.out.println("url " + url);
      conn = DriverManager.getConnection(url, "sa", "");       // Connection mit DB+Zugangsdaten fuettern
      conn.setAutoCommit(true);
    }
    catch ( Exception e ) 
    { 
      System.err.println("DB-Treiber laden fehlgeschlagen!");
      e.printStackTrace();
      return; 
    }
    
    try
    {
      Statement st = null;
      st = conn.createStatement();    // statement anlegen und mit connection verbinden
      int i = 0;
      
    // Default Time setzen
    try
    {
      st.execute("SET WRITE_DELAY 0 MILLIS");
      pruefe(i);
      //System.out.println("\tDefaulttime angelegt");
    }catch (SQLException sqle)
    {
      System.err.println("Achtung! Defaulttime nicht angelegt");
      sqle.printStackTrace();
    }
    st.close();      
    }catch ( Exception e ) 
    { 
      e.printStackTrace();
      return; 
    }    
  }
  
  
  String TabName;
  /**
   * legt eine neue Tabelle der Datenbank an
   * @param TabName gewuenschter Name der neuen Tabelle (ohne Leer- und Sonderzeichen!)
   */
  public void erzeugeTabelle(String TabName)
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
        st.execute("SET WRITE_DELAY 0 MILLIS");
        st.execute("CREATE TABLE " + TabName + " (ID int, Name varchar(30))");
        st.execute("COMMIT");
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
  
  public void erzeugeReihe(String tabellenName, String reihenName)
  {
    try
    {
      Statement st = null;
      st = conn.createStatement();    // statement anlegen und mit connection verbinden
      int i = 0;
      
      // Daten in Tabelle einfuegen
      i = st.executeUpdate("ALTER TABLE " + tabellenName + " add " + reihenName + " char(50)");
      pruefe(i); 
      System.out.println("\tDaten eingefuegt");
        
      st.close();
    }catch( Exception e ) 
    { 
      System.err.println("Achtung! Reihe bereits vorhanden!"); 
      e.printStackTrace();      
      return; 
    }    
  }// Ende erzeugeDatensatz ==================================================

  public void loescheAlleTabellen()
  {
    try
    {
      Statement st = null;
      st = conn.createStatement();    // statement anlegen und mit connection verbinden
      int i = 0;
      
      for(String name : this.textAllerTabellenInDatenbank()){
        // Daten in Tabelle einfuegen
        i = st.executeUpdate("DROP TABLE " + name);
        pruefe(i); 
      }
      st.close();
    }
    catch( Exception e ) 
    { 
      System.err.println("Achtung! Tabelle loeschen nicht moelich"); 
      e.printStackTrace();      
      return;
    }    
  }// Ende erzeugeDatensatz ==================================================
  
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
  
  public void datenAblegen(String tabName, String ... daten)
  {
    String befehl = "INSERT INTO " + tabName + " VALUES (";
    try
    {
      String[] alle = this.textAllerTabellenInDatenbank();
      boolean found = false;
      for(String tabs : alle){
        if(tabs.toLowerCase().equalsIgnoreCase(tabName)){
          found = true;
        }
      }
      if(!found){
        System.out.println("Tabellenname " + tabName + " existiert nicht. Anlage nicht moeglich.");
        return;
      }

      if(daten == null || daten.length == 0){
        System.out.println("Keine Daten zum Ablegen. Anlage nicht moeglich.");
        return;        
      }
      
      for(int t=0;t<daten.length; t++){
        if(daten[t].length()<1){
          System.out.println("Ein Datensatz ist leer. Anlage nicht moeglich.");
          return;                  
        }
      }

      for(String tabs : daten){
        befehl = befehl + "'" + tabs.trim() + "',";
      }
      befehl = befehl.substring(0, befehl.length()-1);
      befehl = befehl + ");";
      this.verarbeiteSQLBefehl(befehl);
      
    }catch( Exception e ) 
    { 
      System.err.println("Fehler bei Datenablage: " + befehl); 
      e.printStackTrace();
      return; 
    }    
  }
  
  public String verarbeiteSQLBefehl(String befehl)
  {
    String result = "Ausfuehrung des Befehls: \n" + befehl + "\nwar fehlerhaft.\n";
    try
    {
      Statement st = null;
      st = conn.createStatement();    // statement anlegen und mit connection verbinden
      int i = 0;
      
      if(befehl.length() < 3)
      {
        result = result + "Befehl zu kurz";
        return result;
      }
      else
      {
        // Daten in Tabelle einfuegen
        i = st.executeUpdate(befehl.trim());
        if (i == -1){
          return result;    
        }
        result = "Ausfuehrung des Befehls: \n" + befehl + "\nerfolgreich.\n";
      }
      conn.commit();
      st.close();
    }catch( Exception e ) 
    { 
      e.printStackTrace();
      result = result + e.getMessage();
      return result;
    }
    return result;
  }// Ende erzeugeDatensatz ==================================================
  
  /**
   * Auflistung aller erzeugten Tabellen mit entsprechenden Datensaetzen
   */
   public String[] textAllerTabellenInDatenbank()
   {
     String[] allTabNames = null;     
     int anzTab = 0; 
          
     try {       
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
       
     } catch (SQLException e) {
       e.printStackTrace();
     }
     
     return allTabNames;
   }

   /**
    * Auflistung aller erzeugten Tabellen mit entsprechenden Datensaetzen
    */
    public Vector<ColumnDatum> textAllerReihen(String tabellenName)
    {
      String primaryKey = null;
      Vector<ColumnDatum> result = new Vector<ColumnDatum>();
      try{
        ResultSet rs;
        DatabaseMetaData dbMetaData = conn.getMetaData();
        rs = dbMetaData.getPrimaryKeys(null, null, tabellenName);
        while (rs.next())
        {
          primaryKey = rs.getString(4);
        }

        rs = dbMetaData.getColumns(null, null, tabellenName, null);
        ColumnDatum columnDatum;
        while (rs.next())
        {
          columnDatum = new ColumnDatum(rs.getString("COLUMN_NAME"), rs.getString("TYPE_NAME"), rs.getString("COLUMN_SIZE"), primaryKey);
          result.add(columnDatum);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      
      return result;
    }

    /**
  * Auflistung aller erzeugten Tabellen mit entsprechenden Datensaetzen
  */
  public void zeigeDatenbank()
  {
    if(this.frame != null){
      this.frame.dispose();
    }
    
    String[] alle = this.textAllerTabellenInDatenbank();
    if(alle == null){
      return;
    }
    if(alle.length <= 0){
      return;
    }
    
    try {
      this.conn.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    this.connect();
      
    frame = new JFrame("Datenbank");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    cont = frame.getContentPane();
    cont.setLayout(new FlowLayout());
    Dimension screenSize = new Dimension(800,600);
    frame.setSize(screenSize);
    frame.setLocation(200, 200);
    frame.setVisible(true);

    for(String name : alle){
      System.out.println(""+name);
      JPanel komplett = this.createTableWindow(name);
      cont.add(komplett);
      frame.setContentPane(cont);
    }
    //frame.pack();
  }
  
  
  /**
   * hier neuen Panel anlegen, Tabelle einfuegen, 
   * Spalten beschriften (DB Abfrage)
   * Daten einfuegen (DB Abfrage)
   //* @param allTabNames - Namen aller Tabellen
   //* @param tabCounter  - Position fuer allTabNames[]
   */
  @SuppressWarnings("serial")
  private JPanel createTableWindow(String tabellenName)
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
    lblpanel.add(new JLabel(tabellenName));  
    komplett.add(lblpanel, BorderLayout.NORTH);      
    
    try
    {
      int row = 0;
      int rowOfPrimary = 9999; 
      Vector<ColumnDatum> alleReihen = this.textAllerReihen(tabellenName);
      String[] colNames = new String[alleReihen.size()];
      for(ColumnDatum columnDatum : alleReihen){
        colNames[row] = columnDatum.getColumnName();
        if(columnDatum.getColumnName().equals(columnDatum.getPrimaryKey())){
          rowOfPrimary = row;
        }
        row++;
      }
      final int uRowOfPrimary = rowOfPrimary;
      DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer()
      {
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
  
          super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          // Font
          if(column == uRowOfPrimary){
            super.setForeground(Color.RED);
            super.setFont(new Font("Arial", Font.BOLD, 12));
          }
          return this;
        }
      };
      
      mod = new DefaultTableModel(colNames, 0)
      { 
        // Spalte ID nach Zahlen sortieren (sonst 1, 10, 2) normal: String-Sortierung
        @SuppressWarnings("unchecked")
        public Class getColumnClass(int column) {
          Class returnValue;
          returnValue = Object.class;
          return returnValue;
        }
      };
      
      tab = new JTable(mod);
      if(rowOfPrimary != 9999){
        tab.getColumnModel().getColumn(rowOfPrimary).setCellRenderer(defaultTableCellRenderer);
      }
            
      // Scroller wenn noetig hinzufuegen
      JScrollPane scroller = new JScrollPane(tab);
      scroller.setVerticalScrollBarPolicy  (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);  // ok
      //scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);   // scrollt nicht
      scroller.setPreferredSize(new Dimension(200,250));        // ca 10 Datensaetze werden angezeigt
      scroller.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.YELLOW));
      
      mod = this.saetze(tabellenName, alleReihen, mod);
      
      // Tabellenspalten sortierbar machen (nach Namen - String-Sortierung)
      TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();     // Daten des Models sortieren      
      tab.setRowSorter( sorter );       // Sorter muss JTable bekannt sein   
      sorter.setModel( mod );       // Sorter muss wissen, welche Daten er sortieren muss      
      
      
      // Spaltenweite ungefaehr an Inhalt anpassen      
      TableColumn colID = tab.getColumnModel().getColumn(0);
      colID.setMinWidth(15);    // kann nicht kleiner gezogen werden als 15 Pixel (Breite von 1 Ziffer)
      colID.setMaxWidth((int) scroller.getPreferredSize().getWidth());
      
      if(alleReihen.size()>2){
        TableColumn colName = tab.getColumnModel().getColumn(1);
        colName.setPreferredWidth(100);
        colName.setMinWidth(40);  // kann nicht kleiner gezogen werden als 40 Pixel (Breite von Ueberschrift)
        colName.setMaxWidth((int) scroller.getPreferredSize().getWidth());
      }
      
            
      komplett.add(scroller, BorderLayout.CENTER);      // kleines Fenster in groﬂes Fenster einfuegen
      return komplett;
    }catch( Exception e ) 
    { 
      e.printStackTrace();
      return null; 
    }    
    
  }
  
  private DefaultTableModel saetze(String tabellenName, Vector<ColumnDatum> alleReihen, DefaultTableModel defaultTableModel){
    
    try{
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM " + tabellenName);      
      
      int reiheZahl  = 1;
      int spalteZahl = 0;
      Object[] o = new Object[defaultTableModel.getColumnCount()];
      String inhalt = "";
      while (rs.next()) {
        for(ColumnDatum reihe : alleReihen){
          inhalt = rs.getString(reihe.getColumnName());
          o[spalteZahl] = inhalt;
          spalteZahl++;
        }
        defaultTableModel.addRow(o);
        reiheZahl++;
        spalteZahl = 0;
      }
      st.close();
    }
    catch (SQLException se) {
    se.printStackTrace();
    }
    
    return defaultTableModel;
  }

  public int[] abfragenDatensaetzeAlsInt(String tabellenName, String nameDerReihe){
    String result[] = this.abfragenDatensaetze(tabellenName, nameDerReihe);
    int konvert[] = new int[result.length];
    for(int t=0; t<result.length; t++){
      konvert[t] = 0;
      try{
        konvert[t] = Integer.parseInt(result[t]);
      }
      catch(Exception e){
        
      }
    }
    return konvert;
  }
  
  public String[] abfragenDatensaetze(String tabellenName, String nameDerReihe){
    String[] result = new String[0];
    Vector<String> prepareResult = new Vector<String>(11);
    try{
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM " + tabellenName);      

      String inhalt = null;
      while (rs.next()) {
        inhalt = rs.getString(nameDerReihe);
        if(inhalt == null){
          return result;
        }
        prepareResult.add(inhalt);
      }
      st.close();
    }
    catch (SQLException se) {
      se.printStackTrace();
      return result;
    }
    result = new String[prepareResult.size()];
    int t= 0;
    for(String res : prepareResult){
      result[t] = res;
      t++;
    }
    return result;
  }
  
  public DatenReihe abfrageDatenReihe(String tabellenName, String nameDerReihe){
    String[] erg;
    erg = this.abfragenDatensaetze(tabellenName, nameDerReihe);
    int size = erg.length;
    DatenReihe datenReihe = new DatenReihe();
    if(size > 0){
      for(String s : erg){
        datenReihe.hinzufuegen(s);
      }
    }
    return datenReihe;
  }
  
  public int zeileAbfragenInt(String tabellenName, String nameDerReihe, int zeile){
    int res = 0;
    String result = this.zeileAbfragen(tabellenName, nameDerReihe, zeile);
    try{
      res = Integer.parseInt(result);
    }
    catch(Exception e){
      System.out.println("keine Zahl auslesbar");
    }
    return res;
  }

  public double zeileAbfragenDouble(String tabellenName, String nameDerReihe, int zeile){
    double res = 0;
    String result = this.zeileAbfragen(tabellenName, nameDerReihe, zeile);
    try{
      res = Double.parseDouble(result);
    }
    catch(Exception e){
      System.out.println("keine Zahl auslesbar");
    }
    return res;
  }

  public String zeileAbfragen(String tabellenName, String nameDerReihe, int zeile){
    String result = "kein Ergebnis";
    try{
      DatenReihe resultat = this.abfrage(tabellenName, nameDerReihe);
      result = ""; 
      int size = resultat.liefereZahlDerEintraege();
      if(zeile < 0 || zeile >= size ){
        result = "Fehler: Die Reihe " + zeile + " gibt es nicht.";
      }
      else{
        result = result + resultat.holeStringAnStelle(zeile);
      }
        
    }
    catch(Exception e){
      result = "Fehler: " + e.getMessage();
    }

    return result;
  }

  public int anzahlDerZeilen(String tabellenName){
    int result = 0;
    try{
      String[] alleTabellen = this.textAllerTabellenInDatenbank();
      if(alleTabellen.length <=0){
        return 0;
      }
      Vector<ColumnDatum> alleReihen = this.textAllerReihen(alleTabellen[0]);
      if(alleReihen.size() <=0){
        System.out.println("Es gibt keine Tabellen in der Datenbank");
        return 0;
      }
      DatenReihe resultat = this.abfrage(alleTabellen[0].toLowerCase(), alleReihen.get(0).getColumnName());
      int size = resultat.liefereZahlDerEintraege();
      result = size;
    }
    catch(Exception e){
      System.out.println("Fehler: " + e.getMessage());
    }
    return result;
  }
  
  public DatenReihe abfrage(String tabellenName, String nameDerReihe){
    DatenReihe datenReihe = new DatenReihe();
    String[] result = new String[0];
    Vector<String> prepareResult = new Vector<String>(11);
    try{
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM " + tabellenName);      

      String inhalt = null;
      while (rs.next()) {
        inhalt = rs.getString(nameDerReihe);
        if(inhalt == null){
          return datenReihe;
        }
        prepareResult.add(inhalt);
      }
      st.close();
    }
    catch (SQLException se) {
      se.printStackTrace();
      return datenReihe;
    }
    result = new String[prepareResult.size()];
    int t= 0;
    for(String res : prepareResult){
      result[t] = res;
      datenReihe.hinzufuegen(result[t]);
      t++;
    }
    return datenReihe;
  }
 

  public String abfragen(String sqlAbfrage){
    String result = "";
    Statement  st = null;
    ResultSet  rs = null;

    Vector<String> prepareResult = new Vector<String>(11);
    try{
      st = this.conn.createStatement();
      rs = st.executeQuery( sqlAbfrage );
      ResultSetMetaData rsmd = rs.getMetaData();
      int i, n = rsmd.getColumnCount();
      // Print table content:
      for( i=0; i<n; i++ ){
        System.out.print( "+---------------" );
        result = result + "+---------------";
      }
      System.out.println( "+" );
      result = result + "+\n";
      for( i=1; i<=n; i++ ){    // Attention: first column with 1 instead of 0
        System.out.print( "| " + extendStringTo14( rsmd.getColumnName( i ) ) );
        result = result +  "| " + extendStringTo14( rsmd.getColumnName( i )) ;
      }
      System.out.println( "|" );
        result = result + "|\n";
      for( i=0; i<n; i++ ){
        System.out.print( "+---------------" );
        result = result + "+---------------";
      }
      System.out.println( "+" );
      result = result + "+\n";
      while( rs.next() ) {
        for( i=1; i<=n; i++ ){  // Attention: first column with 1 instead of 0
          System.out.print( "| " + extendStringTo14( rs.getString( i ) ) );
          result = result + "| " + extendStringTo14( rs.getString( i ) );
        }
        System.out.println( "|" );
        result = result + "|\n";
      }
      for( i=0; i<n; i++ ){
        System.out.print( "+---------------" );
        result = result + "+---------------";
      }
      System.out.println( "+" );
      result = result + "+\n";
    }
    catch (SQLException se) {
      se.printStackTrace();
      result = se.getMessage();
    }
    finally {
      try { if( null != rs ) rs.close(); } catch( Exception ex ) {}
      try { if( null != st ) st.close(); } catch( Exception ex ) {}
    }
    return result;
  }

  
  public String[][] abfrage(String sqlAbfrage){
    String[][] result = new String[100][100];
    Statement  st = null;
    ResultSet  rs = null;
    int currentLineNumber = 0;
    int i = 0;
    int n = 0;
    try{
      st = this.conn.createStatement();
      rs = st.executeQuery( sqlAbfrage );
      ResultSetMetaData rsmd = rs.getMetaData();
      i = rsmd.getColumnCount();
      n = rsmd.getColumnCount();
      while( rs.next() ) {
        for( i=1; i<=n; i++ ){  // Attention: first column with 1 instead of 0
          System.out.print(rs.getString( i )  );
          result[currentLineNumber][i] = rs.getString( i ) ;
        }
        currentLineNumber = currentLineNumber + 1;
      }
    }
    catch (SQLException se) {
      se.printStackTrace();
    }
    finally {
      try { if( null != rs ) rs.close(); } catch( Exception ex ) {}
      try { if( null != st ) st.close(); } catch( Exception ex ) {}
    }
    
    String groesseRichtigResult[][] = new String[n][currentLineNumber];
    System.out.println("currentLineNumber " + currentLineNumber );
    System.out.println("n " + n );
    
    for (int t = 0; t < n; t=t+1){
      for(int tt = 0; tt < currentLineNumber; tt=tt+1){
        groesseRichtigResult[t][tt] = result[t][tt];
        System.out.println(t + " " + tt + " -> " + groesseRichtigResult[t][tt]);
      }
    }
    int size = groesseRichtigResult.length;
    
    System.out.println("l"+ size);
    return groesseRichtigResult;
  }

  
  
  // Extend String to length of 14 characters
  private static final String extendStringTo14( String s )
  {
    if( null == s ) s = "";
    final String sFillStrWithWantLen = "              ";
    final int iWantLen = sFillStrWithWantLen.length();
    final int iActLen  = s.length();
    if( iActLen < iWantLen )
      return (s + sFillStrWithWantLen).substring( 0, iWantLen );
    if( iActLen > 2 * iWantLen )
      return s.substring( 0, 2 * iWantLen );
    return s;
  }
  
  public static void main(String args[]){
    Datenbank d = new Datenbank();
    d.abfrage("SELECT * FROM PERSON;");
    
  }

}


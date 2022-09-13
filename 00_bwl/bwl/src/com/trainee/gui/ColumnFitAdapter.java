package com.trainee.gui;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 * Bei Mausklick auf JTableHeader - Zwischenraum an Inhalt anpassen
 * Loesung von
 * http://www.jroller.com/santhosh/date/20050523#fit_tablecolumns_on_demand
 * 
 * @author Steres14130
 * 29.01.2010
 */
public class ColumnFitAdapter extends MouseAdapter{
  
  public void mouseClicked(MouseEvent e)
  { 
    if(e.getClickCount() == 2)      // bei Doppelklick
    {
      JTableHeader header = (JTableHeader)e.getSource();    // welche Spalte wurde gewaehlt
      TableColumn tableColumn = getResizingColumn(header, e.getPoint());
      
      if(tableColumn == null) { return;  }
      
      int col = header.getColumnModel().getColumnIndex(tableColumn.getIdentifier()); // Spalte genau bestimmen
      JTable table = header.getTable(); 
      int rowCount = table.getRowCount(); 

      int width = (int)header.getDefaultRenderer().getTableCellRendererComponent(
                      table, tableColumn.getIdentifier(), false, false, -1, col)
                      .getPreferredSize().getWidth();   // bevorzugte Spaltenbreite gewaehlter Spalte bekommen
      for(int row = 0; row < rowCount; row++)
      { // bevorzugte Spaltenbreite aller Spalten rauskriegen
        int preferedWidth = (int)table.getCellRenderer(row, col).getTableCellRendererComponent(
                                table, table.getValueAt(row, col), false, false, row, col)
                                .getPreferredSize().getWidth(); 
        width = Math.max(width, preferedWidth);     // bestimmt welcher Maximalwert ist
      } 
      header.setResizingColumn(tableColumn); // zu resizende Spalte setzen (wichtig!)
      tableColumn.setWidth(width+table.getIntercellSpacing().width); //Breite setzen,verbleibenden Platz mit addieren
    }
  }
  
  /**
   * findet gewaehlte Spalte raus, gibt diese an andere Methode weiter
   * @param header
   * @param p
   * @return TableColumn - aus aufgerufener Methode
   */
  private TableColumn getResizingColumn(JTableHeader header, Point p) {
    return getResizingColumn(header, p, header.columnAtPoint(p)); 
  }// copied from BasicTableHeader.MouseInputHandler.getResizingColumn 
  
  /**
   * 
   * @param header - Spaltenueberschriften der Tabelle
   * @param p      - geklickter Mauspunkt
   * @param column - Spalte auf die geklickt wurde
   * @return
   */
  private TableColumn getResizingColumn(JTableHeader header, Point p, int column) {
    if(column == -1) { return null;  }      // keine Spalte geklickt
    Rectangle r = header.getHeaderRect(column); 
    r.grow(-3, 0);      // 3 Pixel zwischen Spalten zum Mausklick fuer Resize vorsehen

    if(r.contains(p)) { return null;  }     // es wurde auf Spalte geklickt
    
    // es wurde auf Zwischenraum der Spalten geklickt
    int midPoint = r.x + r.width / 2;       // genaue Mitte der Spalte
    int columnIndex; 

    if(header.getComponentOrientation().isLeftToRight()) 
    { 
      columnIndex = (p.x < midPoint) ? column-1 : column; 
    }
    else {
      columnIndex = (p.x < midPoint) ? column : column-1;
    }

    if(columnIndex == -1) { return null;  }

    return header.getColumnModel().getColumn(columnIndex); 
  }// copied from BasicTableHeader.MouseInputHandler.getResizingColumn 
}


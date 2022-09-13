package com.trainee;

import java.awt.Component;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

public class BorderCellRenderer extends JLabel implements TableCellRenderer {
  protected Border noFocusBorder; 
  protected Border columnBorder; 
  
  public BorderCellRenderer() {
    noFocusBorder = new EmptyBorder(1, 2, 1, 2);
    setOpaque(true);
  }
  
  public Component getTableCellRendererComponent(JTable table, Object value,
               boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setFont(table.getFont());
    
    if (hasFocus) {
      setBorder( UIManager.getBorder("Table.focusCellHighlightBorder") );
      if (table.isCellEditable(row, column)) {
        setForeground( UIManager.getColor("Table.focusCellForeground") );
        setBackground( UIManager.getColor("Table.focusCellBackground") );
      }
    } else {
      if (value instanceof CellBorder) {
        Border border = ((CellBorder)value).getBorder();
        setBorder(border);
      } else {
        if (columnBorder != null) {
          setBorder(columnBorder);
        } else {
          setBorder(noFocusBorder);
        }
      }
    }
    setText((value == null) ? "" : value.toString());        
    return this;
  }
  
  public void setColumnBorder(Border border) {
    columnBorder = border;
  }
  
  public Border getColumnBorder() {
    return columnBorder;
  }

}



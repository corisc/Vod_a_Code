package com.trainee;

import javax.swing.border.Border;

public interface CellBorder {

  public Border getBorder();
  public Border getBorder(int row, int column);
  
  public void setBorder(Border border);
  public void setBorder(Border border, int row, int column);
}


package com.ml.datenbank;

public class ColumnDatum {
  
  private String columnName;
  private String typeName;
  private String columnSize;
  private String primaryKey;
  
  public ColumnDatum(String columnName, String typeName, String columnSize, String primaryKey) {
    super();
    this.columnName = columnName;
    this.typeName   = typeName;
    this.columnSize = columnSize;
    this.primaryKey = primaryKey;
  }

  public String getColumnName() {
    return columnName;
  }

  public String getTypeName() {
    return typeName;
  }

  public String getColumnSize() {
    return columnSize;
  }

  public String getPrimaryKey() {
    return primaryKey;
  }

}


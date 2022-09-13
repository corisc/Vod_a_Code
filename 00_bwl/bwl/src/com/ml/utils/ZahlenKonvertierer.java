package com.ml.utils;

import java.math.BigDecimal;

public class ZahlenKonvertierer {

  public ZahlenKonvertierer() {
  }
  
  public double rundeZweiStellen(double zahl){
    BigDecimal b = new BigDecimal(zahl);
    return  b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
  }
}


package com.ml.utils;

import java.math.BigDecimal;

public class GoldmanSachs {

  public GoldmanSachs() {
  }
  
  public double holeZertifikatWert(double daxKurs, double knockout){
    double wert = (daxKurs - knockout) * 0.01;
    BigDecimal myDec = new BigDecimal( wert );
    myDec = myDec.setScale( 5, BigDecimal.ROUND_HALF_UP );
    wert = myDec.doubleValue();
    return wert;
  }

}


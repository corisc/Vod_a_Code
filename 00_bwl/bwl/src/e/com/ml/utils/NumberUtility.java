package e.com.ml.utils;

import java.math.BigDecimal;

public class NumberUtility {

  public NumberUtility() {
  }
  
  public double roundDecimalPlacesTwo(double zahl){
    BigDecimal b = new BigDecimal(zahl);
    return  b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
  }
}


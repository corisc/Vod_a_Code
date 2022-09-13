package e.com.ml.views.copy;

public class CircleCalculator {
  
  public CircleCalculator() {
  }
  
  public double berechneSinus(double winkel){
    double sinWert = Math.sin(Math.PI*(winkel)/180);
    if(sinWert<0){
      sinWert = sinWert * (-1);
    }
    return sinWert;
  }

  public double berechneCosinus(double winkel){
    double sinWert = Math.sin(Math.PI*(winkel)/180);
    return sinWert;
  }
}


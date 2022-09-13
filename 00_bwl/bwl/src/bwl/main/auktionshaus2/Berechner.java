package bwl.main.auktionshaus2;

import com.ml.utils.MatheHelfer;
import com.ml.utils.ZahlenKonvertierer;

public class Berechner {
  
  public Berechner(){
  }
  
  public double streckeBerechnen(Punkt p1, Punkt p2){
    double ergebnis = 0;
    double a = p1.x - p2.x;
    double b = p1.y - p2.y;
    MatheHelfer matheHelfer = new MatheHelfer();
    a = matheHelfer.absoluterWert(a);
    b = matheHelfer.absoluterWert(b);
    double cquadrat = matheHelfer.zumQuadrat(a) + matheHelfer.zumQuadrat(b);
    ergebnis = matheHelfer.quadratwurzel(cquadrat);
    
    return ergebnis;
  }

  public double streckeBerechnen(double x1, double y1, double x2, double y2){
    double ergebnis = 0;
    double a = x1 - x2;
    double b = y1 - y2;
    MatheHelfer matheHelfer = new MatheHelfer();
    a = matheHelfer.absoluterWert(a);
    b = matheHelfer.absoluterWert(b);
    double cquadrat = matheHelfer.zumQuadrat(a) + matheHelfer.zumQuadrat(b);
    ergebnis = matheHelfer.quadratwurzel(cquadrat);
    ZahlenKonvertierer zahlenKonvertierer = new ZahlenKonvertierer();
    return zahlenKonvertierer.rundeZweiStellen(ergebnis);
  }
}


package vf.group.presentation;

import e.com.ml.views.copy.Paint;
import e.com.ml.views.copy.DrawWindow;

public class StartPolygon {

  public static void main(String[] args) {
    DrawWindow dw = new DrawWindow("VF");
        
    dw.drawPolygon(new Paint(255, 0, 0), 100, 100, 100, 500, 200, 500, 200, 100, 100, 100);
    dw.drawPolygon(new Paint(200,200,200), 100, 100, 300, 200, 400, 200, 200, 100, 100, 100);

  }

}


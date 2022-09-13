package bwl.main.winkel;

import com.framework.SQLFenster;
import com.framework.server.BasicServer;
import com.framework.server.ParameterServer;
import com.ml.connection.*;
import com.ml.utils.*;
import com.ml.views.*;
import com.ml.datenbank.*;

import bwl.oo.paket1.*;
import bwl.oo.paket2.*;
import bwl.oo.paket3.*;

public class Wuerfel {

  public static void main(String[] args) {

    // Hau rein

    ZeichenFenster w = new ZeichenFenster("Wuerfel in Drehung");
    boolean a = true;
    while (a = true) {
      // Streckungsfaktor:
      int k = 50;
      // Radius:
      double wr = 100;
      double r = 1.41 * wr; // kreisradius = wurzel(2)*wuerfelradius

      // Winkel:
      double winkel = 0;
      double winkelA = winkel + 45;
      double winkelB = winkel + 135;
      double winkelC = winkel + 225;
      double winkelD = winkel + 315;

      // Startpositionen:
      int uqm = 200; // = Mittelpunkt des unteren Quadrats

      // Positionen:
      double xA = 0;
      double yA = 0;
      double xB = 0;
      double yB = 0;
      double xC = 0;
      double yC = 0;
      double xD = 0;
      double yD = 0;

      // oberes Quadrat:

      double oyA = 0;
      double oyB = 0;
      double oyC = 0;
      double oyD = 0;

      for (winkel = 0; winkel <= 360; winkel++) {

        winkelA = Math.toRadians(winkel + 45);
        winkelB = Math.toRadians(winkel + 135);
        winkelC = Math.toRadians(winkel + 225);
        winkelD = Math.toRadians(winkel + 315);

        xA = uqm + r * Math.sin(winkelA);
        yA = uqm + (r - k) * Math.cos(winkelA);
        xB = uqm + r * Math.sin(winkelB);
        yB = uqm + (r - k) * Math.cos(winkelB);
        xC = uqm + r * Math.sin(winkelC);
        yC = uqm + (r - k) * Math.cos(winkelC);
        xD = uqm + r * Math.sin(winkelD);
        yD = uqm + (r - k) * Math.cos(winkelD);

        w.linieZeichnen(xA, yA, xB, yB, 4);
        w.linieZeichnen(xB, yB, xC, yC, 4);
        w.linieZeichnen(xC, yC, xD, yD, 4);
        w.linieZeichnen(xD, yD, xA, yA, 4);

        oyA = yA + r;
        oyB = yB + r;
        oyC = yC + r;
        oyD = yD + r;

        w.linieZeichnen(xA, oyA, xB, oyB, 4);
        w.linieZeichnen(xB, oyB, xC, oyC, 4);
        w.linieZeichnen(xC, oyC, xD, oyD, 4);
        w.linieZeichnen(xD, oyD, xA, oyA, 4);

        w.linieZeichnen(xA, yA, xA, oyA, 4);
        w.linieZeichnen(xB, yB, xB, oyB, 4);
        w.linieZeichnen(xC, yC, xC, oyC, 4);
        w.linieZeichnen(xD, yD, xD, oyD, 4);

        Trivials.warteMillis(50);
        w.loeschen();
      }
    }
  }
}

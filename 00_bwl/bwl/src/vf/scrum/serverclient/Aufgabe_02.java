package vf.scrum.serverclient;

import com.ml.views.Farbe;
import com.ml.views.SplashScreen;
import com.ml.views.ZeichenFenster;

public class Aufgabe_02 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    
    // Bild muss genau rienpassen 
    ZeichenFenster zf = new ZeichenFenster("Vodafone e-Shop");
    zf.textZeichnen("Vodafone e-Shop", 30, 700, 40, "rot");
    zf.linieZeichnen(30, 690, 340, 690, 4, "rot");
    zf.linieZeichnen(0, 650, 1000, 650, 2);


    
  }

}


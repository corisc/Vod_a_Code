package bwl;

import com.ml.views.*;

public class Programm1 {


  public static void main(String[] args) {
    //Hau rein
    ZeichenFenster zei = new ZeichenFenster("blaaaa");
    zei.linieZeichnen(300,100,300,500);
    zei.linieZeichnen(300,200,400,100);
    zei.kreisZeichnen(300,500,100);
    zei.linieZeichnen(100,100,500,100,5);
    zei.linieZeichnen(100,90,500,90,5,"rot");
    
  }
}




package com.ml.utils;

import java.util.Comparator;


public class SortierungKurs implements Comparator<Kurs>{
  // -1 = a1 gewinnt 1= a2 gewinnt
  public int compare(Kurs a1, Kurs a2) {
    if(a1.getUnixZeit() > a2.getUnixZeit()){
      return 1;
    }
    else{
      return -1;
    }
  }

}


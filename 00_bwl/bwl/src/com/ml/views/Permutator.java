package com.ml.views;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import bwl.main.auktionshaus2.Punkt;


// die permutaions funktionen Klasse 
public class Permutator {
  private LinkedList<Object> result = new LinkedList<Object>();

  public static Object[] permut(int[] val) {
    Object[] obj = Permutator.permutate(val,
        ArrayConverterHelper.createIntegerArrayConverter());
    // for(Object o : obj){
    // int[] all = (int[])o;
    // for(int i : all){
    // System.out.print(" " + i);
    // }
    // System.out.println("");
    // }
    return obj;
  }

  private static int permutationVorgangsnummer = 0;

  private static Vector<DatenReihe> ursprungsDatenreihen = new Vector<DatenReihe>();

  public DatenReihe permutiere(int permutation, double... punkte) {
    if (punkte == null || punkte.length == 0) {
      System.exit(1);
      System.out.println("Es wurden keine Punkte angegeben");
    }
    if (punkte.length % 2 != 0) {
      System.exit(1);
      System.out.println("Die Anzahl der Punkte muss gerade sein !!");
    }
    DatenReihe origin = new DatenReihe();
    DatenReihe result = new DatenReihe();
    for (int t = 0; t < punkte.length; t = t + 2) {
      Punkt p = new Punkt(punkte[t], punkte[t + 1], "");
      origin.hinzufuegen(p);
    }
    DatenReihe datenreihen = this.punktePermutieren(origin);
    if (permutation > datenreihen.liefereZahlDerEintraege()) {
      System.exit(1);
      System.out.println("Es wurde Permutation Nummer: " + permutation
          + " gesucht es gibt aber nur maximal "
          + datenreihen.liefereZahlDerEintraege() + " Permutationen");
    }
    DatenReihe ent = datenreihen.holeDatenReiheAnStelle(permutation);
    // for(int a=0;a<4;a++){
    // System.out.print(""+ent.holePunktAnStelle(a).x + " ");
    // }
    for (int tt = 0; tt < punkte.length / 2; tt = tt + 1) {
      result.hinzufuegen(ent.holePunktAnStelle(tt).x);
      result.hinzufuegen(ent.holePunktAnStelle(tt).y);
    }
    // for(int a=0;a<8;a++){
    // System.out.print(""+result.holeIntAnStelle(a) + " ");
    // }
    return result;
  }

  public String zeigeAllePermutationen(String... punkte) {
    String antwort = "";
    DecimalFormat df = new DecimalFormat("##000");
    if (punkte == null || punkte.length == 0) {
      System.exit(1);
      System.out.println("Es wurden keine Punkte angegeben");
    }
    DatenReihe origin = new DatenReihe();
    for (int t = 0; t < punkte.length; t = t + 1) {
      origin.hinzufuegen(new Punkt(0, 0, punkte[t]));
    }
    DatenReihe datenreihen = this.punktePermutieren(origin);
    for (int t = 0; t < datenreihen.liefereZahlDerEintraege(); t++) {
      antwort = antwort + (df.format(t) + ": ");
      for (int tt = 0; tt < punkte.length; tt++) {
        antwort = antwort
            + (datenreihen.holeDatenReiheAnStelle(t).holePunktAnStelle(tt).name + " ");
      }
      antwort = antwort + ("\n");
    }
    return antwort;
  }

  public DatenReihe punktePermutieren(DatenReihe datenReihe) {
    DatenReihe result = new DatenReihe();
    if (datenReihe == null) {
      return result;
    }
    if (datenReihe.liefereZahlDerEintraege() < 1) {
      return result;
    }
    if (!(datenReihe.holeObjektAnStelle(0) instanceof Punkt)) {
      return result;
    }
    int anzahl = datenReihe.liefereZahlDerEintraege();
    int[] val = new int[anzahl];
    for (int t = 0; t < anzahl; t++) {
      val[t] = t;
    }
    Object[] o = permut(val);
    for (int t = 0; t < o.length; t++) {
      DatenReihe neue = new DatenReihe();
      int[] all = (int[]) o[t];
      for (int tt = 0; tt < anzahl; tt++) {
        neue.hinzufuegen(datenReihe.holePunktAnStelle(all[tt]));
      }
      result.hinzufuegen(neue);
    }
    // for(int t=0;t<result.liefereZahlDerEintraege();t++){
    // DatenReihe datenReihe2 = result.holeDatenReiheAnStelle(t);
    // for(int tt=0;tt<datenReihe2.liefereZahlDerEintraege(); tt++){
    // System.out.print(datenReihe2.holePunktAnStelle(tt).x);
    // }
    // System.out.println();
    // }

    return result;
  }

  public DatenReihe inhaltPermutieren(DatenReihe datenReihe) {
    if (ursprungsDatenreihen.size() == 0) {
      ursprungsDatenreihen.add(datenReihe);
    }
    DatenReihe result = new DatenReihe();
    if (datenReihe == null) {
      return result;
    }
    if (datenReihe.liefereZahlDerEintraege() < 1) {
      return result;
    }
    int anzahl = datenReihe.liefereZahlDerEintraege();
    int[] val = new int[anzahl];
    for (int t = 0; t < anzahl; t++) {
      val[t] = t;
    }
    Object[] o = permut(val);
    for (int t = 0; t < o.length; t++) {
      if (t == permutationVorgangsnummer) {
        DatenReihe neue = new DatenReihe();
        int[] all = (int[]) o[t];
        for (int tt = 0; tt < anzahl; tt++) {
          if (ursprungsDatenreihen.firstElement().holeObjektAnStelle(0) instanceof String) {
            neue.hinzufuegen(ursprungsDatenreihen.firstElement()
                .holeStringAnStelle(all[tt]));
          }
        }
        permutationVorgangsnummer++;
        return neue;
      }
      // for(int t=0;t<result.liefereZahlDerEintraege();t++){
      // DatenReihe datenReihe2 = result.holeDatenReiheAnStelle(t);
      // for(int tt=0;tt<datenReihe2.liefereZahlDerEintraege(); tt++){
      // System.out.print(datenReihe2.holePunktAnStelle(tt).x);
      // }
      // System.out.println();
      // }
    }
    System.out.println("Es sind keine Permutationen mehr uebrig");
    return null;
  }

  public DatenReihe permutiereStrings(DatenReihe d) {
    int size = d.liefereZahlDerEintraege();
    java.util.List<Object> arr = new Vector<Object>();
    for (int t = 0; t < size; t++) {
      arr.add(d.holeStringAnStelle(t));
    }
    this.result = new LinkedList<Object>();
    permutierenObject(arr, 0);
    size = this.result.size();
    DatenReihe ergebnis = new DatenReihe();
    for (int t = 0; t < size; t++) {
      ergebnis.hinzufuegen(this.result.get(t));
    }
    return ergebnis;
  }

  public DatenReihe permutiereDouble(DatenReihe d) {
    int size = d.liefereZahlDerEintraege();
    java.util.List<Object> arr = new Vector<Object>();
    for (int t = 0; t < size; t++) {
      arr.add(d.holeDoubleAnStelle(t));
    }
    this.result = new LinkedList<Object>();
    permutierenDouble(arr, 0);
    size = this.result.size();
    DatenReihe ergebnis = new DatenReihe();
    for (int t = 0; t < size; t++) {
      ergebnis.hinzufuegen(this.result.get(t));
    }
    return ergebnis;
  }

  public static int factorial(int n) {
    int fact = 1; // this  will be the result
    for (int i = 1; i <= n; i++) {
        fact *= i;
    }
    return fact;
}
  
  private void permutierenObject(java.util.List<Object> arr, int k) {
    for (int i = k; i < arr.size(); i++) {
      java.util.Collections.swap(arr, i, k);
      permutierenObject(arr, k + 1);
      java.util.Collections.swap(arr, k, i);
    }
    if (k == arr.size() - 1) {
      //System.out.println(java.util.Arrays.toString(arr.toArray()));
      DatenReihe dr = new DatenReihe();
      for(Object o : arr.toArray()){
        dr.hinzufuegen((String)o);
      }
      this.result.add(dr);
    }
  }

  private void permutierenDouble(java.util.List<Object> arr, int k) {
    for (int i = k; i < arr.size(); i++) {
      java.util.Collections.swap(arr, i, k);
      permutierenDouble(arr, k + 1);
      java.util.Collections.swap(arr, k, i);
    }
    if (k == arr.size() - 1) {
      //System.out.println(java.util.Arrays.toString(arr.toArray()));
      DatenReihe dr = new DatenReihe();
      for(Object o : arr.toArray()){
        dr.hinzufuegen(((Double)o).doubleValue());
      }
      this.result.add(dr);
    }
  }

  /*
   * hier wird das ganze array p von start bis n-1 um eine stelle nach links
   * verschoben. dabei wird erstmal das startelement ge- speichert, und dann
   * wieder ganz hinten in das array eingefuegt!
   */
  private static void push(int i_startIdx, Object[] io_objects) {
    Object temp = io_objects[i_startIdx - 1];
    for (int i = i_startIdx - 1; i < io_objects.length - 1; i++) {
      io_objects[i] = io_objects[i + 1];
    }
    io_objects[io_objects.length - 1] = temp;
  }

  /**
   * This method creates a flat copy of the array
   * 
   * @param i_objs
   * @return
   */
  private static Object[] copy(Object[] i_objs) {
    Object[] objs = new Object[i_objs.length];
    System.arraycopy(i_objs, 0, objs, 0, objs.length);
    return objs;
  }

  /*
   * dies ist die eigentliche permutations-fnkt Alle elemente werden genau so
   * oft verschoben bis alle kombinationen abgearbeitet wurden! vom aktuellen
   * element weg werden dann alle nachfolgenden Elemente weiterpermutiert. am
   * schluss sieht die zahl dann wieder genau gleich aus, und muss daher nicht
   * mehr ange- zeigt werden!
   */
  private static void permu(int i_index, Object[] io_objects, ArrayList o_set) {
    for (int i = i_index; i <= io_objects.length; i++) {
      permu(i_index + 1, io_objects, o_set);
      push(i_index, io_objects);
      if (i != io_objects.length) {
        o_set.add(copy(io_objects));
      }
    }
  }

  private static ArrayList permutate(Object[] i_objects) {
    ArrayList set = new ArrayList();
    set.add(copy(i_objects));
    permu(1, copy(i_objects), set);
    return set;
  }

  public static Object[] permutate(Object i_object,
      ArrayConverter i_arrayConverter) {
    Object[] array = i_arrayConverter.toArray(i_object);
    ArrayList set = permutate(array);
    Object[] objs = new Object[set.size()];
    for (int i = 0; i < objs.length; ++i) {
      Object[] a = (Object[]) set.get(i);
      objs[i] = i_arrayConverter.toObject(a);
    }
    return objs;
  }
}

package bwl.oo.paket5;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public abstract class OneMany<T extends One, S extends Many> {

  private ArrayList<T> vieleOnes = new ArrayList<T>();

  protected String oneName1;

  protected String oneName2;

  protected String oneName3;

  protected String oneName4;

  protected int oneNumber1;

  protected int oneNumber2;

  protected int oneNumber3;

  protected int oneNumber4;

  protected OneMany(String oneName1) {
    this.oneName1 = oneName1;
  }

  protected OneMany(String oneName1, String oneName2) {
    this.oneName1 = oneName1;
    this.oneName2 = oneName2;
  }

  protected OneMany(int oneIndex, String oneName1, String oneName2) {
    this.oneNumber1 = oneIndex;
    this.oneName1 = oneName1;
    this.oneName2 = oneName2;
  }

  public T holeOne(int sucheOneNumber1) {
    if (sucheOneNumber1 < 1) {
      System.out.println("Es wurde bei der Suche in " + this.getGenericName()
          + " eine Nummer kleiner 1 gesucht");
      return null;
    }
    for (T t : this.vieleOnes) {
      if (t.oneNumber1 == sucheOneNumber1) {
        return t;
      }
    }
    System.out.println("Es wurde bei der Suche in " + this.getGenericName()
        + " keine Nummer " + sucheOneNumber1 + " gefunden");
    return null;
  }

  public T holeOne1(String oneName1Suche) {
    if (oneName1Suche == null || oneName1Suche.length() < 1) {
      System.out.println("Es wurde bei der Suche in " + this.getGenericName()
          + " nichts angegeben");
      return null;
    }

    for (T t : this.vieleOnes) {
      if (t.oneName1.equalsIgnoreCase(oneName1Suche)) {
        return t;
      }
    }

    System.out.println("Bei der Suche in " + this.getGenericName()
        + " wurde ein Eintrag mit dem Namen: " + oneName1Suche
        + " nicht gefunden");
    return null;
  }

  public T holeOne2(String oneName2Suche) {
    if (oneName2Suche == null || oneName2Suche.length() < 1) {
      System.out.println("Es wurde bei der Suche in " + this.getGenericName()
          + " nichts angegeben");
      return null;
    }

    for (T t : this.vieleOnes) {
      if (t.oneName2.equalsIgnoreCase(oneName2Suche)) {
        return t;
      }
    }

    System.out.println("Bei der Suche in " + this.getGenericName()
        + " wurde ein Eintrag mit dem Namen: " + oneName2Suche
        + " nicht gefunden");
    return null;
  }

  public T holeOne(String oneName1Suche, String oneName2Suche) {
    if (oneName1Suche == null || oneName1Suche.length() < 1) {
      System.out.println("Es wurde bei der Suche in " + this.getGenericName()
          + " nichts angegeben");
      return null;
    }

    if (oneName2Suche == null || oneName2Suche.length() < 1) {
      System.out.println("Es wurde bei der Suche in " + this.getGenericName()
          + " nichts angegeben");
      return null;
    }

    for (T t : this.vieleOnes) {
      if (t.oneName2.equalsIgnoreCase(oneName2Suche)
          && t.oneName1.equalsIgnoreCase(oneName1Suche)) {
        return t;
      }
    }

    System.out.println("Bei der Suche in " + this.getGenericName()
        + " wurde ein Eintrag mit dem Namen: " + oneName2Suche
        + " nicht gefunden");
    return null;
  }

  public void oneHinzufuegen(T t) {
    this.vieleOnes.add(t);
  }

  @SuppressWarnings("unchecked")
  protected String getGenericName() {
    return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0]).getCanonicalName();
  }

}

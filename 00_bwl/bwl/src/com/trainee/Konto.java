package com.trainee;

import java.io.Serializable;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Konto implements Serializable{

  // Variablen
  private String kontoArt;      // Array mit vorgegebenen Kontoarten?
  private long   kontoNr;         // long ~19 Stellen
  private double kontostand;
  
  private double kreditGesBetrag;
  private double kreditRestBetrag;
  private double kreditTeiltilgung;
  private String kreditVerwendung;
  private int    kreditLaufzeit;
  private int    kreditRestLaufzeit;
  
  // Konstruktor
  public Konto (String kontoArt, long kontoNr)
  {
    this.kontoArt   = kontoArt;
    this.kontostand = 0.0;
    this.kontoNr    = kontoNr;
    
    this.kreditGesBetrag    = 0.0;
    this.kreditRestBetrag   = 0.0;
    this.kreditTeiltilgung  = 0.0;
    this.kreditVerwendung   = " ";
    this.kreditLaufzeit     = 0;
    this.kreditRestLaufzeit = 0;
//    kontrollausgabe();   
  }// Ende Konstruktor
  
  
  // ~~~~~~~ Methoden ~~~~~~~~
  public void kontrollausgabe()
  {
    System.out.println("");
  }
  
  // Geld abheben / einzahlen
  public void geldAbheben(double betrag)
  {    
    double temp = kontostand - betrag;    
    if (temp >= 0.0)    // genuegend Geld auf Konto
    {
      kontostand = temp;
      System.out.println("Abgehobener Betrag: " + betrag);
    }
    else if (temp < 0.0)    // NICHT genuegend Geld auf Konto
    {
      System.out.println("Betrag konnte nicht abgehoben werden, zu wenig Geld verfuegbar!");
      JOptionPane.showMessageDialog(null, "Achtung! zu wenig Geld vorhanden!");

      System.out.println("Beantragen Sie doch eine Kontoueberziehung");
    }
    System.out.println("Kontostand: " + kontostand);    // Falsche Wertausgabe
  }
  public void geldEinzahlen(double betrag)
  {
    kontostand += betrag;    
    System.out.println("Eingezahlter Betrag: " + betrag);
    System.out.println("Kontostand: " + kontostand);
  }
  
  // Kredite
  public void kreditBeantragen(double kreditGesBetrag, String kreditVerwendung, 
                               double kreditTeiltilgung, int kreditLaufzeit)
  {
    this.kreditGesBetrag    = kreditGesBetrag;
    this.kreditVerwendung   = kreditVerwendung;
    this.kreditTeiltilgung  = kreditTeiltilgung;
    this.kreditLaufzeit     = kreditLaufzeit;
    this.kreditRestLaufzeit = kreditLaufzeit;
    this.kreditRestBetrag   = kreditGesBetrag;
    
    System.out.println("Kredit in Hoehe von\t" + kreditGesBetrag + 
                       " Euro fuer \"" + kreditVerwendung + "\" wurde beantragt.");
    System.out.println("Die monatliche Teiltilgung wurde auf " + kreditTeiltilgung + 
                       " Euro festgesetzt");
    System.out.println("Laufzeit: " + kreditLaufzeit + " Monate");
  }
  
  public void kreditTeiltilgung()
  {
    double temp = kreditRestBetrag - kreditTeiltilgung;    
    if (temp > 0.0)
    {
      kreditRestBetrag = temp;
      kreditRestLaufzeit--;
    }
    else if (temp == 0.0)
    {
      kreditRestBetrag = temp;
      System.out.println("Sie haben Ihren Kredit komplett getilgt. Vielen Dank fuer Ihr Vertrauen");
      System.out.println("Sie haetten noch " + kreditRestLaufzeit + " Monate Zeit gehabt.");
    }
    else
    {
      System.out.println("Restbetrag zu klein fuer Ihre Teiltilgung. Bitte leisten Sie eine Einmalzahlung von");
      System.out.println(temp + " Euro");
    }
    System.out.println("Restbetrag: " + kreditRestBetrag + "\tRestlaufzeit: " + kreditRestLaufzeit);
  }
  
  public void kreditEinmalZuzahlung(double betrag)
  {
    double temp = kreditRestBetrag - betrag;    
    if (temp > 0.0)         // immer noch im Minus
    {
      kreditRestBetrag = temp;
      System.out.println("Restbetrag: " + kreditRestBetrag + "\tRestlaufzeit: " + kreditRestLaufzeit);
    }
    else if (temp == 0.0)    // Kredit abbezahlt
    {
      kreditRestBetrag   = temp;
      kreditRestLaufzeit = 0;
      System.out.println("Sie haben Ihren Kredit komplett getilgt. Vielen Dank");
    }
    else if (temp < 0.0)
    {
      temp -= kreditRestBetrag;
      kreditRestBetrag   = 0;
      kreditRestLaufzeit = 0;
      System.out.println("Sie haben Ihren Kredit komplett getilgt.");
      System.out.println("Moechten Sie den Ueberschuss von " + temp + " Euro anlegen oder spenden?");
    }
  }

  // ~~~~~~~~ Setter+Getter ~~~~~~~~
  public long getKontoNr() {
    return kontoNr;
  }  
  public double getKontostand() {
    return this.kontostand;
  }
  public double getKreditGesBetrag() {
    return kreditGesBetrag;
  }
  public double getKreditRestBetrag() {
    return kreditRestBetrag;
  }
  public void setKontoNr(long kontoNr) {
    this.kontoNr = kontoNr;
  }
  public String getKontoArt() {
    return kontoArt;
  }
  public void setKontoArt(String kontoArt) {
    this.kontoArt = kontoArt;
  }
  public void setKontostand(double kontostand) {
    this.kontostand = kontostand;
  }
  public double getKreditTeiltilgung() {
    return kreditTeiltilgung;
  }
  public void setKreditTeiltilgung(double kreditTeiltilgung) {
    this.kreditTeiltilgung = kreditTeiltilgung;
  }
  public String getKreditVerwendung() {
    return kreditVerwendung;
  }
  public void setKreditVerwendung(String kreditVerwendung) {
    this.kreditVerwendung = kreditVerwendung;
  }
  public int getKreditLaufzeit() {
    return kreditLaufzeit;
  }
  public void setKreditLaufzeit(int kreditLaufzeit) {
    this.kreditLaufzeit = kreditLaufzeit;
  }
  public int getKreditRestLaufzeit() {
    return kreditRestLaufzeit;
  }
  public void setKreditRestLaufzeit(int kreditRestLaufzeit) {
    this.kreditRestLaufzeit = kreditRestLaufzeit;
  }
  public void setKreditGesBetrag(double kreditGesBetrag) {
    this.kreditGesBetrag = kreditGesBetrag;
  }
  public void setKreditRestBetrag(double kreditRestBetrag) {
    this.kreditRestBetrag = kreditRestBetrag;
  }  
}
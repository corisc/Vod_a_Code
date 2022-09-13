package com.trainee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Kunde implements Serializable{

  private String vName;
  private String nName;
  private int kundenNr = 1000;
  
  private List<Konto> kontenDesKunden = new ArrayList<Konto>();      // Kontenliste des Kunden
//  private List<Depot> depotsDesKunden = new ArrayList<Depot>();      // Liste der Depots/Wertpapiere
  
  
  public Kunde (String vName, String nName, int kundenNr)    // Konstruktor
  {
    this.vName = vName;
    this.nName = nName;
    this.kundenNr = kundenNr;
    
    kontrollausgabe();   
  }// Ende Konstruktor
  
  // ~~~~~~~ Methoden ~~~~~~~
  public void kontrollausgabe()     // bisschen formatiert ausgeben fuer leichtere Lesbarkeit
  {
    System.out.println("--------------------- Kontollausgabe Kunde ----------------");
    System.out.print("Kunde \"" +vName+ " " +nName+ "\"");
    System.out.print(" " +kundenNr+ " hat derzeit ");
    double kontostandGesamt = 0.0;
    for(Konto konto : kontenDesKunden)
    {
      kontostandGesamt += konto.getKontostand();
    }
    String s = String.format("%.2f", kontostandGesamt);
    System.out.println(s+ " Euro auf seinen Konten");
    System.out.println("-----------------------------------------------------------");    
  }
  public void nameAendern(String vNameNeu, String nNameNeu)     // vName + nName aendern
  {
    this.vName = vNameNeu;
    this.nName = nNameNeu;    
    System.out.println("Kundenname geaendert auf\t" +vName+ " " +nName);
  }
  public void addKonto(Konto konto)
  {
    this.kontenDesKunden.add(konto);
  }
  public void kontoAufloesen(int index)   // 1 Konto loeschen
  {
    this.kontenDesKunden.remove(index);
  }
  
  
  public void neuesKontoHinzufuegen(Konto neuesKonto)
  {
    this.kontenDesKunden.add(neuesKonto);
  }
  
  // ~~~~~~~~~~~ Setter+Getter ~~~~~~~~~~~
  public void setKonten(List<Konto> konten) {
    this.kontenDesKunden = konten;
  }
  public String getVName() {
    return vName;
  }
  public String getNName() {
    return nName;
  }
  public void setNName(String name) {
    nName = name;
  }
  public int getKundenNr() {
    return kundenNr;
  }  
  public void setKundenNr(int kundenNr) {
    this.kundenNr = kundenNr;
  }
  public void setVName(String name) {
    vName = name;
  }
  public List<Konto> getKonten() {
    return kontenDesKunden;
  }  
  
  
  public boolean kontoLoeschen (Konto konto)
  {    
    if (this.getKonten().contains(konto))
    {
      this.getKonten().remove(konto);
      return true;
    }    
    return false;
  }
  
}
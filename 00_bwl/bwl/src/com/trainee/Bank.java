package com.trainee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Bank implements Serializable{

  // Variablen
  private String bankName;
  private double gesKredite;
  private double gesGuthaben;
  private String blz;
  private boolean kreditBewilligt;
  
  private List<Kunde> kundenDerBank = new ArrayList<Kunde>();
//  private List<Konto> kontenDerBank = new ArrayList<Konto>();
  
  public Bank (String bankName, String blz)     // Konstruktor
  {
    this.bankName = bankName;
    this.blz = blz;
    this.gesKredite = 0.0;
    this.gesGuthaben = 0.0;    
    kontrollausgabe();    
  }// Ende Konstruktor
  
  
  // Methoden
  public void kontrollausgabe()
  {
    System.out.println("\n------------------- Bankdaten ------------------");
    System.out.println(bankName + " (" + blz + ")\tverfuegt derzeit ueber ein Gesamtguthaben von ");
    String s = String.format("%.2f", gesGuthaben);
    System.out.println(s + " Euro");
    System.out.println("und der Gesamtbetrag der vergebenen Kredite entspricht ");
    s = String.format("%.2f", gesKredite);   
    System.out.println(s + " Euro"); 
    System.out.println("Kunden der Bank: ");
    for (Kunde kunde : kundenDerBank)
    {
      System.out.println("   " + kunde.getVName() + " " + kunde.getNName() + "  -->  " + kunde.getKundenNr());
    }
  }
  
  public boolean kreditBeantragen(double kreditGesBetrag)
  {
    double temp = gesGuthaben - kreditGesBetrag;
    kreditBewilligt = false;
    
    if (temp > 0.0)
    {
      System.out.println("Antrag auf Kredit stattgegeben");
      kreditBewilligt = true;
    }
    else
    {
      System.out.println("Antrag auf Kredit NICHT stattgegeben");
      System.out.println("Versuchen Sie es doch zu einem spaeteren Zeitpunkt erneut");
    }
    return kreditBewilligt;
  }

  public void neuenKundenHinzufuegen(Kunde neuerKunde) {
    this.kundenDerBank.add(neuerKunde);
  }
  
  public void berechneGesamtguthaben()
  {
    System.out.println("");
    System.out.println("------------ Berechne Gesamtguthaben -------------------------");
    
    double gesamtguthaben = 0;
    
    for(Kunde kunde : kundenDerBank)
    {
      System.out.println("Kunde: " + kunde.getVName());      
      List<Konto> kontenDesKunden = kunde.getKonten();
      
      for(Konto konto : kontenDesKunden)
      {
        System.out.println("   Konto: " + konto.getKontoNr());
        System.out.println("   Kontostand: " + konto.getKontostand());
        
        gesamtguthaben = gesamtguthaben + konto.getKontostand();
      }      
    }
    
    System.out.println("Gesamtguthaben: " + gesamtguthaben);    
    System.out.println("--------------------------------------------------------------");

    gesGuthaben = gesamtguthaben;
  }


  public void berechneGesamtkredite()
  {
    System.out.println("");
    System.out.println("------------ Berechne Gesamtkredite -------------------------");
    
    double gesamtkredit = 0;
    double zurueckgez = 0;
    double differenz = 0;
    
    for(Kunde kunde : kundenDerBank)
    {
      System.out.println("Kunde: " + kunde.getVName());      
      List<Konto> kontenDesKunden = kunde.getKonten();
      
      for(Konto konto : kontenDesKunden)
      {
        System.out.println("   Konto: " + konto.getKontoNr());
        
        if (konto.getKreditGesBetrag() != 0.0)
        {
          gesamtkredit = gesamtkredit + konto.getKreditGesBetrag();
          differenz = differenz + konto.getKreditRestBetrag();
          double temp = konto.getKreditGesBetrag() - konto.getKreditRestBetrag();
          zurueckgez = zurueckgez + temp;
        }
        else
        {
          System.out.println("        ### hat KEINEN Kredit ###");
        }
      }// Ende Konto-Schleife      
    }// Ende Kunden-Schleife
    
    System.out.println("Gesamtkredite: " + gesKredite + "    ~ Geld zurueckgezahlt: " + 
                        zurueckgez + "   --> Differenz: " + differenz);    
    System.out.println("--------------------------------------------------------------");

    gesKredite = gesamtkredit;
  }

  
  // Setter + Getter
  public String getBankName() {
    return bankName;
  }
  public String getBlz() {
    return this.blz;
  }
  public void setBankName(String bankName) {
    this.bankName = bankName;
  }
  public void setBlz(String blz) {
    this.blz = blz;
  }
  public double getGesKredite() {
    return gesKredite;
  }
  public double getGesGuthaben() {
    return gesGuthaben;
  }
  public void setGesGuthaben(double gesGuthaben) {
    this.gesGuthaben = gesGuthaben;
  }
  public void setGesKredite(double gesKredite) {
    this.gesKredite = gesKredite;
  }
  public boolean isKreditBewilligt() {
    return kreditBewilligt;
  }
  public List<Kunde> getKundenDerBank() {
    return kundenDerBank;
  }   
  
  
  // --------------- K U N D E N ----------------  

  int result = 1001;   
  public int getNaechsteFreieKundennummer()
  {     
    if(this.getKundenDerBank().isEmpty()){
      System.out.println("Leere KundenListe --> 1001");
      result = 1001;
      return result;
    }    

    else{
      result = getHoechsteKundenNr();
      result++;
      System.out.println("\tkundennr: " + result);
      return result;
    }
    //return kundenDerBank.get(kundenDerBank.size()).getKundenNr() + 1;    
  }  

  public int getHoechsteKundenNr()
  {
    // liste kundenDerBank enthaelt noch keine kunden
    if (this.kundenDerBank.isEmpty())
    {
      return 1001;      
    }
    else    // liste kundenDerBank bereits gefuellt
    {
      int hoechsteKundenNr = 1000;
      for(Kunde k : this.getKundenDerBank())
      {
        if(k.getKundenNr() > hoechsteKundenNr)
        {       
          hoechsteKundenNr = k.getKundenNr();
        }
      }      
      return hoechsteKundenNr;
    }
  }
    
  public void kundenDerBankAktualisieren(Kunde kunde)
  {
    this.kundenDerBank.add(kunde);
  }
  
  // --------------- K O N T E N ----------------
  
  long res = 1000001;   
  public long getNaechsteFreieKontonummer()
  { 
    // Pruefung ob Konten vorhanden
    List<Konto> kontenDerBank = new ArrayList<Konto>();
    for (Kunde kun : this.getKundenDerBank())
    {
      if (!kun.getKonten().isEmpty())
      { for (Konto kon : kun.getKonten())
        { kontenDerBank.add(kon);  }    // hier null-PointerException
      }
    }
    
    if (kontenDerBank == null){
      System.out.println("Leere KontoListe --> 1000001");
      res = 1000001;
      return res;
    }    
    else{
      res = getHoechsteKontoNr();
      res++;
      System.out.println("\tkontonr: " + res);
      return res;
    }
  }

  public long getHoechsteKontoNr()
  {
    // Pruefung ob Konten vorhanden
    List<Konto> kontenDerBank = new ArrayList<Konto>();
    for (Kunde kun : this.getKundenDerBank())
    {
      if (!kun.getKonten().isEmpty())
      { for (Konto kon : kun.getKonten())
        { kontenDerBank.add(kon);  }
      }
    }
    
    // liste kontenDerBank enthaelt noch keine kunden
    if (kontenDerBank == null)
    {
      return 1000001;      
    }
    else    // liste kontenDerBank bereits gefuellt
    {
      long hoechsteKontoNr = 1000000;
      for(Konto k : kontenDerBank)
      {
        if(k.getKontoNr() > hoechsteKontoNr)
        { hoechsteKontoNr = k.getKontoNr();  }
      }      
      return hoechsteKontoNr;
    }
  }
    
//  public void kontenDerBankAktualisieren(Konto konto)
//  {
//    this.kontenDerBank.add(konto);
//    System.out.println("\n neues Konto der Bank hinzugefuegt.");
//    for (Konto k : kontenDerBank)
//    {
//      System.out.println("Konto: " + k.getKontoArt() + " " + k.getKontoNr() + 
//                         " in Liste d.Bank " + this.getBankName());
//    }
//  }
  
  public void geldEingezahlt (double betrag)
  {
    double geld = getGesGuthaben();
    geld += betrag;
    setGesGuthaben(geld);
  }
  
  public void geldAusgezahlt (double betrag)
  {
    double geld = getGesGuthaben();
    geld -= betrag;
    setGesGuthaben(geld);
  }  
  
  public boolean kontoLoeschen (Konto konto)
  {
    for (Kunde k : this.getKundenDerBank())
    { if (k.getKonten().contains(konto))
      {
        k.getKonten().remove(konto);
        return true;
      }      
    }
    return false;
  }
  
}// Ende class Bank


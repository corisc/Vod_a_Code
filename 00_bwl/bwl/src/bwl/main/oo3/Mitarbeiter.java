package bwl.main.oo3;

public class Mitarbeiter {
  
  public int        interneNummer;
  public String     vorname;
  public String     nachname;
  public double     gehalt;
  public String     abteilung;
  
  
  public Mitarbeiter(int interneNummer, String vorname, String nachname, double gehalt, String abteilung) {
    
    this.interneNummer = interneNummer;
    this.vorname = vorname;
    this.nachname = nachname;
    this.gehalt = gehalt;
    this.abteilung = abteilung;
  }
  
  public void gehaltErhoehen(int betrag){
    this.gehalt = this.gehalt + betrag;
  }
}


package bwl.oo.paket5;

public class Abgeordneter extends One{
  
  public Abgeordneter(String vorname, String nachname, int abgeordnetenNummer) {
    super();
    this.oneName1 = vorname;
    this.oneName2 = nachname;
    this.oneNumber1 = abgeordnetenNummer;
  }
  
  public String getVorname() {
    return this.oneName1;
  }

  public String getNachname() {
    return this.oneName2;
  }
  
  public int getAbgeordnetenNummer(){
    return this.oneNumber1;
  }
  
}


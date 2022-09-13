package bwl.oo.paket5;

public class Wahlleiter{
  private String vorname;
  private String nachname;
  
  
  public Wahlleiter(String vorname, String nachname) {
    this.vorname = vorname;
    this.nachname = nachname;
  }
  
  public String getVorname(){
    return this.vorname;
  }

  public String getNachname(){
    return this.nachname;
  }

}


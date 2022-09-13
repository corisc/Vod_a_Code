package com.pi;

public class Mitarbeiter {

  String vorname;
  String nachname;
  String unternehmen;
  
  public Mitarbeiter(String vorname, String nachname, String unternehmen) {
    this.nachname = nachname;
    this.vorname = vorname;
    this.unternehmen = unternehmen;
  }

  public String getVorname() {
    return vorname;
  }

  public String getNachname() {
    return nachname;
  }

  public String getUnternehmen() {
    return unternehmen;
  }
  
  
  
  

}


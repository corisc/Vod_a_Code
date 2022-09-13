package com.pi;

public class SA extends Mitarbeiter {

  private long terminEnablerFreigabe;
  
  public SA(String vorname, String nachname, String unternehmen) {
    super(vorname, nachname, unternehmen);
  }
  
  public void setTerminEnablerFreigabe(long currentTimeMillis){
    this.terminEnablerFreigabe = currentTimeMillis;
  }

  public long getTerminEnablerFreigabe() {
    return terminEnablerFreigabe;
  }

  
  
}


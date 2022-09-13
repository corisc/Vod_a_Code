package com.trainee;

public class DispoKonto extends Konto
{
  private Double kreditLimit;
  
  public DispoKonto(String kontoArt, long kontoNr)
  {
    super( kontoArt, kontoNr);  
  }

  public void setzeNeuesKreditLimit(Double meinNeuesKreditlimit)
  {
    this.kreditLimit = meinNeuesKreditlimit;
  }
}


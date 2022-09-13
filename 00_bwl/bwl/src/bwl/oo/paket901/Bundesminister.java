package bwl.oo.paket901;

public class Bundesminister {

    private String vorname;
    private String nachname;
    private String adresse;
    private Ministerium ministerium;
    
	public Bundesminister(String vorname, String nachname, String adresse) {
		this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.ministerium = ministerium;
  }

	
  public String liefereVorname() {
      return vorname;
  }
  
  public Ministerium liefereMinisterium() {
    return this.ministerium;
}


  public void setzeVorname(String vorname) {
      this.vorname = vorname;
  }

  public String liefereNachname() {
      return nachname;
  }

  public void setzeNachname(String nachname) {
      this.nachname = nachname;
  }

  public String liefereAdresse() {
      return adresse;
  }

  public Ministerium setzeMinisterium(Ministerium ministerium) {
    return this.ministerium = ministerium;
}

  
  public void setzeAdresse(String adresse) {
      this.adresse = adresse;
  }
  
  
  
  
  
 
  
}


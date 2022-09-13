package bwl.oo.paket9;

public class Minister {

	public String ressort;
    private String vorname;
    private String nachname;
    private String adresse;
    
	public Minister(String vorname, String nachname, String adresse, String ressort) {
		this.ressort = ressort;
		this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
   
  }

  public String liefereRessort() {
    return ressort;
  }

  public void setzeRessort(String ressort) {
    this.ressort = ressort;
  }
	
  public String liefereVorname() {
      return vorname;
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

  public void setzeAdresse(String adresse) {
      this.adresse = adresse;
  }
  
  
  
 
  
}


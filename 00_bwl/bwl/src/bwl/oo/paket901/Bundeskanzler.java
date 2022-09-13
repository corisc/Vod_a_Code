package bwl.oo.paket901;

public class Bundeskanzler{


	 private double amtszeit;
	 private String vorname;
	 private String nachname;
	 private String adresse;
	
	public Bundeskanzler(String vorname, String nachname, String adresse, double amtszeit) {
		this.amtszeit = amtszeit;     
		this.vorname = vorname;
		this.nachname = nachname;
        this.adresse = adresse;
	}

    public double liefereAmtszeit() {
      return amtszeit;
    }
  
    public void setzeAmtszeit(double amtszeit) {
      this.amtszeit = amtszeit;
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
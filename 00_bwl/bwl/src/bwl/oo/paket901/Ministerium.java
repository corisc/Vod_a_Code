package bwl.oo.paket901;

import java.util.ArrayList;

public class Ministerium {
	private String adresse;
	private Bundesminister leitenderMinister;
	   public String ressort;

	
  	public Ministerium(String adresse, Bundesminister leitenderMinister) {
      super();
      this.adresse = adresse;
      this.leitenderMinister = leitenderMinister;
    }
  	
  	public String liefereAdresse() {
      return adresse;
    }

    public void setzeAlleMitarbeiter(String name) {
      this.adresse = adresse;
    }
  	
    public Bundesminister liefereLeitenderMinister() {
      return leitenderMinister;
    }

    public void setzeLeitenderMinister(Bundesminister leitenderMinister) {
      this.leitenderMinister = leitenderMinister;
    }
    
    public String liefereRessort() {
      return ressort;
    }

    public void setzeRessort(String ressort) {
      this.ressort = ressort;
    }

    
}

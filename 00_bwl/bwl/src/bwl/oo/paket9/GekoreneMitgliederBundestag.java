package bwl.oo.paket9;

public class GekoreneMitgliederBundestag {

	private String berufung;
	private Partei partei;
	private String vorname;
    private String nachname;
    private String adresse;
    
	public GekoreneMitgliederBundestag(String vorname, String nachname, String adresse, String berufung, Partei partei) {
		this.berufung = berufung;
		this.partei = partei;
		this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
	}

    public Partei lieferePartei() {
      return partei;
    }
  
    public void setzePartei(Partei partei) {
      this.partei = partei;
    }

    public String liefereBerufung() {
      return berufung;
    }
  
    public void setzeBerufung(String berufung) {
      this.berufung = berufung;
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

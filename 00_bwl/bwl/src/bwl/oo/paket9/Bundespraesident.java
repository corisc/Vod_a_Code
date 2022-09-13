package bwl.oo.paket9;

public class Bundespraesident {
	
	
   private double amtszeit;
   private String vorname;
   private String nachname;
   private String adresse;
   
   public Bundespraesident(String vorname, String nachname, String adresse, double amtszeit) {
       this.amtszeit = amtszeit;     
       this.vorname = vorname;
       this.nachname = nachname;
       this.adresse = adresse;
   }
  
   public void gesetzGegenzeichnen(Gesetz g) {
     int i = (int) Math.random();
     boolean unterzeichnen = i<0.7;
     g.setzeBeschluss(unterzeichnen);
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

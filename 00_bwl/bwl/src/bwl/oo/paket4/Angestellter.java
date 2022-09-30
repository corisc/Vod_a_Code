package bwl.oo.paket4;

import bwl.oo.paket10.Company;
import bwl.oo.paket2.Mitarbeiter;
import bwl.oo.paket3.Vorlesung;
import bwl.oo.paket6.Filiale;
import bwl.oo.paket7.Buergermeister;

public class Angestellter {
  
  public String vorname;
  public String nachname;
  
  
  public Angestellter(String vorname, String nachname) {
    super();
    this.vorname = vorname;
    this.nachname = nachname;
  }
  public String urlaubBeantragen(){
    String oo = new String(vorname+nachname+ " hat Urlaub beantragt!");
    //System.out.println(vorname+nachname+ " hat Urlaub beantragt!");
    return oo;
  }
  public void setVorname(String vorname){
    this.vorname = vorname;
  }
  public String getVorname(){
    return vorname;
  }
  public void setNachname(){
    this.nachname = nachname;
  }
  public String getNachname(){
    return nachname;
  }

  public String arbeiten(){
    String ss = new String(vorname+nachname+ " ist am Arbeiten");
    //System.out.println(ss);
    return ss;
  }
  public String ortung(Filiale filiale){
    String sus = new String(vorname+nachname+" befindet sich in der Filiale: "+filiale.getStandort());
    return sus;
  }
  public String arbeitetBei(Company company){
    String suss = new String(vorname+nachname+"arbeitet bei der Firma: "+company.getName());
    return suss;
  }

}


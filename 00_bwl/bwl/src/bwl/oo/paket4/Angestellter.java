package bwl.oo.paket4;

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
}


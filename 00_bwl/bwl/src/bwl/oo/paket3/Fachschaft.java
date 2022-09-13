package bwl.oo.paket3;

import java.util.Vector;

import bwl.oo.paket2.Aufgabe;

public class Fachschaft {
  
  public String name;
  public Angestellter dekan;
  public Vector<Angestellter> professoren = new Vector<Angestellter>();
  public Vector<Vorlesung> vorlesungen = new Vector<Vorlesung>();

  
  public int liefereAnzahlProfessoren(){
    return professoren.size();
  }
  
  public Angestellter liefereProfessor(String nachname){
    if(nachname == null || nachname.length()<1){
      System.out.println("Es wurde nichts angegeben");
      return null;
    }
    for(Angestellter p : this.professoren){
      if(p.nachname.equalsIgnoreCase(nachname)){
        return p;
      }
    }   
    System.out.println("Den Namen: " + nachname + " in der Fachschaft: " + this.name + " gibt es nicht");
    return null;
  }

  public Angestellter liefereProfessor(int professorSortiertNachAnlage){
    if(professorSortiertNachAnlage<1){
      System.out.println("Es gibt keinen Professor mit der Nummer: " + professorSortiertNachAnlage);
      return null;
    }
    if(professorSortiertNachAnlage>this.professoren.size()){
      System.out.println("Es gibt keinen Professor mit der Nummer: " + professorSortiertNachAnlage);
      return null;
    }
    return professoren.get(professorSortiertNachAnlage-1);
  }

  
  public void fuegeVorlesungHinzu(Vorlesung vorlesung){
    this.vorlesungen.add(vorlesung);
  }

  public int liefereAnzahlVorlesungen(){
    return vorlesungen.size();
  }
  
  public Vorlesung liefereVorlesung(int vorlesungsNummerSortiertNachAnlage){
    if(vorlesungsNummerSortiertNachAnlage<1){
      System.out.println("Es gibt keine Vorlesung mit der Nummer: " + vorlesungsNummerSortiertNachAnlage);
      return null;
    }
    if(vorlesungsNummerSortiertNachAnlage>this.vorlesungen.size()){
      System.out.println("Es gibt keine Vorlesung mit der Nummer: " + vorlesungsNummerSortiertNachAnlage);
      return null;
    }
    return vorlesungen.get(vorlesungsNummerSortiertNachAnlage-1);
  }

  
  public Vorlesung liefereVorlesung(String titel){
    if(titel == null || titel.length()<1){
      System.out.println("Es wurde nichts angegeben");
      return null;
    }
    for(Vorlesung v : this.vorlesungen){
      if(v.titel.equalsIgnoreCase(titel)){
        return v;
      }
    }   
    System.out.println("Den Titel: " + titel + " fuer eine Vorlseung in der Fachschaft: " + this.name + " gibt es nicht");
    return null;
  }
  
  public void fuegeProfessorHinzu(Angestellter professor){
    this.professoren.add(professor);
  }

  
  public Fachschaft(String name, Angestellter dekan) {
    super();
    this.name = name;
    this.dekan = dekan;
  }


}


package bwl.oo.paket6;

import bwl.oo.paket2.Mitarbeiter;
import bwl.oo.paket2.Projekt;
import bwl.oo.paket8.Sparkonto;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse Besitzer ist eine untergeordnete Klasse von der Klasse Peson.
 * hat drei Eigenschaften(Anzahl der Filialen->private int filialen, Nachname und Vorname,
 *  die letzen beiden von Person geerbt werden).
 * */

public class Besitzer extends Person{

    private int filialen;

    private Sparkonto sparkonto;
    private List<Projekt> projekten = new ArrayList<>();

    private List<Mitarbeiter> mitarbeiters = new ArrayList<>();



    public Besitzer(String vorname, String nachname, Mitarbeiter mitarbeiter, Projekt projekt) {
        super(nachname, nachname);
        mitarbeiters.add(mitarbeiter);
        projekten.add(projekt);
    }

    public Sparkonto getSparkonto() {
        return sparkonto;
    }

    public void setSparkonto(Sparkonto sparkonto) {
        this.sparkonto = sparkonto;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getFilialen(){
        return filialen;
    }

    public void setFilialen(int fil){
        filialen = fil;
    }

    /**
     * Hilfsmethode addProjekt(Projekt projekt) fuegt einen Projekt in der List hinzu
     * */
    public void addProjekt(Projekt projekt){
        projekten.add(projekt);
    }

    /**
     * Hilfsmethode addMitarbeiter(Mitarbeiter mitarbeiter) fuegt einen Mitarbeiter in der List hinzu
     * */
    public void addMitarbeiter(Mitarbeiter mitarbeiter){
        mitarbeiters.add(mitarbeiter);
    }

    /**
     * Methode fuegeFilialeHinzu() erhöht die Anzaht von den Filialen, die Besitzer hat.
     * @return filialen
     * */

    public void fuegeFilialeHinzu(){
        filialen++;
    }

    /**
     * Hilfsmethode randomGenerate() generiert zufällige Zahlen und gibt die zurück
     * */
    public int randomGenerate(){
        int min = 50;
        int max = 100;

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }


    /**
     * Methode zinsSatzAendern() aendert den Zinssatz.
     * */

    public void zinsSatzAendern(int neuZinssatz){
       sparkonto.setZinssatz(neuZinssatz);
    }

    /**
     * Methode projekteZeigen() gibt die Projekten zurück, die Besitzer momentan hat.
     * @return
     */
    public String projekteZeigen(){
        String pr ="";

       for (Projekt projekt: projekten){
          pr += projekten.get(0).getTitel() + " ";
       }

       return pr;
    }

}

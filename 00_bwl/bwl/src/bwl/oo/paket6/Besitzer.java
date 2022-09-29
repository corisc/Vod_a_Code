package bwl.oo.paket6;

import bwl.oo.paket8.Sparkonto;
import com.trainee.Konto;

import java.util.List;

/**
 * Klasse Besitzer ist eine untergeordnete Klasse von der Klasse Peson.
 * hat drei Eigenschaften(Anzahl der Filialen->private int filialen, Nachname und Vorname,
 *  die letzen beiden von Person geerbt werden).
 * */

public class Besitzer extends Person{

    private int filialen;

    private Sparkonto sparkonto;

    public Besitzer(String vorname, String nachname) {
        super(nachname, nachname);
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
     * Methode fuegeFilialeHinzu() erhöht die Anzaht von den Filialen, die Besitzer hat.
     * @return filialen
     * */

    public void fuegeFilialeHinzu(){
        filialen++;
    }

    /**
     * Methode randomGenerate() generiert zufällige Zahlen und gibt die zurück
     * */
    public int randomGenerate(){
        int min = 50;
        int max = 100;

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    /**
     * Methode zinsSatzAendern() aendert den Zinssatz
     * */

    public void zinsSatzAendern(int neuZinssatz){
       sparkonto.setZinssatz(neuZinssatz);
    }

}

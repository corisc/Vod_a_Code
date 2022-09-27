package bwl.oo.paket6;
/**
 * Klasse Besitzer ist eine untergeordnete Klasse von der Klasse Peson.
 * hat drei Eigenschaften(Anzahl der Filialen->private int filialen, Nachname und Vorname,
 *  die letzen beiden von Person geerbt werden).
 * */

public class Besitzer extends Person{

    private int filialen;


    public Besitzer(String vorname, String nachname) {
        super(nachname, nachname);
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
     * */

    public void fuegeFilialeHinzu(){
        filialen++;
    }

}
